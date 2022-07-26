package kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class frm_register extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver,database,user,pass;
    
    public frm_register() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        
        txt_username.setText("");
        txt_password1.setText("");
        txt_password2.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txt_password1 = new javax.swing.JPasswordField();
        txt_password2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel2.setText("Nama Pengguna");

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel3.setText("Masukan Password");

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel4.setText("Masukan Kembali Password");

        txt_username.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N

        jButton1.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jButton1.setText("Daftar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jButton2.setText("Kembali");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txt_password1.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        txt_password1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_password1KeyPressed(evt);
            }
        });

        txt_password2.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        txt_password2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_password2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jButton1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jButton2)
                                .addGap(54, 54, 54))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_password2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_password1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_password1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_password2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String password1 = String.valueOf(txt_password1.getPassword()); 
        String password2 = String.valueOf(txt_password2.getPassword());
        String pass_encrypsi1 = null;  
        
        try{  
            MessageDigest m = MessageDigest.getInstance("MD5");  
            m.update(password1.getBytes());  
            byte[] bytes = m.digest();  
            StringBuilder s = new StringBuilder();  
            for(int i=0; i< bytes.length ;i++){  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }  
            pass_encrypsi1 = s.toString();  
        } catch(NoSuchAlgorithmException e){  
            e.printStackTrace();  
        }  
          
        if(txt_username.getText().isEmpty() || password1.isEmpty() || password2.isEmpty()){
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong, Silahkan Lengkapi :> ");
            txt_username.requestFocus();
        } else {
            if(!(Arrays.equals(txt_password1.getPassword(), txt_password2.getPassword()))){
                JOptionPane.showMessageDialog(null, "Password tidak sama, silahkan periksa kembali");
            } else {
                try{
                    Class.forName(driver);
                    Connection kon =  DriverManager.getConnection(database,user,pass);
                    Statement stt = kon.createStatement();
                    String SQL = "INSERT INTO user(username,password) VALUES "
                            +"('"+txt_username.getText()+"',"
                            +"'"+pass_encrypsi1+"')";
                    stt.executeUpdate(SQL);
                    stt.close();
                    kon.close();
                    JOptionPane.showMessageDialog(null, "Registrasi berhasil, Silahkan login menggunakan akun anda");
                    dispose();
                    frm_login login = new frm_login();
                    login.setVisible(true);
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Data dengan username : "+txt_username.getText()+" sudah terdaftar");
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        frm_login login = new frm_login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_password1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_password1KeyPressed
        // TODO add your handling code here:
//        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
//            btn_login.doClick();
//        }
    }//GEN-LAST:event_txt_password1KeyPressed

    private void txt_password2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_password2KeyPressed

    }//GEN-LAST:event_txt_password2KeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txt_password1;
    private javax.swing.JPasswordField txt_password2;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
