
package apresentacao;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Classificador;

public class Inicial extends javax.swing.JFrame {
    Classificador classificador;
    ArrayList<String> nomes = new ArrayList<>();
    private final Pattern regexValor = Pattern.compile("^[0-9]++$");
    File arquivo = null;
    public Inicial() {
        this.setTitle("Classificador beta v0.5");
        this.setResizable(false); 
        initComponents();
        this.setLocationRelativeTo(null);
        this.cmdClasificar.setEnabled(false);
        this.setVisible(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblArquivo = new javax.swing.JLabel();
        textoArquivo = new javax.swing.JTextField();
        textoCusters = new javax.swing.JTextField();
        lblClasses = new javax.swing.JLabel();
        cmdCarregar = new javax.swing.JButton();
        cmdClasificar = new javax.swing.JButton();
        chackTeste = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textoBase = new javax.swing.JTextField();
        textAttr = new javax.swing.JTextField();
        cmdArquivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblArquivo.setText("Arquivo:");

        lblClasses.setText("Classes");

        cmdCarregar.setText("Carregar");
        cmdCarregar.setEnabled(false);
        cmdCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCarregarActionPerformed(evt);
            }
        });

        cmdClasificar.setText("Classificar");
        cmdClasificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdClasificarActionPerformed(evt);
            }
        });

        chackTeste.setText("Treinamento");
        chackTeste.setEnabled(false);

        jLabel1.setText("Tamaho da base:");

        jLabel2.setText("Numero de Atributos:");

        textoBase.setEditable(false);

        textAttr.setEditable(false);

        cmdArquivo.setText("Arquivo");
        cmdArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdArquivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cmdClasificar)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblArquivo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmdArquivo)
                                .addGap(50, 50, 50)
                                .addComponent(lblClasses)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textoCusters, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(cmdCarregar)
                    .addComponent(chackTeste)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(textoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textAttr, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblArquivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoCusters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClasses)
                    .addComponent(cmdArquivo))
                .addGap(18, 18, 18)
                .addComponent(cmdCarregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chackTeste)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textAttr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(cmdClasificar)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCarregarActionPerformed
        if( arquivo != null){
            this.classificador = new Classificador(arquivo.getAbsolutePath(), this.chackTeste.isSelected());
            int[] cont = this.classificador.getContagem();
            this.textoBase.setText(String.valueOf(cont[0]));
            this.textAttr.setText(String.valueOf(cont[1]));
            this.cmdClasificar.setEnabled(true);
            this.chackTeste.setEnabled(false);
            this.cmdCarregar.setEnabled(false);
            this.textoArquivo.setEditable(false);
        }
    }//GEN-LAST:event_cmdCarregarActionPerformed

    private void cmdClasificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdClasificarActionPerformed
        if(this.classificador != null && regexValor.matcher(this.textoCusters.getText()).matches()){
            int k = Integer.parseInt(this.textoCusters.getText());
            this.classificador.init(k);
            this.classificador.Classficar();
            this.cmdClasificar.setEnabled(true);
            this.chackTeste.setEnabled(true);
            this.cmdCarregar.setEnabled(true);
            this.textoArquivo.setEditable(true);
        } else{
            JOptionPane.showMessageDialog(null, "QUNATIDADE INVALIDA", "Classificador", JOptionPane.ERROR_MESSAGE);
            this.textoCusters.requestFocus();
        }
    }//GEN-LAST:event_cmdClasificarActionPerformed

    private void cmdArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdArquivoActionPerformed
        JFileChooser pegaArquivo = new JFileChooser();
        pegaArquivo.setDialogTitle("Abrir Arquivo");
        pegaArquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        pegaArquivo.setFileFilter(new FileNameExtensionFilter("Texto", "txt" , "csv", "*"));
        int retorno = pegaArquivo.showOpenDialog(this);
        if(retorno == JFileChooser.APPROVE_OPTION){
            arquivo = pegaArquivo.getSelectedFile();
            this.textoArquivo.setText(arquivo.getName());
            this.cmdCarregar.setEnabled(true);
            this.chackTeste.setEnabled(true);
        }
        
    }//GEN-LAST:event_cmdArquivoActionPerformed
    

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
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chackTeste;
    private javax.swing.JButton cmdArquivo;
    private javax.swing.JButton cmdCarregar;
    private javax.swing.JButton cmdClasificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblArquivo;
    private javax.swing.JLabel lblClasses;
    private javax.swing.JTextField textAttr;
    private javax.swing.JTextField textoArquivo;
    private javax.swing.JTextField textoBase;
    private javax.swing.JTextField textoCusters;
    // End of variables declaration//GEN-END:variables
}
