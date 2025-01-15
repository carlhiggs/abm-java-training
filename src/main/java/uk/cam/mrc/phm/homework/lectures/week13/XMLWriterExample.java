package uk.cam.mrc.phm.homework.lectures.week13;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLWriterExample {
    public static void main(String[] args) {
        File file = new File ("scenarios/homework/week13/buildingNoIndent.xml");

        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(file));

            //write header
            writer.writeStartDocument("utf-8","1.0");

            writer.writeStartElement("building");
            writer.writeAttribute("name", "happy");
            writer.writeAttribute("year", "2014");

            writer.writeStartElement("households");
            writer.writeAttribute("Address", "xxxx");

            writer.writeStartElement("household");
            writer.writeAttribute("id", "1");
            writer.writeStartElement("persons");
            writer.writeStartElement("person");
            writer.writeAttribute("name", "aa");
            writer.writeAttribute("age", "30");
            writer.writeAttribute("nationality", "German");
            writer.writeEndElement();
            writer.writeEndElement();
            writer.writeEndElement();

            writer.writeStartElement("household");
            writer.writeAttribute("id", "2");
            writer.writeStartElement("persons");
            writer.writeStartElement("person");
            writer.writeAttribute("name", "bb");
            writer.writeAttribute("age", "22");
            writer.writeAttribute("nationality", "German");
            writer.writeEndElement();
            writer.writeStartElement("person");
            writer.writeAttribute("name", "cc");
            writer.writeAttribute("age", "24");
            writer.writeAttribute("nationality", "Dutch");
            writer.writeEndElement();
            writer.writeEndElement();
            writer.writeEndElement();


            writer.writeEndElement();

            writer.writeEndElement();

            writer.writeEndDocument();
            writer.close();


        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
