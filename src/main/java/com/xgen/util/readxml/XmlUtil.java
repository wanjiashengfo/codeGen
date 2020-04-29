package com.xgen.util.readxml;

import org.w3c.dom.Document;

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
        Document doc = builder.parse(resourceAsStream);
        doc.normalize();
        return doc;
    }
}
