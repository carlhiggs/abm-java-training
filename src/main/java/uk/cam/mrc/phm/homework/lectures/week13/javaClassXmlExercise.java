package uk.cam.mrc.phm.homework.lectures.week13;

import com.sun.xml.txw2.output.IndentingXMLStreamWriter;

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

    public static void main(String[] args) {
        final String[] studentNames = {"Valentina A", "Miguel B", "Jorge C", "Javier D", "Joaquin E", "Jose F", "Juan G", "Julia H", "Julieta I", "Julian J", "Julio K", "Jürgen L", "Karl M", "Karla N", "Karol O", "Katarina P", "Katerina Q", "Katharina R", "Xiaoqi S", "Xiaoyan T"};
        final String[] supervisorNames = {"Professor X", "Professor Y", "Professor Z"};
        writeClassReportXML(studentNames, supervisorNames);
    }

    public static void writeClassReportXML(String[] studentNames, String[] supervisorNames) {
        Classroom classroom = new Classroom(studentNames, supervisorNames);
        Student[] students = classroom.getStudents();
        String[] supervisors = classroom.getSupervisors();
        File reportXmlOutputFile = new File("scenarios/homework/week13/javaClassStudentReports.xml");
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(reportXmlOutputFile));
            XMLStreamWriter writerIndenting = new IndentingXMLStreamWriter(writer);

            //write header
            writerIndenting.writeStartDocument("utf-8", "1.0");

            writerIndenting.writeStartElement("classroom");

            writerIndenting.writeStartElement("supervisors");
            for (String supervisor : supervisors) {
                writerIndenting.writeStartElement("supervisor");
                writerIndenting.writeAttribute("name", supervisor);
                writerIndenting.writeEndElement();
            }
            writerIndenting.writeEndElement();

            writerIndenting.writeStartElement("students");
            for (Student student : students) {
                writerIndenting.writeStartElement("student");
                writerIndenting.writeAttribute("id", String.valueOf(student.getId()));
                writerIndenting.writeAttribute("name", student.getName());
                writerIndenting.writeAttribute("grade", String.valueOf(student.getGrade()));
                writerIndenting.writeEndElement();
            }
            writerIndenting.writeEndElement();

            writerIndenting.writeEndElement();
            writerIndenting.writeEndDocument();
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
