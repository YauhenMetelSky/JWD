package by.metelski.xmltask.builder;

import by.metelski.xmltask.entity.Medicine;
import by.metelski.xmltask.exception.CustomXMLParseException;
import by.metelski.xmltask.handler.MedicineSaxHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;
import org.apache.logging.log4j.Level;

public class MedicinesSaxBuilder extends AbstractMedicinesBuilder {
    public static final Logger logger = LogManager.getLogger();
    private Set<Medicine> medicines;
    private MedicineSaxHandler handler=new MedicineSaxHandler();
    private XMLReader reader;
    public MedicinesSaxBuilder() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try{
            SAXParser saxParser=factory.newSAXParser();
            reader = saxParser.getXMLReader();
        }catch (ParserConfigurationException| SAXException e){
            logger.log(Level.ERROR,"caught exception: "+e);
        }
        reader.setContentHandler(handler);
    }
    public MedicinesSaxBuilder(Set<Medicine> medicines){
        super(medicines);
    }
    public Set<Medicine> getMedicines(){
        logger.log(Level.INFO,"return list medicines" );
        return medicines;
    }
    @Override
    public void buildSetMedicines(String filename) throws CustomXMLParseException {
        try {
            reader.parse(filename);
        }catch (IOException|SAXException e){
            throw new CustomXMLParseException("Parser configuration exception or SAXExcetion ",e);
        }
        medicines=handler.getMedicines();
        logger.log(Level.INFO,"built set medicines");
    }
}
