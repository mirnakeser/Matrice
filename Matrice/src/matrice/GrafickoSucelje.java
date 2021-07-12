/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Leonardo Lionel
 */
public class GrafickoSucelje extends javax.swing.JFrame {

    /**
     * Creates new form GrafickoSucelje
     */
    
    
    public GrafickoSucelje() {
        //matrice se mogu unositi preko txt fielda ili preko datoteka ciji oblik se ovdje zadaje
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        FileChooser.setFileFilter(filter);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jButtonUcitajDatoteku = new javax.swing.JButton();
        jTextFieldUnosMatrice = new javax.swing.JTextField();
        jButtonUcitajMatricu = new javax.swing.JButton();
        jTextFieldSvojstva = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonUcitajDatoteku1 = new javax.swing.JButton();
        jTextFieldUnosMatrice1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButtonUcitajDatoteku2 = new javax.swing.JButton();
        jButtonUcitajMatricu2 = new javax.swing.JButton();
        jTextFieldUnosMatrice2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonUcitajDatoteku.setText("Učitaj datoteku");
        jButtonUcitajDatoteku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUcitajDatotekuActionPerformed(evt);
            }
        });

        jButtonUcitajMatricu.setText("Učitaj matricu");
        jButtonUcitajMatricu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUcitajMatricuActionPerformed(evt);
            }
        });

        jTextFieldSvojstva.setName("jTextFieldSvojstva"); // NOI18N
        jTextFieldSvojstva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSvojstvaActionPerformed(evt);
            }
        });

        jLabel2.setText("Svojstva:");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simetričnost", "Rang", "Pozitivna definitnost" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Transformacije:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transponiranje", "faktorizacija Choleskog", "Swap" }));

        jButton1.setText("Izračunaj!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("Transformiraj!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel9))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jTextFieldUnosMatrice, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonUcitajDatoteku, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonUcitajMatricu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jTextFieldSvojstva, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jButtonUcitajDatoteku)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUcitajMatricu)
                    .addComponent(jTextFieldUnosMatrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(36, 36, 36)
                .addComponent(jTextFieldSvojstva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );

        jTabbedPane1.addTab("Svojstva i tranformacije", jPanel2);

        jLabel3.setText("Računanje s matricama");

        jLabel4.setText("Unesi matricu 1:");

        jLabel5.setText("Unesi matricu 2:");

        jButtonUcitajDatoteku1.setText("Učitaj datoteku 1");
        jButtonUcitajDatoteku1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUcitajDatoteku1ActionPerformed(evt);
            }
        });

        jButton2.setText("Učitaj matricu 1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Zbroj");

        jButton4.setText("Umnožak");

        jButtonUcitajDatoteku2.setText("Učitaj datoteku 2");
        jButtonUcitajDatoteku2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUcitajDatoteku2ActionPerformed(evt);
            }
        });

        jButtonUcitajMatricu2.setText("Učitaj matricu 2");
        jButtonUcitajMatricu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUcitajMatricu2ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane1.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(136, 136, 136)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldUnosMatrice2)
                                .addComponent(jTextFieldUnosMatrice1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton2))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonUcitajDatoteku1))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonUcitajMatricu2)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(138, 138, 138)
                                        .addComponent(jButtonUcitajDatoteku2)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jButton3)
                                    .addGap(40, 40, 40)
                                    .addComponent(jButton4))
                                .addComponent(jScrollPane1)))))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jButtonUcitajDatoteku1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldUnosMatrice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(17, 17, 17)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jButtonUcitajDatoteku2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUcitajMatricu2)
                    .addComponent(jTextFieldUnosMatrice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Računanje s matricana", jPanel3);

        jLabel6.setText("Upute za pravilan unos matrica:");

        jLabel7.setText("1. učitavanje iz datoteka moguće isključivo ako su .txt formata");

        jLabel8.setText("2. matrice nužno moraju biti oblika [[a11,a12,...a1n],[a21,a22,...,a2n],...,[am1,am2,...,amn]]");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel6)
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addGap(38, 38, 38)
                .addComponent(jLabel8)
                .addContainerGap(340, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Upute", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 46, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 45, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Svojstva");

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    // fja koja prima string u kojem je zapisan ili tekst datoteke ili unos iz tekst fielda
    // prima int opcija koji daje info o tome od kud je ucitana matrica (tab1, tab2 prva ili druga)
    //prebacuje dani string u odgovarajuce polje double[][]
    //provjerava je li dani tekst ispravnog formata
    private void raspakirajMatricu(String tekst, int opcija) {
        
        if(opcija == 0) {
            matricaPravilnoUnesena = false;
        }
        else if (opcija == 1) {
            matrica1PravilnoUnesena = false;
        }
        else if (opcija == 2) {
            matrica2PravilnoUnesena = false;
        }
        
        //System.out.println("ucitano: " + tekst);
        tekst = tekst.strip();

        if (!tekst.endsWith("]") || !tekst.startsWith("[")) {
            System.out.println("nepravilno unesena matrica");
            return;
        }
        //micem [ s pocetka i ] s kraja, zatim uklanjam bjeline s pocetka i kraja
        tekst = tekst.substring(1, tekst.length()-1);
        tekst = tekst.strip();
        if (!tekst.endsWith("]") || !tekst.startsWith("[")) {
            System.out.println("nepravilno unesena matrica");
            return;
        }
        //System.out.println(tekst);
        
        String matrica[] = tekst.split(Pattern.quote("["));
        //for(int i = 1; i < matrica.length; i++)
        //    System.out.println("redak " + i + ": " + matrica[i]);


        //unesenaMatrica = new double[matrica.length][matrica[0].length()-2];
        //System.out.println("duljina prvog retka: " + matrica[0].length());
        //double unesenaMatrica[][] = new double[matrica[0].length()][matrica.length];
        
        brojRedaka = matrica.length-1;
        brojStupaca = matrica[1].split(",").length;
        
        if(brojStupaca== 0) {            
            System.out.println("nepravilno unesena matrica");
            return;
        }
        unesenaMatrica = new double[matrica.length-1][brojStupaca];

        for(int i = 1; i < matrica.length; i++) {
            matrica[i] = matrica[i].strip();
            //System.out.println(matrica[i]);

            int duljina = matrica[i].length();
            int cijelaDuljina = matrica.length;
            
            if(i < matrica.length-1) {
                if(matrica[i].endsWith(",") && matrica[i].lastIndexOf("]") == matrica[i].length()-2)
                    matrica[i] = matrica[i].substring(0, duljina-2);
                else {
                    System.out.println("nepravilno unesena matrica");
                    return;
                }
            }
            else matrica[i] = matrica[i].substring(0, duljina-1);
            //System.out.println(matrica[i]);

            String redak[] = matrica[i].split(",");
            //System.out.println("duljina retka: " + redak.length);
            
            if(redak.length != brojStupaca) {
                System.out.println("nepravilno unesena matrica");
                return;
            }
            
            for(int j = 0; j < redak.length; j++) {
                //System.out.println(Double.parseDouble(redak[j]));
                if (!redak[j].matches("^(\\d+(\\.\\d+)?)$")) {
                    System.out.println("nepravilno unesena matrica");
                    return;
                }
                else
                    unesenaMatrica[i-1][j] = Double.parseDouble(redak[j]);
            }            
            //System.out.println();                              
        }
        /*
        for(int i = 0; i < unesenaMatrica.length; i++) {
            for(int j = 0; j < unesenaMatrica[i].length; j++)
                System.out.print(unesenaMatrica[i][j]+",");
            System.out.println();   
        }  
        */
        
        if(opcija == 0) {
             //postavlja se na true ako je fja primila string s pravilno upisanom matricom
            matricaPravilnoUnesena = true;
            //matricaTab1 = new Matrica(unesenaMatrica);
        }
        else if (opcija == 1) {
             //postavlja se na true ako je fja primila string s pravilno upisanom matricom
            matrica1PravilnoUnesena = true;
            //matrica1Tab2 = new Matrica(unesenaMatrica);

        }
        else if (opcija == 2) {
             //postavlja se na true ako je fja primila string s pravilno upisanom matricom
            matrica2PravilnoUnesena = true;
            //matrica2Tab2 = new Matrica(unesenaMatrica);

        }
        
       
        
    }
    
    
    //prima polje u kojem je upisana matrica
    //vraca string s istom matricu u formatu koji ce se ispisati u text area
    private String upisMatriceUTextArea(double[][] matrica) {
        String tekst = "";
        
        for(int i = 0; i < matrica.length; i++) {
            tekst += "[";
            for(int j = 0; j < matrica[0].length; j++) {
                tekst += String.valueOf(unesenaMatrica[i][j]);
                if(j < unesenaMatrica[0].length-1)
                    tekst += ", ";
            }
            tekst += "]\n";                              
        }       
        return tekst;
    }
    
    // nakon pritiska buttona za ucitavanje matrice iz datoteke se ovoj fji salje odgovarajuci evt
    // biramo datoteku koja sadrzi matricu
    //upisujemo sve iz datoteke u string cijelaDatoteka
    //fja vraca string sa sadrzajem datoteke
    String ucitajDatoteku(java.awt.event.ActionEvent evt) {
        int returnVal = FileChooser.showOpenDialog((Component)evt.getSource());
        String cijelaDatoteka = "";
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = FileChooser.getSelectedFile();
            try {
                imeDatoteke = file.toString();
            } catch (Exception ex) {

            }
            //System.out.println(imeDatoteke);
            String linija = "";
            File input = new File(imeDatoteke);

            Path p = Paths.get(input.getAbsolutePath());
            try {
                BufferedReader citac = Files.newBufferedReader(p, StandardCharsets.UTF_8);
                while((linija = citac.readLine()) != null) {
                    cijelaDatoteka += linija;
                }
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Neuspješno čitanje datoteke!", "Upozorenje", JOptionPane.WARNING_MESSAGE);

            }
        }
        return cijelaDatoteka;

    }
    
    private void jTextFieldSvojstvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSvojstvaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextFieldSvojstvaActionPerformed
    // pozivaju se fje za odabir datoteke s matricom, upis u string, provjeru sadrzaja stringa
    // ako je sve pravilno odabrano i uneseno, ispisujemo matricu u txt area
    //tab 1
    private void jButtonUcitajDatotekuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUcitajDatotekuActionPerformed
        // TODO add your handling code here:
        String datoteka = ucitajDatoteku(evt);
        jTextArea1.setText("");
        jTextFieldSvojstva.setText("");
        raspakirajMatricu(datoteka, 0);                  
        if (matricaPravilnoUnesena)
            jTextArea1.setText(upisMatriceUTextArea(unesenaMatrica));
        else
            JOptionPane.showMessageDialog(this, "Nepravilno unesena matrica!", "Greška", JOptionPane.ERROR_MESSAGE);

    }//GEN-LAST:event_jButtonUcitajDatotekuActionPerformed

    // ako je u text field pravilno upisana matrica, ispisuje ju se u text area i cisti se sadrzaj text fielda
    // tab 1
    private void jButtonUcitajMatricuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUcitajMatricuActionPerformed
        // TODO add your handling code here:
        jTextArea1.setText("");
        jTextFieldSvojstva.setText("");

        raspakirajMatricu(jTextFieldUnosMatrice.getText(), 0);
        if (matricaPravilnoUnesena) {
            jTextArea1.setText(upisMatriceUTextArea(unesenaMatrica));  
            jTextFieldUnosMatrice.setText("");
        }
        else
            JOptionPane.showMessageDialog(this, "Nepravilno unesena matrica!", "Greška", JOptionPane.ERROR_MESSAGE);

    }//GEN-LAST:event_jButtonUcitajMatricuActionPerformed

    // unos matrice 1 u tabu 2 za racunanje
    //----- treba dodati varijable za rad s dvije matrice i dovrsiti fju
    private void jButtonUcitajDatoteku1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUcitajDatoteku1ActionPerformed
        // TODO add your handling code here:
        String datoteka = ucitajDatoteku(evt);
        raspakirajMatricu(datoteka, 1);                  
        if (matrica1PravilnoUnesena && !matrica2PravilnoUnesena) {
            jTextArea2.setText(upisMatriceUTextArea(unesenaMatrica)+"\n"+"Unesite matricu 2");            
        }
        else if (!matrica1PravilnoUnesena) {
            jTextArea2.setText("Matrica 1 unesena u nepravilnom formatu.");
        }
        else if (matrica1PravilnoUnesena && matrica2PravilnoUnesena) {

        }
    }//GEN-LAST:event_jButtonUcitajDatoteku1ActionPerformed
    // unos matrice 1 u tabu 2 za racunanje, preko text fielda
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        raspakirajMatricu(jTextFieldUnosMatrice1.getText(), 1);
        jTextFieldUnosMatrice1.setText("");

    }//GEN-LAST:event_jButton2ActionPerformed
    // unos matrice 2 u tabu 2 za racunanje
    private void jButtonUcitajDatoteku2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUcitajDatoteku2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUcitajDatoteku2ActionPerformed
    // unos matrice 2 u tabu 2 za racunanje, preko text fielda
    private void jButtonUcitajMatricu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUcitajMatricu2ActionPerformed
        // TODO add your handling code here:
        raspakirajMatricu(jTextFieldUnosMatrice2.getText(), 2);
        jTextFieldUnosMatrice2.setText("");

    }//GEN-LAST:event_jButtonUcitajMatricu2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    // IZRACUNAJ BUTTON
    //provjera odabrane opcije
    //ovisno o odabiru poziva se odg fja koja racuna trazeno svojstvo matrice i daje ispis rezultata
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(!matricaPravilnoUnesena) {
            JOptionPane.showMessageDialog(this, "Nema unesene matrice za provjeru regularnosti.", "", JOptionPane.INFORMATION_MESSAGE);            
            return;
        }
        String odabrano = jComboBox1.getSelectedItem().toString();
        jTextFieldSvojstva.setText("");
        String rez = "";
        if(odabrano == "Simetričnost" || odabrano == "Pozitivna definitnost") {
            if (brojRedaka != brojStupaca) {
                JOptionPane.showMessageDialog(this, "Matrica nije kvadratna, ne može se izračunati traženo svojstvo!", "Upozorenje", JOptionPane.WARNING_MESSAGE);            
                return;
            }
            if(odabrano == "Simetričnost") {
                // if (matricaTab1.jeLiSimetrinca()) rez = "Matrica je simetrična.";
                //else rez = "Matrica nije simetrična.";
            }
            // poztivna definitnost
            else {
                // if (matricaTab1.jeLiPozitivnoDefinitna()) rez = "Matrica je pozitivno definitna.";
                //else rez = "Matrica nije pozitivno definitna.";
            }
        }
        
        //rang
        else {
            rez = "Rang matrice je "; //+ matricaTab1.rang().toString();
        }
        jTextFieldSvojstva.setText(rez);

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GrafickoSucelje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrafickoSucelje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrafickoSucelje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrafickoSucelje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GrafickoSucelje().setVisible(true);
            }
        });
        
        
    }

    private final JFileChooser FileChooser = new JFileChooser();
    String imeDatoteke = "";
    double unesenaMatrica[][];
    int brojStupaca, brojRedaka;
    boolean matrica1PravilnoUnesena = false, matrica2PravilnoUnesena = false;
    boolean matricaPravilnoUnesena = false;
    
    
    // Matrica matricaTab1, matrica1Tab2, matrica2Tab2;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonUcitajDatoteku;
    private javax.swing.JButton jButtonUcitajDatoteku1;
    private javax.swing.JButton jButtonUcitajDatoteku2;
    private javax.swing.JButton jButtonUcitajMatricu;
    private javax.swing.JButton jButtonUcitajMatricu2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextFieldSvojstva;
    private javax.swing.JTextField jTextFieldUnosMatrice;
    private javax.swing.JTextField jTextFieldUnosMatrice1;
    private javax.swing.JTextField jTextFieldUnosMatrice2;
    // End of variables declaration//GEN-END:variables
}
