package Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static Principal.Tarjeta.saldo2;


public class Piso1 extends JFrame {
    public  static  JPanel panel;
    private static Piso1 instanciaActual;
    private int piso1;
    private static int x;

    public Piso1(int piso1) {
        instanciaActual = this;
        this.piso1 = piso1;
        x=piso1;

    }

    public Piso1() {
        setSize(1400, 1000);
        setLocation(150, 200);
        setTitle("Primer piso");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(200, 200));
        Items3();
        instanciaActual = this;

    }

    void Items3() {
        CrearpanelPiso1();
        Elevador();
        BP1();
        P1();
BotonTarjeta();

    }

    private void CrearpanelPiso1() {
        panel = new JPanel();
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);

        panel.setLayout(null);
    }

    public static Icon icono(String ruta, int ancho, int alto) {
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
        String[] opciones = {"Lobby", "Piso 2", "Restaurante"};
        String respuesta = (String) JOptionPane.showInputDialog(null,"A dónde se quiere dirigir", "Elevador", JOptionPane.DEFAULT_OPTION, icono("/Imag/LOGO.png",50,50), opciones, opciones[0]);

        try {
            switch (respuesta) {
                case "Lobby":
                    MuseoDentro lobby = new MuseoDentro();
                    lobby.setVisible(true);
                    instanciaActual.dispose();
                    break;
                case "Piso 2":
                    if (x == 1) {
                        JOptionPane.showMessageDialog(null, "No tiene acceso a este piso", "Elevador", JOptionPane.WARNING_MESSAGE, icono("/Imag/LOGO.png",50,50));
                    } else {
                        Piso2 piso2 = new Piso2();
                        piso2.setVisible(true);
                        instanciaActual.dispose();
                    }

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
    private void P1() {
        ImageIcon portada = new ImageIcon(getClass().getResource("/Imag/P1.png"));

        JLabel p1 = new JLabel();

        p1.setBounds(50, 70, 1200, 650);

        p1.setIcon(new ImageIcon(portada.getImage().getScaledInstance(p1.getWidth(), p1.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(p1);
    }
    private void BP1(){
            JButton a  = new JButton();//Robert
            JButton b  = new JButton();//Egypcian
            JButton c  = new JButton();//Greek
            JButton d  = new JButton();//Arms and armour


            a.setBounds(540,70,200,130);
        a.setEnabled(true);
        a.setContentAreaFilled(false);
        a.setBorderPainted(false);
            panel.add(a);
            b.setBounds(900,500,350,180);
        b.setEnabled(true);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
            panel.add(b);
            c.setBounds(50,570,450,120);
        c.setEnabled(true);
        c.setContentAreaFilled(false);
        c.setBorderPainted(false);
            panel.add(c);
            d.setBounds(850,355,160,110);
        d.setContentAreaFilled(false);
        d.setBorderPainted(false);
        d.setEnabled(true);
            panel.add(d);

        a.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            mostrarVentanaInformacion("Bowl, Mina'i y Faceted Basin", "Bowl, Mina'i de anónimo, del siglo 12, es un plato de la clase alta iraní de la época. \n\nFaceted Basin de anónimo, del siglo 13, es otro plato de la clase alta iraní de la época.", "/Imag/r1.jpeg", "/Imag/r2.jpeg");
        }});panel.add(a);

        b.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            mostrarVentanaInformacion("Pataikos or other dwarf god, with curly hair y Wedjat Eye Amulet", "Pataikos or other dwarf god, with curly hair, del año 664 A.C., es una estatuilla de un dios enano egipcio. \n\nWedjat Eye Amulet, del año 332 A.C., es un artilugio de oro que simboliza al dios Ra.", "/Imag/e1.jpeg", "/Imag/e2.jpeg");
        }});panel.add(b);

        c.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            mostrarVentanaInformacion("Limestone sphinx supporting a votive bowl y Bell", "Limestone sphinx supporting a votive bowl del pueblo de Cypriot anónimo, del siglo 6 A.C., es una escultura de la época, además de que funcionaba como jarrón. \n\nBell del pueblo de Cypriot anónimo, del siglo 4 A.C., es una campana de bronce de la época.", "/Imag/gr1.jpeg", "/Imag/gr2.jpeg");
        }});panel.add(c);

        d.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            mostrarVentanaInformacion("Rapier y Sword Guard", "Rapier, del año 1773, es una espada española tradicional. \n\nSword Guard, del siglo 19, es una base de una katana Japonesa de un samurai", "/Imag/ea1.jpeg", "/Imag/ea2.jpeg");
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
