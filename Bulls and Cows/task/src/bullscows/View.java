package bullscows;

public class View {

    public void show() {
        System.out.print("Grade: None. The secret code is");
    }

    public void show(int bulls, int cows) {
        System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s). The secret code is ");
    }

    public void showBulls(int bulls) {
        System.out.println("Grade: " + bulls + " bull(s). The secret code is ");
    }

    public void showCows(int cows) {
        System.out.println("Grade: " + cows + " cow(s). The secret code is ");
    }
}
