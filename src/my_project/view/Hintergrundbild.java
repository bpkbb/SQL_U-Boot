package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.image.BufferedImage;

public class Hintergrundbild extends GraphicalObject {

    private BufferedImage myImage;

    public Hintergrundbild(BufferedImage hintergrund){
        myImage = hintergrund;
    }

    public void draw (DrawTool drawTool){
        drawTool.drawImage(myImage,0, 0);

    }
}
