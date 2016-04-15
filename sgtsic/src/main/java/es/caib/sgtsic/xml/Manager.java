/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.caib.sgtsic.xml;

import java.io.ByteArrayOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author gdeignacio
 * @param <T>
 */
public abstract class Manager<T> {
    
    private final Class<T> itemClass;
    
    public Manager(Class<T> itemClass) {
        this.itemClass = itemClass;
    }
    
    public byte[] generate(T item) throws JAXBException{
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
        
        JAXBContext jaxbContext = JAXBContext.newInstance(itemClass);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(item, baos);
        
        return baos.toByteArray();
        
    }
    
    
    
}
