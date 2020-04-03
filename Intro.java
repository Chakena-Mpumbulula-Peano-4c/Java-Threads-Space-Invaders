/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

/**
 *
 * @author mpumbulula.chakenane
 */
public class Intro extends Spazio {
     private int i = 0;
     private BufferStrategy strategy;

    @Override
    public void paint(Graphics g) {
 // scrivi nel canvas la scritta in Rosso 
            g.setColor(Color.red);
            // Seleziona i Font della scritta (Bold) e la dimensione dei caratteri (40)
            g.setFont(new Font("Bold", Font.PLAIN, 40));
            // Scrivi partendo dalla posizione x=100 e y=100
            g.drawString("Space Invaders", 100, 100);
            g.setFont(new Font("Bold", Font.PLAIN, 10));
            g.drawString("          by Chakena Mpumbulula", 110, 110);            
        }

    void run() throws InterruptedException {
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        setBackground (Color.BLACK);
       setSize(800, 600);
               
        for(i=100;i>=0;i-=1) {
            System.out.println("i: " + i);
            this.repaint();
            Thread.sleep(10);
        }
         for(i=0;i<10;i+=1) {
            System.out.println("i: " + i);
            disegna();
            //Thread.sleep(10);
        }
        
       }
    void disegna() {
        //chiediamo il buffer in cui comporre la nuova immagine
        Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
        //cancelliamo l'immagine precedente coprendola con un rettangolo nero
        g.setColor(Color.black);
        g.fillRect(0,0,800,600);
         
        // scrivi nel buffer la scritta in Rosso 
        g.setColor(Color.red);
        g.setFont(new Font("Bold", Font.PLAIN, 40+i));
        g.drawString("Space Invaders", 100+i, 100+i);
        g.setFont(new Font("Bold", Font.PLAIN, 10+i));
        g.drawString("          by Mpumbulula Chakena", 110+i+i, 110+i+i);
        //rilascia risorse create per la composizione di questa immagine
        g.dispose(); 
        //visualizza la nuova immagine sullo schermo
        strategy.show(); 
    }
    
    
    }
    

