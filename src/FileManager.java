import java.io.*;
import java.util.*;

public class FileManager 
{
    private List<ReminderList> lists;
    public static String filename = "data.bin";

    public FileManager() 
    {
        lists = new ArrayList<ReminderList>();
        load();
    }

    public List<ReminderList> getLists() 
    {
        return lists;
    }

    public void load()
    {
        try 
        {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream istream = new ObjectInputStream(file);
            Integer num = (Integer) istream.readObject(); // read number of objects to allow for for loop
            
            // initialize list of reminder lists
            for (int i = 0; i < num; i++)
            {
                lists.add((ReminderList) istream.readObject());
            }
            istream.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("No existing data found");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void save()
    {
        try 
        {
            FileOutputStream file = new FileOutputStream(filename, false);
            ObjectOutputStream ostream = new ObjectOutputStream(file);
            Integer num = lists.size();
            ostream.writeObject(num);

            // write all reminder lists to file
            for (ReminderList list : lists)
            {
                ostream.writeObject(list);
            }
            ostream.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }

    public void createList(String name)
    {
        lists.add(new ReminderList((name)));
    }

    public void editList(int index, String name)
    {
        lists.get(index).setName(name);
    }

    public void deleteList(ReminderList list)
    {
        lists.remove(lists.indexOf(list));
    }
}