package UserInterface.CustomerControl;

import javax.swing.*;

import UserInterface.IAStyle;

import java.awt.*;

public class MCLabelText extends JPanel{
    private MCLabel    lblEtiqueta = new MCLabel();
    private MCTextBox  txtContenido= new MCTextBox();

    public MCLabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(  etiqueta, 
                                            IAStyle.FONT_SMALL, 
                                            IAStyle.COLOR_FONT_LIGHT, 
                                            IAStyle.ALIGNMENT_LEFT); 
        //txtContenido.setBorder(txtContenido.createBorderLine());
        txtContenido.setBorderLine();
        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}
