package array;

import java.util.*;

public class WordLadderII {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("hot");
        l.add("dot");
        l.add("dog");
        l.add("lot");
        l.add("log");
        l.add("cog");
        List<List<String>> ll = findLadders("hit", "cog", l);
        ll.forEach(n -> {
            n.forEach(m -> System.out.print(m + " "));
            System.out.println();
        });
    }


    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList == null || wordList.size() == 0) return res;
        Set<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord)) return res;

        Map<String, List<String>> graph = new HashMap<>();
        Set<String> curLevel = new HashSet<>();
        curLevel.add(beginWord);

        boolean foundEnd = false;


        //cant use queue as once flag is set it will come out of the loop and will not execute all the shortest scenarios.
        /*while (!curLevel.isEmpty() && !foundEnd) {
            wordDict.removeAll(curLevel);
            List<String> tmpList = new ArrayList<>();
            String word = null;

            while ((word = curLevel.poll()) != null) {
                graph.put(word, new ArrayList<>());
                StringBuilder sb = new StringBuilder(word);
                for (int j = 0; j < word.length(); j++) {
                    char temp = sb.charAt(j);
                    for (char i = 'a'; i <= 'z'; i++) {
                        if(i==temp) continue;
                        sb.setCharAt(j, i);
                        if (!wordDict.contains(sb.toString())) continue;
                        graph.get(word).add(sb.toString());
                        tmpList.add(sb.toString());
                        foundEnd = word.equals(endWord);
                    }
                    sb.setCharAt(j, temp);
                }
            }
            curLevel.addAll(tmpList);
        }*/

        //bfs
        while (!curLevel.isEmpty() && !foundEnd) {
            wordDict.removeAll(curLevel); //this is important for minimizing the graph size, and avoid backtrack of the path
            Set<String> nextLevel = new HashSet<>();
            for (String s : curLevel) {
                graph.put(s, new ArrayList<>());
                char[] cur = s.toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    char c = cur[j];
                    for (char r = 'a'; r <= 'z'; r++) {
                        if (r == c) continue;
                        cur[j] = r;
                        String temp = new String(cur);
                        if (!wordDict.contains(temp)) continue;
                        graph.get(s).add(temp);
                        nextLevel.add(temp);
                        if (temp.equals(endWord)) {
                            foundEnd = true;
                        }
                    }
                    cur[j] = c;
                }
            }
            curLevel = nextLevel;
        }

        if (!foundEnd) return res;
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        addPath(beginWord, endWord, res, graph, list);
        return res;
    }

    //dfs
    private static void addPath(String from, String to, List<List<String>> res,
                                Map<String, List<String>> graph, List<String> list) {
        if (from.equals(to)) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (!graph.containsKey(from)) return;
        for (String next : graph.get(from)) {
            list.add(next);
            addPath(next, to, res, graph, list);
            list.remove(list.size() - 1);
        }
    }
}

