import java.io.*;
import java.util.*;

public class USACO_Dec2024_Prob1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // Read number of test cases
        
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(br.readLine()); // Number of cakes
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] cakes = new long[c];
            for (int j = 0; j < c; j++) {
                cakes[j] = Long.parseLong(st.nextToken());
            }
            
            // Cumulative sum array
            long[] cum = new long[c + 1];
            for (int k = 0; k < c; k++) {
                cum[k + 1] = cum[k] + cakes[k];
            }
            
            long minBessie = Long.MAX_VALUE;
            for (int j = 0; j < c/2; j++) {
                minBessie = Math.min(minBessie, cum[j + c / 2 + 1] - cum[j]);
            }
            
            // Calculate the total sum
            long totalSum = 0;
            for (long num : cakes) {
                totalSum += num;
            }
            
            // Output result
            System.out.println(minBessie + " " + (totalSum - minBessie) );
        }
    }
}
