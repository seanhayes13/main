[Back to Battleship Main](README.md#gridposition)

# GridPosition

The GridPosition class defines each of the 100 blocks of the game board with an character row and a integer column.

## generateRandom

Uses the Random function to generate a random GridPosition by pulling a number from 1 to 10 and a character
from a to j, then passing those into a GridPosition constructor.

```java
	public static GridPosition generateRandom(){
		Random rand = new Random();
		int c = rand.nextInt((10-1)+1)+1;
		char r = (char)(rand.nextInt(10)+'a');
		return new GridPosition(r, c);
	}
```

## parse

The parse method takes string input from the user of the grid they are firing at, such as "a,4", splits the string,
and returns a new GridPosition based on the results of the split. The newly created GridPosition is then used in
the GameBoard's attack method.

```java
	public static GridPosition parse (String s){
		//System.out.printf("Passed in: %s\n",s);
		String[] first = s.split(",");
		return new GridPosition(first[0].charAt(0),Integer.parseInt(first[1]));
	}
```

## verifyGrid

The verifyGrid method checks that the grid the user enters is a valid position on a standard Battleship game board,
so no "z,99" calls from a user.

```java
	public static boolean verifyGrid(GridPosition gp){
		if(gp.column < 1 || gp.column > 10 || gp.row >'j' || gp.row < 'a') return false;
		else return true;
	}
```
