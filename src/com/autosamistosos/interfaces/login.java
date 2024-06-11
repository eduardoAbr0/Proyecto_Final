package com.autosamistosos.interfaces;

import com.autosamistosos.basedatos.controlador.DBLogin;
import com.autosamistosos.interfaces.personalizacion.interfaz;
import com.autosamistosos.interfaces.subpaneles.panelRegistro;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class login extends JFrame {
    BorderLayout bl = new BorderLayout();
    JPanel log,img;
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    JLabel txtLogin , txtUsuario, txtPassword;
    JTextField txFUsuario;
    JPasswordField txFPassword;
    JButton btnLogin, btnRestablecer, btnRegistrarU;
    DBLogin login = new DBLogin();

    String imgIzq = "/ComponentesG/car33.jpg";
    String iconU = "/ComponentesG/iconUs2.png";
    String iconP = "/ComponentesG/iconP.png";
    String imgDer = "/ComponentesG/loginD5.jpg";
    public login() {

        //PANEL INTERFAZ
        getContentPane().setLayout(bl);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ComponentesG/carL1.png")));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("LOGIN");

        //PANEL DER
        log = new JPanel();
        log.setLayout(gbl);
        log.setBackground(Color.DARK_GRAY);
        log.setPreferredSize(new Dimension(350, 600));

        //PANEL IZQ
        img = new interfaz.PanelImagen(imgIzq);
        img.setPreferredSize(new Dimension(550, 600));
        gbc.insets = new Insets(5,5,5,5);

        //COMPONENTES DERECHA
        txtLogin = new JLabel("AutosAmistosos");
        interfaz.personalizarLabelEsp(txtLogin,Color.white,30);
        txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
        agregarComp(txtLogin,0,0,1,2,1,1,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER);

        //USUARIO Y CONTRASENA
        txtUsuario = new JLabel("Usuario: ",interfaz.iconoC(iconU,25,25), JLabel.LEFT);
        interfaz.personalizarLabelNormal(txtUsuario,Color.white,22);
        agregarComp(txtUsuario,0,1,1,1,1,1);
        txFUsuario = new JTextField();
        interfaz.personalizarTextField(txFUsuario, Color.white,22,Color.white);
        agregarComp(txFUsuario,1,1,1,1,1,1);

        txtPassword = new JLabel("Contraseña: ",interfaz.iconoC(iconP,25,25), JLabel.LEFT);
        interfaz.personalizarLabelNormal(txtPassword,Color.white,22);
        agregarComp(txtPassword,0,2,1,1,1,1);
        txFPassword = new JPasswordField();
        interfaz.personalizarTextField(txFPassword, Color.white,22,Color.white);
        agregarComp(txFPassword,1,2,1,1,1,1);

        //BOTONES LOGIN RESTABLECER REGISTRO
        btnLogin = new JButton("Login");
        interfaz.estiloBoton(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txFUsuario.getText().isEmpty() || txFPassword.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Llena los campos");
                }else{
                    if(login.encontrarUsuario(String.valueOf(txFUsuario.getText()),String.valueOf(txFPassword.getText()))){
                        new general();
                        dispose();
                    }
                }
            }
        });
        agregarComp(btnLogin,0,3,1,1,1,1);

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

        btnRegistrarU = new JButton("Registrar Usuario");
        interfaz.estiloBoton(btnRegistrarU);
        btnRegistrarU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new panelRegistro();
            }
        });
        agregarComp(btnRegistrarU,0,4,1,2,1,0,2,20);

        add(log, BorderLayout.EAST);
        add(img, BorderLayout.WEST);

        interfaz.generalesInt();
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
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


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new login();
            }
        });
    }
}
