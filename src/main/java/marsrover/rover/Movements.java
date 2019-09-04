package marsrover.rover;

import marsrover.surface.CollisionException;
import marsrover.surface.Coordinates;
import marsrover.surface.Direction;
import marsrover.surface.Surface;


class Movements {

    static void forward(MarsRover rover, Surface surface) {

        Coordinates roverCoordinates = surface.coordinates(rover);
        Coordinates target = null;

        switch (rover.getDirection()) {
            case NORTH:
                target = surface.adjacentCoordinates(roverCoordinates, Direction.NORTH);
                break;

            case EAST:
                target = surface.adjacentCoordinates(roverCoordinates, Direction.EAST);
                break;

            case SOUTH:
                target = surface.adjacentCoordinates(roverCoordinates, Direction.SOUTH);
                break;

            case WEST:
                target = surface.adjacentCoordinates(roverCoordinates, Direction.WEST);
                break;
        }

        try {
            surface.positionAt(rover, target);
        } catch (CollisionException e) {
            rover.addDamage(10);
        }
    }
}
