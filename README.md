# ZombieSiege

A horrible 2D top-down game made in an attempt to learn Java. Its code and commit history probably break all kinds of best practices.

![Screenshot](https://raw.github.com/duckson/zombiesiege/master/zombiesiege.png)

In this game, you spawn on a playing field with zombies. Your objective is to shoot them down with the various weapons at your disposal.

## Controls

Move your character with `W/A/S/D`. Fire your weapon by clicking or hitting the spacebar. Reload it by pressing `R`. Hit `Q` or `E` to cycle between weapons.

## Building and running

Open the project in IntelliJ or Eclipse and hit "run". It should work on a standard installation.

## Technicalities

The game runs inside a JFrame, see the `PlayingField` class for this. It contains the game loop and should probably be refactored. Also, an actual drawing library should probably be used instead.

The playing field is based around Entities, which are drawn on the screen during the game loop (from an `entities` arraylist). They're all based off the `Entity` class, and can be anything from a bullet to a zombie to the player character.

Every tick, the following things occur:

1. Call `move()` on every entity
2. Check for collisions between entities
3. Check if anything needs to be respawned
4. Update the textual labels
5. Paint all entities and labels on the screen

## License

Code available under the WTFPL.

Credit for the sound effects goes to the [Freesound project](http://freesound.org).
