/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bancoprestacion;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.ClienteDAO;
import org.itson.bdavanzadas.daos.CuentaDAO;
import org.itson.bdavanzadas.daos.IClienteDAO;
import org.itson.bdavanzadas.daos.ICuentaDAO;
import org.itson.bdavanzadas.dominio.Cliente;
import org.itson.bdavanzadas.dominio.Cuenta;
import org.itson.bdavanzadas.excepciones.PersistenciaException;
import org.itson.bdavanzadas.utileria.EncriptarContrasenia;

/**
 * @author Berry
 */
public class PantallaInicial extends javax.swing.JFrame {

    private final IClienteDAO clienteDAO;
    private final IConexion conexion;

    /**
     * Creates new form PantallaInicial
     */
    public PantallaInicial(IClienteDAO clienteDAO, IConexion conexion) {
        initComponents();
        this.clienteDAO = clienteDAO;
        this.conexion = conexion;
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
        txtContraseña = new javax.swing.JLabel();
        txtIDdeUsuario = new javax.swing.JLabel();
        pasContraseñaUsuario = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        btnAcceder = new javax.swing.JButton();
        btnRetiroSinCuenta = new javax.swing.JButton();
        btnRegistrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pantalla Inicial");

        panAzulObscuro.setBackground(new java.awt.Color(2, 48, 71));

        panAzulClaro.setBackground(new java.awt.Color(33, 158, 188));

        javax.swing.GroupLayout panLogoLayout = new javax.swing.GroupLayout(panLogo);
        panLogo.setLayout(panLogoLayout);
        panLogoLayout.setHorizontalGroup(
            panLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panLogoLayout.setVerticalGroup(
            panLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        txtTitulo.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo.setText("Banco muy importante");

        txtContraseña.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtContraseña.setText("Contraseña:");

        txtIDdeUsuario.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtIDdeUsuario.setText("ID de usuario:");

        pasContraseñaUsuario.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        pasContraseñaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasContraseñaUsuarioActionPerformed(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        btnAcceder.setBackground(new java.awt.Color(252, 191, 73));
        btnAcceder.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnAcceder.setText("Acceder");
        btnAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccederActionPerformed(evt);
            }
        });

        btnRetiroSinCuenta.setBackground(new java.awt.Color(252, 191, 73));
        btnRetiroSinCuenta.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnRetiroSinCuenta.setText("Retiro sin cuenta");
        btnRetiroSinCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroSinCuentaActionPerformed(evt);
            }
        });

        btnRegistrarse.setBackground(new java.awt.Color(252, 191, 73));
        btnRegistrarse.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panAzulClaroLayout = new javax.swing.GroupLayout(panAzulClaro);
        panAzulClaro.setLayout(panAzulClaroLayout);
        panAzulClaroLayout.setHorizontalGroup(
            panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAzulClaroLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(panLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAzulClaroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtIDdeUsuario)
                    .addComponent(txtContraseña))
                .addGap(18, 18, 18)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pasContraseñaUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(145, 145, 145))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAzulClaroLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnRetiroSinCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(btnAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        panAzulClaroLayout.setVerticalGroup(
            panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAzulClaroLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panAzulClaroLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtTitulo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDdeUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContraseña)
                    .addComponent(pasContraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetiroSinCuenta)
                    .addComponent(btnAcceder)
                    .addComponent(btnRegistrarse))
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

    private void btnRetiroSinCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroSinCuentaActionPerformed
        FormRetiroSinCuenta rsc = new FormRetiroSinCuenta(clienteDAO, conexion);
        rsc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRetiroSinCuentaActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        RegistroCliente rc = new RegistroCliente((ClienteDAO) clienteDAO, conexion);
        rc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccederActionPerformed
        if (txtUsuario.getText().equals("") || String.valueOf(pasContraseñaUsuario.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(this, "Todo los campos deben estar llenos");
            return;
        }

        Cliente cliente = login();
        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "El usuario o la contraseña no coinciden");
            return;

        }
        ICuentaDAO cuentaDAO = new CuentaDAO(conexion);
        MenuPrincipal mp = new MenuPrincipal(cliente, cuentaDAO, conexion);
        mp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAccederActionPerformed

    private void pasContraseñaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasContraseñaUsuarioActionPerformed

    }//GEN-LAST:event_pasContraseñaUsuarioActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57;

        if (!numero) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    /**
     * Se encarga de verificar si elcliente existe y la contraseña sea la del cliente
     *
     * @return Cliente loggeado o si falla, regresa nulo
     * @throws PersistenciaException por si falla en accesar a los datos
     */
    private Cliente login() {
        Cliente cliente = null;
        try {
            String usuario = this.txtUsuario.getText();
            char[] contrasenia = this.pasContraseñaUsuario.getPassword();
            cliente = this.clienteDAO.consultarCliente(Integer.valueOf(usuario));
            if (cliente == null) {
                return null;
            }
            if (!EncriptarContrasenia.comprobarContrasenia(String.valueOf(contrasenia), cliente.getContrasenia())) {
                return null;
            }

        } catch (PersistenciaException ex) {
            Logger.getLogger(PantallaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceder;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton btnRetiroSinCuenta;
    private javax.swing.JPanel panAzulClaro;
    private javax.swing.JPanel panAzulObscuro;
    private javax.swing.JPanel panLogo;
    private javax.swing.JPasswordField pasContraseñaUsuario;
    private javax.swing.JLabel txtContraseña;
    private javax.swing.JLabel txtIDdeUsuario;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
