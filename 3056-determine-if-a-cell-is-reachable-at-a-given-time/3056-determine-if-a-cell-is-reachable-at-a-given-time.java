class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(fx == sx && fy == sy && t == 1){
            return false;
        }
        int x = Math.abs(fx-sx);
        int y = Math.abs(fy-sy);
        return t>=Math.max(x,y);
    }
}