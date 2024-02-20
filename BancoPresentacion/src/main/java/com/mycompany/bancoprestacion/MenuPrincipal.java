/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bancoprestacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.ClienteDAO;
import org.itson.bdavanzadas.daos.CuentaDAO;
import org.itson.bdavanzadas.daos.IClienteDAO;
import org.itson.bdavanzadas.daos.ICuentaDAO;
import org.itson.bdavanzadas.dominio.Cliente;
import org.itson.bdavanzadas.dominio.Cuenta;
import org.itson.bdavanzadas.dominio.Transaccion;
import org.itson.bdavanzadas.dtos.CuentaNuevaDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author Laboratorios
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private Cliente cliente;
    private ICuentaDAO cuentaDAO;
    private final IConexion conexion;

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal(Cliente cliente, ICuentaDAO cuentaDAO, IConexion conexion) {
        initComponents();
        this.cliente = cliente;
        this.cuentaDAO = cuentaDAO;
        this.conexion = conexion;

        String saludo = txtSaludo.getText().replaceAll("Usuario", cliente.getNombres());
        txtSaludo.setText(saludo);

        listarCuentas();

        ListTarjetas.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                int index = ListTarjetas.getSelectedIndex();
                if (index != -1) {
                    String cuenta = modeloLista.getElementAt(index);
                    Tarjeta tarjeta = new Tarjeta(cliente, consultarCuenta(Integer.valueOf(cuenta)), conexion, cuentaDAO);
                    tarjeta.setVisible(true);
                    this.dispose();
                }
            }
        });
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
        jPanel1 = new javax.swing.JPanel();
        txtSaludo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JLabel();
        txtIDdeUsuario = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnCrearTarjetas = new javax.swing.JButton();
        btnOpciones = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListTarjetas = new javax.swing.JList<>();

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

        jPanel1.setBackground(new java.awt.Color(142, 202, 230));

        txtSaludo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtSaludo.setText("¡Hola, Usuario!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtSaludo)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSaludo)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        txtTitulo.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo.setText("Banco muy importante");

        txtIDdeUsuario.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtIDdeUsuario.setText("Tus Tarjetas");

        btnCerrarSesion.setBackground(new java.awt.Color(252, 191, 73));
        btnCerrarSesion.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnCrearTarjetas.setBackground(new java.awt.Color(252, 191, 73));
        btnCrearTarjetas.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnCrearTarjetas.setText("Crear Tarjeta");
        btnCrearTarjetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTarjetasActionPerformed(evt);
            }
        });

        btnOpciones.setBackground(new java.awt.Color(252, 191, 73));
        btnOpciones.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnOpciones.setText("Actualizar cliente");
        btnOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcionesActionPerformed(evt);
            }
        });

        ListTarjetas.setBackground(new java.awt.Color(252, 191, 73));
        ListTarjetas.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        ListTarjetas.setSelectionBackground(new java.awt.Color(252, 191, 73));
        jScrollPane1.setViewportView(ListTarjetas);

        javax.swing.GroupLayout panAzulClaroLayout = new javax.swing.GroupLayout(panAzulClaro);
        panAzulClaro.setLayout(panAzulClaroLayout);
        panAzulClaroLayout.setHorizontalGroup(
            panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAzulClaroLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panAzulClaroLayout.createSequentialGroup()
                        .addComponent(txtIDdeUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panAzulClaroLayout.createSequentialGroup()
                        .addComponent(panLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAzulClaroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAzulClaroLayout.createSequentialGroup()
                        .addComponent(btnCrearTarjetas, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(btnCerrarSesion)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAzulClaroLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(237, 237, 237))))
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
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panAzulClaroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panAzulClaroLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txtIDdeUsuario)))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearTarjetas)
                    .addComponent(btnCerrarSesion))
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

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        IClienteDAO clienteDAO = new ClienteDAO(conexion);
        PantallaInicial pi = new PantallaInicial(clienteDAO, conexion);
        pi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnCrearTarjetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTarjetasActionPerformed
        CuentaNuevaDTO cuentaNDTO = new CuentaNuevaDTO();
        cuentaNDTO.setSaldo(500);
        cuentaNDTO.setId_cliente(cliente.getId());
        cuentaNDTO.setEsta_activo(true);
        try {
            Cuenta cuenta = cuentaDAO.agregar(cuentaNDTO);
            JOptionPane.showMessageDialog(this, "Tarjeta agregada!");
        } catch (PersistenciaException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        modeloLista.removeAllElements();
        listarCuentas();
    }//GEN-LAST:event_btnCrearTarjetasActionPerformed

    private void btnOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionesActionPerformed
        ModificarCliente mc = new ModificarCliente(cliente, cuentaDAO, conexion);
        mc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnOpcionesActionPerformed
    /**
     * Lista las cuentas que tiene el cliente en "ListTarjetas"
     *
     * @throws PersistenciaException por si falla en accesar a los datos
     */
    private void listarCuentas() {

        List<Cuenta> cuentas = null;

        try {
            cuentas = cuentaDAO.consultar(cliente.getId());
        } catch (PersistenciaException pe) {
            pe.printStackTrace();
            // Manejar la excepción aquí
        }
        for (Cuenta cuenta : cuentas) {
            if (cuenta.isEsta_activo()) {
                modeloLista.addElement(String.valueOf(cuenta.getNumero()));
            }
        }
        ListTarjetas.setModel(modeloLista);
        jScrollPane1.setViewportView(ListTarjetas);
    }

    /**
     * Consulta la cuenta por medio del numero de cuenta (cuentaNum) y la
     * devuelve
     *
     * @param cuentaNum El número de cuenta usado para encontrar la cuenta;
     * @return Cuenta respecto al numero de cuenta, o null si no se encuentra
     * ninguna cuenta.
     * @throws PersistenciaException por si falla en accesar a los datos
     */
    private Cuenta consultarCuenta(int cuentaNum) {
        Cuenta cuenta = null;
        try {
            cuenta = this.cuentaDAO.consultarCuenta(cuentaNum);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PantallaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cuenta;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListTarjetas;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCrearTarjetas;
    private javax.swing.JButton btnOpciones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panAzulClaro;
    private javax.swing.JPanel panAzulObscuro;
    private javax.swing.JPanel panLogo;
    private javax.swing.JLabel txtIDdeUsuario;
    private javax.swing.JLabel txtSaludo;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
