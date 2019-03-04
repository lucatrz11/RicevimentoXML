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
public class docenti {

    private docente[] listaDocente;
    private int numElLista;

    public docenti() {
        listaDocente = new docente[170];
        numElLista = 0;
    }

    public void generaId(int id) {
        for (int i = 0; i < listaDocente.length; i++) {
            docente d = new docente();
            listaDocente[0].setId(id);
            numElLista++;
        }
    }

    public void genera(int id, String docente, String giorno, String ora, String note) {
        for (int i = 0; i < listaDocente.length; i++) {
            docente d = new docente();
            listaDocente[0].setId(id);
            listaDocente[1].setDocente(docente);
            listaDocente[2].setOra(ora);
            listaDocente[3].setNote(note);
            numElLista++;
        }
    }

}
