# OOP-Reminders-App

Use Case Diagram:
![Use Case Diagram](https://edrawcloudpublicus.s3.amazonaws.com/viewer/self/3741860/share/2023-8-13/1691946784/main.svg)

Reference Name/Number: Create new reminder list

Overview:	When the “create new reminder list” button is clicked on the main GUI, a new window pops up to enter the name of the reminder list that the user wants to create. The user has the option to save this reminder list or cancel. When saving, the window closes and goes back to the main window of the application. When canceling, no new reminder list is created.

Related use cases:	none

Actors: user

Pre Conditions (Optional):	That must be true to allow execution (if any)

Post Conditions (Optional):	A new reminder list is created in the application for further use.  The first reminder list that is created auto populates the drop-down selection box in the main window during each use of the application

Reference Name/Number: View reminder list

Overview: When a user selects an existing reminder list from the dropdown box selection button and clicks the “view reminder list” button is clicked on the main GUI, a window pops up and gives the user three options for their reminder list. They can either, edit the reminder list, create a new reminder, or view reminder details, through the corresponding buttons

Related use cases:	edit reminder list, create new reminder, view reminder details

Actors: user

Pre Conditions (Optional):	There must be at least one reminder list already created beforehand for the “view reminder list” use case to work

Post Conditions (Optional):	The reminder list will be edited, have a new reminder added, or the details of the reminder will be viewed, if the user chooses to do so for the specified reminder list

Reference Name/Number:	edit reminder list

Overview:	when the user choses to edit the reminder list, a new window pops up and allows the user to change the name of the list and either save this change or cancel it. Through this window the user also has the option to delete the reminder list

Related use cases:	change reminder list name, delete reminder list, view reminder list
Actors: user

Pre Conditions (Optional):	The “view reminder list” use case must be initiated in order for “Edit reminder list” functionality to proceed and at least one reminder list must have been created during this application’s runtime.

Post Conditions (Optional):	The selected reminder list will either have an edited name, be deleted, or left alone. 

Reference Name/Number: change reminder list name
Overview	when the user choses to change the reminder list name, they have the option the edit the text field that has the existing name of the reminder list. from here they have the option to save this change, or cancel. if they change it, the reminder list will reflect this change and be saved as the new name. if they chose to cancel, the previous name would remain,

Related use cases:	edit reminder list

Actors: user

Pre Conditions (Optional):	The “edit reminder list” use case must be initiated in order for “change reminder list name” functionality to proceed, and and at least one reminder list must have been created during this application’s runtime.

Post Conditions (Optional): The selected reminder list will either have an edited name, or be left alone

Reference Name/Number: delete reminder list

Overview:	when the user choses to delete the reminder list, the reminder list will no longer exist in the application and be unable to be used or implement any of these use cases.

Related use cases:	edit reminder list

Actors: user

Pre Conditions (Optional: 	The “edit reminder list” use case must be initiated in order for “delete reminder list” functionality to proceed, and at least one reminder list must have been created during this application’s runtime.

Post Conditions (Optional):	The selected reminder list will either have an edited name, be deleted, or left alone. 

Reference Name/Number: create new reminder

Overview:	when the user choses to create a new reminder, a new window will pop up where the user will be prompted to enter a title, notes, date, time, and location for the reminder. They then have the option to save this reminder to the selected list or to cancel.

Related use cases:	view reminder list

Actors: user

Pre Conditions (Optional):	The “view reminder list” use case must be initiated in order for “create new reminder” functionality to proceed, and at least one reminder list must have been created during this application’s runtime.

Post Conditions (Optional):	A reminder will be added to the selected reminder list for the user to view/ further manipulate if desired. The first reminder created during each application runtime will auto populate into the drop-down selection box for the reminder list window

Reference Name/Number: view reminder details

Overview:	when a reminder is selected from the drop-down selection box in the reminder window, the user can click “view reminder details”. They will then be shown text boxes with the title, notes, date, time, and location of the reminder.
There are also buttons with the option to edit the reminder or complete/delete the reminder

Related use cases:	view reminder list, complete/delete reminder, edit reminder details

Actors: user

Pre Conditions (Optional):	The “view reminder list” use case must be initiated in order for the “view reminder details” functionality to proceed, and at least one reminder list must have been created during this application’s runtime.

Post Conditions (Optional):	A reminder and its details will be shown to the user so that they have the option to edit it or mark it as complete/delete it

Reference Name/Number: Mark reminder as complete/delete

Overview:	when the user chooses to complete/delete the reminder in the view reminder details window, the reminder will essentially be checked off their list. this will make the reminder no longer accessible to the user in the specified list and remove it from the list

Related use cases:	view reminder details

Actors: user

Pre Conditions (Optional):	The “view reminder details” use case must be initiated in order for “create new reminder” functionality to proceed, and at least one reminder list must have been created during this application’s runtime.

Post Conditions (Optional):	A reminder will be removed from the list as the user either completed it or wants to delete it. Therefore it will be no longer accessible to the application/user

Reference Name/Number:  Usecase name or number	edit reminder details

Overview:	when the user choses edit reminder in the view reminder details window, they will have the option to edit any of the text boxes that show the reminder’s title, notes, date, time, location. They have the option to edit any or all of these fields. They then have the option to save these changes or cancel. Saving these changes will update any of the reminder’s details depending on which were changed. Cancelling will  not update any changes and have the previous details remain.

Related use cases:	view reminder details

Actors:	user

Pre Conditions (Optional):	The “view reminder details” use case must be initiated in order for “edit reminder details” functionality to proceed, and at least one reminder list must have been created during this application’s runtime.

Post Conditions (Optional):	A reminder’s details, either all of them or only specific ones, will be edited and changed 
in the application for further use and the drop-down selection box in the reminder list window will also reflect these changes (if the change is the title)



Class Diagram:
![Class Diagram](https://edrawcloudpublicus.s3.amazonaws.com/viewer/self/3741860/share/2023-8-13/1691946449/main.svg)

Project Objective:
We want to design and implement a system in Java that allows a user to manage tasks through a GUI based reminders application.


Project Description:
The app will provide various means of organizing tasks. At the furthest level out, there will be reminder lists. The user can create, edit and delete reminder lists. Upon selecting a reminder list to view, the user will then be able to see the existing reminders within the list, create new reminders, edit reminders, and mark off reminders. Upon selecting a reminder within a list, the details of the reminder will be displayed and able to be edited. The fields of each reminder will be a title, notes, date, time, and location, which each can be edited upon viewing. The list that the current reminder is in can also be edited, in this mode. The way that a user clears will be through selecting the reminder/reminders that the user wishes to clear and then clicking a button to remove said reminders. 


System Design:
We will first create a use case diagram for our system. The system will be designed with OOP principles and will consist of several classes and methods to manage the functionality. The two most key classes will be the MainGUI class which will manage the various windows and the Reminder class which will contain all of the necessary attributes for each reminder as described above. A ReminderList class will also be necessary to manage the lists of reminders that the user has created. A FileManager class will also be necessary in order to save and load the data that the user has created. 

Deliverables:
By the end of this project, we hope to create a fully functional Reminders app, with user-friendly and intuitive user experience, a nice-looking GUI, error checking, and comprehensive documentation.
