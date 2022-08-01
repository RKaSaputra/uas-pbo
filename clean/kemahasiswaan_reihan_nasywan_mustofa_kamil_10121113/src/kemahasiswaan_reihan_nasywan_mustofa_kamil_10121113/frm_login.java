package kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113.frm_utama;

public class frm_login extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver,database,user,pass, sql;
    ResultSet rs;
    int inputtime = 0;
    public frm_login() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        
        jCheckBox1.setVisible(false);
        
        addplaceholder(txt_username);
        addplaceholder(txt_password);
    }
    
    public void addplaceholder(JTextField textField){
        Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.gray);
    }
    
    public void removeplaceholder(JTextField textField){
        Font font = textField.getFont();
        font = font.deriveFont(Font.PLAIN|Font.BOLD);
        textField.setFont(font);
        textField.setForeground(Color.black);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_username = new javax.swing.JTextField();
        btn_login = new javax.swing.JButton();
        btn_register = new javax.swing.JButton();
        txt_password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        txt_username.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        txt_username.setText("Username");
        txt_username.setBorder(null);
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });

        btn_login.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        btn_login.setText("Masuk");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        btn_register.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        btn_register.setText("Daftar");
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });

        txt_password.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        txt_password.setText("Password");
        txt_password.setBorder(null);
        txt_password.setEchoChar('\u0000');
        txt_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_passwordFocusLost(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113/icon/login.png"))); // NOI18N

        jCheckBox1.setHideActionText(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(btn_register))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(btn_login))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(469, 469, 469)
                .addComponent(jCheckBox1))
            .addComponent(jLabel4)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jCheckBox1))
            .addComponent(jLabel4)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        String password = String.valueOf(txt_password.getPassword());
        String pass_encrypsi = null;
        try{
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            pass_encrypsi = s.toString();
        } catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        try{
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement st=kon.createStatement();
            sql = "SELECT * FROM user Where username='"+txt_username.getText()+"' AND password='"+pass_encrypsi+"'";
            rs = st.executeQuery(sql);
            if(rs.next()){
                if(txt_username.getText().equals(rs.getString("username")) && pass_encrypsi.equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "Berhasil Masuk");
                    frm_utama utama = new frm_utama();
                    utama.setVisible(true);
                    dispose();
                }
            }else{
                JOptionPane.showMessageDialog(null, "username dan password tidak ditemukan, silahkan daftar");
                inputtime = inputtime + 1;
                if (inputtime == 3){
                    JOptionPane.showMessageDialog(null, "Aplikasi akan keluar. karena, anda sudah salah memasukan username dan password sebanyak 3x");
                    dispose();
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Username atau password tidak boleh kosong");
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            btn_login.doClick();
        }
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        frm_register reg = new frm_register();
        reg.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_registerActionPerformed

    private void txt_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passwordFocusGained
        if(txt_password.getText().equals("Password")){
            txt_password.setText(null);
            txt_password.requestFocus();
            txt_password.setEchoChar('*');
            removeplaceholder(txt_password);
        }
    }//GEN-LAST:event_txt_passwordFocusGained

    private void txt_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passwordFocusLost
        if(txt_password.getText().length()==0){
            addplaceholder(txt_password);
            txt_password.setText("Password");
            txt_password.setEchoChar('\u0000');
        }
    }//GEN-LAST:event_txt_passwordFocusLost

    private void txt_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusGained
        if(txt_username.getText().equals("Username")){
            txt_username.setText(null);
            txt_username.requestFocus();
            removeplaceholder(txt_username);
        }
    }//GEN-LAST:event_txt_usernameFocusGained

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
        if(txt_username.getText().length()==0){
            addplaceholder(txt_username);
            txt_username.setText("Username");
        }
    }//GEN-LAST:event_txt_usernameFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        this.requestFocusInWindow();
    }//GEN-LAST:event_formWindowGainedFocus

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_register;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
