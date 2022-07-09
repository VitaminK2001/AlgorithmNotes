package 回溯.单词搜索2;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    String word;
    Map<Character, Trie> children;
    public Trie(){
        this.word = "";
        this.children = new HashMap<>();
    }
    public void insert(String word){
        Trie cur = this;
        for(int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)){
                cur.children.put(c, new Trie());
            }
            cur = cur.children.get(c);
        }
        cur.word = word; //标记是最后一个
    }
}
