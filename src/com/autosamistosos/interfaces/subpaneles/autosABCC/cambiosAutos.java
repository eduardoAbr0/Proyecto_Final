package com.autosamistosos.interfaces.subpaneles.autosABCC;

import com.autosamistosos.basedatos.controlador.DAOAutomovilImpl;
import com.autosamistosos.basedatos.modelo.Automovil;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class cambiosAutos extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID, txtModelo, txtPrecio, txtFechaf, txtPeso, txtCilindros, txtColor, txtCapL, txtEstado, txtSeguro, txtKilometros, txtGarantia, txtEstadoFab, txtPaisFab;
    JButton btnCambiar, btnLimpiar;
    JDateChooser fechaFab;
    JComboBox cmbID;
    ArrayList<Automovil> autos;
    Automovil auto;
    DAOAutomovilImpl daoAutomovil = new DAOAutomovilImpl();

    public cambiosAutos(){
        super("Cambios autos", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 500);
        setResizable(false);

        //Label e input para ID
        JLabel txID = new JLabel("ID Auto: ");
        agregarComp(txID, 0, 0, 1, 1, 1, 1);
        add(txID, gbc);
        cmbID = new JComboBox();
        cmbID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rellenarTxt();
            }
        });
        agregarComp(cmbID, 1, 0, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbID, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // Label e input de Modelo
        JLabel txModelo = new JLabel("Modelo: ");
        agregarComp(txModelo, 0, 1, 1, 1, 1, 1);
        add(txModelo, gbc);
        txtModelo = new JTextField(10);
        agregarComp(txtModelo, 1, 1, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtModelo, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // Label e input de Precio
        JLabel txPrecio = new JLabel("Precio: ");
        agregarComp(txPrecio, 0, 2, 1, 1, 1, 1);
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
        agregarComp(txtPrecio, 1, 2, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtPrecio, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // Label e input de Fecha de fabricación
        JLabel txFechaf = new JLabel("Fecha fabriacion: ");
        fechaFab = new JDateChooser();
        fechaFab.setDateFormatString("yyyy/MM/dd");
        agregarComp(txFechaf, 0, 3, 1, 1, 1, 1);
        add(txFechaf, gbc);
        agregarComp(fechaFab, 1, 3, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(fechaFab, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // Label e input de País de fabricación
        JLabel txPaisF = new JLabel("Pais fabricacion: ");
        agregarComp(txPaisF, 0, 4, 1, 1, 1, 1);
        add(txPaisF, gbc);
        txtPaisFab = new JTextField(10);
        agregarComp(txtPaisFab, 1, 4, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtPaisFab, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // Label e input de Estado de fabricación
        JLabel txEstadoF = new JLabel("Estado fabricacion: ");
        agregarComp(txEstadoF, 0, 5, 1, 1, 1, 1);
        add(txEstadoF, gbc);
        txtEstadoFab = new JTextField(10);
        agregarComp(txtEstadoFab, 1, 5, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtEstadoFab, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // Label e input de Peso
        JLabel txPeso = new JLabel("Peso: ");
        agregarComp(txPeso, 0, 6, 1, 1, 1, 1);
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
        agregarComp(txtPeso, 1, 6, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtPeso, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // Label e input de Cilindros
        JLabel txCilindros = new JLabel("Cilindros: ");
        agregarComp(txCilindros, 0, 7, 1, 1, 1, 1);
        add(txCilindros, gbc);
        JComboBox cmbCilindros = new JComboBox();
        cmbCilindros.addItem("4");
        cmbCilindros.addItem("6");
        cmbCilindros.addItem("12");
        cmbCilindros.addItem("16");
        agregarComp(cmbCilindros, 1, 7, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbCilindros, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // Label e input de Color
        JLabel txColor = new JLabel("Color: ");
        agregarComp(txColor, 0, 8, 1, 1, 1, 1);
        add(txColor, gbc);
        txtColor = new JTextField(10);
        agregarComp(txtColor, 1, 8, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtColor, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // Label e input de Capacidad
        JLabel txCapL = new JLabel("Capacidad: ");
        agregarComp(txCapL, 0, 9, 1, 1, 1, 1);
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
        agregarComp(txtCapL, 1, 9, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtCapL, gbc);
        gbc.fill = GridBagConstraints.NONE;

        // Label e input de Estado
        JLabel txEstado = new JLabel("Estado: ");
        agregarComp(txEstado, 0, 10, 1, 1, 1, 1);
        add(txEstado, gbc);
        JComboBox cmbEstado = new JComboBox();
        cmbEstado.addItem("Nuevo");
        cmbEstado.addItem("Usado");
        agregarComp(cmbEstado, 1, 10, 1, 1, 1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbEstado, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txSeguro = new JLabel("Seguro: ");
        agregarComp(txSeguro,0,11,1,1,1,1);
        add(txSeguro, gbc);
        JComboBox cmbSeguro = new JComboBox();
        cmbSeguro.addItem("Seguro total");
        cmbSeguro.addItem("Seguro Robo");
        cmbSeguro.addItem("Seguro Accidentes");
        agregarComp(cmbSeguro,1,11,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbSeguro, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txKilometros = new JLabel("Kilometros: ");
        agregarComp(txKilometros,0,12,1,1,1,1);
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
        agregarComp(txtKilometros,1,12,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtKilometros, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txGarantia = new JLabel("Garantia(meses): ");
        agregarComp(txGarantia,0,13,1,1,1, 1);
        add(txGarantia, gbc);
        SpinnerNumberModel spM = new SpinnerNumberModel(1, 1, null, 1);
        JSpinner spGar = new JSpinner(spM);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) spGar.getEditor()).getTextField();
        tf.setEditable(false);
        agregarComp(spGar, 1, 13, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(spGar, gbc);
        gbc.fill = GridBagConstraints.NONE;

        btnCambiar = new JButton("Cambiar");
        btnCambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtModelo.getText().isEmpty() || txtPrecio.getText().isEmpty() || fechaFab.getDate()==null||
                        txtPaisFab.getText().isEmpty() || txtEstadoFab.getText().isEmpty() || txtPeso.getText().isEmpty() || txtColor.getText().isEmpty()
                        || txtCapL.getText().isEmpty() || txtKilometros.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Componente(s) vacio.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }else if(cmbID.getItemCount()>0){
                    Date fechaSeleccionada = fechaFab.getDate();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
                    String fechaSeleccionadaS = formatoFecha.format(fechaSeleccionada);

                    auto = new Automovil(
                            (Integer) cmbID.getSelectedItem(),
                            txtModelo.getText(),
                            Double.parseDouble(txtPrecio.getText()),
                            fechaSeleccionadaS,
                            txtPaisFab.getText(),
                            txtEstadoFab.getText(),
                            Integer.parseInt(txtPeso.getText()),
                            Integer.parseInt(cmbCilindros.getSelectedItem().toString()),
                            txtColor.getText(),
                            Integer.parseInt(txtCapL.getText()),
                            cmbEstado.getSelectedItem().toString()
                    );

                    auto.setSeguro(cmbSeguro.getSelectedItem().toString());
                    auto.setKmAutomovil(Double.parseDouble(txtKilometros.getText()));
                    auto.setGarantiaAutomovil(spGar.getValue().toString());

                    daoAutomovil.actualizar(auto);
                }else{
                    JOptionPane.showMessageDialog(null, "No hay registros para cambiar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

                //ACTUALIZACION DE LOS IDS DISPONIBLES
                rellenarCmb();
            }
        });
        agregarComp(btnCambiar,0,14,1,1,1,1);
        add(btnCambiar, gbc);

        //Se limpian todos los textfields del internalframe
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
        agregarComp(btnLimpiar,1,14,1,1,1,1);
        add(btnLimpiar, gbc);

        rellenarCmb();
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

    public void rellenarCmb(){
        autos = daoAutomovil.buscarTodos();
        cmbID.removeAllItems();
        cmbID.repaint();

        for(Automovil a : autos){
            cmbID.addItem(a.getIdAutomovil());
        }
    }

    public void rellenarTxt(){
        if (cmbID.getItemCount()>0){
            auto = daoAutomovil.buscar((Integer) cmbID.getSelectedItem());
            txtModelo.setText(auto.getModeloA());
            txtPrecio.setText(String.valueOf(auto.getPrecioAutomovil()));
            txtPaisFab.setText(auto.getPaisFab());
            txtEstadoFab.setText(auto.getEstadoFab());
            txtPeso.setText(String.valueOf(auto.getPesoAutomovil()));
            txtColor.setText(auto.getColor());
            txtCapL.setText(String.valueOf(auto.getCapacidad()));
            txtKilometros.setText(String.valueOf(auto.getKmAutomovil()));
        }
    }
}
