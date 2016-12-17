import java.io.*;
import java.util.Random;

public class Poker52
{
    private Random random;
    private boolean[] cards;

    private String suits[] = { "C", "D", "H", "S" };
    private String c13s[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q","K" };

    public Poker52() {
        random = new Random(System.currentTimeMillis());
        cards = new boolean[52];

        for (int i=0; i<52; i++)
            cards[i] = false;
    }

    public int deal() {
        // get a random type first
        for (int i=0; i<52; i++) {
            int j = random.nextInt(52);
            if (!cards[j]) { // still false, not dealt yet, good
                System.out.println("deal() " + i);
                cards[j] = true;
                return j;
            }
        }

        return -1; // run out of cards
    }

    public String i2n(int i) {
//        System.out.println("i2n() i=" + i);
        int q = i/13;
        int r = i%13;
//        System.out.println("i2n() i=" + i + " q=" + q + " r=" + r);
        return c13s[r] + suits[q];
    }
}
