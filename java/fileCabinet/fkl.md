# ForeignKeyList

When it came time to begin approaching how to handle arrays, specifically, arrays of other objects, my first
approach was to build a NodeArray class that would hold an array of Nodes, similar to how the current Page object
works and store that NodeArray as the value of a Node. This approach was working but I began thinking about more
complex storage.

One of my earlier projects working with Microsoft Access was a database to hold information about movies and TV shows
that I owned including details about the movie or TV show, and a list of the actors who starred in them. To do this
I developed a many-to-many relationship, which is relatively easy in a relational database.

In an object database, *n*-to-many relationships are a bit tricky since there is no table to store the related information.
So I adopted an approach I found online for creating a many-to-many relationship in C# into this program. The change came
in that the C# version stores a complete copy of each object within the other. So going back to the movie-actor system,
each movie would store a complete copy of each actor that starred in it, and each actor would contain a complete copy of
each movie they starred in.

Not only do I not want to store all of that information in each JSON file, but I also did not want to deal with the hassle
of writing the functions for cascading updates and deletes using that method. Solution? Use a bit of both and build the 
ForeignKeyList.

The ForeignKeyList keeps an array of Nodes that store the name of the drawer and the page to link to. Keeping with
the movie-actor example, I have two drawers: movies and actors. Within each drawer are a series of pages for each movie
and actor. When I build a relationship in the actors Drawer to a movie, I provide:

* The name of the far-side drawer in this case 'movies'
* The Page ID of the Page to link to
* The name of the list on the near side (in the actors Drawer)
* The name of the list on the far-side (in the movies Drawer)

The function creates a Node with the far-side Drawer name and Page ID as the key and value, and puts this into the array
of a ForeignKeyList object. A new Node is built with the near-side collection name and the new ForeignKeyList as the key
and value, and that node is added to the current Page. A similar ForeignKeyList is made with the current Drawer and Page
ID, and added to a new Node using the far-side collection name and this new ForeignKeyList, and is added to that far-side
Page.

Obviously, if a collection with the same name exists on either side, the Drawer name and Page ID node are added to the 
existing ForeignKeyList.
