# Text Game, continued

Previous - [Main](README.md)

This portion of the program works a lot with inheritance with Entity being the main, general class and with Player ad Enemy pulling from it.

I plan to load the code for these sections in the next week or so

### Entity

Right now the game only has the Player and Enemy classes but this will likely expand at some point to include neutral NPCs (non-Player Characters) such as merchants. This class defines broad characteristics like health, weapon damage.

### Player

The Player class expands on the Entity class, adding in elements like experience, level, and name. Included are functions that adjust experience and skill level.

### Enemy

The Enemy class expands on the Entity class, adding in elements like experience value and type (Orc, goblin, etc). The type identifier is just a place holder at this point but there are plans that were put on hold to adjust health, weapon damage, and other stats based on type (higher or lower health, stronger or weaker weapon damage, etc).
