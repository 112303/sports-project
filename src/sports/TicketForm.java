/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sports;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author paul
 */
public class TicketForm extends javax.swing.JFrame {

    /**
     * Creates new form TicketForm
     */
    
    String matchName;
    int matchId;
    List matchInfo;
    List userInfo;
    public TicketForm(String matchName, int matchId, List userInfo) throws ClassNotFoundException, SQLException {
        initComponents();
        this.matchName = matchName;
        this.matchId = matchId;
        this.userInfo = userInfo;
        
        matchNameLabel.setText(matchName);
        
        Connector conn = new Connector();
        matchInfo = conn.getMatchInfo(matchId);
        
        pricePerTicketLabel.setText("Ksh: " + matchInfo.get(5));
    }
    
    public TicketForm(){
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        matchNameLabel = new javax.swing.JLabel();
        buyTicketButton = new javax.swing.JButton();
        pricePerTicketLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        numberOfTicketsInput = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        matchNameLabel.setText("jLabel1");

        buyTicketButton.setText("BUY TICKET");
        buyTicketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyTicketButtonActionPerformed(evt);
            }
        });

        pricePerTicketLabel.setText("jLabel1");

        numberOfTicketsInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfTicketsInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(matchNameLabel)
                            .addComponent(pricePerTicketLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numberOfTicketsInput, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buyTicketButton))))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(matchNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pricePerTicketLabel)
                .addGap(40, 40, 40)
                .addComponent(numberOfTicketsInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buyTicketButton)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buyTicketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyTicketButtonActionPerformed
//        int numberOfTickets = (Integer) numberOfTicketsDropdown.getText();
        try{
            int numberOfTickets = Integer.parseInt(numberOfTicketsInput.getText());
            Connector conn = new Connector();
            System.out.println(matchId);
            System.out.println(numberOfTickets);
            boolean isBought = conn.buyTicket(1, matchId, numberOfTickets);
            
            if (isBought == true){
                int totalPrice = numberOfTickets * (Integer) matchInfo.get(5);
                JOptionPane.showMessageDialog(null, "Bought " + numberOfTickets + " tickets worth " + totalPrice);
                this.setVisible(false);
                MatchesPage matchesPage = new MatchesPage(userInfo);
            } else {
                
            }
                
        } catch(NumberFormatException e){
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TicketForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buyTicketButtonActionPerformed

    private void numberOfTicketsInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfTicketsInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberOfTicketsInputActionPerformed

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
            java.util.logging.Logger.getLogger(TicketForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicketForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicketForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicketForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicketForm().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyTicketButton;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel matchNameLabel;
    private javax.swing.JTextField numberOfTicketsInput;
    private javax.swing.JLabel pricePerTicketLabel;
    // End of variables declaration//GEN-END:variables
}
