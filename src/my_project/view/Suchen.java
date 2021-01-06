package my_project.view;

import KAGO_framework.model.abitur.datenstrukturen.Queue;
import my_project.control.CentralControll;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Suchen {
    private JPanel mainPanel, nutzPanel, booPanel;
    private JLabel label01, label02, label03, label04, booL;
    private JTextField feld03, feld04, feld01, feld02;
    private JButton jaButton, neinButton, suchenButton;
    private JFrame frame;
    private CentralControll centralControll;
    int tabelle, anzahl;
    private String boo;

    public Suchen(CentralControll centralControll){
        this.centralControll = centralControll;
        frame = new JFrame("Suchen");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);
        jaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jaButton.setBackground(Color.RED);
                neinButton.setBackground(Color.WHITE);
                boo = "true";
            }
        });
        neinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                neinButton.setBackground(Color.RED);
                jaButton.setBackground(Color.WHITE);
                boo = "false";
            }
        });
        suchenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countSuchparameter();
                String[] attribute = suchParameterAusgeben();
                centralControll.sucheObjekt(tabelle, anzahl, attribute[0],attribute[1],attribute[2],attribute[3],attribute[4],attribute[5],attribute[6],attribute[7],attribute[8],attribute[9]);
                frame.dispose();
            }
        });
    }

    public void openSuchen(int tabelle){
        this.tabelle = tabelle;
        frame.setVisible(true);
        boo = "";
        feld01.setText("");
        feld02.setText("");
        feld03.setText("");
        feld04.setText("");
        jaButton.setBackground(Color.WHITE);
        neinButton.setBackground(Color.WHITE);
        if (tabelle == 0){
            booPanel.setVisible(true);
            label01.setText("Name");
            label02.setText("Land");
            label03.setText("Koordinate01");
            label04.setText("Koordinate02");
            booL.setText("Bespaßung");
        }else if (tabelle == 1){
            booPanel.setVisible(true);
            label01.setText("Hafen");
            label02.setText("Typ");
            label03.setText("Mission");
            label04.setText("Koordinate01");
            booL.setText("Verschollen");
        }else if (tabelle == 2){
            booPanel.setVisible(true);
            label01.setText("UBootNummer");
            label02.setText("Age");
            label03.setText("Geschlecht");
            label04.setText("Land");
            booL.setText("Aktiv");
        }else if (tabelle == 3){
            booPanel.setVisible(false);
            label01.setText("Codename");
            label02.setText("Beschreibung");
            label03.setText("Status");
            label04.setText("ChefID");
        }else if (tabelle == 4){
            booPanel.setVisible(false);
            label01.setText("Name");
            label02.setText("zStandort");
            label03.setText("Grund");
            label04.setText("Stärke");
        }else if (tabelle == 5){
            booPanel.setVisible(false);
            label01.setText("Typ");
            label02.setText("PS");
            label03.setText("Größe");
            label04.setText("maxPersonen");
        }
    }

    private void countSuchparameter(){
        anzahl = 0;
        if(!feld01.getText().equals("")){
            anzahl++;
        }
        if(!feld02.getText().equals("")){
            anzahl++;
        }
        if(!feld03.getText().equals("")){
            anzahl++;
        }
        if(!feld04.getText().equals("")){
            anzahl++;
        }
        if(!boo.equals("")){
            anzahl++;
        }
        System.out.println("Anzahl Suchattribute: " + anzahl);
    }

    private String[] suchParameterAusgeben(){
        String zwischenResultat = "";
        if(!feld01.getText().equals("")){
            zwischenResultat = zwischenResultat + "§" + label01.getText() + "§'" + feld01.getText() + "'";
        }
        if(!feld02.getText().equals("")){
            zwischenResultat = zwischenResultat + "§" + label02.getText() + "§'" + feld02.getText() + "'";
        }
        if(!feld03.getText().equals("")){
            zwischenResultat = zwischenResultat + "§" + label03.getText() + "§'" + feld03.getText() + "'";
        }
        if(!feld04.getText().equals("")){
            zwischenResultat = zwischenResultat + "§" + label04.getText() + "§'" + feld04.getText() + "'";
        }
        if(!boo.equals("")){
            zwischenResultat = zwischenResultat + "§" + booL.getText() + "§" + boo;
        }
        String[] result = zwischenResultat.split("§");
        System.out.println(zwischenResultat);
        Queue<String> tmp = new Queue<>();
        for (int i = 1; i< result.length; i++){
            tmp.enqueue(result[i]);
        }
        String[] tmpS = new String[10];
        int i = 0;
        while (!tmp.isEmpty()){
            tmpS[i] = tmp.front();
            i++;
            tmp.dequeue();
        }
        return tmpS;

    }
}
