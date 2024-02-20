/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bancoprestacion;

import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.JOptionPane;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.ICuentaDAO;
import org.itson.bdavanzadas.daos.ISinCuentaDAO;
import org.itson.bdavanzadas.daos.ITransaccionDAO;
import org.itson.bdavanzadas.daos.SinCuentaDAO;
import org.itson.bdavanzadas.daos.TransaccionDAO;
import org.itson.bdavanzadas.dominio.Cliente;
import org.itson.bdavanzadas.dominio.Cuenta;
import org.itson.bdavanzadas.dominio.SinCuenta;
import org.itson.bdavanzadas.dominio.Transaccion;
import org.itson.bdavanzadas.dtos.SinCuentaNuevaDTO;
import org.itson.bdavanzadas.dtos.TransaccionNuevaDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author Berry
 */
public class MontoRetiroSinTarjeta extends javax.swing.JFrame {

    private Cliente cliente;
    private Cuenta cuenta;
    private final IConexion conexion;
    private ICuentaDAO cuentaDAO;
    private ITransaccionDAO transaccionDAO;
    private ISinCuentaDAO sinCuentaDAO;

    /**
     * Creates new form MontoRetiroSinTarjeta
     */
    public MontoRetiroSinTarjeta(Cliente cliente, Cuenta cuenta, IConexion conexion, ICuentaDAO cuentaDAO) {
        this.cliente = cliente;
        this.cuenta = cuenta;
        this.conexion = conexion;
        this.cuentaDAO = cuentaDAO;
        transaccionDAO = new TransaccionDAO(conexion);
        sinCuentaDAO = new SinCuentaDAO(conexion);
        
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
        txtIngresaLaCantidad = new javax.swing.JLabel();
        txfMonto = new javax.swing.JTextField();
        txtIngresaLaCantidad1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

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
        txtTitulo.setText("Monto del retiro sin tarjeta");

        txtIDeTarjeta.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtIDeTarjeta.setText("Tarjeta ");

        panMensaje.setBackground(new java.awt.Color(142, 202, 230));

        txtIngresaLaCantidad.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtIngresaLaCantidad.setText("Ingresa la cantidad que quieres retirar");

        txfMonto.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        txtIngresaLaCantidad1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtIngresaLaCantidad1.setText("Se le generara una contraseña y folio para realizar el retiro");

        javax.swing.GroupLayout panMensajeLayout = new javax.swing.GroupLayout(panMensaje);
        panMensaje.setLayout(panMensajeLayout);
        panMensajeLayout.setHorizontalGroup(
            panMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMensajeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMensajeLayout.createSequentialGroup()
                        .addComponent(txtIngresaLaCantidad)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMensajeLayout.createSequentialGroup()
                        .addComponent(txtIngresaLaCantidad1)
                        .addGap(82, 82, 82))))
            .addGroup(panMensajeLayout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(txfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panMensajeLayout.setVerticalGroup(
            panMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMensajeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtIngresaLaCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIngresaLaCantidad1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnSalir.setBackground(new java.awt.Color(252, 191, 73));
        btnSalir.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(252, 191, 73));
        btnAceptar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(panSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panAzulClaroLayout.createSequentialGroup()
                        .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDeTarjeta)
                            .addGroup(panAzulClaroLayout.createSequentialGroup()
                                .addComponent(btnSalir)
                                .addGap(18, 18, 18)
                                .addComponent(btnAceptar)))
                        .addContainerGap())))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
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
            .addComponent(panAzulObscuro, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private boolean validarSaldo() {

        try {
            float saldoDisponible = cuentaDAO.consultarCuenta(this.cuenta.getId_cuenta()).getSaldo();
            String saldoTransferir = txfMonto.getText();
            return saldoDisponible >= Integer.valueOf(saldoTransferir) && Integer.valueOf(saldoTransferir) > 0;
        } catch (PersistenciaException ex) {
            Logger.getLogger(MontoRetiroSinTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        Tarjeta tarjeta = new Tarjeta(cliente, cuenta, conexion, cuentaDAO);
        tarjeta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        if (validarSaldo() == false) {
            return;
        }
        //Creamos la transaccion

        TransaccionNuevaDTO trasanccionNueva = new TransaccionNuevaDTO();
        trasanccionNueva.setMonto(Float.parseFloat(txfMonto.getText()));
        trasanccionNueva.setTipo("sin cuenta");
        trasanccionNueva.setId_cuenta(cliente.getId());
        Transaccion transaccionNueva = crearTransaccion(trasanccionNueva);
        //Creamos el Sin Cuenta
        SinCuentaNuevaDTO sinCuentaNuevaDTO = new SinCuentaNuevaDTO();
        sinCuentaNuevaDTO.setId_transaccion(transaccionNueva.getId());
        sinCuentaNuevaDTO.setEstado("pendiente");

        SinCuenta sinCuentaNueva = crearSinCuenta(sinCuentaNuevaDTO);

        //if tiene dinero
        JOptionPane.showMessageDialog(this, "Retiro sin tarjeta Generado\nFolio: " + sinCuentaNueva.getFolio() + "\nContraseña: " + sinCuentaNueva.getContrasenia() + "");
        Tarjeta tarjeta = new Tarjeta(cliente, cuenta, conexion, cuentaDAO);
        tarjeta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private Transaccion crearTransaccion(TransaccionNuevaDTO trasanccionNueva) {
        Transaccion transaccion = null;
        try {
            transaccion = this.transaccionDAO.agregar(trasanccionNueva);
        } catch (PersistenciaException ex) {
            Logger.getLogger(MontoRetiroSinTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccion;
    }

    private SinCuenta crearSinCuenta(SinCuentaNuevaDTO sinCuentaNueva) {
        SinCuenta sinCuenta = null;
        try {
            sinCuenta = this.sinCuentaDAO.agregar(sinCuentaNueva);
        } catch (PersistenciaException ex) {
            Logger.getLogger(FormTransferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sinCuenta;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel panAzulClaro;
    private javax.swing.JPanel panAzulObscuro;
    private javax.swing.JPanel panLogo;
    private javax.swing.JPanel panMensaje;
    private javax.swing.JPanel panSaludo;
    private javax.swing.JTextField txfMonto;
    private javax.swing.JLabel txtIDeTarjeta;
    private javax.swing.JLabel txtIngresaLaCantidad;
    private javax.swing.JLabel txtIngresaLaCantidad1;
    private javax.swing.JLabel txtSaludo;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
