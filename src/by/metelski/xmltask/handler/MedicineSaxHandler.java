package by.metelski.xmltask.handler;

import by.metelski.xmltask.entity.Medicine;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class MedicineSaxHandler extends DefaultHandler {
    private Set<Medicine> medicines;
    private Medicine current;
    private Medicine.Version currentVersion;
    private MedicineXmlTag currentXmlTag;
    private EnumSet<MedicineXmlTag> withText;
    public static final Logger logger = LogManager.getLogger();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public MedicineSaxHandler(){
        medicines=new HashSet<>();
        withText=EnumSet.range(MedicineXmlTag.NAME,MedicineXmlTag.DOSE);
    }
    public Set<Medicine> getMedicines() {
        return medicines;
    }
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        logger.log(Level.INFO,"start element: " + qName);
        if(MedicineXmlTag.MEDICINE.getValue().equals(qName)) {
            current = new Medicine();
            logger.log(Level.INFO, "new medicine created");
            for (int i = 0; i < attributes.getLength(); i++) {
                switch (attributes.getQName(i)) {
                    case "group":
                        current.setGroup(attributes.getValue(i));
                        logger.log(Level.INFO, "set group: " + attributes.getValue(i));
                        break;
                    case "id":
                        current.setId(attributes.getValue(i));
                        logger.log(Level.INFO, "set id: " + attributes.getValue(i));
                        break;
                }
            }
        }if(MedicineXmlTag.VERSION.getValue().equals(qName)) {
            currentVersion = current.new Version();
        }if(MedicineXmlTag.DOSAGE.getValue().equals(qName)){
            for (int i = 0; i <attributes.getLength() ; i++) {
                currentVersion.getDosage().setFrequencyOfMedication(attributes.getValue(0));
                logger.log(Level.INFO, current.getName()+": set frequency of medication : " + attributes.getValue(0));
            }
        }
        else {
            MedicineXmlTag temp = MedicineXmlTag.valueOf(qName.toUpperCase().replaceAll("-","_"));
            if(withText.contains(temp)){
                currentXmlTag = temp;
            }
        }
    }
    public void characters(char[] ch, int start, int length) {
    String data = new String(ch,start,length).strip();
    logger.log(Level.INFO,"read data: "+ data);
    if(currentXmlTag!=null){
            switch (currentXmlTag){
            case NAME:
                current.setName(data);
                logger.log(Level.INFO,current.getName()+": set name: "+ data);
                break;
            case PHARMACEUTICAL_COMPANY:
                current.setPharmaceuticalCompany(data);
                logger.log(Level.INFO,current.getName()+": set pharmaceutical company: "+ data);
                break;
            case MANUFACTURER:
                currentVersion.setManufacturer(data);
                logger.log(Level.INFO,current.getName()+": set manufacturer: "+ data);
                break;
            case ANALOG:
                current.addAnalog(data);
                logger.log(Level.INFO,current.getName()+": added analog: "+ data);
                break;
            case NUMBER:
                currentVersion.getCertificate().setNumber(data);
                logger.log(Level.INFO,current.getName()+": set certificate number: "+ data);
                break;
            case DATE_OF_ISSUE:
                currentVersion.getCertificate().setDateOfIssue(LocalDate.parse(data,formatter));
                logger.log(Level.INFO,current.getName()+": set date of issue: "+ data);
                break;
            case EXPIRY_DATE:
                currentVersion.getCertificate().setExpiryDate(LocalDate.parse(data,formatter));
                logger.log(Level.INFO,current.getName()+": set expiry date: "+ data);
                break;
            case REGISTRATION_ORGANISATION:
                currentVersion.getCertificate().setRegistrationOrganisation(data);
                logger.log(Level.INFO,current.getName()+": set registration organisation: "+ data);
                break;
            case PACKAGE_TYPE:
                currentVersion.getMedicinePackage().setPackageType(data);
                logger.log(Level.INFO,current.getName()+": set package type: "+ data);
                break;
            case AMOUNT_IN_PACKAGE:
                currentVersion.getMedicinePackage().setAmountInPackage(Integer.parseInt(data));
                logger.log(Level.INFO,current.getName()+": set amount in package: "+ data);
                break;
            case PRICE:
                currentVersion.getMedicinePackage().setPrice(Double.parseDouble(data));
                logger.log(Level.INFO,current.getName()+": set price: "+ data);
                break;
                case DOSE:
                    currentVersion.getDosage().setDose(Integer.parseInt(data));
                    logger.log(Level.INFO,current.getName()+": set dose: "+ data);
                    break;
            default:
                throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(),currentXmlTag.name());
        }
    }
    currentXmlTag=null;
    }
    public void endElement(String uri, String localName, String qName) {
        logger.log(Level.INFO,current.getName()+": end element: " + qName);
        if(MedicineXmlTag.MEDICINE.getValue().equals(qName)){
           medicines.add(current);
       }
             if(MedicineXmlTag.VERSION.getValue().equals(qName)){
           current.addVersion(currentVersion);
       }
    }
}
