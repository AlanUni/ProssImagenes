
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class Main extends javax.swing.JFrame {

    private int indice, indImagen;
    
    
    private BufferedImage img, sal;
    private Graphics g;
    /**
     * Creates new form Main
     */
    float [][][][] arrim;
    int activos[] = {0,0,0,0,0,0};
    
    public Main() {
        initComponents();
        this.indice = 1;
        recorrerPaneles();
        arrim = new float[6][3][][];
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
    }

    public float [][][] getArregloImg(int i) {
        return this.arrim[i];
    }
    
    public void setArregloImg (int indice, float [][][] arreglo){
        this.arrim[indice] = arreglo;
        sal = MathImg.convierteDeArregloAImagen(arrim[indice]);
        borrarPintar();
    }
    
    public void dibujaExterno(BufferedImage sal){
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
            
            Imagen im = new Imagen(imagenPrincipal, sal, 1);
            imagenPrincipal.add(im).repaint();
    }
    
    public int getActivoEnUso(int i){
        return this.activos[i];
    }
    
    
    public void setIndice(int indice){
        this.indice = indice;
    }
    
    public int getIndice(){
        return this.indice;
    }
    
    public void recorrerPaneles(){
        imagenPrincipal.removeAll();
        imagenPrincipal.setBackground(Color.black);
        imagenPrincipal.repaint();
        
        jPanel1.setBackground(Color.black);
        jPanel2.setBackground(Color.black);
        jPanel3.setBackground(Color.black);
        jPanel4.setBackground(Color.black);
        jPanel5.setBackground(Color.black);
        jPanel6.setBackground(Color.black);
        
        switch(getIndice()){
            case 1: jPanel1.setBackground(Color.red); break;
            case 2: jPanel2.setBackground(Color.red); break;
            case 3: jPanel3.setBackground(Color.red); break;
            case 4: jPanel4.setBackground(Color.red); break;
            case 5: jPanel5.setBackground(Color.red); break;
            case 6: jPanel6.setBackground(Color.red); break;
        }
        
        indImagen = getIndice() - 1;
        if( activos[indImagen] == 1){
            sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
            
            Imagen im = new Imagen(imagenPrincipal, sal, 1);
            imagenPrincipal.add(im).repaint();
        }
           
        
    }
    
    public void seleccionPanel(int indice){
        setIndice(indice);
        recorrerPaneles();
    }
    
    
    public void pintarMiniatura(int indice){
        Imagen im;
            
        switch(getIndice()){
            case 1: im = new Imagen(jPanel1, sal, 0);
                                    jPanel1.add(im).repaint();
            break;
            case 2: im = new Imagen(jPanel2, sal, 0);
                                    jPanel2.add(im).repaint();
            break;
            case 3: im = new Imagen(jPanel3, sal, 0);
                                    jPanel3.add(im).repaint();
            break;
            case 4: im = new Imagen(jPanel4, sal, 0);
                                    jPanel4.add(im).repaint();
            break;
            case 5: im = new Imagen(jPanel5, sal, 0);
                                    jPanel5.add(im).repaint();
            break;
            case 6: im = new Imagen(jPanel6, sal, 0);
                                    jPanel6.add(im).repaint();
            break;
        }
    }
    
    public void borrarPintar(){
    
        imagenPrincipal.removeAll();
        imagenPrincipal.setBackground(Color.black);
        imagenPrincipal.repaint();
        
           
        switch(getIndice()){
            case 1: 
                jPanel1.removeAll();
                jPanel1.setBackground(Color.black);
                jPanel1.repaint();
            break;
            case 2: 
                jPanel2.removeAll();
                jPanel2.setBackground(Color.black);
                jPanel2.repaint();
            break;
            case 3: 
                jPanel3.removeAll();
                jPanel3.setBackground(Color.black);
                jPanel3.repaint();
            break;
            case 4: 
                jPanel4.removeAll();
                jPanel4.setBackground(Color.black);
                jPanel4.repaint();
            break;
            case 5: 
                jPanel5.removeAll();
                jPanel5.setBackground(Color.black);
                jPanel5.repaint();
            break;
            case 6: 
                jPanel6.removeAll();
                jPanel6.setBackground(Color.black);
                jPanel6.repaint();
            break;
        }
        
        
        Imagen im = new Imagen(imagenPrincipal, sal, 1);
        imagenPrincipal.add(im).repaint();
            
        pintarMiniatura(getIndice());
        
    }
    
    public void pintarPaneles(String color){
        
        System.out.println(color);
        jPanel1.setBackground(Color.red);
    }
    
    
    public void ordenSumaImagenes(int ind, int i1, int i2){
        setIndice(ind);
        indImagen = getIndice() - 1;
        
        activos[indImagen] = 1;
        arrim[indImagen] = MathImg.sumaImagenesColor(arrim[i1], arrim[i2]);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
    }
    public void ordenRestaImagenes(int ind, int i1, int i2){
        setIndice(ind);
        indImagen = getIndice() - 1;
        
        activos[indImagen] = 1;
        arrim[indImagen] = MathImg.restaImagenesColor(arrim[i1], arrim[i2]);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
    }
    public void ordenMultiplicacionImagenes(int ind, int i1, int i2){
        setIndice(ind);
        indImagen = getIndice() - 1;
        
        activos[indImagen] = 1;
        arrim[indImagen] = MathImg.multiplicacionImagenesColor(arrim[i1], arrim[i2]);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
    }
    public void ordenDivicionImagenes(int ind, int i1, int i2){
        setIndice(ind);
        indImagen = getIndice() - 1;
        
        activos[indImagen] = 1;
        arrim[indImagen] = MathImg.divicionImagenesColor(arrim[i1], arrim[i2]);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
    }
    public void ordenMarcadeAguaImagenes(int ind, int i1, int i2){
        setIndice(ind);
        indImagen = getIndice() - 1;
        activos[indImagen] = 1;
        arrim[indImagen] = MathImg.marcadeAguaColor(arrim[i1], arrim[i2], 10.0f);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
    }
    public void ordenescalaXYImagen(float esc){
        indImagen = getIndice() - 1;
        arrim[indImagen] = MathImg.escalaXYColor(arrim[indImagen], esc);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
    }
    public void ordenescalaXYInterpolacionImagen(float esc){
        indImagen = getIndice() - 1;
        arrim[indImagen] = MathImg.escalaXYInterpolacionColor(arrim[indImagen], esc);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        imagenPrincipal = new javax.swing.JPanel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        jComboBox1 = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\ProssImg\\matematicas.png")); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\ProssImg\\histograma.png")); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(70, 70));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(70, 70));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(70, 70));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(70, 70));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(70, 70));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setPreferredSize(new java.awt.Dimension(70, 70));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        imagenPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        imagenPrincipal.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout imagenPrincipalLayout = new javax.swing.GroupLayout(imagenPrincipal);
        imagenPrincipal.setLayout(imagenPrincipalLayout);
        imagenPrincipalLayout.setHorizontalGroup(
            imagenPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
        );
        imagenPrincipalLayout.setVerticalGroup(
            imagenPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        button1.setBackground(new java.awt.Color(0, 0, 0));
        button1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        button1.setForeground(new java.awt.Color(0, 255, 0));
        button1.setLabel("+");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(0, 0, 0));
        button2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        button2.setForeground(new java.awt.Color(51, 255, 0));
        button2.setLabel("-");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escala XY", "Escala XY Interpolacion" }));

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem11.setText("jMenuItem11");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuItem12.setText("jMenuItem12");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

        jMenuItem15.setText("Abrir Imagen");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem15);

        jMenuItem14.setText("Guardar");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem14);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Efectos");

        jMenuItem2.setText("Convierte a Gris");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem5.setText("Umbral");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem3.setText("Negativo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem6.setText("Espejo en X");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Espejo en Y");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Rotar 90 Izquierda");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("Rotar 90 Derecha");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem10.setText("Gira 180");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Operaciones");

        jMenuItem4.setText("Escalares/Matematicas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem13.setText("Imagenes");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(imagenPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 46, Short.MAX_VALUE))
                    .addComponent(imagenPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            // TODO add your handling code here:
            /*Edicion x = new Edicion();
            x.setPantalla(this);
            x.setVisible(true);
            */
            File archivo = new File("imagen.jpg");
            
            img = ImageIO.read(archivo);
            
            
            indImagen = getIndice() - 1;
            activos[indImagen] = 1;
            arrim[indImagen] = MathImg.convierteDeImagenaArreglo(img);
            sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
            
            borrarPintar();
            //Imagen im = new Imagen(imagenPrincipal, sal, 1);
            //imagenPrincipal.add(im).repaint();
            
            //pintarMiniatura(getIndice());
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        seleccionPanel(1);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
        
        seleccionPanel(2);
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
        seleccionPanel(3);
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        seleccionPanel(4);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
        seleccionPanel(5);
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
        seleccionPanel(6);
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:        
        indImagen = getIndice() - 1;
        arrim[indImagen] = MathImg.convierteGris(arrim[indImagen]);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:        
        indImagen = getIndice() - 1;
        arrim[indImagen] = MathImg.negativoColor(arrim[indImagen]);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        indImagen = getIndice() - 1;
        OperacionEscalar x = new OperacionEscalar();
        x.setPantalla(this);
        x.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        indImagen = getIndice() - 1;
        arrim[indImagen] = MathImg.umbralColor(arrim[indImagen], 80.0f);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        indImagen = getIndice() - 1;
        arrim[indImagen] = MathImg.espejoXColor(arrim[indImagen]);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        indImagen = getIndice() - 1;
        arrim[indImagen] = MathImg.espejoYColor(arrim[indImagen]);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:indImagen = getIndice() - 1;
        indImagen = getIndice() - 1;
        arrim[indImagen] = MathImg.rotar90IzqColor(arrim[indImagen]);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        indImagen = getIndice() - 1;
        arrim[indImagen] = MathImg.rotar90DerColor(arrim[indImagen]);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        indImagen = getIndice() - 1;
        arrim[indImagen] = MathImg.gira180Color(arrim[indImagen]);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
                try {
            // TODO add your handling code here:
            /*Edicion x = new Edicion();
            x.setPantalla(this);
            x.setVisible(true);
            */
            File archivo = new File("imagen2.jpg");
            
            img = ImageIO.read(archivo);
            
            
            indImagen = getIndice() - 1;
            activos[indImagen] = 1;
            arrim[indImagen] = MathImg.convierteDeImagenaArreglo(img);
            sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
            
            //Imagen im = new Imagen(imagenPrincipal, sal, 1);
            //imagenPrincipal.add(im).repaint();
            
            //pintarMiniatura(getIndice());
            borrarPintar();
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        /*indImagen = getIndice() - 1;
        activos[indImagen] = 1;
        arrim[indImagen] = MathImg.sumaImagenesColor(arrim[0], arrim[1]);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
        
        //ordenSumaImagenes(3, 0, 1);
        indImagen = getIndice() - 1;
        activos[indImagen] = 1;
        arrim[indImagen] = MathImg.marcadeAguaColor(arrim[0], arrim[1], 10.0f);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
        */
        indImagen = getIndice() - 1;
        arrim[indImagen] = MathImg.escalaXYInterpolacionColor(arrim[indImagen], 2f);
        sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
        borrarPintar();
        
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        //indImagen = getIndice() - 1;
        OperacionesImagenes operacionesImagenes = new OperacionesImagenes();
        operacionesImagenes.setPantalla(this);
        operacionesImagenes.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        int interpolacion = jComboBox1.getSelectedIndex();
        
        switch(interpolacion){
            case 0:
                ordenescalaXYImagen(0.8f);
            break;
            
            case 1:
                ordenescalaXYInterpolacionImagen(0.8f);
            break;
        }
    }//GEN-LAST:event_button2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        int interpolacion = jComboBox1.getSelectedIndex();
        
        switch(interpolacion){
            case 0:
                ordenescalaXYImagen(1.5f);
            break;
            
            case 1:
                ordenescalaXYInterpolacionImagen(1.5f);
            break;
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileFilter(new FileNameExtensionFilter("*.jpg", "jpg"));
    if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try {
            ImageIO.write(sal, "jpg", new File(file.getAbsolutePath()+".jpg"));
        } catch (IOException ex) {
            System.out.println("Failed to save image!");
        }
    } else {
        System.out.println("No file choosen!");
    }
    
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        FileDialog dialogoArchivo;
        dialogoArchivo = new FileDialog(this, "Lista de Archivos desde Frame",FileDialog.LOAD);
        dialogoArchivo.setVisible(true);
        if(dialogoArchivo.getFile()!=null){ 
            try {
            /* Validar que se haya Seleccionado un Archivo*/
            String directorio = dialogoArchivo.getDirectory();
            String nombreArchivo =dialogoArchivo.getFile();
            String rutatotal = directorio + nombreArchivo;
            
            
            File archivo = new File(nombreArchivo);
            
            img = ImageIO.read(archivo);
            
            
            indImagen = getIndice() - 1;
            activos[indImagen] = 1;
            arrim[indImagen] = MathImg.convierteDeImagenaArreglo(img);
            sal = MathImg.convierteDeArregloAImagen(arrim[indImagen]);
            
            borrarPintar();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
           System.out.println("No Seleccionó Archivo");
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JPanel imagenPrincipal;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
