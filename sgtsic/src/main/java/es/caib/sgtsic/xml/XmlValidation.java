/*
 * Copyright 2016 gdeignacio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.caib.sgtsic.xml;

/**
 *
 * @author gdeignacio
 */

import es.caib.sgtsic.util.DataHandlers;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.activation.DataHandler;
 
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
 
import org.xml.sax.SAXException;
 
public class XmlValidation {
 
    public static boolean validateXMLSchema(DataHandler xsd, DataHandler xml){
         
        try {
            SchemaFactory factory = 
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            
            InputStream xsdIs = new ByteArrayInputStream(DataHandlers.dataHandlerToByteArray(xsd));
            Source xsdSource = new StreamSource(xsdIs);
            Schema schema = factory.newSchema(xsdSource);
            
            Validator validator = schema.newValidator();
            
            InputStream xmlIs = new ByteArrayInputStream(DataHandlers.dataHandlerToByteArray(xml));
            Source xmlSource = new StreamSource(xmlIs);
            
            validator.validate(xmlSource);
            
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }
}
