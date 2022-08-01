package kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113;

import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

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
        btn_daftar = new javax.swing.JButton();
        btn_kembali = new javax.swing.JButton();
        txt_password1 = new javax.swing.JPasswordField();
        txt_password2 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel2.setText("Nama Pengguna");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel3.setText("Masukan Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, -1));

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        jLabel4.setText("Masukan Kembali Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        txt_username.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_usernameKeyTyped(evt);
            }
        });
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 141, -1));

        btn_daftar.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        btn_daftar.setText("Daftar");
        btn_daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daftarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_daftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, -1, -1));

        btn_kembali.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        btn_kembali.setText("Kembali");
        btn_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(btn_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, -1, -1));

        txt_password1.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        txt_password1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_password1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_password1KeyTyped(evt);
            }
        });
        getContentPane().add(txt_password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 142, -1));

        txt_password2.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        txt_password2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_password2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_password2KeyTyped(evt);
            }
        });
        getContentPane().add(txt_password2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 142, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113/icon/register.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daftarActionPerformed
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
                if(txt_username.getText().length() <= 3){
                    JOptionPane.showMessageDialog(null,"username minimal 4 karakter");
                }else if(password1.length() <= 3){
                    JOptionPane.showMessageDialog(null, "password minimal 4 karakter");
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
        }
    }//GEN-LAST:event_btn_daftarActionPerformed

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        dispose();
        frm_login login = new frm_login();
        login.setVisible(true);
    }//GEN-LAST:event_btn_kembaliActionPerformed

    private void txt_password1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_password1KeyPressed
        // TODO add your handling code here:
//        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
//            btn_login.doClick();
//        }
    }//GEN-LAST:event_txt_password1KeyPressed

    private void txt_password2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_password2KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            btn_daftar.doClick();
        }
    }//GEN-LAST:event_txt_password2KeyPressed

    private void txt_password1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_password1KeyTyped
        String password1 = String.valueOf(txt_password1.getPassword());
        if(password1.length()>=10) {  
            evt.consume();
        }
    }//GEN-LAST:event_txt_password1KeyTyped

    private void txt_usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyTyped
        if( txt_username.getText().length()>=10 ) {  
            evt.consume();
        }
    }//GEN-LAST:event_txt_usernameKeyTyped

    private void txt_password2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_password2KeyTyped
        String password2 = String.valueOf(txt_password2.getPassword());
        if(password2.length()>=10) {  
            evt.consume();
        }
    }//GEN-LAST:event_txt_password2KeyTyped

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_daftar;
    private javax.swing.JButton btn_kembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txt_password1;
    private javax.swing.JPasswordField txt_password2;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
