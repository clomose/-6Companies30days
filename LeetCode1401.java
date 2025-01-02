class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int centerX = Math.max(x1,Math.min(x2,xCenter));
        int centerY = Math.max(y1,Math.min(y2,yCenter));
        
        int distX = xCenter - centerX;
        int distY = yCenter - centerY;
        if(distX*distX + distY*distY <= radius*radius){
            return true;
        }
        
        return false;
    }
}