 [Back to Java Main](../)

# Battleship

For my last term on my Bachelor's degree I took a Java class to fill in some space. 
For the last two labs of the course we had to write Battleship, just between two
human players to start. We were given class and method signatures to get us started, 
from there we were on our own, for the most part.

I'll be uploading my solution here in the next few weeks but here's is a brief run down.

## Classes

### [Ship](ship.md)

The Ship class was used as a parent class for each of the individual ships (Carrier,
Battleship, Cruiser, Submarine, and Destroyer) with only a few functions being overriden.

### [GridPosition](gridPosition.md)

Relatively simple class defining each of the grids on the game board.

### [GameBoard](gameBoard.md)

The GameBoard managed ship placement, a count of shots fired, checking the result of
a shot during each turn, and a few other things.

### [AttackResult and Orientation](enums.md)

Two enum classes to help track the result of an attack and the orientation of a ship
when placing on the board.

## Extra Credit

The challenge came while writing the code and thinking back to one of my favorite movies:
WarGames. Specifically the end of the movie when, to stop a nuclear apocalypse, they tell
the computer to play Tic-Tac-Toe against itself. Which made me think: How hard would it be
to write a class that played Battleship?

Not that hard, frustrating beyond belief, but not that hard, but in the end I managed to
write a class that will play Battleship. I chose a checkerboard pattern as the search pattern
calling shots at random until getting a hit. After getting a hit, the 'AI' checks up until it
gets a miss, down until it gets a miss, then left and right. After the GameBoard reports back
that the ship is sunk, the 'AI' goes back to randomly searching the board.

More to come in the next few weeks...
