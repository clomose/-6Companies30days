class Solution {
    public boolean isValidSerialization(String preorder) {
        int count = 0;
        String str[] = preorder.split(",");
        for(int i=0;i<str.length;i++){
            if(count==-1 && i<str.length-1){
                return false;
            }
            if(str[i].equals("#")){
                count--;
            }else{
                count++;
            }
        }
        return count==-1;
    }
}