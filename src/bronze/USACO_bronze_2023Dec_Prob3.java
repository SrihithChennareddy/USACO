package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class USACO_bronze_2023Dec_Prob3 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
		
        while(testCases > 0) {
        	
            int n = Integer.parseInt(br.readLine()); // No of plants
            int[] height = readArray(br, n);
            int[] growth = readArray(br, n);
            int[] want = readArray(br, n);
        	
            
            int days = 0;
            
            // Check growth rate same scenario
            
            int growthNumber = growth[0];
            int growthCount = 1;
            for(int i=1; i<n; i++) {
            	if(growthNumber == growth[i]) {
            		growthCount++;
            	}
            }
            if(growthCount == n) {
            	days = -1;
            }
            
          
            while(days >= 0) {

            	// Calculate growth of plants after a day
            	int temp[] = new int[n];
            	for(int i=0; i<n; i++) {
            		temp[i] = height[i]+(days*growth[i]);
            	}
            	
            	int i=0;
            	// Find out all plants satisfy wants of farmer
            	for(; i<n; i++) {
            		
            		int greaterCount  = want[i];
            		int value = temp[i];
            		int count=0;
            		for(int j=0; j<n; j++) {
            			if(i != j && temp[j] > value) {
            				count++;
            			}
            		}
            		System.out.println("greater count " + greaterCount + " count : " + count);
            		if(count!=greaterCount) {
            			days++;
            			//System.out.println("increment days : " + days);
            			i=n+1;
            		}
            	}
            	//System.out.println("i days : " + i);
            	if(i==n) {
            		System.out.println(days);
            		days = -1;
            		break;
            	}
            	
            }
            
            testCases--;
        }
        
	}
        
  
   /**
    * Read n numbers from input
    * 
    * @param br
    * @param n
    * @return
    * @throws IOException
    */
   private static int[] readArray(BufferedReader br, int n) throws IOException {
	   StringTokenizer st = new StringTokenizer(br.readLine());
       int[] input = new int[n];
       for(int i = 0; i < n; i++) {
    	   input[i] = Integer.parseInt(st.nextToken());
       }
       return input;
   }

}
