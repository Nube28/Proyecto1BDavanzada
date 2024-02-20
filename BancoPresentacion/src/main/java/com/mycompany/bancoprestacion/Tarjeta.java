/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bancoprestacion;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.ICuentaDAO;
import org.itson.bdavanzadas.dominio.Cliente;
import org.itson.bdavanzadas.dominio.Cuenta;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author natas
 */
public class Tarjeta extends javax.swing.JFrame {

    private Cliente cliente;
    private Cuenta cuenta;
    private final IConexion conexion;
    private ICuentaDAO cuentaDAO;

    /**
     * Creates new form Tarjeta
     */
    public Tarjeta(Cliente cliente, Cuenta cuenta, IConexion conexion, ICuentaDAO cuentaDAO) {
        initComponents();

        this.cliente = cliente;
        this.cuenta = cuenta;
        this.conexion = conexion;
        this.cuentaDAO = cuentaDAO;

        refrescarCuenta();
        String saludo = txtSaludo.getText().replaceAll("Usuario", this.cliente.getNombres());
        txtSaludo.setText(saludo);

        txtSaldoModificar.setText("$" + this.cuenta.getSaldo());

        txtIDeTarjeta.setText("Tarjeta " + this.cuenta.getNumero());
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
        jLabel1 = new javax.swing.JLabel();
        panSaludo = new javax.swing.JPanel();
        txtSaludo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JLabel();
        txtIDeTarjeta = new javax.swing.JLabel();
        panMensaje = new javax.swing.JPanel();
        txtSaldo = new javax.swing.JLabel();
        txtSaldoModificar = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnCancelarCuenta = new javax.swing.JButton();
        btnTransferencia = new javax.swing.JButton();
        btnRetirar = new javax.swing.JButton();
        btnMovimineto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panAzulObscuro.setBackground(new java.awt.Color(2, 48, 71));
        panAzulObscuro.setPreferredSize(new java.awt.Dimension(704, 376));

        panAzulClaro.setBackground(new java.awt.Color(33, 158, 188));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multimedia/LogoMuyImportantePqueñ.png"))); // NOI18N

        javax.swing.GroupLayout panLogoLayout = new javax.swing.GroupLayout(panLogo);
        panLogo.setLayout(panLogoLayout);
        panLogoLayout.setHorizontalGroup(
            panLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        panLogoLayout.setVerticalGroup(
            panLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
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
        txtTitulo.setText("Transferencia");

        txtIDeTarjeta.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtIDeTarjeta.setText("Tarjeta ");

        panMensaje.setBackground(new java.awt.Color(142, 202, 230));

        txtSaldo.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtSaldo.setText("Saldo:");

        txtSaldoModificar.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        txtSaldoModificar.setText("$");

        javax.swing.GroupLayout panMensajeLayout = new javax.swing.GroupLayout(panMensaje);
        panMensaje.setLayout(panMensajeLayout);
        panMensajeLayout.setHorizontalGroup(
            panMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMensajeLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtSaldo)
                .addGap(173, 173, 173)
                .addComponent(txtSaldoModificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panMensajeLayout.setVerticalGroup(
            panMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMensajeLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaldo)
                    .addComponent(txtSaldoModificar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btnSalir.setBackground(new java.awt.Color(252, 191, 73));
        btnSalir.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnCancelarCuenta.setBackground(new java.awt.Color(252, 191, 73));
        btnCancelarCuenta.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnCancelarCuenta.setText("Cancelar Cuenta");
        btnCancelarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCuentaActionPerformed(evt);
            }
        });

        btnTransferencia.setBackground(new java.awt.Color(252, 191, 73));
        btnTransferencia.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnTransferencia.setText("Transferencia");
        btnTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferenciaActionPerformed(evt);
            }
        });

        btnRetirar.setBackground(new java.awt.Color(252, 191, 73));
        btnRetirar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnRetirar.setText("Retirar");
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });

        btnMovimineto.setBackground(new java.awt.Color(252, 191, 73));
        btnMovimineto.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnMovimineto.setText("Movimientos");
        btnMovimineto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoviminetoActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panAzulClaroLayout.createSequentialGroup()
                        .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDeTarjeta)
                            .addGroup(panAzulClaroLayout.createSequentialGroup()
                                .addComponent(btnCancelarCuenta)
                                .addGap(154, 154, 154)
                                .addComponent(btnSalir)))
                        .addContainerGap())))
            .addGroup(panAzulClaroLayout.createSequentialGroup()
                .addContainerGap(240, Short.MAX_VALUE)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTransferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btnRetirar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMovimineto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 240, Short.MAX_VALUE))
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
                        .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(txtIDeTarjeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTransferencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRetirar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMovimineto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarCuenta)
                    .addComponent(btnSalir))
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
            .addComponent(panAzulObscuro, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void refrescarCuenta() {
        try {
            this.cuenta = cuentaDAO.consultarCuenta(this.cuenta.getId_cuenta());
        } catch (PersistenciaException ex) {
            Logger.getLogger(Tarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        MenuPrincipal mp = new MenuPrincipal(cliente, cuentaDAO, conexion);
        mp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCancelarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCuentaActionPerformed
        CancelarCuenta cc = new CancelarCuenta(cliente, cuenta, conexion, cuentaDAO);
        cc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarCuentaActionPerformed

    private void btnMoviminetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoviminetoActionPerformed
        Movimientos mov = new Movimientos(cliente, cuenta, conexion, cuentaDAO);
        mov.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMoviminetoActionPerformed

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed
        MontoRetiroSinTarjeta mrst = new MontoRetiroSinTarjeta(cliente, cuenta, conexion, cuentaDAO);
        mrst.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRetirarActionPerformed

    private void btnTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciaActionPerformed
        FormTransferencia tr = new FormTransferencia(cliente, cuenta, cuentaDAO, conexion);
        tr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTransferenciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarCuenta;
    private javax.swing.JButton btnMovimineto;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTransferencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panAzulClaro;
    private javax.swing.JPanel panAzulObscuro;
    private javax.swing.JPanel panLogo;
    private javax.swing.JPanel panMensaje;
    private javax.swing.JPanel panSaludo;
    private javax.swing.JLabel txtIDeTarjeta;
    private javax.swing.JLabel txtSaldo;
    private javax.swing.JLabel txtSaldoModificar;
    private javax.swing.JLabel txtSaludo;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
