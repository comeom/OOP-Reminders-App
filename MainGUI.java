import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    private JButton createListButton;
    private JButton viewListButton;

    public MainGUI() {
        setTitle("Reminders App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new FlowLayout());

        createListButton = new JButton("Create New Reminder List");
        viewListButton = new JButton("View Reminder List");

        createListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateReminderListWindow createReminderListWindow = new CreateReminderListWindow();
                createReminderListWindow.setVisible(true);
            }
        });

        viewListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewReminderListWindow viewReminderListWindow = new ViewReminderListWindow();
                viewReminderListWindow.setVisible(true);
            }
        });

        add(createListButton);
        add(viewListButton);
    }

    public static void main(String[] args) {
        MainGUI mainGUI = new MainGUI();
        mainGUI.setVisible(true);
    }
}

class CreateReminderListWindow extends JFrame {
    private JButton saveButton;
    private JButton cancelButton;
    private JTextField listNameTextField;

    public CreateReminderListWindow() {
        setTitle("Create Reminder List");
        setSize(300, 150);
        setLayout(new FlowLayout());

        listNameTextField = new JTextField(20);
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to save the reminder list
                dispose(); // Close the window after saving
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });

        add(new JLabel("Enter Reminder List Name:"));
        add(listNameTextField);
        add(saveButton);
        add(cancelButton);
    }
}

class ViewReminderListWindow extends JFrame {
    private JButton editListButton;
    private JButton createReminderButton;
    private JButton viewReminderDetailsButton;

    public ViewReminderListWindow() {
        setTitle("View Reminder List");
        setSize(300, 150);
        setLayout(new FlowLayout());

        editListButton = new JButton("Edit Reminder List");
        createReminderButton = new JButton("Create New Reminder");
        viewReminderDetailsButton = new JButton("View Reminder Details");

        editListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditReminderListWindow editReminderListWindow = new EditReminderListWindow();
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

        add(editListButton);
        add(createReminderButton);
        add(viewReminderDetailsButton);
    }
}

class EditReminderListWindow extends JFrame {
    private JButton changeListNameButton;
    private JButton deleteListButton;

    public EditReminderListWindow() {
        setTitle("Edit Reminder List");
        setSize(300, 150);
        setLayout(new FlowLayout());

        changeListNameButton = new JButton("Change List Name");
        deleteListButton = new JButton("Delete Reminder List");

        changeListNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to change list name
            }
        });

        deleteListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to delete reminder list
                dispose(); // Close the window after deleting
            }
        });

        add(changeListNameButton);
        add(deleteListButton);
    }
}

class CreateReminderWindow extends JFrame {
    private JButton saveButton;
    private JButton cancelButton;
    private JTextField titleTextField;
    private JTextArea notesTextArea;
    private JTextField dateTextField;
    private JTextField timeTextField;
    private JTextField locationTextField;

    public CreateReminderWindow() {
        setTitle("Create New Reminder");
        setSize(400, 300);
        setLayout(new GridLayout(7, 2));

        titleTextField = new JTextField(20);
        notesTextArea = new JTextArea(5, 20);
        dateTextField = new JTextField(10);
        timeTextField = new JTextField(10);
        locationTextField = new JTextField(20);
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to save the reminder
                dispose(); // Close the window after saving
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });

        add(new JLabel("Title:"));
        add(titleTextField);
        add(new JLabel("Notes:"));
        add(new JScrollPane(notesTextArea));
        add(new JLabel("Date:"));
        add(dateTextField);
        add(new JLabel("Time:"));
        add(timeTextField);
        add(new JLabel("Location:"));
        add(locationTextField);
        add(saveButton);
        add(cancelButton);
    }
}

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
                // Logic to delete reminder
                dispose(); // Close the window after deleting
            }
        });

        add(editReminderButton);
        add(deleteReminderButton);
    }
}

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
