class Solution {
    LinkedList<String> ans = new LinkedList<>();
    Map<String, PriorityQueue<String>> adjMap = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for(int i=0; i<tickets.size(); i++){
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);

            adjMap.putIfAbsent(from, new PriorityQueue<>());

            adjMap.get(from).add(to);
        }

        dfs("JFK");

        return ans;
    }

    public void dfs(String node){
        PriorityQueue<String> pq = adjMap.get(node);
        while(pq != null && !pq.isEmpty()){
            dfs(pq.poll());
        }
        ans.addFirst(node);
    }
}