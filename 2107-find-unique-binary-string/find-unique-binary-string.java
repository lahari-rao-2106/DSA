class Solution {
    public String findDifferentBinaryString(String[] nums) {
         StringBuilder sw = new StringBuilder() ;
          for(int i =0 ; i <nums.length ; i++){
           sw.append (nums[i].charAt(i) == '0' ? '1' : '0');
          }
          return sw.toString(); 
    }        
    
}