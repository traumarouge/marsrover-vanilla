package marsrover.rover;

import marsrover.surface.Coordinates;
import marsrover.surface.Direction;
import marsrover.surface.Positionable;
import marsrover.surface.Surface;

import static java.lang.String.format;


public final class MarsRover implements Positionable {

    private final Surface surface;
    private Direction direction;
    private int damage = 0;

    public MarsRover(Surface surface, Direction direction) {

        this.surface = surface;
        this.direction = direction;
    }

    Direction getDirection() {

        return direction;
    }


    void addDamage(int damage) {

        this.damage += damage;
    }


    public void process(String commands) {

        if (damage >= 100) {
            return;
        }

        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'l':
                    direction = direction.leftOf();
                    break;

                case 'r':
                    direction = direction.rightOf();
                    break;

                case 'f':
                    Movements.forward(this, surface);
            }
        }
    }


    public String status() {

        Coordinates coordinates = surface.coordinates(this);

        return format("%d;%d;%s;%d", coordinates.x, coordinates.y, direction.symbol, damage);
    }
}
