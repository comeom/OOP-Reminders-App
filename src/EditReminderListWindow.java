import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EditReminderListWindow extends JFrame {
    private JButton changeListNameButton;
    private JButton deleteListButton;
    private ViewReminderListWindow view;

    public EditReminderListWindow(ViewReminderListWindow view) {
        this.view = view;
        setTitle("Edit Reminder List");
        setSize(300, 150);
        setLayout(new FlowLayout());

        changeListNameButton = new JButton("Change List Name");
        deleteListButton = new JButton("Delete Reminder List");

        changeListNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        deleteListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGUI.getFileManager().deleteList(MainGUI.getSelected());
                MainGUI.display(MainGUI.getFileManager(), MainGUI.getListBox());
                view.dispose();
                dispose(); // Close the window after deleting
            }
        });

        add(changeListNameButton);
        add(deleteListButton);
    }
}
