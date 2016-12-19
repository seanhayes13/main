[Back to Battleship Main](README.md#ship)

#Ship class

The Ship class handles the bulk of the work for each ship including getting the list of GridPositions
that each ship occupies, keeping track of the ship's health, checking if the ship has been destroyed
(health is 0), and checking to see if the ship is at a particular position.

##Individual Ships

There are five additional child classes that use the Ship class as a parent, one for each of the five
ships: Carrier, Battleship, Cruiser, Submarine, and Destroyer. The only changes they make over the
parent is to return different values for ship size and ship type.
