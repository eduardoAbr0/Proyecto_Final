package com.autosamistosos.interfaces.subpaneles.licenciasABCC;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class altasLicencias extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID, txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9;
    JComboBox combo1;
    JButton btnAgregar, btnLimpiar;

    public altasLicencias(){
        super("Altas licencias", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setResizable(false);

        JLabel txID = new JLabel("ID Licencia: ");
        agregarComp(txID, 0, 0, 1, 1, 1, 1);
        add(txID, gbc);
        SpinnerNumberModel spM = new SpinnerNumberModel(1, 1, null, 1);
        JSpinner spId = new JSpinner(spM);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) spId.getEditor()).getTextField();
        tf.setEditable(false);
        agregarComp(spId, 1, 0, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(spId, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx1 = new JLabel("Fecha emision: ");
        agregarComp(tx1,0,1,1,1,1,1);
        add(tx1, gbc);
        JDateChooser fechaEm = new JDateChooser();
        fechaEm.setDateFormatString("yyyy/MM/dd");
        agregarComp(fechaEm,1,1,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(fechaEm, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx2 = new JLabel("Fecha expiracion: ");
        agregarComp(tx2,0,2,1,1,1,1);
        add(tx2, gbc);
        JDateChooser fechaEx = new JDateChooser();
        fechaEx.setDateFormatString("yyyy/MM/dd");
        agregarComp(fechaEx,1,2,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(fechaEx, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx7 = new JLabel("Cliente: ");
        agregarComp(tx7,0,3,1,1,1,1);
        add(tx7, gbc);
        JComboBox cmbVentaID = new JComboBox();
        agregarComp(cmbVentaID,1,3,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbVentaID, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx9 = new JLabel("Automovil: ");
        agregarComp(tx9,0,4,1,1,1,1);
        add(tx9, gbc);
        JComboBox cmbAutoID = new JComboBox();
        agregarComp(cmbAutoID,1,4,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbAutoID, gbc);
        gbc.fill = GridBagConstraints.NONE;

        /*
        JLabel tx4 = new JLabel("Kilometraje: ");
        agregarComp(tx4,0,4,1,1,1,1);
        add(tx4, gbc);
        txt4 = new JTextField(10);
        agregarComp(txt4,1,4,1,1,1,1);
        add(txt4, gbc);

        JLabel tx6 = new JLabel("Seguro: ");
        agregarComp(tx6,0,6,1,1,1,1);
        add(tx6, gbc);
        txt6 = new JTextField(10);
        agregarComp(txt6,1,6,1,1,1,1);
        add(txt6, gbc);



         */


        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        agregarComp(btnAgregar,0,5,1,1,1,1);
        add(btnAgregar, gbc);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Component component: getContentPane().getComponents()){
                    if (component instanceof JTextField) {
                        JTextField textField = (JTextField) component;
                        textField.setText("");
                    }
                }
            }
        });
        agregarComp(btnLimpiar,1,5,1,1,1,1);
        add(btnLimpiar, gbc);

        setVisible(true);
    }

    public void agregarComp(JComponent c, int x, int y, int alt, int anch, int pesox, int pesoy){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = anch;
        gbc.gridheight = alt;
        gbc.weightx = pesox;
        gbc.weighty = pesoy;

        add(c,gbc);
    }
}
