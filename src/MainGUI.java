import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainGUI extends JFrame implements ActionListener {
    private JButton createListButton;
    private JButton viewListButton;
    private static JComboBox<ReminderList> listBox;
    private static FileManager fm;
    private static ReminderList selected;

    public MainGUI() {
        setTitle("Reminders App");
        setSize(600, 300);
        setLayout(new FlowLayout());

        listBox = new JComboBox<>();
        fm = new FileManager();
        display(MainGUI.getFileManager(), MainGUI.getListBox());

        createListButton = new JButton("Create New Reminder List");
        viewListButton = new JButton("View Reminder List");

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
            CreateReminderListWindow createReminderListWindow = new CreateReminderListWindow();
            createReminderListWindow.setVisible(true);
        } else if (e.getSource() == viewListButton) {
            ViewReminderListWindow viewReminderListWindow = new ViewReminderListWindow();
            viewReminderListWindow.setVisible(true);
        } else if (e.getSource() == listBox) {
            selected = (ReminderList) listBox.getSelectedItem();
        }
    }

    public static void display(FileManager fm, JComboBox<ReminderList> listbox) {
        listBox.removeAllItems(); 
        for (ReminderList list : fm.getLists()) {
            listBox.addItem(list);
        }
        if (fm.getLists().size() > 0) {
            selected = fm.getLists().get(0);
        }
    }

    public static FileManager getFileManager() {
        return fm;
    }

    public static JComboBox<ReminderList> getListBox() {
        return listBox;
    }

    public static ReminderList getSelected() {
        return selected;
    }
}
