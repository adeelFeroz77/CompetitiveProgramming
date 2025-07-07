class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.sort(events, (a,b) -> {
            if(a[0] != b[0]){
                return a[0]-b[0];
            }
            return b[1] - a[1];
        });

        int day = events[0][0];
        int i = 0;
        int ans = 0;

        while(!pq.isEmpty() || i < n){
            
            if(pq.isEmpty()){
                day = events[i][0];
            }

            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }

            while(i<n && events[i][0] == day){
                pq.add(events[i][1]);
                i++;
            }

            if(!pq.isEmpty()){
                int x = pq.poll();
                System.out.println("day: " + day + "val: " + x);
                ans++;
            }

            day++;
        }

        return ans;

    }
}