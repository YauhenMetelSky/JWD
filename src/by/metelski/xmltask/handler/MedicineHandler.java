package by.metelski.xmltask.handler;

import by.metelski.xmltask.entity.Medicine;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class MedicineHandler extends DefaultHandler {
    private Set<Medicine> medicines;
    private Medicine current;
    private MedicineXmlTag currentXmlTag;
    private EnumSet<MedicineXmlTag> withText;
    private static final String ELEMENT_MEDICINE="medicine";
    private static final String ELEMENT_DOSAGE="dosage";
    private static final String ELEMENT_VERSION="version";
    public static final Logger logger = LogManager.getLogger();

    public MedicineHandler(){
        medicines=new HashSet<Medicine>();
        withText=EnumSet.range(MedicineXmlTag.NAME,MedicineXmlTag.PRICE);
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        logger.log(Level.INFO,"start element: " + qName);
        if(ELEMENT_MEDICINE.equals(qName)){
            current = new Medicine();
            logger.log(Level.INFO,"new medicine created");
            for (int i = 0; i <attributes.getLength() ; i++) {
                switch (attributes.getQName(i)){
                    case "group":
                        current.setGroup(attributes.getValue(i));
                        logger.log(Level.INFO,"setted group: "+ attributes.getValue(i));
                        break;
                    case "id":
                        current.setId(attributes.getValue(i));
                        logger.log(Level.INFO,"setted id: "+ attributes.getValue(i));
                        break;
                }
            }

        } if(ELEMENT_DOSAGE.equals(qName)){
                current.getVersion().getDosage().setFrequencyOfMedication(attributes.getValue(0));
                logger.log(Level.INFO,"setted frequency of medication : "+ attributes.getValue(0));

        }else {
            MedicineXmlTag temp = MedicineXmlTag.valueOf(qName.toUpperCase().replaceAll("-","_"));
            if(withText.contains(temp)){
                currentXmlTag = temp;
            }
        }
    }
    public void characters(char[] ch, int start, int length) {
    String data = new String(ch,start,length).strip();
    logger.log(Level.INFO,"readed data: "+ data);
    if(currentXmlTag!=null){
            switch (currentXmlTag){
            case NAME:
                current.setName(data);
                logger.log(Level.INFO,"setted name: "+ data);
                break;
            case PHARM:
                current.setPharm(data);
                logger.log(Level.INFO,"setted pharm: "+ data);
                break;
            case MANUFACTURER:
                current.getVersion().setManufacturer(data);
                logger.log(Level.INFO,"setted manufacturer: "+ data);
                break;
            case ANALOG:
                current.addAnalog(data);
                logger.log(Level.INFO,"added analog: "+ data);
                break;
            case NUMBER:
                current.getVersion().getCertificate().setNumber(data);
                logger.log(Level.INFO,"setted certificate number: "+ data);
                break;
            case DATE_OF_ISSUE:
                current.getVersion().getCertificate().setDateOfIssue(data);
                logger.log(Level.INFO,"setted date of issue: "+ data);
                break;
            case EXPIRY_DATE:
                current.getVersion().getCertificate().setExpiryDate(data);
                logger.log(Level.INFO,"setted expiry date: "+ data);
                break;
            case REGISTRATION_ORGANISATION:
                current.getVersion().getCertificate().setRegistrationOrganisation(data);
                logger.log(Level.INFO,"setted registration organisation: "+ data);
                break;
            case PACKAGE_TYPE:
                current.getVersion().getMedicinePackage().setPackageType(data);
                logger.log(Level.INFO,"setted package type: "+ data);
                break;
            case AMOUNT_IN_PACKAGE:
                current.getVersion().getMedicinePackage().setAmountInPackage(Integer.parseInt(data));
                logger.log(Level.INFO,"setted amount in package: "+ data);
                break;
            case PRICE:
                current.getVersion().getMedicinePackage().setPrice(Double.parseDouble(data));
                logger.log(Level.INFO,"setted price: "+ data);
                break;
            default:
                throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(),currentXmlTag.name());
        }
    }
    currentXmlTag=null;
    }
    public void endElement(String uri, String localName, String qName) {
        logger.log(Level.INFO,"end element: " + qName);
       if(ELEMENT_MEDICINE.equals(qName)){
           medicines.add(current);
       }
       if(ELEMENT_VERSION.equals(qName)){
           current.getVersions().add(current.getVersion());
       }
    }
}
