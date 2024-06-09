package com.autosamistosos.interfaces.subpaneles.autosABCC;

import com.autosamistosos.basedatos.controlador.DAOAutomovilImpl;
import com.autosamistosos.basedatos.modelo.Automovil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class bajasAutos extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JComboBox cmbID;
    JButton btnEliminar;
    DAOAutomovilImpl daoAutomovil = new DAOAutomovilImpl();
    ArrayList<Automovil> autos;
    public bajasAutos(){
        super("Bajas autos", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 250, 150);
        setResizable(false);

        JLabel txID = new JLabel("ID Automovil: ");
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
                    JOptionPane.showMessageDialog(null, "No hay automoviles por eliminar","",JOptionPane.WARNING_MESSAGE);
                }else {
                    daoAutomovil.eliminar((Integer) cmbID.getSelectedItem());
                }
                rellenarCmb();
            }
        });
        agregarComp(btnEliminar,0,1,1,2,1,0);
        add(btnEliminar, gbc);

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
}
