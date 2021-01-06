package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.view.*;

public class ViewControll {

    private ViewController vC;
    private CentralControll centralControll;
    private Startfenster startfenster;
    private Aktionsfenster aktionsfenster;
    private Suchen suchenFenster;
    private Erstellen erstellenFenster;
    private Veraendern veraendernFenster;


    public ViewControll(ViewController vC, CentralControll centralControll){
        this.vC = vC;
        this.centralControll = centralControll;
        startfenster = new Startfenster(vC, this);
        aktionsfenster = new Aktionsfenster(this, centralControll);
        suchenFenster = new Suchen(centralControll);
        erstellenFenster = new Erstellen(centralControll);
        veraendernFenster = new Veraendern(centralControll);
        vC.createScene();
        vC.createScene();
        drawUndRegister();
    }

    private void drawUndRegister(){
        vC.draw(startfenster,0);
        vC.draw(aktionsfenster,1);
        aktionsfenster.registriereButtons(vC);
    }

    public void starteMusik(int welche){
        if(welche == 1){
            vC.getSoundController().playSound("music01");
            vC.getSoundController().setVolume("music01", 1);
            vC.getSoundController().stopSound("music02");
            vC.getSoundController().stopSound("begin");
        }else if (welche == 2){
            vC.getSoundController().playSound("music02");
            vC.getSoundController().setVolume("music02", 1);
            vC.getSoundController().stopSound("music01");
            vC.getSoundController().stopSound("begin");
        }else if (welche == 0){
            vC.getSoundController().stopSound("music01");
            vC.getSoundController().stopSound("music02");
            vC.getSoundController().stopSound("begin");
        }
    }

    /**
     * buttonNr = 0 ist suchen
     * buttonNr = 1 ist verändern
     * buttonNr = 3 ist erstellen
     * tabelle = 0 ist Hafen
     * tabelle = 1 ist U-Boot
     * tabelle = 2 ist Person
     * tabelle = 3 ist Mission
     * tabelle = 4 ist Feind
     * tabelle = 5 ist Typen
     */
    public void oeffneDieViewDazu(int buttonNr, int tabelle){
        if (buttonNr == 0){
            suchenFenster.openSuchen(tabelle);
        }else if (buttonNr == 1){
            veraendernFenster.openVeraendern(tabelle);
        }else if (buttonNr == 2){
            erstellenFenster.openErstellen(tabelle);
        }
    }
}
