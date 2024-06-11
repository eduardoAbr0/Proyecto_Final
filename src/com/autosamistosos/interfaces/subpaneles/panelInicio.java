package com.autosamistosos.interfaces.subpaneles;

import com.autosamistosos.interfaces.personalizacion.interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class panelInicio extends JPanel {
    String imgInicio = "/ComponentesG/inicioG.gif";

    public panelInicio() {
        String imgInicio = "/ComponentesG/inicioF.png";
        setLayout(new BorderLayout());
        setOpaque(false); // Hace que el panel sea transparente para que se pueda ver la imagen de fondo
        //add(new interfaz.PanelImagen(imgInicio));
    }
}
