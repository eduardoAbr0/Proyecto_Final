package com.autosamistosos.interfaces.subpaneles;

import com.autosamistosos.basedatos.controlador.DBLogin;
import com.autosamistosos.interfaces.personalizacion.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelRegistro extends JFrame {
    BorderLayout bl = new BorderLayout();
    JPanel log,img = new JPanel();
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    JTextField txFUsuario;
    JPasswordField txFPassword;
    JButton btnRegistrar, btnRestablecer;
    DBLogin db = new DBLogin();

    String imgDer = "/ComponentesG/car5.jpg";
    String iconU = "/ComponentesG/iconUs2.png";
    String iconP = "/ComponentesG/iconP.png";
    public panelRegistro() {

        //PANEL INTERFAZ
        getContentPane().setLayout(bl);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ComponentesG/carL1.png")));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Registro");

        //PANEL IZQ
        log = new JPanel();
        log.setLayout(gbl);
        log.setBackground(Color.LIGHT_GRAY);
        log.setPreferredSize(new Dimension(350, 600));

        //PANEL DER
        img = new interfaz.PanelImagen(imgDer);
        img.setPreferredSize(new Dimension(550, 600));

        gbc.insets = new Insets(5,5,5,5);
        //COMPONENTES IZQUIERDA
        JLabel txtLogin = new JLabel("Registro");
        interfaz.personalizarLabelEsp(txtLogin,Color.BLACK,30);
        txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
        agregarComp(txtLogin,0,0,1,2,1,1,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER);


        //USUARIO Y CONTRASENA
        JLabel txtUsuario = new JLabel("Usuario: ",interfaz.iconoC(iconU,25,25), JLabel.LEFT);
        interfaz.personalizarLabelNormal(txtUsuario,Color.black,22);
        agregarComp(txtUsuario,0,1,1,1,1,1);
        txFUsuario = new JTextField();
        interfaz.personalizarTextField(txFUsuario, Color.BLACK,22,Color.BLACK);
        agregarComp(txFUsuario,1,1,1,1,1,1);

        JLabel txtPassword = new JLabel("Contraseña: ",interfaz.iconoC(iconP,25,25), JLabel.LEFT);
        interfaz.personalizarLabelNormal(txtPassword,Color.BLACK,22);
        agregarComp(txtPassword,0,2,1,1,1,1);
        txFPassword = new JPasswordField();
        interfaz.personalizarTextField(txFPassword, Color.BLACK, 22,Color.BLACK);
        agregarComp(txFPassword,1,2,1,1,1,1);

        btnRegistrar = new JButton("Registrar");
        interfaz.estiloBoton(btnRegistrar);
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txFUsuario.getText().isEmpty() || txFPassword.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Llena los campos.");
                }else{
                    db.registroUsuario(txFUsuario.getText(),txFPassword.getText());
                }
            }
        });
        agregarComp(btnRegistrar,0,3,1,1,1,1);

        btnRestablecer = new JButton("Restablecer");
        interfaz.estiloBoton(btnRestablecer);
        btnRestablecer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txFUsuario.setText("");
                txFPassword.setText("");
            }
        });
        agregarComp(btnRestablecer,1,3,1,1,1,1);


        add(img, BorderLayout.EAST);
        add(log, BorderLayout.WEST);

        pack();
        setLocationRelativeTo(null);
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
        log.add(c);
    }
    public void agregarComp(JComponent c, int x, int y, int alt, int anch, int pesox, int pesoy, int fill, int orientacion){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = anch;
        gbc.gridheight = alt;
        gbc.weightx = pesox;
        gbc.weighty = pesoy;
        gbc.fill = fill;
        gbc.anchor = orientacion;

        gbl.setConstraints(c,gbc);
        log.add(c);
    }

}
