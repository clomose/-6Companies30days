class TrieNode{
    HashMap<Character,TrieNode> children;
    boolean isWord;
    public TrieNode(){
        children = new HashMap<>();
        isWord = false;
    }
}


class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!node.children.containsKey(c)){
                node.children.put(c,new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return helper(root,word,0);
    }
    
    boolean helper(TrieNode root,String word,int index){
        if(index==word.length()){
            return root.isWord;
        }
        char c = word.charAt(index);
        if(c=='.'){
            for(TrieNode child : root.children.values()){
                if(helper(child,word,index+1)){
                    return true;
                }
            }
            return false;
        }else{
            TrieNode child = root.children.get(c);
            if(child==null){
                return false;
            }
            return helper(child,word,index+1);
        }
    }
}
