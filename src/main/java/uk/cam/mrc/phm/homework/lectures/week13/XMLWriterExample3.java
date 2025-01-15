package uk.cam.mrc.phm.homework.lectures.week13;


import com.sun.xml.txw2.output.IndentingXMLStreamWriter;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLWriterExample3 {
    public static void main(String[] args) {

        Household[] households = {
                new Household(1, new Person[]{
                        new Person("aa", 30, "German")
                }),
                new Household(2, new Person[]{
                        new Person("bb", 22, "German"),
                        new Person("cc", 24, "Dutch")
                })
        };

        File file = new File ("scenarios/homework/week13/buildingNested.xml");

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

            for (Household household : households) {
                writerIndenting.writeStartElement("household");
                writerIndenting.writeAttribute("id", String.valueOf(household.getId()));

                writerIndenting.writeStartElement("persons");
                for (Person person : household.getPersons()) {
                    writerIndenting.writeStartElement("person");
                    writerIndenting.writeAttribute("name",person.getName());
                    writerIndenting.writeAttribute("age", String.valueOf(person.getAge()));
                    writerIndenting.writeAttribute("nationality", person.getNationality());
                    writerIndenting.writeEndElement();
                }
                writerIndenting.writeEndElement();

                writerIndenting.writeEndElement();
            }

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
