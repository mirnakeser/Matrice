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
import java.sql.ResultSet;



/**
 *
 * @author Leonardo Lionel
 */
public class SQLite {
    private static String imeBaze = "matrica.db";
    private static String url = "jdbc:sqlite:" + imeBaze ;
    private static String stupac = "", sql = "";

    // kreira se baza podataka s nazivom matrica u koju ce se pohranjivati pravilno unesene matrice 
    // 1 poziv
    private static void stvaranjeBaze() {
        try ( Connection conn = DriverManager.getConnection ( url ) ) {
            if ( conn != null ) {
                DatabaseMetaData meta = conn.getMetaData () ;
                System.out.println ("Ime biblioteke za rad s bazom podataka " + meta.getDriverName () ) ;
                System.out.println ("Stvorena je nova baza.") ;
            }
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ;
        } 
    }
    
    // kreira se tablica u bazi matrica u koju ce se pohranjivati pravilno unesene matrice 
    // 1 poziv
    private static void stvaranjeTablice() {
        
        
        //simetricnost i poz. definitnost:
        // -1 ako matrica nije kvasdratna
        // 0 ako matrica nije sim. / poz. def.
        // 1 ako matrica je sim. / poz.def.
        sql = " CREATE TABLE IF NOT EXISTS matrice (\n"
                        + " vrijenodnosti text PRIMARY KEY, \n"
                        + " rang integer, \n"
                        + " simetricnost integer, \n"
                        + " pozitivnaDefinitnost integer \n"
                        + " transponirana text, \n"
                        + " faktorizacijaCholeskog text, \n"
                        + " swap text \n"
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
        sql = " INSERT INTO matrica ( vrijednosti ) VALUES (?)";

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
    
    private static boolean pomocnaSvojstvo(int opcija) {
        if( opcija == 1 )
            stupac = "rang";
        else if ( opcija == 2 )
            stupac = "simetricnost";
        else if ( opcija == 3 )
            stupac = "pozitivnaDefinitnost";
        else {
            System.out.println("Baza se ne moze azurirati, opcije su vrijednosti 1-3.");
            return false;
        }
        return true;
    }
    
    private static boolean pomocnaTransformacija(int opcija) {
        if( opcija == 1 )
            stupac = "transponirana";
        else if ( opcija == 2 )
            stupac = "faktorizacijaCholeskog";
        else if ( opcija == 3 )
            stupac = "swap";
        else {
            System.out.println("Baza se ne moze azurirati, opcije su vrijednosti 1-3.");
            return false;
        }
        return true;
    }
    
    // nakon sto korisnik trazi da se izracuna neko od svostava matrice,
    // u bazi se takoder azurira taj podatak
    // istom fjom se unosi sve, saljemo u fju info o tome koji podatak o matrici smo izracunali
    public static void azurirajSvojstvoMatrice ( int opcija, String vrijednosti , int novaVrijednost, Connection conn ) {
        
       if(!pomocnaSvojstvo(opcija))
            return;
                    
        sql = " UPDATE matrica SET " + stupac + " = ? , "
                        + " WHERE vrijednosti = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement ( sql );
            pstmt.setInt (1 , novaVrijednost ) ;
            pstmt.setString (2 , vrijednosti ) ;
            pstmt.executeUpdate () ;
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ;
        }
    }

    public static void azurirajTransformacijuMatrice ( int opcija, String vrijednosti , String novaVrijednost, Connection conn ) {
        if(!pomocnaTransformacija(opcija))
            return;
                    
        sql = " UPDATE matrica SET ? = ? WHERE vrijednosti = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement ( sql );
            pstmt.setString (1 , stupac ) ;
            pstmt.setString (2 , novaVrijednost ) ;
            pstmt.setString (3 , vrijednosti ) ;
            pstmt.executeUpdate () ;
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ;
        }
    }
    
    public static void selectSvojstvo ( Connection conn, String vrijednosti, int opcija ) {
        
        if(!pomocnaSvojstvo(opcija))
            return;
        
        sql = " SELECT ? FROM matrica WHERE vrijednosti = ? ";

        try {
            PreparedStatement pstmt = conn.prepareStatement ( sql );
            pstmt.setString (1 , stupac ) ;
            pstmt.setString (2 , vrijednosti ) ;
            pstmt.executeUpdate () ;
            ResultSet rs = pstmt.executeQuery ( sql );
            while ( rs.next () ) {
            System.out.println ( rs.getInt (stupac));
        }
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ;
        }   
    }
    
    public static void selectTransformacija ( Connection conn, String vrijednosti, int opcija ) {
        
        if(!pomocnaTransformacija(opcija))
            return;
        
        sql = " SELECT ? FROM matrica WHERE vrijednosti = ? ";

        try {
            PreparedStatement pstmt = conn.prepareStatement ( sql );
            pstmt.setString (1 , stupac ) ;
            pstmt.setString (2 , vrijednosti ) ;
            pstmt.executeUpdate () ;
            ResultSet rs = pstmt.executeQuery ( sql );
            while ( rs.next () ) {
            System.out.println ( rs.getString (stupac));
        }
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ;
        }
    }
    
    public static void main (String args[]) {
        SQLite.stvaranjeBaze();
        SQLite.stvaranjeTablice();
    }
    
    
}
