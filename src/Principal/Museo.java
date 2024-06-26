package Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static Principal.Tarjeta.saldo2;

public class Museo extends JFrame {package Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static Principal.Tarjeta.saldo2;

    public class Museo extends JFrame {
        public JPanel panel;
        public static String Nombre;
        public static int Personas;
        public Double Monto;
        public static int Piso;
        public static Double Costo;
        private Tarjeta tarjeta;


        public Museo() {

            setSize(1400,1000);
            setLocation(150,200);
            setTitle("Metropolitan Museum NY");

            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setMinimumSize(new Dimension(200,200));
            Items();
        }

        private void Items(){
            SolicitarContrasena();
            Crearpanel();
            BotonEntrada();

            Entrada();
            EtiquetaEntrada();
            EtiquetaEntrada2();
        }

        public static Icon icono(String ruta, int ancho, int alto) { //Para habilitar las imágenes
            Icon icono_imagen = new ImageIcon(new ImageIcon(Principal.class.getResource(ruta)).getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
            return icono_imagen;
        }

        private void SolicitarContrasena() {
            JPasswordField passw = new JPasswordField(10);
            int result = JOptionPane.showConfirmDialog(null, passw, "Ingrese la contraseña:",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png",50,50));

            if (result == JOptionPane.OK_OPTION) {
                char[] clave = {'M', 'E', 'T', '2', '3'};
                char[] contras = passw.getPassword();

                if (Arrays.equals(contras, clave)) {
                    JOptionPane.showMessageDialog(null, "Bienvenido","Contraseña",JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png",50,50));
                    Cliente();
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña Incorrecta","Contraseña",JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png",50,50));
                    SolicitarContrasena();
                }
            } else {
                System.exit(0);
            }
        }

        private void Crearpanel(){
            panel= new JPanel();
            panel.setBackground(Color.white);
            this.getContentPane().add(panel);

            panel.setLayout(null);
        }

        private void Cliente(){
            do {
                Nombre = JOptionPane.showInputDialog(null, new JLabel("Ingresa el nombre del responsable", icono("/Imag/LOGO.png",50,50), JLabel.LEADING), "Datos de Registro", JOptionPane.PLAIN_MESSAGE);
                if (Nombre == null || Nombre.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nombre inválido", "Datos de Registro", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));}
            }while (Nombre == null || Nombre.trim().isEmpty());




            boolean personasValidas = false;
            while (!personasValidas) {
                try {
                    String personasStr = JOptionPane.showInputDialog(null, new JLabel(Nombre + ", ingresa el número de personas que ingresarán", icono("/Imag/LOGO.png", 50, 50), JLabel.LEADING), "Datos de Registro", JOptionPane.PLAIN_MESSAGE);
                    if (personasStr == null) {
                        return;
                    }
                    Personas = Integer.parseInt(personasStr);

                    if (Personas >= 1 && Personas <= 6) {
                        personasValidas = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Número de personas inválido. Debe ser entre 1 y 6.", "Datos de Registro", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Dato no válido, favor de ingresar una cantidad de personas válida", "Datos de Registro", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                }
            }
            String[] op ={"A los 2 pisos, Costo $50 por persona","Solo al piso 1, Costo $30 por persona"};
            Piso = JOptionPane.showOptionDialog(null, "A qué pisos quiere tener acceso?", "Datos de Registro", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icono("/Imag/LOGO.png", 50, 50), op, op[0]);
            MuseoDentro piso;
            piso = new MuseoDentro(Piso);
            Piso1 piso1;
            piso1= new Piso1(Piso);
            Restaurante piso11;
            piso11 = new Restaurante(Piso);

            if(Piso == 1){
                Costo= (double) (Personas*30);
            }else{
                Costo= (double) (Personas*50);
            }

            boolean montoValido = false;
            while (!montoValido) {
                String montoStr;
                try {
                    montoStr = JOptionPane.showInputDialog(null, new JLabel(Nombre + ", ingresa el monto con el que deseas ingresar al museo", icono("/Imag/LOGO.png", 50, 50), JLabel.LEADING), "Datos de Registro", JOptionPane.PLAIN_MESSAGE);
                    if (montoStr == null) {
                        return;
                    }
                    Monto = Double.parseDouble(montoStr);

                    if (Monto >= Costo) {
                        montoValido = true;
                        tarjeta = new Tarjeta(Monto);
                        tarjeta.restarCompra(Costo);

                    } else {
                        JOptionPane.showMessageDialog(null, "Monto no suficiente. Debe ser de mínimo $"+Costo+".", "Datos de Registro", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                        montoStr = null;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Dato no válido, favor de ingresar un monto válido", "Datos de Registro", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                    montoStr = null;
                }
            }
        }



        private void Entrada() {
            ImageIcon portada = new ImageIcon(getClass().getResource("/Imag/MET2.jpeg"));

            JLabel p1 = new JLabel();

            p1.setBounds(0, 170, 1410, 550);

            p1.setIcon(new ImageIcon(portada.getImage().getScaledInstance(p1.getWidth(), p1.getHeight(), Image.SCALE_SMOOTH)));
            panel.add(p1);
        }

        private void EtiquetaEntrada(){
            JLabel etiqueta1 = new JLabel("<html><div style='text-align: center;'>Bienvenido al Museo Metropolitano de NY!<br>De click en la puerta para continuar con la experiencia!</html>", SwingConstants.CENTER);
            etiqueta1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            etiqueta1.setBounds(400,0,600,170);
            etiqueta1.setForeground(Color.black);
            etiqueta1.setOpaque(true);
            etiqueta1.setBackground(Color.white);
            panel.add(etiqueta1);
        }
        private void EtiquetaEntrada2(){
            JLabel etiqueta2 = new JLabel("<html><div style='text-align: center;'>Donde el arte<br>va más allá</html>", SwingConstants.CENTER);
            etiqueta2.setFont(new Font("Century Gothic", Font.PLAIN, 10));
            etiqueta2.setBounds(400,735,600,50);
            etiqueta2.setForeground(Color.black);
            etiqueta2.setOpaque(true);
            etiqueta2.setBackground(Color.white);
            panel.add(etiqueta2);
        }
        private void BotonEntrada() {
            JButton be1  = new JButton();
            be1.setOpaque(false);
            be1.setContentAreaFilled(false);
            be1.setBorderPainted(false);
            be1.setBounds(625,580,150,120);
            be1.setEnabled(true);

            be1.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) { //Lo que ativa la función del botón
                    MuseoDentro museo2 = new MuseoDentro();
                    museo2.setVisible(true);


                }
            });
            panel.add(be1);
        }
        public static void main(String[] args) { //Hace que se pueda correr el boton
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Museo museo = new Museo();
                    museo.setVisible(true);
                }
            });
        }

    }
public JPanel panel;
public static String Nombre;
public static int Personas;
public Double Monto;
public static int Piso;
public static Double Costo;
private Tarjeta tarjeta;


    public Museo() {

        setSize(1400,1000);
        setLocation(150,200);
        setTitle("Metropolitan Museum NY");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(200,200));
        Items();
    }

    private void Items(){
        SolicitarContrasena();
        Crearpanel();
        BotonEntrada();

        Entrada();
        EtiquetaEntrada();
        EtiquetaEntrada2();
    }

    public static Icon icono(String ruta, int ancho, int alto) { //Para habilitar las imágenes
        Icon icono_imagen = new ImageIcon(new ImageIcon(Principal.class.getResource(ruta)).getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
        return icono_imagen;
    }

    private void SolicitarContrasena() {
        JPasswordField passw = new JPasswordField(10);
        int result = JOptionPane.showConfirmDialog(null, passw, "Ingrese la contraseña:",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png",50,50));

        if (result == JOptionPane.OK_OPTION) {
            char[] clave = {'M', 'E', 'T', '2', '3'};
            char[] contras = passw.getPassword();

            if (Arrays.equals(contras, clave)) {
                JOptionPane.showMessageDialog(null, "Bienvenido","Contraseña",JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png",50,50));
                Cliente();
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta","Contraseña",JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png",50,50));
                SolicitarContrasena();
            }
        } else {
            System.exit(0);
        }
    }

    private void Crearpanel(){
        panel= new JPanel();
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);

        panel.setLayout(null);
    }

    private void Cliente(){
        do {
            Nombre = JOptionPane.showInputDialog(null, new JLabel("Ingresa el nombre del responsable", icono("/Imag/LOGO.png",50,50), JLabel.LEADING), "Datos de Registro", JOptionPane.PLAIN_MESSAGE);
            if (Nombre == null || Nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nombre inválido", "Datos de Registro", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));}
        }while (Nombre == null || Nombre.trim().isEmpty());




                boolean personasValidas = false;
                while (!personasValidas) {
                    try {
                        String personasStr = JOptionPane.showInputDialog(null, new JLabel(Nombre + ", ingresa el número de personas que ingresarán", icono("/Imag/LOGO.png", 50, 50), JLabel.LEADING), "Datos de Registro", JOptionPane.PLAIN_MESSAGE);
                        if (personasStr == null) {
                            return;
                        }
                        Personas = Integer.parseInt(personasStr);

                        if (Personas >= 1 && Personas <= 6) {
                            personasValidas = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Número de personas inválido. Debe ser entre 1 y 6.", "Datos de Registro", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Dato no válido, favor de ingresar una cantidad de personas válida", "Datos de Registro", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                    }
                }
        String[] op ={"A los 2 pisos, Costo $50 por persona","Solo al piso 1, Costo $30 por persona"};
        Piso = JOptionPane.showOptionDialog(null, "A qué pisos quiere tener acceso?", "Datos de Registro", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icono("/Imag/LOGO.png", 50, 50), op, op[0]);
        MuseoDentro piso;
        piso = new MuseoDentro(Piso);
        Piso1 piso1;
        piso1= new Piso1(Piso);
        Restaurante piso11;
        piso11 = new Restaurante(Piso);

        if(Piso == 1){
            Costo= (double) (Personas*30);
        }else{
            Costo= (double) (Personas*50);
        }

                boolean montoValido = false;
                while (!montoValido) {
                    String montoStr;
                    try {
                        montoStr = JOptionPane.showInputDialog(null, new JLabel(Nombre + ", ingresa el monto con el que deseas ingresar al museo", icono("/Imag/LOGO.png", 50, 50), JLabel.LEADING), "Datos de Registro", JOptionPane.PLAIN_MESSAGE);
                        if (montoStr == null) {
                            return;
                        }
                        Monto = Double.parseDouble(montoStr);

                        if (Monto >= Costo) {
                            montoValido = true;
                            tarjeta = new Tarjeta(Monto);
                            tarjeta.restarCompra(Costo);

                        } else {
                            JOptionPane.showMessageDialog(null, "Monto no suficiente. Debe ser de mínimo $"+Costo+".", "Datos de Registro", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                            montoStr = null;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Dato no válido, favor de ingresar un monto válido", "Datos de Registro", JOptionPane.PLAIN_MESSAGE, icono("/Imag/LOGO.png", 50, 50));
                        montoStr = null;
                    }
                }
            }



private void Entrada() {
    ImageIcon portada = new ImageIcon(getClass().getResource("/Imag/MET2.jpeg"));

    JLabel p1 = new JLabel();

    p1.setBounds(0, 170, 1410, 550);

    p1.setIcon(new ImageIcon(portada.getImage().getScaledInstance(p1.getWidth(), p1.getHeight(), Image.SCALE_SMOOTH)));
    panel.add(p1);
}

    private void EtiquetaEntrada(){
        JLabel etiqueta1 = new JLabel("<html><div style='text-align: center;'>Bienvenido al Museo Metropolitano de NY!<br>De click en la puerta para continuar con la experiencia!</html>", SwingConstants.CENTER);
        etiqueta1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        etiqueta1.setBounds(400,0,600,170);
        etiqueta1.setForeground(Color.black);
        etiqueta1.setOpaque(true);
        etiqueta1.setBackground(Color.white);
        panel.add(etiqueta1);
    }
    private void EtiquetaEntrada2(){
        JLabel etiqueta2 = new JLabel("<html><div style='text-align: center;'>Donde el arte<br>va más allá</html>", SwingConstants.CENTER);
        etiqueta2.setFont(new Font("Century Gothic", Font.PLAIN, 10));
        etiqueta2.setBounds(400,735,600,50);
        etiqueta2.setForeground(Color.black);
        etiqueta2.setOpaque(true);
        etiqueta2.setBackground(Color.white);
        panel.add(etiqueta2);
    }
    private void BotonEntrada() {
        JButton be1  = new JButton();
        be1.setOpaque(false);
        be1.setContentAreaFilled(false);
        be1.setBorderPainted(false);
        be1.setBounds(625,580,150,120);
        be1.setEnabled(true);

        be1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { //Lo que ativa la función del botón
                MuseoDentro museo2 = new MuseoDentro();
                museo2.setVisible(true);


            }
        });
        panel.add(be1);
    }
    public static void main(String[] args) { //Hace que se pueda correr el boton
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Museo museo = new Museo();
                museo.setVisible(true);
            }
        });
    }

}
