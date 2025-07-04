package pertemuan10;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import static pertemuan10.dbkoneksi.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Antonia Wunu
 * TGL 21 Juni 2025
 */
public class fMahasiswa extends javax.swing.JFrame {
    DefaultTableModel dtm = new DefaultTableModel();
    /**
     * Creates new form fMahasiswa
     * @throws java.sql.SQLException
     */
    public fMahasiswa() throws SQLException {
        initComponents();
        tmhs.setModel(dtm);
        dtm.addColumn("Nama Mahasiswa");
        dtm.addColumn("NIM");
        dtm.addColumn("prodi");
        dtm.addColumn("Jenis Kelamin");
        
        lsDtMhs();
        fieldEnabled(false);
        tombol(false);
        cBaru.setEnabled(true);
        cTutup.setEnabled(true);
        
        
    }    
    private void fieldEnabled(boolean opsi) {
        txNIM.setEditable(opsi);
        txNAMA.setEditable(opsi);
        txJK.setEditable(opsi);
        txPRODI.setEditable(opsi);
    }
    private void tombol(boolean opsi){
        cBaru.setEnabled(opsi);
        cUbah.setEnabled(opsi);
        cHapus.setEnabled(opsi);
                      cTutup.setEnabled(opsi);
    }
    private void clearForm(){
        txNIM.setText("");
        txNAMA.setText("");
        txPRODI.setText("");
        txJK.setText("");
    }
    
        private void lsDtMhs() throws SQLException{
            Connection cnn = koneksi();
            
            dtm.getDataVector().removeAllElements();
            dtm.fireTableDataChanged();
            
             if(!cnn.isClosed()){
                 PreparedStatement ps = cnn.prepareStatement("SELECT * FROM mhs;");
                  ResultSet rs = ps.executeQuery();
                  while( rs.next()){
                      Object[] dta = new Object[4];
                      dta[0] = rs.getString("NAMA");
                      dta[1] = rs.getString("NIM");
                      dta[2] = rs.getString("PRODI");
                      dta[3] = rs.getString("JKEL");
                      
                dtm.addRow(dta);
                     
                  }
                  cnn.close();
             }
        }  
        private void storeData() throws SQLException{
            Connection cnn = koneksi();
            
            if (!cnn.isClosed()){
               PreparedStatement ps = cnn.prepareStatement("INSERT INTO mhs(NIM,NAMA,PRODI,JKEL) VALUES (?,?,?,?);");
               ps.setString(1, txNIM.getText());
               ps.setString(2, txNAMA.getText());
               ps.setString(3, txPRODI.getText());
               ps.setString(4, txJK.getText());
               ps.executeUpdate();      
                cnn.close();
            }
                }
        private void updateData()throws SQLException{
             Connection cnn = koneksi();
            if (!cnn.isClosed()){
               PreparedStatement ps = cnn.prepareStatement("UPDATE mhs SET NAMA=?,PRODI=?,PRODI=?,JKEL=? WHERE NIM=?;");
               ps.setString(4, txNIM.getText());
               ps.setString(1, txNAMA.getText());
               ps.setString(2, txPRODI.getText());
               ps.setString(3, txJK.getText());
               ps.executeUpdate();      
                cnn.close();
            }
        }
        private void destoryData()throws SQLException{
          Connection cnn = koneksi();
            if (!cnn.isClosed()){
               PreparedStatement ps = cnn.prepareStatement("DELETE FROM mhs WHERE NIM=?;");
               ps.setString(1, txNIM.getText());
               ps.executeUpdate();      
                cnn.close();   
            }
        }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txNIM = new javax.swing.JTextField();
        txNAMA = new javax.swing.JTextField();
        txJK = new javax.swing.JTextField();
        txPRODI = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tmhs = new javax.swing.JTable();
        cUbah = new javax.swing.JButton();
        cBaru = new javax.swing.JButton();
        cHapus = new javax.swing.JButton();
        cTutup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        jLabel1.setText("Data Mahasiswa");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("NIM");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Nama Mahasiswa");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Jenis Kelamin");

        jLabel8.setText("Program Studi");

        txNIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNIMActionPerformed(evt);
            }
        });

        txNAMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNAMAActionPerformed(evt);
            }
        });

        txJK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txJKActionPerformed(evt);
            }
        });

        txPRODI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPRODIActionPerformed(evt);
            }
        });

        tmhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tmhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tmhsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tmhs);

        cUbah.setText("Ubah");
        cUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cUbahActionPerformed(evt);
            }
        });

        cBaru.setText("Baru");
        cBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBaruActionPerformed(evt);
            }
        });

        cHapus.setText("Hapus");
        cHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cHapusActionPerformed(evt);
            }
        });

        cTutup.setText("Tutup");
        cTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTutupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2)
                                .addComponent(txNIM)
                                .addComponent(txNAMA)
                                .addComponent(txJK)
                                .addComponent(txPRODI, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cTutup, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txJK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txPRODI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cTutup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txNIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNIMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNIMActionPerformed

    private void txJKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txJKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txJKActionPerformed

    private void txPRODIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPRODIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPRODIActionPerformed

    private void txNAMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNAMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNAMAActionPerformed

    private void cUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cUbahActionPerformed
     
        if(cUbah.getText().equals("Ubah")){
            cUbah.setText("Simpan");
            cTutup.setText("Batal");
        
            cUbah.setEnabled(false);
             cHapus.setEnabled(false);
             fieldEnabled(true);
             txNIM.setEditable(false);
            
        }else{ 
            
        
           try {
            updateData();
            lsDtMhs();
           fieldEnabled(false);
           
            cUbah.setText("Ubah");
             cTutup.setText("Tutup");
              cBaru.setText("True");
            } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(fMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_cUbahActionPerformed

    private void cHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cHapusActionPerformed
       int jwb = JOptionPane.showOptionDialog(
               this,
               "Yakin akan mengahpus data "+txNIM.getText()+"?",
               "Konfirmasi Hapus Data",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE,
               null, null, null);
       if(jwb == JOptionPane.YES_OPTION ){
        try {
            destoryData();
            lsDtMhs();
            clearForm();
            cUbah.setEnabled(false);
            cHapus.setEnabled(false);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(fMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       }
    }//GEN-LAST:event_cHapusActionPerformed

    private void cTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTutupActionPerformed
        if(cTutup.getText().equals("Tutup")){
        int opsi = JOptionPane.showOptionDialog(this, "Yakin akan Menutup Form?", "Konfirmasi Tutup Form", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if(opsi == JOptionPane.YES_OPTION){
           System.exit(0);
        }
    }else{
            cTutup.setText("Tutup");
            cBaru.setText("Baru");
            cUbah.setText("Ubah");
               
            fieldEnabled(false);
            
            }
    }//GEN-LAST:event_cTutupActionPerformed

    private void tmhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmhsMouseClicked
        txNIM.setText(tmhs.getValueAt(tmhs.getSelectedRow(), 1).toString() );
        txNAMA.setText(tmhs.getValueAt(tmhs.getSelectedRow(), 0).toString() );
        String jkx =(tmhs.getValueAt(tmhs.getSelectedRow(), 2).toString().equals("L"))?"Laki-Laki":"Perempuan";
        txJK.setText(jkx);
        txPRODI.setText(tmhs.getValueAt(tmhs.getSelectedRow(), 3).toString() );
        cUbah.setEnabled(true);
        cHapus.setEnabled(true);
    }//GEN-LAST:event_tmhsMouseClicked

    private void cBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBaruActionPerformed
       if (cBaru.getText().equals("Baru")){
           cBaru.setText("Simpan");
           cTutup.setText("Batal");
           cUbah.setEnabled(false);
           cHapus.setEnabled(false); 
           clearForm();
           fieldEnabled(true);
       }else{
           if(!txNIM.getText().equals("")){
               try {   
                   storeData();
                   lsDtMhs();
               } catch (SQLException ex) {
                   java.util.logging.Logger.getLogger(fMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
               }
           }
        cBaru.setText("Baru");
        cTutup.setText("Tutup");
         clearForm();
           fieldEnabled(false);
    }//GEN-LAST:event_cBaruActionPerformed
    }
    /**
     * @param args the command line arguments
     */
  
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
            java.util.logging.Logger.getLogger(fMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new fMahasiswa().setVisible(true);
                } catch (SQLException ex) {
                    //ogger.getLogger(fMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cBaru;
    private javax.swing.JButton cHapus;
    private javax.swing.JButton cTutup;
    private javax.swing.JButton cUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tmhs;
    private javax.swing.JTextField txJK;
    private javax.swing.JTextField txNAMA;
    private javax.swing.JTextField txNIM;
    private javax.swing.JTextField txPRODI;
    // End of variables declaration//GEN-END:variables

    

}