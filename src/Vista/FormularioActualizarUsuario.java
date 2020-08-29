/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorAdministracionUsuarios;
import Controlador.ControladorBD;
import Modelo.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Pantalla de formulario para actualizar un usuario ya existente
 *
 * @author Diego
 */
public class FormularioActualizarUsuario extends javax.swing.JFrame {

    // Inicio controladores
    ControladorAdministracionUsuarios controladorUsuarios = new ControladorAdministracionUsuarios();
    ControladorBD adminPostgres = new ControladorBD();

    // Creo variable para llevar cuenta de la pantalla anterior
    // y poder pedirle que construya la tabla de usuarios luego de actualizar.
    private PantallaAdministracionUsuarios pantallaAnterior = null;
    private Usuario usuarioCargado;

    private FormularioActualizarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Constructor con parámetros de pantalla y usuario
     *
     * @param pantalla
     * @param unUsuario
     */
    public FormularioActualizarUsuario(PantallaAdministracionUsuarios pantalla, Usuario unUsuario) {
        initComponents();
        this.pantallaAnterior = pantalla;
        this.usuarioCargado = unUsuario;
        cargarDatosUsuario();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textUsuario = new javax.swing.JTextField();
        textContraseña = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textDocumento = new javax.swing.JTextField();
        textApellido = new javax.swing.JTextField();
        textTelefono = new javax.swing.JTextField();
        textDireccion = new javax.swing.JTextField();
        botonActualizar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        labelIdUsuario = new javax.swing.JLabel();
        textoIdUsuairo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario");

        jLabel2.setText("Contraseña");

        jLabel3.setText("Nombre");

        textNombre.setToolTipText("");

        jLabel4.setText("Apellido");

        jLabel5.setText("Documento");

        jLabel6.setText("Teléfono");

        jLabel7.setText("Dirección");

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        labelIdUsuario.setText("ID Usuario:");

        textoIdUsuairo.setText("idUsuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(botonActualizar)
                .addGap(69, 69, 69)
                .addComponent(botonCancelar))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(textUsuario)))
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelIdUsuario)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textoIdUsuairo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6))
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIdUsuario)
                    .addComponent(textoIdUsuairo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(textContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(textDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonActualizar))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Obtengo todos los datos del usuario que voy a actualizar.
    private void cargarDatosUsuario() {
        this.textUsuario.setText(this.usuarioCargado.getUsuario());
        this.textContraseña.setText(this.usuarioCargado.getContraseña());
        this.textNombre.setText(this.usuarioCargado.getNombre());
        this.textApellido.setText(this.usuarioCargado.getApellido());
        this.textDocumento.setText(String.valueOf(this.usuarioCargado.getDocumento()));
        this.textTelefono.setText(String.valueOf(this.usuarioCargado.getTelefono()));
        this.textDireccion.setText(this.usuarioCargado.getDireccion());
        this.textoIdUsuairo.setText(String.valueOf(this.usuarioCargado.getId()));

    }

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        // Creo varialbes para llevar estado de errores.
        boolean errorFormatoDocumento = false;
        boolean errorFormatoTelefono = false;

        String usuario = this.textUsuario.getText();
        String contraseña = this.textContraseña.getText();
        String nombre = this.textNombre.getText();
        String apellido = this.textApellido.getText();
        String direccion = this.textDireccion.getText();
        int documento = 0;
        int telefono = 0;
        // Controlo que el documento sea un número
        if (controladorUsuarios.esNumero(this.textDocumento.getText())) {
            errorFormatoDocumento = false;
            documento = Integer.valueOf(this.textDocumento.getText());
        } else {
            // Si no es número, tiro error
            errorFormatoDocumento = true;
            JOptionPane.showMessageDialog(this,
                    "Documento debe ser un número.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        // Controlo que el teléfono sea un número
        if (controladorUsuarios.esNumero(this.textTelefono.getText())) {
            errorFormatoTelefono = false;
            telefono = Integer.valueOf(this.textTelefono.getText());
        } else {
            // si no es número, tiro error
            errorFormatoDocumento = true;
            JOptionPane.showMessageDialog(this,
                    "Teléfono debe ser un número.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        String sentenciaInsertarUsuario = "UPDATE usuarios\n"
                + "SET usuario = '" + usuario + "', contraseña = '" + contraseña + "', nombre = '" + nombre + "', apellido = '" + apellido + "', documento = '" + documento + "', telefono = '" + telefono + "', direccion = '" + direccion + "'\n"
                + "WHERE id_usuario = '" + this.usuarioCargado.getId() + "';";

        try {
            // debo verificar si el usuario ya existe antes de mandar crearlo
            if (controladorUsuarios.usuarioYaExiste(this.usuarioCargado.getId(), usuario)) {
                JOptionPane.showMessageDialog(this,
                        "Ese usuario ya existe. Pongale otro nombre de usuario.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

            } else if (!errorFormatoDocumento && !errorFormatoTelefono) {
                // Si no hay errores, envío la sentencia a la base de datos.
                adminPostgres.enviarSentencia(sentenciaInsertarUsuario);
                pantallaAnterior.construirTabla();
                this.dispose();
            }

        } catch (SQLException ex) {
            Logger.getLogger(FormularioNuevoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FormularioActualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioActualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioActualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioActualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioActualizarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelIdUsuario;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textContraseña;
    private javax.swing.JTextField textDireccion;
    private javax.swing.JTextField textDocumento;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textTelefono;
    private javax.swing.JTextField textUsuario;
    private javax.swing.JLabel textoIdUsuairo;
    // End of variables declaration//GEN-END:variables
}
