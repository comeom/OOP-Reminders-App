import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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