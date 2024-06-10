package com.autosamistosos.interfaces;

import com.autosamistosos.basedatos.controlador.DBLogin;
import com.autosamistosos.interfaces.subpaneles.panelRegistro;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class login extends JFrame {
    BorderLayout bl = new BorderLayout();
    JPanel log,img = new JPanel();
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    JTextField txFUsuario;
    JPasswordField txFPassword;
    JButton btnLogin, btnRestablecer, btnRegistrarU;
    DBLogin login = new DBLogin();

    BufferedImage fondo;
    public login() {

        //PANEL INTERFAZ
        getContentPane().setLayout(bl);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login");

        setVisible(true);

        //PANEL DER
        log = new JPanel();
        log.setLayout(gbl);
        log.setBackground(Color.CYAN);
        log.setPreferredSize(new Dimension(350, 600));

        //PANEL IZQ
        img = new JPanel();
        img.setBackground(Color.RED);
        img.setPreferredSize(new Dimension(550, 600));

        gbc.insets = new Insets(5,5,5,5);

        //COMPONENTES DERECHA
        JLabel txtLogin = new JLabel("LOGIN");
        txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
        agregarComp(txtLogin,0,0,1,2,1,1,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER);

        JLabel txtUsuario = new JLabel("Usuario: ");
        agregarComp(txtUsuario,0,1,1,1,1,1);

        txFUsuario = new JTextField();
        agregarComp(txFUsuario,1,1,1,1,1,1);

        JLabel txtPassword = new JLabel("Contraseña: ");
        agregarComp(txtPassword,0,2,1,1,1,1);

        txFPassword = new JPasswordField();
        agregarComp(txFPassword,1,2,1,1,1,1);

        btnLogin = new JButton("Login");
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
        btnRestablecer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txFUsuario.setText("");
                txFPassword.setText("");
            }
        });
        agregarComp(btnRestablecer,1,3,1,1,1,1);

        btnRegistrarU = new JButton("Registrar Usuario");
        btnRegistrarU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new panelRegistro();
            }
        });
        agregarComp(btnRegistrarU,0,4,1,2,1,0,2,20);


        add(log, BorderLayout.EAST);
        add(img, BorderLayout.WEST);

        pack();
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

    public panelImagen() {
        try {
            // Cargar la imagen desde un archivo
            imagen = ImageIO.read(new File("ruta/a/la/imagen.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
