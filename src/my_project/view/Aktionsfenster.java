package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import my_project.control.ViewControll;

import javax.swing.*;

public class Aktionsfenster extends GraphicalObject implements ButtonUser {

    private ViewControll viewC;
    private Hintergrundbild hintergrund;
    private Button suchen, veraendern, erstellen;

    public Aktionsfenster(ViewController vC, ViewControll viewC){
        this.viewC = viewC;
        setNewImage("daten/Image/map.jpg");
        hintergrund = new Hintergrundbild(getMyImage());
        suchen = new Button("Suchen",851,0,50,149,255,255,255,0,this);
        veraendern = new Button("Verändern",851,60,50,149,255,255,255,1,this);
        erstellen = new Button("Erstellen",851,120,50,149,255,255,255,2,this);
    }

    @Override
    public void buttoneffect(int buttonNummer) {
        String[] options = new String[6];
        options[0] = "Hafen";
        options[1] = "U-Boot";
        options[2] = "Person";
        options[3] = "Mission";
        options[4] = "Feind";
        options[5] = "Typen";
        if (buttonNummer == 0){
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
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }else if (eingabe == 1){
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }else if (eingabe == 2){
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }else if (eingabe == 3){
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }else if (eingabe == 4){
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }else{
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }
        }else if (buttonNummer == 1){
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
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }else if (eingabe == 1){
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }else if (eingabe == 2){
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }else if (eingabe == 3){
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }else if (eingabe == 4){
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }else{
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }
        }else if (buttonNummer == 3){
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
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }else if (eingabe == 1){
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }else if (eingabe == 2){
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }else if (eingabe == 3){
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }else if (eingabe == 4){
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }else{
                System.out.println(eingabe);
                viewC.oeffneDieViewDazu(buttonNummer,eingabe);
            }
        }
    }

    @Override
    public void registriereButtons(ViewController vC) {
        System.out.println("MOIN");
        vC.draw(suchen,1);
        vC.draw(veraendern,1);
        vC.draw(erstellen,1);
        vC.register(suchen,1);
        vC.register(veraendern,1);
        vC.register(erstellen,1);
    }
}
