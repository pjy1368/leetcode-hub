class Trie {

    private boolean isEnd = false;
    private Trie[] children = new Trie[26];

    public Trie() {

    }
    
    public void insert(String word) {
        if (word.length() == 0) {
            isEnd = true;
        } else {
            int index = word.charAt(0) - 'a';
            if (children[index] == null) {
                children[index] = new Trie();
            } 
            children[index].insert(word.substring(1));
        }
    }
    
    public boolean search(String word) {
        if (word.length() == 0) {
            return isEnd;
        }

        int index = word.charAt(0) - 'a';
        if (children[index] == null) {
            return false;
        }
        return children[index].search(word.substring(1));
    }
    
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) {
            return true;
        }

        int index = prefix.charAt(0) - 'a';
        if (children[index] == null) {
            return false;
        }
        return children[index].startsWith(prefix.substring(1));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */