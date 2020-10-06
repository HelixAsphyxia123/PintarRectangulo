/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prappletbasico;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author valti
 */
public class PintarRectangulo extends Applet implements ActionListener {

    private Label labAncho, labAlto;
    private TextField txtAncho, txtAlto;
    private Choice lstColor;
    private Button btnPintar, btnLimpiar;
    private boolean pintar;
    private Color colorAUsar;

    public PintarRectangulo() {
        labAncho = new Label("ANCHO");
        labAlto = new Label("ALTO");
        txtAncho = new TextField(5);
        txtAlto = new TextField(5);
        lstColor = new Choice();
        btnPintar = new Button("PINTAR");
        btnLimpiar = new Button("LIMPIAR");

        lstColor.add("Rojo");
        lstColor.add("Naranjado");
        lstColor.add("Negro");
        lstColor.add("Cyan");
        lstColor.add("Verde");
        lstColor.add("Amarillo");
        lstColor.add("Magenta");
        lstColor.add("Azul");
        
        add(labAncho);
        add(txtAncho);
        
        add(labAlto);
        add(txtAlto);
        
        add(lstColor);
        
        add(btnPintar);
        add(btnLimpiar);
        
        btnPintar.addActionListener(this);
        btnLimpiar.addActionListener(this);
        
    }//PintarRectangulo
    
    public void init(){
        resize(600,400);
        pintar = false;
        
    }
    @Override
    public void paint(Graphics g){
        int x, y;
        int ancho, alto;
        if( pintar == true){
            ancho = Integer.parseInt(txtAncho.getText());
            alto = Integer.parseInt(txtAlto.getText());
            //fijar el color para graficar
            g.setColor(Color.BLACK);
            x =40; y=100;
            g.drawString("Rectangulo["+ancho+" x "+alto+"]",x,y);
            
            //pintar el rectangulo relleno
            x = 100; y=90;
            g.setColor(colorAUsar);
            g.fillRect(x,y,ancho,alto);
        }
    }//paint

    public void actionPerformed(ActionEvent e) {
        
        if( e.getSource()== btnPintar){
            pintar = true;
            String colorSeleccionado = lstColor.getSelectedItem();
            if( colorSeleccionado.equalsIgnoreCase("Rojo") ){
                colorAUsar = Color.RED;
            }else if( colorSeleccionado.equalsIgnoreCase("Naranjado")){
                colorAUsar = Color.ORANGE;  
            }else if( colorSeleccionado.equalsIgnoreCase("Negro")){
                colorAUsar = Color.BLACK;  
            }else if( colorSeleccionado.equalsIgnoreCase("Cyan")){
                colorAUsar = Color.CYAN;  
            }else if( colorSeleccionado.equalsIgnoreCase("Verde")){
                colorAUsar = Color.GREEN;  
            }else if( colorSeleccionado.equalsIgnoreCase("Amarillo")){
                colorAUsar = Color.YELLOW;  
            }else if( colorSeleccionado.equalsIgnoreCase("Magenta")){
                colorAUsar = Color.magenta;  
            }else if( colorSeleccionado.equalsIgnoreCase("Azul")){
                colorAUsar = Color.BLUE;  
            }
            
            
        }
        if(e.getSource()== btnLimpiar){
            pintar = false;
            txtAncho.setText("");
            txtAlto.setText("");
        }
        repaint();

    }//ActionListener
}//PintarRectangulo
