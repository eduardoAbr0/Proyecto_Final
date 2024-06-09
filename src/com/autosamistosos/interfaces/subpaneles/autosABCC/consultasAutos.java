package com.autosamistosos.interfaces.subpaneles.autosABCC;

import com.autosamistosos.basedatos.controlador.DAOAutomovilImpl;
import com.autosamistosos.basedatos.modelo.Automovil;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class consultasAutos extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID;
    JButton btnConsultar, btnLimpiar;
    JRadioButton radioTodos, radioID; //radio1, radio2, radio3, radio4, radio5, radio6, radio7, radio8, radio9, radio10, radio11, radio12, radio13, radio14;
    ButtonGroup radioGroup;
    JTable tbAuto;
    JComboBox cmbID;
    DefaultTableModel tableModel = new DefaultTableModel();
    DAOAutomovilImpl daoAutomovil = new DAOAutomovilImpl();
    ArrayList<Automovil> automoviles;
    Automovil automovil;

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
        cmbID = new JComboBox();
        agregarComp(radioID, 0, 1, 1, 1, 0, 0);
        add(radioID, gbc);
        agregarComp(txID, 1, 1, 1, 1, 0, 0);
        add(txID, gbc);
        agregarComp(cmbID, 2, 1, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbID, gbc);
        gbc.fill = GridBagConstraints.NONE;


        //CONSULTAR
        btnConsultar = new JButton("Consultar automovil");
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioTodos.isSelected()) {
                    tableModel.setRowCount(0);
                    automoviles = daoAutomovil.buscarTodos();

                    for (Automovil a : automoviles) {
                        tableModel.addRow(new Object[]{a.getIdAutomovil(),a.getModeloA(),a.getPrecioAutomovil(),a.getFechaFab(),a.getPaisFab(),a.getEstadoFab(),a.getPesoAutomovil(),a.getCilindroAutomovil(),a.getColor(),a.getCapacidad(),a.getEstado(),a.getSeguro(),a.getKmAutomovil(),a.getGarantiaAutomovil()});
                    }
                } else if (radioID.isSelected()) {
                    if (cmbID.getItemCount()>0){
                        automovil = daoAutomovil.buscar((Integer) cmbID.getSelectedItem());

                        tableModel.addRow(new Object[]{automovil.getIdAutomovil(),automovil.getModeloA(),automovil.getPrecioAutomovil(),automovil.getFechaFab(),automovil.getPaisFab(),automovil.getEstadoFab(),automovil.getPesoAutomovil(),automovil.getCilindroAutomovil(),automovil.getColor(),automovil.getCapacidad(),automovil.getEstado(),automovil.getSeguro(),automovil.getKmAutomovil(),automovil.getGarantiaAutomovil()});
                    }else{
                        JOptionPane.showMessageDialog(null, "No hay automoviles", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione opcion de busqueda.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        agregarComp(btnConsultar, 1, 2, 1, 1, 0, 0);
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

                tableModel.setRowCount(0);
            }
        });
        agregarComp(btnLimpiar, 2, 2, 1, 1, 0, 0);
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
        automoviles = daoAutomovil.buscarTodos();
        cmbID.removeAllItems();
        cmbID.repaint();

        for(Automovil a : automoviles){
            cmbID.addItem(a.getIdAutomovil());
        }
    }
}
