package my_project.view;

import javax.swing.*;

public class Veraendern {
    private JPanel mainPanel;
    private JLabel allesL;
    private JTextField wasFeld, wozuFeld;
    private JButton fertigButton;
    private JFrame frame;

    public Veraendern(){
        frame = new JFrame("VERÄNDERN");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);
    }

    public void openVeraendern(int tabelle){
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
