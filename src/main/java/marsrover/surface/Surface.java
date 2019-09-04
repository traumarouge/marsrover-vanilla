package marsrover.surface;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Surface {

    public final int height;
    public final int width;

    private final Map<Coordinates, Positionable> positionableByCoordinates = new HashMap<>();

    public Surface(int width, int height) {

        this.width = width;
        this.height = height;
    }

    public Set<Coordinates> allCoordinates() {

        return new HashSet<>(positionableByCoordinates.keySet());
    }


    public Coordinates coordinates(Positionable positionable) {

        for (Map.Entry<Coordinates, Positionable> e : positionableByCoordinates.entrySet()) {
            if (positionable == e.getValue()) {
                return e.getKey();
            }
        }

        return null;
    }


    public Coordinates adjacentCoordinates(Coordinates c, Direction direction) {

        switch (direction) {
            case NORTH:
                return c.y == height - 1 ? new Coordinates(c.x, 0) : new Coordinates(c.x, c.y + 1);

            case EAST:
                return c.x == width - 1 ? new Coordinates(0, c.y) : new Coordinates(c.x + 1, c.y);

            case SOUTH:
                return c.y == 0 ? new Coordinates(c.x, height - 1) : new Coordinates(c.x, c.y - 1);

            case WEST:
                return c.x == 0 ? new Coordinates(width - 1, c.y) : new Coordinates(c.x - 1, c.y);
        }

        throw new IllegalStateException();
    }


    public Positionable positionable(Coordinates coordinates) {

        return positionableByCoordinates.get(coordinates);
    }


    public void positionAt(Positionable positionable, Coordinates target) {

        if (target.x >= width || target.y >= height || target.x < 0 || target.y < 0) {
            throw new IllegalArgumentException();
        }

        if (positionableByCoordinates.get(target) == null) {
            positionableByCoordinates.remove(coordinates(positionable));
            positionableByCoordinates.put(target, positionable);
        } else {
            throw new CollisionException();
        }
    }
}
