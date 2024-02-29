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

import BussinessLogic.SoldadoBL;
import BussinessLogic.Soldadoconndata;
import UserInterface.Form.MainForm;
import UserInterface.Form.SplashScreenForm;

public class App {
    public static void main(String[] args) throws Exception {
        SoldadoBL bl = new SoldadoBL();
        Soldadoconndata soldadoconndata = new Soldadoconndata();
        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try {
                UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
            } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } 
    
       SplashScreenForm.show();
       MainForm frmMain = new MainForm("IABot");

  
       
          
    }
}

