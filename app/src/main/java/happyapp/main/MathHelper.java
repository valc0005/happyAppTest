package happyapp.main;

public class MathHelper {

    public static int getRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
}