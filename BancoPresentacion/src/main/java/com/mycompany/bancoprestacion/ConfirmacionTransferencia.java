/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bancoprestacion;

import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.ICuentaDAO;
import org.itson.bdavanzadas.dominio.Cliente;
import org.itson.bdavanzadas.dominio.Cuenta;
import org.itson.bdavanzadas.dominio.Transaccion;

/**
 *
 * @author natas
 */
public class ConfirmacionTransferencia extends javax.swing.JFrame {
    private Cliente cliente;
    private Cuenta cuenta;
    private ICuentaDAO cuentaDAO;
    private final IConexion conexion;
    /**
     * Creates new form Confirmacion
     */
    public ConfirmacionTransferencia(Cliente cliente, Cuenta cuenta, Transaccion transacccion, String cuentaDestino, ICuentaDAO cuentaDAO, IConexion conexion) {
        initComponents();
        this.cuentaDAO = cuentaDAO;
        this.conexion = conexion;
        this.cuenta = cuenta;
        this.cliente = cliente;
        
        String saludo = txtSaludo.getText().replaceAll("Usuario", cliente.getNombres());
        txtSaludo.setText(saludo);

        txtIDeTarjeta.setText("Tarjeta " + cuenta.getNumero());
        txtCantidad.setText("Cantidad: " + transacccion.getMonto());
        txtNumeroCuentaDestino.setText("Numero de cuenta: " + cuentaDestino);
        txtFechaHora.setText("Fecha y Hora: " + transacccion.getFecha());
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
        txtTransferenciaRealizada = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JLabel();
        txtNumeroCuentaDestino = new javax.swing.JLabel();
        txtFechaHora = new javax.swing.JLabel();
        btnCrearTarjetas = new javax.swing.JButton();

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
            .addGap(0, 73, Short.MAX_VALUE)
        );

        panSaludo.setBackground(new java.awt.Color(142, 202, 230));

        txtSaludo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtSaludo.setText("¡Hola, Usuario!");

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
        txtTitulo.setText("Banco muy importante");

        txtIDeTarjeta.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtIDeTarjeta.setText("Tarjeta ");

        panMensaje.setBackground(new java.awt.Color(142, 202, 230));

        txtTransferenciaRealizada.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtTransferenciaRealizada.setText("Transferencia Realizada con exito!");

        txtCantidad.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtCantidad.setText("Cantidad:");

        txtNumeroCuentaDestino.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtNumeroCuentaDestino.setText("Numero de cuenta:");

        txtFechaHora.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtFechaHora.setText("Fecha y Hora:");

        javax.swing.GroupLayout panMensajeLayout = new javax.swing.GroupLayout(panMensaje);
        panMensaje.setLayout(panMensajeLayout);
        panMensajeLayout.setHorizontalGroup(
            panMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMensajeLayout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(panMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaHora)
                    .addComponent(txtNumeroCuentaDestino)
                    .addComponent(txtCantidad)
                    .addComponent(txtTransferenciaRealizada))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panMensajeLayout.setVerticalGroup(
            panMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMensajeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTransferenciaRealizada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroCuentaDestino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaHora)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCrearTarjetas.setBackground(new java.awt.Color(252, 191, 73));
        btnCrearTarjetas.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnCrearTarjetas.setText("Volver");
        btnCrearTarjetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTarjetasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panAzulClaroLayout = new javax.swing.GroupLayout(panAzulClaro);
        panAzulClaro.setLayout(panAzulClaroLayout);
        panAzulClaroLayout.setHorizontalGroup(
            panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAzulClaroLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panAzulClaroLayout.createSequentialGroup()
                        .addComponent(txtIDeTarjeta)
                        .addContainerGap())
                    .addGroup(panAzulClaroLayout.createSequentialGroup()
                        .addComponent(panLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addComponent(panSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(panMensaje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAzulClaroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCrearTarjetas)
                .addGap(19, 19, 19))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnCrearTarjetas)
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearTarjetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTarjetasActionPerformed
        Tarjeta tarjeta = new Tarjeta(cliente, cuenta, conexion, cuentaDAO);
        tarjeta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCrearTarjetasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearTarjetas;
    private javax.swing.JPanel panAzulClaro;
    private javax.swing.JPanel panAzulObscuro;
    private javax.swing.JPanel panLogo;
    private javax.swing.JPanel panMensaje;
    private javax.swing.JPanel panSaludo;
    private javax.swing.JLabel txtCantidad;
    private javax.swing.JLabel txtFechaHora;
    private javax.swing.JLabel txtIDeTarjeta;
    private javax.swing.JLabel txtNumeroCuentaDestino;
    private javax.swing.JLabel txtSaludo;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JLabel txtTransferenciaRealizada;
    // End of variables declaration//GEN-END:variables
}
