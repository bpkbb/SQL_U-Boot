package my_project.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ausgabenformatierung {
    private JPanel mainPanel;
    private JButton finishButton;
    private JTable table2;
    private JFrame frame;

    public Ausgabenformatierung(String[][] rueckgabe){
        frame = new JFrame("Ergebnis der Anfrage");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        final DefaultTableModel model = new DefaultTableModel();

        // Die Titel der Spalten setzen
        model.setColumnIdentifiers(rueckgabe[0]);

        for( int i = 0; i < rueckgabe.length; i++ ){
            Object[] row = new Object[ model.getColumnCount() ];
            for( int j = 0; j < row.length; j++ ){
                row[j] = rueckgabe[i][j];
            }
            model.addRow( row );
        }
        table2.setModel(model);

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
