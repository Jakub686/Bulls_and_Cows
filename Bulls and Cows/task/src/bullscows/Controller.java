package bullscows;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public static long pseudoRandom(int length) {

        Long result = 0L;
        if (length >= 10) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
        } else {

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
            st = st.substring(0, length);
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

        System.out.println("Enter number with " + length + " digits");  // czy wszystkei sout pchac do classy View?
        String input = ss.nextLine();

        //bulls
        for (int i = 0; i < randomString.length(); i++) {
            if (input.charAt(i) == randomString.charAt(i)) {
                model.setBulls(model.getBulls() + 1);

            }
        }
        //cows
        for (int i = 0; i < randomString.length(); i++) {
            for (int j = 0; j < randomString.length(); j++) {
                if (input.charAt(i) == randomString.charAt(j)) {
                    model.setCows(model.getCows() + 1);
                }
            }
        }

        if (model.getBulls() > 0 & model.getCows() == 0)
            view.showBulls(model.getBulls());

        if (model.getCows() > 0 & model.getBulls() == 0)
            view.showCows(model.getCows());

        if (model.getBulls() > 0 & model.getCows() > 0)
            view.show(model.getBulls(), model.getCows());

        if (model.getBulls() == 0 & model.getCows() == 0)
            view.show();
    }
}