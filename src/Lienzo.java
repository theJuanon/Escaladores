import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Lienzo extends Canvas implements ActionListener {

    private final Timer T;
    private String[] spideys;
    private String background;
    private int ascenso, intento, sub;
    private final int nEscalador;
    private boolean gano;

    Graphics gAux;
    Image backBuffer;

    public Lienzo(int nEscalador) {
        this.setSize(300,720);
        this.nEscalador = nEscalador;
        intento = 0;
        ascenso = getHeight();
        sub = 0;
        setSpideys();
        T = new Timer(175,this);
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
        gAux.drawImage(Rutinas.AjustarImagen(background, this.getWidth(),this.getHeight()).getImage(),0,0,null);
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

        if (sub == spideys.length-1)
            sub = 0;
        else
            sub++;

        repaint();
    }

    private void setSpideys() {
        if (nEscalador % 3 == 0){
            spideys = new String[]{
                    "assets/doppel1.png",
                    "assets/doppel2.png",
                    "assets/doppel3.png",
                    "assets/doppel4.png",
                    "assets/doppel5.png",
                    "assets/doppel6.png"
            };
            background = "assets/fondo3.png";
            return;
        }
        if (nEscalador % 2 == 0){
            spideys = new String[]{
                    "assets/venom1.png",
                    "assets/venom2.png",
                    "assets/venom3.png",
                    "assets/venom4.png",
                    "assets/venom5.png",
                    "assets/venom6.png",
                    "assets/venom7.png"
            };
            background = "assets/fondo2.png";
            return;
        }
        spideys = new String[]{
                "assets/spidey1.png",
                "assets/spidey2.png",
                "assets/spidey3.png",
                "assets/spidey4.png",
                "assets/spidey5.png",
                "assets/spidey6.png",
                "assets/spidey7.png"
        };
        background = "assets/fondo1.png";
    }

    public boolean isGano() {
        return gano;
    }
}
