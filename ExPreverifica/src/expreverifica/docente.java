/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expreverifica;

/**
 *
 * @author trezzi_luca
 */
public class docente {

    private int id;
    private String docente;
    private String giorno;
    private String ora;
    private String note;

    public docente() {
        id = 0;
        docente = "";
        giorno = "";
        ora = "";
        note = "";
    }

    public docente(int id, String docente, String giorno, String ora, String note) {
        this.id = id;
        this.docente = docente;
        this.giorno = giorno;
        this.ora = ora;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String toString() {
        String s = "";
        s += id + "," + docente + "," + giorno + "," + ora + "," + note+"\n\r";
        return s;
    }

}
