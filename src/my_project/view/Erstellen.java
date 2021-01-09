package my_project.view;

import my_project.control.CentralControll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Erstellen {
    private JPanel mainPanel, booPanel, pSpezPanel, extraPanel, nutzPanel;
    private JTextField idTypFeld, nachnameFeld, textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, nameFeld;
    private JLabel idTypL, nameL, nachnameL, label01, label02, label03, label04, label05, label06, label07, label08, booL;
    private JButton jaButton, neinButton, fertigButton;
    private JTextField textField9;
    private JPanel bzhP;
    private JFrame frame;
    private String boo;
    private int tabelle;
    private CentralControll centralControll;

    public Erstellen(CentralControll centralControll){
        frame = new JFrame("ERSTELLEN");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);
        this.centralControll = centralControll;
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
        fertigButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                erstelleDatensatz();
                frame.dispose();
            }
        });
    }

    public void openErstellen(int tabelle){
        this.tabelle = tabelle;
        frame.setVisible(true);
        nutzPanel.setVisible(true);
        extraPanel.setVisible(true);
        idTypFeld.setText("");
        nameFeld.setText("");
        nachnameFeld.setText("");
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
        textField8.setText("");
        textField9.setText("");
        jaButton.setBackground(Color.WHITE);
        neinButton.setBackground(Color.WHITE);
        if (tabelle == 0){
            pSpezPanel.setVisible(false);
            booPanel.setVisible(true);
            bzhP.setVisible(false);
            idTypL.setText("ID:");
            nameL.setText("Name:");
            nachnameL.setText("Land:");
            label01.setText("Koordinate01:");
            label02.setText("Koordinate02:");
            label03.setText("");
            label04.setText("");
            textField2.setVisible(false);
            textField3.setVisible(false);
            textField4.setVisible(true);
            booL.setText("Bespaßung?");
        }else if (tabelle == 1){
            pSpezPanel.setVisible(false);
            booPanel.setVisible(true);
            bzhP.setVisible(false);
            idTypL.setText("Kennnummer:");
            nameL.setText("Hafen:");
            nachnameL.setText("Typ:");
            label01.setText("Koordinate01:");
            label02.setText("Koordinate02:");
            label03.setText("Mission:");
            label04.setText("");
            textField2.setVisible(true);
            textField3.setVisible(false);
            textField4.setVisible(true);
            booL.setText("Verschollen?");
        }else if (tabelle == 2){
            pSpezPanel.setVisible(true);
            booPanel.setVisible(true);
            bzhP.setVisible(false);
            idTypL.setText("PersonenID:");
            nameL.setText("Vorname:");
            nachnameL.setText("Nachname:");
            label01.setText("U-Bootnummer:");
            label02.setText("Alter:");
            label03.setText("Geschlecht:");
            label04.setText("Geburtstag:");
            label05.setText("Land:");
            label06.setText("Straße:");
            label07.setText("Hausnummer:");
            label08.setText("Postleitzahl:");
            textField2.setVisible(true);
            textField3.setVisible(true);
            textField4.setVisible(true);
            booL.setText("Aktiv?");
        }else if (tabelle == 3){
            pSpezPanel.setVisible(false);
            booPanel.setVisible(false);
            bzhP.setVisible(true);
            idTypL.setText("MissionsID:");
            nameL.setText("Codename:");
            nachnameL.setText("Beschreibung:");
            label01.setText("Status:");
            label02.setText("ChefId:");
            label03.setText("");
            label04.setText("");
            textField2.setVisible(false);
            textField3.setVisible(false);
            textField4.setVisible(true);
        }else if (tabelle == 4){
            pSpezPanel.setVisible(false);
            booPanel.setVisible(false);
            bzhP.setVisible(false);
            idTypL.setText("FeindID:");
            nameL.setText("Name:");
            nachnameL.setText("Zentraler Standort:");
            label01.setText("Koordinate01:");
            label02.setText("Koordinate02:");
            label03.setText("Grund:");
            label04.setText("Stärke:");
            textField2.setVisible(true);
            textField3.setVisible(true);
            textField4.setVisible(true);
        }else if (tabelle == 5){
            pSpezPanel.setVisible(false);
            booPanel.setVisible(false);
            bzhP.setVisible(false);
            idTypL.setText("Typ:");
            nameL.setText("PS:");
            nachnameL.setText("Größe:");
            label01.setText("Maximale Personenanzahl:");
            label02.setText("");
            label03.setText("");
            label04.setText("");
            textField4.setVisible(false);
            textField2.setVisible(false);
            textField3.setVisible(false);
        }
    }

    private void erstelleDatensatz(){
        if (tabelle == 0){
            centralControll.datensatzErstellen(tabelle,idTypFeld.getText(),nameFeld.getText(),nachnameFeld.getText(),textField1.getText(),textField4.getText(),boo,null,null,null,null,null,null,null);
        }else if(tabelle == 1){
            centralControll.datensatzErstellen(tabelle,idTypFeld.getText(),nameFeld.getText(),nachnameFeld.getText(),boo,textField2.getText(),textField1.getText(),textField4.getText(),null,null,null,null,null,null);
        }else if(tabelle == 2){
            centralControll.datensatzErstellen(tabelle,idTypFeld.getText(),nameFeld.getText(),nachnameFeld.getText(),textField1.getText(),textField4.getText(),textField2.getText(),textField3.getText(), boo, textField5.getText(), textField7.getText(),textField6.getText(),textField8.getText(),null);
        }else if(tabelle == 3){
            centralControll.datensatzErstellen(tabelle,idTypFeld.getText(),nameFeld.getText(),nachnameFeld.getText(),textField1.getText(),textField4.getText(),null,null,null,null,null,null,null, createStrings());
        }else if(tabelle == 4){
            centralControll.datensatzErstellen(tabelle,idTypFeld.getText(),nameFeld.getText(),nachnameFeld.getText(),textField1.getText(),textField4.getText(),textField2.getText(),textField3.getText(),null,null,null,null,null,null);
        }else if(tabelle == 5){
            centralControll.datensatzErstellen(tabelle,idTypFeld.getText(),nameFeld.getText(),nachnameFeld.getText(),textField1.getText(),null,null,null,null,null,null,null,null,null);
        }
    }

    private String[] createStrings(){
        String[] tmp = textField9.getText().split(";");
        return tmp;
    }
}
