package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.HashMap;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


class DocumentContainer {
    private Document document;
    private String fileName = "test.xml";

    DocumentContainer() {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            this.document = documentBuilder.parse(fileName);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
    public Document getDocument() {
        return document;
    }

    public void writeDocument() throws TransformerFactoryConfigurationError {
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream("test.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }

}


class DocumentMapper {
    private HashMap <Integer, String> documentMap;
    private DocumentContainer documentContainer;

    DocumentMapper() throws IOException {
        documentContainer = new DocumentContainer();
        this.documentMap = toHashMap();
    }

    private HashMap <Integer, String> toHashMap() throws IOException {
        HashMap <Integer, String> usersMap = new HashMap<Integer, String>();
        Document document = documentContainer.getDocument();
        Node root = document.getDocumentElement();
        NodeList users = root.getChildNodes();
        for (int i = 0; i < users.getLength(); i++) {
            Node user = users.item(i);
            if (user.getNodeType() != Node.TEXT_NODE) {
                NodeList usersProps = user.getChildNodes();
                int id = 0;
                String name = "";
                for (int j = 0; j < usersProps.getLength(); j++) {
                    Node userProp = usersProps.item(j);
                    if (userProp.getNodeType() != Node.TEXT_NODE) {
                        if (userProp.getNodeName() == "Id") {
                            id = Integer.parseInt(userProp.getChildNodes().item(0).getTextContent());
                        }
                        if (userProp.getNodeName() == "Name") {
                            name = userProp.getChildNodes().item(0).getTextContent();
                        }
                    }
                }
                usersMap.put(id, name);
            }
        }
        return usersMap;
    }
    public HashMap getDocumentMap() {
        return documentMap;
    }

    public void addName(String name) {
        int id = documentMap.keySet().size();
        documentMap.put(id, name);

        Document document = documentContainer.getDocument();
        Node root = document.getDocumentElement();
        Element user = document.createElement("User");
        Element userId = document.createElement("Id");
        userId.setTextContent(Integer.toString(id));
        Element userName = document.createElement("Name");
        userName.setTextContent(name);
        user.appendChild(userId);
        user.appendChild(userName);
        root.appendChild(user);
        documentContainer.writeDocument();
    }


}


public class Main {
    public static void main(String[] args) throws IOException {

        DocumentMapper dm = new DocumentMapper();
        HashMap <Integer, String> hs = dm.getDocumentMap();

        hs.forEach((key, value) -> System.out.println("ID = " + key + " Name = " + value));
        dm.addName("Michael");
        System.out.println("-------------------");
        hs.forEach((key, value) -> System.out.println("ID = " + key + " Name = " + value));
        dm.addName("Shara");
        System.out.println("-------------------");
        hs.forEach((key, value) -> System.out.println("ID = " + key + " Name = " + value));
    }
}