
import java.awt.Color;
import java.awt.image.BufferedImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class OperacionesImagenes extends javax.swing.JFrame {
    int img1, img2, oper;
    Main pantalla;
    BufferedImage img, sal;
    int indiceimgseleccion = -1;
    
    
    float [][][]arregimg = new float[3][][];
  
    /**
     * Creates new form OperacionesImagenes
     */
    public OperacionesImagenes() {
        initComponents();
    }

    
    public void setPantalla(Main pantalla) {
        this.pantalla = pantalla;
    }
    
    public void accionSuma(){
        img1 = img1-1;
        img2 = img2-1;
        if( this.pantalla.getActivoEnUso(img1) == 1 && this.pantalla.getActivoEnUso(img2) == 1){
            
            arregimg = MathImg.sumaImagenesColor(this.pantalla.getArregloImg(img1), this.pantalla.getArregloImg(img2));
            sal = MathImg.convierteDeArregloAImagen(arregimg);
            jPanel1.removeAll();
            jPanel1.setBackground(Color.black);
            jPanel1.repaint();
            Imagen im = new Imagen(jPanel1, sal, 1);
            jPanel1.add(im).repaint();
        }
    }
    
    public void accionResta(){
        img1 = img1-1;
        img2 = img2-1;
        if( this.pantalla.getActivoEnUso(img1) == 1 && this.pantalla.getActivoEnUso(img2) == 1){
            
            arregimg = MathImg.restaImagenesColor(this.pantalla.getArregloImg(img1), this.pantalla.getArregloImg(img2));
            sal = MathImg.convierteDeArregloAImagen(arregimg);
            jPanel1.removeAll();
            jPanel1.setBackground(Color.black);
            jPanel1.repaint();
            Imagen im = new Imagen(jPanel1, sal, 1);
            jPanel1.add(im).repaint();
        }
    }
            
    public void accionMultiplcacion(){
        img1 = img1-1;
        img2 = img2-1;
        if( this.pantalla.getActivoEnUso(img1) == 1 && this.pantalla.getActivoEnUso(img2) == 1){
            
            arregimg = MathImg.multiplicacionImagenesColor(this.pantalla.getArregloImg(img1), this.pantalla.getArregloImg(img2));
            sal = MathImg.convierteDeArregloAImagen(arregimg);
            jPanel1.removeAll();
            jPanel1.setBackground(Color.black);
            jPanel1.repaint();
            Imagen im = new Imagen(jPanel1, sal, 1);
            jPanel1.add(im).repaint();
        }
    }
    
    public void accionDivicion(){
        img1 = img1-1;
        img2 = img2-1;
        if( this.pantalla.getActivoEnUso(img1) == 1 && this.pantalla.getActivoEnUso(img2) == 1){
            
            arregimg = MathImg.divicionImagenesColor(this.pantalla.getArregloImg(img1), this.pantalla.getArregloImg(img2));
            sal = MathImg.convierteDeArregloAImagen(arregimg);
            jPanel1.removeAll();
            jPanel1.setBackground(Color.black);
            jPanel1.repaint();
            Imagen im = new Imagen(jPanel1, sal, 1);
            jPanel1.add(im).repaint();
        }
    }
    
    public void accionMarcaAgua(float porc){
        img1 = img1-1;
        img2 = img2-1;
        if( this.pantalla.getActivoEnUso(img1) == 1 && this.pantalla.getActivoEnUso(img2) == 1){
            
            arregimg = MathImg.marcadeAguaColor(this.pantalla.getArregloImg(img1), this.pantalla.getArregloImg(img2), porc);
            sal = MathImg.convierteDeArregloAImagen(arregimg);
            jPanel1.removeAll();
            jPanel1.setBackground(Color.black);
            jPanel1.repaint();
            Imagen im = new Imagen(jPanel1, sal, 1);
            jPanel1.add(im).repaint();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        jComboBox4 = new javax.swing.JComboBox();
        textField1 = new java.awt.TextField();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Imagen", "1", "2", "3", "4", "5", "6" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "operacion", "+", "-", "*", "/", "Marca Agua" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Imagen", "1", "2", "3", "4", "5", "6" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });

        button1.setLabel("Calcular");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setLabel("Aplicar");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Resultado a Imagen", "1", "2", "3", "4", "5", "6" }));
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });

        textField1.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        img1 = jComboBox1.getSelectedIndex();
        img2 = jComboBox3.getSelectedIndex();
        oper = jComboBox2.getSelectedIndex();
        
        if(img1 * img2 * oper > 0){
            switch(oper){
                case 1:
                    accionSuma();
                break;
                case 2:
                    accionResta();
                break;
                case 3:
                    accionMultiplcacion();
                break;
                case 4:
                    accionDivicion();
                break;
                case 5: //10.0f
                    float num = Float.parseFloat( textField1.getText() );
                    accionMarcaAgua(num);
                break;
            }
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        img1 = jComboBox1.getSelectedIndex();
        img2 = jComboBox3.getSelectedIndex();
        oper = jComboBox2.getSelectedIndex();
        int imgres = jComboBox4.getSelectedIndex();
        
        System.out.println(img1 +", "+ img2 +", "+ oper +", "+ imgres);
        if( (img1 * img2 * oper * imgres) > 0){
            img1=img1-1;
            img2=img2-1;
            switch(oper){
                case 1:
                    this.pantalla.ordenSumaImagenes(imgres, img1, img2);
                break;
                case 2:
                    this.pantalla.ordenRestaImagenes(imgres, img1, img2);
                break;
                case 3:
                    this.pantalla.ordenMultiplicacionImagenes(imgres, img1, img2);
                break;
                case 4:
                    this.pantalla.ordenDivicionImagenes(imgres, img1, img2);
                break;
                case 5:
                    this.pantalla.ordenMarcadeAguaImagenes(imgres, img1, img2);
                break;
            }
        }
        
    }//GEN-LAST:event_button2ActionPerformed

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ItemStateChanged

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
            java.util.logging.Logger.getLogger(OperacionesImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OperacionesImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OperacionesImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OperacionesImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OperacionesImagenes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JPanel jPanel1;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
