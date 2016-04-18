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

import es.caib.sgtsic.mail.ByteArrayDataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.activation.DataHandler;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

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

    private ByteArrayOutputStream marshal(T item) throws JAXBException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        jaxbMarshaller.marshal(item, baos);

        return baos;
    }

    private T unmarshal(InputStream is) throws JAXBException {

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (T) jaxbUnmarshaller.unmarshal(new StreamSource(is), clazz);

    }

    public DataHandler generateXml(T item) throws JAXBException {

        ByteArrayDataSource bads = new ByteArrayDataSource();

        bads.setContentType("application/xml");
        bads.setBytes(marshal(item).toByteArray());

        return new DataHandler(bads);

    }
    
    public DataHandler generateXml(List<T> items) throws JAXBException{
        
        ByteArrayDataSource bads = new ByteArrayDataSource();

        bads.setContentType("text/plain");
        
        byte[] b = generateXmlString(items).getBytes();
        
        bads.setBytes(b);

        return new DataHandler(bads);
        
    }
    
  
    public T generateItem(DataHandler document) throws JAXBException, IOException {
        return unmarshal(document.getInputStream());
    }

    public byte[] generateXmlByteArray(T item) throws JAXBException {

        return marshal(item).toByteArray();

    }

    public String generateXmlString(T item) throws JAXBException {

        return marshal(item).toString();

    }
    
    public String generateXmlString(List<T> items) throws JAXBException{
        
        StringBuilder mensajes = new StringBuilder();
        for (T item : items) {
            mensajes.append(generateXmlString(item));
        }
        return mensajes.toString();
        
    }

}
