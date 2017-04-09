# Working with JSON

My original plan was to store each drawer as a seperate JSON file in it's entirety. I may return to this idea when I get
a better idea on working with Java and JSON (using Jackson to get the two to talk to each other) but for now I am going
about this in what is probably a very ugly manner: getting all of the nodes in a drawer, saving them in one list, and
writing that whole list to one JSON file. Now you see why I saved the ID from the page and the name of the drawer in each
node. I may readdress this at some point down the road but it works. And before you ask, yes I do have a function that, after
reading in the monster list of nodes, goes through them and rebuilds the Drawer-Page-Node structure.

[Back to the start](readme.md)
