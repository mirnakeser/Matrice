/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice;

import java.util.Random;
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
public class KvadratnaMatricaTest {
    
    public KvadratnaMatricaTest() {
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
     * Test of transponiraj method, of class KvadratnaMatrica.
     */
    @Test
    public void testTransponiraj() {
        System.out.println("transponiraj");
        
        KvadratnaMatrica instance=new KvadratnaMatrica();
        KvadratnaMatrica expResult=new KvadratnaMatrica();
        
        
        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++)
                expResult.matrica[i][j]=instance.matrica[j][i];
        
        
      instance.transponiraj();
      for(int i = 0; i < expResult.size().get(0); ++i)
            assertArrayEquals(expResult.matrica[i], instance.matrica[i], 1e-9);
        
       
       // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of jeLiSimetricna method, of class KvadratnaMatrica.
     */
    @Test
    public void testJeLiSimetricna() {
        System.out.println("jeLiSimetricna");
        
        double[][] A=new double[5][5];
                
             for(int i=0;i<5;i++)
                 for(int j=0;j<5;j++)
                 {
                   A[i][j]=3;
                  if(i==j) A[i][j]=1;
                 }
        KvadratnaMatrica instance = new KvadratnaMatrica(A);   
                
        boolean expResult = true;
        boolean result = instance.jeLiSimetricna();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of faktorizacijaCholeskog method, of class KvadratnaMatrica.
     */
  @Test
    public void testFaktorizacijaCholeskog() {
        System.out.println("faktorizacijaCholeskog");
         double[][] A = {{1,0},{0,1}};
        KvadratnaMatrica instance = new KvadratnaMatrica(A);
         
        KvadratnaMatrica expResult = new KvadratnaMatrica(A);
        KvadratnaMatrica result = instance.faktorizacijaCholeskog();
       for(int i = 0; i < expResult.size().get(0); ++i)
            assertArrayEquals(expResult.matrica[i], result.matrica[i], 1e-9);
        // TODO review the generated test code and remove the default call to fail.
     }

    /**
     * Test of jeLiPozitivnoDefinitna method, of class KvadratnaMatrica.
     */
   @Test
    public void testJeLiPozitivnoDefinitna() {
        System.out.println("jeLiPozitivnoDefinitna");
        double [][] A=new double[2][2];
        for(int i=0;i<2;i++)
            for(int j=0;j<2;j++)
                 A[i][j]=1;
        A[1][1]=-1;
        KvadratnaMatrica instance = new KvadratnaMatrica(A);
        boolean expResult = false;
        boolean result = instance.jeLiPozitivnoDefinitna();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of inverz method, of class KvadratnaMatrica.
     */
   @Test
    public void testInverz() {
        System.out.println("inverz");
        double[][] A = {{1,2},{3,4}};
        KvadratnaMatrica instance = new KvadratnaMatrica(A);
        double[][] rez = {{-2,1},{1.5,-0.5}};
        KvadratnaMatrica expResult = new KvadratnaMatrica(rez);

       KvadratnaMatrica result = instance.inverz();
        for(int i = 0; i < expResult.size().get(0); ++i)
            assertArrayEquals(expResult.matrica[i], result.matrica[i], 1e-9);
       
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of dijagonala method, of class KvadratnaMatrica.
     */
   @Test
    public void testDijagonala() {
        System.out.println("dijagonala");
        KvadratnaMatrica instance = new KvadratnaMatrica();
        double[] expResult =new double[5];
        
        for(int i=0;i<5;i++)
              expResult[i]=instance.matrica[i][i];
        
        
       double[] result = instance.dijagonala();
       assertArrayEquals(expResult, result, 1e-9);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of svojstveneVrijednosti method, of class KvadratnaMatrica.
     */
    @Test
    public void testSvojstveneVrijednosti() {
        System.out.println("svojstveneVrijednosti");
        double [][] A=new double[2][2];
        for(int i=0;i<2;i++)
            for(int j=0;j<2;j++)
                 A[i][j]=1;
        
        KvadratnaMatrica instance = new KvadratnaMatrica(A);
        double[] expResult = new double[2];
        
        expResult[0]=2;
        expResult[1]=0;
        
        double[] result = instance.svojstveneVrijednosti();
        
        assertArrayEquals(expResult, result, 1e-9);
        // TODO review the generated test code and remove the default call to fail.
      }
    /**
     * Test of svojstveniVektori method, of class KvadratnaMatrica.
     */
    @Test
    public void testSvojstveniVektori() {
        System.out.println("svojstveniVektori");
        double[][] A = {{1,2},{3,4}};
        
       KvadratnaMatrica instance=new KvadratnaMatrica(A);
       
       double [][] expResult={{-0.4159736,-0.8245648},{-0.9093767,0.5657675}};
       
       double[][] result=instance.svojstveniVektori();     
        
          for(int i=0;i<expResult.length;i++)
                 assertArrayEquals(expResult[i], result[i], 1e-5);
 }

    /**
     * Test of trag method, of class KvadratnaMatrica.
     */
    @Test
    public void testTrag() {
        System.out.println("trag");
        double[][] A={{1,2,3},{1,2,3},{1,2,3}};
        KvadratnaMatrica instance = new KvadratnaMatrica(A);
        int expResult = 6;
       
        
        int result = instance.trag();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of jeLiRegularna method, of class KvadratnaMatrica.
     */
    @Test
    public void testJeLiRegularna() {
        System.out.println("jeLiRegularna");
        double[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        KvadratnaMatrica instance = new KvadratnaMatrica(a);
        boolean expResult = false;
        boolean result = instance.jeLiRegularna();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
  
}