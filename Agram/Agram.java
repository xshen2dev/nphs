import java.io.*;

public class Agram
{
    public static void main(String[] args) {
        /*
        if (args.length < 1) {
            System.err.println("Usage: <integer to convert>");
            System.exit(1);
        }
        try {
            int d = Integer.parseInt(args[0]);
            System.err.println("d=" + d);
            String hex = d2h(d);
            System.err.println("hex=" + hex);

        }
        catch (NumberFormatException e) {
            System.err.println(e);
        }
        */


        Poker52 p = new Poker52();

        int c0 = p.deal();

        int c5s[] = new int[5];
        for (int i=0; i<5; i++) {
            c5s[i] =  p.deal();
        }

//        System.out.print(c0);
//        System.out.print(p.i2n(c0));
        for (int i=0; i<5; i++) {
//            System.out.print(" " + c5s[i]);
//            System.out.print(" " + p.i2n(c5s[i]));
        }
//        System.out.println();

        // let's start playing

        // first suit of c0
        int s0 = c0/13;
        int r0 = c0%13; // rank

        // does c5s[] has the same suit?

        // the lowest card in that suit that's higher than ...
        int c_lowest_higher = -1;
        int r_lowest_higher = 13;

        // the lowest card in that suit
        int c_lowest_same_suit = -1;
        int r_lowest_same_suit = 13;

        // the lowest card regardless
        int c_lowest_regardless = -1;
        int r_lowest_regardless = 13;

        for (int i=0; i<5; i++) {
            int s = c5s[i]/13;
            int r = c5s[i]%13; // rank
            if (s == s0) { // same suit
                if (r > r0) {
                    // check the lowest rank with the same suit
                    // and higher than
                    if (r < r_lowest_same_suit) {
                        r_lowest_higher = r;
                        c_lowest_higher = c5s[i];
                    }
                }
                
                // check the lowest rank with the same suit
                if (r < r_lowest_same_suit) {
                    r_lowest_same_suit = r;
                    c_lowest_same_suit = c5s[i];
                }
            }

            // check the lowest rank regardless
            if (r < r_lowest_regardless) {
                r_lowest_regardless = r;
                c_lowest_regardless = c5s[i];
            }
        }

        System.err.print("r_lowest_higher=" + r_lowest_higher);
        System.err.println(" c_lowest_higher=" + c_lowest_higher);
        System.err.print("r_lowest_same_suit=" + r_lowest_same_suit);
        System.err.println(" c_lowest_same_suit=" + c_lowest_same_suit);
        System.err.print("r_lowest_regardless=" + r_lowest_regardless);
        System.err.println(" c_lowest_regardless=" + c_lowest_regardless);

        int c_the_one = -1;
        if (r_lowest_higher < 13) {
            c_the_one = c_lowest_higher;
        }
        else if (r_lowest_same_suit < 13) {
            c_the_one = c_lowest_same_suit;
        }
        else if (r_lowest_regardless < 13) {
            c_the_one = c_lowest_regardless;
        }
        else { // shouldn't happen
            System.err.println("Can't find anything, which shouldn't happen!");
        }

        System.out.print(c0);
        System.out.print(p.i2n(c0));
        for (int i=0; i<5; i++) {
            System.out.print(" " + c5s[i]);
            System.out.print(" " + p.i2n(c5s[i]));
        }
        System.out.println("\t" + p.i2n(c_the_one));
    }
}
