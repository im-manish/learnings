package com.manish.java.thread.concurrency;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Test  {

    // Complete the numberOfPairs function below.
    static int numberOfPairs(int[] a, long k) {
        a = sortTheArray(a);
        a= removeDuplicateFromSortedArray(a);
        int length = a.length;
        int count=0;
        for(int i=0;i<(length);i++){
        	for(int j=i;j<length;j++) {
        		long sum = a[i]+a[j]; 
        		if(sum== k){
        			count ++;
        		}
        		
        	}
            
        }
        return count;
        
    }

    static int[] removeDuplicateFromSortedArray(int[] a){
        int n =a.length;
        Set<Integer> withoutDupList = new HashSet<Integer>();
        for(int i=0;i<n;i++){
            withoutDupList.add(a[i]);
        }
        int[] arrayWithOutDuplicate = new int[withoutDupList.size()];
        int index =0;
        for(Integer element: withoutDupList){
            arrayWithOutDuplicate[index] = element.intValue();
            index++;
        }
       // int[] arrayWithOutDuplicate = Arrays.copyOf(withoutDupList.toArray(),withoutDupList.size(),int[].class);
        return arrayWithOutDuplicate;
    }

    static int[] sortTheArray(int[] a){
            int n= a.length;
            for(int i=0;i<n-1;i++){
                for(int j=0; j<n-i-1;j++){
                    if(a[j]>a[j+1]){
                        int temp = a[j];
                        a[j] = a[j+1];
                        a[j+1] = temp;
                    }
                }
            }
            return a;
        }

    public static void main(String[] args) throws IOException {
       /* BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[aCount];

        for (int i = 0; i < aCount; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            a[i] = aItem;
        }

        long k = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");*/
    	int a[] = {6,1,3,46,1,3,9};

        int res = numberOfPairs(a, 47);
        System.out.println(res);

       /* bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
	

}
