package Principal;
import javax.swing.*;

import java.awt.*;

public class  Tarjeta {
    public double saldo;

public static double saldo2;

     Tarjeta(double Monto) {
        this.saldo = Monto;
     }
    public static Icon icono(String ruta, int ancho, int alto) { //Para habilitar las imágenes
        Icon icono_imagen = new ImageIcon(new ImageIcon(Principal.class.getResource(ruta)).getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
        return icono_imagen;
    }

    public void restarCompra(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            saldo2=saldo;
            JOptionPane.showMessageDialog(null, "Su compra ha sido exitosa!\nSaldo restante: " + saldo,"Saldo virtual", JOptionPane.DEFAULT_OPTION, icono("/Imag/LOGO.png",50,50));
        } else {
            JOptionPane.showMessageDialog(null, "No ha podido realizar esta compra, no hay fondos suficientes","Saldo virtual", JOptionPane.DEFAULT_OPTION, icono("/Imag/LOGO.png",50,50));
        }
    }
}
