package com.autosamistosos.interfaces.subpaneles.autosABCC;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class consultasAutos extends JInternalFrame {
    private final JTextField txtModelo;
    private final JTextField txtPrecio;
    private final JTextField txtPaisFab;
    private final JTextField txtEstadoFab;
    private final JTextField txtPeso;
    private final JTextField txtColor;
    private final JTextField txtCapL;
    private final JTextField txtKilometros;
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID;
    JButton btnConsultar, btnLimpiar;
    JRadioButton radioTodos, radioID, radio1, radio2, radio3, radio4, radio5, radio6, radio7, radio8, radio9, radio10, radio11, radio12, radio13, radio14;
    ButtonGroup radioGroup;
    JTable tbAuto;
    DefaultTableModel tableModel = new DefaultTableModel();

    public consultasAutos() {
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
        JLabel txID = new JLabel("ID Auto: ");
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
        // Label e input de Modelo
        JLabel txModelo = new JLabel("Modelo: ");
        agregarComp(radio1, 0, 2, 1, 1, 0, 0);
        add(radio1, gbc);
        agregarComp(txModelo, 1, 2, 1, 1, 1, 1);
        add(txModelo, gbc);
        txtModelo = new JTextField(10);
        agregarComp(txtModelo, 2, 2, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtModelo, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT2
        radio2 = new JRadioButton();
        radioGroup.add(radio2);
        // Label e input de Precio
        JLabel txPrecio = new JLabel("Precio: ");
        agregarComp(radio2, 0, 3, 1, 1, 0, 0);
        add(radio2, gbc);
        agregarComp(txPrecio, 1, 3, 1, 1, 1, 1);
        add(txPrecio, gbc);
        txtPrecio = new JTextField(10);
        txtPrecio.addKeyListener(new KeyListener() {
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
        agregarComp(txtPrecio, 2, 3, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtPrecio, gbc);
        gbc.fill = GridBagConstraints.NONE;


        // TXT3
        radio3 = new JRadioButton();
        radioGroup.add(radio3);
        agregarComp(radio3, 0, 4, 1, 1, 0, 0);
        add(radio3, gbc);
        JLabel txFechaf = new JLabel("Fecha fabriacion: ");
        JDateChooser fechaFab = new JDateChooser();
        fechaFab.setDateFormatString("yyyy/MM/dd");
        agregarComp(txFechaf, 1, 4, 1, 1, 1, 1);
        add(txFechaf, gbc);
        agregarComp(fechaFab, 2, 4, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(fechaFab, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT4
        radio4 = new JRadioButton();
        radioGroup.add(radio4);
        agregarComp(radio4, 0, 5, 1, 1, 0, 0);
        add(radio4, gbc);
        JLabel txPaisF = new JLabel("Pais fabricacion: ");
        agregarComp(txPaisF, 1, 5, 1, 1, 1, 1);
        add(txPaisF, gbc);
        txtPaisFab = new JTextField(10);
        agregarComp(txtPaisFab, 2, 5, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtPaisFab, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT5
        radio5 = new JRadioButton();
        radioGroup.add(radio5);
        agregarComp(radio5, 0, 6, 1, 1, 0, 0);
        add(radio5, gbc);
        JLabel txEstadoF = new JLabel("Estado fabricacion: ");
        agregarComp(txEstadoF, 1, 6, 1, 1, 1, 1);
        add(txEstadoF, gbc);
        txtEstadoFab = new JTextField(10);
        agregarComp(txtEstadoFab, 2, 6, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtEstadoFab, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT6
        radio6 = new JRadioButton();
        radioGroup.add(radio6);
        agregarComp(radio6, 0, 7, 1, 1, 0, 0);
        add(radio6, gbc);
        JLabel txPeso = new JLabel("Peso: ");
        agregarComp(txPeso, 1, 7, 1, 1, 1, 1);
        add(txPeso, gbc);
        txtPeso = new JTextField(10);
        txtPeso.addKeyListener(new KeyListener() {
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
        agregarComp(txtPeso, 2, 7, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtPeso, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT7
        radio7 = new JRadioButton();
        radioGroup.add(radio7);
        agregarComp(radio7, 0, 8, 1, 1, 0, 0);
        add(radio7, gbc);
        JLabel txCilindros = new JLabel("Cilindros: ");
        agregarComp(txCilindros, 1, 8, 1, 1, 1, 1);
        add(txCilindros, gbc);
        JComboBox cmbCilindros = new JComboBox();
        cmbCilindros.addItem("4");
        cmbCilindros.addItem("6");
        cmbCilindros.addItem("12");
        cmbCilindros.addItem("16");
        agregarComp(cmbCilindros, 2, 8, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbCilindros, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT8
        radio8 = new JRadioButton();
        radioGroup.add(radio8);
        agregarComp(radio8, 0, 9, 1, 1, 0, 0);
        add(radio8, gbc);
        JLabel txColor = new JLabel("Color: ");
        agregarComp(txColor, 1, 9, 1, 1, 1, 1);
        add(txColor, gbc);
        txtColor = new JTextField(10);
        agregarComp(txtColor, 2, 9, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtColor, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT9
        radio9 = new JRadioButton();
        radioGroup.add(radio9);
        agregarComp(radio9, 0, 10, 1, 1, 0, 0);
        add(radio9, gbc);
        JLabel txCapL = new JLabel("Capacidad: ");
        agregarComp(txCapL, 1, 10, 1, 1, 1, 1);
        add(txCapL, gbc);
        txtCapL = new JTextField(10);
        txtCapL.addKeyListener(new KeyListener() {
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
        agregarComp(txtCapL, 2, 10, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtCapL, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT10
        radio10 = new JRadioButton();
        radioGroup.add(radio10);
        agregarComp(radio10, 0, 11, 1, 1, 0, 0);
        add(radio10, gbc);
        JLabel txEstado = new JLabel("Estado: ");
        agregarComp(txEstado, 1, 11, 1, 1, 1, 1);
        add(txEstado, gbc);
        JComboBox cmbEstado = new JComboBox();
        cmbEstado.addItem("Nuevo");
        cmbEstado.addItem("Usado");
        agregarComp(cmbEstado, 2, 11, 1, 1, 1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbEstado, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT11
        radio11 = new JRadioButton();
        radioGroup.add(radio11);
        agregarComp(radio11, 0, 12, 1, 1, 0, 0);
        add(radio11, gbc);
        JLabel txSeguro = new JLabel("Seguro: ");
        agregarComp(txSeguro,1,12,1,1,1,1);
        add(txSeguro, gbc);
        JComboBox cmbSeguro = new JComboBox();
        cmbSeguro.addItem("Seguro total");
        cmbSeguro.addItem("Seguro Robo");
        cmbSeguro.addItem("Seguro Accidentes");
        agregarComp(cmbSeguro,2,12,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbSeguro, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT12
        radio12 = new JRadioButton();
        radioGroup.add(radio12);
        agregarComp(radio12, 0, 13, 1, 1, 0, 0);
        add(radio12, gbc);
        JLabel txKilometros = new JLabel("Kilometros: ");
        agregarComp(txKilometros,1,13,1,1,1,1);
        add(txKilometros, gbc);
        txtKilometros = new JTextField(10);
        txtKilometros.addKeyListener(new KeyListener() {
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
        agregarComp(txtKilometros,2,13,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtKilometros, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // TXT13
        radio13 = new JRadioButton();
        radioGroup.add(radio13);
        agregarComp(radio13, 0, 14, 1, 1, 0, 0);
        add(radio13, gbc);
        JLabel txGarantia = new JLabel("Garantia(meses): ");
        agregarComp(txGarantia,1,14,1,1,1, 1);
        add(txGarantia, gbc);
        SpinnerNumberModel spM = new SpinnerNumberModel(1, 1, null, 1);
        JSpinner spGar = new JSpinner(spM);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) spGar.getEditor()).getTextField();
        tf.setEditable(false);
        agregarComp(spGar, 2, 14, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(spGar, gbc);
        gbc.fill = GridBagConstraints.NONE;


        //CONSULTAR
        btnConsultar = new JButton("Consultar automovil");
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        agregarComp(btnConsultar, 0, 15, 1, 1, 0, 0);
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
        agregarComp(btnLimpiar, 1, 15, 1, 1, 0, 0);
        add(btnLimpiar, gbc);

        tableModel.addColumn("ID");
        tableModel.addColumn("Modelo");
        tableModel.addColumn("Precio");
        tableModel.addColumn("Fecha_fab");
        tableModel.addColumn("Pais_fab");
        tableModel.addColumn("Estado_fab");
        tableModel.addColumn("Peso");
        tableModel.addColumn("Cilindros");
        tableModel.addColumn("Color");
        tableModel.addColumn("Capacidad");
        tableModel.addColumn("Estado");
        tableModel.addColumn("Seguro");
        tableModel.addColumn("Kilometros");
        tableModel.addColumn("Garantia");

        tbAuto = new JTable(tableModel);
        JScrollPane jsCl = new JScrollPane(tbAuto);
        agregarComp(jsCl, 3, 0, GridBagConstraints.REMAINDER, GridBagConstraints.REMAINDER, 4, 1);
        gbc.fill = GridBagConstraints.BOTH;
        add(jsCl, gbc);

        rellenarCmb();
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

    public void rellenarCmb(){
        /*
        ArrayList<Cliente> clientes = daoCliente.buscarTodos();

        for(Cliente c : clientes){
            cmbID.addItem(c.getIdCliente());
        }

         */

    }
}
