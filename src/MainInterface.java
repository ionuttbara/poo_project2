import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainInterface extends javax.swing.JFrame {

   private ArrayList<Produse> listaproduse;
   // header tabel
    String header[] = new String[]{"Nume Produs", "Pret Produs", "Tip Produs"};
    DefaultTableModel dtm;
    int row,col;
    // randuri + coloane
    /**
     * Creeare lista
     */
    public MainInterface() {
        initComponents();
        listaproduse = new ArrayList<>();
        dtm = new DefaultTableModel(header,0);
        jTable2.setModel(dtm);
        this.setLocationRelativeTo(null);
    }
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(Color.WHITE);
        jLabel2 = new javax.swing.JLabel();
        jTextNumeProdus = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextPretProdus = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCBTipProdus = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBackground(Color.WHITE);
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Marketplace Produse IT");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Nume Produs");

        jLabel3.setText("Pret Produs");

        jLabel4.setText("Tip Produs");
// tip produs
        jCBTipProdus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unitate", "CPU", "GPU", "RAM", "Stocare" }));
        jCBTipProdus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCBTipProdusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextNumeProdus)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jTextPretProdus, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCBTipProdus, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextNumeProdus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextPretProdus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jCBTipProdus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(14, Short.MAX_VALUE))
        );
// butoanele in aplicatie
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Adauga");
        jButton1.setBackground(Color.CYAN);
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sterge");
        jButton2.setBackground(Color.RED);
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Actualizare");
        jButton3.setBackground(Color.GREEN);
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cautare");
        jButton4.setBackground(Color.DARK_GRAY);
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        // implementare fereastra de cautare
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
// initializare obiecte
        jTable2.setBackground(Color.WHITE);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))
        );

        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String numeproduse = jTextNumeProdus.getText();
        double pretproduse = Double.parseDouble(jTextPretProdus.getText());
        String tipprodus = jCBTipProdus.getSelectedItem().toString();
        listaproduse.add(new Produse(numeproduse,tipprodus,pretproduse));
        dtm.setRowCount(0);//reset data model
        for (int i = 0; i < listaproduse.size(); i++) {
            Object[] objs = {listaproduse.get(i).numeproduse,listaproduse.get(i).pretproduse,listaproduse.get(i).tipprodus};
            dtm.addRow(objs);
        }
        //reset
        clearField();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void clearField(){
        jTextNumeProdus.requestFocus();
        jTextNumeProdus.setText("");
        jTextPretProdus.setText("");
        jCBTipProdus.setSelectedIndex(0);
    }
    private void jTable2MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        row = jTable2.getSelectedRow();
        col = jTable2.getColumnCount();
        System.out.println(row+","+col);
        jTextNumeProdus.setText(dtm.getValueAt(row, 0).toString());
        jTextPretProdus.setText(dtm.getValueAt(row, 1).toString());
        String location = dtm.getValueAt(row, 2).toString();
        for (int i = 0; i<(jCBTipProdus.getItemCount());i++){
            if (jCBTipProdus.getItemAt(i).equalsIgnoreCase(location)){
                jCBTipProdus.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jCBTipProdusActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jCBTipProdusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBTipProdusActionPerformed

    private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Esti sigur ca vrei sa stergi?", "Stergere", dialogButton);
        if(dialogResult == 0) {
            dtm.removeRow(row);
            listaproduse.remove(row);
            dtm.setRowCount(0);//reset table and populate again with listaproduse
            for (int i = 0; i < listaproduse.size(); i++) {
                Object[] objs = {listaproduse.get(i).numeproduse,listaproduse.get(i).pretproduse,listaproduse.get(i).tipprodus};
                dtm.addRow(objs);
            }
            clearField();
        } else {

        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String updatednumeproduse = jTextNumeProdus.getText();
        double updatedpretproduse = Double.parseDouble(jTextPretProdus.getText());
        String updatedtipprodus = jCBTipProdus.getSelectedItem().toString();
        listaproduse.get(row).numeproduse = updatednumeproduse;
        listaproduse.get(row).pretproduse = updatedpretproduse;
        listaproduse.get(row).tipprodus = updatedtipprodus;
        dtm.setRowCount(0);
        for (int i = 0; i < listaproduse.size(); i++) {
            Object[] objs = {listaproduse.get(i).numeproduse,listaproduse.get(i).pretproduse,listaproduse.get(i).tipprodus};
            dtm.addRow(objs);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this,"Introdu nume produs de cautat:");
        for (int i = 0; i < listaproduse.size(); i++) {
            if (listaproduse.get(i).numeproduse.equalsIgnoreCase(input)){
                JOptionPane.showMessageDialog(jButton4, "Gasit!","Cautare produse",2);
                jTextNumeProdus.setText(listaproduse.get(i).numeproduse);
                jTextPretProdus.setText(String.valueOf(listaproduse.get(i).pretproduse));
                String location = listaproduse.get(i).tipprodus;
                for (int j = 0; j<(jCBTipProdus.getItemCount());j++){
                    if (jCBTipProdus.getItemAt(i).equalsIgnoreCase(location)){
                        jCBTipProdus.setSelectedIndex(i);
                    }
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(jButton4, "Nu a fost gasit!","Cautare produse",2);

    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* creeare si afisare fereastra */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainInterface().setVisible(true);
            }
        });
    }

    // Declarare variabile
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jCBTipProdus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextNumeProdus;
    private javax.swing.JTextField jTextPretProdus;
    // sf declararii variabilelor
}
