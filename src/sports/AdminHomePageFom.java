/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sports;

/**
 *
 * @author paul
 */
public class AdminHomePageFom extends javax.swing.JFrame {

    /**
     * Creates new form AdminHomePageFom
     */
    public AdminHomePageFom() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminTeamsLabel = new javax.swing.JLabel();
        adminStadiumsLabel = new javax.swing.JLabel();
        adminUsersLabel = new javax.swing.JLabel();
        adminMatchesLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        adminTeamsLabel.setText("TEAMS");
        adminTeamsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminTeamsLabelMouseClicked(evt);
            }
        });

        adminStadiumsLabel.setText("STADIUMS");
        adminStadiumsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminStadiumsLabelMouseClicked(evt);
            }
        });

        adminUsersLabel.setText("USERS");
        adminUsersLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminUsersLabelMouseClicked(evt);
            }
        });

        adminMatchesLabel.setText("MATCHES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminMatchesLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(adminTeamsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adminStadiumsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(adminUsersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(adminTeamsLabel)
                .addGap(26, 26, 26)
                .addComponent(adminStadiumsLabel)
                .addGap(29, 29, 29)
                .addComponent(adminUsersLabel)
                .addGap(18, 18, 18)
                .addComponent(adminMatchesLabel)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminTeamsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminTeamsLabelMouseClicked
        // TODO add your handling code here:
        System.out.println("teams clicked...");
        

    }//GEN-LAST:event_adminTeamsLabelMouseClicked

    private void adminStadiumsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminStadiumsLabelMouseClicked
        // TODO add your handling code here:
//        System.out.println("stadiums clicked...");
    }//GEN-LAST:event_adminStadiumsLabelMouseClicked

    private void adminUsersLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminUsersLabelMouseClicked
        // TODO add your handling code here:
//        System.out.println("users clicked...");
    }//GEN-LAST:event_adminUsersLabelMouseClicked

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
            java.util.logging.Logger.getLogger(AdminHomePageFom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHomePageFom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHomePageFom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHomePageFom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHomePageFom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminMatchesLabel;
    private javax.swing.JLabel adminStadiumsLabel;
    private javax.swing.JLabel adminTeamsLabel;
    private javax.swing.JLabel adminUsersLabel;
    // End of variables declaration//GEN-END:variables
}
