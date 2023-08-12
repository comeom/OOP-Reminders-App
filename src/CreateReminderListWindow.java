import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class CreateReminderListWindow extends JFrame {
    private JButton saveButton;
    private JButton cancelButton;
    private JTextField listNameTextField;

    public CreateReminderListWindow() {
        setTitle("Create Reminder List");
        setSize(300, 150);
        setLayout(new FlowLayout());

        listNameTextField = new JTextField(20);
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGUI.getFileManager().createList(listNameTextField.getText());
                MainGUI.display(MainGUI.getFileManager(), MainGUI.getListBox());
                dispose(); // Close the window after saving
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });

        add(new JLabel("Enter Reminder List Name:"));
        add(listNameTextField);
        add(saveButton);
        add(cancelButton);
    }
}