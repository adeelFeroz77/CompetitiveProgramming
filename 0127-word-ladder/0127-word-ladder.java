class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=wordList.size();i++){
            adj.add(new ArrayList<>());
        }
        int target = -1;
        for(int i=0;i<wordList.size();i++){
            if(compareStrings(beginWord,wordList.get(i))==1){
                adj.get(0).add(i+1);
                adj.get(i+1).add(0);
            }
            if(wordList.get(i).equals(endWord)){
                target = i+1;
            }
        }
        if(target==-1){
            return 0;
        }
        for(int i=0;i<wordList.size();i++){
            for(int j=i+1;j<wordList.size();j++){
                if(compareStrings(wordList.get(i),wordList.get(j))==1){
                    adj.get(i+1).add(j+1);
                    adj.get(j+1).add(i+1);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        Queue<Word> queue = new LinkedList<>();
        int [] visited = new int[wordList.size()+1];
        queue.add(new Word(0,1));
        visited[0] = 1;
        while(!queue.isEmpty()){
            Word node = queue.remove();
            for(Integer n: adj.get(node.index)){
                if(visited[n]==0){
                    queue.add(new Word(n,node.pos+1));
                    visited[n] = 1;
                }
                if(n==target){
                    ans = Math.min(ans,node.pos+1);
                }
            }
        }
        if(ans == Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }

    public static int compareStrings(String s1, String s2){
        int diff = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                diff++;
            }
        }
        return diff;
    }
}

class Word{
    int index;
    int pos;
    Word(int index,int pos){
        this.index = index;
        this.pos = pos;
    }
}