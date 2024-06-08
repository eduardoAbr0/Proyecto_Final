package com.autosamistosos.interfaces.subpaneles.clientesABCC;

import com.autosamistosos.basedatos.controlador.DAOEmpleadoImpl;
import com.autosamistosos.basedatos.modelo.Empleado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class consultasClientes extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID;
    JRadioButton radioTodos, radioID, radio1, radio2, radio3, radio4, radio5, radio6, radio7, radio8, radio9, radio10, radio11, radio12, radio13, radio14;
    ButtonGroup radioGroup;
    JButton btnConsultar, btnLimpiar;
    JTable tbEmpleado;
    DefaultTableModel tableModel = new DefaultTableModel();
    DAOEmpleadoImpl daoEmpleado = new DAOEmpleadoImpl();

    public consultasClientes(){
        super("Consultas autos", true, true, true, true);

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
        JLabel txID = new JLabel("ID");
        JTextField txtID = new JTextField();
        agregarComp(radioID, 0, 1, 1, 1, 0, 0);
        add(radioID, gbc);
        agregarComp(txID, 1, 1, 1, 1, 0, 0);
        add(txID, gbc);
        agregarComp(txtID, 2, 1, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtID, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT1
        radio1 = new JRadioButton();
        radioGroup.add(radio1);
        JLabel txTXT1 = new JLabel("TXT1");
        JTextField txtTXT1 = new JTextField(15);
        agregarComp(radio1, 0, 2, 1, 1, 0, 0);
        add(radio1, gbc);
        agregarComp(txTXT1, 1, 2, 1, 1, 0, 0);
        add(txTXT1, gbc);
        agregarComp(txtTXT1, 2, 2, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTXT1, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT2
        radio2 = new JRadioButton();
        radioGroup.add(radio2);
        JLabel txTXT2 = new JLabel("TXT2");
        JTextField txtTXT2 = new JTextField(15);
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
        JLabel txTXT3 = new JLabel("TXT3");
        JTextField txtTXT3 = new JTextField(15);
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
        JLabel txTXT4 = new JLabel("TXT4");
        JTextField txtTXT4 = new JTextField(15);
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
        JLabel txTXT5 = new JLabel("TXT5");
        JTextField txtTXT5 = new JTextField(15);
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
        JLabel txTXT6 = new JLabel("TXT6");
        JTextField txtTXT6 = new JTextField(15);
        agregarComp(radio6, 0, 7, 1, 1, 0, 0);
        add(radio6, gbc);
        agregarComp(txTXT6, 1, 7, 1, 1, 0, 0);
        add(txTXT6, gbc);
        agregarComp(txtTXT6, 2, 7, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTXT6, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT7
        radio7 = new JRadioButton();
        radioGroup.add(radio7);
        JLabel txTXT7 = new JLabel("TXT7");
        JTextField txtTXT7 = new JTextField(15);
        agregarComp(radio7, 0, 8, 1, 1, 0, 0);
        add(radio7, gbc);
        agregarComp(txTXT7, 1, 8, 1, 1, 0, 0);
        add(txTXT7, gbc);
        agregarComp(txtTXT7, 2, 8, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTXT7, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT8
        radio8 = new JRadioButton();
        radioGroup.add(radio8);
        JLabel txTXT8 = new JLabel("TXT8");
        JTextField txtTXT8 = new JTextField(15);
        agregarComp(radio8, 0, 9, 1, 1, 0, 0);
        add(radio8, gbc);
        agregarComp(txTXT8, 1, 9, 1, 1, 0, 0);
        add(txTXT8, gbc);
        agregarComp(txtTXT8, 2, 9, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTXT8, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT9
        radio9 = new JRadioButton();
        radioGroup.add(radio9);
        JLabel txTXT9 = new JLabel("TXT9");
        JTextField txtTXT9 = new JTextField(15);
        agregarComp(radio9, 0, 10, 1, 1, 0, 0);
        add(radio9, gbc);
        agregarComp(txTXT9, 1, 10, 1, 1, 0, 0);
        add(txTXT9, gbc);
        agregarComp(txtTXT9, 2, 10, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTXT9, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT10
        radio10 = new JRadioButton();
        radioGroup.add(radio10);
        JLabel txTXT10 = new JLabel("TXT10");
        JTextField txtTXT10 = new JTextField(15);
        agregarComp(radio10, 0, 11, 1, 1, 0, 0);
        add(radio10, gbc);
        agregarComp(txTXT10, 1, 11, 1, 1, 0, 0);
        add(txTXT10, gbc);
        agregarComp(txtTXT10, 2, 11, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTXT10, gbc);
        gbc.fill = GridBagConstraints.NONE;



        //CONSULTAR
        btnConsultar = new JButton("Consultar cliente");
        agregarComp(btnConsultar, 0, 12, 1, 1, 0, 0);
        add(btnConsultar, gbc);

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
        agregarComp(btnLimpiar, 1, 12, 1, 1, 0, 0);
        add(btnLimpiar, gbc);

        tableModel.addColumn("ID");
        tableModel.addColumn("Correo");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Primer_ap");
        tableModel.addColumn("Segundo_ap");
        tableModel.addColumn("Numero_casa");
        tableModel.addColumn("Calle");
        tableModel.addColumn("Colonia");
        tableModel.addColumn("CP");
        tableModel.addColumn("RFC");
        tableModel.addColumn("Telefono");
        tableModel.addColumn("EmpleadoID");

        tbEmpleado = new JTable(tableModel);
        JScrollPane jsCl = new JScrollPane(tbEmpleado);
        agregarComp(jsCl, 3, 0, GridBagConstraints.REMAINDER, GridBagConstraints.REMAINDER, 4, 1);
        gbc.fill = GridBagConstraints.BOTH;
        add(jsCl, gbc);

        setVisible(true);
    }

    public void agregarComp(JComponent c, int x, int y, int alt, int anch, int pesox, int pesoy) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = anch;
        gbc.gridheight = alt;
        gbc.weightx = pesox;
        gbc.weighty = pesoy;

        gbl.setConstraints(c, gbc);
    }
}
