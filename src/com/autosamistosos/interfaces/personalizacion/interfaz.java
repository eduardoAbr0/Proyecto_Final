package com.autosamistosos.interfaces.personalizacion;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class interfaz {
    static String fuenteEl = "C:/Users/ed308/Documents/PROYECTOF/AutosAmistosos/src/ComponentesG/CorporateARegular/CorporateARegular.otf";
    static String fuenteNrm = "C:/Users/ed308/Documents/PROYECTOF/AutosAmistosos/src/ComponentesG/source-sans-pro/SourceSansPro-Regular.otf";
    static Font fuenteDerivada;
    static Font fuenteExterna;

    public static void generalesInt(){
        try {
            fuenteExterna = Font.createFont(Font.TRUETYPE_FONT, new File(fuenteNrm)).deriveFont(Font.PLAIN, 16);
            //Cambiar font de bottones, textfield, passwordfeld y labels en todo el programa
            UIManager.put("Button.font", fuenteExterna);
            UIManager.put("TextField.font", fuenteExterna);
            UIManager.put("PasswordField.font", fuenteExterna);
            UIManager.put("Label.font", fuenteExterna);

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    public static void estiloBoton(JButton boton) {
        Color colorFondoNormal = new Color(230, 230, 230); // Gris claro
        Color colorFondoHover = new Color(210, 210, 210); // Gris medio para hover
        Color colorFondoClick = new Color(190, 190, 190); // Gris más oscuro para click
        Color colorTexto = Color.DARK_GRAY; // Gris oscuro para el texto

        boton.setBackground(colorFondoNormal);
        boton.setForeground(colorTexto);

        try {
            // Cargar la fuente desde el archivo OTF
            fuenteExterna = Font.createFont(Font.TRUETYPE_FONT, new File(fuenteNrm));
            fuenteDerivada = fuenteExterna.deriveFont(Font.PLAIN, 24);

            // Aplicar al label
            boton.setFont(fuenteDerivada);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la fuente: " + e.getMessage());
        }

        Border border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);
        boton.setBorder(border);
        boton.setFocusPainted(false);
        boton.setContentAreaFilled(false);
        boton.setOpaque(true);

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(colorFondoHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(colorFondoNormal);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                boton.setBackground(colorFondoClick);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (boton.getMousePosition() != null) {
                    boton.setBackground(colorFondoHover);
                } else {
                    boton.setBackground(colorFondoNormal);
                }
            }
        });
    }

    public static void estiloBoton(JButton boton, int size) {
        Color colorFondoNormal = new Color(230, 230, 230); // Gris claro
        Color colorFondoHover = new Color(210, 210, 210); // Gris medio para hover
        Color colorFondoClick = new Color(190, 190, 190); // Gris más oscuro para click
        Color colorTexto = Color.DARK_GRAY; // Gris oscuro para el texto

        boton.setBackground(colorFondoNormal);
        boton.setForeground(colorTexto);

        try {
            // Cargar la fuente desde el archivo OTF
            fuenteExterna = Font.createFont(Font.TRUETYPE_FONT, new File(fuenteNrm));
            fuenteDerivada = fuenteExterna.deriveFont(Font.PLAIN, size);

            // Aplicar al label
            boton.setFont(fuenteDerivada);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la fuente: " + e.getMessage());
        }

        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        boton.setFocusPainted(false);
        boton.setContentAreaFilled(false);
        boton.setOpaque(true);

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(colorFondoHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(colorFondoNormal);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                boton.setBackground(colorFondoClick);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (boton.getMousePosition() != null) {
                    boton.setBackground(colorFondoHover);
                } else {
                    boton.setBackground(colorFondoNormal);
                }
            }
        });
    }

    public static void estiloBoton(JButton boton, Color colorL,Color colorF, Icon icon) {
        //Color colorFondoNormal = new Color(230, 230, 230); // Gris claro
        Color colorFondoHover = new Color(210, 210, 210); // Gris medio para hover
        Color colorFondoClick = new Color(190, 190, 190); // Gris más oscuro para click
        Color colorTexto = Color.DARK_GRAY; // Gris oscuro para el texto

        boton.setBackground(colorF);
        boton.setForeground(colorL);
        boton.setIcon(icon);

        try {
            // Cargar la fuente desde el archivo OTF
            fuenteExterna = Font.createFont(Font.TRUETYPE_FONT, new File(fuenteNrm));
            fuenteDerivada = fuenteExterna.deriveFont(Font.PLAIN, 24);

            // Aplicar al label
            boton.setFont(fuenteDerivada);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la fuente: " + e.getMessage());
        }

        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        boton.setFocusPainted(false);
        boton.setContentAreaFilled(false);
        boton.setOpaque(true);

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(colorFondoHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(colorF);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                boton.setBackground(colorFondoClick);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (boton.getMousePosition() != null) {
                    boton.setBackground(colorFondoHover);
                } else {
                    boton.setBackground(colorF);
                }
            }
        });
    }

    public static void personalizarTextField(JTextField textField, Color color, int size , Color borde) {
        //Cambio de color letras y opacidad
        textField.setForeground(Color.WHITE);
        textField.setOpaque(false);

        //Font
        try {
            // Cargar la fuente desde el archivo OTF
            fuenteExterna = Font.createFont(Font.TRUETYPE_FONT, new File(fuenteNrm));
            fuenteDerivada = fuenteExterna.deriveFont(Font.PLAIN, size);

            // Aplicar al label
            textField.setFont(fuenteDerivada);
            textField.setForeground(color);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la fuente: " + e.getMessage());
        }

        //Borde en parte inferior
        Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, borde);
        textField.setBorder(border);
    }

    public static Icon iconoC(String url, int ancho, int alto) {
        Icon icono = new ImageIcon(interfaz.class.getResource(url));
        // Obtener la imagen del icono
        Image imagen = ((ImageIcon) icono).getImage();
        // Redimensionar la imagen al tamaño deseado
        Image imagenRedimensionada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        // Crear un nuevo ImageIcon con la imagen redimensionada
        return new ImageIcon(imagenRedimensionada);
    }

    public static void personalizarLabelNormal(JLabel label, Color color, int size){
        try {
            // Cargar la fuente desde el archivo OTF
            fuenteExterna = Font.createFont(Font.TRUETYPE_FONT, new File(fuenteNrm));
            fuenteDerivada = fuenteExterna.deriveFont(Font.PLAIN, size);

            // Aplicar al label
            label.setFont(fuenteDerivada);
            label.setForeground(color);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la fuente: " + e.getMessage());
        }
    }

    public static void personalizarLabelEsp(JLabel label, Color color, int size){
        try {
            // Cargar la fuente desde el archivo OTF
            fuenteExterna = Font.createFont(Font.TRUETYPE_FONT, new File(fuenteEl));
            fuenteDerivada = fuenteExterna.deriveFont(Font.BOLD, size);

            // Aplicar al label
            label.setFont(fuenteDerivada);
            label.setForeground(color);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la fuente: " + e.getMessage());
        }
    }

    public static void personalizarTabla(JTable table){
        // Personalizar la apariencia de la tabla
        table.setBackground(Color.lightGray);
        table.setForeground(Color.blue);
        table.setSelectionBackground(Color.yellow);
        table.setSelectionForeground(Color.black);
        table.setGridColor(Color.darkGray);

        //Font
        try {
            // Cargar la fuente desde el archivo OTF
            fuenteExterna = Font.createFont(Font.TRUETYPE_FONT, new File(fuenteNrm));
            fuenteDerivada = fuenteExterna.deriveFont(Font.PLAIN, 15);

            // Aplicar al label
            table.setFont(fuenteDerivada);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la fuente: " + e.getMessage());
        }

        // Personalizar la alineación del texto en las celdas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        // Personalizar la altura de las filas
        table.setRowHeight(30);

        // Personalizar la selección de filas
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public static class PanelImagen extends JPanel {
        private BufferedImage fondo;

        public PanelImagen(String dir) {
            try {
                // Cargar la imagen desde un archivo
                fondo = ImageIO.read(getClass().getResource(dir));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Dibujar la imagen como fondo del panel
            if (fondo != null) {
                g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public static class deskImg extends JDesktopPane {
        private Image backgroundImage;

        public deskImg(String imagePath) {
            // Cargar la imagen de fondo
            backgroundImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Dibujar la imagen de fondo
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
