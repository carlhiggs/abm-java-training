package uk.cam.mrc.phm.homework.lectures.week13;


import com.sun.xml.txw2.output.IndentingXMLStreamWriter;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLWriterExample2 {
    public static void main(String[] args) {
        File file = new File ("scenarios/homework/week13/buildingIndented.xml");

        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(file));
            XMLStreamWriter writerIndenting = new IndentingXMLStreamWriter(writer);

            //write header
            writerIndenting.writeStartDocument("utf-8","1.0");

            writerIndenting.writeStartElement("building");
            writerIndenting.writeAttribute("name", "happy");
            writerIndenting.writeAttribute("year", "2014");

            writerIndenting.writeStartElement("households");
            writerIndenting.writeAttribute("Address", "xxxx");

            writerIndenting.writeStartElement("household");
            writerIndenting.writeAttribute("id", "1");

            writerIndenting.writeStartElement("persons");

            writerIndenting.writeStartElement("person");
            writerIndenting.writeAttribute("name", "aa");
            writerIndenting.writeAttribute("age", "30");
            writerIndenting.writeAttribute("nationality", "German");
            writerIndenting.writeEndElement();

            writerIndenting.writeEndElement();

            writerIndenting.writeEndElement();

            writerIndenting.writeStartElement("household");
            writerIndenting.writeAttribute("id", "2");
            writerIndenting.writeStartElement("persons");
            writerIndenting.writeStartElement("person");
            writerIndenting.writeAttribute("name", "bb");
            writerIndenting.writeAttribute("age", "22");
            writerIndenting.writeAttribute("nationality", "German");
            writerIndenting.writeEndElement();
            writerIndenting.writeStartElement("person");
            writerIndenting.writeAttribute("name", "cc");
            writerIndenting.writeAttribute("age", "24");
            writerIndenting.writeAttribute("nationality", "Dutch");
            writerIndenting.writeEndElement();
            writerIndenting.writeEndElement();
            writerIndenting.writeEndElement();


            writerIndenting.writeEndElement();

            writerIndenting.writeEndElement();

            writerIndenting.writeEndDocument();
            writerIndenting.close();

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
