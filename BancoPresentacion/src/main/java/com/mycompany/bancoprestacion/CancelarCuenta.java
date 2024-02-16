/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bancoprestacion;

import javax.swing.JOptionPane;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.ICuentaDAO;
import org.itson.bdavanzadas.dominio.Cliente;
import org.itson.bdavanzadas.dominio.Cuenta;

/**
 *
 * @author Berry
 */
public class CancelarCuenta extends javax.swing.JFrame {
    
    private Cliente cliente;
    private Cuenta cuenta;
    private final IConexion conexion;
    private ICuentaDAO cuentaDAO;
    
    /**
     * Creates new form CancelarCuenta
     */
    public CancelarCuenta(Cliente cliente, Cuenta cuenta, IConexion conexion, ICuentaDAO cuentaDAO) {
        this.cliente = cliente;
        this.cuenta = cuenta;
        this.conexion = conexion;
        this.cuentaDAO = cuentaDAO;
        
        initComponents();
        
        String saludo = txtSaludo.getText().replaceAll("Usuario", this.cliente.getNombres());
        txtSaludo.setText(saludo);

        txtIDeTarjeta.setText("Tarjeta " + cuenta.getNumero());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panAzulObscuro = new javax.swing.JPanel();
        panAzulClaro = new javax.swing.JPanel();
        panLogo = new javax.swing.JPanel();
        panSaludo = new javax.swing.JPanel();
        txtSaludo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JLabel();
        txtIDeTarjeta = new javax.swing.JLabel();
        panMensaje = new javax.swing.JPanel();
        txtConfirmacion = new javax.swing.JLabel();
        txtConfirmacion1 = new javax.swing.JLabel();
        txtConfirmacion2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        pasContraseñaUsuario = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panAzulObscuro.setBackground(new java.awt.Color(2, 48, 71));
        panAzulObscuro.setPreferredSize(new java.awt.Dimension(704, 376));

        panAzulClaro.setBackground(new java.awt.Color(33, 158, 188));

        javax.swing.GroupLayout panLogoLayout = new javax.swing.GroupLayout(panLogo);
        panLogo.setLayout(panLogoLayout);
        panLogoLayout.setHorizontalGroup(
            panLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );
        panLogoLayout.setVerticalGroup(
            panLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panSaludo.setBackground(new java.awt.Color(142, 202, 230));

        txtSaludo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtSaludo.setText("¡Adios, Usuario!");

        javax.swing.GroupLayout panSaludoLayout = new javax.swing.GroupLayout(panSaludo);
        panSaludo.setLayout(panSaludoLayout);
        panSaludoLayout.setHorizontalGroup(
            panSaludoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSaludoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtSaludo)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        panSaludoLayout.setVerticalGroup(
            panSaludoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSaludoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSaludo)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        txtTitulo.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo.setText("Cancelar Cuenta");

        txtIDeTarjeta.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtIDeTarjeta.setText("Tarjeta ");

        panMensaje.setBackground(new java.awt.Color(142, 202, 230));

        txtConfirmacion.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtConfirmacion.setText("¿Seguro que quieres cancelar la cuenta?");

        txtConfirmacion1.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtConfirmacion1.setText("Esta accion es inrreversible.");

        txtConfirmacion2.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtConfirmacion2.setText("Por seguridad ingrese su contraseña");

        javax.swing.GroupLayout panMensajeLayout = new javax.swing.GroupLayout(panMensaje);
        panMensaje.setLayout(panMensajeLayout);
        panMensajeLayout.setHorizontalGroup(
            panMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMensajeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMensajeLayout.createSequentialGroup()
                        .addComponent(txtConfirmacion2)
                        .addGap(137, 137, 137))
                    .addGroup(panMensajeLayout.createSequentialGroup()
                        .addComponent(txtConfirmacion)
                        .addGap(113, 113, 113))))
            .addGroup(panMensajeLayout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(txtConfirmacion1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panMensajeLayout.setVerticalGroup(
            panMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMensajeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtConfirmacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmacion1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmacion2)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        btnCancelar.setBackground(new java.awt.Color(252, 191, 73));
        btnCancelar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnConfirmar.setBackground(new java.awt.Color(252, 191, 73));
        btnConfirmar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        pasContraseñaUsuario.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        pasContraseñaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasContraseñaUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panAzulClaroLayout = new javax.swing.GroupLayout(panAzulClaro);
        panAzulClaro.setLayout(panAzulClaroLayout);
        panAzulClaroLayout.setHorizontalGroup(
            panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panMensaje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panAzulClaroLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panAzulClaroLayout.createSequentialGroup()
                        .addComponent(panLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                        .addComponent(panSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panAzulClaroLayout.createSequentialGroup()
                        .addComponent(txtIDeTarjeta)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAzulClaroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAzulClaroLayout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirmar)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAzulClaroLayout.createSequentialGroup()
                        .addComponent(pasContraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))))
        );
        panAzulClaroLayout.setVerticalGroup(
            panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAzulClaroLayout.createSequentialGroup()
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panAzulClaroLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(txtTitulo))
                    .addGroup(panAzulClaroLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panSaludo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(txtIDeTarjeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pasContraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout panAzulObscuroLayout = new javax.swing.GroupLayout(panAzulObscuro);
        panAzulObscuro.setLayout(panAzulObscuroLayout);
        panAzulObscuroLayout.setHorizontalGroup(
            panAzulObscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAzulObscuroLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(panAzulClaro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        panAzulObscuroLayout.setVerticalGroup(
            panAzulObscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAzulObscuroLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(panAzulClaro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panAzulObscuro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panAzulObscuro, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Tarjeta tarjeta = new Tarjeta(cliente, cuenta, conexion, cuentaDAO);
        tarjeta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if(pasContraseñaUsuario.getText().equals(cliente.getContrasenia())){
            //cuenta.setActivo(false); Necesitamso eso en la base de datos
            JOptionPane.showMessageDialog(this, "Se cancelo la cuenta correctamente");
            MenuPrincipal mp = new MenuPrincipal(cliente,cuentaDAO,conexion);
            mp.setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void pasContraseñaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasContraseñaUsuarioActionPerformed

    }//GEN-LAST:event_pasContraseñaUsuarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JPanel panAzulClaro;
    private javax.swing.JPanel panAzulObscuro;
    private javax.swing.JPanel panLogo;
    private javax.swing.JPanel panMensaje;
    private javax.swing.JPanel panSaludo;
    private javax.swing.JPasswordField pasContraseñaUsuario;
    private javax.swing.JLabel txtConfirmacion;
    private javax.swing.JLabel txtConfirmacion1;
    private javax.swing.JLabel txtConfirmacion2;
    private javax.swing.JLabel txtIDeTarjeta;
    private javax.swing.JLabel txtSaludo;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
