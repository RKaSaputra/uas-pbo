package kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class frm_mahasiswa_nilai extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver,database,user,pass;
    Object table;
    
    
    
        
    
//    public void nilai_absen(){
//        nilai_absen = (((jumlah_pertemuan/14)*100*5)/100);
//        return nilai_absen;
//    }
//    
//    public void nilai_tugas(){
//        nilai_tugas = ((tugas1 + tugas2 + tugas3/3)*(25/100));
//    }
//    
//    public void nilai_uts(){
//        nilai_uts = uts*(30/100);
//    }
//    
//    public void nilai_uas(){
//        nilai_uas = uas*(30/100);
//    }
//    
//    public void nilai_akhir(){
//        nilai_akhir = nilai_absen + nilai_tugas + nilai_uts + nilai_uas;
//    }
//    
//    public void index(){
//        if(nilai_akhir > 80){
//            index = A;
//        }else if(nilai_akhir ){
//            
//        }
//    }
//    
//    public void keterangan(){
//        if(index = A) OR (index = B) OR (index = C){
//        keterangan = "lulus";
//        } else if(index = D) OR (index = E){
//        keterangan = "Tidak Lulus";
//        } else if(absensi < 11){
//        keterangan = "Tidak Lulus";        
//        }
//    }
    
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
        nonaktif_teks();
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
        btn_simpan.setEnabled(false);
        btn_batal.setEnabled(false);
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
            Connection kon = DriverManager.getConnection(
                                database,
                                user,
                                pass);
            
            Statement stt = kon.createStatement();
            String SQL = "select nama, nama_mk, kehadiran, tugas_1, tugas_2, tugas_3, uts, uas from mahasiswa_nilai";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next()){
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);
                data[5] = res.getString(6);
                data[6] = res.getString(7);
                data[7] = res.getString(8);
                tableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(),"Error",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    private void caridata(String key){
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
    
    public void lebar_column(){
        table_mahasiswa_nilai.getColumnModel().getColumn(0).setPreferredWidth(100);
        table_mahasiswa_nilai.getColumnModel().getColumn(1).setPreferredWidth(100);
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
        table_mahasiswa_nilai.getColumnModel().getColumn(13).setPreferredWidth(30);
        table_mahasiswa_nilai.getColumnModel().getColumn(14).setPreferredWidth(30);
        
        
    }
    
    public void membersihkan_teks(){
        txt_nim.setText("");
        txt_nama.setSelectedIndex(0);
        txt_kode_mk.setText("");
        txt_nama_mk.setSelectedIndex(0);
        txt_kehadiran.setText("");
        txt_tugas1.setText("");
        txt_tugas2.setText("");
        txt_tugas3.setText("");
        txt_uts.setText("");
        txt_uas.setText("");
        txt_angkatan.setText("");
    }
    
    public void nonaktif_teks(){
        txt_nim.setEnabled(false);
        txt_nama.setEnabled(false);
        txt_kode_mk.setEnabled(false);
        txt_nama_mk.setEnabled(false);
        txt_kehadiran.setEnabled(false);
        txt_tugas1.setEnabled(false);
        txt_tugas2.setEnabled(false);
        txt_tugas3.setEnabled(false);
        txt_uts.setEnabled(false);
        txt_uas.setEnabled(false);
        txt_angkatan.setEnabled(false);
    }
    public void aktif_teks(){
        txt_nim.setEnabled(true);
        txt_nama.setEnabled(true);
        txt_kode_mk.setEnabled(true);
        txt_nama_mk.setEnabled(true);
        txt_kehadiran.setEnabled(true);
        txt_tugas1.setEnabled(true);
        txt_tugas2.setEnabled(true);
        txt_tugas3.setEnabled(true);
        txt_uts.setEnabled(true);
        txt_uas.setEnabled(true);
        txt_angkatan.setEnabled(true);
    }
    
    int row = 0;
    public void tampil_field(){
        try{
            String SQL="select * from Mahasiswa_nilai";
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            ResultSet res = stt.executeQuery(SQL);
            String nim = txt_nim.getText();
            txt_nim.setText(res.getString(nim));
            
            
            
            
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
        
//        txt_nama.setText(tableModel.getValueAt(row, 1).toString());
//        txt_kode_mk.setText(tableModel.getValueAt(row, 2).toString());
////        txt_nama_mk.setText(tableModel.getValueAt(row, 3).toString());
//        txt_kehadiran.setText(tableModel.getValueAt(row, 4).toString());
//        txt_tugas1.setText(tableModel.getValueAt(row, 5).toString());
//        txt_tugas2.setText(tableModel.getValueAt(row, 6).toString());
//        txt_tugas3.setText(tableModel.getValueAt(row, 7).toString());
//        txt_uts.setText(tableModel.getValueAt(row, 8).toString());
//        txt_uas.setText(tableModel.getValueAt(row, 9).toString());
//        txt_angkatan.setText(tableModel.getValueAt(row, 10).toString());
            btn_simpan.setEnabled(false);
            btn_ubah.setEnabled(true);
            btn_hapus.setEnabled(true);
            btn_batal.setEnabled(true);
            btn_keluar.setEnabled(true);
            aktif_teks();
//        
        
    }
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
        }catch (Exception ex){
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
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
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
        txt_kode_mk = new javax.swing.JTextField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Franklin Gothic Medium", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        jLabel1.setText("FORM NILAI MAHASISWA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(418, 418, 418))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31))
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

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel12.setText("UTS");

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel13.setText("Angkatan");

        jLabel14.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel14.setText("UAS");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 530, Short.MAX_VALUE)
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
                            .addComponent(txt_kode_mk, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_angkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
                            .addComponent(txt_kode_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaActionPerformed
        
    }//GEN-LAST:event_txt_namaActionPerformed

    private void txt_nama_mkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nama_mkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nama_mkActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        membersihkan_teks();
        txt_nim.requestFocus();
        btn_simpan.setEnabled(true);
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
        btn_keluar.setEnabled(false);
        btn_batal.setEnabled(true);
        aktif_teks();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        String nim = txt_nim.getText();
        String nama = txt_nama.getSelectedItem().toString();
        String kode_mk = txt_kode_mk.getText();
        String nama_mk = txt_nama_mk.getSelectedItem().toString();
        String kehadiran = txt_kehadiran.getText();
        String tugas1 = txt_tugas1.getText();
        String tugas2 = txt_tugas2.getText();
        String tugas3 = txt_tugas3.getText();
        String uts = txt_uts.getText();
        String uas = txt_uas.getText();
        String angkatan = txt_angkatan.getText();
        
        if((nim.isEmpty()) | (kode_mk.isEmpty())){
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
            txt_nim.requestFocus();
        }else{
            try{
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL = "UPDATE 'mahasiswa_nilai'" 
                            + "SET 'nim' = '"+nim+"'," 
                            + "'nama' = '"+nama+"',"
                            + "'no_mk' = '"+kode_mk+"',"
                            + "'nama_mk' = '"+nama_mk+"',"
                            + "'kehadiran' = '"+kehadiran+"',"
                            + "'tugas1' = '"+tugas1+"',"
                            + "'tugas2' = '"+tugas2+"',"
                            + "'tugas3' = '"+tugas3+"',"
                            + "'uts' = '"+uts+"',"
                            + "'uas' = '"+uas+"',"
                            + "'angkatan' = '"+angkatan+"' "
                            + "WHERE "
                            + "'nim'='"+tableModel.getValueAt(row, 0).toString()+"';";
                stt.executeUpdate(SQL);
                data[0] = nim;
                data[1] = nama;
                data[2] = kode_mk;
                data[3] = nama_mk;
                data[4] = kehadiran;
                data[5] = tugas1;
                data[6] = tugas2;
                data[7] = tugas3;
                data[8] = uts;
                data[9] = uas;
                data[10] = angkatan;
                tableModel.removeRow(row);
                tableModel.insertRow(row, data);
                stt.close();
                kon.close();
                membersihkan_teks();
                btn_simpan.setEnabled(false);
                nonaktif_teks();
            }
            catch (Exception ex){
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String  SQL = "Delete From mahasiswa_nilai "
                            +"WHERE "
                            +"id='"+tableModel.getValueAt(row, 0).toString()+"'";
            stt.executeUpdate(SQL);
            tableModel.removeRow(row);
            stt.close();
            kon.close(); 
            membersihkan_teks();
        }
        catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        String data[]=new String[11];
        
        if ((txt_nim.getText().isEmpty()) || (txt_kode_mk.getText().isEmpty())){
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
            txt_nim.requestFocus();
        }else{
            try{
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO mahasiswa_nilai(nim,nama,no_mk,nama_mk,kehadiran,tugas_1,tugas_2,tugas_3,uts,uas,angkatan) VALUES "
                            + "( '"+txt_nim.getText()+"',"
                            + " '"+txt_nama.getSelectedItem().toString()+"',"
                            + " '"+txt_kode_mk.getText()+"',"
                            + " '"+txt_nama_mk.getSelectedItem().toString()+"',"
                            + " '"+txt_kehadiran.getText()+"',"
                            + " '"+txt_tugas1.getText()+"',"
                            + " '"+txt_tugas2.getText()+"',"
                            + " '"+txt_tugas3.getText()+"',"
                            + " '"+txt_uts.getText()+"',"
                            + " '"+txt_uas.getText()+"',"
                            + " '"+txt_angkatan.getText()+" ')";
                
                stt.executeUpdate(SQL);
                data[0] = txt_nama.getSelectedItem().toString();
                data[1] = txt_nama_mk.getSelectedItem().toString();
                data[2] = txt_kehadiran.getText();
                data[3] = txt_tugas1.getText();
                data[4] = txt_tugas2.getText();
                data[5] = txt_tugas3.getText();
                data[6] = txt_uts.getText();
                data[7] = txt_uas.getText();
                tableModel.insertRow(0, data);
                
                stt.close();
                kon.close();
                membersihkan_teks();
                btn_simpan.setEnabled(false);
                btn_batal.setEnabled(false);
                btn_keluar.setEnabled(true);
                nonaktif_teks();
                
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah");
            }   
            catch (Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        membersihkan_teks();
        nonaktif_teks();
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
        btn_simpan.setEnabled(false);
        btn_batal.setEnabled(false);
        btn_keluar.setEnabled(true);
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void txt_nimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nimActionPerformed

    private void table_mahasiswa_nilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_mahasiswa_nilaiMouseClicked
        if(evt.getClickCount() == 1){
            tampil_field();
        }
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
        membersihkan_teks();
        nonaktif_teks();
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
                txt_kode_mk.setText(no_mk);
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txt_nama_mkPopupMenuWillBecomeInvisible

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        String key = txt_search.getText();
        
        if(key!=""){
            caridata(key);
        }else{
            settableload();
        }
    }//GEN-LAST:event_txt_searchKeyReleased

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

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
            java.util.logging.Logger.getLogger(frm_mahasiswa_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_mahasiswa_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_mahasiswa_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_mahasiswa_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
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
    private javax.swing.JTable table_mahasiswa_nilai;
    private javax.swing.JTextField txt_angkatan;
    private javax.swing.JTextField txt_kehadiran;
    private javax.swing.JTextField txt_kode_mk;
    private javax.swing.JComboBox<String> txt_nama;
    private javax.swing.JComboBox<String> txt_nama_mk;
    private javax.swing.JTextField txt_nim;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_tugas1;
    private javax.swing.JTextField txt_tugas2;
    private javax.swing.JTextField txt_tugas3;
    private javax.swing.JTextField txt_uas;
    private javax.swing.JTextField txt_uts;
    // End of variables declaration//GEN-END:variables
}
