package bullscows;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        new Controller().run();


    }
}

class Model {

    public Model() {
    }

    int bulls = 0;
    int cows = 0;


}

class View {

    int bulls;
    int cows;


    public View(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;

    }

    public void showNone() {
        System.out.print("Grade: None. The secret code is");
    }

    public void showBullsCows() {
        System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s). The secret code is ");
    }

    public void showBulls() {
        System.out.println("Grade: " + bulls + " bull(s). The secret code is ");
    }

    public void showCows() {
        System.out.println("Grade: " + cows + " cow(s). The secret code is ");
    }
}

class Controller {

    public static long pseudoRandom(int length) {

        Long result = 0L;
        if(length >=10){
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
        }else {


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
            st = st.substring(0,length);
            result = Long.parseLong(st);
            System.out.println("The random secret number is " + result);
        }
        return result;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        Scanner ss = new Scanner(System.in);
        

        int length = sc.nextInt();
        long random = Controller.pseudoRandom(length);
        String randomString = Long.toString(random);

        Model model = new Model();
        System.out.println("Enter number with " + length + " digits" );  // czy wszystkei sout pchac do classy View?
        String input  = ss.nextLine();

        //bulls
        for (int i = 0; i < randomString.length(); i++) {
            if (input.charAt(i) == randomString.charAt(i)) {
                model.bulls += 1;
            }
        }
        //cows
        for (int i = 0; i < randomString.length(); i++) {
            for (int j = 0; j < randomString.length(); j++) {
                if (input.charAt(i) == randomString.charAt(j)) {
                    model.cows += 1;
                }
            }
        }


        if (model.bulls > 0 & model.cows == 0)
            new View(model.bulls, model.cows);

        if (model.cows > 0 & model.bulls == 0)
            new View(model.bulls, model.cows);

        if (model.bulls > 0 & model.cows > 0)
            model.cows = model.bulls - model.cows;
        new View(model.bulls, model.cows);

        if (model.bulls == 0 & model.cows == 0)
            new View(model.bulls, model.cows);
}}
