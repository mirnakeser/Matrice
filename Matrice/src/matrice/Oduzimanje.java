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
public class Oduzimanje implements Runnable{
    Matrica M1, M2, rez;
    int id;
    
    public Oduzimanje(Matrica _M1, Matrica _M2, Matrica _rez, int _id){
        M1 = _M1;
        M2 = _M2;
        rez = _rez;
        id = _id;
    }
    
    @Override
    public void run(){
        for(int i = 0; i < M1.size().get(1); ++i)
            rez.matrica[id][i] = M1.matrica[id][i] - M2.matrica[id][i];
    }
}
