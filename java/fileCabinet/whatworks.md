# What works...

I will try to add to this list when I make some break throughs

## 14 June

So I'm putting up this update because I'm going to be busy for the next couple weeks. Making some big changes:
* Adding another level of storage, the Folder, between Drawer and Page. Still going to leave the option of storing Pages in Drawers, but the primary location for them will be in Folders.
* With the introduction of the Folder level I am changing the way that the ForeignKeyList stores link information. Instead of a String that gets parsed out and used, I'm building a new object to store the different pieces of information (Drawer and Folder name and Page ID).
* Folders will be one level deep for now. Once this change is complete and working, I plan to look into having Folders within Folders, the hold up at this point is how to store them in the new ForeignLink objects.
* Also creating a new object for storing criteria for filtering. This is a new requirement that came from the GUI development.
* Speaking of GUI Development, the inital development phases are complete, early tests are complete. Had to make some changes to the setup that are mostly cosmetic. One thing that couldn't carryover (at least not at this point) was most of the batch commands.

## 12 June

Been a crazy month

* The ForeignKeyList as giving me some problems for a while, especially creating the links in both sides, but 
  especially when it came to reading them back into the program. The program was saving them in the custom
  class but after saving to file they were being read back in as a LinkedHashMap which required a conversion.
  All of that work was an exercise in futility since I have changed the basic storage structure and switched from
  JSON to XML.
* Oh, yeah, I switched from JSON to XML. Save cleaner, and allowed me more flexibility when saving, not to mention 
  reducing the amount of code that was getting taken up by checking if the FKL was in the proper format or in a LinkedHashMap and converting to the proper format if needed.
* Started the first draft of a possible GUI, trying to keep it as simple as possible. Right now it is a single panel with three sub-panels, plus the command entry text-field.
* All previous 'interfaces' were reworked and grouped together as utilities.
* As part of moving from JSON to XML I reorganized the structure a little bit. Instead of one Node handling everything, including have other class objects as the value, I decided to change to having an abstract BaseNode with several other Nodes extending it. The change and reorganization has actually made things a little easier to work with even if it did require adding half a dozen more classes and making changes of some degree to almost every part of the program.

## 9 May

I really need to get better about making these updates. Since my last update, in addition to starting a new job,
I've made some progress on a few things.
   * Removed the NodeArray and replaced with the ForeignKeyList to handle relationships between other pages
   * The new ForeignKeyList system allows for *n*-to-*n* relationships (one-to-one, one-to-many, and many-to-many)
   * Went through two iterations of getting user input, the first was a seperate class but that was recently replaced with an interface to handle String and Integer input and handle the confirmation before deleting an object
   * Reworked the print functions from individual toString overrides within each level and moved the print functionality
   into another interface
   * At the end of the day I was able to get the sorting function working with a single field (had to completely rewrite
   a function I had written previously), works with both ascending and descending. Next step: sorting on multiple fields

## 24 April
So I haven't updated this list as regularly as I wanted to but I've reached a break point in the work so
I am taking a chance to do a big upload of what is working (I'm not uploading the output from the help
command like last time because that list is getting long).
   * Basic CRUD operations are working and have been tested
   * Unique print formats for Drawer, Page, Node, and NodeArray
   * Created another structure, NodeArray, to handle storing arrays within a Node
   * Functions for both adding a new NodeArray to a Node that already stores an array and for adding Nodes to an
   existing NodeArray
   * Updating the value of a Node, whether or not that Node is part of an array
   * Stacking commands to reduce how many times to press the enter key. This allows the user to load a series of commands
   that get run one after another instead of typing a command, enter, another command, enter, etc.
   * Went back through and removed all throw statements, replacing with try-catch blocks, and updated documentation with
   JavaDoc comments (may upload those here in the near future). Both of these actually helped identify some functions
   that were no longer used.

## 10 April
  Added a lot of functionality including the first phases of the engine to control interacting with the FileCabinet, this 
  is the actual output from running the help command:
```
clearactivedrawer: Clear the FileCabinet's active drawer and work from the FileCabinet level.

clearactivefc: Clears the active FileCabinet in preparation of loading a new FileCabinet

clearactivepage: Clears the active Page before loading a new page. A new page can be added without running this command.

exit: Exit the program

findall: Returns all elements in the currently active level

help: Display a list of known commands

listfc: Display a list of all FileCabinets in the current directory

loadalldrawers: Load all Drawers associated with the current FileCabinet

loaddrawer: Load one Drawer

loadfc: Load file cabinet configurations to the program

newdrawer: Create and add a new drawer to the active FileCabinet.

newfc: Create a new FileCabinet with the option of setting the new FileCabinet as the active FileCabinet

newnode: Insert a new node onto the current page. A page must be selected.

newpage: Add a new page to the active Drawer. An active FileCabinet must also be set.

selectpage: Set a page as the active page by providing the Page ID
```
  * The next big project is to work on saving changes, either automatically when a change is made or only when initiated by
  the user

## 9 April
   * Save and upload FileCabinet and Drawer configurations including name of the FileCabinet and the current next ID
   number for each drawer. Tested by adding a second Drawer of albums with group/artist names
   * Started work on basic command prompt input class. What's working on this?
      * Load a file cabinet
      * Display a list of known commands and their description
      * Exit

## 8 April
   * Basic Node-Page-Drawer-FileCabinet (NPDF) system tested entering first and last name and age for four people
   * Exporting to and importing from a JSON file
   * Parsing the imported data from a list of nodes into the NPDF format
      
[Back to the start](readme.md) | [ForeignKeyList](fkl.md) | [XML](xml.md) | [Commands](commands.md)
