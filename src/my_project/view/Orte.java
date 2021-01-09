package my_project.view;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ViewControll;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Orte extends InteractiveGraphicalObject {
    private int y;
    private int x;
    private int typ;
    private BufferedImage hafen, feind;
    private ViewControll vC;
    
    public Orte(int y, int x, int typ, ViewControll vC){
        this.vC = vC;
        this.y = y;
        this.x = x;
        this.typ = typ;
        setNewImage("Daten/Image/symbol.png");
        hafen = getMyImage();
        setNewImage("Daten/Image/enemy.png");
        feind = getMyImage();
    }


    public void draw(DrawTool drawTool){
        if (typ == 0){
            drawTool.drawImage(hafen, x- hafen.getWidth()/2, y- hafen.getHeight());
        }else{
            drawTool.drawImage(hafen, x- feind.getWidth()/2, y- feind.getHeight());
        }
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

    @Override
    public void mouseClicked(MouseEvent e) {
        double mouseX = e.getX();
        double mouseY = e.getY();
        if (typ == 0){
            if(mouseX > x- hafen.getWidth()/2 && mouseX < x+ hafen.getWidth()/2 && mouseY > y- hafen.getHeight() && mouseY < y){
                //vC.getvS().gibStandortDatenAus(x, y);
            }
        }else{
            if(mouseX > x- feind.getWidth()/2 && mouseX < x+ feind.getWidth()/2 && mouseY > y- feind.getHeight() && mouseY < y){
                //vC.getvS().gibStandortDatenAus(x, y);
            }
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

    public int getMyY() {
        return y;
    }

    public int getMyX() {
        return x;
    }
}
