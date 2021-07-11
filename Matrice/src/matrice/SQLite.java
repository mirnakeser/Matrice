/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;



/**
 *
 * @author Leonardo Lionel
 */
public class SQLite {
    private String imeBaze = "matrica.db";
    private String url = " jdbc:sqlite:" + imeBaze ;

    // kreira se baza podataka s nazivom matrica u koju ce se pohranjivati pravilno unesene matrice 
    // 1 poziv
    void stvaranjeBaze() {

        try ( Connection conn = DriverManager.getConnection ( url ) ) {
            if ( conn != null ) {
                DatabaseMetaData meta = conn.getMetaData () ;
                System.out.println ("Ime biblioteke za rad s bazom podataka " + meta.getDriverName () ) ;
                System.out.println (" Stvorena je nova baza .") ;
            }
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ;
        } 
    }
    
    // kreira se tablica u bazi matrica u koju ce se pohranjivati pravilno unesene matrice 
    // 1 poziv
    void stvaranjeTablice() {
        
        String sql = " CREATE TABLE IF NOT EXISTS matrice (\n"
                        + " id integer PRIMARY KEY,\n"
                        + " vrijenodnosti text NOT NULL, \n"
                        + " regularnost integer, \n"
                        + " simetricnost integer, \n"
                        + " pozitivnaDefinitnost integer \n"
                        + ");";
        
        try ( Connection conn = DriverManager.getConnection ( url ) ;
        Statement stmt = conn.createStatement () ) {
            if ( conn != null ) { stmt.execute ( sql ) ;}
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ; } 
    }
    
    // dodavanje matricu u bazu
    // po unosenju matrice znamo samo njene vrijednosti,
    // ostala svojstva se mogu i ne moraju naknadno izracunati ovisno o zahtjevima korisnika
    public static void dodajNovuMatricu ( String vrijednosti, Connection conn ) {
        String sql = " INSERT INTO matrica ( vrijednosti ) VALUES (?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement ( sql ) ;
            pstmt.setString (1 , vrijednosti ) ;
            pstmt.executeUpdate () ;
        }
        catch ( SQLException e ) { } 
    }

        // poziv u programu
    /*
        Ub . insert (" Pero "," Peric " ,35 , conn ) ; Ub . insert (" Marko ","
       Markic " ,55 , conn ) ; Ub . insert (" Mislav "," Mikic " ,46 , conn ) ; Ub
       . insert (" Karmen "," Karlovic " ,61 , conn ) ; Ub . insert (" Maja ","
       Smjeskic " ,20 , conn ) ;
*/
    
    // nakon sto korisnik trazi da se izracuna neko od svostava matrice,
    // u bazi se takoder azurira taj podatak
    // istom fjom se unosi sve, saljemo u fju info o tome koji podatak o matrici smo izracunali
    public static void azurirajMatricu ( int opcija, int id , int novaVrijednost, Connection conn ) {
        
        String stupac = "";
        
        if( opcija == 1 )
            stupac = "regularnost";
        else if ( opcija == 2 )
            stupac = "simetricnost";
        else if ( opcija == 3 )
            stupac = "pozitivnaDefinitnost";
        else {
            System.out.println("Baza se ne moze azurirati, opcije su vrijednosti 1-3.");
            return;
        }
                    
        String sql = " UPDATE matrica SET " + stupac + " = ? , "
                        + " WHERE id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement ( sql );
            pstmt.setInt (1 , novaVrijednost ) ;
            pstmt.setInt (2 , id ) ;
            pstmt.executeUpdate () ;
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ;
        }
    }

}
