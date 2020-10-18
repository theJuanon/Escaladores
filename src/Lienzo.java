import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Lienzo extends Canvas implements ActionListener {

    //private String scenario;
    private Timer T;
    private String[] spideys = {"spidey1.png","spidey2.png","spidey3.png","spidey4.png","spidey5.png","spidey6.png","spidey7.png"};
    private int ascenso, descenso, intento, sub, nEscalador;
    private boolean gano;
    Graphics gAux;
    Image backBuffer;

    public Lienzo(int nEscalador) {
        this.setSize(300,720);
        this.nEscalador = nEscalador;
        intento = 0;
        ascenso = getHeight();
        sub = 0;
        T = new Timer(200,this);
        T.start();
    }

    public void update(Graphics g){
        paint(g);
    }

    public void paint(Graphics g){
        if (backBuffer == null){
            backBuffer = createImage(getWidth(), getHeight());
            gAux = backBuffer.getGraphics();
        }
        gAux.drawImage(Rutinas.AjustarImagen("fondo2.png",this.getWidth(),this.getHeight()).getImage(),0,0,null);
        gAux.drawImage(new ImageIcon(spideys[sub]).getImage(), 100, ascenso - 110,null);
        g.drawImage(backBuffer, 0,0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ascenso - 80 <= 0){
            T.stop();
            gano = true;
        }

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

    public boolean isGano() {
        return gano;
    }
}
