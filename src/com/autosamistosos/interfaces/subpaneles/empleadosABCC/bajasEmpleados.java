package com.autosamistosos.interfaces.subpaneles.empleadosABCC;

import com.autosamistosos.basedatos.controlador.DAOEmpleadoImpl;
import com.autosamistosos.basedatos.hilos;
import com.autosamistosos.basedatos.modelo.Automovil;
import com.autosamistosos.basedatos.modelo.Empleado;
import com.autosamistosos.basedatos.controlador.empleadoDAO;
import com.autosamistosos.interfaces.personalizacion.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class bajasEmpleados extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID;
    JButton btnEliminar;
    JComboBox cmbID;
    DAOEmpleadoImpl daoEmpleado = new DAOEmpleadoImpl();
    hilos h;

    public bajasEmpleados(){
        super("Bajas empleados", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 250, 150);
        setResizable(false);

        JLabel txID = new JLabel("ID Empleado: ");
        agregarComp(txID,0,0,1,1,1,1);
        add(txID, gbc);
        cmbID = new JComboBox();
        agregarComp(cmbID,1,0,1,1,1,1);
        add(cmbID, gbc);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbID.getItemCount() == 0){
                    JOptionPane.showMessageDialog(null, "Agrega empleados.", "Advertencia", JOptionPane.ERROR_MESSAGE);
                }else{
                    h = new hilos("eliminarEmpleado");
                    h.setId((Integer) cmbID.getSelectedItem());
                    h.start();
                }
                rellenarCmb();
            }
        });
        agregarComp(btnEliminar,0,1,1,2,1,0);
        add(btnEliminar, gbc);

        aplicarEstilos(getContentPane());
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
        ArrayList<Empleado> empleados = daoEmpleado.buscarTodos();
        cmbID.removeAllItems();
        cmbID.repaint();

        for(Empleado e : empleados){
            cmbID.addItem(e.getId());
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
