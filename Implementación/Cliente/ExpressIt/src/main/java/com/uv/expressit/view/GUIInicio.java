/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.uv.expressit.view;

import com.uv.expressit.DAO.DAOArchivo;
import com.uv.expressit.DAO.DAOEntrada;
import com.uv.expressit.DAO.DAOUsuario;
import com.uv.expressit.POJO.Entrada;
import com.uv.expressit.POJO.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;



/**
 *
 * @author josuecg
 */
public class GUIInicio extends javax.swing.JFrame {

    private ArrayList<Entrada> listaEntradasSeguidos = null;
    int contador = 0;
    /**
     * Creates new form GUIInicio
     */
    public GUIInicio() {
        initComponents();
        cargarEntradasSeguidos();
        ocultarElementosPerfil();
        btnInicio.setBackground(Color.black);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        bg = new javax.swing.JPanel();
        mainSection = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        btnInicio = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnPerfil = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnConfigurarPerfil = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        profileSection = new javax.swing.JPanel();
        fotoPerfil = new javax.swing.JPanel();
        lbFotoPerfil = new javax.swing.JLabel();
        contentPerfil = new javax.swing.JPanel();
        lbNombreUsuario = new javax.swing.JLabel();
        lbNombreCompleto = new javax.swing.JLabel();
        lbFechaNacimiento = new javax.swing.JLabel();
        lbSeguidores = new javax.swing.JLabel();
        lbEntradas = new javax.swing.JLabel();
        scrollTextarea = new javax.swing.JScrollPane();
        txtDescripcionUsuario = new javax.swing.JTextArea();
        btnSeguirUsuario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bgContent = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        content = new javax.swing.JPanel();
        txtBuscador = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnTuitear = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1080, 720));
        setMaximumSize(null);
        setResizable(false);

        bg.setBackground(new java.awt.Color(20, 20, 21));
        bg.setRequestFocusEnabled(false);
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainSection.setBackground(new java.awt.Color(13, 13, 13));
        mainSection.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        mainSection.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitulo.setFont(new java.awt.Font("DejaVu Sans", 1, 33)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitulo.setText("Express It");
        mainSection.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 190, 70));

        btnInicio.setBackground(new java.awt.Color(13, 13, 13));
        btnInicio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInicioMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Inicio");

        javax.swing.GroupLayout btnInicioLayout = new javax.swing.GroupLayout(btnInicio);
        btnInicio.setLayout(btnInicioLayout);
        btnInicioLayout.setHorizontalGroup(
            btnInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );
        btnInicioLayout.setVerticalGroup(
            btnInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainSection.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 74, 220, 60));

        btnPerfil.setBackground(new java.awt.Color(13, 13, 13));
        btnPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Perfil");

        javax.swing.GroupLayout btnPerfilLayout = new javax.swing.GroupLayout(btnPerfil);
        btnPerfil.setLayout(btnPerfilLayout);
        btnPerfilLayout.setHorizontalGroup(
            btnPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );
        btnPerfilLayout.setVerticalGroup(
            btnPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainSection.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 134, 220, 60));

        btnConfigurarPerfil.setBackground(new java.awt.Color(13, 13, 13));
        btnConfigurarPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Configuración");

        javax.swing.GroupLayout btnConfigurarPerfilLayout = new javax.swing.GroupLayout(btnConfigurarPerfil);
        btnConfigurarPerfil.setLayout(btnConfigurarPerfilLayout);
        btnConfigurarPerfilLayout.setHorizontalGroup(
            btnConfigurarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnConfigurarPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        btnConfigurarPerfilLayout.setVerticalGroup(
            btnConfigurarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnConfigurarPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainSection.add(btnConfigurarPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 193, 220, 60));

        btnCerrarSesion.setBackground(new java.awt.Color(120, 0, 14));
        btnCerrarSesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cerrar sesión");

        javax.swing.GroupLayout btnCerrarSesionLayout = new javax.swing.GroupLayout(btnCerrarSesion);
        btnCerrarSesion.setLayout(btnCerrarSesionLayout);
        btnCerrarSesionLayout.setHorizontalGroup(
            btnCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCerrarSesionLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        btnCerrarSesionLayout.setVerticalGroup(
            btnCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCerrarSesionLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        mainSection.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 220, 70));

        bg.add(mainSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 720));

        profileSection.setBackground(new java.awt.Color(13, 13, 13));

        fotoPerfil.setBackground(new java.awt.Color(255, 255, 255));

        lbFotoPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout fotoPerfilLayout = new javax.swing.GroupLayout(fotoPerfil);
        fotoPerfil.setLayout(fotoPerfilLayout);
        fotoPerfilLayout.setHorizontalGroup(
            fotoPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbFotoPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        fotoPerfilLayout.setVerticalGroup(
            fotoPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbFotoPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        contentPerfil.setBackground(new java.awt.Color(41, 41, 43));

        lbNombreUsuario.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lbNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbNombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNombreUsuario.setText("<nombre_usuario>");

        lbNombreCompleto.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lbNombreCompleto.setForeground(new java.awt.Color(255, 255, 255));
        lbNombreCompleto.setText("<nombre_completo>");

        lbFechaNacimiento.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lbFechaNacimiento.setForeground(new java.awt.Color(255, 255, 255));
        lbFechaNacimiento.setText("<fecha_nacimiento>");

        lbSeguidores.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lbSeguidores.setForeground(new java.awt.Color(255, 255, 255));
        lbSeguidores.setText("<numero_seguidores>");

        lbEntradas.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lbEntradas.setForeground(new java.awt.Color(255, 255, 255));
        lbEntradas.setText("<numero_entradas>");

        txtDescripcionUsuario.setEditable(false);
        txtDescripcionUsuario.setBackground(new java.awt.Color(41, 41, 43));
        txtDescripcionUsuario.setColumns(20);
        txtDescripcionUsuario.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        txtDescripcionUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcionUsuario.setLineWrap(true);
        txtDescripcionUsuario.setRows(5);
        txtDescripcionUsuario.setText("<descripción_usuario>");
        scrollTextarea.setViewportView(txtDescripcionUsuario);

        btnSeguirUsuario.setBackground(new java.awt.Color(0, 116, 158));
        btnSeguirUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSeguirUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSeguirUsuarioMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Seguir");

        javax.swing.GroupLayout btnSeguirUsuarioLayout = new javax.swing.GroupLayout(btnSeguirUsuario);
        btnSeguirUsuario.setLayout(btnSeguirUsuarioLayout);
        btnSeguirUsuarioLayout.setHorizontalGroup(
            btnSeguirUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnSeguirUsuarioLayout.setVerticalGroup(
            btnSeguirUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contentPerfilLayout = new javax.swing.GroupLayout(contentPerfil);
        contentPerfil.setLayout(contentPerfilLayout);
        contentPerfilLayout.setHorizontalGroup(
            contentPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNombreCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSeguidores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbEntradas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollTextarea, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnSeguirUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentPerfilLayout.setVerticalGroup(
            contentPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSeguidores, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTextarea, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSeguirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout profileSectionLayout = new javax.swing.GroupLayout(profileSection);
        profileSection.setLayout(profileSectionLayout);
        profileSectionLayout.setHorizontalGroup(
            profileSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileSectionLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(fotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(profileSectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        profileSectionLayout.setVerticalGroup(
            profileSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileSectionLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(fotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contentPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bg.add(profileSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 280, 720));

        bgContent.setBackground(new java.awt.Color(13, 13, 13));
        bgContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        content.setBackground(new java.awt.Color(13, 13, 13));
        content.setAutoscrolls(true);
        content.setLayout(new javax.swing.BoxLayout(content, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(content);

        bgContent.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 640, 590));

        txtBuscador.setBackground(new java.awt.Color(20, 20, 21));
        txtBuscador.setFont(new java.awt.Font("DejaVu Sans", 2, 18)); // NOI18N
        txtBuscador.setForeground(new java.awt.Color(153, 153, 153));
        txtBuscador.setText("Buscar...");
        txtBuscador.setBorder(new LineBorder(Color.BLACK));
        txtBuscador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscadorMouseClicked(evt);
            }
        });
        txtBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscadorKeyTyped(evt);
            }
        });
        bgContent.add(txtBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 530, 40));

        jPanel2.setBackground(new java.awt.Color(0, 116, 158));
        jPanel2.setPreferredSize(new java.awt.Dimension(110, 34));

        jLabel7.setBackground(new java.awt.Color(0, 116, 158));
        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Buscar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        bgContent.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 100, 30));

        bg.add(bgContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 0, 660, -1));

        btnTuitear.setBackground(new java.awt.Color(0, 116, 158));
        btnTuitear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTuitearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTuitearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTuitearMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Express it");

        javax.swing.GroupLayout btnTuitearLayout = new javax.swing.GroupLayout(btnTuitear);
        btnTuitear.setLayout(btnTuitearLayout);
        btnTuitearLayout.setHorizontalGroup(
            btnTuitearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTuitearLayout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jLabel1)
                .addContainerGap(254, Short.MAX_VALUE))
        );
        btnTuitearLayout.setVerticalGroup(
            btnTuitearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTuitearLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        bg.add(btnTuitear, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 650, 650, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTuitearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTuitearMouseClicked
        GUIAñadirEntrada nuevaEntrada = new GUIAñadirEntrada();
        nuevaEntrada.setVisible(true);
    }//GEN-LAST:event_btnTuitearMouseClicked

    private void btnTuitearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTuitearMouseEntered
        btnTuitear.setBackground(Color.decode("#00b0f0"));
    }//GEN-LAST:event_btnTuitearMouseEntered

    private void btnTuitearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTuitearMouseExited
       btnTuitear.setBackground(Color.decode("#00749E"));
    }//GEN-LAST:event_btnTuitearMouseExited

    private void btnCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseEntered
        btnCerrarSesion.setBackground(Color.decode("#A7000E"));
    }//GEN-LAST:event_btnCerrarSesionMouseEntered

    private void btnCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseExited
        btnCerrarSesion.setBackground(Color.decode("#78000E"));
    }//GEN-LAST:event_btnCerrarSesionMouseExited

    private void txtBuscadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscadorMouseClicked
        this.txtBuscador.setText("");
        this.txtBuscador.setForeground(Color.WHITE);
        this.txtBuscador.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
    }//GEN-LAST:event_txtBuscadorMouseClicked

    private void txtBuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorKeyTyped
       if(txtBuscador.getText().equals("Buscar...")){
           txtBuscador.setText("");
       }
    }//GEN-LAST:event_txtBuscadorKeyTyped

    private void btnCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseClicked
        GUIlogin pantallaLogin = new GUIlogin();
        pantallaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionMouseClicked

    private void btnInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseClicked
        cargarEntradasSeguidos();
        ocultarElementosPerfil();
        this.btnInicio.setBackground(Color.BLACK);
    }//GEN-LAST:event_btnInicioMouseClicked

    private void btnSeguirUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeguirUsuarioMouseEntered
        this.btnSeguirUsuario.setBackground(Color.decode("#00b0f0"));
    }//GEN-LAST:event_btnSeguirUsuarioMouseEntered

    private void btnSeguirUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeguirUsuarioMouseExited
        this.btnSeguirUsuario.setBackground(Color.decode("#00749E"));
    }//GEN-LAST:event_btnSeguirUsuarioMouseExited

    public void desocultarElementosPerfil(){
        this.contentPerfil.setVisible(true);
        this.fotoPerfil.setVisible(true);
    }
    
    public void ocultarElementosPerfil(){
        this.contentPerfil.setVisible(false);
        this.fotoPerfil.setVisible(false);
    }
    
    public void cargarEntradasSeguidos(){
        if(this.listaEntradasSeguidos != null){
            this.listaEntradasSeguidos.clear();
            this.content.removeAll();
        }
        try {
           this.listaEntradasSeguidos = DAOEntrada.obtenerEntradasSeguidor(GUIlogin.usuarioLogeado.getIdUsuario());
           mostrarEntradas(listaEntradasSeguidos);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al cargar el feed, \ninténtelo de nuevo más tarde");
        }
    }
    
    //Este método crea componentes dinámicos en donde iran los twitts
    public void mostrarEntradas(ArrayList<Entrada> listaMostrar){
        for(Entrada entradaMostrar:listaMostrar){
            try {
                entradaMostrar.setLikesEntrada(DAOEntrada.obtenerLikesEntrada(entradaMostrar.getIdEntrada()));
                entradaMostrar.setUsuarioLike(DAOEntrada.usuarioLike(entradaMostrar.getIdEntrada(), GUIlogin.usuarioLogeado.getIdUsuario()));
                BorderLayout borderLayout = new BorderLayout();
                BorderLayout borderLayout2 = new BorderLayout();
                //Border lineBorder = BorderFactory.createLineBorder(Color.BLACK,4);
                
                JPanel seccionEntrada = new JPanel();
                JPanel paneBotones = new JPanel();
                JPanel multiMedia = new JPanel();
                String meGusta = String.valueOf(entradaMostrar.getLikesEntrada());
                JLabel lbContadorMeGusta = new JLabel("Me gusta: "+meGusta);
                lbContadorMeGusta.setForeground(Color.white);
                JLabel lbMultiMedia = new JLabel("Aqui va el contenido multimedia xd");
                lbMultiMedia.setPreferredSize(new Dimension(200,200));
                lbMultiMedia.setForeground(Color.white);
                lbMultiMedia.setAlignmentX(CENTER_ALIGNMENT);
                lbMultiMedia.setAlignmentY(CENTER_ALIGNMENT);
                
                JLabel btnMeGusta = new JLabel("Me gusta");
                btnMeGusta.setFont(new Font("SansSerif", Font.BOLD, 16));
                btnMeGusta.setForeground(Color.white);
                boolean tieneLikePropio = entradaMostrar.getUsuarioLike();
                if(tieneLikePropio){
                    btnMeGusta.setForeground(Color.decode("#00749E"));
                }
                btnMeGusta.addMouseListener(new MouseAdapter(){
                    
                    @Override
                    public void mouseClicked(MouseEvent e){
                        boolean isLikePressed = entradaMostrar.getUsuarioLike();
                        int contadorMeGusta = entradaMostrar.getLikesEntrada();
                        if(isLikePressed){
                            btnMeGusta.setForeground(Color.white);
                            DAOEntrada.borrarlikeEntrada(entradaMostrar.getIdEntrada(), GUIlogin.usuarioLogeado.getIdUsuario());
                            contadorMeGusta--;
                            entradaMostrar.setLikesEntrada(contadorMeGusta);
                            lbContadorMeGusta.setText("Me gusta: "+String.valueOf(contadorMeGusta));
                            isLikePressed = false;
                            entradaMostrar.setUsuarioLike(isLikePressed);
                        }else{
                            entradaMostrar.setUsuarioLike(isLikePressed);
                            DAOEntrada.likearEntrada(entradaMostrar.getIdEntrada(), GUIlogin.usuarioLogeado.getIdUsuario());
                            contadorMeGusta++;
                            entradaMostrar.setLikesEntrada(contadorMeGusta);
                            lbContadorMeGusta.setText("Me gusta: "+String.valueOf(contadorMeGusta));
                            btnMeGusta.setForeground(Color.decode("#00749E"));
                            isLikePressed = true;
                            entradaMostrar.setUsuarioLike(isLikePressed);
                        }
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent e){
                        btnMeGusta.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }
                });
                
                JTextArea areaText = new JTextArea(entradaMostrar.getTextoEntrada());
                areaText.setLineWrap(true);
                areaText.setForeground(Color.white);
                areaText.setBackground(Color.decode("#29292B"));
                areaText.setEditable(false);
                areaText.setFont(new Font("SansSerif", Font.PLAIN, 16));
                areaText.setPreferredSize(new Dimension(200,200));
                
                JLabel lbUsuarioTuit = new JLabel("Publicado por: "
                        +entradaMostrar.getNombreUsuario()+", el "+entradaMostrar.getFechaEntrada());
                lbUsuarioTuit.setForeground(Color.white);
                lbUsuarioTuit.setFont(new Font("SansSerif", Font.BOLD, 18));
                lbUsuarioTuit.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e){
                        try {
                            Usuario usuarioObtenido = DAOUsuario.obtenerUsuarioPorUsername(entradaMostrar.getNombreUsuario());
                            mostrarDatosUsuario(usuarioObtenido);
                            ArrayList<Entrada> listaEntradasUsuario = DAOEntrada.obtenerEntradasUsuario(usuarioObtenido.getIdUsuario());
                            listaEntradasSeguidos.clear();
                            content.removeAll();
                            btnInicio.setBackground(Color.decode("#0D0D0D"));
                            BufferedImage imageMostrar = DAOArchivo.obtenerFotoPerfilUsuario(usuarioObtenido.getIdUsuario());
                            Image imagenNueva = imageMostrar.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                            lbFotoPerfil.setIcon(new ImageIcon(imagenNueva));
                            mostrarEntradas(listaEntradasUsuario);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Ocurrio un error al mostrar los datos");
                        }
                    }
                    
                    public void mouseEntered(MouseEvent e){
                        lbUsuarioTuit.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }
                });
                
                multiMedia.setBackground(Color.decode("#29292B"));
                multiMedia.setPreferredSize(new Dimension(200,200));
                multiMedia.add(lbMultiMedia);
                
                paneBotones.setLayout(borderLayout2);
                paneBotones.add(multiMedia, BorderLayout.PAGE_START);
                paneBotones.add(btnMeGusta, BorderLayout.LINE_START);
                paneBotones.add(lbContadorMeGusta, BorderLayout.LINE_END);
                paneBotones.setBackground(Color.decode("#141415"));
                
                seccionEntrada.setLayout(borderLayout);
                seccionEntrada.add(lbUsuarioTuit, BorderLayout.PAGE_START);
                seccionEntrada.add(areaText, BorderLayout.CENTER);
                seccionEntrada.add(paneBotones, BorderLayout.PAGE_END );
                seccionEntrada.setBackground(Color.decode("#141415"));
                
                //pane.setBorder(lineBorder);
                this.content.add(seccionEntrada);
                this.content.add(Box.createRigidArea(new Dimension(15,15)));
                content.updateUI();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Ocurrio un error al cargar la información");
            }
        }
    }
    
    public void mostrarDatosUsuario(Usuario usuarioCargar){
        this.desocultarElementosPerfil();
        this.lbNombreUsuario.setText(usuarioCargar.getNombreUsuario());
        this.lbNombreCompleto.setText(usuarioCargar.getNombreCompletoUsuario());
        this.lbFechaNacimiento.setText(usuarioCargar.getFechaNacUsuario());
        this.lbEntradas.setText("Entradas: "+usuarioCargar.getCantidadEntradas());
        this.lbSeguidores.setText("Seguidores: "+usuarioCargar.getTotalSeguidores());
        this.txtDescripcionUsuario.setText(usuarioCargar.getDescripcionUsuario());
    }
    
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
            java.util.logging.Logger.getLogger(GUIInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel bgContent;
    private javax.swing.JPanel btnCerrarSesion;
    private javax.swing.JPanel btnConfigurarPerfil;
    private javax.swing.JPanel btnInicio;
    private javax.swing.JPanel btnPerfil;
    private javax.swing.JPanel btnSeguirUsuario;
    private javax.swing.JPanel btnTuitear;
    private javax.swing.JPanel content;
    private javax.swing.JPanel contentPerfil;
    private javax.swing.JPanel fotoPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbEntradas;
    private javax.swing.JLabel lbFechaNacimiento;
    private javax.swing.JLabel lbFotoPerfil;
    private javax.swing.JLabel lbNombreCompleto;
    private javax.swing.JLabel lbNombreUsuario;
    private javax.swing.JLabel lbSeguidores;
    private javax.swing.JPanel mainSection;
    private javax.swing.JPanel profileSection;
    private javax.swing.JScrollPane scrollTextarea;
    private javax.swing.JTextField txtBuscador;
    private javax.swing.JTextArea txtDescripcionUsuario;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
