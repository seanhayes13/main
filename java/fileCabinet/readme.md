# The Project

I recently started digging into other databases (object ones like MongoDB and object-relationals like PostGreSQL) and 
while looking at MongoDB I asked myself, how hard would that be to build? Which led to me asking which language would I
use? Before I knew it I was starting to come up with a basic outline of how I would build this. So I picked up a notebook
and began throwing down notes.

Originally I was going to write this in Python, but circumstances arose that moved my focus to Java (I plan to translate
into C# and Python at some point, with a local web browser based version written in possibly JavaScript later on).

Spent half hour at the library writing the basic structure, then rolled up my sleeves that night once everyone had gone to
bed and began working (nice thing about working night shifts and staying on the same sleep schedule on my nights off is
that there is no one to bug me for 6-8 hours).

First night of coding and in under 5 hours I built the basic structure of objects (see below) and worked out the first steps
of reading to and from JSON files (I have since changed to using XML).

# The Structure

I started off with a plan to use a prebuilt structure, whichever variation of a key-value pair that came with each language
(Map or HashMap in the case of Java) but quickly decided to build this from scratch. The general idea was to envision a filing
cabinet (guess where I got the name) with drawers, each drawer holds papers that contain the data.

## Node

Basic building block, these are the data on the pages, like fields on a relational table. Started off with two members, a 
string the key and an object the value (using an object so I can store any data-type) but further developments expanded 
this to also include an ID number of the page and the drawer or collection it belongs to (I'll explain more later).
Storing a person's first and last name would be two nodes, one for the first name and one for the last name.

### Different Nodes

There are 6 types of Nodes
* String
* Integer
* Double
* Boolean
* Array
* Foreign Key List

### ForeignKeyList

In a previous instance of this page, there was a block called NodeArray, that was used for handling arrays of other nodes.
That element has been replaced with the ForeignKeyList. Those of you familiar with relational databases will recognize the
term Foreign Key, but for those of you who do not, a Foreign Key is a reference to a record in another table elsewhere in a
database. See [this page](fkl.md) for more details about how the ForeignKeyList works in the context of this program.

## Page

Groupings of related nodes, for those relational database users, this is equivalent to a record on a table. So each person
would have their own page. Each page would get an ID from the drawer it resides in. This ID would also be applied to each
of the nodes on the page (again, more on why I set it up like this to follow).

## Drawer

The equivalent of collections in MongoDB or tables from a relational database. The drawer keeps track of the last used ID
and this information is saved as part of the configuration files.

## FileCabinet

You guessed it, this is the database itself.

## Storage

Starting with the FileCabinet, each element has a collection (with Java I used ArrayList) of the next level down:

* FileCabinet has a list of Drawer objects
* Each Drawer object has a list of Page objects
* Each Page object has a list of Node objects
* Each ForeignKeyList also has a list of Node objects to point to other Page objects

[ForeignKeyList](fkl.md) | [Working with JSON](xml.md) | [What's Working?](whatworks.md) | [Commands](commands.md)
