package marsrover;

import marsrover.obstacle.Obstacle;

import marsrover.rover.MarsRover;

import marsrover.surface.Coordinates;
import marsrover.surface.Direction;
import marsrover.surface.Surface;

import marsrover.ui.SurfaceScreen;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Surface surface = new Surface(20, 10);
        SurfaceScreen screen = new SurfaceScreen(surface);
        surface.positionAt(new Obstacle(), new Coordinates(2, 2));

        MarsRover rover = new MarsRover(surface, Direction.NORTH);
        surface.positionAt(rover, new Coordinates(0, 0));
        screen.render();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String commands = sc.next();
            rover.process(commands);
            screen.render();
        }
    }
}
