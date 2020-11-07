public class TrieImpl {
    class Node{
        int prefix;
        int end;
        char ch;
        Node[] children=new Node[26];
        public Node(){}

        public Node(int prefix,int end,char ch){
            this.prefix=prefix;
            this.end=end;
            this.ch=ch;
        }
    }
    /** Initialize your data structure here. */
    Node root;
    public TrieImpl() {
        this.root=new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int len=word.length();
        Node cur=root;
        int prefixLength;
        int max=0;
        for(int i=0;i<len;i++){
            char ch=word.charAt(i);
            int idx=ch-'a';
            if(cur.children[idx]==null){
                cur.children[idx]=new Node(1,0,ch);
            }else{
                prefixLength=cur.children[idx].prefix;
                prefixLength++;
                max=Math.max(max,prefixLength);
            }
            cur=cur.children[idx];
        }
        cur.end++;
        System.out.println(max);
        deleteWord(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur=root;
        int len=word.length();

        for(int i=0;i<len;i++){
            char ch=word.charAt(i);
            int idx=ch-'a';
            cur=cur.children[idx];
            if(cur==null) return false;
        }
        return cur.end>0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur=root;
        int len=prefix.length();

        for(int i=0;i<len;i++){
            char ch=prefix.charAt(i);
            int idx=ch-'a';
            cur=cur.children[idx];
            if(cur==null) return false;
        }
        return cur.prefix>0;
    }

    public void deleteWord(String prefix) {
        Node cur=root;
        int len=prefix.length();

        for(int i=0;i<len;i++){
            char ch=prefix.charAt(i);
            int idx=ch-'a';
            Node temp=cur.children[idx];
            if(temp==null) return ;
            else{
                temp.prefix--;
                if(temp.prefix==0){
                    cur.children[idx]=null;
                    return;
                }
            }
        }
        cur.end--;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */