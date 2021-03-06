/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expreverifica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 *
 * @author trezzi_luca
 */
public class Parser {

    public static docente[] listaDocenti;
    private String giorno;
    private int numEl;
    public static docente docente;
    private String docScelto;

    public Parser() {
    }

    public Parser(String giorno,String docScelto) {
        this.giorno = giorno;
        listaDocenti = new docente[100];
        this.docScelto = docScelto;
        docente = new docente();
    }
//    public void ParserDoc(String docScelto) {
//        this.docScelto = docScelto;
//        docente = new docente();
//    }

    public docente[] parseDocument(String filename) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element, tagTd;
        NodeList nodelist;
        NodeList nodelist2;

        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "tr"
        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                String contenuto = element.getFirstChild().getTextContent();
                nodelist2 = element.getElementsByTagName("td");
                if (nodelist2 != null && nodelist2.getLength() == 5) {
                    tagTd = (Element) nodelist2.item(2);
                    String giornoTd = tagTd.getTextContent();
                    if (giornoTd.equals(giorno)) {
                        int id = Integer.parseInt(((Element) nodelist2.item(0)).getTextContent());
                        String nomeDocente = ((Element) nodelist2.item(1)).getTextContent();
                        String giornoD = ((Element) nodelist2.item(2)).getTextContent();
                        String ora = ((Element) nodelist2.item(3)).getTextContent();
                        String note = ((Element) nodelist2.item(4)).getTextContent();
                        docente doc = new docente(id, nomeDocente, giornoD, ora, note);
                        listaDocenti[numEl] = doc;
                        numEl++;
                    }
                }
            }
        }
        return listaDocenti;
    }

    public docente parseDocumentDoc(String filename) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element, tagTd;
        NodeList nodelist;
        NodeList nodelist2;

        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "tr"
        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                String contenuto = element.getFirstChild().getTextContent();
                nodelist2 = element.getElementsByTagName("td");
                if (nodelist2 != null && nodelist2.getLength() == 5) {
                    tagTd = (Element) nodelist2.item(1);
                    String docTd = tagTd.getTextContent();
                    if (docTd.equals(docScelto)) {
                        int id = Integer.parseInt(((Element) nodelist2.item(0)).getTextContent());
                        String nomeDocente = ((Element) nodelist2.item(1)).getTextContent();
                        String giornoD = ((Element) nodelist2.item(2)).getTextContent();
                        String ora = ((Element) nodelist2.item(3)).getTextContent();
                        String note = ((Element) nodelist2.item(4)).getTextContent();
                        docente = new docente(id, nomeDocente, giornoD, ora, note);
                    }
                }
            }
        }
        return docente;
    }

    public List getText(NodeList nodelist, String tag) {
        List testo = new ArrayList();

        if (nodelist != null && nodelist.getLength() > 0) {
            testo.add(nodelist.item(0).getTextContent());
            testo.add(nodelist.item(1).getTextContent());
            testo.add(nodelist.item(2).getTextContent());
            testo.add(nodelist.item(3).getTextContent());
        }
        return testo;
    }
}
