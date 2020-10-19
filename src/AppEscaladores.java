import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class AppEscaladores extends JFrame implements ActionListener, KeyListener {
    Lienzo[] lienzos;
    JDialog entrada;
    JTextField txtEscaladores;
    JButton btnSubmit;
    Timer Tgano;

    public AppEscaladores() {
        super("App Escaladores");
        HazInterfaz();
        HazEscuchas();
    }

    private void HazInterfaz() {
        entrada = new JDialog();
        entrada.setIconImage(new ImageIcon("assets/icon.png").getImage());
        entrada.setSize(200,125);
        entrada.setLocationRelativeTo(null);
        entrada.setLayout(new GridLayout(0,1));
        entrada.add(new JLabel("Numero de escaladores"));
        txtEscaladores = new JTextField();
        entrada.add(txtEscaladores);
        btnSubmit = new JButton("Start");
        entrada.add(btnSubmit);
        entrada.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        entrada.setVisible(true);
        Tgano = new Timer(175,this);

        setIconImage(new ImageIcon("icon.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,0));
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
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showConfirmDialog(null,"Se requiere numero de escaladores","Numero de Escaladores",JOptionPane.DEFAULT_OPTION);
                return;
            }

            int nEsc = Integer.parseInt(txtEscaladores.getText());
            lienzos = new Lienzo[nEsc];

            if (nEsc <= 5)
                setSize(300*nEsc,720);
            else
                setSize(300*5,720);
            setLocationRelativeTo(null);

            for (int i = 0; i < lienzos.length; i++){
                lienzos[i] = new Lienzo(i+1);
                add(lienzos[i]);
            }
            setVisible(true);
            Tgano.start();
            return;
        }

        if (evt.getSource() == Tgano){
            for (int i = 0; i < lienzos.length; i++){
                if (lienzos[i].isGano()){
                    JOptionPane.showMessageDialog(null,"Ganó escalador "+(i+1), "GANADOR",JOptionPane.INFORMATION_MESSAGE);
                    Tgano.stop();
                    return;
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (txtEscaladores.getText().length() == 0 && evt.getKeyChar() == '0'){
            evt.consume();
            return;
        }
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
