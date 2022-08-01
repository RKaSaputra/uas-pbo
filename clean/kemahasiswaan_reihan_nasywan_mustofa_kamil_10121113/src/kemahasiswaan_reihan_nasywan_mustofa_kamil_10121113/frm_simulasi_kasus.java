package kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frm_simulasi_kasus extends javax.swing.JFrame {

    public frm_simulasi_kasus() {
        initComponents();
        banyakdisable();
        jumlahdisable();
        
        hr1.setVisible(false);
        btn_preview.setVisible(false);
        btn_cetak.setVisible(false);
        txa_tujuan.setEnabled(false);
        table_bon.setModel(tableModel);
    }
    
    public javax.swing.table.DefaultTableModel tableModel=getDefaultTableModel();
    private javax.swing.table.DefaultTableModel getDefaultTableModel(){
        return new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] {"Banyak","Menu","Harga","Jumlah"}
        ){
            boolean[] canEdit = new boolean[]{
                false,false,false,false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit[columnIndex];
            }
        };
    }

    int no_nota = 0;
    
    public void banyakdisable(){
        txt_usus_ndower.setEnabled(false);
        txt_ceker_ndower.setEnabled(false);
        txt_sayap_ndower.setEnabled(false);
        txt_kepala_ndower.setEnabled(false);
        txt_ayam_geprek.setEnabled(false);
        txt_mie_nelongso.setEnabled(false);
        txt_paket_nasi_ayam_geprek.setEnabled(false);
        txt_paket_mie_ayam_geprek.setEnabled(false);
        txt_nasi.setEnabled(false);
        txt_mie_goreng.setEnabled(false);
        txt_telor_ceplok.setEnabled(false);
        txt_air_mineral.setEnabled(false);
        txt_teh_pucuk.setEnabled(false);
    }
    
    public void jumlahdisable(){
        txt_usus_ndower1.setEnabled(false);
        txt_ceker_ndower1.setEnabled(false);
        txt_sayap_ndower1.setEnabled(false);
        txt_kepala_ndower1.setEnabled(false);
        txt_ayam_geprek1.setEnabled(false);
        txt_mie_nelongso1.setEnabled(false);
        txt_paket_nasi_ayam_geprek1.setEnabled(false);
        txt_paket_mie_ayam_geprek1.setEnabled(false);
        txt_nasi1.setEnabled(false);
        txt_mie_goreng1.setEnabled(false);
        txt_telor_ceplok1.setEnabled(false);
        txt_air_mineral1.setEnabled(false);
        txt_teh_pucuk1.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cb_air_mineral = new javax.swing.JCheckBox();
        txt_mie_goreng1 = new javax.swing.JTextField();
        cb_teh_pucuk = new javax.swing.JCheckBox();
        txt_telor_ceplok1 = new javax.swing.JTextField();
        txt_usus_ndower = new javax.swing.JTextField();
        txt_ceker_ndower = new javax.swing.JTextField();
        txt_air_mineral1 = new javax.swing.JTextField();
        txt_teh_pucuk1 = new javax.swing.JTextField();
        jumlah = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txt_sayap_ndower = new javax.swing.JTextField();
        tujuan = new javax.swing.JLabel();
        txt_kepala_ndower = new javax.swing.JTextField();
        txt_ayam_geprek = new javax.swing.JTextField();
        txt_mie_nelongso = new javax.swing.JTextField();
        txt_paket_nasi_ayam_geprek = new javax.swing.JTextField();
        txt_paket_mie_ayam_geprek = new javax.swing.JTextField();
        txt_nasi = new javax.swing.JTextField();
        txt_mie_goreng = new javax.swing.JTextField();
        txt_telor_ceplok = new javax.swing.JTextField();
        txt_air_mineral = new javax.swing.JTextField();
        txt_teh_pucuk = new javax.swing.JTextField();
        daftar_menu = new javax.swing.JLabel();
        banyak = new javax.swing.JLabel();
        harga = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cb_ceker_ndower = new javax.swing.JCheckBox();
        cb_usus_ndower = new javax.swing.JCheckBox();
        cb_kepala_ndower = new javax.swing.JCheckBox();
        txt_usus_ndower1 = new javax.swing.JTextField();
        cb_sayap_ndower = new javax.swing.JCheckBox();
        cb_mie_nelongso = new javax.swing.JCheckBox();
        cb_ayam_geprek = new javax.swing.JCheckBox();
        cb_paket_nasi_ayam_geprek = new javax.swing.JCheckBox();
        txt_ceker_ndower1 = new javax.swing.JTextField();
        txt_sayap_ndower1 = new javax.swing.JTextField();
        txt_kepala_ndower1 = new javax.swing.JTextField();
        txt_ayam_geprek1 = new javax.swing.JTextField();
        cb_paket_mie_ayam_geprek = new javax.swing.JCheckBox();
        txt_mie_nelongso1 = new javax.swing.JTextField();
        cb_nasi = new javax.swing.JCheckBox();
        txt_paket_nasi_ayam_geprek1 = new javax.swing.JTextField();
        cb_mie_goreng = new javax.swing.JCheckBox();
        txt_paket_mie_ayam_geprek1 = new javax.swing.JTextField();
        cb_telor_ceplok = new javax.swing.JCheckBox();
        txt_nasi1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txa_tujuan = new javax.swing.JTextArea();
        btn_hitung = new javax.swing.JButton();
        btn_preview = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();
        label_jumlah2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_jumlah = new javax.swing.JLabel();
        hr1 = new javax.swing.JPanel();
        toko_kafe_mamat = new javax.swing.JLabel();
        hr2 = new javax.swing.JSeparator();
        label_nota = new javax.swing.JLabel();
        label_tanggal = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_bon = new javax.swing.JTable();
        txt_nota = new javax.swing.JLabel();
        txt_tanggal = new javax.swing.JLabel();
        txt_tujuan = new javax.swing.JLabel();
        label_tujuan = new javax.swing.JLabel();
        label_jumlah = new javax.swing.JLabel();
        txt_jumlah_print = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cb_air_mineral.setText("Air Mineral");
        cb_air_mineral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_air_mineralActionPerformed(evt);
            }
        });

        txt_mie_goreng1.setText("0");

        cb_teh_pucuk.setText("Teh Pucuk");
        cb_teh_pucuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_teh_pucukActionPerformed(evt);
            }
        });

        txt_telor_ceplok1.setText("0");

        txt_usus_ndower.setText("0");

        txt_ceker_ndower.setText("0");

        txt_air_mineral1.setText("0");

        txt_teh_pucuk1.setText("0");

        jumlah.setText("Jumlah");

        txt_sayap_ndower.setText("0");

        tujuan.setText("Tujuan");
        tujuan.setToolTipText("");

        txt_kepala_ndower.setText("0");

        txt_ayam_geprek.setText("0");

        txt_mie_nelongso.setText("0");

        txt_paket_nasi_ayam_geprek.setText("0");

        txt_paket_mie_ayam_geprek.setText("0");

        txt_nasi.setText("0");

        txt_mie_goreng.setText("0");

        txt_telor_ceplok.setText("0");

        txt_air_mineral.setText("0");

        txt_teh_pucuk.setText("0");

        daftar_menu.setText("Daftar Menu");

        banyak.setText("Banyak");

        harga.setText("Harga");

        jLabel1.setText("Rp. 12.000");

        jLabel2.setText("Rp. 12.000");

        jLabel3.setText("Rp. 17.500");

        jLabel6.setText("Rp. 12.000");

        jLabel7.setText("Rp. 17.500");

        jLabel8.setText("Rp. 12.000");

        jLabel9.setText("Rp. 21.500");

        jLabel10.setText("Rp. 22.500");

        jLabel11.setText("Rp. 5.000");

        jLabel12.setText("Rp. 6.000");

        jLabel13.setText("Rp. 3.000");

        jLabel14.setText("Rp. 5.000");

        jLabel15.setText("Rp. 6.000");

        cb_ceker_ndower.setText("Ceker ndower");
        cb_ceker_ndower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ceker_ndowerActionPerformed(evt);
            }
        });

        cb_usus_ndower.setText("Usus ndower");
        cb_usus_ndower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_usus_ndowerActionPerformed(evt);
            }
        });

        cb_kepala_ndower.setText("Kepala Ndower");
        cb_kepala_ndower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_kepala_ndowerActionPerformed(evt);
            }
        });

        txt_usus_ndower1.setText("0");

        cb_sayap_ndower.setText("Sayap ndower");
        cb_sayap_ndower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sayap_ndowerActionPerformed(evt);
            }
        });

        cb_mie_nelongso.setText("Mie nelongso");
        cb_mie_nelongso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_mie_nelongsoActionPerformed(evt);
            }
        });

        cb_ayam_geprek.setText("Ayam Geprek");
        cb_ayam_geprek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ayam_geprekActionPerformed(evt);
            }
        });

        cb_paket_nasi_ayam_geprek.setText("Paket nasi ayam geprek");
        cb_paket_nasi_ayam_geprek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_paket_nasi_ayam_geprekActionPerformed(evt);
            }
        });

        txt_ceker_ndower1.setText("0");

        txt_sayap_ndower1.setText("0");

        txt_kepala_ndower1.setText("0");

        txt_ayam_geprek1.setText("0");

        cb_paket_mie_ayam_geprek.setText("Paket mie ayam geprek");
        cb_paket_mie_ayam_geprek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_paket_mie_ayam_geprekActionPerformed(evt);
            }
        });

        txt_mie_nelongso1.setText("0");

        cb_nasi.setText("Nasi");
        cb_nasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_nasiActionPerformed(evt);
            }
        });

        txt_paket_nasi_ayam_geprek1.setText("0");

        cb_mie_goreng.setText("Mie Goreng");
        cb_mie_goreng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_mie_gorengActionPerformed(evt);
            }
        });

        txt_paket_mie_ayam_geprek1.setText("0");

        cb_telor_ceplok.setText("Telor Ceplok/Dadar");
        cb_telor_ceplok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_telor_ceplokActionPerformed(evt);
            }
        });

        txt_nasi1.setText("0");

        txa_tujuan.setColumns(20);
        txa_tujuan.setRows(5);
        jScrollPane1.setViewportView(txa_tujuan);

        btn_hitung.setText("Hitung");
        btn_hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hitungActionPerformed(evt);
            }
        });

        btn_preview.setText("Cetak Preview");
        btn_preview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previewActionPerformed(evt);
            }
        });

        btn_cetak.setText("Cetak");
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });

        label_jumlah2.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14)); // NOI18N
        label_jumlah2.setText("Jumlah : Rp.");

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_jumlah.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14)); // NOI18N
        txt_jumlah.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cb_ceker_ndower)
                                        .addComponent(cb_sayap_ndower)
                                        .addComponent(cb_kepala_ndower)
                                        .addComponent(cb_ayam_geprek)
                                        .addComponent(cb_mie_nelongso)
                                        .addComponent(cb_paket_nasi_ayam_geprek)
                                        .addComponent(cb_usus_ndower))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cb_nasi)
                                        .addComponent(cb_paket_mie_ayam_geprek)
                                        .addComponent(cb_mie_goreng)
                                        .addComponent(cb_telor_ceplok)
                                        .addComponent(cb_air_mineral)
                                        .addComponent(cb_teh_pucuk))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(daftar_menu)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(harga))
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15))))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(banyak))
                                    .addComponent(txt_paket_mie_ayam_geprek)
                                    .addComponent(txt_ayam_geprek)
                                    .addComponent(txt_kepala_ndower)
                                    .addComponent(txt_sayap_ndower)
                                    .addComponent(txt_ceker_ndower)
                                    .addComponent(txt_usus_ndower)
                                    .addComponent(txt_mie_nelongso)
                                    .addComponent(txt_paket_nasi_ayam_geprek)
                                    .addComponent(txt_nasi)
                                    .addComponent(txt_mie_goreng)
                                    .addComponent(txt_telor_ceplok)
                                    .addComponent(txt_air_mineral)
                                    .addComponent(txt_teh_pucuk, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_teh_pucuk1)
                                    .addComponent(txt_air_mineral1)
                                    .addComponent(txt_telor_ceplok1)
                                    .addComponent(txt_mie_goreng1)
                                    .addComponent(txt_nasi1)
                                    .addComponent(txt_paket_mie_ayam_geprek1)
                                    .addComponent(txt_paket_nasi_ayam_geprek1)
                                    .addComponent(txt_mie_nelongso1)
                                    .addComponent(txt_ayam_geprek1)
                                    .addComponent(txt_kepala_ndower1)
                                    .addComponent(txt_sayap_ndower1)
                                    .addComponent(txt_ceker_ndower1)
                                    .addComponent(txt_usus_ndower1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jumlah))))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tujuan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_preview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_hitung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_jumlah2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_jumlah)
                .addGap(85, 85, 85))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jumlah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_usus_ndower1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ceker_ndower1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_sayap_ndower1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_kepala_ndower1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ayam_geprek1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_mie_nelongso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_paket_nasi_ayam_geprek1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_paket_mie_ayam_geprek1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nasi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_mie_goreng1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_telor_ceplok1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_air_mineral1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_teh_pucuk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(daftar_menu)
                            .addComponent(banyak)
                            .addComponent(harga))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_usus_ndower)
                            .addComponent(txt_usus_ndower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_ceker_ndower)
                            .addComponent(txt_ceker_ndower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_sayap_ndower)
                            .addComponent(txt_sayap_ndower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_kepala_ndower)
                            .addComponent(txt_kepala_ndower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_ayam_geprek)
                            .addComponent(txt_ayam_geprek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_mie_nelongso)
                            .addComponent(txt_mie_nelongso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_paket_nasi_ayam_geprek)
                            .addComponent(txt_paket_nasi_ayam_geprek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_paket_mie_ayam_geprek)
                            .addComponent(txt_paket_mie_ayam_geprek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_nasi)
                            .addComponent(txt_nasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_mie_goreng)
                            .addComponent(txt_mie_goreng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_telor_ceplok)
                            .addComponent(txt_telor_ceplok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_air_mineral)
                            .addComponent(txt_air_mineral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_teh_pucuk)
                            .addComponent(txt_teh_pucuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_jumlah2)
                    .addComponent(txt_jumlah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tujuan)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_hitung)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_preview)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cetak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(30, 30, 30))
        );

        hr1.setBackground(new java.awt.Color(255, 255, 255));

        toko_kafe_mamat.setFont(new java.awt.Font("Franklin Gothic Book", 1, 24)); // NOI18N
        toko_kafe_mamat.setText("Toko Kafe Mamat");

        hr2.setForeground(new java.awt.Color(0, 0, 0));

        label_nota.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        label_nota.setText("No nota         :");

        label_tanggal.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        label_tanggal.setText("Tanggal         :");

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));

        table_bon.setModel(new javax.swing.table.DefaultTableModel(
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
        table_bon.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(table_bon);

        txt_nota.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        txt_nota.setText("N");

        txt_tanggal.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        txt_tanggal.setText("N");

        txt_tujuan.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        txt_tujuan.setText("N");

        label_tujuan.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        label_tujuan.setText("Tujuan          :");

        label_jumlah.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14)); // NOI18N
        label_jumlah.setText("Jumlah Bayar : Rp.");

        txt_jumlah_print.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14)); // NOI18N
        txt_jumlah_print.setText("0");

        javax.swing.GroupLayout hr1Layout = new javax.swing.GroupLayout(hr1);
        hr1.setLayout(hr1Layout);
        hr1Layout.setHorizontalGroup(
            hr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hr1Layout.createSequentialGroup()
                .addGroup(hr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hr1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(hr2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(hr1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(hr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hr1Layout.createSequentialGroup()
                                .addGroup(hr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_nota)
                                    .addComponent(label_tanggal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(hr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nota)
                                    .addComponent(txt_tanggal)))
                            .addGroup(hr1Layout.createSequentialGroup()
                                .addComponent(label_tujuan)
                                .addGap(18, 18, 18)
                                .addComponent(txt_tujuan))))
                    .addGroup(hr1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(hr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(hr1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(hr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(hr1Layout.createSequentialGroup()
                                        .addComponent(label_jumlah)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_jumlah_print))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(7, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hr1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(toko_kafe_mamat)
                .addGap(92, 92, 92))
        );
        hr1Layout.setVerticalGroup(
            hr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hr1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(toko_kafe_mamat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hr2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nota)
                    .addComponent(txt_nota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tanggal)
                    .addComponent(txt_tanggal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tujuan)
                    .addComponent(txt_tujuan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_jumlah)
                    .addComponent(txt_jumlah_print))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_telor_ceplokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_telor_ceplokActionPerformed
        if(cb_telor_ceplok.isSelected()){
            txt_telor_ceplok.setEnabled(true);
        } else {
            txt_telor_ceplok.setEnabled(false);
        }
    }//GEN-LAST:event_cb_telor_ceplokActionPerformed

    private void cb_mie_gorengActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_mie_gorengActionPerformed
        if(cb_mie_goreng.isSelected()){
            txt_mie_goreng.setEnabled(true);
        } else {
            txt_mie_goreng.setEnabled(false);
        }
    }//GEN-LAST:event_cb_mie_gorengActionPerformed

    private void cb_nasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_nasiActionPerformed
        if(cb_nasi.isSelected()){
            txt_nasi.setEnabled(true);
        } else {
            txt_nasi.setEnabled(false);
        }
    }//GEN-LAST:event_cb_nasiActionPerformed

    private void cb_paket_mie_ayam_geprekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_paket_mie_ayam_geprekActionPerformed
        if(cb_paket_mie_ayam_geprek.isSelected()){
            txt_paket_mie_ayam_geprek.setEnabled(true);
        } else {
            txt_paket_mie_ayam_geprek.setEnabled(false);
        }
    }//GEN-LAST:event_cb_paket_mie_ayam_geprekActionPerformed

    private void cb_paket_nasi_ayam_geprekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_paket_nasi_ayam_geprekActionPerformed
        if(cb_paket_nasi_ayam_geprek.isSelected()){
            txt_paket_nasi_ayam_geprek.setEnabled(true);
        } else {
            txt_paket_nasi_ayam_geprek.setEnabled(false);
        }
    }//GEN-LAST:event_cb_paket_nasi_ayam_geprekActionPerformed

    private void cb_ayam_geprekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ayam_geprekActionPerformed
        if(cb_ayam_geprek.isSelected()){
            txt_ayam_geprek.setEnabled(true);
        } else {
            txt_ayam_geprek.setEnabled(false);
        }
    }//GEN-LAST:event_cb_ayam_geprekActionPerformed

    private void cb_mie_nelongsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_mie_nelongsoActionPerformed
        if(cb_mie_nelongso.isSelected()){
            txt_mie_nelongso.setEnabled(true);
        } else {
            txt_mie_nelongso.setEnabled(false);
        }
    }//GEN-LAST:event_cb_mie_nelongsoActionPerformed

    private void cb_sayap_ndowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sayap_ndowerActionPerformed
        if(cb_sayap_ndower.isSelected()){
            txt_sayap_ndower.setEnabled(true);
        } else {
            txt_sayap_ndower.setEnabled(false);
        }
    }//GEN-LAST:event_cb_sayap_ndowerActionPerformed

    private void cb_kepala_ndowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_kepala_ndowerActionPerformed
        if(cb_kepala_ndower.isSelected()){
            txt_kepala_ndower.setEnabled(true);
        } else {
            txt_kepala_ndower.setEnabled(false);
        }
    }//GEN-LAST:event_cb_kepala_ndowerActionPerformed

    private void cb_usus_ndowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_usus_ndowerActionPerformed
        if(cb_usus_ndower.isSelected()){
            txt_usus_ndower.setEnabled(true);
        } else {
            txt_usus_ndower.setEnabled(false);
        }
        
    }//GEN-LAST:event_cb_usus_ndowerActionPerformed

    private void cb_ceker_ndowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ceker_ndowerActionPerformed
        if(cb_ceker_ndower.isSelected()){
            txt_ceker_ndower.setEnabled(true);
        } else {
            txt_ceker_ndower.setEnabled(false);
        }
    }//GEN-LAST:event_cb_ceker_ndowerActionPerformed

    private void cb_teh_pucukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_teh_pucukActionPerformed
       if(cb_teh_pucuk.isSelected()){
            txt_teh_pucuk.setEnabled(true);
        } else {
            txt_teh_pucuk.setEnabled(false);
        }
    }//GEN-LAST:event_cb_teh_pucukActionPerformed

    private void cb_air_mineralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_air_mineralActionPerformed
        if(cb_air_mineral.isSelected()){
            txt_air_mineral.setEnabled(true);
        } else {
            txt_air_mineral.setEnabled(false);
        }
    }//GEN-LAST:event_cb_air_mineralActionPerformed

    private void btn_hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hitungActionPerformed
        int jumlah1 = 0;
        int jumlah2 = 0;
        int jumlah3 = 0;
        int jumlah4 = 0;
        int jumlah5 = 0;
        int jumlah6 = 0;
        int jumlah7 = 0;
        int jumlah8 = 0;
        int jumlah9 = 0;
        int jumlah10 = 0;
        int jumlah11 = 0;
        int jumlah12 = 0;
        int jumlah13 = 0;
        
        
        int harga1 = 12000;
        int banyak1 = Integer.parseInt(txt_usus_ndower.getText());
        jumlah1 = harga1 * banyak1;
        String jumlahS1 = String.valueOf(jumlah1);
        txt_usus_ndower1.setText(jumlahS1);
        
        int harga2 = 12000;
        int banyak2 = Integer.parseInt(txt_ceker_ndower.getText());
        jumlah2 = harga2 * banyak2;
        String jumlahS2 = String.valueOf(jumlah2);
        txt_ceker_ndower1.setText(jumlahS2);
        
        int harga3 = 17500;
        int banyak3 = Integer.parseInt(txt_sayap_ndower.getText());
        jumlah3 = harga3 * banyak3;
        String jumlahS3 = String.valueOf(jumlah3);
        txt_sayap_ndower1.setText(jumlahS3);

        int harga4 = 12000;
        int banyak4 = Integer.parseInt(txt_kepala_ndower.getText());
        jumlah4 = harga4 * banyak4;
        String jumlahS4 = String.valueOf(jumlah4);
        txt_kepala_ndower1.setText(jumlahS4);

        int harga5 = 17500;
        int banyak5 = Integer.parseInt(txt_ayam_geprek.getText());
        jumlah5 = harga5 * banyak5;
        String jumlahS5 = String.valueOf(jumlah5);
        txt_ayam_geprek1.setText(jumlahS5);
        
        int harga6 = 12000;
        int banyak6 = Integer.parseInt(txt_mie_nelongso.getText());
        jumlah6 = harga6 * banyak6;
        String jumlahS6 = String.valueOf(jumlah6);
        txt_mie_nelongso1.setText(jumlahS6);

        int harga7 = 21500;
        int banyak7 = Integer.parseInt(txt_paket_nasi_ayam_geprek.getText());
        jumlah7 = harga7 * banyak7;
        String jumlahS7 = String.valueOf(jumlah7);
        txt_paket_nasi_ayam_geprek1.setText(jumlahS7);

        int harga8 = 22500;
        int banyak8 = Integer.parseInt(txt_paket_mie_ayam_geprek.getText());
        jumlah8 = harga8 * banyak8;
        String jumlahS8 = String.valueOf(jumlah8);
        txt_paket_mie_ayam_geprek1.setText(jumlahS8);

        int harga9 = 5000;
        int banyak9 = Integer.parseInt(txt_nasi.getText());
        jumlah9 = harga9 * banyak9;
        String jumlahS9 = String.valueOf(jumlah9);
        txt_nasi1.setText(jumlahS9);

        int harga10 = 6000;
        int banyak10 = Integer.parseInt(txt_mie_goreng.getText());
        jumlah10 = harga10 * banyak10;
        String jumlahS10 = String.valueOf(jumlah10);
        txt_mie_goreng1.setText(jumlahS10);

        int harga11 = 3000;
        int banyak11 = Integer.parseInt(txt_telor_ceplok.getText());
        jumlah11 = harga11 * banyak11;
        String jumlahS11 = String.valueOf(jumlah11);
        txt_telor_ceplok1.setText(jumlahS11);

        int harga12 = 5000;
        int banyak12 = Integer.parseInt(txt_air_mineral.getText());
        jumlah12 = harga12 * banyak12;
        String jumlahS12 = String.valueOf(jumlah12);
        txt_air_mineral1.setText(jumlahS12);

        int harga13 = 6000;
        int banyak13 = Integer.parseInt(txt_teh_pucuk.getText());
        jumlah13 = harga13 * banyak13;
        String jumlahS13 = String.valueOf(jumlah13);
        txt_teh_pucuk1.setText(jumlahS13);
        
        int total_jumlah = jumlah1 + jumlah2 + jumlah3 + jumlah4 + jumlah5 + jumlah6 + jumlah7 + jumlah8 + jumlah9 + jumlah10 + jumlah11 + jumlah12 + jumlah13;
        String totaljumlah = String.valueOf(total_jumlah);
        
        txt_jumlah.setText(totaljumlah);
        txa_tujuan.setEnabled(true);
        btn_preview.setVisible(true);
    }//GEN-LAST:event_btn_hitungActionPerformed

    private void btn_previewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_previewActionPerformed
        DefaultTableModel model = (DefaultTableModel)table_bon.getModel();
        model.getDataVector().removeAllElements();
        revalidate();
        
        String jumlah = txt_jumlah.getText();
        txt_jumlah_print.setText(jumlah);
        
        no_nota = no_nota + 1;
        String notaS = String.valueOf(no_nota);
        txt_nota.setText(notaS);
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Timestamp ts = Timestamp.from(Instant.now());
        String tss = String.valueOf(ts);
        txt_tanggal.setText(tss);
        
        String ta_tujuan = txa_tujuan.getText();
        txt_tujuan.setText(ta_tujuan);
        
        String data[]=new String[4];
        if(cb_usus_ndower.isSelected()){
            data[0] = txt_usus_ndower.getText();
            data[1] = "Usus Ndower";
            data[2] = "Rp. 12.000";
            data[3] = "Rp. "+ txt_usus_ndower1.getText();
            tableModel.addRow(data);
        }
        
        if(cb_ceker_ndower.isSelected()){
            data[0] = txt_ceker_ndower.getText();
            data[1] = "Ceker Ndower";
            data[2] = "Rp. 12.000";
            data[3] = "Rp. "+ txt_ceker_ndower1.getText();
            tableModel.addRow(data);
        }
        
        if(cb_sayap_ndower.isSelected()){
            data[0] = txt_sayap_ndower.getText();
            data[1] = "Sayap Ndower";
            data[2] = "Rp. 17.500";
            data[3] = "Rp. "+ txt_sayap_ndower1.getText();
            tableModel.addRow(data);
        }
        
        if(cb_kepala_ndower.isSelected()){
            data[0] = txt_kepala_ndower.getText();
            data[1] = "Kepala Ndower";
            data[2] = "Rp. 12.000";
            data[3] = "Rp. "+ txt_kepala_ndower1.getText();
            tableModel.addRow(data);
        }
        
        if(cb_ayam_geprek.isSelected()){
            data[0] = txt_ayam_geprek.getText();
            data[1] = "Ayam Geprek";
            data[2] = "Rp. 17.500";
            data[3] = "Rp. "+ txt_ayam_geprek1.getText();
            tableModel.addRow(data);
        }
        
        if(cb_mie_nelongso.isSelected()){
            data[0] = txt_mie_nelongso.getText();
            data[1] = "Mie Nelongso";
            data[2] = "Rp. 12.000";
            data[3] = "Rp. "+ txt_mie_nelongso1.getText();
            tableModel.addRow(data);
        }
        if(cb_paket_nasi_ayam_geprek.isSelected()){
            data[0] = txt_paket_nasi_ayam_geprek.getText();
            data[1] = "Nasi Ayam Geprek";
            data[2] = "Rp. 21.500";
            data[3] = "Rp. "+ txt_paket_nasi_ayam_geprek1.getText();
            tableModel.addRow(data);
        }
        
        if(cb_paket_mie_ayam_geprek.isSelected()){
            data[0] = txt_paket_mie_ayam_geprek.getText();
            data[1] = "Paket Mie Ayam Geprek";
            data[2] = "Rp.22.500";
            data[3] = "Rp. "+ txt_paket_mie_ayam_geprek1.getText();
            tableModel.addRow(data);
        }
        
        if(cb_nasi.isSelected()){
            data[0] = txt_nasi.getText();
            data[1] = "Nasi";
            data[2] = "Rp. 5.000";
            data[3] = "Rp. "+ txt_nasi1.getText();
            tableModel.addRow(data);
        }
        
        if(cb_mie_goreng.isSelected()){
            data[0] = txt_mie_goreng.getText();
            data[1] = "Mie Goreng";
            data[2] = "Rp. 6.000";
            data[3] = "Rp. "+ txt_mie_goreng1.getText();
            tableModel.addRow(data);
        }
        if(cb_telor_ceplok.isSelected()){
            data[0] = txt_telor_ceplok.getText();
            data[1] = "Telor Ceplok/Dadar";
            data[2] = "Rp. 3.000";
            data[3] = "Rp. "+ txt_telor_ceplok1.getText();
            tableModel.addRow(data);
        }
        if(cb_air_mineral.isSelected()){
            data[0] = txt_air_mineral.getText();
            data[1] = "Air Mineral";
            data[2] = "Rp. 5.000";
            data[3] = "Rp. "+ txt_air_mineral1.getText();
            tableModel.addRow(data);
        }
        if(cb_teh_pucuk.isSelected()){
            data[0] = txt_teh_pucuk.getText();
            data[1] = "Teh Pucuk";
            data[2] = "Rp. 6.000";
            data[3] = "Rp. "+ txt_teh_pucuk1.getText();
            tableModel.addRow(data);
        }
        
        hr1.setVisible(true);
        btn_cetak.setVisible(true);
    }//GEN-LAST:event_btn_previewActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        banyakdisable();
        txt_jumlah.setText("0");
        btn_cetak.setVisible(false);
        btn_preview.setVisible(false);
        hr1.setVisible(false);
        
        cb_usus_ndower.setSelected(false);
        txt_usus_ndower.setText("0");
        txt_usus_ndower1.setText("0");

        cb_ceker_ndower.setSelected(false);
        txt_ceker_ndower.setText("0");
        txt_ceker_ndower1.setText("0");

        cb_sayap_ndower.setSelected(false);
        txt_sayap_ndower.setText("0");
        txt_sayap_ndower1.setText("0");

        cb_kepala_ndower.setSelected(false);
        txt_kepala_ndower.setText("0");
        txt_kepala_ndower1.setText("0");

        cb_ayam_geprek.setSelected(false);
        txt_ayam_geprek.setText("0");
        txt_ayam_geprek1.setText("0");

        cb_mie_nelongso.setSelected(false);
        txt_mie_nelongso.setText("0");
        txt_mie_nelongso1.setText("0");

        cb_paket_nasi_ayam_geprek.setSelected(false);
        txt_paket_nasi_ayam_geprek.setText("0");
        txt_paket_nasi_ayam_geprek1.setText("0");

        cb_paket_mie_ayam_geprek.setSelected(false);
        txt_paket_mie_ayam_geprek.setText("0");
        txt_paket_mie_ayam_geprek1.setText("0");

        cb_nasi.setSelected(false);
        txt_nasi.setText("0");
        txt_nasi1.setText("0");

        cb_mie_goreng.setSelected(false);
        txt_mie_goreng.setText("0");
        txt_mie_goreng1.setText("0");

        cb_telor_ceplok.setSelected(false);
        txt_telor_ceplok.setText("0");
        txt_telor_ceplok1.setText("0");

        cb_air_mineral.setSelected(false);
        txt_air_mineral.setText("0");
        txt_air_mineral1.setText("0");

        cb_teh_pucuk.setSelected(false);
        txt_teh_pucuk.setText("0");
        txt_teh_pucuk1.setText("0");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printable(){
           public int print(Graphics pg, PageFormat pf,int pageNum){
                if(pageNum>0){
                   return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.93, 0.93);    
                hr1.paint(g2);
                return Printable.PAGE_EXISTS;
            } 
        });
        boolean a = job.printDialog();
        if(a){
            try{
                job.print();
            } catch(PrinterException ex){
                Logger.getLogger(frm_cetak_nilai.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_cetakActionPerformed

    public static void main(String args[]) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_simulasi_kasus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel banyak;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_hitung;
    private javax.swing.JButton btn_preview;
    private javax.swing.JCheckBox cb_air_mineral;
    private javax.swing.JCheckBox cb_ayam_geprek;
    private javax.swing.JCheckBox cb_ceker_ndower;
    private javax.swing.JCheckBox cb_kepala_ndower;
    private javax.swing.JCheckBox cb_mie_goreng;
    private javax.swing.JCheckBox cb_mie_nelongso;
    private javax.swing.JCheckBox cb_nasi;
    private javax.swing.JCheckBox cb_paket_mie_ayam_geprek;
    private javax.swing.JCheckBox cb_paket_nasi_ayam_geprek;
    private javax.swing.JCheckBox cb_sayap_ndower;
    private javax.swing.JCheckBox cb_teh_pucuk;
    private javax.swing.JCheckBox cb_telor_ceplok;
    private javax.swing.JCheckBox cb_usus_ndower;
    private javax.swing.JLabel daftar_menu;
    private javax.swing.JLabel harga;
    private javax.swing.JPanel hr1;
    private javax.swing.JSeparator hr2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel jumlah;
    private javax.swing.JLabel label_jumlah;
    private javax.swing.JLabel label_jumlah2;
    private javax.swing.JLabel label_nota;
    private javax.swing.JLabel label_tanggal;
    private javax.swing.JLabel label_tujuan;
    private javax.swing.JTable table_bon;
    private javax.swing.JLabel toko_kafe_mamat;
    private javax.swing.JLabel tujuan;
    private javax.swing.JTextArea txa_tujuan;
    private javax.swing.JTextField txt_air_mineral;
    private javax.swing.JTextField txt_air_mineral1;
    private javax.swing.JTextField txt_ayam_geprek;
    private javax.swing.JTextField txt_ayam_geprek1;
    private javax.swing.JTextField txt_ceker_ndower;
    private javax.swing.JTextField txt_ceker_ndower1;
    private javax.swing.JLabel txt_jumlah;
    private javax.swing.JLabel txt_jumlah_print;
    private javax.swing.JTextField txt_kepala_ndower;
    private javax.swing.JTextField txt_kepala_ndower1;
    private javax.swing.JTextField txt_mie_goreng;
    private javax.swing.JTextField txt_mie_goreng1;
    private javax.swing.JTextField txt_mie_nelongso;
    private javax.swing.JTextField txt_mie_nelongso1;
    private javax.swing.JTextField txt_nasi;
    private javax.swing.JTextField txt_nasi1;
    private javax.swing.JLabel txt_nota;
    private javax.swing.JTextField txt_paket_mie_ayam_geprek;
    private javax.swing.JTextField txt_paket_mie_ayam_geprek1;
    private javax.swing.JTextField txt_paket_nasi_ayam_geprek;
    private javax.swing.JTextField txt_paket_nasi_ayam_geprek1;
    private javax.swing.JTextField txt_sayap_ndower;
    private javax.swing.JTextField txt_sayap_ndower1;
    private javax.swing.JLabel txt_tanggal;
    private javax.swing.JTextField txt_teh_pucuk;
    private javax.swing.JTextField txt_teh_pucuk1;
    private javax.swing.JTextField txt_telor_ceplok;
    private javax.swing.JTextField txt_telor_ceplok1;
    private javax.swing.JLabel txt_tujuan;
    private javax.swing.JTextField txt_usus_ndower;
    private javax.swing.JTextField txt_usus_ndower1;
    // End of variables declaration//GEN-END:variables
}
