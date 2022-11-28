/*
 @author Caicedo, Frank; Pernia, Luis; Rodriguez, Sebastian.
 */
package proyecto2_pcr;

import javax.swing.*;
import java.awt.*;

public class ArbolBinarioGrafico extends JFrame {
    //Método para dibujar el Árbol
    public int drawTree(Graphics g, NodoArbol x, int x0, int x1, int y){
        int m = (x0 + x1) / 2;
        g.setColor(Color.RED);
        g.fillOval(m, y, 30, 30);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial",Font.BOLD,20));
        String t = String.valueOf(x.getInfo());
        g.drawString(t, m+10, y+25);
        if (x.getpHijoIzquierdo() != null) {
            int x2 = drawTree(g, x.getpHijoIzquierdo(),x0,m,y+50);
            g.drawLine(m+15, y+30, x2+12, y+50);
            g.setColor(Color.BLACK);
        }
        if (x.getpHijoDerecho() != null) {
            int x2 = drawTree(g, x.getpHijoDerecho(),m,x1,y+50);
            g.drawLine(m+15, y+30, x2+12, y + 50);
            g.setColor(Color.BLACK);
        }
        return m;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawTree(g, Proyecto2_PCR.Arbol.getpRoot(), 0, this.getWidth()-25, 100);
    }
}