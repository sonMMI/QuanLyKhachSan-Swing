/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author doanvanson
 */
public class StaffInfo extends javax.swing.JFrame {

    /**
     * Creates new form StaffInfo
     */
    public StaffInfo() {
    	setTitle("Hotel Management - DVS");
        initComponents();
        showDetails();
    }
    
    // ======== Begin Get Database Table Room ==========
    public void showDetails(){
    	 DefaultTableModel defaultTableModel = new DefaultTableModel(){
         	@Override
         	public boolean isCellEditable(int row, int column) {
         		return false;
         	};
         };
         tableStaffInfor.setModel(defaultTableModel); 
         
         defaultTableModel.addColumn("Name");
         defaultTableModel.addColumn("Contact");
         defaultTableModel.addColumn("codeStaff");
         defaultTableModel.addColumn("role");
         
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("JDBC:mysql://192.168.64.2:3306/Hotel_Management_System","root","password");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("USE Hotel_Management_System;");
            ResultSet rs = stmt.executeQuery("SELECT * FROM staff");
            while(rs.next()){
                String name = rs.getString("name");
                String contact = rs.getString("contact");
                String codeStaff = rs.getString("codeStaff");
                String role = rs.getString("role");                
                defaultTableModel.addRow(new Object[]{name,contact,codeStaff,role});
            }
            rs.close();  
            con.close();
            stmt.close();           
        }
        catch(Exception e)
        {
            System.out.println("Esception: "+e);
        }     
    }
    // ======== End Get Database Table Room ==========

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        staffInfo = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        jScrollPaneStaffInfo = new javax.swing.JScrollPane();
        tableStaffInfor = new javax.swing.JTable();

        // Frame
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        staffInfo.setBackground(new java.awt.Color(255, 204, 204));
        
        lblStaffInfo = new JLabel("Staff Information");
        lblStaffInfo.setBackground(Color.WHITE);
        lblStaffInfo.setForeground(Color.WHITE);
        lblStaffInfo.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 35));

        //Button home
        btnHome.setFont(new Font("Dialog", Font.BOLD, 16)); 
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-home-page-32.png"))); 
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_buttonActionPerformed(evt);
            }
        });

        // Table Staff Info
        tableStaffInfor.setBackground(new java.awt.Color(255, 204, 204));
        jScrollPaneStaffInfo.setViewportView(tableStaffInfor);
      

        javax.swing.GroupLayout gl_staffInfo = new javax.swing.GroupLayout(staffInfo);
        gl_staffInfo.setHorizontalGroup(
        	gl_staffInfo.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_staffInfo.createSequentialGroup()
        			.addGroup(gl_staffInfo.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_staffInfo.createSequentialGroup()
        					.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
        					.addGap(237)
        					.addComponent(lblStaffInfo))
        				.addGroup(gl_staffInfo.createSequentialGroup()
        					.addGap(97)
        					.addComponent(jScrollPaneStaffInfo, GroupLayout.PREFERRED_SIZE, 814, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(90, Short.MAX_VALUE))
        );
        gl_staffInfo.setVerticalGroup(
        	gl_staffInfo.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_staffInfo.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_staffInfo.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblStaffInfo, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPaneStaffInfo, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(56, Short.MAX_VALUE))
        );
        staffInfo.setLayout(gl_staffInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    // ========= Begin Event Click Button ===========
    
    // Event home_buttonActionPerformed
    private void home_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        new MainScreen().setVisible(true);
        this.setVisible(false);
    }
    
    //========= End Event Click Button ===========

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
            java.util.logging.Logger.getLogger(StaffInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnHome;
    private javax.swing.JPanel staffInfo;
    private javax.swing.JScrollPane jScrollPaneStaffInfo;
    private javax.swing.JTable tableStaffInfor;
    private JLabel lblStaffInfo;
    // End of variables declaration
}