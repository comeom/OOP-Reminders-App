import java.io.Serializable;

public class Reminder implements Serializable
{
    private String name;
    private String notes;
    private String date;
    private String time;
    private String location;
    private boolean status;

    public Reminder(String name, String notes, String date, String time, String location) 
    {
        this.name = name;
        this.notes = notes;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public String getName() 
    {
        return name;
    }

    public String getNotes()
    {
        return notes;
    }

    public String getDate() 
    {
        return date;
    }

    public String getTime() 
    {
        return time;
    }

    public String getLocation() 
    {
        return location;
    }

    public boolean isStatus() 
    {
        return status;
    }

    public void setReminder(String name, String notes, String date, String time, String location)
    {
        this.name = name;
        this.notes = notes;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setNotes(String notes) 
    {
        this.notes = notes;
    }

    public void setDate(String date) 
    {
        this.date = date;
    }

    public void setTime(String time) 
    {
        this.time = time;
    }

    public void setLocation(String location) 
    {
        this.location = location;
    }

    public void setStatus(boolean status) 
    {
        this.status = status;
    }

    public String toString()
    {
        return name;
    }
}
