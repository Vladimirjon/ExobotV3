package UserInterface.Form;


import javax.swing.*;

import BusinessLogic.ExobotBL;
import BusinessLogic.ExobotBL;
import DataAccess.DTO.ExobotDTO;
import DataAccess.DTO.ExobotDTO;
import UserInterface.IAStyle;
import UserInterface.CustomerControl.PatButton;
import UserInterface.CustomerControl.PatLabel;
import UserInterface.CustomerControl.PatTextBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExobotPanel  extends JPanel implements ActionListener {
    private Integer idExobot = 0, idMaxExobot=0;
    private ExobotBL exobotBL = null;
    private ExobotDTO exobot = null;

    public ExobotPanel() {
        try {
            
            customizeComponent();
            loadRow();
            showRow();
            showTable();

            btnRowIni.addActionListener(this);
            btnRowAnt.addActionListener(this);
            btnRowSig.addActionListener(this);
            btnRowFin.addActionListener(this);
            
            btnNuevo.addActionListener(     e -> btnNuevoClick());
            btnGuardar.addActionListener(   e -> btnGuardarClick());
            btnEliminar.addActionListener(  e -> btnEliminarClick());
            btnCancelar.addActionListener(  e -> btnCancelarClick());
        } catch (Exception e) {
            IAStyle.showMsg(e.getMessage());
        }
    }

    private void loadRow() throws Exception {
        idExobot      = 2;
        exobotBL      = new ExobotBL();
        exobot        = exobotBL.getByIdExobot(idExobot);
        
    }

    private void showRow() {
        boolean exobotNull = (exobot == null);
        txtIdExobot.setText((exobotNull) ? " " : exobot.getIdExobot().toString());            
        txtModelo.setText((exobotNull) ? " " : exobot.getModelo());
        txtArmaIzq.setText((exobotNull) ? " " : exobot.getArmaIzquierda());
        txtArmaDer.setText((exobotNull) ? " " : exobot.getArmaDerecha());
        txtEspanol.setText((exobotNull) ? " " : exobot.getAprenderEspanol().toString());
        txtIngles.setText((exobotNull) ? " " : exobot.getAprenderIngles().toString());

        lblTotalReg.setText(idExobot.toString() + " de " + idMaxExobot.toString());
    }

    private void btnNuevoClick() {
        exobot = null;
        showRow();
    } 
    
    private void btnGuardarClick() {
        boolean exobotNull = (exobot == null);
        // String buttonText = ((JButton) e.getSource()).getText();
        try {
            if (IAStyle.showConfirmYesNo("¿Seguro que desea " + ((exobotNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
                if (exobotNull)
                    exobot = new ExobotDTO(0,txtModelo.getText(),txtArmaIzq.getText(),txtArmaDer.getText(),true,true);
                else
                    exobot.setModelo(txtModelo.getText());
                    exobot.setArmaIzquierda(txtArmaIzq.getText());
                    exobot.setArmaDerecha(txtArmaDer.getText());
                    exobot.setAprenderEspanol(true);
                    exobot.setAprenderIngles(true);

    
                if(!((exobotNull) ? exobotBL.create(exobot) : exobotBL.update(exobot)))
                    IAStyle.showMsgError("Error al guardar...!");
    
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            IAStyle.showMsgError(e.getMessage());
        }
    }

    private void btnEliminarClick() {
        try {
            if (IAStyle.showConfirmYesNo("Seguro que desea Eliminar?")) {

                if (!exobotBL.delete(exobot.getIdExobot()))
                    throw new Exception("Error al eliminar...!");
    
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            IAStyle.showMsgError(e.getMessage());
        }
    }

    private void btnCancelarClick() {
        try {
            if(exobot == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            idExobot = 1;
        if (e.getSource() == btnRowAnt && (idExobot > 1))
            idExobot--;
        if (e.getSource() == btnRowSig && (idExobot < idMaxExobot))
            idExobot++;
        if (e.getSource() == btnRowFin)
            idExobot = idMaxExobot;
        try {
            exobot    = exobotBL.getByIdExobot(idExobot);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        String[] header = {"IdExobot", "Modelo","ArmaIzq","ArmaDer","Espanol","Ingles"};
        Object[][] data = new Object[exobotBL.getAll().size()][6];
        int index = 0;
        for (ExobotDTO s : exobotBL.getAll()) {
            data[index][0] = s.getIdExobot();
            data[index][1] = s.getModelo();
            data[index][2] = s.getArmaIzquierda();
            data[index][3] = s.getArmaDerecha();
            data[index][4] = s.getAprenderEspanol();
            data[index][5] = s.getAprenderIngles();
            
            index++;
        }

        JTable table = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.BLACK);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table.setPreferredScrollableViewportSize(new Dimension(450, 150));
        table.setFillsViewportHeight(true);

        pnlTabla.removeAll();
        pnlTabla.add(new JScrollPane(table));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                if (row >= 0 && col >= 0) {
                    String strIdExobot = table.getModel().getValueAt(row, 0).toString();
                    idExobot = Integer.parseInt(strIdExobot);
                    try {
                        exobot = exobotBL.getByIdExobot(idExobot);
                        showRow();
                    } catch (Exception ignored) {
                    }
                    System.out.println("Tabla.Selected: " + strIdExobot);
                }
            }
        });
    }

/************************
 * FormDesing : pat_mic
 ************************/ 
    private PatLabel 
        lblTitulo  = new PatLabel(" EXOBOT "          ),
        lblIdExobot  = new PatLabel(" Num Exobot :      " ),
        lblModelo  = new PatLabel(" Modelo :      " ),
        lblArmaIzq  = new PatLabel(" ArmaIzquieda: " ),
        lblArmaDer  = new PatLabel(" ArmaDerecha: " ),
        lblEspanol  = new PatLabel(" Ingles: " ),
        lblIngles  = new PatLabel(" Espanol: " ),
        lblTotalReg= new PatLabel("  0 de 0  "    );
    private PatTextBox 
            txtIdExobot  = new PatTextBox (),
            txtModelo  = new PatTextBox (),
            txtArmaIzq = new PatTextBox (),
            txtArmaDer = new PatTextBox (),
            txtEspanol = new PatTextBox (),
            txtIngles = new PatTextBox ();
    private PatButton 
            btnPageIni  = new PatButton(" |< "),
            btnPageAnt  = new PatButton(" << "),
            btnPageSig  = new PatButton(" >> "),
            btnPageFin  = new PatButton(" >| "),

            btnRowIni   = new PatButton(" |< "),
            btnRowAnt   = new PatButton(" << "),
            btnRowSig   = new PatButton(" >> "),
            btnRowFin   = new PatButton(" >| "),

            btnNuevo    = new PatButton("Nuevo"),
            btnGuardar  = new PatButton("Guardar"),
            btnCancelar = new PatButton("Cancelar"),
            btnEliminar = new PatButton("Eliminar");
    private JPanel 
            pnlTabla    = new JPanel(),
            pnlBtnRow   = new JPanel(new FlowLayout()),
            pnlBtnPage  = new JPanel(new FlowLayout()),
            pnlBtnCRUD  = new JPanel(new FlowLayout());

    public void customizeComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        txtIdExobot.setEnabled(false);
        txtIdExobot.setBorderLine();
        txtModelo.setBorderLine();

        pnlBtnPage.add(btnPageIni);
        pnlBtnPage.add(btnPageAnt);
        pnlBtnPage.add(new PatLabel(" Page:( "));
        pnlBtnPage.add(lblTotalReg); //cambiar
        pnlBtnPage.add(new PatLabel(" ) "));
        pnlBtnPage.add(btnPageSig);
        pnlBtnPage.add(btnPageFin);

        pnlBtnRow.add(btnRowIni);
        pnlBtnRow.add(btnRowAnt);
        pnlBtnRow.add(lblTotalReg);
        pnlBtnRow.add(btnRowSig);
        pnlBtnRow.add(btnRowFin);

        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(IAStyle.createBorderRect());

        gbc.insets = new Insets(3, 3, 3, 3);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de datos: "), gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        add(pnlBtnPage, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.ipady = 200;
        gbc.ipadx = 500;
        pnlTabla.add(new Label("Loading data..."));
        add(pnlTabla, gbc);

        gbc.ipady = 1;
        gbc.ipadx = 1;

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(40, 0, 0, 0);  // Ajusta el valor superior a 50
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(Box.createRigidArea(new Dimension(0, 0)), gbc);

        gbc.insets = new Insets(10, 0, 0, 0);  

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de registro: "), gbc);
        gbc.gridy = 4;
        gbc.gridx = 1;
        add(pnlBtnRow, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(lblIdExobot, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdExobot, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(lblModelo, gbc);
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtModelo, gbc);

        gbc.gridy =7;
        gbc.gridx =0;
        add(lblArmaIzq,gbc);
        gbc.gridy =7;
        gbc.gridx=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(txtArmaIzq,gbc);

        gbc.gridy =8;
        gbc.gridx =0;
        add(lblArmaDer,gbc);
        gbc.gridy =8;
        gbc.gridx=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(txtArmaDer,gbc);

        gbc.gridy =9;
        gbc.gridx =0;
        add(lblEspanol,gbc);
        gbc.gridy =9;
        gbc.gridx=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(txtEspanol,gbc);

        gbc.gridy =10;
        gbc.gridx =0;
        add(lblIngles,gbc);
        gbc.gridy =10;
        gbc.gridx=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(txtIngles,gbc);

        

        // gbc.gridy = 7;
        // gbc.gridx = 1;
        // gbc.gridwidth = 2;
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // add(pnlBtnRow, gbc);

        gbc.gridy = 11;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}