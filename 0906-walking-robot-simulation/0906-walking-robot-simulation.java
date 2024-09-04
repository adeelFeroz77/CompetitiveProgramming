class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y= 0;
        int face = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0;i<obstacles.length;i++){
            if(!map.containsKey(obstacles[i][0])){
                map.put(obstacles[i][0], new HashSet<>());
            }
            map.get(obstacles[i][0]).add(obstacles[i][1]);
        }
        int maxi = 0;
        int n = commands.length;
        for(int i=0;i<n;i++){
            int in = commands[i];
            if(in == -1){
                face++;
                face %= 4;
            }else if(in == -2){
                face --;
                face %= 4;
            }else{
                for(int j=0;j<in;j++){
                    int newX = x;
                    int newY = y;
                    if(face == 0){
                        newY++;
                    }else if(face == 1 || face == -3){
                        newX++;
                    }else if(face == 2 || face == -2){
                        newY--;
                    }else if(face == 3 || face == -1){
                        newX--;
                    }
                    if(map.containsKey(newX)){
                        if(map.get(newX).contains(newY)){
                            break;
                        }
                    }
                    x = newX;
                    y = newY;
                }
            }
            maxi = Math.max(maxi, x*x + y*y);
            System.out.println(x + " " + y);
        }
        return maxi;
    }
}