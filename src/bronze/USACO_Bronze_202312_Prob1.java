package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Math;

public class USACO_Bronze_202312_Prob1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // no of cows
    int m = Integer.parseInt(st.nextToken()); // no of candy cranes

    long[] htCows = new long[n]; // Height of cows
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      htCows[i] = Long.parseLong(st.nextToken());
    }

    // Calculate height of cow after eating each candy crane
    st = new StringTokenizer(br.readLine());
    while(m-- > 0) {
      long curr = Long.parseLong(st.nextToken());
      long taken = 0;
      for(int i = 0; i < n && taken < curr; i++) {
        long eat = Math.min(curr, htCows[i]) - taken;
        if(eat > 0) {
          htCows[i] += eat;
          taken += eat;
        }
      }
    }

    // print height of final cows after eating candy crane
    for(int i = 0; i < n; i++) 
        System.out.println(htCows[i]);
  }
}