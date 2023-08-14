import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CreateListGUI extends JFrame implements ActionListener {
    private MainGUI main;
    private JButton saveButton;
    private JButton cancelButton;
    private JTextField listNameTextField;

    public CreateListGUI(MainGUI main) {
        this.main = main;
        setTitle("Create Reminder List");
        setSize(300, 150);
        setLayout(new FlowLayout());

        listNameTextField = new JTextField(20);
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        saveButton.addActionListener(this);
        cancelButton.addActionListener(this);
        add(new JLabel("Enter Reminder List Name:"));
        add(listNameTextField);
        add(saveButton);
        add(cancelButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            main.getFileManager().createList(listNameTextField.getText());
            main.display();
            dispose(); // Close the window after saving
        } else if (e.getSource() == cancelButton) {
            dispose(); // Close the window
        }
    }
}