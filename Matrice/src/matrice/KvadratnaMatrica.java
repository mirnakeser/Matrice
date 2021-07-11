/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice;

/**
 *
 * @author Martina
 */
public class KvadratnaMatrica extends Matrica{
    public KvadratnaMatrica(){
        super();
    }
    
    public KvadratnaMatrica(double[][] elementi) throws IllegalArgumentException{
        super(elementi);
        
        if(elementi.length != elementi[0].length)
            throw new IllegalArgumentException();
    }
    
    public KvadratnaMatrica(int br){
        super(br, br);
    }
    
    public void transponiraj(){
        for(int i = 0; i < this.size().get(0); ++i){
            for(int j = 0; j < this.size().get(0); ++j){
                if(i > j){
                    double temp = this.matrica[i][j];
                    this.matrica[i][j] = this.matrica[j][i];
                    this.matrica[j][i] = temp;
                }
            }
        }
    }
}
