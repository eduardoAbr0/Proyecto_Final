package com.autosamistosos.interfaces.subpaneles.facturasABCC;

import com.autosamistosos.interfaces.personalizacion.interfaz;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class cambiosFacturas extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txt1;
    JComboBox combo1;
    JButton btnCambiar, btnLimpiar;

    public cambiosFacturas(){
        super("Cambios facturas", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setResizable(false);

        JLabel txID = new JLabel("ID Factura: ");
        agregarComp(txID, 0, 0, 1, 1, 1, 1);
        add(txID, gbc);
        JComboBox cmbID = new JComboBox();
        agregarComp(cmbID, 1, 0, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbID, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx1 = new JLabel("Precio final: ");
        agregarComp(tx1,0,1,1,1,1,1);
        add(tx1, gbc);
        txt1 = new JTextField(10);
        txt1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!(Character.isDigit(e.getKeyChar()))) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        agregarComp(txt1,1,1,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txt1, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx2 = new JLabel("Financiamiento: ");
        agregarComp(tx2,0,2,1,1,1,1);
        add(tx2, gbc);
        combo1 = new JComboBox();
        combo1.addItem("Distribuidor");
        combo1.addItem("Banco");
        agregarComp(combo1,1,2,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(combo1, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txFechaf = new JLabel("Fecha emmision: ");
        JDateChooser fechaFab = new JDateChooser();
        fechaFab.setDateFormatString("yyyy/MM/dd");
        agregarComp(txFechaf, 0, 3, 1, 1, 1, 1);
        add(txFechaf, gbc);
        agregarComp(fechaFab, 1, 3, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(fechaFab, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx7 = new JLabel("Venta: ");
        agregarComp(tx7,0,4,1,1,1,1);
        add(tx7, gbc);
        JComboBox cmbVentaID = new JComboBox();
        agregarComp(cmbVentaID,1,4,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbVentaID, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx8 = new JLabel("Cliente: ");
        agregarComp(tx8,0,5,1,1,1,1);
        add(tx8, gbc);
        JComboBox cmbClienteID = new JComboBox();
        agregarComp(cmbClienteID,1,5,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbClienteID, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx9 = new JLabel("Automovil: ");
        agregarComp(tx9,0,6,1,1,1,1);
        add(tx9, gbc);
        JComboBox cmbAutoID = new JComboBox();
        agregarComp(cmbAutoID,1,6,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbAutoID, gbc);
        gbc.fill = GridBagConstraints.NONE;

        btnCambiar = new JButton("Cambiar");
        btnCambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        agregarComp(btnCambiar,0,7,1,1,1,1);
        add(btnCambiar, gbc);

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
        agregarComp(btnLimpiar,1,7,1,1,1,1);
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
