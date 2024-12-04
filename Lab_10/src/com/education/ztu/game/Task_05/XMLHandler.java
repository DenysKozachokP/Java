package com.education.ztu.game.Task_05;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLHandler {

    public static void main(String[] args) {
        String filePath = "src/com/education/ztu/game/Task_05/participants.xml";

        Document document = readXML(filePath);
        if (document != null) {
            printParticipants(document);
        }

        addParticipant(document, "Alice Brown", 22);

        saveXML(document, filePath);
    }

    /**
     * Читає XML-файл і повертає об'єкт {@link Document}.
     * @param filePath Шлях до XML-файлу.
     * @return Об'єкт {@link Document} або null у разі помилки.
     */
    public static Document readXML(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Додає нового учасника до документа XML.
     * @param document Об'єкт {@link Document}.
     * @param name Ім'я нового учасника.
     * @param age Вік нового учасника.
     */
    public static void addParticipant(Document document, String name, int age) {
        Element root = document.getDocumentElement();

        Element participant = document.createElement("participant");

        Element nameElement = document.createElement("name");
        nameElement.appendChild(document.createTextNode(name));
        participant.appendChild(nameElement);

        Element ageElement = document.createElement("age");
        ageElement.appendChild(document.createTextNode(String.valueOf(age)));
        participant.appendChild(ageElement);

        root.appendChild(participant);
    }

    /**
     * Зберігає змінений XML-документ у файл.
     * @param document Об'єкт {@link Document}.
     * @param filePath Шлях до XML-файлу.
     */
    public static void saveXML(Document document, String filePath) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);
            System.out.println("XML-файл збережено: " + filePath);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Виводить список учасників з XML-документа.
     * @param document Об'єкт {@link Document}.
     */
    public static void printParticipants(Document document) {
        NodeList participantList = document.getElementsByTagName("participant");
        for (int i = 0; i < participantList.getLength(); i++) {
            Node node = participantList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element participant = (Element) node;
                String name = participant.getElementsByTagName("name").item(0).getTextContent();
                String age = participant.getElementsByTagName("age").item(0).getTextContent();
                System.out.println("Учасник: " + name + ", Вік: " + age);
            }
        }
    }
}