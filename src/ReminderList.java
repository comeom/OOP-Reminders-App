import java.io.Serializable;
import java.util.*;

public class ReminderList implements Serializable
{
    private String name;
    private List<Reminder> reminders;

    public ReminderList(String name) 
    {
        this.name = name;
        this.reminders = new ArrayList<>();
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public List<Reminder> getReminders() 
    {
        return reminders;
    }

    public String toString()
    {
        return name;
    }

    public void createReminder(String name, String notes, String date, String time, String location)
    {
        reminders.add(new Reminder(name, notes, date, time, location));
    }

    public void deleteReminder(Reminder reminder)
    {
        reminders.remove(reminders.indexOf(reminder));
    }
}
