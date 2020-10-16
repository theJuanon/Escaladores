import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class AppEscaladores extends JFrame implements ActionListener, KeyListener {
    Lienzo lienzo;
    Lienzo[] lienzos;
    JDialog entrada;
    JTextField txtEscaladores;
    JButton btnSubmit;

    public AppEscaladores() {
        super("App Escaladores");
        HazInterfaz();
        HazEscuchas();
    }

    private void HazInterfaz() {
        entrada = new JDialog();
        entrada.setIconImage(new ImageIcon("icon.png").getImage());
        entrada.setSize(200,125);
        entrada.setLocationRelativeTo(null);
        entrada.setLayout(new GridLayout(0,1));
        entrada.add(new JLabel("Numero de escaladores"));
        txtEscaladores = new JTextField();
        entrada.add(txtEscaladores);
        btnSubmit = new JButton("Start");
        entrada.add(btnSubmit);
        entrada.setVisible(true);

        setIconImage(new ImageIcon("icon.png").getImage());
        setSize(600,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,3));

    }
    private void HazEscuchas() {
        txtEscaladores.addKeyListener(this);
        txtEscaladores.addActionListener(this);
        btnSubmit.addActionListener(this);
    }
    public static void main(String [] a) {
        new AppEscaladores();

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnSubmit){
            if (txtEscaladores.getText().length() == 0){
                JOptionPane.showConfirmDialog(null,"Se requiere numero de escaladores","Numero de Escaladores",JOptionPane.DEFAULT_OPTION);
                return;
            }
            int nEsc = Integer.parseInt(txtEscaladores.getText());
            lienzos = new Lienzo[nEsc];

            for (int i = 0; i<lienzos.length; i++){
                lienzos[i] = new Lienzo("");
                add(lienzos[i]);
            }
            setVisible(true);
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getKeyChar() < '0' || evt.getKeyChar() > '9')
            evt.consume();
    }

    @Override
    public void keyPressed(KeyEvent evt) {

    }

    @Override
    public void keyReleased(KeyEvent evt) {

    }
}
