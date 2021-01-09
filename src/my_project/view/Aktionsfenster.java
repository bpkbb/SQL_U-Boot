package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import my_project.control.CentralControll;
import my_project.control.ViewControll;

import javax.swing.*;

public class Aktionsfenster extends GraphicalObject implements ButtonUser {

    private ViewControll viewC;
    private Hintergrundbild hintergrund;
    private Button suchen, veraendern, erstellen, einsAusgeben, loeschen, einstellungen;
    private CentralControll centralControll;

    public Aktionsfenster(ViewControll viewC, CentralControll centralControll){
        this.viewC = viewC;
        this.centralControll = centralControll;
        setNewImage("daten/Image/map.jpg");
        hintergrund = new Hintergrundbild(getMyImage());
        suchen = new Button("Suchen",851,0,40,255,255,255,0,this);
        veraendern = new Button("Verändern",851,60,40,255,255,255,1,this);
        erstellen = new Button("Erstellen",851,120,40,255,255,255,2,this);
        einsAusgeben = new Button("Tabelle ausgeben",851,180,40,255,255,255,3,this);
        //loeschen = new Button("Löschen",851,240,40,255,255,255,4,this);
        einstellungen = new Button("Einstellungen",851,560,40,255,255,255,5,this);
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
                    "Wähle eine Tabelle aus",
                    "Tabellenauswahl",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null, //Icon
                    options,
                    options[0]);

            System.out.println(eingabe);
            viewC.oeffneDieViewDazu(buttonNummer,eingabe);
        }else if (buttonNummer == 1){
            int eingabe = JOptionPane.showOptionDialog(
                    null, //Component
                    "Wähle eine Tabelle aus",
                    "Tabellenauswahl",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null, //Icon
                    options,
                    options[0]);

            System.out.println(eingabe);
            viewC.oeffneDieViewDazu(buttonNummer,eingabe);
        }else if (buttonNummer == 2){
            int eingabe = JOptionPane.showOptionDialog(
                    null, //Component
                    "Wähle eine Tabelle aus",
                    "Tabellenauswahl",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null, //Icon
                    options,
                    options[0]);
            System.out.println(eingabe);
            viewC.oeffneDieViewDazu(buttonNummer,eingabe);
        }else if (buttonNummer == 3){
            int eingabe = JOptionPane.showOptionDialog(
                null, //Component
                "Welche Tabelle willst du ausgeben?",
                "Tabellenauswahl",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, //Icon
                options,
                options[0]);
            centralControll.eineTabelleAusgeben(eingabe);
        }else if (buttonNummer == 5){
            String[] optionen = new String[2];
            optionen[0] = "Musik";
            optionen[1] = "Erneut verbinden";
            int tmp = JOptionPane.showOptionDialog(
                    null, //Component
                    "Wähle eine Hintergrundmusik",
                    "Musikauswahl",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null, //Icon
                    optionen,
                    optionen[0] );
            if(tmp == 0){
                String[] musikOptionen = new String[3];
                musikOptionen[0] = "Keine Hintergrundmusik";
                musikOptionen[1] = "01";
                musikOptionen[2] = "02";
                int eingabe = JOptionPane.showOptionDialog(
                        null, //Component
                        "Wähle eine Hintergrundmusik",
                        "Musikauswahl",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null, //Icon
                        musikOptionen,
                        musikOptionen[0] );
                if(eingabe == 0){
                    System.out.println("Du hast keine Musik gewählt");
                    viewC.starteMusik(eingabe);
                }else if(eingabe == 1){
                    System.out.println("Du hast Musik 01 gewählt");
                    viewC.starteMusik(eingabe);
                }else if(eingabe == 2){
                    System.out.println("Du hast Musik 02 gewählt");
                    viewC.starteMusik(eingabe);
                }
            }else if(tmp == 1){
                centralControll.reconnect();
            }
        }
        /*else if (buttonNummer == 4){
            int eingabe = JOptionPane.showOptionDialog(
                null, //Component
                "Welche Tabelle willst du löschen?",
                "Tabellenauswahl",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, //Icon
                options,
                options[0]);
            String id = JOptionPane.showInputDialog(null,"Gib den Primärschlüssel des Objektes an",
                    "Primärschlüsselangabe",
                    JOptionPane.PLAIN_MESSAGE);
            centralControll.loescheObjekt(eingabe,id);
        }*/
    }

    @Override
    public void registriereButtons(ViewController vC) {
        vC.draw(suchen,1);
        vC.draw(veraendern,1);
        vC.draw(erstellen,1);
        vC.draw(einsAusgeben,1);
        vC.draw(einstellungen,1);
        //vC.draw(loeschen,1);
        vC.register(suchen,1);
        vC.register(veraendern,1);
        vC.register(erstellen,1);
        vC.register(einsAusgeben,1);
        vC.register(einstellungen,1);
        //vC.register(loeschen,1);
    }
}
