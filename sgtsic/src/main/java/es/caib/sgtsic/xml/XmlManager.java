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

import es.caib.sgtsic.io.ByteArrayDataSource;
import es.caib.sgtsic.util.DataHandlers;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author gdeignacio
 * @param <T>
 */
public abstract class XmlManager<T> {

    private final Class<T> clazz;

    private final JAXBContext jaxbContext;

    public XmlManager(Class<T> clazz) throws JAXBException {
        
        this.clazz = clazz;
        this.jaxbContext = JAXBContext.newInstance(clazz);
    }

    public JAXBContext getContext() {
        return this.jaxbContext;
    }

    private ByteArrayOutputStream marshal(T item, DataHandler xsd) throws JAXBException {
        
        return marshal(item, xsd, Boolean.TRUE);

    }
    
     private ByteArrayOutputStream marshal(T item, DataHandler xsd, boolean formattedOutput) throws JAXBException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formattedOutput);
        
        SchemaFactory factory = 
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        
         if (xsd != null) {
             InputStream xsdIs;
             Source xsdSource;
             Schema schema;
             try {
                 xsdIs = new ByteArrayInputStream(DataHandlers.dataHandlerToByteArray(xsd));
                 xsdSource = new StreamSource(xsdIs);
                 schema = factory.newSchema(xsdSource);
                 jaxbMarshaller.setSchema(schema);
                 jaxbMarshaller.setEventHandler(new XmlValidationEventHandler());
             } catch (IOException | SAXException ex) {
                 Logger.getLogger(XmlManager.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
        
        
        jaxbMarshaller.marshal(item, baos);

        return baos;
    }

    private T unmarshal(InputStream is) throws JAXBException {

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (T) jaxbUnmarshaller.unmarshal(new StreamSource(is), clazz);

    }

    public DataHandler generateXml(T item, DataHandler xsd) throws JAXBException {

        ByteArrayDataSource bads = new ByteArrayDataSource();

        bads.setContentType("application/xml");
        bads.setBytes(marshal(item, xsd).toByteArray());

        return new DataHandler(bads);

    }
    
    public DataHandler generateXml(List<T> items, DataHandler xsd) throws JAXBException{
        
        ByteArrayDataSource bads = new ByteArrayDataSource();

        bads.setContentType("text/plain");
        
        byte[] b = generateXmlString(items, xsd).getBytes();
        
        bads.setBytes(b);

        return new DataHandler(bads);
        
    }
    
    public DataHandler generateFlatXml(List<T> items, DataHandler xsd) throws JAXBException{
        
        ByteArrayDataSource bads = new ByteArrayDataSource();

        bads.setContentType("text/plain");
        
        byte[] b = generateFlatXmlString(items, xsd).getBytes();
        
        bads.setBytes(b);

        return new DataHandler(bads);
        
    }
    
  
    public T generateItem(DataHandler document) throws JAXBException, IOException {
        return unmarshal(document.getInputStream());
    }

    public byte[] generateXmlByteArray(T item, DataHandler xsd) throws JAXBException {

        return marshal(item,xsd).toByteArray();

    }

    
    public String generateFlatXmlString(T item, DataHandler xsd) throws JAXBException {
        
        return marshal(item, xsd, Boolean.FALSE).toString();

    }
    
    public String generateFlatXmlString(List<T> items, DataHandler xsd) throws JAXBException{
        
        StringBuilder mensajes = new StringBuilder();
        for (T item : items) {
            mensajes.append(generateFlatXmlString(item, xsd));
            mensajes.append("\n");
        }
        return mensajes.toString();
        
    }
    
    
    
    public String generateXmlString(T item, DataHandler xsd) throws JAXBException {

        return marshal(item, xsd).toString();

    }
    
    public String generateXmlString(List<T> items, DataHandler xsd) throws JAXBException{
        
        StringBuilder mensajes = new StringBuilder();
        for (T item : items) {
            mensajes.append(generateXmlString(item, xsd));
        }
        return mensajes.toString();
        
    }

}
