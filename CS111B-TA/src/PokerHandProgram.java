import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
public class PokerHandProgram {
    public static void main(String[] args){
        int[] hand = getUserHand();
        Arrays.sort(hand); // Quick Sort algorithm.
        System.out.println(getType(hand));
        statistics();
    }
    public static boolean containsPair(int hand[]){
        /* O(n^2)
        for (int i = 0; i < hand.length-1; i++){
            for (int j = i+1; j < hand.length; j++){
                if (hand[i] == hand[j]){
                    return true;
                }
            }
        } */
        // O(N)
        for (int i = 0; i< hand.length-1; i++) {
            if (hand[i] == hand[i+1]){
                return true;
            }
        }
        return false;
    }
    public  static boolean containsTwoPair(int hand[]){
        int counter = 0;
        for (int i = 0 ; i < hand.length-1;i++){
            if (hand[i] == hand[i+1]){
                counter++;
            }
        }
        if (counter == 2) {
            return true;
        }
        return false;
    }
    public static boolean containsThreeOfaKind(int hand[]){
        /* O(n^3)
        for (int i = 0; i < hand.length-2; i++){
            for (int j = i+1; j < hand.length-1; j++){
                for (int k = j + 1; k < hand.length; k++){
                    if (hand[i] == hand[j] && hand[i] == hand[k]){
                        return true;
                    }
                }
            }
        } */
        for (int i=0; i < hand.length -2; i++){
            if (hand[i] == hand[i+1] && hand[i] == hand[i+2]){
                return true;
            }
        }
        return false;
    }
    public static boolean containsStraight(int hand[]){
        boolean isStraight = false;
        for (int i =0; i< hand.length -1 ; i++){
            if (hand[i] == hand[i+1] - 1){
                isStraight = true;
            } else {
                return false;
            }
        }
        return isStraight;
    }
    public static boolean containsFullHouse(int hand[]){
        AtomicBoolean foundPair = new AtomicBoolean(false);
        AtomicBoolean foundTriple = new AtomicBoolean(false);
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < hand.length; i++){
            if (hmap.containsKey(hand[i])){
                hmap.replace(hand[i], hmap.get(hand[i])+1 );
            } else {
                hmap.put(hand[i], 1);
            }
        }
        hmap.forEach((k,v) -> {
            if (v == 2){
                foundPair.set(true);
            } else if (v==3){
                foundTriple.set(true);
            }
        });
        if (foundPair.get() == true  && foundTriple.get() == true){
            return true;
        } else {
            return false;
        }
    }
    public static boolean containsFourOfaKind(int hand[]){
        for (int i = 0; i < hand.length - 3; i++){
            if (hand[i] == hand[i+1] && hand[i] == hand[i+2] && hand[i] == 
hand[i+3]){
                return true;
            }
        }
        return false;
    }
    public static int[] getUserHand(){
        int[] hand = new int[5];
        System.out.println("Enter five numeric cards, no face cards. Use 2 - 9.");
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < hand.length; i++){
            System.out.println("Card " + i + 1 + ": ");
            hand[i] = input.nextInt();
        }
        return hand;
    }
    public static String getType(int[] hand){
        if (containsFourOfaKind(hand)){
            return("4 OF A KIND");
        } else if (containsFullHouse(hand)){
            return("FULL HOUSE");
        } else if (containsStraight(hand)){
            return("Straight");
        } else if (containsThreeOfaKind(hand)){
            return("3 of a kind");
        } else if (containsTwoPair(hand)){
            return("2 Pairs");
        } else if (containsPair(hand)){
            return("Pair");
        } else {
            return("High Card!");
        }
    }
    public static void statistics(){
        System.out.println("Getting statistics of 1 million random arrays.");
        Map<String, Integer> hmap = new HashMap<String, Integer>();
        for (int i = 0; i < 1000000; i++){
            int[] hand = new int[5];
            for(int j = 0; j < 5; j++){
                hand[j] = (int) (Math.random() * 8) + 2;
            }
            Arrays.sort(hand);
            String result = getType(hand);
            if (hmap.containsKey(result)){
                hmap.replace(result, hmap.get(result) + 1);
            } else {
                hmap.put(result, 1);
            }
        }
        hmap.forEach((k,v) -> {
            System.out.println("Number of " + k + ": " + v);
        });
    }
    /*
    Number of High Card!: 1903282
    Number of FULL HOUSE: 170894
    Number of 4 OF A KIND: 88093
    Number of 3 of a kind: 1025215
    Number of 2 Pairs: 1538292
    Number of Pair: 5128396
    Number of Straight: 145828
     */
}