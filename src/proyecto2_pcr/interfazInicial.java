/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto2_pcr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static proyecto2_pcr.Proyecto2_PCR.Arbol;

/**
 * @author Caicedo, Frank; Pernia, Luis; Rodriguez, Sebastian.
 */
public class interfazInicial extends javax.swing.JFrame {

    static String arregloTxt[];

    public interfazInicial() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cargarTXT = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ImprimirExpresiones = new javax.swing.JButton();
        ImprimirArbol = new javax.swing.JButton();
        Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Inicio");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 30, -1));

        cargarTXT.setText("Cargar TXT");
        cargarTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarTXTActionPerformed(evt);
            }
        });
        jPanel1.add(cargarTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel4.setText("Cargue un TXT con una expresion:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        ImprimirExpresiones.setText("Imprimir Expresiones");
        ImprimirExpresiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirExpresionesActionPerformed(evt);
            }
        });
        jPanel1.add(ImprimirExpresiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        ImprimirArbol.setText("Imprimir Arbol");
        ImprimirArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirArbolActionPerformed(evt);
            }
        });
        jPanel1.add(ImprimirArbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 140, -1));

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jPanel1.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Boton para agregar el archivo TXT 
    private void cargarTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarTXTActionPerformed
        Proyecto2_PCR.Arbol = new ArbolBinario();
        Scanner entrada = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(fileChooser);
        try {
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            File f = new File(ruta);
            entrada = new Scanner(f);
            while (entrada.hasNext()) {
                String[] arreglo = entrada.nextLine().split(" ");
                arregloTxt = arreglo;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("No se ha seleccionado ningún fichero");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
        try{
        if("+".equals(arregloTxt[0]) || "/".equals(arregloTxt[0]) || "*".equals(arregloTxt[0]) || "-".equals(arregloTxt[0]) || "^".equals(arregloTxt[0])){
            Proyecto2_PCR.Arbol.ConvertirPrefijaArbol(Proyecto2_PCR.Arbol.getpRoot(),arregloTxt,0);
        }
        else if("+".equals(arregloTxt[arregloTxt.length-1]) || "/".equals(arregloTxt[arregloTxt.length-1]) || "*".equals(arregloTxt[arregloTxt.length-1]) || "-".equals(arregloTxt[arregloTxt.length-1]) || "^".equals(arregloTxt[arregloTxt.length-1])){
        Proyecto2_PCR.Arbol.ConvertirPosfijoArbol(arregloTxt);
        }
        else{
            arregloTxt = Proyecto2_PCR.Arbol.ConversionInfijaPostfija(arregloTxt);
            Proyecto2_PCR.Arbol.ConvertirPosfijoArbol(arregloTxt);
        }
        if(Proyecto2_PCR.Arbol.EsVacio(Proyecto2_PCR.Arbol.getpRoot())){
        JOptionPane.showMessageDialog(null, "La expresion que ingreso no es valida");
        }
        else{
        JOptionPane.showMessageDialog(null, "Archivo TXT cargado");
        }
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, "La expresion que ingreso no es valida");
        }
    }//GEN-LAST:event_cargarTXTActionPerformed
    
    //Boton para mostrar el arbol
    private void ImprimirArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirArbolActionPerformed
            if(Proyecto2_PCR.Arbol.EsVacio(Proyecto2_PCR.Arbol.getpRoot())){
                JOptionPane.showMessageDialog(null, "Error, no existe ningun archivo TXT en el sistema");
            }
            else{
                JFrame frame = new ArbolBinarioGrafico();
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
    }//GEN-LAST:event_ImprimirArbolActionPerformed

    //Metodo para mostrar las expresiones
    private void ImprimirExpresionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirExpresionesActionPerformed
        if (Proyecto2_PCR.Arbol.EsVacio(Proyecto2_PCR.Arbol.getpRoot())) {
            JOptionPane.showMessageDialog(null, "Error, no existe ningun archivo TXT en el sistema");
        }
        else{
            this.setVisible(false);
            InterfazOrdenes ventanaOrdenes = new InterfazOrdenes();
            Proyecto2_PCR.Arbol.ImprimirPreorden(Proyecto2_PCR.Arbol.getpRoot(),ventanaOrdenes);
            Proyecto2_PCR.Arbol.ImprimirInorden(Proyecto2_PCR.Arbol.getpRoot(),ventanaOrdenes);
            Proyecto2_PCR.Arbol.ImprimirPosorden(Proyecto2_PCR.Arbol.getpRoot(),ventanaOrdenes);
            ventanaOrdenes.setVisible(true);
        }
    }//GEN-LAST:event_ImprimirExpresionesActionPerformed

    //Metodo para salir del sistema
    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.setVisible(false);
        JOptionPane.showMessageDialog(null, "Gracias vuelva pronto");
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

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
            java.util.logging.Logger.getLogger(interfazInicial.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfazInicial.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfazInicial.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfazInicial.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfazInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ImprimirArbol;
    private javax.swing.JButton ImprimirExpresiones;
    private javax.swing.JButton Salir;
    private javax.swing.JButton cargarTXT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
