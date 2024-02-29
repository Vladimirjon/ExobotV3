package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import UserInterface.IAStyle;

public abstract class BuhoScreen {
    private static JFrame frmBuho;
    private static JProgressBar prbLoaging;
    private static ImageIcon icoImagen;
    private static JLabel lblBuho;

    public static void show() {
        icoImagen = new ImageIcon(IAStyle.URL_SPLASH);
        Image newImage = icoImagen.getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH);
        icoImagen = new ImageIcon(newImage);
        lblBuho = new JLabel(icoImagen);
        prbLoaging = new JProgressBar(0, 100);

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        prbLoaging.setStringPainted(true);
        prbLoaging.setForeground(new Color(255, 255, 255)); // Blanco
        prbLoaging.setBackground(new Color(0, 0, 0)); // Negro // Configurar el color de la barra de carga

        frmBuho = new JFrame();
        frmBuho.setUndecorated(true);
        frmBuho.getContentPane().add(lblBuho, BorderLayout.CENTER);
        frmBuho.add(prbLoaging, BorderLayout.SOUTH);
        frmBuho.setSize(icoImagen.getIconWidth(), icoImagen.getIconHeight());
        frmBuho.setLocationRelativeTo(null); // Centrar en la pantalla

        frmBuho.setVisible(true);
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50); // Espera por 50 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prbLoaging.setValue(i);
        }
        frmBuho.setVisible(false);
    }
}