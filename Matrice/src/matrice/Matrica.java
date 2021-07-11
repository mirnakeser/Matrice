/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Leonardo Lionel
 * Klasa Matrica sadrzi varijable brRedaka i brStupaca te dvodimenzijalno polje 
 * matrica tipa double u koje pohranjujemo elemente matrice.
 */
public class Matrica implements Sucelje{
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
                matrica[i][j] = Math.round((r.nextDouble() * (r.nextInt()%100))*100.0)/100.0;
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
                matrica[i][j] = Math.round((r.nextDouble() * (r.nextInt()%100))*100.0)/100.0;
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
    
    private void swap(int redak1, int redak2, int stupac)
    {
        for (int i = 0; i < stupac; i++)
        {
            double temp = matrica[redak1][i];
            matrica[redak1][i] = matrica[redak2][i];
            matrica[redak2][i] = temp;
        }
    }
    
    @Override
    public int rang(){
        //postavimo rang na min{brRedaka, brStupaca}
        int rang = brStupaca;
        
        for (int i = 0; i < rang; ++i){
            if (matrica[i][i] != 0){
                for (int j = 0; j < brRedaka; ++j){
                    if (j != i){
                        double mult = (double)matrica[j][i] / matrica[i][i];
                        for (int k = 0; k < rang; k++)
                            matrica[j][k] -= mult * matrica[i][k];
                    }
                }
            }
            else
            {
                boolean reduce = true;
     
                for (int k = i + 1; i < brRedaka; k++)
                {
                    if (matrica[k][i] != 0){
                        swap(i, k, rang);
                        reduce = false;
                        break ;
                    }
                }
     
                if (reduce){
                    rang--;
     
                    // Copy the last column here
                    for (int k = 0; k < brRedaka; ++k)
                        matrica[k][i] = matrica[k][rang];
                }
                --i;
            }
        }
         
        return rang;
    }
    
    @Override
    public ArrayList<Integer> size(){
        ArrayList<Integer> s = new ArrayList<>();
        s.add(brRedaka);
        s.add(brStupaca);
        
        return s;
    }
    
    @Override
    public Matrica plus(Matrica M) throws IllegalArgumentException, InterruptedException{
        if(this.size().get(0) != M.size().get(0) || this.size().get(1) != M.size().get(1))
            throw new IllegalArgumentException();
        
        int m = this.size().get(0);
        int n = this.size().get(1);
        Matrica zbroj = new Matrica(m, n);
        int z = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor trd = new ThreadPoolExecutor(z, z, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(m));
        
        for( int i = 0; i < m; ++i ){
            trd.execute(new Zbrajanje(this, M, zbroj, i));
        }
      
        trd.shutdown();
        trd.awaitTermination(1, TimeUnit.MINUTES);
        
        return zbroj;
    }
    
    @Override
    public Matrica minus(Matrica M)throws IllegalArgumentException, InterruptedException{
        if(this.size().get(0) != M.size().get(0) || this.size().get(1) != M.size().get(1))
            throw new IllegalArgumentException();
        
        int m = this.size().get(0);
        int n = this.size().get(1);
        Matrica razlika = new Matrica(m, n);
        int z = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor trd = new ThreadPoolExecutor(z, z, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(m));
        
        for( int i = 0; i < m; ++i ){
            trd.execute(new Oduzimanje(this, M, razlika, i));
        }
      
        trd.shutdown();
        trd.awaitTermination(1, TimeUnit.MINUTES);
        
        return razlika;
    }
    
    @Override
    public Matrica puta(Matrica M) throws IllegalArgumentException, InterruptedException{
        if(this.size().get(1) != M.size().get(0))
            throw new IllegalArgumentException();
        
        int m = this.size().get(0);
        int n = this.size().get(1);
        int k = M.size().get(1);
        
        Matrica umnozak = new Matrica(m, k);
        int z = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor trd = new ThreadPoolExecutor(z, z, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(m));
        
        for( int i = 0; i < m; ++i ){
            trd.execute(new Mnozenje(this, M, umnozak, i));
        }
      
        trd.shutdown();
        trd.awaitTermination(1, TimeUnit.MINUTES);
        
        return umnozak;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        KvadratnaMatrica M = new KvadratnaMatrica(3);
        System.out.println(M.toString());
        M.transponiraj();
        System.out.println(M.toString());
    }
    
}
