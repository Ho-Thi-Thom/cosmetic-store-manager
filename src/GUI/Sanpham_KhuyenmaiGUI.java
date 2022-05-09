/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.SanphamBLL;
import BLL.Sanpham_KhuyenmaiBLL;
import DTO.SanphamDTO;
import DTO.Sanpham_KhuyenmaiDTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MYPC
 */
public class Sanpham_KhuyenmaiGUI extends javax.swing.JInternalFrame {

    Sanpham_KhuyenmaiBLL spkmBLL = new Sanpham_KhuyenmaiBLL();
    private ArrayList<Sanpham_KhuyenmaiDTO> list1;
    DefaultTableModel model1;
    SanphamBLL spBLL = new SanphamBLL();
    private ArrayList<SanphamDTO> list;
    DefaultTableModel model;

    public Sanpham_KhuyenmaiGUI() {
        initComponents();
         try {
            UIManager.setLookAndFeel(new com.jtattoo.plaf.graphite.GraphiteLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Sanpham_KhuyenmaiGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        list1 = spkmBLL.getAllsp_kmDTO();
        model1 = (DefaultTableModel) tblspkm.getModel();
        model1.setColumnIdentifiers(new Object[]{
            "STT", "MAKM", "MASP", "CÁCH TÍNH"
        });
        showTable();
        list = spBLL.getAllSanphamDTO();
        model = (DefaultTableModel) tblSanpham.getModel();
        model.setColumnIdentifiers(new Object[]{
            "STT", "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Đơn vị tính",
            "Mã loại", "Nhà sản xuất"
        });
        showTableSanpham();
        // spkmBLL.loadCombobox(this.cbMakm);
        btnXoa.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbMakm = new javax.swing.JComboBox<>();
        txtMasp = new javax.swing.JTextField();
        txtCachgiam = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        cbTimkiem = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanpham = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblspkm = new javax.swing.JTable();

        setTitle("Sản phẩm khuyến mãi");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SẢN PHẨM KHUYẾN MÃI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Mã KM :");

        jLabel3.setText("Mã SP :");

        jLabel4.setText("Cách giảm :");

        cbMakm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KM004", "KM005", "KM006", "KM007" }));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 13), new java.awt.Color(0, 0, 102))); // NOI18N

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sua.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/them.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xoa.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addGap(18, 18, 18)
                .addComponent(btnReset))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tblSanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblSanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanphamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanpham);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbMakm, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMasp, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtCachgiam, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(cbTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMasp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCachgiam, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbMakm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbTimkiem)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblspkm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblspkm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblspkmMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblspkm);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private int kt1() {
        int fag = 1;
        if (cbMakm.getSize().equals("")) {
            fag = 0;
        } else if (txtMasp.getText().length() == 0) {
            fag = 0;
        } else if (txtCachgiam.getText().length() == 0) {
            fag = 0;
        } else if (isNumeric(txtCachgiam.getText()) == false) {
            fag = 0;
            JOptionPane.showMessageDialog(rootPane, "% khuyến mãi là số");
        }
        return fag;
    }

    public static boolean isNumeric(String str) { //kiểm tra có phải số kiểu INT
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int selectedIndex = tblspkm.getSelectedRow();
        if (list1.size() == 0) {
            JOptionPane.showMessageDialog(rootPane,
                    "Hãy nhập thêm Sản phẩm khuyến mãi rồi sửa");
        } else if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(rootPane,
                    "Hãy chọn dòng có sản phẩm cần sửa rồi ấn sửa");
        } else {
            Sanpham_KhuyenmaiDTO spkmDTO = new Sanpham_KhuyenmaiDTO();
            spkmDTO.setMaKM(cbMakm.getSelectedItem().toString());
            spkmDTO.setMaSP(txtMasp.getText());
            spkmDTO.setCachtinh(Integer.parseInt(txtCachgiam.getText()));
            try {
                if (spkmBLL.suaspkmDTO(spkmDTO)) {
                    JOptionPane.showMessageDialog(rootPane, "Sửa thành công !");
                    model1.setRowCount(0);
                    list1 = spkmBLL.getAllsp_kmDTO();
                    showTable();
                    reset();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Sửa không thành công ");
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(rootPane, "Sửa không thành công ");
            }
        }
        btnThem.setEnabled(true);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int i = tblSanpham.getSelectedRow();
        String temp = tblSanpham.getValueAt(i, 1).toString();
        String temp1 = cbMakm.getSelectedItem().toString();
        int temp2 = 0;
        for (int j = 0; j < tblspkm.getRowCount(); j++) {
            if (tblspkm.getValueAt(j, 2).equals(temp) && tblspkm.getValueAt(j, 1).equals(temp1)) {
                temp2 = 1;
                break;
            }
        }
        if (temp2 == 1) {
            JOptionPane.showMessageDialog(rootPane, "Sản phẩm đã tồn tại trong mã khuyến mãi ");
            reset();
            return;
        }
        if (kt1() == 1) {
            Sanpham_KhuyenmaiDTO spkmDTO = new Sanpham_KhuyenmaiDTO();
            cbMakm.setEditable(true);
            spkmDTO.setMaKM(cbMakm.getSelectedItem().toString());
            spkmDTO.setMaSP(txtMasp.getText());
            spkmDTO.setCachtinh(Integer.parseInt(txtCachgiam.getText()));
            try {
                if (spkmBLL.addspkmDTO(spkmDTO)) {
                    JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
                    list1.add(spkmDTO);//them vao danh sach
                    showResult();
                    reset();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Thêm không thành công ");
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(rootPane, "Thêm không thành công ");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa đủ điều kiện !!!");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
        btnThem.setEnabled(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int removeIndex = tblspkm.getSelectedRow();
        if (removeIndex == -1) {
            JOptionPane.showMessageDialog(rootPane,
                    "Hãy chọn một dòng rồi ấn nút xóa");
        } else if (list1.size() == 0) {
            JOptionPane.showMessageDialog(rootPane,
                    "Không có thông tin  nào để xóa");
        } else {
            Sanpham_KhuyenmaiDTO spkmDTO = new Sanpham_KhuyenmaiDTO();
            spkmDTO.setMaKM(cbMakm.getSelectedItem().toString());
            spkmDTO.setMaSP(txtMasp.getText());
            if (spkmBLL.xoaspkmDTO(spkmDTO)) {
                if (JOptionPane.showConfirmDialog(this, "Delete Sản phẩm ?", "Confirm",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    model1.setRowCount(0);
                    list1 = new Sanpham_KhuyenmaiBLL().getAllsp_kmDTO();
                    showTable();
                }
                reset();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Xóa không thành công ");
            }
        }
        btnThem.setEnabled(true);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblSanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanphamMouseClicked
        int i = tblSanpham.getSelectedRow();
        txtMasp.setText(tblSanpham.getModel().getValueAt(i, 1).toString());
    }//GEN-LAST:event_tblSanphamMouseClicked

    private void tblspkmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblspkmMouseClicked
        int i = tblspkm.getSelectedRow();
        cbMakm.setSelectedItem(tblspkm.getModel().getValueAt(i, 1).toString());
        cbMakm.setEditable(false);
        txtMasp.setText(tblspkm.getModel().getValueAt(i, 2).toString());
        txtMasp.setEditable(false);
        txtCachgiam.setText(tblspkm.getModel().getValueAt(i, 3).toString());
        btnThem.setEnabled(false);

    }//GEN-LAST:event_tblspkmMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbMakm;
    private javax.swing.JComboBox<String> cbTimkiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblSanpham;
    private javax.swing.JTable tblspkm;
    private javax.swing.JTextField txtCachgiam;
    private javax.swing.JTextField txtMasp;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
 private void showTable() {
        int i = 1;
        for (Sanpham_KhuyenmaiDTO spkmDTO : list1) {
            model1.addRow(new Object[]{
                i++, spkmDTO.getMaKM(), spkmDTO.getMaSP(), spkmDTO.getCachtinh()
            });
        }
    }

    public void showResult() {
        int i = list1.size();
        Sanpham_KhuyenmaiDTO spkmDTO = list1.get(list1.size() - 1);
        model1.addRow(new Object[]{
            i++, spkmDTO.getMaKM(), spkmDTO.getMaSP(), spkmDTO.getCachtinh()
        });
    }

    public void reset() {
        txtMasp.setText("");
        cbMakm.setSelectedIndex(0);
        txtCachgiam.setText("");
    }

    public void showTableSanpham() {
        int i = 1;
        model.setRowCount(0);
        for (SanphamDTO spDTO : list) {
            model.addRow(new Object[]{
                i++, spDTO.getMasp(), spDTO.getTensp(), spDTO.getSoluong(),
                spDTO.getDongia(), spDTO.getDonvitinh(),
                spDTO.getMaloai(), spDTO.getMaNSX()
            });
        }
    }
}
