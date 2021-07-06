/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice;

import java.util.Random;

/**
 *
 * @author Leonardo Lionel
 * Klasa Matrica sadrzi varijable brRedaka i brStupaca te dvodimenzijalno polje 
 * matrica tipa double u koje pohranjujemo elemente matrice.
 */
public class Matrica {
    int brRedaka, brStupaca;
    double[][] matrica;
    
    /**
     * Defaultni konstruktor stvara matricu dimenzije 5x5 i popuni ju 
     * random elementima.
     */
    
    public Matrica(){
        brRedaka = 5;
        brStupaca = 5;
        matrica = new double[brRedaka][brStupaca];
        
        Random r = new Random();
        for(int i = 0; i < brRedaka; ++i)
            for(int j = 0; j < brStupaca; ++j)
                matrica[i][j] = r.nextDouble() * (r.nextInt()%100);
    }
    
    /**
     * Konstruktor koji prima dvodimenzionalno polje elemenata matrice te stvara 
     * matricu s tim elementima.
     * @param elementi 
     */
    
    public Matrica(double[][] elementi){
        brRedaka = elementi.length;
        brStupaca = elementi[0].length;
        matrica = new double[brRedaka][brStupaca];
        
        for(int i = 0; i < brRedaka; ++i)
            for(int j = 0; j < brStupaca; ++j)
                matrica[i][j] = elementi[i][j];
    }
    
    /**
     * Konstruktor koji prima broj redaka i broj stupaca matrice te stvara matricu
     * odredenih dimenzija ispunjenu random elementima.
     * @param _brRedaka
     * @param _brStupaca 
     */
    
    public Matrica(int _brRedaka, int _brStupaca){
        brRedaka = _brRedaka;
        brStupaca = _brStupaca;
        Random r = new Random();
        
        matrica = new double[brRedaka][brStupaca];
        for(int i = 0; i < brRedaka; ++i)
            for(int j = 0; j < brStupaca; ++j)
                matrica[i][j] = r.nextDouble() * (r.nextInt()%100);
    }
    
    /**
     * Nadjacana metoda toString() matricu pretvara u string oblika 
     * [[a_11,...,a_1n],[a_21,...,a_2n],...,[a_m1,...,a_mn]]
     * @return string gornjeg oblika
     */
    
    @Override
    public String toString(){
        String s = "[";
        for(int i = 0; i < brRedaka; ++i){
            s += "[";
            for(int j = 0; j < brStupaca; ++j){
                s += matrica[i][j];
                if(j != brStupaca - 1)
                    s += ",";
            }
            s += "]";
            if(i != brRedaka - 1)
                s += ",\n";
        }
        s += "]";
        return s ;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[][] els = new double[2][3];
        Random r = new Random();
        for(int i = 0; i < 2; ++i){
            for(int j = 0; j < 3; ++j)
                els[i][j] = r.nextDouble();
        }
        Matrica A = new KvadratnaMatrica(els);
        System.out.println(A.toString());
    }
    
}
