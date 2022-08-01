package kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113;

public class frm_utama extends javax.swing.JFrame {

    public frm_utama() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        data_mahasiswa = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        data_mata_kuliah = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        data_nilai = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        simulasi_nilai_akhir = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        cetak_nilai = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        simulasi_kasus = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("10121113 / Reihan Nasywan M.K");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113/photo/bilal.jpg"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113/photo/Abdullah.jpeg"))); // NOI18N
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        jLabel9.setText("10121102 / Abdullah Khatami");

        jLabel10.setText("10121109 / Bilal Nur Fauzi");

        jLabel11.setText("10121112 / Teuku Dika S. Z");

        jToolBar2.setRollover(true);
        jToolBar2.setEnabled(false);

        data_mahasiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113/icon/mahasiswa.png"))); // NOI18N
        data_mahasiswa.setText("Data Mahasiswa");
        data_mahasiswa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        data_mahasiswa.setPreferredSize(new java.awt.Dimension(100, 78));
        data_mahasiswa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        data_mahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_mahasiswaActionPerformed(evt);
            }
        });
        jToolBar2.add(data_mahasiswa);
        jToolBar2.add(jSeparator5);

        data_mata_kuliah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113/icon/mata_kuliah.png"))); // NOI18N
        data_mata_kuliah.setText("Data Mata Kuliah");
        data_mata_kuliah.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        data_mata_kuliah.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        data_mata_kuliah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_mata_kuliahActionPerformed(evt);
            }
        });
        jToolBar2.add(data_mata_kuliah);
        jToolBar2.add(jSeparator7);

        data_nilai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113/icon/nilai.png"))); // NOI18N
        data_nilai.setText("Data Nilai");
        data_nilai.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        data_nilai.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        data_nilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_nilaiActionPerformed(evt);
            }
        });
        jToolBar2.add(data_nilai);
        jToolBar2.add(jSeparator6);

        simulasi_nilai_akhir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113/icon/archiv.png"))); // NOI18N
        simulasi_nilai_akhir.setText("Simulasi Nilai Akhir");
        simulasi_nilai_akhir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        simulasi_nilai_akhir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        simulasi_nilai_akhir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simulasi_nilai_akhirActionPerformed(evt);
            }
        });
        jToolBar2.add(simulasi_nilai_akhir);
        jToolBar2.add(jSeparator8);

        cetak_nilai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113/icon/print.png"))); // NOI18N
        cetak_nilai.setText("Cetak Nilai");
        cetak_nilai.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cetak_nilai.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cetak_nilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetak_nilaiActionPerformed(evt);
            }
        });
        jToolBar2.add(cetak_nilai);
        jToolBar2.add(jSeparator9);

        simulasi_kasus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113/icon/bon.png"))); // NOI18N
        simulasi_kasus.setText("Simulasi Kasus");
        simulasi_kasus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        simulasi_kasus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        simulasi_kasus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simulasi_kasusActionPerformed(evt);
            }
        });
        jToolBar2.add(simulasi_kasus);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113/photo/Reihan.jpeg"))); // NOI18N
        jLabel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_reihan_nasywan_mustofa_kamil_10121113/photo/dika.jpg"))); // NOI18N
        jLabel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        jMenu1.setText("Aplikasi Kemahasiswaan");

        jMenuItem1.setText("Tentang Pembuat");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Log out");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void data_mahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_mahasiswaActionPerformed
        frm_mahasiswa mahasiswa = new frm_mahasiswa();
        mahasiswa.setVisible(true);
        dispose();
    }//GEN-LAST:event_data_mahasiswaActionPerformed

    private void data_mata_kuliahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_mata_kuliahActionPerformed
        frm_mata_kuliah matkul = new frm_mata_kuliah();
        matkul.setVisible(true);
        dispose();
    }//GEN-LAST:event_data_mata_kuliahActionPerformed

    private void data_nilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_nilaiActionPerformed
        frm_mahasiswa_nilai mahasiswa_nilai = new frm_mahasiswa_nilai();
        mahasiswa_nilai.setVisible(true);
        dispose();
    }//GEN-LAST:event_data_nilaiActionPerformed

    private void simulasi_nilai_akhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simulasi_nilai_akhirActionPerformed
        frm_simulasi_nilai simulasi_nilai = new frm_simulasi_nilai();
        simulasi_nilai.setVisible(true);
        dispose();
    }//GEN-LAST:event_simulasi_nilai_akhirActionPerformed

    private void cetak_nilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetak_nilaiActionPerformed
        frm_cetak_nilai cetak_nilai = new frm_cetak_nilai();
        cetak_nilai.setVisible(true);
        dispose();
    }//GEN-LAST:event_cetak_nilaiActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        frm_login login = new frm_login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void simulasi_kasusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simulasi_kasusActionPerformed
        dispose();
        frm_simulasi_kasus simulasi_kasus = new frm_simulasi_kasus();
        simulasi_kasus.setVisible(true);
    }//GEN-LAST:event_simulasi_kasusActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cetak_nilai;
    private javax.swing.JButton data_mahasiswa;
    private javax.swing.JButton data_mata_kuliah;
    private javax.swing.JButton data_nilai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JButton simulasi_kasus;
    private javax.swing.JButton simulasi_nilai_akhir;
    // End of variables declaration//GEN-END:variables
}
