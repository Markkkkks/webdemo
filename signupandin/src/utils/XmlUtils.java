package utils;





import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.*;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class XmlUtils {
    private static String filename = "users.xml";

    public static Document getDocument() throws DocumentException {
        URL url = XmlUtils.class.getClassLoader().getResource(filename);
        String realpath = url.getPath();
        SAXReader saxReader = new SAXReader();

        return saxReader.read(new File(realpath));
    }
    public static void write2Xml(Document document){

    }
    public static void write(Document document) throws IOException {

        // lets write to a file
        URL url = XmlUtils.class.getClassLoader().getResource(filename);
        String realpath = url.getPath();

        XMLWriter writer = new XMLWriter(

                new FileWriter( realpath)

        );

        writer.write( document );

        writer.close();


    }













}
