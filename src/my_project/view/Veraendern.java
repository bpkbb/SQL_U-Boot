package my_project.view;

import my_project.control.CentralControll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Veraendern {
    private JPanel mainPanel;
    private JLabel allesL;
    private JTextField wasFeld, wozuFeld, idFeld;
    private JButton fertigButton;
    private JFrame frame;
    private CentralControll centralControll;
    private int tabelle;

    public Veraendern(CentralControll centralControll){
        this.centralControll = centralControll;
        frame = new JFrame("VERÄNDERN");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);
        fertigButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (wasFeld.getText().equals("Land") || wasFeld.getText().equals("Koordinate01") || wasFeld.getText().equals("Koordinate02") || wasFeld.getText().equals("zStandort")){
                    JOptionPane.showMessageDialog(null,"Diese Eingabe wird nicht unterstützt");
                }else {
                    if (wasFeld.getText().equals("Bespaßung") || wasFeld.getText().equals("Verschollen") || wasFeld.getText().equals("Aktiv")){
                        centralControll.veraendereObjekt(tabelle,wasFeld.getText(),wozuFeld.getText(),idFeld.getText());
                    }else{
                        centralControll.veraendereObjekt(tabelle,wasFeld.getText(),"'"+wozuFeld.getText()+"'",idFeld.getText());
                    }
                }
                frame.dispose();
            }
        });
    }

    public void openVeraendern(int tabelle){
        frame.setVisible(true);
        wasFeld.setText("");
        wozuFeld.setText("");
        idFeld.setText("");
        this.tabelle = tabelle;
        if (tabelle == 0){
            allesL.setText("Mögliche Attribute: ID, Name und Bespaßung");
        }else if (tabelle == 1){
            allesL.setText("Mögliche Attribute: Kennnummer, Hafen, Typ, Verschollen und Mission");
        }else if (tabelle == 2){
            allesL.setText("Mögliche Attribute: ID, Vorname, Nachname, UBootnummer, Age, Geschlecht, Geburtstag, Aktiv, Land, Straße, Hausnummer und PLZ");
        }else if (tabelle == 3){
            allesL.setText("Mögliche Attribute: ID, Codename, Beschreibung, Status und ChefID");
        }else if (tabelle == 4){
            allesL.setText("Mögliche Attribute: ID, Name, Grund und Stärke");
        }else if (tabelle == 5){
            allesL.setText("Mögliche Attribute: Typ, PS, Größe und maxpersonen");
        }
    }
}
