/*---------------------------------------------------\
|  Copyright (©) 2K24 EPN-FIS. All rights reserved.  |
|  pat_mic@hotmail.com  PROPRIETARY/CONFIDENTIAL.    |
|  Use is subject to license terms.       pat_mic    |
\---------------------------------------------------*/

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

import UserInterface.Form.MainForm;
import UserInterface.Form.SplashScreenForm;

public class App {
    public static void main(String[] args) throws Exception {
        // Whiterun oWhiterun= new Whiterun();
        // oWhiterun.iniciar();

        // DACExoBot ex = new DACExoBot();
        // DACSexo  sx = new DACSexo();
        // ResultSet rs = sx.getAllSexo();
        // while (rs.next()) {
        //     System.out.println( rs.getString(1) + " " + rs.getString(2) + " "+ rs.getString(3));
        // }
        
        // SexoDTO s = new SexoDTO();
        // s.setIdSexo(3);
        // s.setNombre("Hibrido");
        // s.setFechaModifica("2023-05-18 17:39:46");
        // SexoDAO oS = new SexoDAO();
        // // oS.create(s);
        // oS.update(s);
        // System.out.println(oS.readBy(3).toString());

        // for (SexoDTO s  : oS.readAll()) {
        //     System.out.println(s.toString());
        //     //  System.out.println( s.getNombre() + " " + s.getFechaCrea() );
        // }
        // SexoBL sBl = new SexoBL();
        // sBl.update(5, "Macho Alpha");
        // sBl.delete(5);
        // for (SexoDTO s : sBl.getAll()) {
        //     System.out.println(s.toString());
        // }
        // Ventana v = new Ventana();

            // LocalidadDAO l = new LocalidadDAO();
            // System.out.println(l.readBy(2).toString());
            // for (LocalidadDTO loca : l.readAll()) {
            //     System.out.println(loca.toString());
            // }

            // LocalidadBL lBL= new LocalidadBL();
            // for (LocalidadDTO l : lBL.getAllCanton()) {
            //     System.out.println(l.toString());
            // }

            //Ventana v = new Ventana();
//             JWindow window = new JWindow();
// window.getContentPane().add(
//     new JLabel("", new ImageIcon("IA.jpg"), SwingConstants.CENTER));
// window.setBounds(500, 150, 300, 200);
// window.setVisible(true);
// try {
//     Thread.sleep(5000);
// } catch (InterruptedException e) {
//     e.printStackTrace();
// }
// window.setVisible(false);
// JFrame frame = new JFrame();
// frame.add(new JLabel("Welcome"));
// frame.setVisible(true);
// frame.setSize(300,100);
// window.dispose();

        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try {
                UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
            } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } 
    
       SplashScreenForm.show();
       MainForm frmMain = new MainForm("IABot");

    //    try {
    //         SexoDAO sDao = new SexoDAO();
    //         for (SexoDTO s : sDao.readAll()) 
    //             System.out.println(s.toString());
    //    } catch (Exception e) {
    //         System.out.println(e.toString());
    //    }
       
          
    }
}
