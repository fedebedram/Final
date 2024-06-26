package Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static Principal.Tarjeta.saldo2;


public class Piso2 extends JFrame {
    public static JPanel panel;
    private static Piso2 instanciaActual;


    public Piso2() {
        setSize(1400, 1000);
        setLocation(150, 200);
        setTitle("Segundo piso");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(200, 200));
        Items4();
        instanciaActual = this;

    }

    void Items4() {
        CrearpanelPiso2();
        Elevador();
        BP2();
        P2();
BotonTarjeta();

    }

    private void CrearpanelPiso2() {
        panel = new JPanel();
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);

        panel.setLayout(null);
    }

    public static Icon icono(String ruta, int ancho, int alto) { //Para habilitar las imágenes
        Icon icono_imagen = new ImageIcon(new ImageIcon(Principal.class.getResource(ruta)).getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
        return icono_imagen;
    }
    private static void Elevador() {
        JButton ele  = new JButton();

        ele.setBounds(1300,650,80,66);
        ele.setBackground(Color.white);
        panel.add(ele);
        JLabel label = new JLabel("Elevador");
        label.setBounds(1310, 630, 80, 20);
        panel.add(label);
        ImageIcon ele_clic = new ImageIcon(MuseoDentro.class.getResource("/Imag/ELE.jpeg"));
        ele.setIcon(new ImageIcon(ele_clic.getImage().getScaledInstance(ele.getWidth(),ele.getHeight(),Image.SCALE_SMOOTH)));
        ele.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Elevadorop();
            }
        });
    }
    private static void Elevadorop(){
        String[] opciones = {"Piso 1", "Lobby", "Restaurante"};
        String respuesta = (String) JOptionPane.showInputDialog(null,"A dónde se quiere dirigir", "Elevador", JOptionPane.DEFAULT_OPTION, icono("/Imag/LOGO.png",50,50), opciones, opciones[0]);

        try {
            switch (respuesta) {
                case "Piso 1":
                    Piso1 piso1 = new Piso1();
                    piso1.setVisible(true);
                    instanciaActual.dispose();
                    break;
                case "Lobby":
                    MuseoDentro lobby = new MuseoDentro();
                    lobby.setVisible(true);
                    instanciaActual.dispose();
                    break;
                case "Restaurante":
                    Restaurante restaurante = new Restaurante();
                    restaurante.setVisible(true);
                    instanciaActual.dispose();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void P2() {
        ImageIcon portada = new ImageIcon(getClass().getResource("/Imag/P2.png"));

        JLabel p2 = new JLabel();

        p2.setBounds(50, 70, 1200, 650);

        p2.setIcon(new ImageIcon(portada.getImage().getScaledInstance(p2.getWidth(), p2.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(p2);
    }
    private void BP2(){
        JButton a  = new JButton();//European paintings
        JButton b  = new JButton();//Asian art
        JButton c  = new JButton();//Modern and contemp
        JButton d  = new JButton();//Art of the arabs


        a.setBounds(435,200,420,260);
        a.setEnabled(true);
        a.setContentAreaFilled(false);
        a.setBorderPainted(false);
        panel.add(a);
        b.setBounds(750,580,500,105);
        b.setEnabled(true);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        panel.add(b);
        c.setBounds(90,140,200,90);
        c.setEnabled(true);
        c.setContentAreaFilled(false);
        c.setBorderPainted(false);
        panel.add(c);
        d.setBounds(50,570,250,140);
        d.setContentAreaFilled(false);
        d.setBorderPainted(false);
        d.setEnabled(true);
        panel.add(d);

        a.addActionListener(new ActionListener() {@Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaInformacion("Morning y Winter Landscape", "Morning de Maximilien Luce, del año 1890, retrata a su amigo y colega Gustave Perrot alistándose una mañana cualquiera al salir el sol. \n\nWinter Landscape de Barend Cornelis Koekkoek, del año 1833, retrata el típico invierno holandés.", "/Imag/ep1.jpeg", "/Imag/ep2.jpeg");
            }});panel.add(a);

        b.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            mostrarVentanaInformacion("Magnolia Flowers y Scene from the Ramayana", "Mangolia Flowers de Kubo Shunman, del siglo 19, retrata flores representativas de Japon. \n\nScene from the Ramayana de Cambodia, del siglo 20, retrata una escena del famoso libro del Ramayana.", "/Imag/aa1.jpeg", "/Imag/aa2.jpeg");
        }});panel.add(b);

        c.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            mostrarVentanaInformacion("Sweets y Washerwoman", "Sweets de Randall Deihl, del año 1980, retrata una tienda de dulces de los 90's, que era todo un evento en aquel entonces y provocaba una sensación especial. \n\nWasherwoman de Auguste Renoir, del año 1916, escultura que nos muestra cómo se llevaba a cabo esta actividad tan cotidiana antes de toda la evolución tecnológica.", "/Imag/ca1.jpeg", "/Imag/ca2.jpeg");
        }});panel.add(c);
        d.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            mostrarVentanaInformacion("Panel Fragment y Buzurgmihr Masters the Game of Chess", "Panel Fragment de Anónimo, del siglo 8 A.C., muestra una parte de una escultira arquitectónica de lo que parece ser una batalla o historia heróica. \n\nBuzurgmihr Masters the Game of Chess de  Abu'l Qasim Firdausi, del año 1300 A.C., es un texto que explica lo que era el ajedrez, sus reglas y más. Representando la pérdida del juego de un Iraní contra un Indio.", "/Imag/a1.jpeg", "/Imag/a2.jpeg");
        }});panel.add(d);
    }

    private void mostrarVentanaInformacion(String titulo, String descripcion, String rutaImagen1, String rutaImagen2) {
        JPanel panelInformacion = new JPanel();
        panelInformacion.setLayout(new BorderLayout());

        JLabel labelTitulo = new JLabel(titulo);
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.ITALIC, 22));
        panelInformacion.add(labelTitulo, BorderLayout.NORTH);

        JTextArea areaTexto = new JTextArea(descripcion);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        panelInformacion.add(new JScrollPane(areaTexto), BorderLayout.SOUTH);

        ImageIcon imagen1 = new ImageIcon(MuseoDentro.class.getResource(rutaImagen1));
        ImageIcon imagen2 = new ImageIcon(MuseoDentro.class.getResource(rutaImagen2));

        JLabel labelImagen1 = new JLabel(imagen1);
        labelImagen1.setBounds(0, 0, 700, 700);

        JLabel labelImagen2 = new JLabel(imagen2);
        labelImagen2.setBounds(700, 0, 700, 700);

        JPanel panelImagenes = new JPanel(new GridLayout(1, 2));
        panelImagenes.add(labelImagen1);
        panelImagenes.add(labelImagen2);

        panelInformacion.add(panelImagenes, BorderLayout.CENTER);

        // Agregar el panel de información al panel principal de tu interfaz gráfica
        JFrame frame = new JFrame("Obras de arte");
        frame.setSize(1400, 1000); // Ajusta el tamaño según tus necesidades
        frame.setLocationRelativeTo(null); // Centrar en la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.add(panelInformacion);
        frame.setVisible(true);
    }
    private void BotonTarjeta() {
        JButton bt1 = new JButton();

        bt1.setBounds(1320, 580, 40, 40);
        bt1.setBackground(Color.white);

        ImageIcon wi = new ImageIcon(getClass().getResource("/Imag/W.png"));
        bt1.setIcon(new ImageIcon(wi.getImage().getScaledInstance(bt1.getWidth(), bt1.getHeight(), Image.SCALE_SMOOTH)));
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Tiene un saldo actual de \n$" + saldo2 + ".", "Saldo virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));

            }
        });

        panel.add(bt1);
    }
    public static void main(String[] args) { //Hace que se pueda correr el boton
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
