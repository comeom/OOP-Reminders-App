import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CreateReminderWindow extends JFrame {
    private JButton saveButton;
    private JButton cancelButton;
    private JTextField titleTextField;
    private JTextArea notesTextArea;
    private JTextField dateTextField;
    private JTextField timeTextField;
    private JTextField locationTextField;

    public CreateReminderWindow() {
        setTitle("Create New Reminder");
        setSize(400, 300);
        setLayout(new GridLayout(7, 2));

        titleTextField = new JTextField(20);
        notesTextArea = new JTextArea(5, 20);
        dateTextField = new JTextField(10);
        timeTextField = new JTextField(10);
        locationTextField = new JTextField(20);
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGUI.getSelected().createReminder(titleTextField.getText(), notesTextArea.getText(), dateTextField.getText(), timeTextField.getText(), locationTextField.getText());
                ViewReminderListWindow.display(ViewReminderListWindow.getReminderBox());
                dispose(); // Close the window after saving
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });

        add(new JLabel("Title:"));
        add(titleTextField);
        add(new JLabel("Notes:"));
        add(new JScrollPane(notesTextArea));
        add(new JLabel("Date:"));
        add(dateTextField);
        add(new JLabel("Time:"));
        add(timeTextField);
        add(new JLabel("Location:"));
        add(locationTextField);
        add(saveButton);
        add(cancelButton);
    }
}