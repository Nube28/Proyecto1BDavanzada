/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bancoprestacion;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.ICuentaDAO;
import org.itson.bdavanzadas.daos.ITransaccionDAO;
import org.itson.bdavanzadas.daos.TransaccionDAO;
import org.itson.bdavanzadas.dominio.Cliente;
import org.itson.bdavanzadas.dominio.Cuenta;
import org.itson.bdavanzadas.dominio.Transaccion;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author natas
 */
public class Movimientos extends javax.swing.JFrame {

    private Cliente cliente;
    private Cuenta cuenta;
    private final IConexion conexion;
    private ICuentaDAO cuentaDAO;
    private ITransaccionDAO transaccionDAO;

    /**
     * Creates new form Movimientos
     */
    public Movimientos(Cliente cliente, Cuenta cuenta, IConexion conexion, ICuentaDAO cuentaDAO) {
        initComponents();
        
        this.cliente = cliente;
        this.cuenta = cuenta;
        this.conexion = conexion;
        this.cuentaDAO = cuentaDAO;
        this.transaccionDAO = new TransaccionDAO(conexion);
        
        String saludo = txtSaludo.getText().replaceAll("Usuario", cliente.getNombres());
        txtSaludo.setText(saludo);
        
        txtIDeTarjeta.setText("Tarjeta "+ cuenta.getNumero());
        
        insertarDatos();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TabMoviemientos = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

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
        txtTitulo.setText("Movimientos");

        txtIDeTarjeta.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtIDeTarjeta.setText("Tarjeta ");

        panMensaje.setBackground(new java.awt.Color(142, 202, 230));

        TabMoviemientos.setBackground(new java.awt.Color(142, 202, 230));
        TabMoviemientos.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        TabMoviemientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Movimientos", "Fecha y Hora", "Cantidad"
            }
        ));
        TabMoviemientos.setToolTipText("");
        TabMoviemientos.setGridColor(new java.awt.Color(2, 48, 71));
        TabMoviemientos.setSelectionBackground(new java.awt.Color(142, 202, 230));
        jScrollPane1.setViewportView(TabMoviemientos);

        javax.swing.GroupLayout panMensajeLayout = new javax.swing.GroupLayout(panMensaje);
        panMensaje.setLayout(panMensajeLayout);
        panMensajeLayout.setHorizontalGroup(
            panMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMensajeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                .addContainerGap())
        );
        panMensajeLayout.setVerticalGroup(
            panMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMensajeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnVolver.setBackground(new java.awt.Color(252, 191, 73));
        btnVolver.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(252, 191, 73));
        btnBuscar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
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
                        .addComponent(panLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panAzulClaroLayout.createSequentialGroup()
                        .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDeTarjeta)
                            .addGroup(panAzulClaroLayout.createSequentialGroup()
                                .addComponent(panMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnVolver)
                                    .addComponent(btnBuscar))))
                        .addContainerGap(24, Short.MAX_VALUE))))
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
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panAzulClaroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVolver)
                        .addGap(14, 14, 14))
                    .addGroup(panAzulClaroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
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
            .addComponent(panAzulObscuro, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panAzulObscuro, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Tarjeta ta = new Tarjeta(cliente, cuenta, conexion, cuentaDAO);
        ta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code he:
    }//GEN-LAST:event_btnBuscarActionPerformed
    private void insertarDatos() {
        List<Transaccion> listaTransacciones;
        try {
            listaTransacciones = transaccionDAO.consultar(cuenta.getId_cuenta());
        } catch (PersistenciaException ex) {
            listaTransacciones = null;
            Logger.getLogger(Movimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel modelo = (DefaultTableModel) this.TabMoviemientos.getModel();
        modelo.setRowCount(0);
        listaTransacciones.forEach(transaccion -> {
            Object[] fila = new Object[3];
            fila[0] = transaccion.getTipo();
            fila[1] = transaccion.getFecha();
            fila[2] = "$ "+transaccion.getMonto();
            modelo.addRow(fila);
        });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabMoviemientos;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panAzulClaro;
    private javax.swing.JPanel panAzulObscuro;
    private javax.swing.JPanel panLogo;
    private javax.swing.JPanel panMensaje;
    private javax.swing.JPanel panSaludo;
    private javax.swing.JLabel txtIDeTarjeta;
    private javax.swing.JLabel txtSaludo;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
