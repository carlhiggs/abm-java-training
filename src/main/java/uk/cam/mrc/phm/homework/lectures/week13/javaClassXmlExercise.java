package uk.cam.mrc.phm.homework.lectures.week13;

import com.sun.xml.txw2.output.IndentingXMLStreamWriter;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class javaClassXmlExercise {
    // The java class information needs to be documented into an XML file, the following elements are
    // included:
    //  - 20 students with their id (index start from 0) and final grade (a random number between 0 and 5)
    //  - 3 supervisors with their names
    // Please interpret this into a proper hierarchical structure, then using XMLStreamWriter to create a
    // javaClass.xml file to store these information properly

    private static final Logger LOGGER = Logger.getLogger(javaClassXmlExercise.class.getName());

    public static void main(String[] args) {
        final String[] studentNames = {"Valentina A", "Miguel B", "Jorge C", "Javier D", "Joaquin E", "Jose F", "Juan G", "Julia H", "Julieta I", "Julian J", "Julio K", "Jürgen L", "Karl M", "Karla N", "Karol O", "Katarina P", "Katerina Q", "Katharina R", "Xiaoqi S", "Xiaoyan T"};
        final String[] supervisorNames = {"Professor X", "Professor Y", "Professor Z"};
        writeClassReportXML(studentNames, supervisorNames);
    }

    public static void writeClassReportXML(String[] studentNames, String[] supervisorNames) {
        Classroom classroom = new Classroom(studentNames, supervisorNames);
        List<Map<String, String>> students = classroom.getStudents();
        String[] supervisors = classroom.getSupervisors();
        File reportXmlOutputFile = new File("scenarios/homework/week13/javaClassStudentReports.xml");
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(reportXmlOutputFile));
            XMLStreamWriter writerIndenting = new IndentingXMLStreamWriter(writer);
            writerIndenting.writeStartDocument("utf-8", "1.0");
            writerIndenting.writeStartElement("classroom");
            writeXmlSection(writerIndenting, "supervisors", "supervisor", supervisors);
            writeXmlSection(writerIndenting, "students", "student", students);
            writerIndenting.writeEndElement();
            writerIndenting.writeEndDocument();
        } catch (IOException | XMLStreamException e) {
            LOGGER.log(Level.SEVERE, "Error writing XML file", e);
        }
    }

    private static void writeXmlSection(XMLStreamWriter writerIndenting, String section, String label, String[] content) throws XMLStreamException {
        writerIndenting.writeStartElement(section);
        for (String i : content) {
            writerIndenting.writeStartElement(label);
            writerIndenting.writeCharacters(i);
            writerIndenting.writeEndElement();
        }
        writerIndenting.writeEndElement();
    }

    private static void writeXmlSection(XMLStreamWriter writerIndenting, String section, String label, List<Map<String, String>> content) throws XMLStreamException {
        writerIndenting.writeStartElement(section);
        for (Map<String, String> i : content) {
            writerIndenting.writeStartElement(label);
            for (Map.Entry<String, String> attribute : i.entrySet()) {
                writerIndenting.writeAttribute(attribute.getKey(), attribute.getValue());
                }
            writerIndenting.writeEndElement();
        }
        writerIndenting.writeEndElement();
    }
}
