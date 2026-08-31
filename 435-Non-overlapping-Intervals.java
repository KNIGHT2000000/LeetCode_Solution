class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        int n=intervals.length;
        //
        

        // so here we have to take a new array and remove the overlapping one
        //solve this
   
        // for(int i=0;i<n-1;i++){
        //     for(j=0;j<n-i-1;j++){
        //         //here we hve to sort 
        //         if(intervals[])
        //     }
        // }
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int count=0;


        int lastEnd_time=intervals[0][1];
        for(int i=1;i<n;i++){
           
                if(intervals[i][0]<lastEnd_time){
                    count++;
                   
                    
                }
                else{
                     lastEnd_time=intervals[i][1];
            
                }


            
            
            
        }
        return count;
       
}}