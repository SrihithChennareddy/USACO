import java.io.*;
import java.util.*;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int x = 5;
        while (st.hasMoreTokens()){  
            nums.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(nums);
        System.out.println(nums);
        System.out.println(binarySearch(nums,x));

    }

    public static Integer binarySearch(ArrayList<Integer> nums, Integer x){
        int left = 0;
        int right = nums.size();
        while(left < right){
            int mid = (left+right)/2;
            if(x < nums.get(mid)){
                right = mid ;
            } else if(x > nums.get(mid)){
                left = mid+1;
            } else{
                return mid;
            }
        }
        return -1;
    }
    
}
