/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poli.view;

import br.com.poli.principal.DificuldadePartida;
import br.com.poli.principal.Partida;
import static java.lang.Integer.parseInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
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

        jLabel1 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        dificuldade = new javax.swing.JComboBox<>();
        playButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idade = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(152, 152, 152));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans Light", 0, 18)); // NOI18N
        jLabel1.setText("S U D O K U");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        nome.setBackground(new java.awt.Color(254, 254, 254));
        nome.setToolTipText("Seu nome");
        nome.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        nome.setName("Seu Nome"); // NOI18N
        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });

        dificuldade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FACIL", "NORMAL", "DIFICIL" }));
        dificuldade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dificuldadeActionPerformed(evt);
            }
        });

        playButton.setText("PLAY");
        playButton.setBorder(null);
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabel2.setText("NOME");

        jLabel3.setText("IDADE");

        jLabel4.setText("DIFICULDADE");

        idade.setFont(new java.awt.Font("DejaVu Sans Light", 1, 11)); // NOI18N
        idade.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        idade.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dificuldade, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(idade, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idade, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dificuldade, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed

        Pattern p = Pattern.compile("[a-zA-z0-9]+");
        Matcher m = p.matcher(nome.getText());
        boolean valido = m.matches();
        boolean ok;
        if (valido) {
            ok = true;
        } else {
            ok = false;
            JOptionPane.showMessageDialog(null, "Campo nome não preenchido");
        }
        if (ok) {
            String nomeUsuario = nome.getText();
            String a = dificuldade.getSelectedItem().toString();
            //JOptionPane.showMessageDialog(null, "O jogo vai começar"+idade.getValue());

            
            switch (dificuldade.getSelectedItem().toString()) {
                case "FACIL":
                    abrirTabuleiro(nome.getText(), DificuldadePartida.FACIL, (int) idade.getValue());
                    break;
                case "NORMAL":
                    abrirTabuleiro(nome.getText(), DificuldadePartida.NORMAL, (int) idade.getValue());
                    break;
                case "DIFICIL":
                    abrirTabuleiro(nome.getText(), DificuldadePartida.DIFICIL, (int) idade.getValue());
                    break;
                default:
                    break;
            }
            dispose();
            //new TabuleiroFrame().setVisible(true);
        }
        /*else {
            int idadeDoJogador = Integer.parseInt(idade.getText());
            Partida novoJogo;
            if (idadeDoJogador == 0) {
                novoJogo = new Partida(nome.getText(), (DificuldadePartida) dificuldade.getSelectedItem());
            } else {
                novoJogo = new Partida(nome.getText(), (DificuldadePartida) dificuldade.getSelectedItem(), idadeDoJogador);
            }
        } */
    }//GEN-LAST:event_playButtonActionPerformed

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void dificuldadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dificuldadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dificuldadeActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
    public void abrirTabuleiro(String nome, DificuldadePartida dificuldade, int idade){
        TabuleiroFrame tab = new TabuleiroFrame(nome,dificuldade,idade);
        dispose();
        tab.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> dificuldade;
    private javax.swing.JSpinner idade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nome;
    private javax.swing.JButton playButton;
    // End of variables declaration//GEN-END:variables
}
