package uk.cam.mrc.phm.homework.lectures.week13;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class XMLReaderExample {

    public static void main(String[] args) {
        File file = new File("scenarios/homework/week13/network.xml");

        FileInputStream stream = null;
        try {
            stream = new FileInputStream(file);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(stream);

            while (reader.hasNext()){
                int integerCode = reader.next();
                System.out.println("Integer code: " + integerCode + ", event type: " + getStringEventType(integerCode));

                if(reader.isStartElement()){
                    System.out.println("start of " + reader.getLocalName() + ":");
                    for (int i = 0; i < reader.getAttributeCount(); i++){
                        String name =  reader.getAttributeLocalName(i);
                        String value = reader.getAttributeValue(i);
                        System.out.println(name + " = " + value);
                    }
                }else if (reader.isEndElement()){
                    System.out.println("end of " + reader.getLocalName());
                }

            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }

    }


    private static String getStringEventType(int eventTypeAsInt) {
        switch (eventTypeAsInt) {
            case 1:
                return "START_ELEMENT";
            case 2:
                return "END_ELEMENT";
            case 3:
                return "PROCESSING_INSTRUCTION";
            case 4:
                return "CHARACTERS";
            case 5:
                return "COMMENT";
            case 6:
                return "SPACE";
            case 7:
                return "START_DOCUMENT";
            case 8:
                return "END_DOCUMENT";
            case 9:
                return "ENTITY_REFERENCE";
            case 10:
                return "ATTRIBUTE";
            case 11:
                return "DTD";
            case 12:
                return "CDATA";
            case 13:
                return "NAMESPACE";
            case 14:
                return "NOTATION_DECLARATION";
            case 15:
                return "ENTITY_DECLARATION";
            default:
                throw new IllegalArgumentException("Event type not defined!");
        }
    }

}
