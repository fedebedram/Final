package Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static Principal.Tarjeta.saldo2;


public class Restaurante extends JFrame {
    public static JPanel panel;
    private static Restaurante instanciaActual;
    private int piso11;
    private static int x;


    public Restaurante(int piso11) {
        instanciaActual = this;
        this.piso11 = piso11;
        x=piso11;
    }

    public Restaurante() {
        setSize(1400, 1000);
        setLocation(150, 200);
        setTitle("Restaurante");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(200, 200));
        Items5();
        instanciaActual = this;

    }

    void Items5() {
        CrearpanelRest();
        Elevador();
        BR();
        R();
        BotonTarjeta();
    }

    private void CrearpanelRest() {
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
        String[] opciones = {"Piso 1", "Piso 2", "Lobby"};
        String respuesta = (String) JOptionPane.showInputDialog(null,"A dónde se quiere dirigir", "Elevador", JOptionPane.DEFAULT_OPTION, icono("/Imag/LOGO.png",50,50), opciones, opciones[0]);

        try {
            switch (respuesta) {
                case "Piso 1":
                    Piso1 piso1 = new Piso1();
                    piso1.setVisible(true);
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
                case "Lobby":
                    MuseoDentro lobby = new MuseoDentro();
                    lobby.setVisible(true);
                    instanciaActual.dispose();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void R() {
        ImageIcon portada = new ImageIcon(getClass().getResource("/Imag/R.png"));

        JLabel R = new JLabel();

        R.setBounds(50, 70, 1200, 650);

        R.setIcon(new ImageIcon(portada.getImage().getScaledInstance(R.getWidth(), R.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(R);
    }
    private void BR(){
        JButton br  = new JButton();

        br.setBounds(170,250,130,70);
        br.setContentAreaFilled(false);
        br.setBorderPainted(false);
        br.setEnabled(true);

        panel.add(br);

        br.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            mostrarVentanaRestaurante("Bienvenido al rooftop", " ", "/Imag/T1.jpeg");
        }});panel.add(br);
    }
    private void mostrarVentanaRestaurante(String titulo, String descripcion, String rutaImagen1) {
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

        JLabel labelImagen1 = new JLabel(imagen1);
        labelImagen1.setBounds(0, 0, 1400, 700);



        JPanel panelImagenes = new JPanel(new GridLayout(1, 2));
        panelImagenes.add(labelImagen1);

        panelInformacion.add(panelImagenes, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new GridLayout(3, 2));

        JButton button1 = new JButton("Bebidas");
        button1.addActionListener(e -> jButtonActionPerformed("Bebidas"));
        panelBotones.add(button1);

        JButton button2 = new JButton("Cerveza");
        button2.addActionListener(e -> jButtonActionPerformed("Cerveza"));
        panelBotones.add(button2);

        JButton button3 = new JButton("Snacks");
        button3.addActionListener(e -> jButtonActionPerformed("Snacks"));
        panelBotones.add(button3);

        JButton button4 = new JButton("Comida");
        button4.addActionListener(e -> jButtonActionPerformed("Comida"));
        panelBotones.add(button4);

        JButton button5 = new JButton("Vino");
        button5.addActionListener(e -> jButtonActionPerformed("Vino"));
        panelBotones.add(button5);
        panelInformacion.add(panelBotones, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Rooftop");
        frame.setSize(1400, 1000);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.add(panelInformacion);
        frame.setVisible(true);
    }
    private void jButtonActionPerformed(String opcion) {

        switch (opcion) {
            case "Bebidas":
                JPanel BE = new JPanel();
                BE.setLayout(new BorderLayout());

                JLabel mensajeLabel = new JLabel("Si gusta un artículo, para comprarlo seleccione el que desee");
                mensajeLabel.setHorizontalAlignment(SwingConstants.CENTER);
                BE.add(mensajeLabel, BorderLayout.NORTH);

                JPanel panelBotones = new JPanel(new GridLayout(3, 2));

                JButton button1 = new JButton("Agua Natural - $4.75");
                button1.addActionListener(e -> BAP1("Agua Natural"));
                panelBotones.add(button1);

                JButton button2 = new JButton("Agua Mineral - $5");
                button2.addActionListener(e -> BAP1("Agua Mineral"));
                panelBotones.add(button2);

                JButton button3 = new JButton("Refresco - $4.25");
                button3.addActionListener(e -> BAP1("Refresco"));
                panelBotones.add(button3);

                JButton button4 = new JButton("Café - $5");
                button4.addActionListener(e -> BAP1("Café"));
                panelBotones.add(button4);

                JButton button5 = new JButton("Limonada - $5");
                button5.addActionListener(e -> BAP1("Limonada"));
                panelBotones.add(button5);

                BE.add(panelBotones, BorderLayout.SOUTH);

                JFrame frame = new JFrame("Bebidas");
                frame.setSize(1000, 200);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                frame.add(BE);
                frame.setVisible(true);
                break;
            case "Cerveza":
                JPanel CE = new JPanel();
                CE.setLayout(new BorderLayout());

                JLabel mensajeLabel1 = new JLabel("Si gusta un artículo, para comprarlo seleccione el que desee");
                mensajeLabel1.setHorizontalAlignment(SwingConstants.CENTER);
                CE.add(mensajeLabel1, BorderLayout.NORTH);

                JPanel panelBotones1 = new JPanel(new GridLayout(1, 3));

                JButton button11 = new JButton("Brooklyn lager - $10");
                button11.addActionListener(e -> BAP2("Brooklyn lager"));
                panelBotones1.add(button11);

                JButton button22 = new JButton("Montauk Summer Pale Ale - $10");
                button22.addActionListener(e -> BAP2("Montauk Summer Pale Ale"));
                panelBotones1.add(button22);

                JButton button33 = new JButton("Radeberger Pilsner - $11");
                button33.addActionListener(e -> BAP2("Radeberger Pilsner"));
                panelBotones1.add(button33);

                CE.add(panelBotones1, BorderLayout.SOUTH);

                JFrame frame1 = new JFrame("Cerveza");
                frame1.setSize(1000, 200);
                frame1.setLocationRelativeTo(null);
                frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                frame1.add(CE);
                frame1.setVisible(true);
                break;
            case "Snacks":
                JPanel SN = new JPanel();
                SN.setLayout(new BorderLayout());

                JLabel mensajeLabel2 = new JLabel("Si gusta un artículo, para comprarlo seleccione el que desee");
                mensajeLabel2.setHorizontalAlignment(SwingConstants.CENTER);
                SN.add(mensajeLabel2, BorderLayout.NORTH);

                JPanel panelBotones2 = new JPanel(new GridLayout(3, 2));

                JButton button111 = new JButton("Sandía - $4.75");
                button111.addActionListener(e -> BAP3("Sandía"));
                panelBotones2.add(button111);

                JButton button222 = new JButton("Papas - $4.25");
                button222.addActionListener(e -> BAP3("Papas"));
                panelBotones2.add(button222);

                JButton button333 = new JButton("Palomitas - $4.25");
                button333.addActionListener(e -> BAP3("Palomitas"));
                panelBotones2.add(button333);

                JButton button444 = new JButton("Nueces - $4.5");
                button444.addActionListener(e -> BAP3("Nueces"));
                panelBotones2.add(button444);

                JButton button555 = new JButton("Menta - $4");
                button555.addActionListener(e -> BAP3("Menta"));
                panelBotones2.add(button555);

                SN.add(panelBotones2, BorderLayout.SOUTH);

                JFrame frame2 = new JFrame("Snacks");
                frame2.setSize(1100, 200);
                frame2.setLocationRelativeTo(null);
                frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                frame2.add(SN);
                frame2.setVisible(true);
                break;
            case "Comida":
                JPanel CO = new JPanel();
                CO.setLayout(new BorderLayout());

                JLabel mensajeLabel3 = new JLabel("Si gusta un artículo, para comprarlo seleccione el que desee");
                mensajeLabel3.setHorizontalAlignment(SwingConstants.CENTER);
                CO.add(mensajeLabel3, BorderLayout.NORTH);

                JPanel panelBotones3 = new JPanel(new GridLayout(1, 3));

                JButton button1111 = new JButton("Rollo de langosta - $18");
                button1111.addActionListener(e -> BAP4("Rollo de langosta"));
                panelBotones3.add(button1111);

                JButton button2222 = new JButton("Sandwich del chef - $15");
                button2222.addActionListener(e -> BAP4("Sandwich del chef"));
                panelBotones3.add(button2222);

                JButton button3333 = new JButton("Sandwich vegetariano - $17");
                button3333.addActionListener(e -> BAP4("Sandwich vegetariano"));
                panelBotones3.add(button3333);

                CO.add(panelBotones3, BorderLayout.SOUTH);

                JFrame frame3 = new JFrame("Comida");
                frame3.setSize(1000, 200);
                frame3.setLocationRelativeTo(null);
                frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                frame3.add(CO);
                frame3.setVisible(true);
                break;
            case "Vino":
                JPanel VI = new JPanel();
                VI.setLayout(new BorderLayout());

                JLabel mensajeLabel4 = new JLabel("Si gusta un artículo, para comprarlo seleccione el que desee");
                mensajeLabel4.setHorizontalAlignment(SwingConstants.CENTER);
                VI.add(mensajeLabel4, BorderLayout.NORTH);

                JPanel panelBotones4 = new JPanel(new GridLayout(1, 3));

                JButton button11111 = new JButton("Rosado - $15");
                button11111.addActionListener(e -> BAP5("Rosado"));
                panelBotones4.add(button11111);

                JButton button22222 = new JButton("Blanco - $15");
                button22222.addActionListener(e -> BAP5("Blanco"));
                panelBotones4.add(button22222);

                JButton button33333 = new JButton("Tinto - $15");
                button33333.addActionListener(e -> BAP5("Tinto"));
                panelBotones4.add(button33333);

                VI.add(panelBotones4, BorderLayout.SOUTH);

                JFrame frame4 = new JFrame("Vino");
                frame4.setSize(1000, 200);
                frame4.setLocationRelativeTo(null);
                frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                frame4.add(VI);
                frame4.setVisible(true);
                break;
            default:
                break;
        }
    }
    private void BAP1(String opcion) {

        switch (opcion) {
            case "Agua Natural":
                if (saldo2>=4.75){
                    saldo2=saldo2-4.75;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Agua Mineral":
                if (saldo2>=5){
                    saldo2=saldo2-5;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Refresco":
                if (saldo2>=4.25){
                    saldo2=saldo2-4.25;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Café":
                if (saldo2>=5.5){
                    saldo2=saldo2-5.5;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Limonada":
                if (saldo2>=5.5){
                    saldo2=saldo2-5.5;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            default:
                break;
        }}
    private void BAP2(String opcion) {
        switch (opcion) {
            case "Brooklyn lager":
                if (saldo2>=10){
                    saldo2=saldo2-10;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Montauk Summer Pale Ale":
                if (saldo2>=10){
                    saldo2=saldo2-10;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Radeberger Pilsner":
                if (saldo2>=11){
                    saldo2=saldo2-11;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            default:
                break;
        }
    }

    private void BAP3(String opcion) {
        switch (opcion) {
            case "Sandía":
                if (saldo2>=4.75){
                    saldo2=saldo2-4.75;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Papas":
                if (saldo2>=4.25){
                    saldo2=saldo2-4.25;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Palomitas":
                if (saldo2>=4.25){
                    saldo2=saldo2-4.25;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Nueces":
                if (saldo2>=4.5){
                    saldo2=saldo2-4.5;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Menta":
                if (saldo2>=4){
                    saldo2=saldo2-4;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            default:
                break;
        }
    }

    private void BAP4(String opcion) {
        switch (opcion) {
            case "Rollo de langosta":
                if (saldo2>=18){
                    saldo2=saldo2-18;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Sandwich del chef":
                if (saldo2>=15){
                    saldo2=saldo2-15;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Sandwich vegetariano":
                if (saldo2>=17){
                    saldo2=saldo2-17;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            default:
                break;
        }
    }

    private void BAP5(String opcion) {
        switch (opcion) {
            case "Rosado":
                if (saldo2>=15){
                    saldo2=saldo2-15;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Blanco":
                if (saldo2>=15){
                    saldo2=saldo2-15;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Tinto":
                if (saldo2>=15){
                    saldo2=saldo2-15;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            default:
                break;
        }
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
