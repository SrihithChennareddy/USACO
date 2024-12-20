import java.io.*;
import java.util.*;

public class Problem3 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // Length of string
        int f = Integer.parseInt(st.nextToken()); // Frequency threshold
        String s = br.readLine(); // Contest string

        // HashMap to store the frequency of each "moo"
        Map<String, Integer> mooCount = new HashMap<>();

        // Precompute valid "moos" using a sliding window
        for (int i = 0; i <= n - 3; i++) {
            String moo = s.substring(i, i + 3);
            if (isValidMoo(moo)) {
                mooCount.put(moo, mooCount.getOrDefault(moo, 0) + 1);
            }
        }

        // TreeSet to store valid "moos" meeting the frequency threshold
        Set<String> validMoos = new TreeSet<>();

        // Iterate through each character in the string
        for (int i = 0; i < n; i++) {
            char originalChar = s.charAt(i);

            // Try replacing s[i] with each character from 'a' to 'z'
            for (char newChar = 'a'; newChar <= 'z'; newChar++) {
                if (newChar != originalChar) {
                    // Replace character and check affected substrings
                    StringBuilder sb = new StringBuilder(s);
                    sb.setCharAt(i, newChar);

                    // Update moo counts for affected substrings
                    Map<String, Integer> tempCount = new HashMap<>(mooCount);
                    for (int j = Math.max(0, i - 2); j <= Math.min(n - 3, i); j++) {
                        String oldMoo = s.substring(j, j + 3);
                        String newMoo = sb.substring(j, j + 3);

                        if (isValidMoo(oldMoo)) {
                            tempCount.put(oldMoo, tempCount.get(oldMoo) - 1);
                        }
                        if (isValidMoo(newMoo)) {
                            tempCount.put(newMoo, tempCount.getOrDefault(newMoo, 0) + 1);
                        }
                    }

                    // Collect valid "moos" meeting the frequency threshold
                    for (Map.Entry<String, Integer> entry : tempCount.entrySet()) {
                        if (entry.getValue() >= f) {
                            validMoos.add(entry.getKey());
                        }
                    }
                }
            }
        }

        // Output results
        System.out.println(validMoos.size());
        for (String moo : validMoos) {
            System.out.println(moo);
        }
    }

    // Helper function to check if a substring is a valid "moo"
    private static boolean isValidMoo(String moo) {
        return moo.length() == 3 && moo.charAt(0) != moo.charAt(1) && moo.charAt(1) == moo.charAt(2);
    }
}
