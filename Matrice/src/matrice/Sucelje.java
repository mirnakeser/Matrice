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
public interface Sucelje {
    public int rang();
    public Matrica plus(Matrica M)throws IllegalArgumentException, InterruptedException;
    public Matrica minus(Matrica M)throws IllegalArgumentException, InterruptedException;
    public Matrica puta(Matrica M) throws IllegalArgumentException, InterruptedException;
}
