/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGraphique;


import algorithme.graph.BellmanFord;
import algorithme.graph.Prim;
import algorithme.graph.Kruskal;
import algorithme.graph.Dijsktra;
import javax.swing.*;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import models.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author CSX101
 */
public class weightedWindow extends javax.swing.JFrame {

    /**
     * Creates new form Window
     */
    
     public static boolean undirected;
    


    public weightedWindow(boolean direction) {
        this.undirected=direction;
        initComponents();
        weightedCanvas.undirected=direction;
        
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        play = new java.awt.Button();
        button2 = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        Report = new javax.swing.JTextArea();
        Algorithms = new javax.swing.JComboBox<>();
        weightedCanvas1 = new interfaceGraphique.weightedCanvas();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        play.setActionCommand("Play");
        play.setBackground(new java.awt.Color(255, 204, 204));
        play.setFont(new java.awt.Font("Constantia", 0, 24)); // NOI18N
        play.setForeground(new java.awt.Color(51, 0, 51));
        play.setLabel("GO");
        play.setName("play"); // NOI18N
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(153, 153, 153));
        button2.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        button2.setForeground(new java.awt.Color(51, 0, 51));
        button2.setLabel("CLEAR");
        button2.setName("reset"); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        Report.setEditable(false);
        Report.setColumns(20);
        Report.setRows(5);
        jScrollPane1.setViewportView(Report);

        Algorithms.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        Algorithms.setForeground(new java.awt.Color(51, 0, 51));
        Algorithms.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BellmanFord", "Dijkstra", "Prim", "Kruskal", " ", " " }));
        Algorithms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlgorithmsActionPerformed(evt);
            }
        });

        weightedCanvas1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout weightedCanvas1Layout = new javax.swing.GroupLayout(weightedCanvas1);
        weightedCanvas1.setLayout(weightedCanvas1Layout);
        weightedCanvas1Layout.setHorizontalGroup(
            weightedCanvas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
        );
        weightedCanvas1Layout.setVerticalGroup(
            weightedCanvas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setText("Algorithmes à appliquer");

        jLabel2.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setText("Resultats");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(Algorithms, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(weightedCanvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(673, 673, 673)
                .addComponent(play, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(play, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Algorithms, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(weightedCanvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
         // TODO add your handling code here:
         String alg = Algorithms.getSelectedItem().toString();
        if(weightedCanvas.undirected){
            if(alg.equals("BellmanFord"))  fct_bl(weightedCanvas.gr);
            if(alg.equals("Dijkstra"))  fct_dij(weightedCanvas.gr);
            if(alg.equals("Prim"))  fct_pri(weightedCanvas.gr);
            if(alg.equals("Kruskal"))  fct_kru(weightedCanvas.gr);
            
        }
        else{
        if(alg.equals("BellmanFord"))  fct_bl(weightedCanvas.gr);
        if(alg.equals("Dijkstra"))  fct_dij(weightedCanvas.gr);
        }
        
    }//GEN-LAST:event_playActionPerformed

    private void AlgorithmsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlgorithmsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlgorithmsActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed

         weightedCanvas.graph.clear();
         weightedCanvas.gr.resetgraph();  
         Report.setText("");
         weightedCanvas.count=1;
         repaint();
    }//GEN-LAST:event_button2ActionPerformed
   
    public String fct_pri(WeightedGraph gr){
    Prim algo=new Prim(gr);
    List<Edge1> list = new ArrayList<>();
       list= algo.getMST();
        Report.append(list.toString()+"\n");
        return list.toString();
    }
    public String fct_kru(WeightedGraph gr){
    Kruskal algo=new Kruskal(gr);
    List<Edge1> list = new ArrayList<>();
       list= algo.getMST();
        Report.append(list.toString()+"\n");
         return list.toString();
    }
    public String fct_bl(WeightedGraph gr){
    BellmanFord algo=new BellmanFord(gr);
        algo.shortestPath(1);
        Report.append(algo.distance.toString()+"\n");
         return algo.distance.toString();
    }
    public String fct_dij(WeightedGraph gr){
     Dijsktra dij = new Dijsktra(gr);
        dij.shortestPath(1);
        Report.append(dij.distance.toString()+"\n");   
         return dij.distance.toString();
    }
    
    
    /**

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {  }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new weightedWindow(undirected).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> Algorithms;
    private javax.swing.JTextArea Report;
    private java.awt.Button button2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Button play;
    private interfaceGraphique.weightedCanvas weightedCanvas1;
    // End of variables declaration//GEN-END:variables
}
