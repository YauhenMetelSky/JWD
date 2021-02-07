package by.metelski.xmltask.builder;

import by.metelski.xmltask.entity.Medicine;
import by.metelski.xmltask.exception.CustomXMLParseException;
import by.metelski.xmltask.handler.MedicineXmlTag;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class MedicinesStaxBuilder extends AbstractMedicinesBuilder {
    public static final Logger logger = LogManager.getLogger();
    public static final String HYPHEN = "-";
    public static final String UNDERSCORE = "_";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private Set<Medicine> medicines;
    private XMLInputFactory inputFactory;

    public MedicinesStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        medicines = new HashSet<Medicine>();
        logger.log(Level.INFO, "medicines empty set created");
    }

    public MedicinesStaxBuilder(Set<Medicine> medicines) {
        super(medicines);
    }

    public Set<Medicine> getMedicines() {
        logger.log(Level.INFO, "medicines set returned");
        return medicines;
    }

    @Override
    public void buildSetMedicines(String filename) throws CustomXMLParseException {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream((new File(filename)))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    logger.log(Level.INFO, "founded start tag: " +name);
                    if (name.equals(MedicineXmlTag.MEDICINE.getValue())) {
                        Medicine medicine = buildMedicine(reader);
                        medicines.add(medicine);
                        logger.log(Level.INFO, "new medicine added to medicines set");
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            logger.log(Level.ERROR,"exception, invalid file: " +filename+"; "+e);
            throw new CustomXMLParseException("Parser configuration exception or SAXExcetion ",e);

        } catch (IOException e) {
            logger.log(Level.ERROR,"exception, invalid file: " +filename+"; "+e);
            throw new CustomXMLParseException("Parser configuration exception or SAXExcetion ",e);
        }
    }

    private Medicine buildMedicine(XMLStreamReader reader) throws XMLStreamException {
        Medicine medicine = new Medicine();
        medicine.setId(reader.getAttributeValue(null, MedicineXmlTag.ID.getValue()));
        medicine.setGroup(reader.getAttributeValue(null, MedicineXmlTag.GROUP.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineXmlTag.valueOf(name.toUpperCase().replaceAll(HYPHEN, UNDERSCORE))) {
                        case NAME:
                            medicine.setName(getXMLText(reader));
                            logger.log(Level.INFO,"name "+getXMLText(reader)+ " set");
                            break;
                        case PHARM:
                            medicine.setPharm(getXMLText(reader));
                            logger.log(Level.INFO,"pharm "+getXMLText(reader)+ " set");
                            break;
                        case ANALOG:
                            medicine.addAnalog(getXMLText(reader));
                            logger.log(Level.INFO,"analog "+getXMLText(reader)+ " added");
                            break;
                        case VERSION:
                            medicine.addVersion(buildVersion(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase().replaceAll(HYPHEN, UNDERSCORE)) == MedicineXmlTag.MEDICINE) {
                        logger.log(Level.INFO,"new medicine returned");
                        return medicine;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <medicine>");
    }

    private Medicine.Version buildVersion(XMLStreamReader reader) throws XMLStreamException {
        Medicine.Version version = new Medicine().new Version();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineXmlTag.valueOf(name.toUpperCase().replaceAll(HYPHEN, UNDERSCORE))) {
                        case MANUFACTURER:
                            version.setManufacturer(getXMLText(reader));
                            logger.log(Level.INFO,"manufacturer "+getXMLText(reader)+ " set");
                            break;
                        case CERTIFICATE:
                            version.setCertificate(buildCertificate(reader, version));
                            break;
                        case PACKAGE:
                            version.setMedicinePackage(buildMedicinePackage(reader, version));
                            break;
                        case DOSAGE:
                            version.setDosage(buildDosage(reader, version));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase().replaceAll(HYPHEN, UNDERSCORE)) == MedicineXmlTag.VERSION) {
                        return version;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <version>");
    }

    private Medicine.Certificate buildCertificate(XMLStreamReader reader, Medicine.Version version) throws XMLStreamException {
        Medicine.Certificate certificate = version.getCertificate();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineXmlTag.valueOf(name.toUpperCase().replaceAll(HYPHEN, UNDERSCORE))) {
                        case NUMBER:
                            certificate.setNumber(getXMLText(reader));
                            logger.log(Level.INFO,"number "+getXMLText(reader)+ " set");
                            break;
                        case DATE_OF_ISSUE:
                            certificate.setDateOfIssue(LocalDate.parse(getXMLText(reader), formatter));
                            logger.log(Level.INFO,"date-of-issue "+getXMLText(reader)+ " set");
                            break;
                        case EXPIRY_DATE:
                            certificate.setExpiryDate(LocalDate.parse(getXMLText(reader), formatter));
                            logger.log(Level.INFO,"expiry-date "+getXMLText(reader)+ " set");
                            break;
                        case REGISTRATION_ORGANISATION:
                            certificate.setRegistrationOrganisation(getXMLText(reader));
                            logger.log(Level.INFO,"registration-organisatio "+getXMLText(reader)+ " set");
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase().replaceAll(HYPHEN, UNDERSCORE)) == MedicineXmlTag.CERTIFICATE) {
                        return certificate;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <certificate>");
    }

    private Medicine.MedicinePackage buildMedicinePackage(XMLStreamReader reader, Medicine.Version version) throws XMLStreamException {
        Medicine.MedicinePackage medicinePackage = version.getMedicinePackage();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineXmlTag.valueOf(name.toUpperCase().replaceAll(HYPHEN, UNDERSCORE))) {
                        case PACKAGE_TYPE:
                            medicinePackage.setPackageType(getXMLText(reader));
                            logger.log(Level.INFO,"package-type "+getXMLText(reader)+ " set");
                            break;
                        case AMOUNT_IN_PACKAGE:
                            medicinePackage.setAmountInPackage(Integer.parseInt(getXMLText(reader)));
                            logger.log(Level.INFO,"amount-in-package "+getXMLText(reader)+ " set");
                            break;
                        case PRICE:
                            medicinePackage.setPrice(Double.parseDouble(getXMLText(reader)));
                            logger.log(Level.INFO,"price "+getXMLText(reader)+ " set");
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase().replaceAll(HYPHEN, UNDERSCORE)) == MedicineXmlTag.PACKAGE) {
                        return medicinePackage;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <package>");
    }

    private Medicine.Dosage buildDosage(XMLStreamReader reader, Medicine.Version version) throws XMLStreamException {
        Medicine.Dosage dosage = version.getDosage();
        int type;
        String name;
        dosage.setFrequencyOfMedication(reader.getAttributeValue(null, MedicineXmlTag.FREQUENCE_OF_MEDICATION.getValue()));
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineXmlTag.valueOf(name.toUpperCase().replaceAll(HYPHEN, UNDERSCORE))) {
                        case DOSE:
                            dosage.setDose(Integer.parseInt(getXMLText(reader)));
                            logger.log(Level.INFO,"dosage "+getXMLText(reader)+ " set");
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase().replaceAll(HYPHEN, UNDERSCORE)) == MedicineXmlTag.DOSAGE) {
                        return dosage;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <certificate>");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
