import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ViewReminderGUI extends JFrame implements ActionListener {
    private ViewListGUI view;
    private JButton editReminderButton;
    private JButton deleteReminderButton;
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

    public ViewReminderGUI(ViewListGUI view) {
        this.view = view;
        setTitle("View Reminder Details");
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
        editReminderButton = new JButton("Edit Reminder");
        deleteReminderButton = new JButton("Complete/Delete Reminder");
        display();

        editReminderButton.addActionListener(this);
        deleteReminderButton.addActionListener(this);
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
        add(editReminderButton);
        add(deleteReminderButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editReminderButton) {
            EditReminderGUI editReminderWindow = new EditReminderGUI(this);
            editReminderWindow.setVisible(true);
        } else if (e.getSource() == deleteReminderButton) {
            view.getMain().getReminderList().deleteReminder(view.getReminder());
            view.display();
            dispose(); // Close the window after deleting
        }
    }

    public void display() {
        titleTextField.setText(view.getReminder().getName());
        notesTextArea.setText(view.getReminder().getNotes());
        dateTextField.setText(view.getReminder().getDate());
        timeTextField.setText(view.getReminder().getTime());
        locationTextField.setText(view.getReminder().getLocation());
    }

    public ViewListGUI getView() {
        return view;
    }
}
