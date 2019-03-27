/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expreverifica;

import static expreverifica.Parser.listaDocenti;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author trezzi_luca
 */
public class ExPreverifica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        docente[] listaDocenti;
        docente docente;
        Scanner input = new Scanner(System.in);
        myFile mioF = new myFile();
        Parser dom = new Parser();
        Parser domDoc = new Parser();
        // docente[] listaDocenti=new docente[200];
        String giorno = "";
        String doc = "";
        System.out.println("Scegli un giorno o un docente: ");
        String decisione = input.nextLine();
        if ("giorno".equals(decisione)) {
            System.out.println("Scegli un giorno: ");
            giorno = input.nextLine();
            giorno = giorno.replaceAll("i", "ì");
            dom = new expreverifica.Parser(giorno, "");
        } else if ("docente".equals(decisione)) {
            System.out.println("Scegli il docente: ");
            doc = input.nextLine();
            doc.toUpperCase();
            domDoc = new expreverifica.Parser("", doc);
        }
        try {
            if ("giorno".equals(decisione)) {
                listaDocenti = dom.parseDocument("ricevimento.xml");
                System.out.println();
                System.out.println(Arrays.toString(listaDocenti));
                mioF.SalvaSuFile(Arrays.toString(listaDocenti));
            } else if ("docente".equals(decisione)) {
                docente = domDoc.parseDocumentDoc("ricevimento.xml");
                System.out.println();
                System.out.println(docente.toString());
                mioF.SalvaSuFile(docente.toString());
            }

        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.out.println("Errore!");
        }

    }
}
