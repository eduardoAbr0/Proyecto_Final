package com.autosamistosos.interfaces.subpaneles.ventasABCC;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class consultasVentas extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID;
    JButton btnConsultar, btnLimpiar;
    JRadioButton radioTodos, radioID, radio1, radio2, radio3, radio4, radio5, radio6, radio7, radio8, radio9, radio10, radio11, radio12, radio13, radio14;
    ButtonGroup radioGroup;
    JTable tbAuto;
    DefaultTableModel tableModel = new DefaultTableModel();
    public consultasVentas(){
        super("Consultas ventas", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 300);
        setResizable(false);

        //RADIO GROUP DONDE SE AGREGARAN LAS DIFERENTES OPCIONES DE BUSQUEDA
        radioGroup = new ButtonGroup();

        // TODOS
        radioTodos = new JRadioButton();
        radioGroup.add(radioTodos);
        JLabel txTodos = new JLabel("Todos");
        agregarComp(radioTodos, 0, 0, 1, 1, 0, 0);
        add(radioTodos, gbc);
        agregarComp(txTodos, 1, 0, 1, 1, 0, 0);
        add(txTodos, gbc);

        // ID
        radioID = new JRadioButton();
        radioGroup.add(radioID);
        JLabel txID = new JLabel("ID: ");
        JComboBox cmbID = new JComboBox();
        agregarComp(radioID, 0, 1, 1, 1, 0, 0);
        add(radioID, gbc);
        agregarComp(txID, 1, 1, 1, 1, 0, 0);
        add(txID, gbc);
        agregarComp(cmbID, 2, 1, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbID, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT1
        radio1 = new JRadioButton();
        radioGroup.add(radio1);
        JLabel txTXT1 = new JLabel("Fecha_venta: ");
        JDateChooser fechaFab = new JDateChooser();
        fechaFab.setDateFormatString("yyyy/MM/dd");
        agregarComp(radio1, 0, 2, 1, 1, 0, 0);
        add(radio1, gbc);
        agregarComp(txTXT1, 1, 2, 1, 1, 0, 0);
        add(txTXT1, gbc);
        agregarComp(fechaFab, 2, 2, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(fechaFab, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT2
        radio2 = new JRadioButton();
        radioGroup.add(radio2);
        JLabel txTXT2 = new JLabel("Impuesto: ");
        JTextField txtTXT2 = new JTextField(15);
        txtTXT2.addKeyListener(new KeyListener() {
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
        agregarComp(radio2, 0, 3, 1, 1, 0, 0);
        add(radio2, gbc);
        agregarComp(txTXT2, 1, 3, 1, 1, 0, 0);
        add(txTXT2, gbc);
        agregarComp(txtTXT2, 2, 3, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTXT2, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT3
        radio3 = new JRadioButton();
        radioGroup.add(radio3);
        JLabel txTXT3 = new JLabel("Costo licencia: ");
        JTextField txtTXT3 = new JTextField(15);
        txtTXT3.addKeyListener(new KeyListener() {
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
        agregarComp(radio3, 0, 4, 1, 1, 0, 0);
        add(radio3, gbc);
        agregarComp(txTXT3, 1, 4, 1, 1, 0, 0);
        add(txTXT3, gbc);
        agregarComp(txtTXT3, 2, 4, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTXT3, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT4
        radio4 = new JRadioButton();
        radioGroup.add(radio4);
        JLabel txTXT4 = new JLabel("Adicion: ");
        JComboBox txtTXT4 = new JComboBox();
        txtTXT4.addItem("Ninguno");
        txtTXT4.addItem("Adornos");
        txtTXT4.addItem("Sistema alarma");
        txtTXT4.addItem("Sistema audio");
        agregarComp(radio4, 0, 5, 1, 1, 0, 0);
        add(radio4, gbc);
        agregarComp(txTXT4, 1, 5, 1, 1, 0, 0);
        add(txTXT4, gbc);
        agregarComp(txtTXT4, 2, 5, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTXT4, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT5
        radio5 = new JRadioButton();
        radioGroup.add(radio5);
        JLabel txTXT5 = new JLabel("Tipo pago: ");
        JComboBox txtTXT5 = new JComboBox();
        txtTXT5.addItem("Completo");
        txtTXT5.addItem("Parcial");
        agregarComp(radio5, 0, 6, 1, 1, 0, 0);
        add(radio5, gbc);
        agregarComp(txTXT5, 1, 6, 1, 1, 0, 0);
        add(txTXT5, gbc);
        agregarComp(txtTXT5, 2, 6, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTXT5, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT6
        radio6 = new JRadioButton();
        radioGroup.add(radio6);
        JLabel txTXT6 = new JLabel("Comision: ");
        JTextField txtTXT6 = new JTextField(15);
        txtTXT6.addKeyListener(new KeyListener() {
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
        agregarComp(radio6, 0, 7, 1, 1, 0, 0);
        add(radio6, gbc);
        agregarComp(txTXT6, 1, 7, 1, 1, 0, 0);
        add(txTXT6, gbc);
        agregarComp(txtTXT6, 2, 7, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTXT6, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT7
        radio6 = new JRadioButton();
        radioGroup.add(radio6);
        JLabel txTXT7 = new JLabel("Cliente: ");
        JComboBox txtTXT7 = new JComboBox();
        agregarComp(radio6, 0, 8, 1, 1, 0, 0);
        add(radio6, gbc);
        agregarComp(txTXT7, 1, 8, 1, 1, 0, 0);
        add(txTXT7, gbc);
        agregarComp(txtTXT7, 2, 8, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTXT7, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT8
        radio6 = new JRadioButton();
        radioGroup.add(radio6);
        JLabel txTXT8 = new JLabel("Empleado: ");
        JComboBox txtTXT8 = new JComboBox();
        agregarComp(radio6, 0, 9, 1, 1, 0, 0);
        add(radio6, gbc);
        agregarComp(txTXT8, 1, 9, 1, 1, 0, 0);
        add(txTXT8, gbc);
        agregarComp(txtTXT8, 2, 9, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTXT8, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT9
        radio6 = new JRadioButton();
        radioGroup.add(radio6);
        JLabel txTXT9 = new JLabel("Vehiculo: ");
        JComboBox txtTXT9 = new JComboBox();
        agregarComp(radio6, 0, 10, 1, 1, 0, 0);
        add(radio6, gbc);
        agregarComp(txTXT9, 1, 10, 1, 1, 0, 0);
        add(txTXT9, gbc);
        agregarComp(txtTXT9, 2, 10, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTXT9, gbc);
        gbc.fill = GridBagConstraints.NONE;


        btnConsultar = new JButton("Consultar venta");
        agregarComp(btnConsultar,0,11,1,1,0,0);
        gbc.fill = GridBagConstraints.NONE;
        getContentPane().add(btnConsultar, gbc);

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
        agregarComp(btnLimpiar,1,11,1,1,0,0);
        getContentPane().add(btnLimpiar, gbc);

        tableModel.addColumn("ID");
        tableModel.addColumn("Fecha_venta");
        tableModel.addColumn("Impuesto");
        tableModel.addColumn("Costo_licencia");
        tableModel.addColumn("Adicion");
        tableModel.addColumn("Tipo_pago");
        tableModel.addColumn("Comision");
        tableModel.addColumn("Cliente");
        tableModel.addColumn("Empleado");
        tableModel.addColumn("Automovil");

        tbAuto = new JTable(tableModel);
        JScrollPane jsCl = new JScrollPane(tbAuto);
        agregarComp(jsCl,3,0,GridBagConstraints.REMAINDER,GridBagConstraints.REMAINDER,3,1);
        gbc.fill = GridBagConstraints.BOTH;
        add(jsCl, gbc);

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
}
