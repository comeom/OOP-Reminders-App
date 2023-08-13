import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// (Bryce) Consider making this edit reminder window solely to change reminder details?
// We can move the delete reminder button to "view reminder details window". May be cleaner like this
// Implement change details here (no need for separate button)
// Add + implement a cancel button

class EditReminderWindow extends JFrame {
    private JButton changeDetailsButton;
    private JButton deleteReminderButton;

    public EditReminderWindow() {
        setTitle("Edit Reminder");
        setSize(300, 150);
        setLayout(new FlowLayout());

        changeDetailsButton = new JButton("Change Reminder Details");
        deleteReminderButton = new JButton("Delete Reminder");

        changeDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to change reminder details
            }
        });

        deleteReminderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to delete reminder
                dispose(); // Close the window after deleting
            }
        });

        add(changeDetailsButton);
        add(deleteReminderButton);
    }
}