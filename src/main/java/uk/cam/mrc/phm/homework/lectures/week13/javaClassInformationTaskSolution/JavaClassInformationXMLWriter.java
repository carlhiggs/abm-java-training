package uk.cam.mrc.phm.homework.lectures.week13.javaClassInformationTaskSolution;

import com.sun.xml.txw2.output.IndentingXMLStreamWriter;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JavaClassInformationXMLWriter {
    public static void main(String[] args) {


        File file = new File ("scenarios/homework/week13/classInformation.xml");

        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(file));
            XMLStreamWriter writerIndenting = new IndentingXMLStreamWriter(writer);

            //write header
            writerIndenting.writeStartDocument("utf-8","1.0");

            writerIndenting.writeStartElement("class");
            writerIndenting.writeAttribute("name", "Java");

            writerIndenting.writeStartElement("students");

            for (int i = 0; i < 20; i++) {
                int grade = (int) (Math.random()*5 + 1);
                writerIndenting.writeStartElement("student");
                writerIndenting.writeAttribute("id", String.valueOf(i));
                writerIndenting.writeAttribute("grade", String.valueOf(grade));
                writerIndenting.writeEndElement();
            }

            writerIndenting.writeEndElement();

            writerIndenting.writeStartElement("supervisors");

            writerIndenting.writeStartElement("supervisor");
            writerIndenting.writeAttribute("name", "Wei");
            writerIndenting.writeEndElement();

            writerIndenting.writeStartElement("supervisor");
            writerIndenting.writeAttribute("name", "Joanna");
            writerIndenting.writeEndElement();

            writerIndenting.writeStartElement("supervisor");
            writerIndenting.writeAttribute("name", "Yangqian");
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
