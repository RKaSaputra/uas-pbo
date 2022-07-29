package kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class frm_simulasi_nilai extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver,database,user,pass;
    Object table;
    
    public frm_simulasi_nilai() {
        initComponents();
        
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        
        table_simulasi_nilai.setModel(tableModel);
        
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
            new String [] {"Nama MK",
                           "Persentase Absen",
                           "Persentase Tugas",
                           "Persentase UTS",
                           "Persentase UAS",
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
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };
            
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit[columnIndex];
            }
        };
    }   
    
    String data[]= new String[18];
    private void settableload(){
        String stat = "";
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "select * from simulasi_nilai";
            ResultSet res = stt.executeQuery(SQL);
            
            while(res.next()){
                data[0] = res.getString(3);
                data[1] = res.getString(4);
                data[2] = res.getString(5);
                data[3] = res.getString(6);
                data[4] = res.getString(7);
                data[5] = res.getString(8);
                data[6] = res.getString(9);
                data[7] = res.getString(10);
                data[8] = res.getString(11);
                data[9] = res.getString(12);
                data[10] = res.getString(13);
                data[11] = res.getString(14);
                data[12] = res.getString(15);
                data[13] = res.getString(16);
                data[14] = res.getString(17);
                data[15] = res.getString(18);
                data[16] = res.getString(19);
                data[17] = res.getString(20);
                
                tableModel.addRow(data);
            }
            
            res.close();
            stt.close();
            kon.close();
        } catch(Exception ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(),"Error",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    private void search(String key){
        tableModel.setRowCount(0);
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt=kon.createStatement();
            String SQL = "SELECT * from simulasi_nilai WHERE no_mk LIKE LIKE '%"+key+"%'";
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
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    int row = 0;
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
        } catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void lebar_column(){
        table_simulasi_nilai.getColumnModel().getColumn(0).setPreferredWidth(80);
        table_simulasi_nilai.getColumnModel().getColumn(1).setPreferredWidth(80);
        table_simulasi_nilai.getColumnModel().getColumn(2).setPreferredWidth(80);
        table_simulasi_nilai.getColumnModel().getColumn(3).setPreferredWidth(70);
        table_simulasi_nilai.getColumnModel().getColumn(4).setPreferredWidth(70);
        table_simulasi_nilai.getColumnModel().getColumn(5).setPreferredWidth(30);
        table_simulasi_nilai.getColumnModel().getColumn(6).setPreferredWidth(5);
        table_simulasi_nilai.getColumnModel().getColumn(7).setPreferredWidth(5);
        table_simulasi_nilai.getColumnModel().getColumn(8).setPreferredWidth(5);
        table_simulasi_nilai.getColumnModel().getColumn(9).setPreferredWidth(5);
        table_simulasi_nilai.getColumnModel().getColumn(10).setPreferredWidth(5);
        table_simulasi_nilai.getColumnModel().getColumn(11).setPreferredWidth(35);
        table_simulasi_nilai.getColumnModel().getColumn(12).setPreferredWidth(35);
        table_simulasi_nilai.getColumnModel().getColumn(13).setPreferredWidth(30);
        table_simulasi_nilai.getColumnModel().getColumn(14).setPreferredWidth(30);
        table_simulasi_nilai.getColumnModel().getColumn(15).setPreferredWidth(30);
        table_simulasi_nilai.getColumnModel().getColumn(16).setPreferredWidth(5);       
        table_simulasi_nilai.getColumnModel().getColumn(17).setPreferredWidth(40);
    }
    
    public void enabled_text(){
        txt_nama_mk.setEnabled(true);
        txt_kode_mk.setEnabled(true);
        txt_p_absen.setEnabled(true);
        txt_p_tugas.setEnabled(true);
        txt_p_uts.setEnabled(true);
        txt_p_uas.setEnabled(true);
        txt_kehadiran.setEnabled(true);
        txt_tugas1.setEnabled(true);
        txt_tugas2.setEnabled(true);
        txt_tugas3.setEnabled(true);
        txt_uts.setEnabled(true);
        txt_uas.setEnabled(true);
    }
    
    public void disabled_text(){
        txt_nama_mk.setEnabled(false);
        txt_kode_mk.setEnabled(false);
        txt_p_absen.setEnabled(false);
        txt_p_tugas.setEnabled(false);
        txt_p_uts.setEnabled(false);
        txt_p_uas.setEnabled(false);
        txt_kehadiran.setEnabled(false);
        txt_tugas1.setEnabled(false);
        txt_tugas2.setEnabled(false);
        txt_tugas3.setEnabled(false);
        txt_uts.setEnabled(false);
        txt_uas.setEnabled(false);
    }
    
    public void clear_text(){
        txt_nama_mk.setSelectedIndex(0);
        txt_kode_mk.setText("");
        txt_p_absen.setText("");
        txt_p_tugas.setText("");
        txt_p_uts.setText("");
        txt_p_uas.setText("");
        txt_kehadiran.setText("");
        txt_tugas1.setText("");
        txt_tugas2.setText("");
        txt_tugas3.setText("");
        txt_uts.setText("");
        txt_uas.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_nama_mk = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_p_absen = new javax.swing.JTextField();
        txt_p_tugas = new javax.swing.JTextField();
        txt_p_uts = new javax.swing.JTextField();
        txt_p_uas = new javax.swing.JTextField();
        txt_kode_mk = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_simulasi_nilai = new javax.swing.JTable();
        btn_tambah = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        pertemuan = new javax.swing.JLabel();
        txt_uts = new javax.swing.JTextField();
        tugas1 = new javax.swing.JLabel();
        txt_kehadiran = new javax.swing.JTextField();
        tugas2 = new javax.swing.JLabel();
        txt_tugas1 = new javax.swing.JTextField();
        tugas3 = new javax.swing.JLabel();
        txt_tugas2 = new javax.swing.JTextField();
        uas = new javax.swing.JLabel();
        txt_tugas3 = new javax.swing.JTextField();
        uts = new javax.swing.JLabel();
        txt_uas = new javax.swing.JTextField();
        kehadiran = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Franklin Gothic Medium", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        jLabel1.setText("FORM SIMULASI NILAI AKHIR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(495, 495, 495)
                .addComponent(jLabel1)
                .addContainerGap(481, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );

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

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel7.setText("Persentase Absen");

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel8.setText("Persentase Tugas");

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel9.setText("Persentase UTS");

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel10.setText("Persentase UAS");

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jLabel11.setText("Kode MK");

        table_simulasi_nilai.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 12)); // NOI18N
        table_simulasi_nilai.setModel(new javax.swing.table.DefaultTableModel(
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
        table_simulasi_nilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_simulasi_nilaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_simulasi_nilai);

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

        pertemuan.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        pertemuan.setText("Pertemuan");

        tugas1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        tugas1.setText("Tugas 1");

        tugas2.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        tugas2.setText("Tugas 2");

        tugas3.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        tugas3.setText("Tugas 3");

        uas.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        uas.setText("UAS");

        uts.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        uts.setText("UTS");

        kehadiran.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        kehadiran.setText("Kehadiran");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nama_mk, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_kode_mk, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_p_uas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_p_tugas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_p_uts, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_p_absen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel11)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tugas1)
                            .addComponent(tugas2)
                            .addComponent(tugas3)
                            .addComponent(uas)
                            .addComponent(uts)
                            .addComponent(kehadiran))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_uts, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_uas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_kehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pertemuan)))
                        .addGap(10, 10, 10)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(txt_p_absen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_p_tugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(txt_p_uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(txt_p_uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pertemuan)
                            .addComponent(txt_kehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kehadiran))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tugas1)
                            .addComponent(txt_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tugas2)
                            .addComponent(txt_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tugas3)
                            .addComponent(txt_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uts))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uas)
                            .addComponent(txt_uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nama_mkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nama_mkActionPerformed

    }//GEN-LAST:event_txt_nama_mkActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        txt_kode_mk.requestFocus();
        btn_simpan.setEnabled(true);
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
        btn_keluar.setEnabled(false);
        btn_batal.setEnabled(true);
        enabled_text();
        clear_text();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        String kode_mk = txt_kode_mk.getText();
        String nama_mk = txt_nama_mk.getSelectedItem().toString();
        String p_absen = txt_p_absen.getText();
        String p_tugas = txt_p_tugas.getText();
        String p_uts = txt_p_uts.getText();
        String p_uas = txt_p_uas.getText();
        String kehadiran = txt_kehadiran.getText();
        String tugas1 = txt_tugas1.getText();
        String tugas2 = txt_tugas2.getText();
        String tugas3 = txt_tugas3.getText();
        String uts = txt_uts.getText();
        String uas = txt_uas.getText();
        
        int selectedRow = table_simulasi_nilai.getSelectedRow();
        
        int P_absen = Integer.parseInt(txt_p_absen.getText());
        int P_tugas = Integer.parseInt(txt_p_tugas.getText());
        int P_uts = Integer.parseInt(txt_p_uts.getText());
        int P_uas = Integer.parseInt(txt_p_uas.getText());
        
        int I_kehadiran = Integer.parseInt(txt_kehadiran.getText());
        int I_tugas1 = Integer.parseInt(txt_tugas1.getText());
        int I_tugas2 = Integer.parseInt(txt_tugas2.getText());
        int I_tugas3 = Integer.parseInt(txt_tugas3.getText());
        int I_uts = Integer.parseInt(txt_uts.getText());
        int I_uas = Integer.parseInt(txt_uas.getText());
        
        double n_absen = ((I_kehadiran/14)*100*(P_absen/100))/100;
        double n_tugas = (((I_tugas1+I_tugas2+I_tugas3)/3)*(P_tugas/100)/100);
        double n_uts =  I_uts*(P_uts/100);
        double n_uas = I_uas*(P_uas/100);
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
        
        String ket = " ";
        if(I_kehadiran<11){
            ket = "TIDAK LULUS";
        }else if (index == "A" || index == "B" || index == "C"){
            ket = "LULUS";
        } else if(index == "D" || index == "E" ){
            ket = "TIDAK LULUS";
        } 
        
        if((kode_mk.isEmpty()) | (nama_mk.isEmpty())){
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
            txt_kode_mk.requestFocus();
        }else{
            try{
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL = "UPDATE `simulasi_nilai` "
                        + "SET `no_mk` = '"+kode_mk+"', "
                        + "`nama_mk` = '"+nama_mk+"', "
                        + "`persentase_absen` = '"+p_absen+"', "
                        + "`persentase_tugas` = '"+p_tugas+"', "
                        + "`persentase_uts` = '"+p_uts+"', "
                        + "`persentase_uas` = '"+p_uas+"', "
                        + "`kehadiran` = '"+kehadiran+"', "
                        + "`tugas_1` = '"+tugas1+"', "
                        + "`tugas_2` = '"+tugas2+"', "
                        + "`tugas_3` = '"+tugas3+"', "
                        + "`uts` = '"+uts+"', "
                        + "`uas` = "+uas+","
                        + "`nilai_absen` = '"+String.format("%.2f",n_absen)+"', "
                        + "`nilai_tugas` = '"+String.format("%.2f",n_tugas)+"', "
                        + "`nilai_uts` = '"+String.format("%.2f",n_uts)+"', "
                        + "`nilai_uas` = '"+String.format("%.2f",n_uas)+"', "
                        + "`nilai_akhir` = '"+String.format("%.2f",n_akhir)+"', "
                        + "`index` = '"+index+"', "
                        + "`keterangan` = '"+ket+"'"
                        + " WHERE `no_mk` = '"+kode_mk+"';";
                
                stt.executeUpdate(SQL);
                data[0] = nama_mk;
                data[1] = p_absen;
                data[2] = p_tugas;
                data[3] = p_uts;
                data[4] = p_uas;
                data[5] = kehadiran;
                data[6] = tugas1;
                data[7] = tugas2;
                data[8] = tugas3;
                data[9] = uts;
                data[10] = uas;
                data[11] = String.format("%.2f",n_absen);
                data[12] = String.format("%.2f",n_tugas);
                data[13] = String.format("%.2f",n_uts);
                data[14] = String.format("%.2f",n_uas);
                data[15] = String.format("%.2f",n_akhir);
                data[16] = String.valueOf(index);
                data[17] = String.valueOf(ket);
                
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
            } catch(Exception ex){
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int selectedRow = table_simulasi_nilai.getSelectedRow();
        String kode_mk = txt_kode_mk.getText();
        
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String  SQL = "DELETE FROM `simulasi_nilai` "
                        + " WHERE `no_mk` = '"+kode_mk+"';";
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
        } catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        String data[]=new String[18];
        
        int selectedRow = table_simulasi_nilai.getSelectedRow();
        
        int P_absen = Integer.parseInt(txt_p_absen.getText());
        int P_tugas = Integer.parseInt(txt_p_tugas.getText());
        int P_uts = Integer.parseInt(txt_p_uts.getText());
        int P_uas = Integer.parseInt(txt_p_uas.getText());
        
        int I_kehadiran = Integer.parseInt(txt_kehadiran.getText());
        int I_tugas1 = Integer.parseInt(txt_tugas1.getText());
        int I_tugas2 = Integer.parseInt(txt_tugas2.getText());
        int I_tugas3 = Integer.parseInt(txt_tugas3.getText());
        int I_uts = Integer.parseInt(txt_uts.getText());
        int I_uas = Integer.parseInt(txt_uas.getText());
        
        double n_absen = (((I_kehadiran/14)*100*(P_absen/100))/100);
        double n_tugas = (((I_tugas1+I_tugas2+I_tugas3)/3)*((P_tugas/100)/100));
        double n_uts =  I_uts*(P_uts/100);
        double n_uas = I_uas*(P_uas/100);
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
        
        String ket = " ";
        if(I_kehadiran<11){
            ket = "TIDAK LULUS";
        }else if (index == "A" || index == "B" || index == "C"){
            ket = "LULUS";
        } else if(index == "D" || index == "E" ){
            ket = "TIDAK LULUS";
        }
        
        if ((txt_tugas1.getText().isEmpty()) || (txt_kode_mk.getText().isEmpty())){
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
            txt_kode_mk.requestFocus();
        }else{
            try{
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO simulasi_nilai(`no_mk`, `nama_mk`, `persentase_absen`, `persentase_tugas`, `persentase_uts`, `persentase_uas`, `kehadiran`, `tugas_1`, `tugas_2`, `tugas_3`, `uts`, `uas`, `nilai_absen`, `nilai_tugas`, `nilai_uts`, `nilai_uas`, `nilai_akhir`, `index`, `keterangan`) VALUES "
                            + "( '"+txt_kode_mk.getText()+"',"
                            + " '"+txt_nama_mk.getSelectedItem().toString()+"',"
                            + " '"+txt_p_absen.getText()+"',"
                            + " '"+txt_p_tugas.getText()+"',"
                            + " '"+txt_p_uts.getText()+"',"
                            + " '"+txt_p_uas.getText()+"',"
                            + " '"+txt_kehadiran.getText()+"',"
                            + " '"+txt_tugas1.getText()+"',"
                            + " '"+txt_tugas2.getText()+"',"
                            + " '"+txt_tugas3.getText()+"',"
                            + " '"+txt_uts.getText()+"',"
                            + " '"+txt_uas.getText()+"',"
                            + " '"+String.format("%.2f",n_absen)+"',"
                            + " '"+String.format("%.2f",n_tugas)+"',"
                            + " '"+String.format("%.2f",n_uts)+"',"
                            + " '"+String.format("%.2f",n_uas)+"',"
                            + " '"+String.format("%.2f",n_akhir)+"',"
                            + " '"+index+"',"
                            + " '"+ket+"');";
                
                stt.executeUpdate(SQL);
                data[0] = txt_nama_mk.getSelectedItem().toString();
                data[1] = txt_p_absen.getText();
                data[2] = txt_p_tugas.getText();
                data[3] = txt_p_uts.getText();
                data[4] = txt_p_uas.getText();
                data[5] = txt_kehadiran.getText();
                data[6] = txt_tugas1.getText();
                data[7] = txt_tugas2.getText();
                data[8] = txt_tugas3.getText();
                data[9] = txt_uts.getText();
                data[10] = txt_uas.getText();
                data[11] = String.format("%.2f",n_absen);
                data[12] = String.format("%.2f",n_tugas);
                data[13] = String.format("%.2f",n_uts);
                data[14] = String.format("%.2f",n_uas);
                data[15] = String.format("%.2f",n_akhir);
                data[16] = String.valueOf(index);
                data[17] = String.valueOf(ket);
                
                tableModel.insertRow(0, data);
                
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
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void table_simulasi_nilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_simulasi_nilaiMouseClicked
        int selectedRow = table_simulasi_nilai.getSelectedRow();
        
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String table_click=(table_simulasi_nilai.getModel().getValueAt(selectedRow,0).toString());
            String SQL="select * from simulasi_nilai where nama_mk='"+table_click+"'";
            ResultSet res = stt.executeQuery(SQL);
            
            if(res.next()){
                String add1=res.getString("no_mk");
                txt_kode_mk.setText(add1);
            }
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }        
        String nama_mk = tableModel.getValueAt(selectedRow, 0).toString();
        
        for (int i = 0; i < txt_nama_mk.getItemCount(); i++){
            if(txt_nama_mk.getItemAt(i).toString().equalsIgnoreCase(nama_mk)){
                txt_nama_mk.setSelectedIndex(i);
            }
        }
        
        txt_p_absen.setText(tableModel.getValueAt(selectedRow, 1).toString());
        txt_p_tugas.setText(tableModel.getValueAt(selectedRow, 2).toString());
        txt_p_uts.setText(tableModel.getValueAt(selectedRow, 3).toString());
        txt_p_uas.setText(tableModel.getValueAt(selectedRow,4).toString());
        txt_kehadiran.setText(tableModel.getValueAt(selectedRow,5).toString());
        txt_tugas1.setText(tableModel.getValueAt(selectedRow, 6).toString());
        txt_tugas2.setText(tableModel.getValueAt(selectedRow, 7).toString());
        txt_tugas3.setText(tableModel.getValueAt(selectedRow, 8).toString());
        txt_uts.setText(tableModel.getValueAt(selectedRow, 9).toString());
        txt_uas.setText(tableModel.getValueAt(selectedRow, 10).toString());
        
        btn_tambah.setEnabled(false);
        btn_ubah.setEnabled(true);
        btn_hapus.setEnabled(true);
        btn_simpan.setEnabled(false);
        btn_batal.setEnabled(true);
        btn_keluar.setEnabled(false);
        enabled_text();
    }//GEN-LAST:event_table_simulasi_nilaiMouseClicked

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
                txt_kode_mk.setText(no_mk);
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txt_nama_mkPopupMenuWillBecomeInvisible

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_simulasi_nilai().setVisible(true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kehadiran;
    private javax.swing.JLabel pertemuan;
    private javax.swing.JTable table_simulasi_nilai;
    private javax.swing.JLabel tugas1;
    private javax.swing.JLabel tugas2;
    private javax.swing.JLabel tugas3;
    private javax.swing.JTextField txt_kehadiran;
    private javax.swing.JTextField txt_kode_mk;
    private javax.swing.JComboBox<String> txt_nama_mk;
    private javax.swing.JTextField txt_p_absen;
    private javax.swing.JTextField txt_p_tugas;
    private javax.swing.JTextField txt_p_uas;
    private javax.swing.JTextField txt_p_uts;
    private javax.swing.JTextField txt_tugas1;
    private javax.swing.JTextField txt_tugas2;
    private javax.swing.JTextField txt_tugas3;
    private javax.swing.JTextField txt_uas;
    private javax.swing.JTextField txt_uts;
    private javax.swing.JLabel uas;
    private javax.swing.JLabel uts;
    // End of variables declaration//GEN-END:variables
}
