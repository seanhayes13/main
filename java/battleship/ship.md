[Back to Battleship Main](README.md#ship)

# Ship class

The Ship class handles the bulk of the work for each ship including getting the list of GridPositions
that each ship occupies, keeping track of the ship's health, checking if the ship has been destroyed
(health is 0), and checking to see if the ship is at a particular position.

## Individual Ships

There are five additional child classes that use the Ship class as a parent, one for each of the five
ships: Carrier, Battleship, Cruiser, Submarine, and Destroyer. The only changes they make over the
parent is to return different values for ship size and ship type.

## getBoardSpan

This function takes a ship's starting location and orientation (set when the constructor is called),
then adds that position, plus enough additional positions for the ship to an ArrayList and returns
that list.

```java
	public ArrayList<GridPosition> getBoardSpan(){
		ArrayList<GridPosition> result = new ArrayList<>();
		int count = getSize();
		int newCol = startLoc.column;
		char newRow = startLoc.row;
		if(orient == Orientation.HORIZONTAL){
			for(int i = 0; i < count; i++){
				result.add(new GridPosition(newRow,newCol));
				newCol++;
			}
		}
		if(orient == Orientation.VERTICAL){
			for(int i = 0; i < count; i++){
				result.add(new GridPosition(newRow,newCol));
				newRow++;
			}
		}
		return result;
	}
```

## isDestroyed

The isDestroyed method checks to see if a ship's health has been reduced to 0, ie, the ship has been
sunk.

```java
	public boolean isDestroyed(){
		if(health==0)return true;
		else return false;
	}
```

## Other methods

There are a few other methods that are pretty self explanatory:
- increaseDamage: Decreases a ship's health by one point
- Ship: Constructor
