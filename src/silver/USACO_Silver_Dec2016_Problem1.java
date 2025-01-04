import java.io.*;
import java.util.*;

public class USACO_Silver_Dec2016_Problem1 {
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int q = Integer.parseInt(st.nextToken()); 

        st = new StringTokenizer(br.readLine());
        int[] nums = new  int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        for(int i = 0; i < q; i++){
            int count=0;
            st = new StringTokenizer(br.readLine());
            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            count = (binarySearch(nums, max) - binarySearch(nums, min-1));
            pw.println(count);
        }
        pw.close();
    }
    
    public static int binarySearch(int[] nums, int x){
        if(x<nums[0]){
            return 0;
        }
        int left=0, right=nums.length-1;
        while(left!=right) {
            int mid = (left+right+1)/2;
            if(nums[mid] <= x){
                left = mid;
            } else {
                right = mid-1;
            } 
        }
        return left+1;
    }
}
