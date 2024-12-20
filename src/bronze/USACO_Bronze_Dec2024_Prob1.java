import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long t = Long.parseLong(st.nextToken());
        long[] testCases = new long[(int) t];
        long maxN = 0;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            testCases[i] = Long.parseLong(st.nextToken());
            maxN = Math.max(maxN, testCases[i]);
        }

        // Precompute results up to maxN using digit-based processing
        long[] precomputedResults = precompute(maxN);

        // Output results for each test case
        for (int i = 0; i < t; i++) {
            System.out.println(precomputedResults[(int) testCases[i]]);
        }
    }

    private static long[] precompute(long maxN) {
        long[] results = new long[(int) (maxN + 1)];
        long count = 0;

        // Start with the first number and process ranges
        long rangeStart = 1;
        while (rangeStart <= maxN) {
            long rangeEnd = Math.min(rangeStart * 10 - 1, maxN);
            for (long n = rangeStart; n <= rangeEnd; n++) {
                if (hasDifferentRounding(n)) {
                    count++;
                }
                results[(int) n] = count;
            }
            rangeStart *= 10; // Move to the next range of numbers
        }

        return results;
    }

    // Optimized version to check if rounding results differ
    private static boolean hasDifferentRounding(long n) {
        int p = (int) Math.log10(n) + 1;  // Get number of digits
        return standardRound(n, p) != chainRound(n, p);
    }

    // Standard rounding optimized for quick calculation
    private static long standardRound(long x, int p) {
        long power = (long) Math.pow(10, p);
        long remainder = x % power;

        return remainder >= power / 2 ? x + (power - remainder) : x - remainder;
    }

    // Chain rounding optimized
    private static long chainRound(long x, int p) {
        for (int i = 1; i <= p; i++) {
            long power = (long) Math.pow(10, i);
            long remainder = x % power;
            x = remainder >= power / 2 ? x + (power - remainder) : x - remainder;
        }
        return x;
    }
}
