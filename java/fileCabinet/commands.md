# Commands

For now this is going to be command prompt driven, and even the GUI will use these commands.

Not all of these have been implemented and this is not a complete list.

* Loading - Before loading a FileCabinet, the prompt shows as ">>>". After successfully loading the FileCabinet, the name
of that FileCabinet is added before those, so if the name is localFC, the new prompt will show as: localFC>>>
This allows the user to see where they are currently working. *selectDrawer* and *selectPage* will similarly add
the active Drawer's name and the active Page's ID number to the prompt. So working in localFC, in the addressBook
Drawer, on a Page with an ID of 13, will show a prompt like: localFC->addressBook->13>>>

* Add/Remove - Adding or deleting a Drawer, Page or Node will use commands that are pretty straight forward: *addElement* or *removeElement*
(replacing Element with Drawer, Page or Node). The remove commands on Drawer and Page will both require the user to confirm
that they want to delete that element (delete one key-value pair and it's a minor inconvenience, delete a page with a
dozen of them and you are going to be typing for a little while, delete a whole drawer with 100 pages each with over a
dozen nodes...)

* Find - Two variations: one to return either the first match, another to return all that match. These will run
off the current selected level. If a page has been selected, it will only check that page. If working from the Drawer level,
the search will go through every Page in the Drawer. If no Drawer has been selected, it will check the entire FileCabinet

[Back to the start](readme.md) | [XML](xml.md) | [What Works?](whatworks.md)
