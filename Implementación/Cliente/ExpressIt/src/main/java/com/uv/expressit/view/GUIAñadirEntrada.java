/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.uv.expressit.view;

import com.uv.expressit.DAO.DAOEntrada;
import com.uv.expressit.POJO.Entrada;
import com.uv.expressit.POJO.Hashtag;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author josuecg
 */
public class GUIAñadirEntrada extends javax.swing.JFrame {
    Entrada entradaNueva = new Entrada();
    String cadenaHashtags = "";
    ArrayList<Hashtag> listaHashtags = new ArrayList<Hashtag>();
    /**
     * Creates new form GUIAñadirEntrada
     */
    public GUIAñadirEntrada() {
        initComponents();
        this.setTitle("Añadir entrada nueva");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextArea();
        btnPublicar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbContadorCatacteres = new javax.swing.JLabel();
        btnAñadirMultimedia = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbNombreArchivo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHashtags = new javax.swing.JTextField();
        txtAñadirHashtags = new javax.swing.JTextField();
        btnAñadirHashtag = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(20, 20, 21));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEntrada.setBackground(new java.awt.Color(41, 41, 43));
        txtEntrada.setColumns(20);
        txtEntrada.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        txtEntrada.setForeground(new java.awt.Color(204, 204, 204));
        txtEntrada.setLineWrap(true);
        txtEntrada.setRows(5);
        txtEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEntradaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEntradaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtEntrada);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 50, 620, 160));

        btnPublicar.setBackground(new java.awt.Color(0, 116, 158));
        btnPublicar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPublicarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPublicarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPublicarMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Publicar");

        javax.swing.GroupLayout btnPublicarLayout = new javax.swing.GroupLayout(btnPublicar);
        btnPublicar.setLayout(btnPublicarLayout);
        btnPublicarLayout.setHorizontalGroup(
            btnPublicarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPublicarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnPublicarLayout.setVerticalGroup(
            btnPublicarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(btnPublicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 120, 40));

        btnCancelar.setBackground(new java.awt.Color(120, 0, 14));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cancelar");

        javax.swing.GroupLayout btnCancelarLayout = new javax.swing.GroupLayout(btnCancelar);
        btnCancelar.setLayout(btnCancelarLayout);
        btnCancelarLayout.setHorizontalGroup(
            btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCancelarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnCancelarLayout.setVerticalGroup(
            btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 110, 40));

        lbContadorCatacteres.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lbContadorCatacteres.setForeground(new java.awt.Color(255, 255, 255));
        lbContadorCatacteres.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbContadorCatacteres.setText("0/280");
        bg.add(lbContadorCatacteres, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 10, 160, 30));

        btnAñadirMultimedia.setBackground(new java.awt.Color(0, 116, 158));
        btnAñadirMultimedia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAñadirMultimediaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAñadirMultimediaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAñadirMultimediaMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Foto/Video");

        javax.swing.GroupLayout btnAñadirMultimediaLayout = new javax.swing.GroupLayout(btnAñadirMultimedia);
        btnAñadirMultimedia.setLayout(btnAñadirMultimediaLayout);
        btnAñadirMultimediaLayout.setHorizontalGroup(
            btnAñadirMultimediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnAñadirMultimediaLayout.setVerticalGroup(
            btnAñadirMultimediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        bg.add(btnAñadirMultimedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        lbNombreArchivo.setForeground(new java.awt.Color(255, 255, 255));
        lbNombreArchivo.setText("<nombre_foto>");
        bg.add(lbNombreArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 15, 310, 20));

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hashtags: ");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 40));

        txtHashtags.setEditable(false);
        txtHashtags.setBackground(new java.awt.Color(41, 41, 43));
        txtHashtags.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        txtHashtags.setForeground(new java.awt.Color(153, 153, 153));
        txtHashtags.setText("Hashtags");
        bg.add(txtHashtags, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 250, 40));

        txtAñadirHashtags.setBackground(new java.awt.Color(41, 41, 43));
        txtAñadirHashtags.setForeground(new java.awt.Color(153, 153, 153));
        txtAñadirHashtags.setText("Añade #hashtags");
        txtAñadirHashtags.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAñadirHashtagsMouseClicked(evt);
            }
        });
        bg.add(txtAñadirHashtags, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 150, 40));

        btnAñadirHashtag.setBackground(new java.awt.Color(0, 116, 158));
        btnAñadirHashtag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAñadirHashtagMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAñadirHashtagMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAñadirHashtagMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("+");

        javax.swing.GroupLayout btnAñadirHashtagLayout = new javax.swing.GroupLayout(btnAñadirHashtag);
        btnAñadirHashtag.setLayout(btnAñadirHashtagLayout);
        btnAñadirHashtagLayout.setHorizontalGroup(
            btnAñadirHashtagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        btnAñadirHashtagLayout.setVerticalGroup(
            btnAñadirHashtagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        bg.add(btnAñadirHashtag, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 225, 50, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void txtEntradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaKeyTyped
        if(evt.getKeyCode() == 35){
            JOptionPane.showMessageDialog(this, "Es hashtag");
        }
        if(txtEntrada.getText().length() <280){
            this.lbContadorCatacteres.setText(txtEntrada.getText().length()+1+"/280");
        }else{
            txtEntrada.setEditable(false);
        }
    }//GEN-LAST:event_txtEntradaKeyTyped

    private void txtEntradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.txtEntrada.setEditable(true);
        }
    }//GEN-LAST:event_txtEntradaKeyPressed

    private void btnAñadirHashtagMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAñadirHashtagMouseEntered
        this.btnAñadirHashtag.setBackground(Color.decode("#00b0f0"));
    }//GEN-LAST:event_btnAñadirHashtagMouseEntered

    private void btnAñadirHashtagMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAñadirHashtagMouseExited
        this.btnAñadirHashtag.setBackground(Color.decode("#00749E"));
    }//GEN-LAST:event_btnAñadirHashtagMouseExited

    private void btnAñadirMultimediaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAñadirMultimediaMouseEntered
        this.btnAñadirMultimedia.setBackground(Color.decode("#00b0f0"));
        
    }//GEN-LAST:event_btnAñadirMultimediaMouseEntered

    private void btnAñadirMultimediaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAñadirMultimediaMouseExited
       this.btnAñadirMultimedia.setBackground(Color.decode("#00749E"));
    }//GEN-LAST:event_btnAñadirMultimediaMouseExited

    private void btnPublicarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPublicarMouseEntered
        this.btnPublicar.setBackground(Color.decode("#00b0f0"));
    }//GEN-LAST:event_btnPublicarMouseEntered

    private void btnPublicarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPublicarMouseExited
        this.btnPublicar.setBackground(Color.decode("#00749E"));
    }//GEN-LAST:event_btnPublicarMouseExited

    private void txtAñadirHashtagsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAñadirHashtagsMouseClicked
        if(this.txtAñadirHashtags.getText().equals("Añade #hashtags")){
            this.txtAñadirHashtags.setText("");
        }
    }//GEN-LAST:event_txtAñadirHashtagsMouseClicked

    private void btnAñadirMultimediaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAñadirMultimediaMouseClicked
        File imagen;
        int resultado;
        
        GUICargarArchivo Buscador = new GUICargarArchivo();  
        FileNameExtensionFilter format = new FileNameExtensionFilter("JPG, PNG, GIF, MP4, AVI, MKV, FLV, MOV", 
                                                                     "jpg", "jpeg", "png", "gif", "mp4", "avi", "mkv", "flv", "mov");
               
        Buscador.fcBuscador.setFileFilter(format);    
        resultado = Buscador.fcBuscador.showOpenDialog(null);
        
        if(JFileChooser.APPROVE_OPTION == resultado){
            
            imagen = Buscador.fcBuscador.getSelectedFile();
            lbNombreArchivo.setText(imagen.getName());
    
            //Aquie se subira la imagen o video

        }
    }//GEN-LAST:event_btnAñadirMultimediaMouseClicked

    private void btnPublicarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPublicarMouseClicked
       if(this.txtEntrada.getText().isBlank()){
           JOptionPane.showMessageDialog(this, "Debe de añadir texto a la entrada");
       }else{
           entradaNueva.setTextoEntrada(this.txtEntrada.getText());
       }
    }//GEN-LAST:event_btnPublicarMouseClicked

    private void btnAñadirHashtagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAñadirHashtagMouseClicked
        if(this.txtAñadirHashtags.getText().isBlank() || this.txtAñadirHashtags.getText().equals("Añade #hashtags")){
            JOptionPane.showMessageDialog(this, "Debe añadir texto para el hashtag");
        }else{
            Hashtag hashtagObtenido = DAOEntrada.obtenerHashtag(this.txtAñadirHashtags.getText());
            if(hashtagObtenido == null){
                hashtagObtenido = new Hashtag();
                hashtagObtenido.setTextoHashtag("#"+this.txtAñadirHashtags.getText());
            }
            cadenaHashtags = cadenaHashtags + hashtagObtenido.getTextoHashtag();
            this.txtHashtags.setText(cadenaHashtags);
            listaHashtags.add(hashtagObtenido);
        }
    }//GEN-LAST:event_btnAñadirHashtagMouseClicked

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
            java.util.logging.Logger.getLogger(GUIAñadirEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIAñadirEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIAñadirEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIAñadirEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIAñadirEntrada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btnAñadirHashtag;
    private javax.swing.JPanel btnAñadirMultimedia;
    private javax.swing.JPanel btnCancelar;
    private javax.swing.JPanel btnPublicar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbContadorCatacteres;
    private javax.swing.JLabel lbNombreArchivo;
    private javax.swing.JTextField txtAñadirHashtags;
    private javax.swing.JTextArea txtEntrada;
    private javax.swing.JTextField txtHashtags;
    // End of variables declaration//GEN-END:variables
}
