/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expreverifica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author trezzi_luca
 */
public class myFile {

    public void SalvaSuFile(String s) throws IOException {
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter("file.csv", true))) {
            writer.write(s);
        }
    }

    public String LeggiDaFile() throws FileNotFoundException, IOException {
        String s = "";

        BufferedReader file
                = new BufferedReader(new FileReader("file.csv"));

        String riga = file.readLine();
        while (riga != null) {

            s += riga;
            riga = file.readLine();
        }

        return s;
    }

    public void SovrascriviFile(String s) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("file.csv"))) {
            writer.write(s);
        }
    }
}
