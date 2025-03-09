class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int n = colors.length;
        int ans = 0;
        queue.add(colors[0]);
        for(int i=1;i<n+k-1;i++){
            if(!queue.isEmpty() && colors[i%n] != queue.peekLast()){
                queue.add(colors[i%n]);
            }else if(!queue.isEmpty()){
                queue.removeFirst();
                i--;
            }else{
                queue.add(colors[i%n]);
            }
            if (queue.size() == k){
                ans++;
                queue.removeFirst();
            }
        }
        return ans;
    }
}