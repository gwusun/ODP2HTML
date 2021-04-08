package cn.test;

import cn.html.XMLEnum;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import sun.misc.BASE64Decoder;

import javax.swing.text.html.HTMLDocument;
import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class TestDom4j {
    @Test
    public void testDom4j() {
        Document document = null;
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(new File("ppts/word/content.xml")); // 读取XML文件,获得document对象
            Element root = document.getRootElement();
            for (Iterator i = root.elementIterator(); i.hasNext();) {
                Element el = (Element) i.next();
                if(el.getName().equals( XMLEnum.AUTOMATIC_STYLE.getValue())){
                    for(Iterator styleIterator=el.elementIterator();styleIterator.hasNext();)
                    {

                      Element style=  (Element)styleIterator.next();

                        Attribute name = style.attribute("name");
                        int f=1;
                    }
                }
//                el.getNamespacePrefix()   office
//                el.getName()              automatic-styles
//                el.getNamespaceURI()      urn:oasis:names:tc:opendocument:xmlns:office:1.0
//                el.getNodeTypeName()      Element
                int j=0;

            }
            int i=0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    public void  testPng() throws IOException {
        String base64 = DatatypeConverter.printBase64Binary(Files.readAllBytes(Paths.get("/Users/sunwu/IdeaProjects/StudyJava/Object1")));
        StringBuilder sb=new StringBuilder();
        sb.append("<img src=“data:image/png;base64,");
        sb.append(base64.replaceAll("/[\\r\\n\\s]/g",""));
        sb.append("\"/>");


        FileWriter fileWriter = new FileWriter("1.html");
        fileWriter.write(sb.toString());
        fileWriter.close();

    }
}
