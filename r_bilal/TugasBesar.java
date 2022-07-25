/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugas.besar;

import java.security.NoSuchAlgorithmException;  
import java.security.MessageDigest;  
/**
 *
 * @author Roan
 */
public class TugasBesar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        frm_mahasiswa mhs = new frm_mahasiswa();
        mhs.setVisible(true);
        
        f_mahasiswa_nilai mhas = new f_mahasiswa_nilai();
        mhas.Combo_mahasiswa();
        mhas.Combo_matakuliah();
        mhas.setVisible(true);
//        frm_login login = new frm_login();
//        login.setVisible(true);
        

    }  
    
}

