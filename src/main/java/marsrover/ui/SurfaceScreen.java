package marsrover.ui;

import marsrover.rover.MarsRover;

import marsrover.surface.Coordinates;
import marsrover.surface.Positionable;
import marsrover.surface.Surface;

import marsrover.ui.console.ConsoleUtil;


public class SurfaceScreen {

    private final Surface surface;

    public SurfaceScreen(Surface surface) {

        this.surface = surface;
    }

    public void render() {

        ConsoleUtil.clear();

        renderBorder();

        for (Coordinates c : surface.allCoordinates()) {
            Positionable positionable = surface.positionable(c);

            if (positionable instanceof MarsRover) {
                ConsoleUtil.print(surface.height + 1 - c.y, c.x + 2, "R");
                ConsoleUtil.print(surface.height + 4, 1, "Rover Status: "
                    + ((MarsRover) positionable).status());
            } else {
                ConsoleUtil.print(surface.height + 1 - c.y, c.x + 2, "#");
            }

            ConsoleUtil.print(surface.height + 6, 1, "Enter Commands: ");
        }
    }


    private void renderBorder() {

        StringBuilder sb;
        sb = new StringBuilder().append("+").append("-".repeat(surface.width)).append("+");

        ConsoleUtil.print(1, 1, sb.toString());
        ConsoleUtil.print(surface.height + 2, 1, sb.toString());

        sb = new StringBuilder().append("|").append(" ".repeat(surface.width)).append("|");

        for (int line = 2; line <= surface.height + 1; ++line) {
            ConsoleUtil.print(line, 1, sb.toString());
        }
    }
}
