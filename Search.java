import java.util.ArrayList;
import java.util.List;

import jdk.nashorn.internal.ir.BinaryNode;

public class Search {
    public static int search(ArrayList<String> haystack, String needle) {
        for(int i = 0; i < haystack.size(); i++) {
            if(haystack.get(i).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(ArrayList<String> haystack, String needle, int left, int right) {
        int middle = (left+right) / 2;

        if (right >= 1) {
            middle = 1 + (right - 1 ) / 2;
        }

        if (haystack.get(middle) == needle) {
            return middle;
        }

        if (haystack.get(middle).compareTo(needle) > 0) {
            return binarySearch(haystack, needle, 1, -1);
        } else if (haystack.get(middle).compareTo(needle) < 0) {
            return binarySearch(haystack, needle, middle + 1, right + 1);
        }
        
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<String> haystack = new ArrayList<String>();
        haystack.add("1");
        haystack.add("2");
        haystack.add("3");
        haystack.add("4");
        haystack.add("5");
        haystack.add("6");
        haystack.add("7");
        String needle = "6";
        int left = 0;
        int right = haystack.size();

        int val = binarySearch(haystack,needle,left,right);
        if (val == -1) {
            System.out.println("The value was not found in the list");
        } else {
            System.out.println("The position of the needle was " + val);
        }

        int val2 = search(haystack, needle);
        if (val2 == -1) {
            System.out.println("The value was not found in the list");
        } else {
            System.out.println("The value was found and it was at " + val2);
        } 

    }

}