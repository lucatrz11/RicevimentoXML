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
        Scanner input = new Scanner(System.in);

        // docente[] listaDocenti=new docente[200];
        System.out.println("Scrivi un giorno: ");
        String giorno = input.nextLine();
        giorno=giorno.replaceAll("i","ì");
        //Parser dom1 = new Parser(giorno);
        expreverifica.Parser dom = new expreverifica.Parser(giorno);
        try {
            Parser.listaDocenti = dom.parseDocument("ricevimento.xml");

            System.out.println();
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.out.println("Errore!");
        }
//        for (int i = 0; i < listaDocenti.length; i++) {
//            int id = listaDocenti[i].getId();
//            String nome = listaDocenti[i].getDocente();
//            String g = listaDocenti[i].getGiorno();
//            String ora = listaDocenti[i].getOra();
//            String note = listaDocenti[i].getNote();
//            System.out.println(id +" "+ nome +" "+ g +" "+ ora +" "+ note);
            System.out.println(Arrays.toString(listaDocenti));
            //String s = dom.toCSV(sportello);

        }
    }


