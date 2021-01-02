package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.view.*;

public class ViewControll {

    private ViewController vC;
    private Startfenster startfenster;
    private Aktionsfenster aktionsfenster;
    private Suchen suchenFenster;
    private Erstellen erstellenFenster;
    private Veraendern veraendernFenster;


    public ViewControll(ViewController vC){
        this.vC = vC;
        startfenster = new Startfenster(vC, this);
        aktionsfenster = new Aktionsfenster(vC, this);
        suchenFenster = new Suchen();
        erstellenFenster = new Erstellen();
        veraendernFenster = new Veraendern();
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
        }else if (welche == 2){
            vC.getSoundController().playSound("music02");
            vC.getSoundController().setVolume("music02", 1);
            vC.getSoundController().stopSound("music01");
        }else if (welche == 0){
            vC.getSoundController().stopSound("music01");
            vC.getSoundController().stopSound("music02");
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
            if (tabelle == 0){
                suchenFenster.openSuchen(tabelle);
            }else if (tabelle == 1){
                suchenFenster.openSuchen(tabelle);
            }else if (tabelle == 2){
                suchenFenster.openSuchen(tabelle);
            }else if (tabelle == 3){
                suchenFenster.openSuchen(tabelle);
            }else if (tabelle == 4){
                suchenFenster.openSuchen(tabelle);
            }else if (tabelle == 5){
                suchenFenster.openSuchen(tabelle);
            }
        }else if (buttonNr == 1){
            if (tabelle == 0){
                veraendernFenster.openVeraendern(tabelle);
            }else if (tabelle == 1){
                veraendernFenster.openVeraendern(tabelle);
            }else if (tabelle == 2){
                veraendernFenster.openVeraendern(tabelle);
            }else if (tabelle == 3){
                veraendernFenster.openVeraendern(tabelle);
            }else if (tabelle == 4){
                veraendernFenster.openVeraendern(tabelle);
            }else if (tabelle == 5){
                veraendernFenster.openVeraendern(tabelle);
            }
        }else{
            if (tabelle == 0){
                erstellenFenster.openErstellen(tabelle);
            }else if (tabelle == 1){
                erstellenFenster.openErstellen(tabelle);
            }else if (tabelle == 2){
                erstellenFenster.openErstellen(tabelle);
            }else if (tabelle == 3){
                erstellenFenster.openErstellen(tabelle);
            }else if (tabelle == 4){
                erstellenFenster.openErstellen(tabelle);
            }else if (tabelle == 5){
                erstellenFenster.openErstellen(tabelle);
            }
        }
    }
}
