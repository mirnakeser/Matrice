/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice;

import java.util.ArrayList;
import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

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
    
    public boolean jeLiSimetricna(){
        for(int i = 0; i < this.size().get(0); ++i){
            for(int j = 0; j < this.size().get(0); ++j){
                if(i > j){
                    if(this.matrica[i][j] != this.matrica[j][i])
                        return false;
                }
            }
        }
        
        return true;
    }
    
    public KvadratnaMatrica faktorizacijaCholeskog(){
        KvadratnaMatrica R = new KvadratnaMatrica(this.size().get(0));
        for(int i = 0; i < R.size().get(0); ++i)
            for(int j = 0; j < R.size().get(0); ++j)
                R.matrica[i][j] = 0;
        double sum = 0.0;
        
        for(int j = 0; j < this.size().get(0); ++j){
            for(int i = 0; i < j; ++i){
                sum = this.matrica[i][j];
                for(int k = 0; k < i; ++k){
                    sum -= R.matrica[k][i] * R.matrica[k][j];
                }
                R.matrica[i][j] = sum / R.matrica[i][i];
            }
            
            sum = this.matrica[j][j];
            for(int k = 0; k < j; ++k){
                sum -= R.matrica[k][j] * R.matrica[k][j];
            }
            
            if(sum > 0.0)
                R.matrica[j][j] = Math.sqrt(sum);
            else
                throw new RuntimeException("Matrica nije pozitivno definitna!");
        }
        
        return R;
    }
    
    public boolean jeLiPozitivnoDefinitna(){
        try{
            this.faktorizacijaCholeskog();
            return true;
        }
        catch(RuntimeException e){
            return false;
        }
    }
    
    private static Rengine stvoriEngine(){
        Rengine engine = Rengine.getMainEngine();
        
        if(engine == null)
            engine = new Rengine(new String[] {"--vanilla"}, false, null);
        
        return engine;
    }
    
    
    private String stvoriRMatricu(){
        String vektor = "c(";
        for(int i = 0; i < this.size().get(0); ++i){
            for(int j = 0; j < this.size().get(0); ++j){
                if(i == this.size().get(0) - 1 && j == this.size().get(0) - 1)
                    vektor += this.matrica[i][j] + ")";
                else
                    vektor += this.matrica[i][j] + ",";
            }
        }
        
        return "matrix( " + vektor + ", nrow=" + this.size().get(0) + ", byrow=TRUE)";
    }
    
    public KvadratnaMatrica inverz(){
        Rengine engine = stvoriEngine();
        String matrica = this.stvoriRMatricu();
        
        engine.eval("A <-" + matrica);
        double[][] a = engine.eval("solve(A)").asDoubleMatrix();
        KvadratnaMatrica A = new KvadratnaMatrica(a);
        
        engine.end();
        
        return A;
    }
    
    public double[] dijagonala(){
        Rengine engine = stvoriEngine();
        String matrica = this.stvoriRMatricu();
        
        engine.eval("A <-" + matrica);
        double[] d = engine.eval("diag(A)").asDoubleArray();
        
        engine.end();
        
        return d;
    }
    
    public double[] svojstveneVrijednosti(){
        Rengine engine = stvoriEngine();
        String matrica = this.stvoriRMatricu();
        
        engine.eval("A <-" + matrica);
        engine.eval("y<-eigen(A)");
        
        double[] val = engine.eval("y$val").asDoubleArray();
        
        engine.end();
        return val;
    }
    
    public double[][] svojstveniVektori(){
        Rengine engine = stvoriEngine();
        String matrica = this.stvoriRMatricu();
        
        engine.eval("A <-" + matrica);
        engine.eval("y<-eigen(A)");
        
        double[][] vec = engine.eval("y$vec").asDoubleMatrix();
        
        engine.end();
        return vec;
    }
    
    
    public void lu(){
        Rengine engine = stvoriEngine();
        String matrica = this.stvoriRMatricu();
        
        engine.eval("require(Matrix)");
        engine.eval("A <-" + matrica);
        //engine.eval("luA <- lu( A )");
        double[][] vec = engine.eval("L<-as.matrix(expand(lu(A))$L)").asDoubleMatrix();
        
        engine.end();
    }
    
    
    public void luFaktorizacija(){
        Rengine engine = stvoriEngine();
        String matrica = this.stvoriRMatricu();
        
        engine.eval("require(\"matrixcalc\")");
        engine.eval("library(matrixcalc)");
        engine.eval("A <-" + matrica);
        engine.eval("luA <- lu.decomposition( A )");
        double[][] vec = engine.eval("L<-as.matrix(luA$L)").asDoubleMatrix();
        
        System.out.println(vec[0][0]);
        
        engine.end();
    }
}