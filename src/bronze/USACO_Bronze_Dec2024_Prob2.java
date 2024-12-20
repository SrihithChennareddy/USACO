import java.io.*;
import java.util.*;

public class Problem2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        // 3D grid to track which cells are filled
        boolean[][][] cheese = new boolean[n][n][n];

        // Counters for rows, columns, and depths
        int[][] rowCount = new int[n][n];
        int[][] colCount = new int[n][n];
        int[][] depthCount = new int[n][n];

        // Set to track completed lines
        Set<String> completedLines = new HashSet<>();
        int count = 0;

        // Process updates
        for (int update = 0; update < q; update++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            // If cell is not already filled
            if (!cheese[x][y][z]) {
                cheese[x][y][z] = true;

                // Update row count and check for completion
                rowCount[x][y]++;
                if (rowCount[x][y] == n) {
                    String key = "row:" + x + ":" + y;
                    if (completedLines.add(key)) {
                        count++;
                    }
                }

                // Update column count and check for completion
                colCount[x][z]++;
                if (colCount[x][z] == n) {
                    String key = "col:" + x + ":" + z;
                    if (completedLines.add(key)) {
                        count++;
                    }
                }

                // Update depth count and check for completion
                depthCount[y][z]++;
                if (depthCount[y][z] == n) {
                    String key = "depth:" + y + ":" + z;
                    if (completedLines.add(key)) {
                        count++;
                    }
                }
            }

            // Print the current count of completed lines
            System.out.println(count);
        }
    }
}
