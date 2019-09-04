package marsrover.surface;

public final class Coordinates {

    public final int x;
    public final int y;

    public Coordinates(int x, int y) {

        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof Coordinates)) {
            return false;
        }

        Coordinates other = (Coordinates) o;

        return x == other.x && y == other.y;
    }


    @Override
    public int hashCode() {

        int hash = 0;

        hash = 31 * hash + Integer.hashCode(x);
        hash = 31 * hash + Integer.hashCode(y);

        return hash;
    }
}
