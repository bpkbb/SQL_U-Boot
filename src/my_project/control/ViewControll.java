package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.view.Aktionsfenster;
import my_project.view.Startfenster;

public class ViewControll {

    private ViewController vC;
    private Startfenster startfenster;
    private Aktionsfenster aktionsfenster;


    public ViewControll(ViewController vC){
        this.vC = vC;
        startfenster = new Startfenster(vC, this);
        aktionsfenster = new Aktionsfenster(vC, this);
        vC.createScene();
        vC.createScene();
        drawUndRegister();
    }

    private void drawUndRegister(){
        vC.draw(startfenster,0);
        vC.draw(aktionsfenster,1);
    }

    public void starteMusik(int welche){
        if(welche == 1){
            vC.getSoundController().playSound("music01");
            vC.getSoundController().setVolume("music01", 1);
            vC.getSoundController().stopSound("music02");
        }else if (welche == 2){
            vC.getSoundController().playSound("music02");
            vC.getSoundController().setVolume("music02", 1);
            vC.getSoundController().stopSound("music01");
        }else if (welche == 0){
            vC.getSoundController().stopSound("music01");
            vC.getSoundController().stopSound("music02");
        }
    }
}
