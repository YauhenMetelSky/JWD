package by.metelski.xmltask.validation;

import by.metelski.xmltask.exception.CustomXMLParseException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class CustomXMLValidator {
    public static final Logger logger = LogManager.getLogger();

    public static boolean isXMLValid(String fileName, String schemaName){
        boolean isValid;
        if(fileName==null||schemaName==null){
            return false;
        }
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory= SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try{
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source=new StreamSource(fileName);
            validator.validate(source);
            isValid = true;
        }catch (SAXException| IOException e){
            logger.log(Level.ERROR,"XML document " + fileName + "or xsd schema "+ schemaName +"is not correct or valid");
            isValid=false;
        }
        logger.log(Level.INFO,"XML document: "+ fileName +"-is valid, schema: " + schemaName);
        return isValid;
    }

}
