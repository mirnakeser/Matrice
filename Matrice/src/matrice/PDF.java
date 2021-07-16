/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
//import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.font.PDFont;
/**
 *
 * @author Leonardo Lionel
 */
public class PDF {
    
    public static void spremiPDF(String mat1, String mat2, String mat3, String name) {
        PDFont pdfFont = PDType1Font.HELVETICA;
        float fontSize = 15;
        
        try {
            String[] mat1retci = mat1.split("],");
            String[] mat2retci = mat2.split("],");
            String[] mat3retci = mat3.split("],");
            
            String fileName = name + ".pdf";
            PDDocument doc = new PDDocument();
            PDPage page = new PDPage();
            doc.addPage(page);
            PDPageContentStream content = new PDPageContentStream(doc, page);
            
            content.beginText();
            
            content.setFont(pdfFont, fontSize);
            //content.moveTextPositionByAmount(50, 750);
            //content.drawString(tekst);
            //content.moveTo(10, 10);
            //content.showText("Umnožak matrica:");
            content.newLineAtOffset(20, 700);
            content.showText(name + " matrica:");
            content.newLineAtOffset(0, -20);
            content.showText(" Matrica 1:");

            for(int i = 0; i < mat1retci.length; i++) {
                content.newLineAtOffset(0, -20);
                content.showText(mat1retci[i]);
            }
            content.newLineAtOffset(0, -20);
            content.showText("Matrica 2:");
            for(int i = 0; i < mat2retci.length; i++) {
                content.newLineAtOffset(0, -20);
                content.showText(mat2retci[i]);
            }
            content.newLineAtOffset(0, -20);
            content.showText("Rezultat:");
            for(int i = 0; i < mat3retci.length; i++) {
                content.newLineAtOffset(0, -20);
                content.showText(mat3retci[i]);
            }
            
            content.endText();
            
            content.close();
            doc.save(fileName);
            doc.close();
            
            System.out.println(System.getProperty("user.dir")); 
         } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
