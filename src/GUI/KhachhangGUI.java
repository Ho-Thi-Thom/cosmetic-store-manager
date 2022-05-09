/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.KhachhangBLL;
import DTO.KhachhangDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class KhachhangGUI extends javax.swing.JInternalFrame {

    KhachhangBLL KhachhangBLL = new KhachhangBLL();
    private ArrayList<KhachhangDTO> list;
    DefaultTableModel model;

    public KhachhangGUI() {
        initComponents();
        jRadioButton1.setSelected(true);
        // setLocationRelativeTo(null);
         try {
            UIManager.setLookAndFeel(new com.jtattoo.plaf.graphite.GraphiteLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(KhachhangGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        list = KhachhangBLL.getAllKhachhangDTO();
        model = (DefaultTableModel) tblKhachhang.getModel();
        tblKhachhang.setRowSorter(new TableRowSorter<TableModel>(model));
        /*
        model.setColumnIdentifiers(new Object[]{
            "STT", "MALOAI", "TENLOAI"
        });*/
        category.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                updateFilter();
            }
        });
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                updateFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                updateFilter();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                updateFilter();
            }
        });

        showTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTenKh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaKh = new javax.swing.JTextField();
        category = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDiachi = new javax.swing.JTextField();
        txtNgaysinh = new com.toedter.calendar.JDateChooser();
        txtSdt = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachhang = new javax.swing.JTable();

        setTitle("Khách hàng");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(0, 51, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tên khách hàng:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Mã khách hàng:");

        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã khách hàng", "Tên khách hàng", "Ngày sinh", "Giới tính", "Số điện thoại", "Email", "Địa chỉ" }));
        category.setPreferredSize(new java.awt.Dimension(60, 30));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Số điện thoại:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Email:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Ngày sinh:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Địa chỉ:");

        txtNgaysinh.setDateFormatString("yyyy-MM-dd");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Giới tính:");

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Nam");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Nữ");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 13), new java.awt.Color(0, 0, 102))); // NOI18N

        btnThem.setBackground(new java.awt.Color(153, 153, 255));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/them.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(153, 153, 255));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xoa.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(153, 153, 255));
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sua.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(153, 153, 255));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnThem)
                .addGap(31, 31, 31)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnReset)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(23, 23, 23)
                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addGap(430, 430, 430))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaKh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton3))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(42, 42, 42)
                                .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)))
                        .addGap(40, 40, 40))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTenKh))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaKh)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN KHÁCH HÀNG");

        tblKhachhang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        tblKhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã KH", "Tên khách hàng", "Ngày sinh", "Giới tính", "Số điện thoại", "Email", "Địa chỉ"
            }
        ));
        tblKhachhang.setGridColor(new java.awt.Color(0, 0, 0));
        tblKhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachhang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (this.ktkh() == 1) {
            KhachhangDTO khDTO = new KhachhangDTO();
            txtMaKh.setEditable(true);
            khDTO.setMaKH(txtMaKh.getText());
            khDTO.setTenKH(txtTenKh.getText());
            khDTO.setEmail(txtEmail.getText());
            khDTO.setSdt(txtSdt.getText());
            khDTO.setDiachi(txtDiachi.getText());
            DateFormat dob = new SimpleDateFormat("yyyy-MM-dd");
            Date date = txtNgaysinh.getDate();
            String ngaysinh = dob.format(date);
            khDTO.setNgaysinh(ngaysinh);
            if (buttonGroup1.isSelected(jRadioButton1.getModel())) {
                khDTO.setGioitinh("Nam");
            } else {
                khDTO.setGioitinh("Nữ");
            }
            for (KhachhangDTO sp : list) {
                if (sp.getMaKH().equals(txtMaKh.getText())) {
                    JOptionPane.showMessageDialog(rootPane, "Đã tồn tại mã khách hàng");
                    return;
                }
            }
            try {
                if (KhachhangBLL.addKhachhangDTO(khDTO)) {
                    JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
                    list.add(khDTO);//them vao danh sach
                    showResult();
                    reset();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Thêm không thành công ");
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(rootPane, "Thêm không thành công ");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (this.ktkh() == 1) {
            int selectedIndex = tblKhachhang.getSelectedRow();
            if (list.size() == 0) {
                JOptionPane.showMessageDialog(rootPane,
                        "Hãy nhập thêm khách hàng rồi sửa");
            } else if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(rootPane,
                        "Hãy chọn dòng có khách hàng cần sửa rồi ấn sửa");
            } else {
                KhachhangDTO khDTO = new KhachhangDTO();
                txtMaKh.setEditable(true);
                khDTO.setMaKH(txtMaKh.getText());
                khDTO.setTenKH(txtTenKh.getText());
                khDTO.setEmail(txtEmail.getText());
                khDTO.setSdt(txtSdt.getText());
                khDTO.setDiachi(txtDiachi.getText());
                DateFormat dob = new SimpleDateFormat("yyyy-MM-dd");
                Date date = txtNgaysinh.getDate();
                String ngaysinh = dob.format(date);
                khDTO.setNgaysinh(ngaysinh);
                if (buttonGroup1.isSelected(jRadioButton1.getModel())) {
                    khDTO.setGioitinh("Nam");
                } else {
                    khDTO.setGioitinh("Nữ");
                }
                try {
                    if (KhachhangBLL.suaKhachhangDTO(khDTO)) {
                        JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
                        model.setRowCount(0);
                        list = KhachhangBLL.getAllKhachhangDTO();
                        showTable();
                        reset();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Sửa không thành công ");
                    }
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(rootPane, "Thêm không thành công ");
                }
            }
        }
        btnThem.setEnabled(true);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
//        int removeIndex = tblKhachhang.getSelectedRow();
//        if (removeIndex == -1) {
//            JOptionPane.showMessageDialog(rootPane,
//                    "Hãy chọn một dòng rồi ấn nút xóa");
//        } else if (list.size() == 0) {
//            JOptionPane.showMessageDialog(rootPane,
//                    "Không có khách hàng nào để xóa");
//        } else {
//            KhachhangDTO KhachhangDTO = new KhachhangDTO();
//            KhachhangDTO.setMaKH(txtMaKh.getText());
//            if (KhachhangBLL.xoaKhachhangDTO(KhachhangDTO)) {
//                if (JOptionPane.showConfirmDialog(this, "Xoá khách hàng?", "Confirm",
//                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//                    model.setRowCount(0);
//                    list = new KhachhangBLL().getAllKhachhangDTO();
//                    showTable();
//                }
//                reset();
//            } else {
//                JOptionPane.showMessageDialog(rootPane, "Xóa không thành công ");
//            }
//        }
          btnThem.setEnabled(true);
          JOptionPane.showMessageDialog(rootPane, "Chức năng đang được phát triển ");
    }//GEN-LAST:event_btnXoaActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        // TODO add your handling code here:
        Object selected = category.getSelectedItem();
        if ("Nâng cao...".equals(selected) == false) {
            list.clear();
            list = KhachhangBLL.getAllKhachhangDTO();
            model.setRowCount(0);
            showTable();
        }
    }//GEN-LAST:event_categoryActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void tblKhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachhangMouseClicked
        int i = tblKhachhang.getSelectedRow();
        txtMaKh.enable(false);
        txtMaKh.setText(tblKhachhang.getModel().getValueAt(i, 1).toString());
        txtTenKh.setText(tblKhachhang.getModel().getValueAt(i, 2).toString());
        String date = tblKhachhang.getModel().getValueAt(i, 3).toString();
        try {
            Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            txtNgaysinh.setDate(dob);
        } catch (ParseException ex) {
            Logger.getLogger(KhachhangGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (tblKhachhang.getModel().getValueAt(i, 4).toString().trim().equals("Nam")) {
            jRadioButton1.setSelected(true);
        } else {
            jRadioButton3.setSelected(true);
        }
        txtSdt.setText(tblKhachhang.getModel().getValueAt(i, 5).toString());
        txtEmail.setText(tblKhachhang.getModel().getValueAt(i, 6).toString());
        txtDiachi.setText(tblKhachhang.getModel().getValueAt(i, 7).toString());
    }//GEN-LAST:event_tblKhachhangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKhachhang;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaKh;
    private com.toedter.calendar.JDateChooser txtNgaysinh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenKh;
    // End of variables declaration//GEN-END:variables

    public void showTable() {
        int i = 1;
        for (KhachhangDTO khDTO : list) {
            model.addRow(new Object[]{
                i++, khDTO.getMaKH(), khDTO.getTenKH(),
                khDTO.getNgaysinh(), khDTO.getGioitinh(), khDTO.getSdt(),
                khDTO.getEmail(), khDTO.getDiachi()
            });
        }
    }

    public void showResult() {
        int i = list.size();
        KhachhangDTO khDTO = list.get(list.size() - 1);
        model.addRow(new Object[]{
            i++, khDTO.getMaKH(), khDTO.getTenKH(),
            khDTO.getNgaysinh(), khDTO.getGioitinh(), khDTO.getSdt(),
            khDTO.getEmail(), khDTO.getDiachi()
        });
    }

    public void reset() {
        txtMaKh.setEnabled(true);
        txtMaKh.setText("");
        txtTenKh.setText("");
        txtSdt.setText("");
        txtEmail.setText("");
        txtDiachi.setText("");
        txtNgaysinh.setDate(null);
    }

    protected void updateFilter() {
        Object selected = category.getSelectedItem();
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tblKhachhang.getRowSorter();
        String text = "(?i)" + txtSearch.getText();
        int col = -1;
        if ("Mã khách hàng".equals(selected)) {
            col = 1;
        } else if ("Tên khách hàng".equals(selected)) {
            col = 2;
        } else if ("Ngày sinh".equals(selected)) {
            col = 3;
        } else if ("Giới tính".equals(selected)) {
            col = 4;
        } else if ("Số điện thoại".equals(selected)) {
            col = 5;
        } else if ("Email".equals(selected)) {
            col = 6;
        } else if ("Địa chỉ".equals(selected)) {
            col = 7;
        }
        sorter.setRowFilter(RowFilter.regexFilter(text, col));
    }

    private int ktkh() {
        int fag = 1;

        if (txtMaKh.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập mã khách hàng");
            fag = 0;
        } else if (txtTenKh.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập tên khách hàng ");
            fag = 0;
        } else if (txtSdt.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập số điện thoại ");
            fag = 0;
        } else if (txtEmail.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập email ");
            fag = 0;
        } else if (txtDiachi.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập địa chỉ ");
            fag = 0;
        }
        return fag;
    }

}
