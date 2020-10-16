import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lienzo extends Canvas implements ActionListener {

    private String scenario;
    Timer T;
    int sub;
    Graphics g;

    public Lienzo(String scenario) {
        this.setSize(100,500);
        sub = 0;
        this.scenario = scenario;
        T = new Timer(300,this);
        T.start();
    }

    public void paint(Graphics g){
        dibuja();
        g.drawImage(Rutinas.AjustarImagen("fondo2.png",this.getWidth(),this.getHeight()).getImage(),0,0,null);
        g.drawImage(new ImageIcon("spidey1.png").getImage(), 50,500,null);
    }

    private void dibuja(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
