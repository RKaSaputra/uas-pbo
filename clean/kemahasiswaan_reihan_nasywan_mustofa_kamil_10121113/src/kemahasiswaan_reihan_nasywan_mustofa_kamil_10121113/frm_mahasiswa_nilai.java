 package kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class frm_mahasiswa_nilai extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver,database,user,pass;
    Object table;
    
    public frm_mahasiswa_nilai() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        
        table_mahasiswa_nilai.setModel(tableModel);
        
        Combo_mahasiswa();
        Combo_matakuliah();
        lebar_column();        
        
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
        btn_simpan.setEnabled(false);
        btn_batal.setEnabled(false);
        disabled_text();
        settableload();
    }
   
    private javax.swing.table.DefaultTableModel tableModel=getDefaultTableModel();
    private javax.swing.table.DefaultTableModel getDefaultTableModel(){
        return new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String [] {"Nama",
                           "Nama MK",
                           "Absensi",
                           "Tgs 1",
                           "Tgs 2",
                           "Tgs 3",
                           "UTS",
                           "UAS",
                           "Nilai Absen",
                           "Nilai Tugas",
                           "Nilai UTS",
                           "Nilai UAS",
                           "Nilai Akhir",
                           "Index",
                           "Keterangan"}
        )
        {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
                    
            };
            
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit[columnIndex];
            }
        };        
    }   
    
    String data[]= new String[15];
    private void settableload(){
        String stat = "";
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "select * from mahasiswa_nilai";
            ResultSet res = stt.executeQuery(SQL);
            
            while(res.next()){
                data[0] = res.getString(3);
                data[1] = res.getString(5);
                data[2] = res.getString(6);
                data[3] = res.getString(7);
                data[4] = res.getString(8);
                data[5] = res.getString(9);
                data[6] = res.getString(10);
                data[7] = res.getString(11);
                data[8] = res.getString(13);
                data[9] = res.getString(14);
                data[10] = res.getString(15);
                data[11] = res.getString(16);
                data[12] = res.getString(17);
                data[13] = res.getString(18);
                data[14] = res.getString(19);
                
                tableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    private void search(String key){
        tableModel.setRowCount(0);
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt=kon.createStatement();
            String SQL = "SELECT * from mahasiswa_nilai WHERE nim LIKE '%"+key+"%' OR nama LIKE '%"+key+"%'";
            ResultSet res = stt.executeQuery(SQL);
            
            while(res.next()){
                data[0] = res.getString(3);
                data[1] = res.getString(5);
                data[2] = res.getString(6);
                data[3] = res.getString(7);
                data[4] = res.getString(8);
                data[5] = res.getString(9);
                data[6] = res.getString(10);
                data[7] = res.getString(11);
                data[8] = res.getString(13);
                data[9] = res.getString(14);
                data[10] = res.getString(15);
                data[11] = res.getString(16);
                data[12] = res.getString(17);
                data[13] = res.getString(18);
                data[14] = res.getString(19);
                tableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    int row = 0;
    public void Combo_mahasiswa(){
        try{
            String SQL="select * from Mahasiswa";
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            ResultSet res = stt.executeQuery(SQL);
            
            while(res.next()){
                String nama = res.getString("nama");
                txt_nama.addItem(nama);
            }
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void Combo_matakuliah(){
        try{
            String SQL="select * from mata_kuliah";
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            ResultSet res = stt.executeQuery(SQL);
            
            while(res.next()){
                String nama_mk = res.getString("nama_mk");
                txt_nama_mk.addItem(nama_mk);
            }
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void lebar_column(){
        table_mahasiswa_nilai.getColumnModel().getColumn(0).setPreferredWidth(80);
        table_mahasiswa_nilai.getColumnModel().getColumn(1).setPreferredWidth(80);
        table_mahasiswa_nilai.getColumnModel().getColumn(2).setPreferredWidth(40);
        table_mahasiswa_nilai.getColumnModel().getColumn(3).setPreferredWidth(25);
        table_mahasiswa_nilai.getColumnModel().getColumn(4).setPreferredWidth(25);
        table_mahasiswa_nilai.getColumnModel().getColumn(5).setPreferredWidth(25);
        table_mahasiswa_nilai.getColumnModel().getColumn(6).setPreferredWidth(25);
        table_mahasiswa_nilai.getColumnModel().getColumn(7).setPreferredWidth(25);
        table_mahasiswa_nilai.getColumnModel().getColumn(8).setPreferredWidth(30);
        table_mahasiswa_nilai.getColumnModel().getColumn(9).setPreferredWidth(30);
        table_mahasiswa_nilai.getColumnModel().getColumn(10).setPreferredWidth(30);
        table_mahasiswa_nilai.getColumnModel().getColumn(11).setPreferredWidth(30);
        table_mahasiswa_nilai.getColumnModel().getColumn(12).setPreferredWidth(30);
        table_mahasiswa_nilai.getColumnModel().getColumn(13).setPreferredWidth(10);
        table_mahasiswa_nilai.getColumnModel().getColumn(14).setPreferredWidth(50);  
    }
    
    public void enabled_text(){
        txt_nim.setEnabled(false);
        txt_nama.setEnabled(true);
        txt_no_mk.setEnabled(false);
        txt_nama_mk.setEnabled(true);
        txt_kehadiran.setEnabled(true);
        txt_tugas1.setEnabled(true);
        txt_tugas2.setEnabled(true);
        txt_tugas3.setEnabled(true);
        txt_uts.setEnabled(true);
        txt_uas.setEnabled(true);
        txt_angkatan.setEnabled(false);
    }
    
    public void disabled_text(){
        txt_nim.setEnabled(false);
        txt_nama.setEnabled(false);
        txt_no_mk.setEnabled(false);
        txt_nama_mk.setEnabled(false);
        txt_kehadiran.setEnabled(false);
        txt_tugas1.setEnabled(false);
        txt_tugas2.setEnabled(false);
        txt_tugas3.setEnabled(false);
        txt_uts.setEnabled(false);
        txt_uas.setEnabled(false);
        txt_angkatan.setEnabled(false);
    }
    
    public void clear_text(){
        txt_nim.setText("");
        txt_nama.setSelectedIndex(0);
        txt_no_mk.setText("");
        txt_nama_mk.setSelectedIndex(0);
        txt_kehadiran.setText("");
        txt_tugas1.setText("");
        txt_tugas2.setText("");
        txt_tugas3.setText("");
        txt_uts.setText("");
        txt_uas.setText("");
        txt_angkatan.setText("2021");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_nama_mk = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_nim = new javax.swing.JTextField();
        txt_kehadiran = new javax.swing.JTextField();
        txt_tugas1 = new javax.swing.JTextField();
        txt_tugas2 = new javax.swing.JTextField();
        txt_tugas3 = new javax.swing.JTextField();
        txt_no_mk = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_uts = new javax.swing.JTextField();
        txt_uas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_mahasiswa_nilai = new javax.swing.JTable();
        btn_tambah = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        txt_angkatan = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Franklin Gothic Medium", 0, 12)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        jLabel1.setText("FORM NILAI MAHASISWA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(467, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(461, 461, 461))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel3.setText("Masukkan Data");

        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel4.setText("Nama");

        txt_nama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        txt_nama.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                txt_namaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        txt_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel5.setText("Nama Mata Kuliah");

        txt_nama_mk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        txt_nama_mk.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                txt_nama_mkPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        txt_nama_mk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nama_mkActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel6.setText("NIM");

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel7.setText("Kehadiran");

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel8.setText("Tugas 1");

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel9.setText("Tugas 2");

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel10.setText("Tugas 3");

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel11.setText("Kode MK");

        txt_nim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nimActionPerformed(evt);
            }
        });

        txt_kehadiran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_kehadiranKeyTyped(evt);
            }
        });

        txt_tugas1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tugas1KeyTyped(evt);
            }
        });

        txt_tugas2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tugas2KeyTyped(evt);
            }
        });

        txt_tugas3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tugas3KeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel12.setText("UTS");

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel13.setText("Angkatan");

        jLabel14.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel14.setText("UAS");

        txt_uts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_utsKeyTyped(evt);
            }
        });

        txt_uas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_uasKeyTyped(evt);
            }
        });

        table_mahasiswa_nilai.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 12)); // NOI18N
        table_mahasiswa_nilai.setModel(new javax.swing.table.DefaultTableModel(
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
        table_mahasiswa_nilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_mahasiswa_nilaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_mahasiswa_nilai);

        btn_tambah.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        btn_tambah.setText("TAMBAH");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_ubah.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        btn_ubah.setText("UBAH");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });

        btn_hapus.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_simpan.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        btn_simpan.setText("SIMPAN");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_batal.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        btn_batal.setText("BATAL");
        btn_batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_batalMouseClicked(evt);
            }
        });
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        btn_keluar.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        btn_keluar.setText("KELUAR");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        txt_angkatan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_angkatanKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_kehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_uas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_uts, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nama_mk, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_no_mk, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_angkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_kehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_nama_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_no_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txt_uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_angkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaActionPerformed
        
    }//GEN-LAST:event_txt_namaActionPerformed

    private void txt_nama_mkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nama_mkActionPerformed

    }//GEN-LAST:event_txt_nama_mkActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        txt_nim.requestFocus();
        
        btn_simpan.setEnabled(true);
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
        btn_keluar.setEnabled(false);
        btn_batal.setEnabled(true);
        enabled_text();
        clear_text();
        txt_search.setEnabled(false);
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        String nim = txt_nim.getText();
        String nama = txt_nama.getSelectedItem().toString();
        String kode_mk = txt_no_mk.getText();
        String nama_mk = txt_nama_mk.getSelectedItem().toString();
        String kehadiran = txt_kehadiran.getText();
        String tugas1 = txt_tugas1.getText();
        String tugas2 = txt_tugas2.getText();
        String tugas3 = txt_tugas3.getText();
        String uts = txt_uts.getText();
        String uas = txt_uas.getText();
        String angkatan = txt_angkatan.getText();
        
        int selectedRow = table_mahasiswa_nilai.getSelectedRow();
        

        
        if((txt_kehadiran.getText().isEmpty()) || (txt_tugas1.getText().isEmpty()) || (txt_tugas2.getText().isEmpty()) || (txt_tugas3.getText().isEmpty()) || (txt_uts.getText().isEmpty()) ||(txt_uas.getText().isEmpty()) ){
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
            txt_nim.requestFocus();
        }else{
            try{
                int I_kehadiran = Integer.parseInt(txt_kehadiran.getText());
                int I_tugas1 = Integer.parseInt(txt_tugas1.getText());
                int I_tugas2 = Integer.parseInt(txt_tugas2.getText());
                int I_tugas3 = Integer.parseInt(txt_tugas3.getText());
                int I_uts = Integer.parseInt(txt_uts.getText());
                int I_uas = Integer.parseInt(txt_uas.getText());

                double n_absen = ((I_kehadiran/14)*100*5)/100;
                double n_tugas = (((I_tugas1+I_tugas2+I_tugas3)/3)*0.25);
                double n_uts =  I_uts*0.30;
                double n_uas = I_uas*0.40;
                double n_akhir = n_absen+n_tugas+n_uts+n_uas;

                String index = "";

                if(n_akhir>=80){
                    index = "A";
                } else if(n_akhir>=68 && n_akhir<=79){
                    index = "B";
                } else if(n_akhir>=56 && n_akhir<=67){
                    index = "C";
                } else if(n_akhir>=45 && n_akhir<=55){
                    index = "D";
                } else {
                    index = "E";
                } 

                String ket = "";
                if(I_kehadiran<11){
                    ket = "TIDAK LULUS";
                }else if (index == "A" || index == "B" || index == "C"){
                    ket = "LULUS";
                } else if(index == "D" || index == "E" ){
                    ket = "TIDAK LULUS";
                } 
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL = "UPDATE `mahasiswa_nilai` "
                        + "SET `nim` = '"+nim+"', "
                        + "`nama` = '"+nama+"', "
                        + "`no_mk` = '"+kode_mk+"', "
                        + "`nama_mk` = '"+nama_mk+"', "
                        + "`kehadiran` = '"+kehadiran+"', "
                        + "`tugas_1` = '"+tugas1+"', "
                        + "`tugas_2` = '"+tugas2+"', "
                        + "`tugas_3` = '"+tugas3+"', "
                        + "`uts` = '"+uts+"', "
                        + "`uas` = '"+uas+"', "
                        + "`angkatan` = '"+angkatan+"', "
                        + "`nilai_absen` = '"+String.format("%.2f",n_absen)+"', "
                        + "`nilai_tugas` = '"+String.format("%.2f",n_tugas)+"', "
                        + "`nilai_uts` = '"+String.format("%.2f",n_uts)+"', "
                        + "`nilai_uas` = '"+String.format("%.2f",n_uas)+"', "
                        + "`nilai_akhir` = '"+String.format("%.2f",n_akhir)+"', "
                        + "`index` = '"+index+"', "
                        + "`keterangan` = '"+ket+"'"
                        + " WHERE `mahasiswa_nilai`.`nim` = "+nim+" "
                        + "AND `mahasiswa_nilai`.`no_mk` = '"+kode_mk+"';";
                stt.executeUpdate(SQL);
                data[0] = nama;
                data[1] = nama_mk;
                data[2] = kehadiran;
                data[3] = tugas1;
                data[4] = tugas2;
                data[5] = tugas3;
                data[6] = uts;
                data[7] = uas;
                data[8] = String.format("%.2f",n_absen);
                data[9] = String.format("%.2f",n_tugas);
                data[10] = String.format("%.2f",n_uts);
                data[11] = String.format("%.2f",n_uas);
                data[12] = String.format("%.2f",n_akhir);
                data[13] = String.valueOf(index);
                data[14] = String.valueOf(ket);
                
                tableModel.removeRow(selectedRow);
                tableModel.insertRow(selectedRow, data);
                
                btn_tambah.setEnabled(true);
                btn_ubah.setEnabled(false);
                btn_hapus.setEnabled(false);
                btn_simpan.setEnabled(false);
                btn_batal.setEnabled(false);
                btn_keluar.setEnabled(true);
                disabled_text();
                clear_text();
                stt.close();
                kon.close();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                txt_search.setEnabled(true);
            } catch(Exception ex){
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int selectedRow = table_mahasiswa_nilai.getSelectedRow();

        String nim = txt_nim.getText();
        String kode_mk = txt_no_mk.getText();
        
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String  SQL = "DELETE FROM `mahasiswa_nilai` "
                        + " WHERE `mahasiswa_nilai`.`nim` = "+nim+" "
                        + "AND `mahasiswa_nilai`.`no_mk` = '"+kode_mk+"';";
            
            stt.executeUpdate(SQL);
            tableModel.removeRow(selectedRow);
            
            btn_tambah.setEnabled(true);
            btn_ubah.setEnabled(false);
            btn_hapus.setEnabled(false);
            btn_simpan.setEnabled(false);
            btn_batal.setEnabled(false);
            btn_keluar.setEnabled(true);
            disabled_text();
            clear_text();
            stt.close();
            kon.close(); 
            txt_search.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        String data[]=new String[15];
        
        
        
        
        
        
        
        if((txt_kehadiran.getText().isEmpty()) || (txt_tugas1.getText().isEmpty()) || (txt_tugas2.getText().isEmpty()) || (txt_tugas3.getText().isEmpty()) || (txt_uts.getText().isEmpty()) ||(txt_uas.getText().isEmpty()) ){
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong, Silahkan Lengkapi ");
        }else{
            int kehadiran = Integer.parseInt(txt_kehadiran.getText());
            int tugas1 = Integer.parseInt(txt_tugas1.getText());
            int tugas2 = Integer.parseInt(txt_tugas2.getText());
            int tugas3 = Integer.parseInt(txt_tugas3.getText());
            int uts = Integer.parseInt(txt_uts.getText());
            int uas = Integer.parseInt(txt_uas.getText());

            double n_absen = ((kehadiran/14)*100*5)/100;
            double n_tugas = (((tugas1+tugas2+tugas3)/3)*0.25);
            double n_uts =  uts*0.30;
            double n_uas = uas*0.40;
            double n_akhir = n_absen+n_tugas+n_uts+n_uas;
            if((kehadiran > 14) || (tugas1 > 100) || (tugas2 > 100) || (tugas3 > 100) || (uts > 100)  || (uas > 100)){
                JOptionPane.showMessageDialog(null, "Kehadiran Maksimal 14, nilai maksimal 100");
            }else {
                
                String index = "A";
        
                if(n_akhir>80){
                    index = "A";
                } else if(n_akhir>68 && n_akhir<79){
                    index = "B";
                } else if(n_akhir>56 && n_akhir<67){
                    index = "C";
                } else if(n_akhir>45 && n_akhir<55){
                    index = "D";
                } else {
                    index = "E";
                } 

                String ket = "Tidak Lulus";
                if(kehadiran<11){
                    ket = "TIDAK LULUS";
                }else if (index == "A" || index == "B" || index == "C"){
                    ket = "LULUS";
                } else if(index == "D" || index == "E" ){
                    ket = "TIDAK LULUS";
                } 
                try{
                    Class.forName(driver);
                    Connection kon = DriverManager.getConnection(database,user,pass);
                    Statement stt = kon.createStatement();
                    String SQL = "INSERT INTO mahasiswa_nilai(`nim`, `nama`, `no_mk`, `nama_mk`, `kehadiran`, `tugas_1`, `tugas_2`, `tugas_3`, `uts`, `uas`, `angkatan`, `nilai_absen`, `nilai_tugas`, `nilai_uts`, `nilai_uas`, `nilai_akhir`, `index`, `keterangan`) VALUES "                        
                                + "('"+txt_nim.getText()+"',"
                                + " '"+txt_nama.getSelectedItem().toString()+"',"
                                + " '"+txt_no_mk.getText()+"',"
                                + " '"+txt_nama_mk.getSelectedItem().toString()+"',"
                                + " '"+txt_kehadiran.getText()+"',"
                                + " '"+txt_tugas1.getText()+"',"
                                + " '"+txt_tugas2.getText()+"',"
                                + " '"+txt_tugas3.getText()+"',"
                                + " '"+txt_uts.getText()+"',"
                                + " '"+txt_uas.getText()+"',"
                                + " '"+txt_angkatan.getText()+"',"
                                + " '"+String.format("%.2f",n_absen)+"',"
                                + " '"+String.format("%.2f",n_tugas)+"',"
                                + " '"+String.format("%.2f",n_uts)+"',"
                                + " '"+String.format("%.2f",n_uas)+"',"
                                + " '"+String.format("%.2f",n_akhir)+"',"
                                + " '"+index+"',"
                                + " '"+ket+"');";

                    stt.executeUpdate(SQL);

                    data[0] = txt_nama.getSelectedItem().toString();
                    data[1] = txt_nama_mk.getSelectedItem().toString();
                    data[2] = txt_kehadiran.getText();
                    data[3] = txt_tugas1.getText();
                    data[4] = txt_tugas2.getText();
                    data[5] = txt_tugas3.getText();
                    data[6] = txt_uts.getText();
                    data[7] = txt_uas.getText();
                    data[8] = String.format("%.2f",n_absen);
                    data[9] = String.format("%.2f",n_tugas);
                    data[10] = String.format("%.2f",n_uts);
                    data[11] = String.format("%.2f",n_uas);
                    data[12] = String.format("%.2f",n_akhir);
                    data[13] = String.valueOf(index);
                    data[14] = String.valueOf(ket);

                    tableModel.insertRow(row, data);

                    btn_simpan.setEnabled(false);
                    btn_batal.setEnabled(false);
                    btn_keluar.setEnabled(true);
                    disabled_text();
                    clear_text();
                    stt.close();
                    kon.close();
                    
                    JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah");
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        btn_tambah.setEnabled(true);
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
        btn_simpan.setEnabled(false);
        btn_batal.setEnabled(false);
        btn_keluar.setEnabled(true);
        disabled_text();
        clear_text();
        txt_search.setEnabled(true);
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        frm_utama utama = new frm_utama();
        utama.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void txt_nimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nimActionPerformed

    }//GEN-LAST:event_txt_nimActionPerformed

    private void table_mahasiswa_nilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_mahasiswa_nilaiMouseClicked
        int selectedRow = table_mahasiswa_nilai.getSelectedRow();
        
        try{
            String nama =(table_mahasiswa_nilai.getModel().getValueAt(selectedRow,0).toString());
            
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            
            String SQLnm="select * from mahasiswa_nilai where nama='"+nama+"'";
            ResultSet res_nm = stt.executeQuery(SQLnm);
            if(res_nm.next()){
                String addnim=res_nm.getString("nim");
                txt_nim.setText(addnim);
                String addakt=res_nm.getString("angkatan");
                txt_angkatan.setText(addakt);
            }
            
            String nama_mk=(table_mahasiswa_nilai.getModel().getValueAt(selectedRow,1).toString());
            String SQLmk="select * from mahasiswa_nilai where nama_mk='"+nama_mk+"'";
            ResultSet res_mk = stt.executeQuery(SQLmk);
            if(res_mk.next()){
                String addmk=res_mk.getString("no_mk");
                txt_no_mk.setText(addmk);
            }
        } catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        
        String nama = tableModel.getValueAt(selectedRow, 0).toString();
        for (int i = 0; i < txt_nama.getItemCount(); i++){
            if(txt_nama.getItemAt(i).toString().equalsIgnoreCase(nama)){
                txt_nama.setSelectedIndex(i);
            }
        }
        
        String nama_mk = tableModel.getValueAt(selectedRow, 1).toString();
        for (int i = 0; i < txt_nama_mk.getItemCount(); i++){
            if(txt_nama_mk.getItemAt(i).toString().equalsIgnoreCase(nama_mk)){
                txt_nama_mk.setSelectedIndex(i);
            }
        }
        
        txt_kehadiran.setText(tableModel.getValueAt(selectedRow, 2).toString());
        txt_tugas1.setText(tableModel.getValueAt(selectedRow, 3).toString());
        txt_tugas2.setText(tableModel.getValueAt(selectedRow, 4).toString());
        txt_tugas3.setText(tableModel.getValueAt(selectedRow, 5).toString());
        txt_uts.setText(tableModel.getValueAt(selectedRow, 6).toString());
        txt_uas.setText(tableModel.getValueAt(selectedRow, 7).toString());        
                
        btn_tambah.setEnabled(false);
        btn_ubah.setEnabled(true);
        btn_hapus.setEnabled(true);
        btn_simpan.setEnabled(false);
        btn_batal.setEnabled(true);
        btn_keluar.setEnabled(false);
        enabled_text();
        txt_search.setEnabled(false);
    }//GEN-LAST:event_table_mahasiswa_nilaiMouseClicked

    private void txt_namaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_txt_namaPopupMenuWillBecomeInvisible
        String item = (String)txt_nama.getSelectedItem();
        String SQL = "select nim from mahasiswa where nama='"+item+"'";
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            ResultSet res = stt.executeQuery(SQL);
            
            if(res.next()){
                String nim = res.getString("nim");
                txt_nim.setText(nim);
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_txt_namaPopupMenuWillBecomeInvisible

    private void btn_batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_batalMouseClicked
        disabled_text();
        clear_text();
    }//GEN-LAST:event_btn_batalMouseClicked

    private void txt_nama_mkPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_txt_nama_mkPopupMenuWillBecomeInvisible
        String item = (String)txt_nama_mk.getSelectedItem();
        
        String SQL = "select no_mk from mata_kuliah where nama_mk='"+item+"'";
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            ResultSet res = stt.executeQuery(SQL);
            
            if(res.next()){
                String no_mk = res.getString("no_mk");
                txt_no_mk.setText(no_mk);
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txt_nama_mkPopupMenuWillBecomeInvisible

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        String key = txt_search.getText();
        
        if(key!=""){
            search(key);
        }else{
            settableload();
        }
    }//GEN-LAST:event_txt_searchKeyReleased

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed

    }//GEN-LAST:event_txt_searchActionPerformed

    private void txt_kehadiranKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_kehadiranKeyTyped
        if(txt_kehadiran.getText().length()>=2) {  
            evt.consume();
        }
    }//GEN-LAST:event_txt_kehadiranKeyTyped

    private void txt_tugas1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tugas1KeyTyped
        if(txt_tugas1.getText().length()>=3) {  
            evt.consume();
        }
    }//GEN-LAST:event_txt_tugas1KeyTyped

    private void txt_tugas2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tugas2KeyTyped
        if(txt_tugas2.getText().length()>=3) {  
            evt.consume();
        }
    }//GEN-LAST:event_txt_tugas2KeyTyped

    private void txt_tugas3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tugas3KeyTyped
        if(txt_tugas3.getText().length()>=3) {  
            evt.consume();
        }
    }//GEN-LAST:event_txt_tugas3KeyTyped

    private void txt_utsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_utsKeyTyped
        if(txt_uts.getText().length()>=3) {  
            evt.consume();
        }
    }//GEN-LAST:event_txt_utsKeyTyped

    private void txt_uasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_uasKeyTyped
        if(txt_uas.getText().length()>=3) {  
            evt.consume();
        }
    }//GEN-LAST:event_txt_uasKeyTyped

    private void txt_angkatanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_angkatanKeyTyped
        if(txt_angkatan.getText().length()>=4) {  
            evt.consume();
        }
    }//GEN-LAST:event_txt_angkatanKeyTyped

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_mahasiswa_nilai().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable table_mahasiswa_nilai;
    private javax.swing.JTextField txt_angkatan;
    private javax.swing.JTextField txt_kehadiran;
    private javax.swing.JComboBox<String> txt_nama;
    private javax.swing.JComboBox<String> txt_nama_mk;
    private javax.swing.JTextField txt_nim;
    private javax.swing.JTextField txt_no_mk;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_tugas1;
    private javax.swing.JTextField txt_tugas2;
    private javax.swing.JTextField txt_tugas3;
    private javax.swing.JTextField txt_uas;
    private javax.swing.JTextField txt_uts;
    // End of variables declaration//GEN-END:variables
}
