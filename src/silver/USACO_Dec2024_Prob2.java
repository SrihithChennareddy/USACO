import java.io.*;
import java.util.*;

public class USACO_Dec2024_Prob2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());

        for (int test = 0; test < tests; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            long[] trees = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                trees[i] = Long.parseLong(st.nextToken());
            }
            Arrays.sort(trees);

            long[][] intervals = new long[k][3];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                intervals[i][1] = Long.parseLong(st.nextToken()); // l
                intervals[i][0] = Long.parseLong(st.nextToken()); // r
                intervals[i][2] = Long.parseLong(st.nextToken()); // t
            }
            Arrays.sort(intervals, Comparator.comparingLong(a -> a[0]));

            int i = 0;
            Deque<long[]> stack = new ArrayDeque<>();
            boolean[] planted = new boolean[n];
            int[] prefix = new int[n + 1];  // Prefix sum array

            for (long[] interval : intervals) {
                long r = interval[0];
                long l = interval[1];
                long t = interval[2];

                // Push trees within the interval [l, r] onto the stack
                while (i < n && trees[i] <= r) {
                    stack.addLast(new long[]{trees[i], i});
                    i++;
                }

                int plantedInRange = countPlantedTrees(trees, prefix, l, r);

                // Plant additional trees if required
                while (plantedInRange < t && !stack.isEmpty()) {
                    long[] tree = stack.pollLast();
                    planted[(int) tree[1]] = true;
                    plantedInRange++;

                    // Update prefix sum after planting
                    for (int j = (int) tree[1] + 1; j <= n; j++) {
                        prefix[j]++;
                    }
                }
            }

            // Count unplanted trees
            int plantedCount = 0;
            for (boolean b : planted) {
                if (b) plantedCount++;
            }
            System.out.println(n - plantedCount);
        }
    }

    // Method to count planted trees in range [l, r] using prefix sum
    private static int countPlantedTrees(long[] trees, int[] prefix, long l, long r) {
        int leftIndex = Arrays.binarySearch(trees, l);
        int rightIndex = Arrays.binarySearch(trees, r);

        if (leftIndex < 0) leftIndex = -leftIndex - 1;
        if (rightIndex < 0) rightIndex = -rightIndex - 2;

        return (rightIndex >= 0 ? prefix[rightIndex + 1] : 0) - 
               (leftIndex > 0 ? prefix[leftIndex] : 0);
    }
}
