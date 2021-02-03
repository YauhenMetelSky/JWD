package by.metelski.xmltask.builder;

import by.metelski.xmltask.entity.Medicine;
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

public class MedicinesSaxBuilder {
    public static final Logger logger = LogManager.getLogger();
    private Set<Medicine> medicines;
    private MedicineSaxHandler handler=new MedicineSaxHandler();
    private XMLReader reader;
    public MedicinesSaxBuilder(){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try{
            SAXParser saxParser=factory.newSAXParser();
            reader = saxParser.getXMLReader();
        }catch (ParserConfigurationException| SAXException e){
            e.printStackTrace();
        }
        reader.setContentHandler(handler);
    }
    public Set<Medicine> getMedicines(){
        logger.log(Level.INFO,"return list medicines" );
        return medicines;
    }
    public void buildSetMedicines(String fileName){
        try {
            reader.parse(fileName);
        }catch (IOException|SAXException e){
            e.printStackTrace();
        }
        medicines=handler.getMedicines();
        logger.log(Level.INFO,"build set medicines");
    }
}
