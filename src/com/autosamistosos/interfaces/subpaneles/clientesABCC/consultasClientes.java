package com.autosamistosos.interfaces.subpaneles.clientesABCC;

import com.autosamistosos.basedatos.controlador.DAOClienteImpl;
import com.autosamistosos.basedatos.modelo.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class consultasClientes extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtTXT1, txtTXT2, txtTXT3, txtTXT4, txtTXT5, txtTXT6, txtTXT7, txtTXT8, txtTXT9, txtTXT10;
    JRadioButton radioTodos, radioID, radio1, radio2, radio3, radio4, radio5, radio6, radio7, radio8, radio9, radio10, radio11, radio12, radio13, radio14;
    ButtonGroup radioGroup;
    JButton btnConsultar, btnLimpiar;
    JTable tbEmpleado;
    JComboBox cmbID;
    ArrayList<Cliente> clientes;
    Cliente cliente;
    DefaultTableModel tableModel = new DefaultTableModel();
    DAOClienteImpl daoCliente = new DAOClienteImpl();

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
        JLabel txID = new JLabel("ID: ");
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
        btnConsultar = new JButton("Consultar cliente");
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                if (radioTodos.isSelected()) {
                    clientes = daoCliente.buscarTodos();

                    for (Cliente c : clientes) {
                        tableModel.addRow(new Object[]{c.getIdCliente(), c.getCorreo(), c.getNombre(), c.getpApellido(), c.getsApellido(), c.getNumeroCasa(), c.getCalle(), c.getColonia(), c.getCp(), c.getRFC(), c.getTelefono(), c.getIdEmpleado()});
                    }
                } else if (radioID.isSelected()) {
                    if (cmbID.getItemCount()>0){
                        cliente = daoCliente.buscar((Integer) cmbID.getSelectedItem());

                        tableModel.addRow(new Object[]{cliente.getIdCliente(), cliente.getCorreo(), cliente.getNombre(), cliente.getpApellido(), cliente.getsApellido(), cliente.getNumeroCasa(), cliente.getCalle(), cliente.getColonia(), cliente.getCp(), cliente.getRFC(), cliente.getTelefono(), cliente.getIdEmpleado()});
                    }else{
                        JOptionPane.showMessageDialog(null, "No hay clientes para consultar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione opcion de busqueda.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        agregarComp(btnConsultar, 0, 2, 1, 1, 0, 0);
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
        agregarComp(btnLimpiar, 1, 2, 1, 1, 0, 0);
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

    public void rellenarCmb() {
        clientes = daoCliente.buscarTodos();

        for(Cliente c : clientes){
            cmbID.addItem(c.getIdCliente());
        }
    }
}
