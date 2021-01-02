package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import my_project.control.ViewControll;

import javax.swing.*;

public class Aktionsfenster extends GraphicalObject implements ButtonUser {

    private ViewControll viewC;
    private Hintergrundbild hintergrund;
    private Button hafen, uBoote, person, mission, feinde, typ;

    public Aktionsfenster(ViewController vC, ViewControll viewC){
        this.viewC = viewC;
        setNewImage("daten/Image/map.jpg");
        hintergrund = new Hintergrundbild(getMyImage());
        hafen = new Button("Hafen",851,0,50,149,255,255,255,0,this);
        uBoote = new Button("U-Boot",851,60,50,149,255,255,255,1,this);
        person = new Button("Person",851,120,50,149,255,255,255,2,this);
        mission = new Button("Mission",851,180,50,149,255,255,255,3,this);
        feinde = new Button("Feind",851,240,50,149,255,255,255,4,this);
        typ =  new Button("Typ",851,300,50,149,255,255,255,5,this);
        registriereButtons(vC);
    }

    @Override
    public void buttoneffect(int buttonNummer) {
        if (buttonNummer == 0){
            String[] options = new String[6];
            options[0] = "Hafen";
            options[1] = "U-Boot";
            options[2] = "Person";
            options[3] = "Mission";
            options[4] = "Feind";
            options[5] = "Typen";
            int eingabe = JOptionPane.showOptionDialog(
                    null, //Component
                    "Möchtest du noch eine Runde spielen?",
                    "Weiter/Raus",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null, //Icon
                    options,
                    options[0]);
            if(eingabe == 0){
                System.out.println("TADA");
            }else{

            }
        }
    }

    @Override
    public void registriereButtons(ViewController vC) {
        System.out.println("MOIN");
        vC.draw(hafen,1);
        vC.draw(uBoote,1);
        vC.draw(person,1);
        vC.draw(mission,1);
        vC.draw(feinde,1);
        vC.draw(typ,1);
        vC.register(hafen,1);
        vC.register(uBoote,1);
        vC.register(person,1);
        vC.register(mission,1);
        vC.register(feinde,1);
        vC.register(typ,1);
    }
}
