package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Button extends InteractiveGraphicalObject {

    private BufferedImage myImage;
    private double x;
    private double y;
    private int breite;
    private int hoehe;
    private String text;
    private int buttonNummer;
    private ButtonUser myUser;
    private int[] farbe;
    private int schriftgroesse;
    private int schriftX;
    private int schriftY;


    public Button(String text,double x, double y, int hoehe, int breite, int schriftgroesse, int schriftX, int schriftY,  int r, int g, int b, int buttonNr, ButtonUser user){
        myUser = user;
        buttonNummer = buttonNr;
        this.x = x;
        this.y = y;
        this.text = text;
        this.hoehe = hoehe;
        this.breite = breite;
        farbe = new int[3];
        farbe[0] = r;
        farbe[1] = g;
        farbe[2] = b;
        this.schriftgroesse = schriftgroesse;
        this.schriftX = schriftX;
        this.schriftY = schriftY;
    }

    public Button(String text, double x, double y, int groesse, int r, int g, int b, int buttonNr, ButtonUser user){
        myUser = user;
        buttonNummer = buttonNr;
        this.x = x;
        this.y = y;
        this.text = text;
        this.hoehe = groesse;
        this.breite = text.length()*(groesse-2)*3/5+15;
        farbe = new int[3];
        farbe[0] = r;
        farbe[1] = g;
        farbe[2] = b;
    }

    public Button(double x, double y, BufferedImage buttonBild, int buttonNr, ButtonUser user){
        text = "";
        myUser = user;
        buttonNummer = buttonNr;
        this.x = x;
        this.y = y;
        myImage = buttonBild;
        this.hoehe = myImage.getHeight();
        this.breite = myImage.getWidth();
    }


    @Override
    public void keyPressed(int key) {

    }

    @Override
    public void keyReleased(int key) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    public void draw(DrawTool drawTool){
        if(text.equals("")){
            drawTool.drawImage(myImage, x, y);
        }else if(schriftgroesse != 0) {
            drawTool.setCurrentColor(100,100,100, 255);
            drawTool.formatText("Courier New", 0, schriftgroesse);
            drawTool.drawFilledRectangle(x, y, breite, hoehe);
            drawTool.setCurrentColor(farbe[0], farbe[1], farbe[2], 255);
            drawTool.drawText(schriftX, schriftY, text);
        }else{
            drawTool.setCurrentColor(100,100,100, 255);
            drawTool.formatText("Courier New", 0, (int) hoehe - 2);
            drawTool.drawFilledRectangle(x, y, breite, hoehe);
            drawTool.setCurrentColor(farbe[0], farbe[1], farbe[2], 255);
            drawTool.drawText(x + 7.5, y + (hoehe - 2) - 8, text);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        double mouseX = e.getX();
        double mouseY = e.getY();
        if(mouseX > x && mouseX < x+breite && mouseY > y && mouseY < y+hoehe){
            myUser.buttoneffect(buttonNummer);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
}
