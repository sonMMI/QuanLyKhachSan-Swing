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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

/**
 *
 * @author doanvanson
 */
public class Restaurant extends javax.swing.JFrame {

    /**
     * Creates new form RestMenu
     */
    public Restaurant() {
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
        tableRestaurant.setModel(defaultTableModel); 
        
        defaultTableModel.addColumn("Item Name");
        defaultTableModel.addColumn("Price per serving");
        
        try{
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("JDBC:mysql://192.168.64.2:3306/Hotel_Management_System","root","password");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("USE Hotel_Management_System");
            ResultSet rs = stmt.executeQuery("SELECT * FROM itemRestaurant");
           
            while(rs.next()){
                String itemName = rs.getString("itemName");
                String itemPrice = rs.getString("itemPrice");        
                defaultTableModel.addRow(new Object[]{itemName,itemPrice});
           
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        restaurant = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        jScrollPaneRestaurant = new javax.swing.JScrollPane();
        tableRestaurant = new javax.swing.JTable();
        btnBookFood = new javax.swing.JButton();
        btnAddItem = new javax.swing.JButton();
        btnAddItem.setText("Add Item");
        btnRemoveItem = new javax.swing.JButton();

        // Frame
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        restaurant.setBackground(new java.awt.Color(255, 204, 204));
        restaurant.setForeground(new java.awt.Color(255, 204, 204));
        lblRestaurant = new JLabel("Restaurant");
        lblRestaurant.setBackground(Color.WHITE);
        lblRestaurant.setForeground(Color.WHITE);
        lblRestaurant.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 36));

        // Button Home
        btnHome.setFont(new Font("Dialog", Font.BOLD, 16)); 
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-home-page-32.png"))); 
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_buttonActionPerformed(evt);
            }
        });

        // Table Restaurant
        tableRestaurant.setBackground(new java.awt.Color(255, 204, 204));
        jScrollPaneRestaurant.setViewportView(tableRestaurant);

        //Button Book Food
        btnBookFood.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); 
        btnBookFood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-tableware-64.png"))); 
        btnBookFood.setText("Book Food For Room");
        btnBookFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookfood_buttonActionPerformed(evt);
            }
        });

        //Button Add Item
        btnAddItem.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); 
        btnAddItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-basket-64.png"))); 
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                additem_buttonActionPerformed(evt);
            }
        });

        //Button Remove item
        btnRemoveItem.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); 
        btnRemoveItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-fallen-ice-cream-cone-64.png"))); // NOI18N
        btnRemoveItem.setText("Remove Item ");
        btnRemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeitem_buttonActionPerformed(evt);
            }
        });
        
      

        javax.swing.GroupLayout gl_restaurant = new javax.swing.GroupLayout(restaurant);
        gl_restaurant.setHorizontalGroup(
        	gl_restaurant.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_restaurant.createSequentialGroup()
        			.addComponent(btnHome)
        			.addPreferredGap(ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
        			.addComponent(lblRestaurant, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
        			.addGap(438))
        		.addGroup(Alignment.LEADING, gl_restaurant.createSequentialGroup()
        			.addGap(102)
        			.addGroup(gl_restaurant.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(jScrollPaneRestaurant, Alignment.LEADING)
        				.addGroup(Alignment.LEADING, gl_restaurant.createSequentialGroup()
        					.addComponent(btnAddItem, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
        					.addGap(29)
        					.addComponent(btnBookFood)
        					.addGap(27)
        					.addComponent(btnRemoveItem)))
        			.addContainerGap(102, Short.MAX_VALUE))
        );
        gl_restaurant.setVerticalGroup(
        	gl_restaurant.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_restaurant.createSequentialGroup()
        			.addGroup(gl_restaurant.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblRestaurant, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPaneRestaurant, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
        			.addGap(18)
        			.addGroup(gl_restaurant.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnBookFood)
        				.addComponent(btnAddItem)
        				.addComponent(btnRemoveItem))
        			.addGap(37))
        );
        restaurant.setLayout(gl_restaurant);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(restaurant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(restaurant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>


    // ========= Begin Event Click Button ===========
    
    // Event additem_buttonActionPerformed
    private void additem_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        new AddItem().setVisible(true);
        this.setVisible(false);
    }

    //Event bookfood_buttonActionPerformed
    private void bookfood_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        new BookFood().setVisible(true);
        this.setVisible(false);
    }

    // Event removeitem_buttonActionPerformed
    private void removeitem_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new RemoveItem().setVisible(true);
        this.setVisible(false);
    }

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
            java.util.logging.Logger.getLogger(Restaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Restaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Restaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Restaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Restaurant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnBookFood;
    private javax.swing.JButton btnHome;
    private javax.swing.JPanel restaurant;
    private javax.swing.JScrollPane jScrollPaneRestaurant;
    private javax.swing.JButton btnRemoveItem;
    private javax.swing.JTable tableRestaurant;
    private JLabel lblRestaurant;
    // End of variables declaration//GEN-END:variables
}
