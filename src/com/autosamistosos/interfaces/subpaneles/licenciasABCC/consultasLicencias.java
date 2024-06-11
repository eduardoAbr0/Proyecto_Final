package com.autosamistosos.interfaces.subpaneles.licenciasABCC;

import com.autosamistosos.interfaces.personalizacion.interfaz;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class consultasLicencias extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID;
    JButton btnConsultar, btnLimpiar;
    JRadioButton radioTodos, radioID, radio1, radio2, radio3, radio4, radio5, radio6, radio7, radio8, radio9, radio10, radio11, radio12, radio13, radio14;
    ButtonGroup radioGroup;
    JTable tbAuto;
    DefaultTableModel tableModel = new DefaultTableModel();
    public consultasLicencias(){
        super("Consultas licencias", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 200);
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
        JLabel txTXT1 = new JLabel("Fecha emision: ");
        JDateChooser date1 = new JDateChooser();
        date1.setDateFormatString("yyyy/MM/dd");
        agregarComp(radio1, 0, 2, 1, 1, 0, 0);
        add(radio1, gbc);
        agregarComp(date1, 1, 2, 1, 1, 0, 0);
        add(txTXT1, gbc);
        agregarComp(date1, 2, 2, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(date1, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT2
        radio2 = new JRadioButton();
        radioGroup.add(radio2);
        JLabel txTXT2 = new JLabel("Fecha expiracion: ");
        JDateChooser date2 = new JDateChooser();
        date2.setDateFormatString("yyyy/MM/dd");
        agregarComp(radio2, 0, 3, 1, 1, 0, 0);
        add(radio2, gbc);
        agregarComp(txTXT2, 1, 3, 1, 1, 0, 0);
        add(txTXT2, gbc);
        agregarComp(date2, 2, 3, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(date2, gbc);
        gbc.fill = GridBagConstraints.NONE;


        // TXT3
        radio3 = new JRadioButton();
        radioGroup.add(radio3);
        JLabel txTXT3 = new JLabel("Cliente: ");
        JComboBox txtTXT3 = new JComboBox();
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
        JLabel txTXT4 = new JLabel("Vehiculo: ");
        JComboBox txtTXT4 = new JComboBox();
        agregarComp(radio4, 0, 5, 1, 1, 0, 0);
        add(radio4, gbc);
        agregarComp(txTXT4, 1, 5, 1, 1, 0, 0);
        add(txTXT4, gbc);
        agregarComp(txtTXT4, 2, 5, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTXT4, gbc);
        gbc.fill = GridBagConstraints.NONE;


        btnConsultar = new JButton("Consultar licencia");
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
        tableModel.addColumn("Fecha_emision");
        tableModel.addColumn("Fecha_expiracion");
        tableModel.addColumn("Cliente");
        tableModel.addColumn("Coche");

        tbAuto = new JTable(tableModel);
        interfaz.personalizarTabla(tbAuto);
        JScrollPane jsCl = new JScrollPane(tbAuto);
        agregarComp(jsCl,3,0,GridBagConstraints.REMAINDER,GridBagConstraints.REMAINDER,3,1);
        gbc.fill = GridBagConstraints.BOTH;
        add(jsCl, gbc);

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
