class Solution {
    static int answer = 0;
    
    public int solution(int[] nums) {
        
        combination(0,0,0,nums);

        return answer;
    }
    static void combination(int s,int l,int sum,int[] nums) {
        if(l == 3) {
            if(isPrime(sum)) {
                answer++;
            }
        } else {
            for(int i = s;i<nums.length;i++) {
                
                combination(i+1,l+1,sum+nums[i],nums);
            }
        }
    }
    
    static boolean isPrime(int x) {
        if(x <= 1) {
            return false;
        }
        
        if(x%2 == 0) {
            return (x == 2) ? true : false;
        }
        
        for(int i = 3;i<=(int)Math.sqrt(x);i+=2) {
            if(x%i == 0) {
                return false;
            }
        }
        return true;
    }
}