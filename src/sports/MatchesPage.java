/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sports;

import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author paul
 */
public class MatchesPage extends javax.swing.JFrame {

    /**
     * Creates new form MatchesPage
     */
    List userInfo = new ArrayList();
    
    public MatchesPage(List userInfo) throws ClassNotFoundException, SQLException {
        initComponents();
        this.userInfo = userInfo;
        
        Connector conn = new Connector();
        List<List> matches = conn.getMatches();
        for (int match = 0; match < matches.size(); match ++){
            String matchValue = "";
            matchValue += matches.get(match).get(0);
            System.out.println(matches.get(match));
            matchValue += " " + matches.get(match).get(1);
            matchValue += " vs " + matches.get(match).get(2);
            matchValue += " - " + matches.get(match).get(3) + "\n";
            matchesListView.add(matchValue);
        }
        
        if (userInfo.size() == 3)
            userInfoLabel.setText((String) userInfo.get(1));
        else{
            JOptionPane.showMessageDialog(null, "Not logged in");
            this.setVisible(false);
            
//            LoginForm loginForm = new LoginForm();
//            loginForm.setVisible(true);
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        matchesListView = new java.awt.List();
        userInfoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        matchesListView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchesListViewActionPerformed(evt);
            }
        });

        userInfoLabel.setText("userinfo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(matchesListView, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(userInfoLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(userInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(matchesListView, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void matchesListViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchesListViewActionPerformed
//        JOptionPane.showMessageDialog(null, matchesListView.getSelectedItem());
//        matchesListView.getSele
        String value = matchesListView.getSelectedItem();
        
        int id = Integer.parseInt(value.substring(0, value.indexOf(' ')));
//        String matchInfo = value.substring(2, value.indexOf(' '));
//        System.out.println("****" + matchInfo + "*****");
//        JOptionPane.showMessageDialog(null, id);
        TicketForm ticketForm;
        try {
            ticketForm = new TicketForm(value, id, userInfo);
            ticketForm.setVisible(true);
            JOptionPane.showMessageDialog(null, id);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MatchesPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_matchesListViewActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
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
            
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatchesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MatchesPage(new ArrayList()).setVisible(true);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(MatchesPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.List matchesListView;
    private javax.swing.JLabel userInfoLabel;
    // End of variables declaration//GEN-END:variables
}
