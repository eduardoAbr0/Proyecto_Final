package com.autosamistosos.interfaces.subpaneles.reportesABCC;

import com.autosamistosos.interfaces.personalizacion.interfaz;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class altasReportes extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID, txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9,txt10, txt11;
    JComboBox combo1;
    JButton btnAgregar, btnLimpiar;

    public altasReportes(){
        super("Altas reportes", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 250, 300);
        setResizable(false);

        JLabel txID = new JLabel("ID reporte: ");
        agregarComp(txID,0,0,1,1,0,0);
        add(txID, gbc);
        SpinnerNumberModel spM = new SpinnerNumberModel(1, 1, null, 1);
        JSpinner spId = new JSpinner(spM);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) spId.getEditor()).getTextField();
        tf.setEditable(false);
        agregarComp(spId,1,0,1,1,0,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(spId, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txFechaf = new JLabel("Mes: ");
        JDateChooser fechaFab = new JDateChooser();
        fechaFab.setDateFormatString("MM");
        agregarComp(txFechaf,0,1,1,1,0,0);
        add(txFechaf, gbc);
        agregarComp(fechaFab,1,1,1,1,0,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(fechaFab, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx2 = new JLabel("Comision: ");
        agregarComp(tx2,0,2,1,1,0,0);
        add(tx2, gbc);
        txt2 = new JTextField(10);
        txt2.setEditable(false);
        agregarComp(txt2,1,2,1,1,0,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txt2, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx3 = new JLabel("Venta: ");
        agregarComp(tx3,0,3,1,1,0,0);
        add(tx3, gbc);
        JComboBox cmbVenta = new JComboBox();
        agregarComp(cmbVenta,1,3,1,1,0,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbVenta, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx11 = new JLabel("Empleado: ");
        agregarComp(tx11,0,4,1,1,0,0);
        add(tx11, gbc);
        JComboBox cmbEmpleados = new JComboBox();
        agregarComp(cmbEmpleados,1,4,1,1,0,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbEmpleados, gbc);
        gbc.fill = GridBagConstraints.NONE;

        btnAgregar = new JButton("Agregar");
        agregarComp(btnAgregar,0,5,1,1,0,0);
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

        aplicarEstilos(getContentPane());
        setVisible(true);
    }

    public void agregarComp(JComponent c, int x, int y, int alt, int anch, int pesox, int pesoy){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = anch;
        gbc.gridheight = alt;
        gbc.weightx = pesox;
        gbc.weighty = pesoy;

        gbl.setConstraints(c,gbc);
    }

    public void aplicarEstilos(Container container) {
        for (Component c : container.getComponents()) {
            if (c instanceof JButton) {
                interfaz.estiloBoton((JButton) c,20);
            } else if (c instanceof  JTextField) {
                interfaz.personalizarTextField((JTextField) c,Color.BLACK,22,Color.BLACK);
            } else if (c instanceof  JLabel) {
                interfaz.personalizarLabelNormal((JLabel) c,Color.BLACK,22);
            } else if (c instanceof Container) {
                // Llamada recursiva para aplicar el estilo a los sub-componentes
                aplicarEstilos((Container) c);
            }
        }
    }
}
