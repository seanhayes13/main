[Back to Web Development Main](../../../../webdev)

# Movie Database Files
## HTML, PHP and SQL code used to mass upload information into my Movie Database
On my website I have a section that I use to demonstrate PHP skills where I store basic information about movies that I own, something that I had worked on in the past using Microsoft Access. The database starts with two massive tables:
  * A listing all of the movies
  * A listing of most of the major actors

And an intermediate table to support the many relationship required, and as you might imagine, that's a lot of entries.

#### Populating Movie/Actor intermediate table
[populatema.php](populatema.php)

This block of code was written to let me mass associate movies and actors.

With close to 1200 actors and over 600 movies, writing all of those insert statements would drive one over the edge, pull tham back up, and drive them over again, and again.

So, I wrote this block to list all of the actors, all of the movies, and use multiple selects to grab multiple actors and/or multiple movies, then run a nested for loop to insert each combination into the database. Extremely useful for movies like Harry Potter, Hobbit, Lord of the Rings, X-Men.

## More files will be loaded soon
