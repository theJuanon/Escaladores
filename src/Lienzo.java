import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Lienzo extends Canvas implements ActionListener {

    private String scenario;
    Timer T;
    int sub;
    //Graphics g;
    Image backBuffer = null;
    String[] spideys = {"spidey1.png","spidey2.png","spidey3.png","spidey4.png","spidey5.png","spidey6.png","spidey7.png","spidey8.png"};
    int ascenso, descenso, intento;

    public Lienzo(String scenario) {
        this.setSize(382,600);
        intento = 0;
        ascenso = getHeight();
        sub = 0;
        this.scenario = scenario;
        T = new Timer(300,this);
        T.start();
    }

    public void paint(Graphics g){
        dibuja();
        g.drawImage(Rutinas.AjustarImagen("fondo2.png",this.getWidth(),this.getHeight()).getImage(),0,0,null);
        g.drawImage(new ImageIcon(spideys[sub]).getImage(), 50, ascenso - 80,null);
    }

    private void dibuja(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( ascenso - 80 <= 0)
            T.stop();

        intento = new Random().nextInt(10);
        if (intento == 0){
            ascenso += new Random().nextInt(10)+10;
            System.out.println(ascenso);
        }else
            ascenso -= new Random().nextInt(30)+20;

        if (sub == 6)
            sub = 0;
        else
            sub++;

        repaint();
    }
}
