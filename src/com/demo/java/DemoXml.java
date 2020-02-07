package com.demo.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


public class DemoXml {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException
    {

        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(
                    new FileInputStream("/home/logan/Datasets/xml_in/add.PER.20191100050000137260000000002_R.xml")
            );
            while (xmlStreamReader.hasNext()) {
                int eventType = xmlStreamReader.getEventType();
                switch (eventType){
                    case XMLEvent.START_DOCUMENT:
                        System.out.println("---------------------Start document-----------");
                        break;
                    case XMLEvent.START_ELEMENT:
                        System.out.println("Start element: " + xmlStreamReader.getName());
                        if (xmlStreamReader.getAttributeCount() > 0 ){
                            System.out.println("\tAttributes: " + xmlStreamReader.getAttributeCount());
                            for(int i=0; i < xmlStreamReader.getAttributeCount(); i++){
                                System.out.println("\t "+ xmlStreamReader.getAttributeName(i));
                            }
                        }
                        break;
                    case XMLEvent.END_ELEMENT:
                        System.out.println("************ End element *****************");
                        break;
                    case XMLEvent.CHARACTERS:
                        System.out.println("CHARACTER: " + xmlStreamReader.getText());
                        break;

                }
                xmlStreamReader.next();

            }
            if (xmlStreamReader.getEventType() == XMLEvent.END_DOCUMENT){
                System.out.println("End Document: ");
            }

        } catch (Exception e){
            System.out.println(e.getMessage());

        }

    }


}

