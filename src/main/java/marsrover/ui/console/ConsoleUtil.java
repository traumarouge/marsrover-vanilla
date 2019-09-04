package marsrover.ui.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConsoleUtil {

    public static int getLines() throws IOException {

        Process p = Runtime.getRuntime().exec(new String[] { "bash", "-c", "tput lines 2> /dev/tty" });

        try(BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            return Integer.valueOf(stdoutReader.readLine());
        }
    }


    public static int getColumns() throws IOException {

        Process p = Runtime.getRuntime().exec(new String[] { "bash", "-c", "tput cols 2> /dev/tty" });

        try(BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            return Integer.valueOf(stdoutReader.readLine());
        }
    }


    public static void print(String s) {

        System.out.print(s);
    }


    public static void print(int line, int column, String s) {

        System.out.printf("\033[%d;%dH%s", line, column, s);
    }


    public static void setCursor(int line, int column) {

        System.out.printf("\033[%d;%dH", line, column);
    }


    public static void clear() {

        System.out.print("\033[2J\033[H");
    }
}
