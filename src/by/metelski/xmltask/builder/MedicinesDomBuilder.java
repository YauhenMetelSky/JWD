package by.metelski.xmltask.builder;

import by.metelski.xmltask.entity.Medicine;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class MedicinesDomBuilder extends AbstractMedicinesBuilder{
    private Set<Medicine> medicines;
    private DocumentBuilder docBuilder;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public MedicinesDomBuilder(){
        medicines=new HashSet<Medicine>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e){
            //log
        }
    }
    public MedicinesDomBuilder(Set<Medicine> medicines){
        super(medicines);
    }
    public Set<Medicine> getMedicines(){

        return medicines;
    }
    @Override
    public void buildSetMedicines(String filename){
        Document doc;
        try{
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList medicinesList = root.getElementsByTagName("medicine");
            for (int i = 0; i <medicinesList.getLength() ; i++) {
                Element medicineElement = (Element)medicinesList.item(i);
                Medicine medicine = buildMedicine(medicineElement);
                medicines.add(medicine);
            }
        }catch (IOException| SAXException e){
            //log
        }
    }
    private Medicine buildMedicine(Element medicineElement){
        Medicine medicine = new Medicine();
        if(null!=medicineElement) {
            Medicine.Version version;
            medicine.setGroup(medicineElement.getAttribute("group"));
            medicine.setId(medicineElement.getAttribute("id"));
            medicine.setName(getElementTextContext(medicineElement,"name"));
            medicine.setPharm(getElementTextContext(medicineElement,"pharm"));

            NodeList nodeList=medicineElement.getElementsByTagName("version");
            for (int i = 0; i <nodeList.getLength() ; i++) {
                Element versionElement =(Element) nodeList.item(i);
                version=medicine.new Version();
                version.setManufacturer(getElementTextContext(medicineElement,"manufacturer"));
                version.setCertificate(buildCertificate(versionElement,version));
                version.setMedicinePackage(buildPackage(versionElement,version));
                version.setDosage(buildDosage(versionElement,version));
                medicine.addVersion(version);
            }
            NodeList nListAnalogs = medicineElement.getElementsByTagName("analog");
            for (int i = 0; i <nListAnalogs.getLength() ; i++) {
                medicine.addAnalog(nListAnalogs.item(i).getTextContent());

            }
        }
           return medicine;// change for sure!!!!!
    }

    private Medicine.Certificate buildCertificate(Element element, Medicine.Version version){
        Medicine.Certificate certificate = version.getCertificate();
        certificate.setNumber(getElementTextContext(element,"number"));
        certificate.setDateOfIssue(LocalDate.parse(getElementTextContext(element,"date-of-issue"),formatter));
        certificate.setExpiryDate(LocalDate.parse(getElementTextContext(element,"expiry-date"),formatter));
        certificate.setRegistrationOrganisation(getElementTextContext(element,"registration-organisation"));
        return certificate;
    }
    private Medicine.MedicinePackage buildPackage(Element element, Medicine.Version version){
        Medicine.MedicinePackage medicinePackage = version.getMedicinePackage();
        medicinePackage.setPackageType(getElementTextContext(element,"package-type"));
        medicinePackage.setAmountInPackage(Integer.parseInt(getElementTextContext(element,"amount-in-package")));
        medicinePackage.setPrice(Double.parseDouble(getElementTextContext(element,"price")));
        return medicinePackage;
    }
    private Medicine.Dosage buildDosage(Element element,Medicine.Version version){
        Medicine.Dosage dosage = version.getDosage();
        dosage.setDose(Integer.parseInt(getElementTextContext(element,"dose")));
        NodeList tagDosage = element.getElementsByTagName("dosage");
        Element tag = (Element) tagDosage.item(0);
        dosage.setFrequencyOfMedication(tag.getAttribute("frequency-of-medication"));
        return dosage;
    }
    private String getElementTextContext(Element element, String elementName){
NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

}
