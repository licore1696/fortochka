import reader.*;
import writer.*;
import java.util.*;
import Calc.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainUI extends JFrame {

    private JLabel fileNameLabel;
    private JTextField fileNameField;
    private JLabel encryptionLabel;
    private JTextField encryptionField;
    private JLabel keyLabel;
    private JTextField keyField;
    private JButton processButton;
    private JLabel outputFileLabel;
    private JTextField outputFileField;
    private JButton saveButton;
    private JLabel compressLabel;
    private JTextField compressField;
    private JButton compressButton;

    public MainUI() {
        setTitle("File Processor");
        setLayout(new GridLayout(6, 2, 10, 10));

        fileNameLabel = new JLabel("Enter file name: ");
        add(fileNameLabel);

        fileNameField = new JTextField();
        add(fileNameField);

        encryptionLabel = new JLabel("File encrypted? (y/n)");
        add(encryptionLabel);

        encryptionField = new JTextField();
        add(encryptionField);

        keyLabel = new JLabel("Write a key:");
        add(keyLabel);

        keyField = new JTextField();
        add(keyField);

        processButton = new JButton("Process");
        add(processButton);

        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                String encryption = encryptionField.getText();
                String key = keyField.getText();

                Main main = new Main();
                //main.processFile(fileName, encryption, key);
            }
        });

        outputFileLabel = new JLabel("Enter file name for output: ");
        add(outputFileLabel);

        outputFileField = new JTextField();
        add(outputFileField);

        saveButton = new JButton("Save");
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String outputFileName = outputFileField.getText();

                Main main = new Main();
               // main.saveFile(outputFileName);
            }
        });
        compressLabel = new JLabel("Do you want to compress file? (y/n)");
        add(compressLabel);

        compressField = new JTextField();
        add(compressField);
        compressButton = new JButton("Compress");
        add(compressButton);

        compressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String compressChoice = compressField.getText();

                Main main = new Main();
              //  if(compressChoice.equalsIgnoreCase("y")){
              //      ZIP.archiveFile(fileName1,name);
               // }
            }
        });

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainUI();
    }
}