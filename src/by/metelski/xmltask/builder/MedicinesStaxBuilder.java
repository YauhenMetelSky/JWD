package by.metelski.xmltask.builder;

import by.metelski.xmltask.entity.Medicine;
import by.metelski.xmltask.handler.MedicineXmlTag;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MedicinesStaxBuilder extends AbstractMedicinesBuilder {
    private Set<Medicine> medicines;
    private XMLInputFactory inputFactory;
    public MedicinesStaxBuilder(){
        inputFactory=XMLInputFactory.newInstance();
        medicines=new HashSet<Medicine>();
    }
    public MedicinesStaxBuilder(Set<Medicine> medicines){
    super(medicines);
    }
    public Set<Medicine> getMedicines(){
        return medicines;
    }
    @Override
    public void buildSetMedicines(String filename){
        XMLStreamReader reader;
        String name;
        try(FileInputStream inputStream=new FileInputStream((new File(filename)))){
            reader=inputFactory.createXMLStreamReader(inputStream);
            while(reader.hasNext()){
                int type=reader.next();
                if(type== XMLStreamConstants.START_ELEMENT){
                    name=reader.getLocalName();
                    if(name.equals(MedicineXmlTag.MEDICINE.getValue())){
                        Medicine medicine=buildMedicine(reader);
                        medicines.add(medicine);
                    }
                }
            }

        }catch (XMLStreamException| FileNotFoundException e){

        }catch (IOException e){

        }

    }
    private Medicine buildMedicine(XMLStreamReader reader) throws XMLStreamException{
        Medicine medicine = new Medicine();
        medicine.setId(reader.getAttributeValue(null, MedicineXmlTag.ID.getValue()));
        medicine.setGroup(reader.getAttributeValue(null,MedicineXmlTag.GROUP.getValue()));
        String name;
        while (reader.hasNext()){
            int type=reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch(MedicineXmlTag.valueOf(name.toUpperCase().replaceAll("-","_"))){
                        case NAME:
                            medicine.setName(getXMLText(reader));
                            break;
                        case PHARM:
                            medicine.setPharm(getXMLText(reader));
                            break;
                        case ANALOG:
                            medicine.addAnalog(getXMLText(reader));
                            break;
                        case VERSION:
                            medicine.addVersion(buildVersion(reader));
                    }
                    break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if(MedicineXmlTag.valueOf(name.toUpperCase().replaceAll("-","_"))==MedicineXmlTag.MEDICINE){
                            return medicine;
                        }
            }
        }
        throw new XMLStreamException("Unknown element in tag <medicine>");
    }
    private Medicine.Version buildVersion(XMLStreamReader reader) throws XMLStreamException{
        Medicine.Version version=new Medicine().new Version();
        int type;
        String name;
        while (reader.hasNext()){
            type=reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineXmlTag.valueOf(name.toUpperCase().replaceAll("-","_"))){
                        case MANUFACTURER:
                            version.setManufacturer(getXMLText(reader));
                            break;
                        case CERTIFICATE:
                            version.setCertificate(buildCertificate(reader,version));
                            break;
                        case PACKAGE:
                            version.setMedicinePackage(buildMedicinePackage(reader,version));
                            break;
                        case DOSAGE:
                            version.setDosage(buildDosage(reader,version));
                            break;
                    }
                    break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if(MedicineXmlTag.valueOf(name.toUpperCase().replaceAll("-","_"))==MedicineXmlTag.VERSION){
                            return version;
                        }
            }
        }
        throw new XMLStreamException("Unknown element in tag <version>");
    }
    private Medicine.Certificate buildCertificate(XMLStreamReader reader,Medicine.Version version) throws XMLStreamException{
        Medicine.Certificate certificate = version.getCertificate();
        int type;
        String name;
        while (reader.hasNext()){
            type=reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineXmlTag.valueOf(name.toUpperCase().replaceAll("-","_"))){
                        case NUMBER:
                            certificate.setNumber(getXMLText(reader));
                            break;
                        case DATE_OF_ISSUE:
                            certificate.setDateOfIssue(getXMLText(reader));
                            break;
                        case EXPIRY_DATE:
                            certificate.setExpiryDate(getXMLText(reader));
                            break;
                        case REGISTRATION_ORGANISATION:
                            certificate.setRegistrationOrganisation(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if(MedicineXmlTag.valueOf(name.toUpperCase().replaceAll("-","_"))==MedicineXmlTag.CERTIFICATE){
                        return certificate;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <certificate>");

    }
    private Medicine.MedicinePackage buildMedicinePackage(XMLStreamReader reader, Medicine.Version version) throws XMLStreamException{
        Medicine.MedicinePackage medicinePackage= version.getMedicinePackage();
        int type;
        String name;
        while (reader.hasNext()){
            type=reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineXmlTag.valueOf(name.toUpperCase().replaceAll("-","_"))){
                        case PACKAGE_TYPE:
                            medicinePackage.setPackageType(getXMLText(reader));
                            break;
                        case AMOUNT_IN_PACKAGE:
                            medicinePackage.setAmountInPackage(Integer.parseInt(getXMLText(reader)));
                            break;
                        case PRICE:
                            medicinePackage.setPrice(Double.parseDouble(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if(MedicineXmlTag.valueOf(name.toUpperCase().replaceAll("-","_"))==MedicineXmlTag.PACKAGE){
                        return medicinePackage;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <package>");
    }
    private Medicine.Dosage buildDosage(XMLStreamReader reader,Medicine.Version version) throws XMLStreamException{
        Medicine.Dosage dosage = version.getDosage();
        int type;
        String name;
        dosage.setFrequencyOfMedication(reader.getAttributeValue(null,MedicineXmlTag.FREQUENCE_OF_MEDICATION.getValue()));
        while (reader.hasNext()){
            type=reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();

                    switch (MedicineXmlTag.valueOf(name.toUpperCase().replaceAll("-","_"))){
                        case DOSE:
                            dosage.setDose(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if(MedicineXmlTag.valueOf(name.toUpperCase().replaceAll("-","_"))==MedicineXmlTag.DOSAGE){
                        return dosage;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <certificate>");
    }
    private String getXMLText(XMLStreamReader reader) throws XMLStreamException{
        String text=null;
        if(reader.hasNext()){
            reader.next();
            text=reader.getText();
        }
        return text;
    }
}
