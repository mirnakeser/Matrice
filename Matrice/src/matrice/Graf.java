/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Martina
 */
public class Graf implements Runnable{
    private int processorNum;
    int[][] mnozenje;
    int[][] zbrajanje;
    int[][] oduzimanje;
    
    public Graf(int[][] m, int[][] z, int[][] o){
        mnozenje = m;
        zbrajanje = z;
        oduzimanje = o;
    }

    
    @Override
    public void run(){
        JFrame frame = new JFrame( "Matrice" );
        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        //------------------------------------------------------------
        //ArrayList<ArrayList<Integer>> vremena = new ArrayList<>();
        
        var podaci = new XYSeriesCollection () ;
   
        for(int i=0;i<3;i++){
            XYSeries series;

            if(i==0){
                series = new XYSeries ("Mnozenje");
                ArrayList<Integer> dimenzija = new ArrayList<>();
                ArrayList<Double> prosjek = new ArrayList<>();
                ArrayList<Integer> vrijednosti = new ArrayList<>();
                for(int j = 0; j < mnozenje[0].length; ++j){
                    int ima = 0;
                    for(int k = 0; k < dimenzija.size(); ++k){
                        if(mnozenje[0][j] == dimenzija.get(k))
                            ima = 1;
                    }
                    if(ima == 0)
                        dimenzija.add(mnozenje[0][j]);
                }
                
                for(int j = 0; j < dimenzija.size(); ++j){
                    int suma = 0;
                    int br = 0;
                    for(int k = 0; k < mnozenje[1].length; ++k){
                        if(mnozenje[0][k] == dimenzija.get(j)){
                            suma += mnozenje[1][k];
                            br++;
                        }
                    }
                    prosjek.add((double)suma/(double)br);
                }
                for(int j = 0; j < dimenzija.size(); ++j)
                    series.add(dimenzija.get(j), prosjek.get(j));
            }
            else if(i==1){
                series = new XYSeries ("Zbrajanje");
                ArrayList<Integer> dimenzija = new ArrayList<>();
                ArrayList<Double> prosjek = new ArrayList<>();
                ArrayList<Integer> vrijednosti = new ArrayList<>();
                for(int j = 0; j < zbrajanje[0].length; ++j){
                    int ima = 0;
                    for(int k = 0; k < dimenzija.size(); ++k){
                        if(zbrajanje[0][j] == dimenzija.get(k))
                            ima = 1;
                    }
                    if(ima == 0)
                        dimenzija.add(zbrajanje[0][j]);
                }
                
                for(int j = 0; j < dimenzija.size(); ++j){
                    int suma = 0;
                    int br = 0;
                    for(int k = 0; k < zbrajanje[1].length; ++k){
                        if(zbrajanje[0][k] == dimenzija.get(j)){
                            suma += zbrajanje[1][k];
                            br++;
                        }
                    }
                    prosjek.add((double)suma/(double)br);
                }
                for(int j = 0; j < dimenzija.size(); ++j)
                    series.add(dimenzija.get(j), prosjek.get(j));
            }
            else{
                series = new XYSeries ("Oduzimanje");
                ArrayList<Integer> dimenzija = new ArrayList<>();
                ArrayList<Double> prosjek = new ArrayList<>();
                ArrayList<Integer> vrijednosti = new ArrayList<>();
                for(int j = 0; j < oduzimanje[0].length; ++j){
                    int ima = 0;
                    for(int k = 0; k < dimenzija.size(); ++k){
                        if(oduzimanje[0][j] == dimenzija.get(k))
                            ima = 1;
                    }
                    if(ima == 0)
                        dimenzija.add(oduzimanje[0][j]);
                }
                
                for(int j = 0; j < dimenzija.size(); ++j){
                    int suma = 0;
                    int br = 0;
                    for(int k = 0; k < oduzimanje[1].length; ++k){
                        if(oduzimanje[0][k] == dimenzija.get(j)){
                            suma += oduzimanje[1][k];
                            br++;
                        }
                    }
                    prosjek.add((double)suma/(double)br);
                }
                for(int j = 0; j < dimenzija.size(); ++j)
                    series.add(dimenzija.get(j), prosjek.get(j));
            }
       
           podaci.addSeries(series);
        }

        JFreeChart chart = ChartFactory.createXYLineChart (
          "Vremena izvrsavanja", "Broj elemenata rezultantne matrice", "Vrijeme izvrsavanja (milisekunde)", podaci , PlotOrientation.VERTICAL , true , true , false ) ;
        try{
            ChartUtilities.saveChartAsPNG(new File ("time.png") , chart , 450 , 400) ;
            frame.add(new JLabel(new ImageIcon( "time.png" ) ) );
        } catch( IOException e ){
            e.printStackTrace();
        }
        
        frame.add(new JLabel(new ImageIcon( "time.png" ) ) );
        frame.setLocationRelativeTo( null );
        frame.pack();
        frame.setVisible( true );
    }
}
