package osipov.dmitry.search;

import java.util.ArrayList;
import java.util.List;

public class SubstringSearch {
    public static void main(String[] args) {
        String text = "aabaabaaaaaabaabaabaabaaaaab";
        String sample = "aabaab";
        System.out.println(searchNaive(text, sample));
        System.out.println(KMPSearch(text, sample));
    }

    public static List<Integer> searchNaive(String text, String sample) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            int j = 0;
            while (j < sample.length() && i + j < text.length() && sample.charAt(j) == text.charAt(i + j)) {
                j++;
            }

            if (j == sample.length()) {
                result.add(i);
            }
        }

        return result;
    }

    public static List<Integer> KMPSearch(String text, String sample) {
        List<Integer> result = new ArrayList<>();
        int[] prefixFunc = prefixFunction(sample);
        int i = 0, j = 0;
        while (i < text.length()) {
            if (sample.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == sample.length()) {
                result.add(i - j);
                j = prefixFunc[j - 1];
            } else if (i < text.length() && text.charAt(i) != sample.charAt(j)) {
                if (j != 0) {
                    j = prefixFunc[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    private static int[] prefixFunction(String sample) {
        int[] values = new int[sample.length()];
        for (int i = 1; i < values.length; i++) {
            int j = 0;
            while(i + j < sample.length() && sample.charAt(i + j) == sample.charAt(j)) {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
            }
        }

        return values;
    }
}
