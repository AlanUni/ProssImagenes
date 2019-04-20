/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.image.BufferedImage;

/**
 *
 * @author CC005
 */

public class MathImg {
    final static int B = 2;
    final static int G = 1;
    final static int R = 0;
    
    public static float [][][] convierteDeImagenaArreglo(BufferedImage bf){
        float [][][] arrimg = new float[3][][];
        int alto = bf.getHeight();
        int ancho = bf.getWidth();
        int variable;
        
        
        
        for(int i=0; i<3; i++){
            arrimg[i] = new float[alto][ancho];
        }
        
        for(int i=0; i<alto; i++){
            for(int j=0; j<ancho; j++){
                variable = bf.getRGB(j, i);
                arrimg[R][i][j] = (variable >>16 & 0xFF);
                arrimg[G][i][j] = (variable >>8 & 0xFF);
                arrimg[B][i][j] = (variable & 0xFF);
            }
        }
        
        return arrimg;
    }    
    
    public static BufferedImage convierteDeArregloAImagen(float [][][] ent){
        BufferedImage sal = null;
        int alto = ent[0].length, ancho = ent[0][0].length;
        
        
        System.out.println("Impresion : anchoXalto "+ancho+"X"+alto);
        
        
        sal = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        
        int pixel;
        
        for(int i=0; i<alto; i++){
            for(int j=0; j<ancho; j++){
                pixel = (int) ent[B][i][j] | (int)ent[G][i][j] << 8 | (int)ent[R][i][j] << 16;
                //System.out.print("-"+pixel+"-");
                sal.setRGB(j, i, pixel);
            }
        }
        
        return sal;       
    }
    
    public static float [][][] reescalaRangoDinamico(float [][][] ent){
            float [][][] sal = new float[3][][];
            int alto = ent[0].length, ancho = ent[0][0].length;
            float max[], min[], factor[];
            max = new float[3];
            min = new float[3];
            factor = new float[3];

            for(int i=0; i<3; i++){
                sal[i] = new float[alto][ancho];
            }
    
            for(int i=0; i<3; i++){
                max[i] = ent[i][0][0];
                min[i] = ent[i][0][0];
            }


    
            for(int k=0; k<3; k++){
                for(int i=0; i<alto; i++){
                    for(int j=0; j<ancho; j++){
                        //if ( max[k] < ent[k][i][j]) max[k] = ent[k][i][j];
                        //if ( min[k] > ent[k][i][j]) min[k] = ent[k][i][j];

                        max[k] = Math.max(max[k], ent[k][i][j]);
                        min[k] = Math.min(min[k], ent[k][i][j]);
                    }
                }
            }
    
    

            for(int k=0; k<3; k++){
                factor[k] = 255.0f/(max[k]-min[k]);
                for(int i=0; i<alto; i++){
                    for(int j=0; j<ancho; j++){
                        sal[k][i][j] = factor[k]*(ent[k][i][j] - min[k]);
                    }
                }
            }
    
            System.out.println("Reescalado : anchoXalto "+ancho+"X"+alto);
        
    
    	return sal;
    }

    public static float [][][] convierteGris(float [][][] ent){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
                sal[i] = new float [alto][ancho];
        }
          
        for(int i=0; i<alto; i++){
            for(int j=0; j<ancho; j++){
                sal[R][i][j] = (ent[R][i][j] + ent[G][i][j] + ent[B][i][j])/3;
                sal[G][i][j] = sal[R][i][j];
                sal[B][i][j] = sal[R][i][j];
            }
        }
        return sal;
    }
    
    public static float [][][] umbralColor(float [][][] ent, float umbr){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
                sal[i] = new float [alto][ancho];
                sal[i] = umbral(ent[i], umbr);
        }
        
        return sal;
    }
    
    public static float [][] umbral(float [][] arr, float umbral){
        int filas = arr.length, cols = arr[0].length;
        float [][] asal = new float[filas][cols];
            
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = arr[i][j] > umbral ? 255 : 0;
            }
        }
        
        return asal;
    }
    
    public static float [][][] negativoColor(float [][][] ent){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
                sal[i] = negativo(ent[i]);
        }
        
        return sal;
    }
    
    public static float [][] negativo(float [][] arr){
        int filas = arr.length, cols = arr[0].length;
        float [][] asal = new float[filas][cols];
        float max = arr[0][0];
            
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                max = Math.max(arr[i][j], max);
            }
        }
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = max - arr[i][j];
            }
        }
        
        return asal;
    }
    
    
    
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
    public static float [][][] sumaEscalarColor(float [][][] ent, float esc){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = sumaEsc(ent[i], esc);
        }
        
        return sal;
    }
    
    public static float [][] sumaEsc(float [][] arr, float esc){
        int filas = arr.length, cols = arr[0].length;
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = arr[i][j] + esc;
            }
        }
        
        return asal;
    }
    
    
    public static float [][][] restaEscalarColor(float [][][] ent, float esc){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = restaEsc(ent[i], esc);
        }
        
        return sal;
    }
    
    public static float [][] restaEsc(float [][] arr, float esc){
        int filas = arr.length, cols = arr[0].length;
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = arr[i][j] - esc;
            }
        }
        
        return asal;
    }
    
    public static float [][][] multiplicacionEscalarColor(float [][][] ent, float esc){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = multiplicacionEsc(ent[i], esc);
        }
        
        return sal;
    }
    
    public static float [][] multiplicacionEsc(float [][] arr, float esc){
        int filas = arr.length, cols = arr[0].length;
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = arr[i][j] * esc;
            }
        }
        
        return asal;
    }
    
    public static float [][][] divicionEscalarColor(float [][][] ent, float esc){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = divicionEsc(ent[i], esc);
        }
        
        return sal;
    }
    
    public static float [][] divicionEsc(float [][] arr, float esc){
        int filas = arr.length, cols = arr[0].length;
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = arr[i][j] / esc;
            }
        }
        
        return asal;
    }
    
    public static float [][][] potenciaColor(float [][][] ent, float pot){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = potencia(ent[i], pot);
        }
        
        return sal;
    }
    
    public static float [][] potencia(float [][] arr, float pot){
        int filas = arr.length, cols = arr[0].length;
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = (float) Math.pow(arr[i][j], pot);
            }
        }
        
        return asal;
    }
    
    
    public static float [][][] raizColor(float [][][] ent){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = raiz(ent[i]);
        }
        
        return sal;
    }
    
    public static float [][] raiz(float [][] arr){
        int filas = arr.length, cols = arr[0].length;
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = (float) Math.sqrt(arr[i][j] * 20);
                
            }
        }
        
        return asal;
    }
    
    
    public static float [][][] logaritmoColor(float [][][] ent){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = logaritmo(ent[i]);
        }
        
        return sal;
    }
    
    public static float [][] logaritmo(float [][] arr){
        int filas = arr.length, cols = arr[0].length;
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = (float) Math.log(arr[i][j])*10f;
                
            }
        }
        
        return asal;
    }

    public static float [][][] senoColor(float [][][] ent){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = seno(ent[i]);
        }
        
        return sal;
    }
    
    public static float [][] seno(float [][] arr){
        int filas = arr.length, cols = arr[0].length;
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = (float) Math.sinh(arr[i][j]);
                
            }
        }
        
        return asal;
    }
    
    
    public static float [][][] cosenoColor(float [][][] ent){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = coseno(ent[i]);
        }
        
        return sal;
    }
    
    public static float [][] coseno(float [][] arr){
        int filas = arr.length, cols = arr[0].length;
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = (float) Math.cosh(arr[i][j]);
                
            }
        }
        
        return asal;
    }
    
    
    public static float [][][] tangenteColor(float [][][] ent){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = tangente(ent[i]);
        }
        
        return sal;
    }
    
    public static float [][] tangente(float [][] arr){
        int filas = arr.length, cols = arr[0].length;
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = (float) Math.tan(arr[i][j]);
                
            }
        }
        
        return asal;
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
    public static float [][][] espejoYColor(float [][][] ent){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = espejoY(ent[i]);
        }
        
        return sal;
    }
    
    public static float [][] espejoY(float [][] arr){
        int filas = arr.length, cols = arr[0].length;
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = arr[filas-1-i][j];
            }
        }
        
        return asal;
    }
    
    public static float [][][] espejoXColor(float [][][] ent){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = espejoX(ent[i]);
        }
        
        return sal;
    }
    
    public static float [][] espejoX(float [][] arr){
        int filas = arr.length, cols = arr[0].length;
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = arr[i][cols-1-j];
            }
        }
        
        return asal;
    }
    
    public static float [][][] rotar90DerColor(float [][][] ent){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = rotar90Der(ent[i]);
        }
        
        return sal;
    }
    
    public static float [][] rotar90Der(float [][] arr){
        int filas = arr.length, cols = arr[0].length;
        float [][] asal = new float[cols][filas];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[j][i] = arr[i][j];
            }
        }
        
        return espejoX(asal);
    }
    
    public static float [][][] rotar90IzqColor(float [][][] ent){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = rotar90Izq(ent[i]);
        }
        
        return sal;
    }
    
    public static float [][] rotar90Izq(float [][] arr){
        int filas = arr.length, cols = arr[0].length;
        float [][] asal = new float[cols][filas];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[cols-1-j][filas-1-i] = arr[i][j];
            }
        }
        
        return espejoX(asal);
    }
    
    public static float [][][] gira180Color(float [][][] ent){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = rota180(ent[i]);
        }
        
        return sal;
    }
    
    public static float [][] rota180(float [][] arr){
        int filas = arr.length, cols = arr[0].length;
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = arr[filas-1-i][cols-1-j];
            }
        }
        
        return asal;
    }
    
    public static float [][][] sumaImagenesColor(float [][][] img1, float [][][] img2){
        float [][][] sal = new float[3][][];
        int alto = Math.min(img1[0].length, img2[0].length);
        int ancho = Math.min(img1[0][0].length, img2[0][0].length);
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = sumaImagenes(img1[i], img2[i]);
        }
        
        return sal;
    }
    
    public static float [][] sumaImagenes(float [][] im1, float [][] im2){
        int filas = Math.min(im1.length, im2.length);
        int cols = Math.min(im1[0].length, im2[0].length);
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = im1[i][j] + im2[i][j];
            }
        }
        
        return asal;
    }
    
    public static float [][][] restaImagenesColor(float [][][] img1, float [][][] img2){
        float [][][] sal = new float[3][][];
        int alto = Math.min(img1[0].length, img2[0].length);
        int ancho = Math.min(img1[0][0].length, img2[0][0].length);
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = restaImagenes(img1[i], img2[i]);
        }
        
        return sal;
    }
    
    public static float [][] restaImagenes(float [][] im1, float [][] im2){
        int filas = Math.min(im1.length, im2.length);
        int cols = Math.min(im1[0].length, im2[0].length);
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = im1[i][j] - im2[i][j];
            }
        }
        
        return asal;
    }
    
    
    public static float [][][] multiplicacionImagenesColor(float [][][] img1, float [][][] img2){
        float [][][] sal = new float[3][][];
        int alto = Math.min(img1[0].length, img2[0].length);
        int ancho = Math.min(img1[0][0].length, img2[0][0].length);
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = multiplicacionImagenes(img1[i], img2[i]);
        }
        
        return sal;
    }
    
    public static float [][] multiplicacionImagenes(float [][] im1, float [][] im2){
        int filas = Math.min(im1.length, im2.length);
        int cols = Math.min(im1[0].length, im2[0].length);
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = im1[i][j] * im2[i][j];
            }
        }
        
        return asal;
    }
    
    
    public static float [][][] divicionImagenesColor(float [][][] img1, float [][][] img2){
        float [][][] sal = new float[3][][];
        int alto = Math.min(img1[0].length, img2[0].length);
        int ancho = Math.min(img1[0][0].length, img2[0][0].length);
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = divicionImagenes(img1[i], img2[i]);
        }
        
        return sal;
    }
    
    public static float [][] divicionImagenes(float [][] im1, float [][] im2){
        int filas = Math.min(im1.length, im2.length);
        int cols = Math.min(im1[0].length, im2[0].length);
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                if(im2[i][j] == 0){
                    asal[i][j] = im1[i][j] / 0.01f;
                }else{
                    asal[i][j] = im1[i][j] / im2[i][j];
                }
                
            }
        }
        
        return asal;
    }
    
    
    public static float [][][] marcadeAguaColor(float [][][] img1, float [][][] img2, float porc){
        float [][][] sal = new float[3][][];
        //int alto = img1[0].length;
        //int ancho = img1[0][0].length;
            
        for(int i=0; i<3; i++){
            //sal[i] = new float[alto][ancho];
            sal[i] = marcaAgua(img1[i], img2[i], porc);
        }
        
        return sal;
    }
    
    
    public static float [][] marcaAgua(float [][] im1, float [][] im2, float porc){
        int filas = im1.length;
        int cols = im1[0].length;
        int filch = im2.length;
        int colch = im2[0].length;
        
        float [][] asal = new float[filas][cols];
        int vecesfila = filas/filch;
        int vecescol = cols/colch;
        
        for(int fg=0; fg<=vecesfila; fg++){
            for(int cg=0; cg<=vecescol; cg++){
                for(int i=0; i<filch; i++){
                    for(int j=0; j<colch; j++){
                        if((filch*fg+i)<filas && (colch*cg + j) < cols)
                            asal[filch*fg + i][colch*cg +j] = im1[filch*fg+i][colch*cg +j] + im2[i][j];
                    }
                }
            }
        }
        
        return asal;
    }
    
    
    
    public static float [][][] escalaXYColor(float [][][] ent, float esc){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = escalaXY(ent[i], esc);
        }
        
        return sal;
    }

    public static float [][] escalaXY(float [][] im1, float esc){
        int filas = (int)(im1.length*esc);
        int cols = (int)(im1[0].length*esc);
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = im1[(int)(i/esc)][(int)(j/esc)];
            }
        }
        
        return asal;
    }


    
    
    
    public static float [][][] escalaXYInterpolacionColor(float [][][] ent, float esc){
        float [][][] sal = new float[3][][];
        int alto = ent[0].length, ancho = ent[0][0].length;
            
        for(int i=0; i<3; i++){
            sal[i] = new float[alto][ancho];
            sal[i] = escalaXYInterpolacion(ent[i], esc);
        }
        
        return sal;
    }
    public static float [][] escalaXYInterpolacion(float [][] im1, float esc){
        int filas = (int)(im1.length*esc);
        int cols = (int)(im1[0].length*esc);
        float [][] asal = new float[filas][cols];
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<cols; j++){
                asal[i][j] = interpolacion( im1, (i/esc), (j/esc) );
            }
        }
        
        return asal;
    }
    
    public static float interpolacion(float I[][], float y, float x){
        float i1,i2,i3 = 0;
        int filas = I.length, cols = I[0].length;
        int i = (int) y, j = (int) x;
        float deltax = x-j, deltay = y-i;
        if(j < cols-1 && i<filas-1){
            i1 = (I[i][j+1] - I[i][j])*deltax + I[i][j];
            i2 = (I[i+1][j+1] - I[i+1][j])*deltax + I[i+1][j];
            i3 = (i2-i1)*deltay +i1;
        }
        return i3;
    }

}




class ImageArr{
    float [][][] img;
}
