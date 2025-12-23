class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        long sum = 0, sumSq = 0;

        for(int num : nums){
            sum += num;
            sumSq += (long) num * num;
        }

        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSumSq = (long) n * (n + 1) * (2 * n + 1) / 6;

        long diff = sum - expectedSum; // duplicate - missing
        long diffSq = sumSq - expectedSumSq; //duplictae^2 - missing^2

        long sumDM = diffSq / diff; // duplicate + missing

        int duplicate =(int) ( (diff + sumDM) / 2);
        int missing =(int) (sumDM - duplicate);

        return new int[]{duplicate, missing};


        
   }
}