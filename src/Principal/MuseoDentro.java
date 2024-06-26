package Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Principal.Tarjeta.saldo2;

public class MuseoDentro extends JFrame{
    public static JPanel panel;
    private static MuseoDentro instanciaActual;
    private int piso;
    private static int x;
    public double saldo;
    public double saldoActual;
private Tarjeta tarjeta;

    public MuseoDentro(int piso) {
        instanciaActual = this;
        this.tarjeta = tarjeta;
        this.piso = piso;
        x=piso;
    }
    public MuseoDentro() {
        setSize(1400,1000);
        setLocation(150,200);
        setTitle("Lobby");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(200,200));
        Items2();
    }

    void Items2(){
        CrearpanelLobby();
        Elevador();
        BotonTarjeta();
        BGH();
        GH();
        BS();
    }
    private void CrearpanelLobby(){
        panel= new JPanel();
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
        String[] opciones = {"Piso 1", "Piso 2", "Restaurante"};
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

    private void GH() {
        ImageIcon portada = new ImageIcon(getClass().getResource("/Imag/GH.jpeg"));

        JLabel GH = new JLabel();

        GH.setBounds(50, 70, 1200, 650);

        GH.setIcon(new ImageIcon(portada.getImage().getScaledInstance(GH.getWidth(), GH.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(GH);
    }
    private void BGH(){
        JButton a  = new JButton();



        a.setBounds(1280,65,100,100);
        a.setBackground(Color.white);
        panel.add(a);

        ImageIcon a1 = new ImageIcon(MuseoDentro.class.getResource("/Imag/MS.jpeg"));
        a.setIcon(new ImageIcon(a1.getImage().getScaledInstance(a.getWidth(),a.getHeight(),Image.SCALE_SMOOTH)));
        panel.add(a);

        a.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            mostrarVentanaTienda("Bienvenido a la tienda", " ", "/Imag/ms1.jpeg");
        }});panel.add(a);

    }
    private void mostrarVentanaTienda(String titulo, String descripcion, String rutaImagen1) {
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

        JPanel panelBotones = new JPanel(new GridLayout(2, 2));

        JButton button1 = new JButton("Ropa");
        button1.addActionListener(e -> jButtonActionPerformed("Ropa"));
        panelBotones.add(button1);

        JButton button2 = new JButton("Decoraciones");
        button2.addActionListener(e -> jButtonActionPerformed("Decoraciones"));
        panelBotones.add(button2);

        JButton button3 = new JButton("Regalos");
        button3.addActionListener(e -> jButtonActionPerformed("Regalos"));
        panelBotones.add(button3);

        JButton button4 = new JButton("Libros");
        button4.addActionListener(e -> jButtonActionPerformed("Libros"));
        panelBotones.add(button4);

        panelInformacion.add(panelBotones, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Souvenir Store");
        frame.setSize(1400, 1000);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.add(panelInformacion);
        frame.setVisible(true);
    }

    private void jButtonActionPerformed(String opcion) {

        switch (opcion) {
            case "Ropa":
                JPanel panelRopa = new JPanel();
                panelRopa.setLayout(new BorderLayout());

                JLabel mensajeLabel = new JLabel("Si gusta un artículo, para comprarlo seleccione el que desee");
                mensajeLabel.setHorizontalAlignment(SwingConstants.CENTER);
                panelRopa.add(mensajeLabel, BorderLayout.NORTH);

                JPanel panelBotones = new JPanel(new GridLayout(1, 3));

                JButton button1 = new JButton("Mandil de gato - $38");
                button1.addActionListener(e -> BAP1("Mandil de gato"));
                panelBotones.add(button1);

                JButton button2 = new JButton("Bufanda de seda de William Morris - $69");
                button2.addActionListener(e -> BAP1("Bufanda de seda de William Morris"));
                panelBotones.add(button2);

                JButton button3 = new JButton("Bolsa grande de pavo real y dragón - $95");
                button3.addActionListener(e -> BAP1("Bolsa grande de pavo real y dragón"));
                panelBotones.add(button3);

                panelRopa.add(panelBotones, BorderLayout.SOUTH);

                JFrame frame = new JFrame("Ropa");
                frame.setSize(1000, 100);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                frame.add(panelRopa);
                frame.setVisible(true);
                break;
            case "Decoraciones":
                JPanel panelDeco = new JPanel();
                panelDeco.setLayout(new BorderLayout());

                JLabel mensajeLabel1 = new JLabel("Si gusta un artículo, para comprarlo seleccione el que desee");
                mensajeLabel1.setHorizontalAlignment(SwingConstants.CENTER);
                panelDeco.add(mensajeLabel1, BorderLayout.NORTH);

                JPanel panelBotones1 = new JPanel(new GridLayout(1, 3));

                JButton button11 = new JButton("Esferas de navidad Louis C. Tiffany - $135");
                button11.addActionListener(e -> BAP2("Esferas de navidad Louis C. Tiffany"));
                panelBotones1.add(button11);

                JButton button22 = new JButton("El pensador escultura - $245");
                button22.addActionListener(e -> BAP2("El pensador escultura"));
                panelBotones1.add(button22);

                JButton button33 = new JButton("Pequeña escultura de gato egipcio - $35");
                button33.addActionListener(e -> BAP2("Pequeña escultura de gato egipcio"));
                panelBotones1.add(button33);

                panelDeco.add(panelBotones1, BorderLayout.SOUTH);

                JFrame frame1 = new JFrame("Decoraciones");
                frame1.setSize(1000, 100);
                frame1.setLocationRelativeTo(null);
                frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                frame1.add(panelDeco);
                frame1.setVisible(true);
                break;
            case "Regalos":
                JPanel panelReg = new JPanel();
                panelReg.setLayout(new BorderLayout());

                JLabel mensajeLabel2 = new JLabel("Si gusta un artículo, para comprarlo seleccione el que desee");
                mensajeLabel2.setHorizontalAlignment(SwingConstants.CENTER);
                panelReg.add(mensajeLabel2, BorderLayout.NORTH);

                JPanel panelBotones2 = new JPanel(new GridLayout(1, 3));

                JButton button111 = new JButton("Decoración del gato favorito - $30");
                button111.addActionListener(e -> BAP3("Decoración del gato favorito"));
                panelBotones2.add(button111);

                JButton button222 = new JButton("Set de servilletas de William Morris Botanical - $60");
                button222.addActionListener(e -> BAP3("Set de servilletas de William Morris Botanical"));
                panelBotones2.add(button222);

                JButton button333 = new JButton("Collar de aves - $85");
                button333.addActionListener(e -> BAP3("Collar de aves"));
                panelBotones2.add(button333);

                panelReg.add(panelBotones2, BorderLayout.SOUTH);

                JFrame frame2 = new JFrame("Regalos");
                frame2.setSize(1100, 100);
                frame2.setLocationRelativeTo(null);
                frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                frame2.add(panelReg);
                frame2.setVisible(true);
                break;
            case "Libros":
                JPanel panelLib = new JPanel();
                panelLib.setLayout(new BorderLayout());

                JLabel mensajeLabel3 = new JLabel("Si gusta un artículo, para comprarlo seleccione el que desee");
                mensajeLabel3.setHorizontalAlignment(SwingConstants.CENTER);
                panelLib.add(mensajeLabel3, BorderLayout.NORTH);

                JPanel panelBotones3 = new JPanel(new GridLayout(1, 3));

                JButton button1111 = new JButton("Vertigo de color - $50");
                button1111.addActionListener(e -> BAP4("Vertigo de color"));
                panelBotones3.add(button1111);

                JButton button2222 = new JButton("Manet/Degas - $65");
                button2222.addActionListener(e -> BAP4("Manet/Degas"));
                panelBotones3.add(button2222);

                JButton button3333 = new JButton("Tree & Serpent - $65");
                button3333.addActionListener(e -> BAP4("Tree & Serpent"));
                panelBotones3.add(button3333);

                panelLib.add(panelBotones3, BorderLayout.SOUTH);

                JFrame frame3 = new JFrame("Libros");
                frame3.setSize(1000, 100);
                frame3.setLocationRelativeTo(null);
                frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                frame3.add(panelLib);
                frame3.setVisible(true);
                break;
            default:
                break;
        }
    }
    private void BAP1(String opcion) {

        switch (opcion) {
            case "Mandil de gato":
                if (saldo2>=38){
                saldo2=saldo2-38;
                JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                    break;
            case "Bufanda de seda de William Morris":
                if (saldo2>=69){
                    saldo2=saldo2-69;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Bolsa grande de pavo real y dragón":
                if (saldo2>=95){
                    saldo2=saldo2-95;
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
            case "Esferas de navidad Louis C. Tiffany":
                if (saldo2>=135){
                    saldo2=saldo2-135;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "El pensador escultura":
                if (saldo2>=245){
                    saldo2=saldo2-245;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Bolsa grande de pavo real y dragón":
                if (saldo2>=35){
                    saldo2=saldo2-35;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            default:
                break;
        }}
    private void BAP3(String opcion) {

        switch (opcion) {
            case "Decoración del gato favorito":
                if (saldo2>=30){
                    saldo2=saldo2-30;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Set de servilletas de William Morris Botanical":
                if (saldo2>=60){
                    saldo2=saldo2-60;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Collar de aves":
                if (saldo2>=85){
                    saldo2=saldo2-85;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            default:
                break;
        }}
    private void BAP4(String opcion) {

        switch (opcion) {
            case "Vertigo de color":
                if (saldo2>=50){
                    saldo2=saldo2-50;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Manet/Degas":
                if (saldo2>=65){
                    saldo2=saldo2-65;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            case "Tree & Serpent":
                if (saldo2>=65){
                    saldo2=saldo2-65;
                    JOptionPane.showMessageDialog(null, "Saldo restante de $"+saldo2+".", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo insuficinete.", "Tarjeta Virtual", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
                break;
            default:
                break;
        }}
    private void BS(){
        JButton botonSalida = new JButton("EXIT");
        botonSalida.setBounds(1320, 515, 50, 40);
        botonSalida.setBackground(Color.white);
        panel.add(botonSalida);

        botonSalida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaComentarios();
            }
        });
    }
    private void abrirVentanaComentarios() {
        JFrame ventanaComentarios = new JFrame("Comentarios");
        ventanaComentarios.setSize(400, 300);
        ventanaComentarios.setLocationRelativeTo(null);

        JTextArea areaComentarios = new JTextArea();
        areaComentarios.setBounds(20, 20, 360, 160);
        areaComentarios.setText("Escriba su comentario aquí");
        areaComentarios.setEditable(true);
        ventanaComentarios.add(areaComentarios);

        JScrollPane barraDesplazamiento = new JScrollPane(areaComentarios,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        barraDesplazamiento.setBounds(20, 20, 360, 160);
        ventanaComentarios.add(barraDesplazamiento);
        areaComentarios.setOpaque(true);

        JButton botonFinalizar = new JButton("Siguiente");
        botonFinalizar.setBounds(150, 220, 100, 40);
        botonFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaComentarios.dispose();
                seleccionarSalasFavoritas();
            }
        });
        ventanaComentarios.add(botonFinalizar);

        ventanaComentarios.setLayout(null);
        ventanaComentarios.setVisible(true);
    }
    private void seleccionarSalasFavoritas() {
        JFrame ventanaCHECK = new JFrame("Cuales fueron las salas que más le gustaron?");
        ventanaCHECK.setSize(600, 400);
        ventanaCHECK.setLocationRelativeTo(null);

        JPanel panelChecklist = new JPanel(new GridLayout(0, 2));

        JCheckBox sala1 = new JCheckBox("Robert Lehman", false);
        panelChecklist.add(sala1);

        JCheckBox sala2 = new JCheckBox("Arms and Armour", false);
        panelChecklist.add(sala2);

        JCheckBox sala3 = new JCheckBox("Egypcian Art", false);
        panelChecklist.add(sala3);

        JCheckBox sala4 = new JCheckBox("Greek and Roman Art", false);
        panelChecklist.add(sala4);

        JCheckBox sala5 = new JCheckBox("Modern and Contemporary Art", false);
        panelChecklist.add(sala5);

        JCheckBox sala6 = new JCheckBox("Asian Art", false);
        panelChecklist.add(sala6);

        JCheckBox sala7 = new JCheckBox("Arab Art", false);
        panelChecklist.add(sala7);

        JCheckBox sala8 = new JCheckBox("European Paintings", false);
        panelChecklist.add(sala8);

        JLabel etiquetaSeleccion = new JLabel();
        panelChecklist.add(etiquetaSeleccion);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etiquetaSeleccion.setText("Seleccionado: " +
                        (sala1.isSelected() ? "Sala 1, " : "") +
                        (sala2.isSelected() ? "Sala 2, " : "") +
                        (sala3.isSelected() ? "Sala 3, " : "") +
                        (sala4.isSelected() ? "Sala 4, " : "") +
                        (sala5.isSelected() ? "Sala 5, " : "") +
                        (sala6.isSelected() ? "Sala 6, " : "") +
                        (sala7.isSelected() ? "Sala 7, " : "") +
                        (sala8.isSelected() ? "Sala 8" : ""));
            }
        };

        sala1.addActionListener(actionListener);
        sala2.addActionListener(actionListener);
        sala3.addActionListener(actionListener);
        sala4.addActionListener(actionListener);
        sala5.addActionListener(actionListener);
        sala6.addActionListener(actionListener);
        sala7.addActionListener(actionListener);
        sala8.addActionListener(actionListener);


        JButton botonSalir = new JButton("Salir");
        botonSalir.setBounds(500, 180, 40, 40);

        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panelChecklist.add(botonSalir);

        ventanaCHECK.add(panelChecklist);
        ventanaCHECK.setLayout(new FlowLayout());
        ventanaCHECK.setVisible(true);
    }
    }