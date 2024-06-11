package com.autosamistosos.interfaces.subpaneles.clientesABCC;

import com.autosamistosos.basedatos.controlador.DAOClienteImpl;
import com.autosamistosos.basedatos.controlador.DAOEmpleadoImpl;
import com.autosamistosos.basedatos.hilos;
import com.autosamistosos.basedatos.modelo.Cliente;
import com.autosamistosos.basedatos.modelo.Empleado;
import com.autosamistosos.interfaces.personalizacion.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class bajasClientes extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID;
    JComboBox cmbID;
    JButton btnEliminar;
    DAOClienteImpl daoCliente = new DAOClienteImpl();
    hilos h;
    public bajasClientes(){
        super("Bajas clientes", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 250, 150);
        setResizable(false);

        JLabel txID = new JLabel("ID Cliente: ");
        agregarComp(txID,0,0,1,1,1,1);
        add(txID, gbc);
        cmbID = new JComboBox();
        agregarComp(cmbID,1,0,1,1,1,1);
        add(cmbID, gbc);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbID.getItemCount()==0){
                    JOptionPane.showMessageDialog(null, "No hay clientes por eliminar","",JOptionPane.WARNING_MESSAGE);
                }else {
                    h = new hilos("eliminarCliente");
                    h.setId((Integer) cmbID.getSelectedItem());
                    h.start();
                }
                rellenarCmb();
            }
        });
        agregarComp(btnEliminar,0,1,1,2,1,0);
        add(btnEliminar, gbc);


        rellenarCmb();
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

    public void rellenarCmb(){
        ArrayList<Cliente> clientes = daoCliente.buscarTodos();
        cmbID.removeAllItems();
        cmbID.repaint();

        for(Cliente c : clientes){
            cmbID.addItem(c.getIdCliente());
        }
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
