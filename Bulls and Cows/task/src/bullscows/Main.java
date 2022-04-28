package bullscows;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String input = sc.nextLine();
        //new Controller().run(input);
        int i = sc.nextInt();
        Controller.pseudoRandom(i);

    }
}

class Model {

    public Model() {
    }

    int bulls = 0;
    int cows = 0;

    public String predefinedNumber() {
        return "1234";
    }
}

class View {

    int bulls;
    int cows;
    String predefinedNumber;

    public View(int bulls, int cows, String predefinedNumber) {
        this.bulls = bulls;
        this.cows = cows;
        this.predefinedNumber = predefinedNumber;
    }

    public void showNone() {
        System.out.print("Grade: None. The secret code is");
    }

    public void showBullsCows() {
        System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s). The secret code is " + predefinedNumber);
    }

    public void showBulls() {
        System.out.println("Grade: " + bulls + " bull(s). The secret code is " + predefinedNumber);
    }

    public void showCows() {
        System.out.println("Grade: " + cows + " cow(s). The secret code is " + predefinedNumber);
    }
}

class Controller {

    public static void pseudoRandom(int i) {

        if(i >=10){
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
        }else {
            Long result = 0L;

            long pseudoRandomNumber = System.nanoTime();
            String pseudoString = Long.toString(pseudoRandomNumber);

            char[] chars = pseudoString.toCharArray();
            Set<Character> charSet = new LinkedHashSet<Character>();
            for (char c : chars) {
                charSet.add(c);
            }

            StringBuilder sb = new StringBuilder();
            for (Character character : charSet) {
                sb.append(character);
            }
            String st = sb.toString();
            st = st.substring(0,i);
            result = Long.parseLong(st);
            System.out.println("The random secret number is " + result);
        }
    }

    public void run(String input) {

        Model model = new Model();

        //bulls
        for (int i = 0; i < model.predefinedNumber().length(); i++) {
            if (input.charAt(i) == model.predefinedNumber().charAt(i)) {
                model.bulls += 1;
            }
        }
        //cows
        for (int i = 0; i < model.predefinedNumber().length(); i++) {
            for (int j = 0; j < model.predefinedNumber().length(); j++) {
                if (input.charAt(i) == model.predefinedNumber().charAt(j)) {
                    model.cows += 1;
                }
            }
        }


        if (model.bulls > 0 & model.cows == 0)
            new View(model.bulls, model.cows, model.predefinedNumber()).showBulls();

        if (model.cows > 0 & model.bulls == 0)
            new View(model.bulls, model.cows, model.predefinedNumber()).showCows();

        if (model.bulls > 0 & model.cows > 0)
            model.cows = model.bulls - model.cows;
        new View(model.bulls, model.cows, model.predefinedNumber()).showBullsCows();

        if (model.bulls == 0 & model.cows == 0)
            new View(model.bulls, model.cows, model.predefinedNumber()).showNone();
    }
}
