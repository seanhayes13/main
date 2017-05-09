[Back to main](../)

# Maze Game

This program started as a test bed for the graphics based navigation system for an RPG that I was trying to refactor from C++ 
but was scaled down to be used for a class project.

## sqlite3

I used sqlite3 to store details of each maze.

### Storing Maze Details

To store the mazes I would start by printing them off and drawing a grid over the maze to identify walls and open areas. But how
to store this information?

At first glance, you might think about storing each grid block of a maze as a seperate record within the database but with a maze
that is 10x10 that's 100 records that need to be stored and read back into the program. And a 10x10 maze is small, some of the other
mazes I was looking at incorporating where 30x30 or bigger. 

Solution? Strings repesenting each row where each letter indicated what type of cell was at that location. After printing off 
each maze and drawing the grid, I created a string for each row comprised of 'w' for walls, 'n' for empty areas, 's' for the 
start, and 'e' for the end. So a row for a 10x10 maze that was only wall looks like this: "wwwwwwwwww". The cross-section for 
a maze where the end was in the middle of a spiral would look something like this: "w n w n e w n w n w" (minus the spaces). 

Each string is stored in the database in a seperate record. When read back into the program from the database, the string is 
split and a row is build based on the letter. The information is then stored in a two-dimensional array ([rows],[columns]).

## PyGame

PyGame then takes that two-dimensional array and builds the maze, adjusting with grid block sized based on the size of the maze.
The base size was a 20 pixels on a 10x10 maze, with the actual size being the proportional (on a 20x20 maze the grid size would be
10 pixels)
