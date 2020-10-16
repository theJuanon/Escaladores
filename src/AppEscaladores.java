import javax.swing.*;
import java.awt.*;

public class AppEscaladores extends JFrame {
    Lienzo lienzo;
    Lienzo[] lienzos;

    public AppEscaladores() {
        super("App Escaladores");
        HazInterfaz();
        HazEscuchas();
    }

    private void HazInterfaz() {
        setIconImage(new ImageIcon("icon.png").getImage());
        setSize(600,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,3));
        lienzo = new Lienzo("");

        lienzos = new Lienzo[]{new Lienzo(""), new Lienzo(""), new Lienzo(""), new Lienzo("")};
        for (int i = 0; i<lienzos.length; i++)
            add(lienzos[i]);
        setVisible(true);
    }
    private void HazEscuchas() {

    }
    public static void main(String [] a) {
        new AppEscaladores();

    }
}
