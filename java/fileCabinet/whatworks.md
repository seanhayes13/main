# What works...

I will try to add to this list when I make some break throughs

* 8 April
   * Basic Node-Page-Drawer-FileCabinet (NPDF) system tested entering first and last name and age for four people
   * Exporting to and importing from a JSON file
   * Parsing the imported data from a list of nodes into the NPDF format
* 9 April
   * Save and upload FileCabinet and Drawer configurations including name of the FileCabinet and the current next ID
   number for each drawer. Tested by adding a second Drawer of albums with group/artist names
   * Started work on basic command prompt input class. What's working on this?
      * Load a file cabinet
      * Display a list of known commands and their description
      * Exit
* 10 April
  * Added a lot of functionality including the first phases of the engine to control interacting with the FileCabinet, this 
  is the actual output from running the help command of :
    * clearactivedrawer: Clear the FileCabinet's active drawer and work from the FileCabinet level.
    * clearactivefc: Clears the active FileCabinet in preparation of loading a new FileCabinet
    * clearactivepage: Clears the active Page before loading a new page. A new page can be added without running this command.
    * exit: Exit the program
    * findall: Returns all elements in the currently active level
    * help: Display a list of known commands
    * listfc: Display a list of all FileCabinets in the current directory
    * loadalldrawers: loadalldrawers
    * loaddrawer: loaddrawer
    * loadfc: Load file cabinet configurations to the program
    * newdrawer: Create and add a new drawer to the active FileCabinet
    * newfc: Create a new FileCabinet with the option of setting the new FileCabinet as the active FileCabinet
    * newnode: Insert a new node onto the current page. A page must be selected.
    * newpage: Add a new page to the active Drawer. An active FileCabinet must also be set.
    * selectpage: Set a page as the active page by providing the Page ID
  * The next big project is to work on saving changes, either automatically when a change is made or only when initiated by
  the user
      
[Back to the start](readme.md) | [JSON](json.md) | [Commands](commands.md)
