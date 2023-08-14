import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EditReminderGUI extends JFrame implements ActionListener{
    private ViewReminderGUI view;
    private JButton saveButton;
    private JButton cancelButton;
    private JTextField titleTextField;
    private JTextArea notesTextArea;
    private JTextField dateTextField;
    private JTextField timeTextField;
    private JTextField locationTextField;
    private JLabel titleLabel;
    private JLabel notesLabel;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JLabel locationLabel;
    private JScrollPane scrollPane;

    public EditReminderGUI(ViewReminderGUI view) {
        this.view = view;
        setTitle("Edit Reminder");
        setSize(400, 300);
        setLayout(new FlowLayout());

        titleTextField = new JTextField(20);
        notesTextArea = new JTextArea(5, 20);
        dateTextField = new JTextField(10);
        timeTextField = new JTextField(10);
        locationTextField = new JTextField(20);
        titleLabel = new JLabel("Title");
        notesLabel = new JLabel("Notes");
        dateLabel = new JLabel("Date");
        timeLabel = new JLabel("Time");
        locationLabel = new JLabel("Location");
        scrollPane = new JScrollPane(notesTextArea);
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        display();

        saveButton.addActionListener(this);
        cancelButton.addActionListener(this);
        add(titleLabel);
        add(titleTextField);
        add(notesLabel);
        add(scrollPane);
        add(dateLabel);
        add(dateTextField);
        add(timeLabel);
        add(timeTextField);
        add(locationLabel);
        add(locationTextField);
        add(saveButton);
        add(cancelButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            view.getView().getReminder().setReminder(titleTextField.getText(), notesTextArea.getText(),
                    dateTextField.getText(), timeTextField.getText(), locationTextField.getText());
            view.display();
            view.getView().display(); // reload view reminder list window in case name has changed
            dispose(); // Close the window after saving
        } else if (e.getSource() == cancelButton) {
            dispose(); // Close the window
        }
    }

    public void display() {
        titleTextField.setText(view.getView().getReminder().getName());
        notesTextArea.setText(view.getView().getReminder().getNotes());
        dateTextField.setText(view.getView().getReminder().getDate());
        timeTextField.setText(view.getView().getReminder().getTime());
        locationTextField.setText(view.getView().getReminder().getLocation());
    }
}