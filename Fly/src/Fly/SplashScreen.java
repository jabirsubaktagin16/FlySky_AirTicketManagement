/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fly;

import java.awt.Color;

/**
 *
 * @author ASUS
 */
public class SplashScreen extends javax.swing.JFrame {

    /**
     * Creates new form SplashScreen
     */
    public SplashScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loadingNum = new javax.swing.JLabel();
        loadingBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(null);

        loadingNum.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        loadingNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loadingNum.setText("99%");
        jPanel1.add(loadingNum);
        loadingNum.setBounds(0, 360, 800, 40);

        loadingBar.setForeground(new java.awt.Color(0, 204, 102));
        jPanel1.add(loadingBar);
        loadingBar.setBounds(200, 360, 420, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Splash Screen.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 450);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(800, 450));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SplashScreen splash=new SplashScreen();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                splash.setVisible(true);
            }
        });
        CustomerFirstPage start=new CustomerFirstPage();
        try{
            for(int i=0;i<=100;i++)
            {
                Thread.sleep(40);
                splash.loadingBar.setValue(i);
                splash.loadingNum.setText(Integer.toString(i)+"%");
                if(i==49)
                    splash.loadingNum.setForeground(Color.white);
            }
        }
        catch(Exception e)
        {
        }
        new SplashScreen().setVisible(false);
        start.setVisible(true);
        splash.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JProgressBar loadingBar;
    public javax.swing.JLabel loadingNum;
    // End of variables declaration//GEN-END:variables
}
