package com.autosamistosos.interfaces.subpaneles.ventasABCC;

import com.autosamistosos.basedatos.modelo.Factura;
import com.autosamistosos.interfaces.personalizacion.interfaz;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class altasVentas extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID, txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9,txt10, txt11;
    JComboBox combo1;
    JButton btnAgregar, btnLimpiar;

    public altasVentas(){
        super("Altas ventas", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 500);
        setResizable(false);

        JLabel txID = new JLabel("ID Venta: ");
        agregarComp(txID,0,0,1,1,1,1);
        add(txID, gbc);
        SpinnerNumberModel spM = new SpinnerNumberModel(1, 1, null, 1);
        JSpinner spId = new JSpinner(spM);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) spId.getEditor()).getTextField();
        tf.setEditable(false);
        agregarComp(spId,1,0,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(spId, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txFechaf = new JLabel("Fecha fabriacion: ");
        JDateChooser fechaFab = new JDateChooser();
        fechaFab.setDateFormatString("yyyy/MM/dd");
        agregarComp(txFechaf,0,1,1,1,1,1);
        add(txFechaf, gbc);
        agregarComp(fechaFab,1,1,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(fechaFab, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx2 = new JLabel("Impuesto: ");
        agregarComp(tx2,0,2,1,1,1,1);
        add(tx2, gbc);
        txt2 = new JTextField(10);
        txt2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!(Character.isDigit(e.getKeyChar()) || (e.getKeyChar() == '.'))) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        agregarComp(txt2,1,2,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txt2, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx3 = new JLabel("Costo licencia: ");
        agregarComp(tx3,0,3,1,1,1,1);
        add(tx3, gbc);
        txt3 = new JTextField(10);
        txt3.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!(Character.isDigit(e.getKeyChar()) || (e.getKeyChar() == '.'))) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        agregarComp(txt3,1,3,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txt3, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx4 = new JLabel("Seguro: ");
        agregarComp(tx4,0,4,1,1,1,1);
        add(tx4, gbc);
        JComboBox cmbSeguro = new JComboBox();
        cmbSeguro.addItem("Seguro total");
        cmbSeguro.addItem("Seguro Robo");
        cmbSeguro.addItem("Seguro Accidentes");
        agregarComp(cmbSeguro,1,4,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbSeguro, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx5 = new JLabel("Kilometros : ");
        agregarComp(tx5,0,5,1,1,1,1);
        add(tx5, gbc);
        txt5 = new JTextField(10);
        txt5.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!(Character.isDigit(e.getKeyChar()) || (e.getKeyChar() == '.'))) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        agregarComp(txt5,1,5,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txt5, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx6 = new JLabel("Adiciones: ");
        agregarComp(tx6,0,6,1,1,1,1);
        add(tx6, gbc);
        combo1 = new JComboBox();
        combo1.addItem("Ninguno");
        combo1.addItem("Adornos");
        combo1.addItem("Sistema alarma");
        combo1.addItem("Sistema audio");
        agregarComp(combo1,1,6,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(combo1, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx7 = new JLabel("Tipo pago: ");
        agregarComp(tx7,0,7,1,1,1,1);
        add(tx7, gbc);
        JComboBox cmbTPago = new JComboBox();
        cmbTPago.addItem("Completo");
        cmbTPago.addItem("Parcial");
        agregarComp(cmbTPago,1,7,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbTPago, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx8 = new JLabel("RFC Cliente: ");
        agregarComp(tx8,0,8,1,1,1,1);
        add(tx8, gbc);
        txt8 = new JTextField(10);
        agregarComp(txt8,1,8,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txt8, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txPA = new JLabel("Primer apellido cliente: ");
        agregarComp(txPA,0,9,1,1,1,1);
        add(txPA, gbc);
        JTextField txtPrimerA = new JTextField(10);
        agregarComp(txtPrimerA,1,9,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtPrimerA, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txSA = new JLabel("Segundo apellido cliente: ");
        agregarComp(txSA,0,10,1,1,1,1);
        add(txSA, gbc);
        JTextField txtSegundoA = new JTextField(10);
        agregarComp(txtSegundoA,1,10,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtSegundoA, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txNmCasa = new JLabel("Numero casa cliente: ");
        agregarComp(txNmCasa,0,11,1,1,1,1);
        add(txNmCasa, gbc);
        JTextField txtNumeroCasa = new JTextField(10);
        txtNumeroCasa.addKeyListener(new KeyListener() {
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
        agregarComp(txtNumeroCasa,1,11,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtNumeroCasa, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txCalle = new JLabel("Calle cliente: ");
        agregarComp(txCalle,0,12,1,1,1,1);
        add(txCalle, gbc);
        JTextField txtCalle = new JTextField(10);
        agregarComp(txtCalle,1,12,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtCalle, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txColonia = new JLabel("Colonia cliente: ");
        agregarComp(txColonia,0,13,1,1,1,1);
        add(txColonia, gbc);
        JTextField txtColonia = new JTextField(10);
        agregarComp(txtColonia,1,13,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtColonia, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txCP = new JLabel("CP cliente: ");
        agregarComp(txCP,0,14,1,1,1,1);
        add(txCP, gbc);
        JTextField txtCP = new JTextField(10);
        txtCP.addKeyListener(new KeyListener() {
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
        agregarComp(txtCP,1,14,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtCP, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx9 = new JLabel("Auto: ");
        agregarComp(tx9,0,15,1,1,1,1);
        add(tx9, gbc);
        JComboBox cmbAutos = new JComboBox();
        agregarComp(cmbAutos,1,15,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbAutos, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx10 = new JLabel("Cliente: ");
        agregarComp(tx10,0,16,1,1,1,1);
        add(tx10, gbc);
        JComboBox cmbClientes = new JComboBox();
        agregarComp(cmbClientes,1,16,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbClientes, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel tx11 = new JLabel("Empleado: ");
        agregarComp(tx11,0,17,1,1,1,1);
        add(tx11, gbc);
        JComboBox cmbEmpleados = new JComboBox();
        agregarComp(cmbEmpleados,1,17,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbEmpleados, gbc);
        gbc.fill = GridBagConstraints.NONE;

        btnAgregar = new JButton("Agregar");
        agregarComp(btnAgregar,0,18,1,1,1,1);
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
        agregarComp(btnLimpiar,1,18,1,1,1,1);
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
