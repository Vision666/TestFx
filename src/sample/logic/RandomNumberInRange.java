package sample.logic;

public class RandomNumberInRange {

    public static int randomize(int min, int max) {
         max -= min;
         return (int) (Math.random() * ++max) + min;
    }

}
