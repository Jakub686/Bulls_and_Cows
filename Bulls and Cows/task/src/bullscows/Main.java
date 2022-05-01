package bullscows;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //dependency injection
        new Controller(new Model(), new View()).run();

    }
}





