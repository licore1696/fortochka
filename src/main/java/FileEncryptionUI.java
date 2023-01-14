import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileEncryptionUI extends JFrame implements ActionListener {
    private JTextField fileNameField;
    private JComboBox<String> encryptionComboBox;
    private JComboBox<String> extensionComboBox;
    private JComboBox<String> archivingComboBox;
    private JButton encryptButton;

    public FileEncryptionUI() {
        // Set up the frame
        setTitle("File Encryption and Archiving");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Create a label and text field for the file name
        add(new JLabel("File name:"));
        fileNameField = new JTextField();
        add(fileNameField);

        // Create a label and combo box for the encryption type
        add(new JLabel("Encryption:"));
        String[] encryptionOptions = {"AES", "NONE"};
        encryptionComboBox = new JComboBox<>(encryptionOptions);
        add(encryptionComboBox);

        // Create a label and combo box for the file extension
        add(new JLabel("File extension:"));
        String[] extensionOptions = {"json", "xml", "txt"};
        extensionComboBox = new JComboBox<>(extensionOptions);
        add(extensionComboBox);

        // Create a label and combo box for the archiving type
        add(new JLabel("Archiving:"));
        String[] archivingOptions = {"ZIP", "NONE"};
        archivingComboBox = new JComboBox<>(archivingOptions);
        add(archivingComboBox);

        // Create a button to initiate the encryption and archiving process
        encryptButton = new JButton("Encrypt and Archive");
        encryptButton.addActionListener(this);
        add(encryptButton);

        // Pack the frame and make it visible
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == encryptButton) {
            // Get the user-specified file name, encryption type, extension, and archiving type
            String fileName = fileNameField.getText();
            String encryption = (String) encryptionComboBox.getSelectedItem();
            String extension = (String) extensionComboBox.getSelectedItem();
            String archiving = (String) archivingComboBox.getSelectedItem();

            // Encrypt and archive the file using the user-specified options
            // ...
        }
    }

    public static void main(String[] args) {
        new FileEncryptionUI();
    }
}