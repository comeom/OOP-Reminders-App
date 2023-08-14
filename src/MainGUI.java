import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainGUI extends JFrame implements ActionListener {
    private JButton createListButton;
    private JButton viewListButton;
    private JComboBox<ReminderList> listBox;

    private FileManager fm;
    private ReminderList reminderList;

    public MainGUI() {
        setTitle("Reminders App");
        setSize(600, 300);
        setLayout(new FlowLayout());

        listBox = new JComboBox<>();
        fm = new FileManager();
        createListButton = new JButton("Create New Reminder List");
        viewListButton = new JButton("View Reminder List");
        display();

        listBox.addActionListener(this);
        createListButton.addActionListener(this);
        viewListButton.addActionListener(this);
        add(listBox);
        add(createListButton);
        add(viewListButton);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fm.save();
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createListButton) {
            CreateListGUI createReminderListWindow = new CreateListGUI(this);
            createReminderListWindow.setVisible(true);
        } else if (e.getSource() == viewListButton) {
            ViewListGUI viewReminderListWindow = new ViewListGUI(this);
            viewReminderListWindow.setVisible(true);
        } else if (e.getSource() == listBox) {
            reminderList = (ReminderList) listBox.getSelectedItem();
        }
    }

    // refreshes reminder lists in combo box
    public void display() {
        listBox.removeAllItems(); 
        for (ReminderList list : fm.getLists()) {
            listBox.addItem(list);
        }
        if (fm.getLists().size() > 0) {
            reminderList = fm.getLists().get(0);
        }
    }

    public FileManager getFileManager() {
        return fm;
    }

    public ReminderList getReminderList() {
        return reminderList;
    }
}
