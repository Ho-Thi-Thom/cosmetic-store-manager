/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.HoadonBLL;
import BLL.PhieunhapBLL;
import BLL.ThongkeBLL;
import DTO.HoadonDTO;
import DTO.PhieunhapDTO;
import DTO.ThongkeDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class ThongkeGUI extends javax.swing.JInternalFrame {

    ThongkeBLL tkBLL = new ThongkeBLL();
    private ArrayList<ThongkeDTO> listTKslbd;
    DefaultTableModel model;
    private ArrayList<ThongkeDTO> listDT;
    DefaultTableModel model1;
    HoadonBLL hdBLL = new HoadonBLL();
    private ArrayList<HoadonDTO> listHD;
    PhieunhapBLL pnBLL = new PhieunhapBLL();
    private ArrayList<PhieunhapDTO> listPN;
    DefaultTableModel model2 = new DefaultTableModel();
    float[] monthRevenue = new float[12];

    public ThongkeGUI() {
        initComponents();
         try {
            UIManager.setLookAndFeel(new com.jtattoo.plaf.graphite.GraphiteLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ThongkeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        listHD = hdBLL.getAllHoadonDTO();
        listPN = pnBLL.getAllPhieunhapDTO();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rdoThongkeslban = new javax.swing.JRadioButton();
        rdoThongkedoanhthu = new javax.swing.JRadioButton();
        txtTungay = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        txtDenngay = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        rdoloinhuan = new javax.swing.JRadioButton();
        txtNam = new com.toedter.calendar.JYearChooser();
        jLabel4 = new javax.swing.JLabel();
        btnThongke = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongke = new javax.swing.JTable();

        setTitle("Thống kê");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("THỐNG KÊ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(rdoThongkeslban);
        rdoThongkeslban.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdoThongkeslban.setText("Thống kê số lượng các sản phẩm đã bán :");

        buttonGroup1.add(rdoThongkedoanhthu);
        rdoThongkedoanhthu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdoThongkedoanhthu.setText("Thống kê doanh thu theo tháng ");
        rdoThongkedoanhthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoThongkedoanhthuActionPerformed(evt);
            }
        });

        txtTungay.setDateFormatString("yyyy-MM-dd");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Từ ngày :");

        txtDenngay.setDateFormatString("yyyy/MM/dd");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Đến ngày :");

        buttonGroup1.add(rdoloinhuan);
        rdoloinhuan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdoloinhuan.setText("Thống kê lợi nhuận ");
        rdoloinhuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoloinhuanActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Năm :");

        btnThongke.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThongke.setText("Thống kê");
        btnThongke.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongkeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(rdoThongkedoanhthu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoThongkeslban, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
                    .addComponent(rdoloinhuan))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTungay, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDenngay, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnThongke, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTungay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoThongkeslban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDenngay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rdoThongkedoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(rdoloinhuan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThongke, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblThongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblThongke);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1013, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdoThongkedoanhthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoThongkedoanhthuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoThongkedoanhthuActionPerformed

    private void rdoloinhuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoloinhuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoloinhuanActionPerformed
 public int kt() {
        int fag = 1;
        Date bd=txtTungay.getDate();
        Date kt=txtDenngay.getDate();
        if (txtTungay.getDate().toString().length() == 0) {
            fag = 0;
        } else if (txtDenngay.getDate().toString().length() == 0) {
            fag = 0;
        }else if(kt.before(bd)){
            fag = 0;
        }
        return fag;
    }
    private void btnThongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongkeActionPerformed
        if (rdoThongkeslban.isSelected()) {
            if (kt() == 1) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String tungay = sdf.format(txtTungay.getDate());
                String denngay = sdf.format(txtDenngay.getDate());
                listTKslbd = tkBLL.getAllTKSLBDDTO(tungay, denngay);
                model = (DefaultTableModel) tblThongke.getModel();
                model.setColumnIdentifiers(new Object[]{
                    "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng bán được "
                });
                showTable();

            } else {
                JOptionPane.showMessageDialog(rootPane, "Chưa nhập đủ thông tin để thống kê hoặc ngày thống kê sai: ");
            }
        } else if (rdoThongkedoanhthu.isSelected()) {
            int nam = txtNam.getYear();
            String nam1 = Integer.toString(nam);
            listDT = tkBLL.getAlldoanhthuDTO(nam1);
            model1 = (DefaultTableModel) tblThongke.getModel();
            model1.setColumnIdentifiers(new Object[]{
                "STT", "Tháng", "Doanh thu"
            });
            showTable1();
        } else if (rdoloinhuan.isSelected()) {
            model2 = (DefaultTableModel) tblThongke.getModel();
            model2.setColumnIdentifiers(new Object[]{
                "Tháng", "Lợi nhuận"
            });
            statistic(txtNam.getYear());
            showTable2();
        }
    }//GEN-LAST:event_btnThongkeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThongke;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoThongkedoanhthu;
    private javax.swing.JRadioButton rdoThongkeslban;
    private javax.swing.JRadioButton rdoloinhuan;
    private javax.swing.JTable tblThongke;
    private com.toedter.calendar.JDateChooser txtDenngay;
    private com.toedter.calendar.JYearChooser txtNam;
    private com.toedter.calendar.JDateChooser txtTungay;
    // End of variables declaration//GEN-END:variables
 private void showTable() {
        model.setRowCount(0);
        int i = 1;
        for (ThongkeDTO tkDTO : listTKslbd) {
            model.addRow(new Object[]{
                i++, tkDTO.getMaSP(), tkDTO.getTenSP(), tkDTO.getSoluongbd()});
        }
    }

    private void showTable1() {
       model1.setRowCount(0);
        int i = 1;
        for (ThongkeDTO tkDTO : listDT) {
            String strDouble = null;
            model1.addRow(new Object[]{
                i++, tkDTO.getThang(), strDouble.format("%.0f", tkDTO.getDoanhthuthang())});
        } 
    }
    
    private void showTable2() {
       model2.setRowCount(0);
        int i = 1;
        for (int j = 0; j<12;j++) {
            String strDouble = null;
            model2.addRow(new Object[]{
                i++,  strDouble.format("%.0f", monthRevenue[j])});
        } 
    }
    
    private void statistic(int year) {
        ArrayList<HoadonDTO> listHDyear = new ArrayList<>();
        ArrayList<PhieunhapDTO> listPNyear = new ArrayList<>();
        for(int i = 0; i < listHD.size(); i++){
            if(listHD.get(i).getNgaylap().substring(0, 4).equals(year+"")) {
                listHDyear.add(listHD.get(i));
            }
        }
        for(int i = 0; i < listPN.size(); i++){
            if(listPN.get(i).getNgaylap().substring(0, 4).equals(year+"")) {
                listPNyear.add(listPN.get(i));
            }
        }
        for(int i = 0; i < listHDyear.size(); i++){
            switch (listHDyear.get(i).getNgaylap().substring(5, 7)) {
                case "01":
                    monthRevenue[0] +=Float.parseFloat(listHDyear.get(i).getTongtien());
                    break;
                case "02":
                    monthRevenue[1] +=Float.parseFloat(listHDyear.get(i).getTongtien());
                    break;
                case "03":
                    monthRevenue[2] +=Float.parseFloat(listHDyear.get(i).getTongtien());
                    break;
                case "04":
                    monthRevenue[3] +=Float.parseFloat(listHDyear.get(i).getTongtien());
                    break;
                case "05":
                    monthRevenue[4] +=Float.parseFloat(listHDyear.get(i).getTongtien());
                    break;
                case "06":
                    monthRevenue[5] +=Float.parseFloat(listHDyear.get(i).getTongtien());
                    break;
                case "07":
                    monthRevenue[6] +=Float.parseFloat(listHDyear.get(i).getTongtien());
                    break;
                case "08":
                    monthRevenue[7] +=Float.parseFloat(listHDyear.get(i).getTongtien());
                    break;
                case "09":
                    monthRevenue[8] +=Float.parseFloat(listHDyear.get(i).getTongtien());
                    break;
                case "10":
                    monthRevenue[9] +=Float.parseFloat(listHDyear.get(i).getTongtien());
                    break;
                case "11":
                    monthRevenue[10] +=Float.parseFloat(listHDyear.get(i).getTongtien());
                    break;
                case "12":
                    monthRevenue[11] +=Float.parseFloat(listHDyear.get(i).getTongtien());
                    break;
                default: break;
            }  
        }
        float[] monthCost = new float[12];
        for(int i = 0; i < listPNyear.size(); i++){
            switch (listPNyear.get(i).getNgaylap().substring(5, 7)) {
                case "01":
                    monthCost[0] +=Float.parseFloat(listPNyear.get(i).getTongtien());
                    break;
                case "02":
                    monthCost[1] +=Float.parseFloat(listPNyear.get(i).getTongtien());
                    break;
                case "03":
                    monthCost[2] +=Float.parseFloat(listPNyear.get(i).getTongtien());
                    break;
                case "04":
                    monthCost[3] +=Float.parseFloat(listPNyear.get(i).getTongtien());
                    break;
                case "05":
                    monthCost[4] +=Float.parseFloat(listPNyear.get(i).getTongtien());
                    break;
                case "06":
                    monthCost[5] +=Float.parseFloat(listPNyear.get(i).getTongtien());
                    break;
                case "07":
                    monthCost[6] +=Float.parseFloat(listPNyear.get(i).getTongtien());
                    break;
                case "08":
                    monthCost[7] +=Float.parseFloat(listPNyear.get(i).getTongtien());
                    break;
                case "09":
                    monthCost[8] +=Float.parseFloat(listPNyear.get(i).getTongtien());
                    break;
                case "10":
                    monthCost[9] +=Float.parseFloat(listPNyear.get(i).getTongtien());
                    break;
                case "11":
                    monthCost[10] +=Float.parseFloat(listPNyear.get(i).getTongtien());
                    break;
                case "12":
                    monthCost[11] +=Float.parseFloat(listPNyear.get(i).getTongtien());
                    break;
                default: break;
            }  
        }
        System.out.println("---------------------");
        for(int i = 0;i < monthRevenue.length;i++){
            monthRevenue[i] -= monthCost[i];
        }
    }
}
