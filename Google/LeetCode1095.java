class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int peak =  peak(arr);
        System.out.println(peak);
        int ans = search(0,peak,target,arr,true);
        if(ans!=-1) return ans;
        ans = search(peak,arr.length()-1,target,arr,false);
        return ans;
    }
    int peak(MountainArray arr){
        int s = 0;
        int e = arr.length()-1;
        int index = -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(arr.get(mid+1)>arr.get(mid)){
                s = mid + 1;
            }else if(arr.get(mid-1)>arr.get(mid)){
                e = mid - 1;
            }else{
                index = mid;
                break;
            }
        }
        return index;
    } 
    int search(int l,int h,int target, MountainArray arr,boolean sort){
        int low = l;
        int high = h;
        if(sort){
            while(low<=high){
                int mid = low + (high-low)/2;
                if(arr.get(mid)==target){
                    return mid;
                }
                if(arr.get(mid)<target){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }else{
            while(low<=high){
                int mid = low + (high-low)/2;
                if(arr.get(mid)==target){
                    return mid;
                }
                if(arr.get(mid)<target){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}