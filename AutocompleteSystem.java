import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class AutocompleteSystem {
    class TrieNode implements Comparable<TrieNode>{
        TrieNode[] children;
        String s;
        int times;
        List<TrieNode> hot;

        public TrieNode(){
            this.children=new TrieNode[128];
            s=null;
            times=0;
            hot=new ArrayList();
        }

        public int compareTo(TrieNode o){
            if(this.times==o.times){
                return this.s.compareTo(o.s);
            }
            else return o.times-this.times;
        }

        public void update(TrieNode node){
            if(!this.hot.contains(node))
                this.hot.add(node);

            Collections.sort(hot);

            if(this.hot.size()>3){
                this.hot.remove(hot.size()-1);
            }
        }
    }

    StringBuilder sb;
    TrieNode root;
    TrieNode cur;
    public AutocompleteSystem(String[] sentences, int[] times) {
        sb=new StringBuilder();
        root=new TrieNode();
        cur=root;

        for(int i=0;i<times.length;i++){
            add(sentences[i],times[i]);
        }
    }

    public void add(String sent,int time){
        TrieNode temp=root;
        List<TrieNode> visited=new ArrayList();
        for(char c:sent.toCharArray()){
            if(temp.children[c]==null){
                temp.children[c]=new TrieNode();
            }

            temp=temp.children[c];
            visited.add(temp);
        }

        temp.s=sent;
        temp.times+=time;

        for(TrieNode node:visited){
            node.update(temp);
        }
    }

    public List<String> input(char c) {
        List<String> res=new ArrayList();
        if(c=='#'){
            add(sb.toString(),1);
            sb=new StringBuilder();
            cur=root;
            return res;
        }
        sb.append(c);
        if(cur!=null)
            cur=cur.children[c];
        if(cur==null) return res;
        for(TrieNode node:cur.hot)
            res.add(node.s);

        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */