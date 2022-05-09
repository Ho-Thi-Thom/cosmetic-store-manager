/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.LoaiSpBLL;
import BLL.NHASXBLL;
import BLL.SanphamBLL_v2;
import DTO.ComboItem;
import DTO.LoaiSpDTO;
import DTO.NHASXDTO;
import DTO.SanphamDTO_v2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SanphamGUI extends javax.swing.JInternalFrame {

    SanphamBLL_v2 SanPhamBLL = new SanphamBLL_v2();
    private ArrayList<SanphamDTO_v2> list;
    DefaultTableModel model;

    public SanphamGUI() {
        initComponents();
//        try {
//            UIManager.setLookAndFeel(new com.jtattoo.plaf.graphite.GraphiteLookAndFeel());
//        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(SanphamGUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
        tblSanPham.removeColumn(tblSanPham.getColumnModel().getColumn(9));
        tblSanPham.removeColumn(tblSanPham.getColumnModel().getColumn(7));
        //tblSanPham.removeColumn(tblSanPham.getColumnModel().getColumn(8));
        advancedLabel1.show(false);
        txtAdvancedLoaiSp.show(false);
        advancedLabel2.show(false);
        txtAdvancedNhaSx.show(false);
        btnAdvanced.show(false);
        minLabel.show(false);
        maxLabel.show(false);
        minRange.show(false);
        maxRange.show(false);
        //  setLocationRelativeTo(null);
        SanPhamBLL.loadCombobox(this.cbLoaisp);
        SanPhamBLL.loadComboboxMaNSX(cbNsx);
        list = SanPhamBLL.getAllSanphamDTO_test();
        model = (DefaultTableModel) tblSanPham.getModel();
        tblSanPham.setRowSorter(new TableRowSorter<TableModel>(model));
        /*
        model.setColumnIdentifiers(new Object[]{
            "STT", "MALOAI", "TENLOAI"
        });*/
        category.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                advancedSearch();
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
        minRange.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                list.clear();
                list = SanPhamBLL.getAllSanphamDTO_test();
                model.setRowCount(0);
                showTable();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                list.clear();
                list = SanPhamBLL.getAllSanphamDTO_test();
                model.setRowCount(0);
                showTable();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                list.clear();
                list = SanPhamBLL.getAllSanphamDTO_test();
                model.setRowCount(0);
                showTable();
            }
        });
        maxRange.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                list.clear();
                list = SanPhamBLL.getAllSanphamDTO_test();
                model.setRowCount(0);
                showTable();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                list.clear();
                list = SanPhamBLL.getAllSanphamDTO_test();
                model.setRowCount(0);
                showTable();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                list.clear();
                list = SanPhamBLL.getAllSanphamDTO_test();
                model.setRowCount(0);
                showTable();
            }
        });
        txtAdvancedLoaiSp.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                updateAdvancedFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                updateAdvancedFilter();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                updateAdvancedFilter();
            }
        });
        txtAdvancedNhaSx.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                updateAdvancedFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                updateAdvancedFilter();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                updateAdvancedFilter();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTenSp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaSp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSl = new javax.swing.JTextField();
        cbLoaisp = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtDonVi = new javax.swing.JTextField();
        cbNsx = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnReset1 = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        category = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        minLabel = new javax.swing.JLabel();
        minRange = new javax.swing.JTextField();
        maxLabel = new javax.swing.JLabel();
        maxRange = new javax.swing.JTextField();
        btnAdvanced = new javax.swing.JButton();
        advancedLabel1 = new javax.swing.JLabel();
        txtAdvancedLoaiSp = new javax.swing.JTextField();
        advancedLabel2 = new javax.swing.JLabel();
        txtAdvancedNhaSx = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();

        setTitle("Sản phẩm");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(0, 51, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Tên sản phẩm:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Mã sản phẩm:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Nhà sản xuất:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Loại sản phẩm:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Đơn giá:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Số lượng:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Đơn vị tính:");

        btnThem.setBackground(new java.awt.Color(153, 153, 255));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/them.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
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

        btnXoa.setBackground(new java.awt.Color(153, 153, 255));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xoa.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnReset1.setBackground(new java.awt.Color(153, 153, 255));
        btnReset1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReset1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btnReset1.setText("Reset");
        btnReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset1ActionPerformed(evt);
            }
        });

        btnExport.setBackground(new java.awt.Color(153, 153, 255));
        btnExport.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnImport.setBackground(new java.awt.Color(153, 153, 255));
        btnImport.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnImport.setText("Import");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(153, 153, 255));
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(btnExport, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addGap(18, 36, Short.MAX_VALUE)
                        .addComponent(btnImport, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        category.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Đơn vị tính", "Loại sản phẩm", "Nhà sản xuất", "Nâng cao..." }));
        category.setPreferredSize(new java.awt.Dimension(60, 30));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });

        txtSearch.setPreferredSize(new java.awt.Dimension(60, 30));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        minLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        minLabel.setText("Giá Từ:");

        maxLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        maxLabel.setText("đến");

        btnAdvanced.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAdvanced.setText("Xác nhận");
        btnAdvanced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdvancedActionPerformed(evt);
            }
        });

        advancedLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        advancedLabel1.setText("Loại sản phẩm:");

        txtAdvancedLoaiSp.setPreferredSize(new java.awt.Dimension(60, 30));
        txtAdvancedLoaiSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdvancedLoaiSpActionPerformed(evt);
            }
        });

        advancedLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        advancedLabel2.setText("Nhà sản xuất:");

        txtAdvancedNhaSx.setPreferredSize(new java.awt.Dimension(60, 30));
        txtAdvancedNhaSx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdvancedNhaSxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(advancedLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAdvancedLoaiSp, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(advancedLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAdvancedNhaSx, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(minLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minRange, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(maxLabel)
                                .addGap(6, 6, 6)
                                .addComponent(maxRange, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(btnAdvanced))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minRange, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maxRange, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdvanced, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(advancedLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAdvancedLoaiSp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAdvancedNhaSx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(advancedLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbLoaisp, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSl, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txtDonVi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbLoaisp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbNsx))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN SẢN PHẨM");

        tblSanPham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên sản phẩm", "SL", "Đơn giá", "Đơn vị tính", "Tên loại", "Mã loại", "Nhà sản xuất", "Mã nhà sản xuất"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.setGridColor(new java.awt.Color(0, 0, 0));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        //thêm cho sản phẩm
        if (ktsp() == 1) {
            SanphamDTO_v2 spDTO = new SanphamDTO_v2();
            txtMaSp.setEditable(true);
            spDTO.setMasp(txtMaSp.getText());
            spDTO.setTensp(txtTenSp.getText());
            spDTO.setSoluong(Integer.parseInt(txtSl.getText()));
            spDTO.setDongia(txtDonGia.getText());
            spDTO.setDonvitinh(txtDonVi.getText());
            //Handle add category
            Object item = cbLoaisp.getSelectedItem();
            String value = ((ComboItem) item).getValue();
            LoaiSpBLL loaiBLL = new LoaiSpBLL();
            LoaiSpDTO loai = loaiBLL.getLoaiSpDTO(value);
            spDTO.setLoaisp(loai);
            //Handle add provider
            Object item2 = cbNsx.getSelectedItem();
            String value2 = ((ComboItem) item2).getValue();
            NHASXBLL nhasxBLL = new NHASXBLL();
            NHASXDTO nhasx = nhasxBLL.getNhaSxDTO(value2);
            spDTO.setNhasx(nhasx);
            for (SanphamDTO_v2 sp : list) {
                if (sp.getMasp().equals(txtMaSp.getText())) {
                    JOptionPane.showMessageDialog(rootPane, "Đã tồn tại mã sản phẩm");
                    return;
                }
            }
            try {
                if (SanPhamBLL.addSanphamDTO_test(spDTO)) {
                    JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
                    list.add(spDTO);//them vao danh sach
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
        if (ktsp() == 1) {
            int selectedIndex = tblSanPham.getSelectedRow();
            if (list.size() == 0) {
                JOptionPane.showMessageDialog(rootPane,
                        "Hãy nhập thêm Sản phẩm rồi sửa");
            } else if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(rootPane,
                        "Hãy chọn dòng có sản phẩm cần sửa rồi ấn sửa");
            } else {
                SanphamDTO_v2 spDTO = new SanphamDTO_v2();
                txtMaSp.setEditable(true);
                spDTO.setMasp(txtMaSp.getText());
                spDTO.setTensp(txtTenSp.getText());
                spDTO.setSoluong(Integer.parseInt(txtSl.getText()));
                spDTO.setDongia(txtDonGia.getText());
                spDTO.setDonvitinh(txtDonVi.getText());
                //Handle add category
                Object item = cbLoaisp.getSelectedItem();
                String value = ((ComboItem) item).getValue();
                LoaiSpBLL loaiBLL = new LoaiSpBLL();
                LoaiSpDTO loai = loaiBLL.getLoaiSpDTO(value);
                spDTO.setLoaisp(loai);
                //Handle add provider
                Object item2 = cbNsx.getSelectedItem();
                String value2 = ((ComboItem) item2).getValue();
                NHASXBLL nhasxBLL = new NHASXBLL();
                NHASXDTO nhasx = nhasxBLL.getNhaSxDTO(value2);
                spDTO.setNhasx(nhasx);

                try {
                    if (SanPhamBLL.suaSanphamDTO_test(spDTO)) {
                        JOptionPane.showMessageDialog(rootPane, "Sửa thành công !");
                        model.setRowCount(0);
                        list = SanPhamBLL.getAllSanphamDTO_test();
                        showTable();
                        reset();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Sửa không thành công ");
                    }
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(rootPane, "Sửa không thành công ");
                }
            }

        }
        btnThem.setEnabled(true);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
//        int removeIndex = tblSanPham.getSelectedRow();
//        if (removeIndex == -1) {
//            JOptionPane.showMessageDialog(rootPane,
//                    "Hãy chọn một dòng rồi ấn nút xóa");
//        } else if (list.size() == 0) {
//            JOptionPane.showMessageDialog(rootPane,
//                    "Không có sản phẩm nào để xóa");
//        } else {
//            SanphamDTO_v2 SanPhamDTO = new SanphamDTO_v2();
//            SanPhamDTO.setMasp(txtMaSp.getText());
//            if (SanPhamBLL.xoaSanphamDTO_test(SanPhamDTO)) {
//                if (JOptionPane.showConfirmDialog(this, "Xoá sản phẩm?", "Confirm",
//                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//                    model.setRowCount(0);
//                    list = new SanphamBLL_v2().getAllSanphamDTO_test();
//                    showTable();
//                }
//                reset();
//            } else {
//                JOptionPane.showMessageDialog(rootPane, "Xóa không thành công ");
//            }
//        }
        btnThem.setEnabled(true);
        JOptionPane.showMessageDialog(rootPane, "Chức năng đang được phát triển");
    }//GEN-LAST:event_btnXoaActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        // TODO add your handling code here:
        Object selected = category.getSelectedItem();
        if ("Nâng cao...".equals(selected) == false) {
            list.clear();
            list = SanPhamBLL.getAllSanphamDTO_test();
            model.setRowCount(0);
            showTable();
        }
    }//GEN-LAST:event_categoryActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        model.setRowCount(0);
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelJTableImport = null;

        String defaultCurentDirectoryPath = "C:\\temp";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurentDirectoryPath);
        int excelChooser = excelFileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = excelFileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);

                excelJTableImport = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
                for (int row = 0; row < excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);

                    XSSFCell excelSTT = excelRow.getCell(0);
                    XSSFCell excelMasp = excelRow.getCell(1);
                    XSSFCell excelTenSp = excelRow.getCell(2);
                    XSSFCell excelSoluong = excelRow.getCell(3);
                    XSSFCell excelDongia = excelRow.getCell(4);
                    XSSFCell excelDonvitinh = excelRow.getCell(5);
                    XSSFCell excelTenloai = excelRow.getCell(6);
                    XSSFCell excelMaloai = excelRow.getCell(7);
                    XSSFCell excelNhax = excelRow.getCell(8);
                    XSSFCell excelMansx = excelRow.getCell(9);
                    model.addRow(new Object[]{
                        excelSTT, excelMasp, excelTenSp, excelSoluong, excelDongia, excelDonvitinh,
                        excelTenloai, excelMaloai, excelNhax, excelMansx
                    });
                    //                    for(int column=0;column<excelRow.getLastCellNum();column++){
                    //                        XSSFCell excelCell=excelRow.getCell(column);
                    //                        System.out.println(excelCell.getStringCellValue());
                    //                    }
                }
                JOptionPane.showMessageDialog(null, "Imported Successfully ! ");
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnImportActionPerformed

    private void btnAdvancedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdvancedActionPerformed
        // TODO add your handling code here:
        String min = minRange.getText();
        String max = maxRange.getText();
        try {
            list.clear();
            list = SanPhamBLL.getInRangeSanphamDTO_test(min, max);
            model.setRowCount(0);
            showTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Search không thành công");
        }
    }//GEN-LAST:event_btnAdvancedActionPerformed

    private void txtAdvancedLoaiSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdvancedLoaiSpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdvancedLoaiSpActionPerformed

    private void txtAdvancedNhaSxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdvancedNhaSxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdvancedNhaSxActionPerformed

    private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset1ActionPerformed
        reset();
    }//GEN-LAST:event_btnReset1ActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;

        String[] title = new String[]{"STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Đơn vị tính", "Tên loại sản phẩm",
            "Mã loại sản phẩm", "Nhà sản xuất", "Mã nhà sản xuất"};
        Row row;
        Cell cell;
        int RowIndex = 0, ColIndex = 0;

        JFileChooser excelFileChooser = new JFileChooser("C:\\temp");
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                excelJTableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");

                row = excelSheet.createRow(RowIndex++);
                for (int i = 0; i < title.length; i++) {
                    cell = row.createCell(ColIndex++);
                    cell.setCellValue(title[i]);
                    cell.setCellStyle(createCellStyleForTitle(excelSheet));
                }

                for (int i = 1; i < tblSanPham.getRowCount() + 1; i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < title.length; j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(model.getValueAt(i - 1, j).toString());
                    }
                }
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Exported Successfully ! ");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }
                    if (excelJTableExporter != null) {
                        excelJTableExporter.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnExportActionPerformed
    public CellStyle createCellStyleForTitle(Sheet sheet) {
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 13); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color
        // Tạo cell style áp dụng font ở trên
        // Sử dụng màu nền xanh (Blue), định dạng border dưới 
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }
    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int i = tblSanPham.getSelectedRow();
        txtMaSp.enable(false);
        txtMaSp.setText(tblSanPham.getModel().getValueAt(i, 1).toString());
        txtTenSp.setText(tblSanPham.getModel().getValueAt(i, 2).toString());
        txtSl.setText(tblSanPham.getModel().getValueAt(i, 3).toString());
        txtDonGia.setText(tblSanPham.getModel().getValueAt(i, 4).toString());
        txtDonVi.setText(tblSanPham.getModel().getValueAt(i, 5).toString());
        ComboItem item = new ComboItem(tblSanPham.getModel().getValueAt(i, 6).toString(), tblSanPham.getModel().getValueAt(i, 7).toString());
        for (int j = 0; j < cbLoaisp.getItemCount(); j++) {
            if (cbLoaisp.getItemAt(j).getKey().equals(item.getKey())) {
                cbLoaisp.setSelectedIndex(j);
            }
        }
        ComboItem item2 = new ComboItem(tblSanPham.getModel().getValueAt(i, 8).toString(), tblSanPham.getModel().getValueAt(i, 9).toString());
        for (int j = 0; j < cbNsx.getItemCount(); j++) {
            if (cbNsx.getItemAt(j).getKey().equals(item2.getKey())) {
                cbNsx.setSelectedIndex(j);
            }
        }
        btnThem.setEnabled(false);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Chức năng đang được phát triển");
    }//GEN-LAST:event_btnLuuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel advancedLabel1;
    private javax.swing.JLabel advancedLabel2;
    private javax.swing.JButton btnAdvanced;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnReset1;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JComboBox<ComboItem> cbLoaisp;
    private javax.swing.JComboBox<ComboItem> cbNsx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel maxLabel;
    private javax.swing.JTextField maxRange;
    private javax.swing.JLabel minLabel;
    private javax.swing.JTextField minRange;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtAdvancedLoaiSp;
    private javax.swing.JTextField txtAdvancedNhaSx;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtDonVi;
    private javax.swing.JTextField txtMaSp;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSl;
    private javax.swing.JTextField txtTenSp;
    // End of variables declaration//GEN-END:variables
 public void showTable() {
        int i = 1;
        for (SanphamDTO_v2 spDTO : list) {
            model.addRow(new Object[]{
                i++, spDTO.getMasp(), spDTO.getTensp(),
                spDTO.getSoluong(), spDTO.getDongia(), spDTO.getDonvitinh(),
                spDTO.getLoaisp().getTENLOAI(), spDTO.getLoaisp().getMALOAI(),
                spDTO.getNhasx().getTENNSX(), spDTO.getNhasx().getMANSX(),});
        }
    }

    public void showResult() {
        int i = list.size();
        SanphamDTO_v2 spDTO = list.get(list.size() - 1);
        model.addRow(new Object[]{
            i++, spDTO.getMasp(), spDTO.getTensp(),
            spDTO.getSoluong(), spDTO.getDongia(), spDTO.getDonvitinh(),
            spDTO.getLoaisp().getTENLOAI(), spDTO.getLoaisp().getMALOAI(),
            spDTO.getNhasx().getTENNSX(), spDTO.getNhasx().getMANSX(),});
    }

    public void reset() {
        txtMaSp.setText("");
        txtTenSp.setText("");
        txtSl.setText("");
        txtDonGia.setText("");
        txtDonVi.setText("");
        cbLoaisp.setSelectedIndex(0);
        cbNsx.setSelectedIndex(0);
        txtMaSp.setEnabled(true);
    }

    protected void updateFilter() {
        Object selected = category.getSelectedItem();
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tblSanPham.getRowSorter();
        String text = "(?i)" + txtSearch.getText();
        if ("Nâng cao...".equals(selected)) {
            sorter.setRowFilter(null);
        } else {
            int col = -1;
            if ("Mã sản phẩm".equals(selected)) {
                col = 1;
            } else if ("Tên sản phẩm".equals(selected)) {
                col = 2;
            } else if ("Số lượng".equals(selected)) {
                col = 3;
            } else if ("Đơn giá".equals(selected)) {
                col = 4;
            } else if ("Đơn vị tính".equals(selected)) {
                col = 5;
            } else if ("Loại sản phẩm".equals(selected)) {
                col = 6;
            } else if ("Nhà sản xuất".equals(selected)) {
                col = 8;
            }
            sorter.setRowFilter(RowFilter.regexFilter(text, col));
        }
    }

    protected void updateAdvancedFilter() {
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tblSanPham.getRowSorter();
        List<RowFilter<Object, Object>> filters = new ArrayList<>(2);
        filters.add(RowFilter.regexFilter(txtAdvancedLoaiSp.getText(), 6));
        filters.add(RowFilter.regexFilter(txtAdvancedNhaSx.getText(), 8));
        RowFilter rf = RowFilter.andFilter(filters);
        sorter.setRowFilter(rf);
    }

    public void advancedSearch() {
        Object selected = category.getSelectedItem();
        if ("Nâng cao...".equals(selected)) {
            txtSearch.setVisible(false);
            advancedLabel1.setVisible(true);
            txtAdvancedLoaiSp.setVisible(true);
            advancedLabel2.setVisible(true);
            txtAdvancedNhaSx.setVisible(true);
            btnAdvanced.setVisible(true);
            minLabel.setVisible(true);
            maxLabel.setVisible(true);
            minRange.setVisible(true);
            maxRange.setVisible(true);
        } else {
            txtSearch.setVisible(true);
            advancedLabel1.setVisible(false);
            txtAdvancedLoaiSp.setVisible(false);
            advancedLabel2.setVisible(false);
            txtAdvancedNhaSx.setVisible(false);
            btnAdvanced.setVisible(false);
            minLabel.setVisible(false);
            maxLabel.setVisible(false);
            minRange.setVisible(false);
            maxRange.setVisible(false);
        }
    }

    public static boolean isNumeric(String str) { //kiểm tra có phải số kiểu INT
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNumericdouble(String str) { //kiểm tra có phải số kiểu DOUBLE
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int ktsp() {
        SanphamDTO_v2 spDTO = new SanphamDTO_v2();
        int fag = 1;
        if (txtMaSp.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập mã sản phẩm ");
            fag = 0;
        } else if (txtTenSp.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập Tên sản phẩm ");
            fag = 0;
        } else if (txtSl.getText().length() == 0
                || isNumeric(txtSl.getText()) == false) {
            JOptionPane.showMessageDialog(rootPane,
                    "Bạn chưa nhập số lượng hoặc số lượng bạn nhập không phải số ");
            fag = 0;
        } else if (txtDonGia.getText().length() == 0
                || isNumericdouble(txtDonGia.getText()) == false) {
            JOptionPane.showMessageDialog(rootPane,
                    "Bạn chưa nhập đơn giá hoặc đơn giá bạn nhập không phải kiểu số ");
            fag = 0;
        } else if (txtDonVi.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane,
                    "Bạn chưa nhập đơn vị tính cho sản phẩm ");
            fag = 0;
        }
        return fag;
    }
}
