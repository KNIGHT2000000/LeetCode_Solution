class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        // here we need to get ourself a multiplication function but here in algo we need O(n) time
        // also agar any elemnt is zero and it is only zero present then we will get multiplication at that time only 
        // if 2 zero then all product
//we cant use the division method
//so what we can do here is that -->w ecan take prefix and suffix product and drop the element 
int[] res=new int[n];
res[0]=1;
// prefix in res
for(int i=1;i<n;i++){
    res[i]=res[i-1]*nums[i-1];

}
//for suffix
int rightproduct=1;
for(int i=n-1;i>=0;i--){
    res[i]=res[i]*rightproduct;
    rightproduct=rightproduct*nums[i];
}





        return res;
        
    }
   
}

// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n = nums.length;
//         int[] result = new int[n];
//         int productWithoutZero = 1;
//         int zeroCount = 0;
        
//         // Find total product and count zeros
//         for (int num : nums) {
//             if (num == 0) {
//                 zeroCount++;
//             } else {
//                 productWithoutZero *= num;
//             }
//         }
        
//         // If 2 or more zeros, the result array is entirely 0s
//         if (zeroCount > 1) {
//             return result; // Java arrays default to 0
//         }
        
//         // Populate the result array based on zero count
//         for (int i = 0; i < n; i++) {
//             if (zeroCount == 1) {
//                 // If exactly 1 zero, only the zero's index gets the product
//                 result[i] = (nums[i] == 0) ? productWithoutZero : 0;
//             } else {
//                 // If no zeros, divide total product by current element
//                 result[i] = productWithoutZero / nums[i];
//             }
//         }
        
//         return result;
//     }
// }