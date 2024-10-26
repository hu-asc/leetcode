package com.code.problemset.problem_1233;

import java.util.*;

/**
 * @author huhongtao
 * @date 2024-10-25
 */
public class RemoveSubfolders {

    /**
     * 使用 set
     * 判断 folder 中的每个字符串 s 的前缀是否在 set 中，如果存在则说明是子文件夹
     */
    public List<String> removeSubfolders(String[] folder) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(folder));
        for (String s : folder) {
            boolean isSub = false;
            String prefix = s;
            while (!prefix.isEmpty()) {
                int pos = prefix.lastIndexOf("/");
                if (pos == -1) {
                    break;
                }
                prefix = prefix.substring(0, pos);
                if (set.contains(prefix)) {
                    isSub = true;
                    break;
                }
            }
            if (!isSub) {
                result.add(s);
            }
        }
        return result;
    }



    TrieNode root = new TrieNode();

    /**
     * 构建 trie 树
     * 构建成功后，在遍历 folder，
     * 判断每个字符串是否已经在树中已经存在
     *
     */
    public List<String> removeSubfoldersV2(String[] folder) {
        for (String path : folder) {
            TrieNode curr = root;
            String[] split = path.split("/");
            for (String folderName : split) {
                if ("".equals(folderName)) {
                    continue;
                }
                if (!curr.children.containsKey(folderName)) {
                    curr.children.put(folderName, new TrieNode());
                }
                curr = curr.children.get(folderName);
            }
            curr.isEnd = true;
        }
        List<String> result = new ArrayList<>();
        for (String s : folder) {
            TrieNode curr = root;
            boolean isSub = false;
            String[] folderNames = s.split("/");
            for (int i = 0; i < folderNames.length; i++) {
                if ("".equals(folderNames[i])) {
                    continue;
                }
                TrieNode nextNode = curr.children.get(folderNames[i]);
                if (nextNode.isEnd && i != folderNames.length - 1) {
                    isSub = true;
                    break;
                }
                curr = nextNode;
            }
            if (!isSub) {
                result.add(s);
            }
        }
        return result;
    }

}

class TrieNode {
    Map<String, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}
