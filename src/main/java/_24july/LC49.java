package _24july;
import java.util.*;

/*
* 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

字母异位词 是由重新排列源单词的所有字母得到的一个新单词。



示例 1:

输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
示例 2:

输入: strs = [""]
输出: [[""]]
示例 3:

输入: strs = ["a"]
输出: [["a"]]


提示：

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] 仅包含小写字母
* */
public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String key = new String(tmp);
            List<String> value =  map.getOrDefault(key,new ArrayList<>());
            value.add(str);
            map.put(key,value);
        }
        List<List<String>> res = new ArrayList<>();
        for(String key:map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
}
