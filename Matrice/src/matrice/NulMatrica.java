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
public class NulMatrica extends KvadratnaMatrica{
    public NulMatrica(){
        super(3);
        
        for(int i = 0; i < this.size().get(0); ++i)
            for(int j = 0; j < this.size().get(0); ++j)
                    this.matrica[i][j] = 0;
    }
    
    public NulMatrica(int m){
        super(m);
        
        for(int i = 0; i < m; ++i)
            for(int j = 0; j < m; ++j)
                    this.matrica[i][j] = 0;
    }
}
