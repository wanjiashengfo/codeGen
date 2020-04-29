package com.xgen.util.readxml;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlUtil {
    private XmlUtil() {
    }

    public static Document getDocument(String filePathName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(XmlUtil.class.getClassLoader().getResourceAsStream(filePathName));
        doc.normalize();
        return doc;
    }
}
