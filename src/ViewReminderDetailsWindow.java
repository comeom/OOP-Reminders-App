import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ViewReminderDetailsWindow extends JFrame {
    private JButton editReminderButton;
    private JButton deleteReminderButton;

    public ViewReminderDetailsWindow() {
        setTitle("View Reminder Details");
        setSize(300, 150);
        setLayout(new FlowLayout());

        editReminderButton = new JButton("Edit Reminder");
        deleteReminderButton = new JButton("Delete Reminder");

        editReminderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditReminderWindow editReminderWindow = new EditReminderWindow();
                editReminderWindow.setVisible(true);
            }
        });

        deleteReminderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGUI.getSelected().deleteReminder(ViewReminderListWindow.getSelected());
                ViewReminderListWindow.display(ViewReminderListWindow.getReminderBox());
                dispose(); // Close the window after deleting
            }
        });

        add(editReminderButton);
        add(deleteReminderButton);
    }
}
