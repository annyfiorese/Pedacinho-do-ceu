package view;

import dao.FuncionarioDAO;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author ANNY FIORESE
 */
public class Login extends javax.swing.JFrame {

    private static Login view;

    public Login() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        entrarLog = new javax.swing.JToggleButton();
        SenhaLog = new javax.swing.JPasswordField();
        UserLog = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        CadastroLog = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/LOGO 3.png"))); // NOI18N

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        entrarLog.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        entrarLog.setText("Entrar");
        entrarLog.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        entrarLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarLogActionPerformed(evt);
            }
        });
        getContentPane().add(entrarLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 420, 90, 20));

        SenhaLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SenhaLogActionPerformed(evt);
            }
        });
        getContentPane().add(SenhaLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 200, -1));

        UserLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserLogActionPerformed(evt);
            }
        });
        getContentPane().add(UserLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 200, -1));

        jButton1.setAutoscrolls(true);
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        CadastroLog.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CadastroLog.setText("Cadastrar");
        CadastroLog.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CadastroLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroLogActionPerformed(evt);
            }
        });
        getContentPane().add(CadastroLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 420, 100, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Senha");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 120, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Login");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 90, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Login.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entrarLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarLogActionPerformed
        String nomeLogin = UserLog.getText().trim();
        String senhaLogin = SenhaLog.getText();

        if (SenhaLog.getText().trim().equals("") || UserLog.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Preencha os campos informados!");

        } else {

            try {

                File fileL = new File("funcionario.csv");
                Scanner scan = new Scanner(fileL);
                scan.useDelimiter("[,\n]");

                boolean encontrou = false;

                while (scan.hasNext()) {

                    String nome = scan.next();
                    String senha = scan.next();

                    String aux = senha;

                    FuncionarioDAO dao = new FuncionarioDAO();

                    if (nomeLogin.equals(nome) && senhaLogin.equals(aux)) {

                        scan.close();
                        encontrou = true;
                        JOptionPane.showMessageDialog(null, "Seja bem vindo " + nome + "!");
                        break;
                    }
                }

                if (encontrou == true) {

                    Menu menu = new Menu();
                    menu.setVisible(true);
                    this.setVisible(false);

                } else {

                    JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido(s), tente novamente!");
                    UserLog.setText(null);
                    SenhaLog.setText(null);

                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Sistema encontrou um erro");
            }

    }//GEN-LAST:event_entrarLogActionPerformed
    }

    private void UserLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserLogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserLogActionPerformed

    private void SenhaLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SenhaLogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SenhaLogActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CadastroLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroLogActionPerformed
        // TODO add your handling code here:
        Cadastro cadastro = new Cadastro();
        cadastro.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_CadastroLogActionPerformed

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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton CadastroLog;
    private javax.swing.JPasswordField SenhaLog;
    private javax.swing.JTextField UserLog;
    private javax.swing.JToggleButton entrarLog;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    // End of variables declaration//GEN-END:variables

    public JPasswordField getSenhaLog() {
        return SenhaLog;
    }

    public void setSenhaLog(JPasswordField SenhaLog) {
        this.SenhaLog = SenhaLog;
    }

    public JTextField getUserLog() {
        return UserLog;
    }

    public void setUserLog(JTextField UserLog) {
        this.UserLog = UserLog;
    }


    

    public JToggleButton getEntrarLog() {
        return entrarLog;
    }

    public void setEntrarLog(JToggleButton entrarLog) {
        this.entrarLog = entrarLog;
    }

}
