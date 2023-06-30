package acwing;

// 高效存储和查找字符串集合的数据结构
// https://leetcode.cn/problems/implement-trie-prefix-tree/
public class TrieTree {

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    // 用来存储子节点的二维数组 son
    private int[][] son;

    // 用来记录出现次数的数组cnt
    private int[] cnt;

    // 用来记录字符串中字母位置的idx
    private int idx;

    private int N = 100010;


    public TrieTree() {

        this.son = new int[N][26];
        this.cnt = new int[N];
        this.idx = 0;

    }

    public void insert(String word) {

        // 根节点
        int p = 0;

        for (int i = 0; i < word.length(); i++) {

            // 获得当前字符
            int u = word.charAt(i) - 'a';
            // 子节点存在当前字符，继续向下插入
            if (this.son[p][u] > 0) {
                p = this.son[p][u];
            } else {// 为子节点赋值
                this.son[p][u] = ++this.idx;
                p = this.son[p][u];
            }

        }

        // 该位置为字符串终点，记录位置
        this.cnt[p] += 1;

    }

    public boolean search(String word) {
        // 根节点
        int p = 0;

        for (int i = 0; i < word.length(); i++) {

            // 获得当前字符
            int u = word.charAt(i) - 'a';
            // 子节点存在当前字符，继续向下查找
            if (this.son[p][u] > 0) {
                p = this.son[p][u];
            } else {// 查找失败
                return false;
            }

        }

        // 确认到达了字符串末尾
        return this.cnt[p] > 0;

    }

    public boolean startsWith(String prefix) {

        // 根节点
        int p = 0;

        for (int i = 0; i < prefix.length(); i++) {

            // 获得当前字符
            int u = prefix.charAt(i) - 'a';
            // 子节点存在当前字符，继续向下查找
            if (this.son[p][u] > 0) {
                p = this.son[p][u];
            } else {// 查找失败
                return false;
            }

        }

        // 无需到达末尾
        return true;

    }
}
