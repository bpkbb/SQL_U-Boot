package my_project.view;

import javax.swing.*;

public class Suchen {
    private JPanel mainPanel, nutzPanel,extraPanel, pSpezPanel, booPanel;
    private JLabel idTypL, nameL, nachnameL;
    private JTextField nameFeld, nachnameFeld, idTypFeld, textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8;
    private JButton jaButton, neinButton, suchenButton;
    private JFrame frame;

    public Suchen(){
        frame = new JFrame("Suchen");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);
    }

    public void openSuchen(int tabelle){
        frame.setVisible(true);
        nutzPanel.setVisible(true);
        if (tabelle == 0){
            extraPanel.setVisible(true);
            pSpezPanel.setVisible(false);
            booPanel.setVisible(true);
        }else if (tabelle == 1){
            extraPanel.setVisible(true);
            pSpezPanel.setVisible(false);
            booPanel.setVisible(true);
        }else if (tabelle == 2){
            extraPanel.setVisible(true);
            pSpezPanel.setVisible(true);
            booPanel.setVisible(true);
        }else if (tabelle == 3){
            extraPanel.setVisible(true);
            pSpezPanel.setVisible(false);
            booPanel.setVisible(false);
        }else if (tabelle == 4){
            extraPanel.setVisible(true);
            pSpezPanel.setVisible(false);
            booPanel.setVisible(false);
        }else if (tabelle == 5){
            extraPanel.setVisible(true);
            pSpezPanel.setVisible(false);
            booPanel.setVisible(false);
        }
    }
}
