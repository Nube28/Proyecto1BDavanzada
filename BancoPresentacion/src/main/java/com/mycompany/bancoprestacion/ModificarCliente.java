/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bancoprestacion;

import javax.swing.JOptionPane;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.IClienteDAO;
import org.itson.bdavanzadas.daos.ICuentaDAO;
import org.itson.bdavanzadas.dominio.Cliente;
import org.itson.bdavanzadas.dtos.ClienteNuevoDTO;
import org.itson.bdavanzadas.dtos.DireccionNuevaDTO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author Laboratorios
 */
public class ModificarCliente extends javax.swing.JFrame {
    private Cliente cliente;
    private ICuentaDAO cuentaDAO;
    private final IConexion conexion;
    private IClienteDAO clienteDAO;
    /**
     * Creates new form Modificar
     */
    public ModificarCliente(Cliente cliente, ICuentaDAO cuentaDAO, IConexion conexion) {
        initComponents();
        this.cliente = cliente;
        this.cuentaDAO = cuentaDAO;
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
        txtINombre = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        txfNombre = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JLabel();
        txfApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JLabel();
        txfApellidoMaterno = new javax.swing.JTextField();
        txtNacimiento = new javax.swing.JLabel();
        txfNacimiento = new javax.swing.JTextField();
        txtCalle = new javax.swing.JLabel();
        txfCalle = new javax.swing.JTextField();
        txtCodigoPostal = new javax.swing.JLabel();
        txfCodigoPostal = new javax.swing.JTextField();
        txtColonia = new javax.swing.JLabel();
        txfColonia = new javax.swing.JTextField();
        txtNumExterior = new javax.swing.JLabel();
        txfNumExterior = new javax.swing.JTextField();
        txtNumInterior = new javax.swing.JLabel();
        txfNumInterior = new javax.swing.JTextField();

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
        txtTitulo.setText("Actualizar Datos Personales");

        txtINombre.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtINombre.setText("Nombres");

        btnVolver.setBackground(new java.awt.Color(252, 191, 73));
        btnVolver.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnCrear.setBackground(new java.awt.Color(252, 191, 73));
        btnCrear.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        txfNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        txtApellidoPaterno.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtApellidoPaterno.setText("Apellido Paterno");

        txfApellidoPaterno.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        txtApellidoMaterno.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtApellidoMaterno.setText("Apellido Materno");

        txfApellidoMaterno.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        txtNacimiento.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtNacimiento.setText("Nacimiento (aaaa-mm-dd)");

        txfNacimiento.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        txtCalle.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtCalle.setText("Calle");

        txfCalle.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        txtCodigoPostal.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtCodigoPostal.setText("Codigo Postal");

        txfCodigoPostal.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        txtColonia.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtColonia.setText("Colonia");

        txfColonia.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        txtNumExterior.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtNumExterior.setText("Num. Exterior");

        txfNumExterior.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        txtNumInterior.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtNumInterior.setText("Num. Interior");

        txfNumInterior.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panAzulClaroLayout.createSequentialGroup()
                        .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panAzulClaroLayout.createSequentialGroup()
                                .addComponent(txtApellidoPaterno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panAzulClaroLayout.createSequentialGroup()
                                .addComponent(txtINombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panAzulClaroLayout.createSequentialGroup()
                                .addComponent(txtApellidoMaterno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panAzulClaroLayout.createSequentialGroup()
                                .addComponent(txtNacimiento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panAzulClaroLayout.createSequentialGroup()
                                .addComponent(txtNumExterior)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfNumExterior, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panAzulClaroLayout.createSequentialGroup()
                                .addComponent(txtNumInterior)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfNumInterior, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panAzulClaroLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(txtColonia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panAzulClaroLayout.createSequentialGroup()
                                    .addComponent(txtCalle)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txfCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panAzulClaroLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(txtCodigoPostal)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txfCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAzulClaroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(18, 18, 18)
                .addComponent(btnCrear)
                .addGap(18, 18, 18))
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
                .addGap(18, 18, 18)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCalle)
                        .addComponent(txfCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtINombre)
                        .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodigoPostal)
                        .addComponent(txfCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtApellidoPaterno)
                        .addComponent(txfApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtColonia)
                        .addComponent(txfColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtApellidoMaterno)
                        .addComponent(txfApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNumExterior)
                        .addComponent(txfNumExterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNacimiento)
                        .addComponent(txfNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumInterior)
                    .addComponent(txfNumInterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(panAzulClaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnCrear))
                .addContainerGap())
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
            .addComponent(panAzulObscuro, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panAzulObscuro, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        MenuPrincipal pi = new MenuPrincipal (cliente, cuentaDAO, conexion);
        pi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        ClienteNuevoDTO clienteNuevoDTO = actaulizarCliente();

        DireccionNuevaDTO direccionNuevaDTO = actualizarDireccion();

        try{
            Cliente cliente = clienteDAO.actualizar(clienteNuevoDTO);

            JOptionPane.showMessageDialog(this, "Cliente registrado!\nTu numero de cliente es: "+cliente.getId());

            PantallaInicial pi = new PantallaInicial(clienteDAO,conexion);
            pi.setVisible(true);
            this.dispose();
        }catch(PersistenciaException ex){
            JOptionPane.showMessageDialog(this, "No se puede agregar al cliente.");
        }

    }//GEN-LAST:event_btnCrearActionPerformed
    private ClienteNuevoDTO actaulizarCliente(){
        ClienteNuevoDTO clienteNuevoDTO = null;
            clienteNuevoDTO = new ClienteNuevoDTO();
            if(txfNombre.getText() == null){
                clienteNuevoDTO.setNombres(cliente.getNombres());
            }
            else{
                clienteNuevoDTO.setNombres(txfNombre.getText());
            }
            
            if(txfApellidoPaterno.getText()== null){
                clienteNuevoDTO.setApellido_paterno(cliente.getApellido_paterno());
            }
            else{
                clienteNuevoDTO.setApellido_paterno(txfApellidoPaterno.getText());
            }
            
            if(txfApellidoMaterno.getText()== null){
                clienteNuevoDTO.setApellido_materno(cliente.getApellido_materno());
            }
            else{
                clienteNuevoDTO.setApellido_materno(txfApellidoMaterno.getText());
            }
            
            if(txfNacimiento.getText()== null){
                clienteNuevoDTO.setNacimiento(cliente.getNacimiento());
            }
            else{
                clienteNuevoDTO.setNacimiento(txfNacimiento.getText());
            }
        return clienteNuevoDTO;
    }

    private DireccionNuevaDTO actualizarDireccion(){
        DireccionNuevaDTO dn = new DireccionNuevaDTO();
        dn.setCalle(txfCalle.getText());
        dn.setCodigo_postal(txfCodigoPostal.getText());
        dn.setColonia(txfColonia.getText());
        dn.setNumero_exterior(Integer.valueOf(txfNumExterior.getText()));
        if(!txfNumInterior.getText().equals("")){
            dn.setNumero_interior(Integer.valueOf(txfNumInterior.getText()));
        }
        
        return dn;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel panAzulClaro;
    private javax.swing.JPanel panAzulObscuro;
    private javax.swing.JPanel panLogo;
    private javax.swing.JTextField txfApellidoMaterno;
    private javax.swing.JTextField txfApellidoPaterno;
    private javax.swing.JTextField txfCalle;
    private javax.swing.JTextField txfCodigoPostal;
    private javax.swing.JTextField txfColonia;
    private javax.swing.JTextField txfNacimiento;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfNumExterior;
    private javax.swing.JTextField txfNumInterior;
    private javax.swing.JLabel txtApellidoMaterno;
    private javax.swing.JLabel txtApellidoPaterno;
    private javax.swing.JLabel txtCalle;
    private javax.swing.JLabel txtCodigoPostal;
    private javax.swing.JLabel txtColonia;
    private javax.swing.JLabel txtINombre;
    private javax.swing.JLabel txtNacimiento;
    private javax.swing.JLabel txtNumExterior;
    private javax.swing.JLabel txtNumInterior;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
