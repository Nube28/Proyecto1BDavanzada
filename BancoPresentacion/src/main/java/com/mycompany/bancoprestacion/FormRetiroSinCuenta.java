/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bancoprestacion;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.CuentaDAO;
import org.itson.bdavanzadas.daos.IClienteDAO;
import org.itson.bdavanzadas.daos.ICuentaDAO;
import org.itson.bdavanzadas.daos.ISinCuentaDAO;
import org.itson.bdavanzadas.daos.ITransaccionDAO;
import org.itson.bdavanzadas.daos.SinCuentaDAO;
import org.itson.bdavanzadas.daos.TransaccionDAO;
import org.itson.bdavanzadas.dominio.Cuenta;
import org.itson.bdavanzadas.dominio.SinCuenta;
import org.itson.bdavanzadas.dominio.Transaccion;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author Berry
 */
public class FormRetiroSinCuenta extends javax.swing.JFrame {

    private final IClienteDAO clienteDAO;
    private final IConexion conexion;
    private final ISinCuentaDAO sinCuentaDAO;
    private final ITransaccionDAO transaccionDAO;
    private final ICuentaDAO cuentaDAO;

    /**
     * Creates new form FormRetiroSinCuenta
     */
    public FormRetiroSinCuenta(IClienteDAO clienteDAO, IConexion conexion) {
        initComponents();
        this.clienteDAO = clienteDAO;
        this.conexion = conexion;
        this.sinCuentaDAO = new SinCuentaDAO(conexion);
        this.transaccionDAO = new TransaccionDAO(conexion);
        this.cuentaDAO = new CuentaDAO(conexion);
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
        txtTitulo = new javax.swing.JLabel();
        txtIntroduzcaLosDatos = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        panAzulCielo = new javax.swing.JPanel();
        txtFolio = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JLabel();
        txfFolio = new javax.swing.JTextField();
        pasContraseña = new javax.swing.JPasswordField();

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

        txtTitulo.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo.setText("Retirar sin cuenta");

        txtIntroduzcaLosDatos.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtIntroduzcaLosDatos.setText("Introduzca los siguientes datos...");

        btnVolver.setBackground(new java.awt.Color(252, 191, 73));
        btnVolver.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
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

        panAzulCielo.setBackground(new java.awt.Color(142, 202, 230));

        txtFolio.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtFolio.setText("Folio:");

        txtContraseña.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtContraseña.setText("Contraseña:");

        txfFolio.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txfFolio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfFolioKeyTyped(evt);
            }
        });

        pasContraseña.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        pasContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasContraseñaActionPerformed(evt);
            }
        });
        pasContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pasContraseñaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panAzulCieloLayout = new javax.swing.GroupLayout(panAzulCielo);
        panAzulCielo.setLayout(panAzulCieloLayout);
        panAzulCieloLayout.setHorizontalGroup(
            panAzulCieloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAzulCieloLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(txtFolio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(txtContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pasContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panAzulCieloLayout.setVerticalGroup(
            panAzulCieloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAzulCieloLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(panAzulCieloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFolio)
                    .addComponent(txtContraseña)
                    .addComponent(txfFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pasContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout panAzulClaroLayout = new javax.swing.GroupLayout(panAzulClaro);
        panAzulClaro.setLayout(panAzulClaroLayout);
        panAzulClaroLayout.setHorizontalGroup(
            panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAzulClaroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAzulClaroLayout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addGap(18, 18, 18)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAzulClaroLayout.createSequentialGroup()
                        .addComponent(txtIntroduzcaLosDatos)
                        .addGap(153, 153, 153))))
            .addGroup(panAzulClaroLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(panAzulCielo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(panLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(txtIntroduzcaLosDatos)
                .addGap(18, 18, 18)
                .addComponent(panAzulCielo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnVolver))
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
            .addComponent(panAzulObscuro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        PantallaInicial pi = new PantallaInicial(clienteDAO, conexion);
        pi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // primera validacion, que tenga texto Hecha :D
        // segunda validacion, que el folio y la contraseña existan y sean de la misma cosita
        // tercera validacion, el estado debe de ser activo
        if (!txfFolio.getText().equals("") && !String.valueOf(pasContraseña.getPassword()).equals("")) {
            if (!this.realizarRetiro()) {
                JOptionPane.showMessageDialog(this, "El folio ha caducado o ya fue retirado");

                return;
            }
            JOptionPane.showMessageDialog(this, "Se retiro correctamente");
            PantallaInicial pi = new PantallaInicial(clienteDAO, conexion);
            pi.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese los datos requeridos");
        }

    }//GEN-LAST:event_btnAceptarActionPerformed
    private SinCuenta obtenerSinCuenta() {
        SinCuenta sinCuenta = null;
        try {
            sinCuenta = this.sinCuentaDAO.consultarSinCuenta(Integer.parseInt(txfFolio.getText()), String.valueOf(pasContraseña.getPassword()));
            if (sinCuenta.getEstado().equalsIgnoreCase("no cobrado") || sinCuenta.getEstado().equalsIgnoreCase("cobrado")) {
                return null;
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(FormRetiroSinCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sinCuenta;
    }

    private Transaccion obtenerTransaccion() {
        Transaccion transaccion = null;
        SinCuenta sinCuenta = obtenerSinCuenta();
        if (sinCuenta == null) {
            return null;
        }
        try {
            transaccion = this.transaccionDAO.consultarTransaccion(sinCuenta.getId_transaccion());

        } catch (PersistenciaException ex) {
            Logger.getLogger(FormRetiroSinCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccion;
    }

    private Cuenta obtenerCuenta() {
        Cuenta cuenta = null;
        Transaccion transaccion = obtenerTransaccion();
        if (transaccion == null) {

            return null;
        }
        try {
            cuenta = this.cuentaDAO.consultarCuentaId(transaccion.getId_cuenta());
            System.out.println(cuenta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PantallaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cuenta;
    }

    private boolean realizarRetiro() {
        Transaccion transaccion = obtenerTransaccion();
        if (transaccion == null) {
            return false;
        }
        Cuenta cuenta = obtenerCuenta();
        if (cuenta == null) {
            return false;
        }
        try {
            this.cuentaDAO.retirarSinCuenta(cuenta, transaccion.getMonto());

        } catch (PersistenciaException ex) {
            Logger.getLogger(FormRetiroSinCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    private void pasContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasContraseñaActionPerformed

    }//GEN-LAST:event_pasContraseñaActionPerformed

    private void txfFolioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfFolioKeyTyped
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57;

        if (!numero) {
            evt.consume();
        }
    }//GEN-LAST:event_txfFolioKeyTyped

    private void pasContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pasContraseñaKeyTyped
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57;

        if (!numero) {
            evt.consume();
        }
    }//GEN-LAST:event_pasContraseñaKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel panAzulCielo;
    private javax.swing.JPanel panAzulClaro;
    private javax.swing.JPanel panAzulObscuro;
    private javax.swing.JPanel panLogo;
    private javax.swing.JPasswordField pasContraseña;
    private javax.swing.JTextField txfFolio;
    private javax.swing.JLabel txtContraseña;
    private javax.swing.JLabel txtFolio;
    private javax.swing.JLabel txtIntroduzcaLosDatos;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
