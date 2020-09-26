package com.xgen.util.readxml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;

public class XmlUtil {
    private XmlUtil() {
    }

    public static Document getDocument(String filePathName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        ClassLoader classLoader = XmlUtil.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(filePathName);
//        Document doc = builder.parse("src/main/resources/xgenconfxml/GenConf.xml");
        Document doc = builder.parse(resourceAsStream);
//        NodeList sList = doc.getElementsByTagName("Params");
//        node(sList);
        doc.normalize();

        return doc;
    }
    public static void node(NodeList list){
        for (int i = 0; i <list.getLength() ; i++) {
            Node node = list.item(i);
            NodeList childNodes = node.getChildNodes();
            for (int j = 0; j <childNodes.getLength() ; j++) {
                if (childNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
                    System.out.print(childNodes.item(j).getNodeName() + ":");
                    System.out.println(childNodes.item(j).getFirstChild().getNodeValue());
                }
            }
        }
    }
}
