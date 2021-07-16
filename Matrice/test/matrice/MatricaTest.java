/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sime
 */
public class MatricaTest {
    
    public MatricaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    

    

    /**
     * Test of rang method, of class Matrica.
     */
   @Test
   public void testRang() { /*provjera ranga*/
       System.out.println("rang");
        double [][] A=new double[4][3];
        
       A[0][0]=3;
       A[0][1]=4;
       A[0][2]=5;
       A[1][0]=7;
       A[1][1]=7;
       A[1][2]=0;
       A[2][0]=5;
       A[2][1]=6;
       A[2][2]=1;
       A[3][0]=9;
       A[3][1]=1000;
       A[3][2]=1;
       
        
        
        
        Matrica instance = new Matrica(A);
        
        int expResult = 3;
        int result = instance.rang();
        assertEquals(expResult, result);
      }

    
  

    /**
     * Test of plus method, of class Matrica.
     */
    @Test
    public void testPlus() throws Exception {
        System.out.println("plus");
        double [][] A=new double[4][3];
       A[0][0]=3;
       A[0][1]=4;
       A[0][2]=5;
       A[1][0]=7;
       A[1][1]=7;
       A[1][2]=0;
       A[2][0]=5;
       A[2][1]=6;
       A[2][2]=1;
       A[3][0]=9;
       A[3][1]=1000;
       A[3][2]=1;
       Matrica M=new Matrica(A);
       
       double [][] B=new double[4][3];
       B[0][0]=7;
       B[0][1]=9;
       B[0][2]=11;
       B[1][0]=8;
       B[1][1]=7;
       B[1][2]=0;
       B[2][0]=5;
       B[2][1]=6;
       B[2][2]=1000;
       B[3][0]=90000;
       B[3][1]=1;
       B[3][2]=77;
       Matrica instance = new Matrica(B);
       
       
       for(int i=0;i<4;i++)
            for(int j=0;j<3;j++)
                A[i][j]=A[i][j]+B[i][j];
       Matrica expResult=new Matrica(A);
        
        
       Matrica result = instance.plus(M);
       
       assertEquals(expResult.matrica, result.matrica);
        // TODO review the generated test code and remove the default call to fail.
      }

    /**
     * Test of minus method, of class Matrica.
     */
    @Test
    public void testMinus() throws Exception {
        System.out.println("minus");
       double [][] A=new double[4][3];
       A[0][0]=3;
       A[0][1]=4;
       A[0][2]=5;
       A[1][0]=7;
       A[1][1]=7;
       A[1][2]=0;
       A[2][0]=5;
       A[2][1]=6;
       A[2][2]=1;
       A[3][0]=9;
       A[3][1]=1000;
       A[3][2]=1;
       Matrica M=new Matrica(A);
       
        double [][] B=new double[4][3];
       B[0][0]=3;
       B[0][1]=1000;
       B[0][2]=110;
       B[1][0]=8888;
       B[1][1]=7777;
       B[1][2]=0;
       B[2][0]=-5;
       B[2][1]=6;
       B[2][2]=1000;
       B[3][0]=90000;
       B[3][1]=1;
       B[3][2]=77;
       Matrica instance = new Matrica(B);
       
       
      for(int i=0;i<4;i++)
            for(int j=0;j<3;j++)
                A[i][j]=B[i][j]-A[i][j];
       Matrica expResult=new Matrica(A);
        
       
       
       Matrica result = instance.minus(M);
        
       assertEquals(expResult.matrica, result.matrica);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of puta method, of class Matrica.
     */
   @Test
    public void testPuta() throws Exception {
        System.out.println("puta");
      
        double[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        double[][] B = {{9,8,7},{6,5,4},{3,2,1}};
        
        Matrica M = new Matrica(B);
        Matrica instance = new Matrica(A);
      
        double[][] rez = {{30, 24, 18}, {84, 69, 54}, {138, 114, 90}};
        Matrica expResult = new Matrica(rez);
        Matrica result = instance.puta(M);
        
        assertEquals(expResult.matrica, result.matrica);
        // TODO review the generated test code and remove the default call to fail.
        
    }
}