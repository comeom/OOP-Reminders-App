import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ViewReminderListWindow extends JFrame {
    private JButton editListButton;
    private JButton createReminderButton;
    private JButton viewReminderDetailsButton;
    private static JComboBox<Reminder> reminderBox;
    private static Reminder selected;

    public ViewReminderListWindow() {
        setSize(300, 150);
        setLayout(new FlowLayout());
        reminderBox = new JComboBox<>();

        display(reminderBox);

        editListButton = new JButton("Edit Reminder List");
        createReminderButton = new JButton("Create New Reminder");
        viewReminderDetailsButton = new JButton("View Reminder Details");

        reminderBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selected = (Reminder) reminderBox.getSelectedItem();
            }
        });

        editListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditReminderListWindow editReminderListWindow = new EditReminderListWindow(ViewReminderListWindow.this);
                editReminderListWindow.setVisible(true);
            }
        });

        createReminderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateReminderWindow createReminderWindow = new CreateReminderWindow();
                createReminderWindow.setVisible(true);
            }
        });

        viewReminderDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewReminderDetailsWindow viewReminderDetailsWindow = new ViewReminderDetailsWindow();
                viewReminderDetailsWindow.setVisible(true);
            }
        });

        add(reminderBox);
        add(editListButton);
        add(createReminderButton);
        add(viewReminderDetailsButton);
    }

    public static void display(JComboBox<Reminder> reminderBox)
    {
        reminderBox.removeAllItems(); 
        for (Reminder reminder : MainGUI.getSelected().getReminders()) {
            reminderBox.addItem(reminder);
        }
        if (MainGUI.getSelected().getReminders().size() > 0) {
            selected = MainGUI.getSelected().getReminders().get(0);
        }
    }

    public static JComboBox<Reminder> getReminderBox()
    {
        return reminderBox;
    }

    public static Reminder getSelected()
    {
        return selected;
    }
}
