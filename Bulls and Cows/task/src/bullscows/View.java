package bullscows;

public class View {

    public void show() {
        System.out.print("Grade: None. Try again");
    }

    public void show(int bulls, int cows) {
        int c = cows -  bulls;
        System.out.println("Grade: " + bulls + " bull(s) and " + c + " cow(s). ");
    }

    public void showBulls(int bulls) {
        System.out.println("Grade: " + bulls + " bull(s).");
    }

    public void showCows(int cows) {
        System.out.println("Grade: " + cows + " cow(s). ");
    }

    public void showEnter() {
        System.out.println("Input the length of the secret code:");
    }

    public void showEnterNumberWithLength(int length) {
        System.out.println("Enter number with " + length + " digits");
    }
    public void showWon(String randomString){
        System.out.println("You win, the random secret number is " + randomString);
    }
}
