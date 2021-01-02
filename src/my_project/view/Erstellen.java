package my_project.view;

import javax.swing.*;

public class Erstellen {
    private JPanel mainPanel, booPanel, pSpezPanel, extraPanel, nutzPanel;
    private JTextField idTypFeld, nachnameFeld, textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, nameFeld;
    private JLabel idTypL, nameL, nachnameL;
    private JButton jaButton, neinButton, fertigButton;
    private JFrame frame;

    public Erstellen(){
        frame = new JFrame("ERSTELLEN");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);
    }

    public void openErstellen(int tabelle){
        frame.setVisible(true);
        if (tabelle == 0){

        }else if (tabelle == 1){

        }else if (tabelle == 2){

        }else if (tabelle == 23){

        }else if (tabelle == 4){

        }else if (tabelle == 5){

        }
    }
}
