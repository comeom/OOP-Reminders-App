import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EditListGUI extends JFrame implements ActionListener {
    private ViewListGUI view;
    private JButton deleteListButton;
    private JButton saveButton;
    private JButton cancelButton;
    private JLabel titleLable;
    private JTextField listNameTextField;

    public EditListGUI(ViewListGUI view) {
        this.view = view;
        setTitle("Edit Reminder List");
        setSize(300, 150);
        setLayout(new FlowLayout());

        listNameTextField = new JTextField(20);
        listNameTextField.setText(view.getMain().getReminderList().toString());
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        deleteListButton = new JButton("Delete Reminder List");

        deleteListButton.addActionListener(this);
        saveButton.addActionListener(this);
        cancelButton.addActionListener(this);
        add(new JLabel("Reminder List Name:"));
        add(listNameTextField);
        add(saveButton);
        add(cancelButton);
        add(deleteListButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteListButton) {
                view.getMain().getFileManager().deleteList(view.getMain().getReminderList());
                view.getMain().display();
                view.dispose();
                dispose(); // Close the window after deleting
        } else if (e.getSource() == saveButton) {
                view.getMain().getReminderList().setName(listNameTextField.getText());
                view.display();
                view.getMain().display();
                dispose(); // Close the window after saving
        } else if (e.getSource() == cancelButton) {
                dispose(); // Close the window
        }
    }
}
