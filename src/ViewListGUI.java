import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ViewListGUI extends JFrame implements ActionListener {
    private MainGUI main;
    private JButton editListButton;
    private JButton createReminderButton;
    private JButton viewReminderDetailsButton;
    private JComboBox<Reminder> reminderBox;
    private Reminder reminder;

    public ViewListGUI(MainGUI main) {
        this.main = main;
        setSize(500, 250);
        setLayout(new FlowLayout());

        reminderBox = new JComboBox<>();
        editListButton = new JButton("Edit Reminder List");
        createReminderButton = new JButton("Create New Reminder");
        viewReminderDetailsButton = new JButton("View Reminder Details");
        display();

        reminderBox.addActionListener(this);
        editListButton.addActionListener(this);
        createReminderButton.addActionListener(this);
        viewReminderDetailsButton.addActionListener(this);
        add(reminderBox);
        add(editListButton);
        add(createReminderButton);
        add(viewReminderDetailsButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reminderBox) {
            reminder = (Reminder) reminderBox.getSelectedItem();
        } else if (e.getSource() == editListButton) {
            EditListGUI editReminderListWindow = new EditListGUI(this);
            editReminderListWindow.setVisible(true);
        } else if (e.getSource() == createReminderButton) {
            CreateReminderGUI createReminderWindow = new CreateReminderGUI(this);
            createReminderWindow.setVisible(true);
        } else if (e.getSource() == viewReminderDetailsButton) {
            ViewReminderGUI viewReminderDetailsWindow = new ViewReminderGUI(this);
            viewReminderDetailsWindow.setVisible(true);
        }
    }

    public void display() {
        setTitle(main.getReminderList().toString());
        reminderBox.removeAllItems();
        for (Reminder reminder : main.getReminderList().getReminders()) {
            reminderBox.addItem(reminder);
        }
        if (main.getReminderList().getReminders().size() > 0) {
            reminder = main.getReminderList().getReminders().get(0);
        }
    }

    public MainGUI getMain() {
        return main;
    }

    public Reminder getReminder() {
        return reminder;
    }
}
