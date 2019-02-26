/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expreverifica;

import java.io.IOException;
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
        Scanner input = new Scanner(System.in);
        docenti doc = new docenti();
        
        System.out.println("Scrivi un giorno: ");
        String giorno = input.nextLine();
        Parser dom = new Parser(giorno);
        try {
            doc = dom.parseDocument("ricevimento.xml");
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.out.println("Errore!");
        }
        //String s = dom.toCSV(sportello);
        
    }
    
}
