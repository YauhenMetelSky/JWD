package by.metelski.xmltask.builder;

import by.metelski.xmltask.entity.Medicine;
import by.metelski.xmltask.exception.CustomXMLParseException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class MedicinesDomBuilder extends AbstractMedicinesBuilder {
    private DocumentBuilder docBuilder;
    public static final Logger logger = LogManager.getLogger();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public MedicinesDomBuilder() {
        medicines = new HashSet<>();
        logger.log(Level.INFO, "new empty medicines list created");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.log(Level.ERROR, "caught exception: " + e);
        }
    }
    public MedicinesDomBuilder(Set<Medicine> medicines) {
        super(medicines);
    }
    @Override
    public void buildSetMedicines(String filename) throws CustomXMLParseException {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList medicinesList = root.getElementsByTagName("medicine");
            for (int i = 0; i < medicinesList.getLength(); i++) {
                Element medicineElement = (Element) medicinesList.item(i);
                Medicine medicine = buildMedicine(medicineElement);
                medicines.add(medicine);
                logger.log(Level.INFO, "medicine added to list");
            }
        } catch (IOException | SAXException e) {
            throw new CustomXMLParseException("Parser configuration exception or SAXExcetion ", e);
        }
    }
    private Medicine buildMedicine(Element medicineElement) {
        Medicine medicine = new Medicine();
        if (null != medicineElement) {
            Medicine.Version version;
            medicine.setGroup(medicineElement.getAttribute("group"));
            logger.log(Level.INFO, "group " + medicineElement.getAttribute("group") + "set");
            medicine.setId(medicineElement.getAttribute("id"));
            logger.log(Level.INFO, "id " + medicineElement.getAttribute("id") + "set");
            medicine.setName(getElementTextContext(medicineElement, "name"));
            logger.log(Level.INFO, "name " + getElementTextContext(medicineElement, "name") + "set");
            medicine.setPharmaceuticalCompany(getElementTextContext(medicineElement, "pharmaceutical-company"));
            logger.log(Level.INFO, "pharmaceutical company " + getElementTextContext(medicineElement, "pharmaceutical-company") + "set");

            NodeList nodeList = medicineElement.getElementsByTagName("version");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element versionElement = (Element) nodeList.item(i);
                version = medicine.new Version();
                version.setManufacturer(getElementTextContext(medicineElement, "manufacturer"));
                logger.log(Level.INFO, "manufacturer " + getElementTextContext(medicineElement, "manufacturer") + "set");
                version.setCertificate(buildCertificate(versionElement, version));
                version.setMedicinePackage(buildPackage(versionElement, version));
                version.setDosage(buildDosage(versionElement, version));
                medicine.addVersion(version);
                logger.log(Level.INFO, "new version added");
            }
            NodeList nListAnalogs = medicineElement.getElementsByTagName("analog");
            for (int i = 0; i < nListAnalogs.getLength(); i++) {
                medicine.addAnalog(nListAnalogs.item(i).getTextContent());
                logger.log(Level.INFO, "new analog \"" + nListAnalogs.item(i).getTextContent() + "\" added");
            }
        }
        return medicine;
    }
    private Medicine.Certificate buildCertificate(Element element, Medicine.Version version) {
        Medicine.Certificate certificate = version.getCertificate();
        certificate.setNumber(getElementTextContext(element, "number"));
        logger.log(Level.INFO, "number " + getElementTextContext(element, "number") + "set");
        certificate.setDateOfIssue(LocalDate.parse(getElementTextContext(element, "date-of-issue"), formatter));
        logger.log(Level.INFO, "date-of-issue " + getElementTextContext(element, "date-of-issue") + "set");
        certificate.setExpiryDate(LocalDate.parse(getElementTextContext(element, "expiry-date"), formatter));
        logger.log(Level.INFO, "expiry-date " + getElementTextContext(element, "expiry-date") + "set");
        certificate.setRegistrationOrganisation(getElementTextContext(element, "registration-organisation"));
        logger.log(Level.INFO, "registration-organisation " + getElementTextContext(element, "registration-organisation") + "set");
        return certificate;
    }
    private Medicine.MedicinePackage buildPackage(Element element, Medicine.Version version) {
        Medicine.MedicinePackage medicinePackage = version.getMedicinePackage();
        medicinePackage.setPackageType(getElementTextContext(element, "package-type"));
        logger.log(Level.INFO, "package-type " + getElementTextContext(element, "package-type") + "set");
        medicinePackage.setAmountInPackage(Integer.parseInt(getElementTextContext(element, "amount-in-package")));
        logger.log(Level.INFO, "amount-in-package " + getElementTextContext(element, "amount-in-package") + "set");
        medicinePackage.setPrice(Double.parseDouble(getElementTextContext(element, "price")));
        logger.log(Level.INFO, "price " + getElementTextContext(element, "price") + "set");
        return medicinePackage;
    }
    private Medicine.Dosage buildDosage(Element element, Medicine.Version version) {
        Medicine.Dosage dosage = version.getDosage();
        dosage.setDose(Integer.parseInt(getElementTextContext(element, "dose")));
        NodeList tagDosage = element.getElementsByTagName("dosage");
        Element tag = (Element) tagDosage.item(0);
        dosage.setFrequencyOfMedication(tag.getAttribute("frequency-of-medication"));
        logger.log(Level.INFO, "frequency-of-medication " + tag.getAttribute("frequency-of-medication")+ "set");
        return dosage;
    }
    private String getElementTextContext(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
