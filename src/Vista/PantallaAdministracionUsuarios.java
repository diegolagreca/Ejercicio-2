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

/**
 *
 * @author Diego
 */
public final class PantallaAdministracionUsuarios extends javax.swing.JFrame {

    // Instancio controlador de usuarios
    ControladorAdministracionUsuarios controladorUsuarios = new ControladorAdministracionUsuarios();

    /**
     * Creates new form PantallaAdministracionUsuarios
     *
     * @throws java.sql.SQLException
     */
    public PantallaAdministracionUsuarios() throws SQLException {
        initComponents();
        construirTabla();
        setLocationRelativeTo(null);
    }

    /**
     *
     * @throws SQLException
     */
    public void construirTabla() throws SQLException {
        tablaUsuarios.setModel((ControladorBD.construirModeloTabla(controladorUsuarios.obtenerUsuarios())));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        botonAñadirUsuario = new javax.swing.JButton();
        botonEliminarUsuario = new javax.swing.JButton();
        botonModificarUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaUsuarios);

        botonAñadirUsuario.setText("Añadir Usuario");
        botonAñadirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAñadirUsuarioActionPerformed(evt);
            }
        });

        botonEliminarUsuario.setText("Eliminar Usuario");
        botonEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarUsuarioActionPerformed(evt);
            }
        });

        botonModificarUsuario.setText("Modificar Usuario");
        botonModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Gestión de Usuarios");

        botonAtras.setText("Atrás");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonModificarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(botonEliminarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonAñadirUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1033, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonAñadirUsuario)
                        .addGap(16, 16, 16)
                        .addComponent(botonModificarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonEliminarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonAtras))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        dispose();
     }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarUsuarioActionPerformed
        // Obtengo la id del usuario a partir de la fila y columna.
        // La fila varía segúm cual tenga seleccionada
        // La columna ya se que es la 0
        int fila = tablaUsuarios.getSelectedRow();
        int columna = 0;
        int idUsuario = (int) tablaUsuarios.getValueAt(fila, columna);

        try {
            // Elimino el usuario que tengo seleccionado.
            System.out.println(idUsuario);
            controladorUsuarios.eliminarUsuario(tablaUsuarios.convertRowIndexToModel(idUsuario));
            construirTabla();
        } catch (SQLException ex) {
            Logger.getLogger(PantallaAdministracionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_botonEliminarUsuarioActionPerformed

    private void botonAñadirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAñadirUsuarioActionPerformed
        FormularioNuevoUsuario formularioUsuarios = null;
        formularioUsuarios = new FormularioNuevoUsuario(this);
        formularioUsuarios.setVisible(true);
    }//GEN-LAST:event_botonAñadirUsuarioActionPerformed

    private void botonModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarUsuarioActionPerformed
        int fila = tablaUsuarios.getSelectedRow();
        int id = (int) tablaUsuarios.getValueAt(fila, 0);
        String usuario = (String) tablaUsuarios.getValueAt(fila, 1);
        String contraseña = (String) tablaUsuarios.getValueAt(fila, 2);
        String nombre = (String) tablaUsuarios.getValueAt(fila, 3);
        String apellido = (String) tablaUsuarios.getValueAt(fila, 4);
        int documento = (int) tablaUsuarios.getValueAt(fila, 5);
        String direccion = (String) tablaUsuarios.getValueAt(fila, 6);
        int telefono = (int) tablaUsuarios.getValueAt(fila, 7);
        
        // Instancio un Usuario con los datos de usuario que hay en la fila.
        Usuario unUsuario = new Usuario(id, usuario, contraseña, nombre, apellido, documento, direccion, telefono);
        // Le paso el usuario al formulario de actualización
        FormularioActualizarUsuario formularioActualizarUsuario = new FormularioActualizarUsuario(this, unUsuario);
        formularioActualizarUsuario.setVisible(true);
    }//GEN-LAST:event_botonModificarUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaAdministracionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaAdministracionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaAdministracionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaAdministracionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PantallaAdministracionUsuarios().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PantallaAdministracionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonAñadirUsuario;
    private javax.swing.JButton botonEliminarUsuario;
    private javax.swing.JButton botonModificarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
