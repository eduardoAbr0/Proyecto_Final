package com.autosamistosos.interfaces.subpaneles.empleadosABCC;

import com.autosamistosos.basedatos.controlador.DAOEmpleadoImpl;
import com.autosamistosos.basedatos.modelo.Automovil;
import com.autosamistosos.basedatos.modelo.Empleado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class consultasEmpleados extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID;
    JRadioButton radioTodos, radioID, radio1, radio2, radio3, radio4, radio5, radio6, radio7, radio8, radio9, radio10, radio11, radio12, radio13, radio14;
    ButtonGroup radioGroup;
    JButton btnConsultar, btnLimpiar;
    JTable tbEmpleado;
    JComboBox cbTipoE;
    DefaultTableModel tableModel = new DefaultTableModel();
    DAOEmpleadoImpl daoEmpleado = new DAOEmpleadoImpl();
    ArrayList<Empleado> empleados;
    Empleado empleado;
    JComboBox cmbID;

    public consultasEmpleados(){
        super("Consultas empleados", true, true, true, true);

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
        cmbID = new JComboBox();
        agregarComp(radioID, 0, 1, 1, 1, 0, 0);
        add(radioID, gbc);
        agregarComp(txID, 1, 1, 1, 1, 0, 0);
        add(txID, gbc);
        agregarComp(cmbID, 2, 1, 1, 1, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbID, gbc);
        gbc.fill = GridBagConstraints.NONE;

        btnConsultar = new JButton("Consultar empleado");
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);

                if (radioTodos.isSelected()) {
                    tableModel.setRowCount(0);
                    empleados = daoEmpleado.buscarTodos();

                    for (Empleado em : empleados) {
                        tableModel.addRow(new Object[]{em.getId(),em.getNombre(),em.getPapellido(),em.getSapellido(),em.getNumeroCasa(),em.getCalle(),em.getColonia(),em.getCp(),em.getTelefono(),em.getTipoEmpleado()});
                    }
                } else if (radioID.isSelected()) {
                    if (cmbID.getItemCount()>0){
                        empleado = daoEmpleado.buscar((Integer) cmbID.getSelectedItem());

                        tableModel.addRow(new Object[]{empleado.getId(),empleado.getNombre(),empleado.getPapellido(),empleado.getSapellido(),empleado.getNumeroCasa(),empleado.getCalle(),empleado.getColonia(),empleado.getCp(),empleado.getTelefono(),empleado.getTipoEmpleado()});
                    }else{
                        JOptionPane.showMessageDialog(null, "No hay automoviles", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione opcion de busqueda.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        agregarComp(btnConsultar,1,2,1,1,0,0);
        getContentPane().add(btnConsultar, gbc);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);

                for(Component component: getContentPane().getComponents()){
                    if (component instanceof JTextField) {
                        JTextField textField = (JTextField) component;
                        textField.setText("");
                    }
                }
            }
        });
        agregarComp(btnLimpiar,2,2,1,1,0,0);
        getContentPane().add(btnLimpiar, gbc);

        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Primer apellido");
        tableModel.addColumn("Segundo apellido");
        tableModel.addColumn("Numero casa");
        tableModel.addColumn("Calle");
        tableModel.addColumn("Colonia");
        tableModel.addColumn("CP");
        tableModel.addColumn("Telefono");
        tableModel.addColumn("Tipo empleado");

        tbEmpleado = new JTable(tableModel);
        JScrollPane jsCl = new JScrollPane(tbEmpleado);
        agregarComp(jsCl,3,0,GridBagConstraints.REMAINDER,GridBagConstraints.REMAINDER,5,1);
        gbc.fill = GridBagConstraints.BOTH;
        add(jsCl, gbc);

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
        ArrayList<Empleado> autos = daoEmpleado.buscarTodos();

        for(Empleado e : autos){
            cmbID.addItem(e.getId());
        }
    }
}
