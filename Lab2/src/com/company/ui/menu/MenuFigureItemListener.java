package com.company.ui.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//Class for generating a shape-specific form asking for required data
public class MenuFigureItemListener {

    Frame f;
    JButton okButton;
    List<JTextField> textFields;

    public void createFields(String name, List<String> fieldNames){
        f = new JFrame(name);
        //set size and location of frame
        f.setSize(330, 300);
        f.setLocation(100, 50);
        ((JFrame) f).setDefaultLookAndFeelDecorated(true);

        int yPos = 25;
        textFields = new ArrayList<>();

        for (String field: fieldNames){
            JLabel label = new JLabel(field);
            label.setBounds(50, yPos, 300, 30);

            JTextField textField = new JTextField(20);
            textField.setBounds(50, yPos + 23, 200, 20);
            yPos += 35;

            f.add(label);
            f.add(textField);

            textFields.add(textField);
        }

        okButton = new JButton("Draw");
        okButton.setBounds(85, yPos+20,75,25);
        f.add(okButton);
        f.setLayout(null);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                buttonListener();
            }
        });
        f.setVisible(true);
    }

    public void buttonListener(){ }
}
