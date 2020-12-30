package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.view.Startfenster;

public class ViewControll {

    private ViewController vC;
    private Startfenster startfenster;


    public ViewControll(ViewController vC){
        this.vC = vC;
        startfenster = new Startfenster(vC);
        vC.createScene();
        vC.createScene();
        drawUndRegister();
    }

    private void drawUndRegister(){
        vC.draw(startfenster,0);
    }
}
