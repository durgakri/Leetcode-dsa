import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // Exact matches
        Set<String> exactSet = new HashSet<>(Arrays.asList(wordlist));

        // Case-insensitive matches
        Map<String, String> caseMap = new HashMap<>();

        // Vowel-error matches
        Map<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            String lower = word.toLowerCase();
            caseMap.putIfAbsent(lower, word);

            String devowel = devowel(lower);
            vowelMap.putIfAbsent(devowel, word);
        }

        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            if (exactSet.contains(q)) {
                result[i] = q; // Rule 1: Exact match
            } else {
                String lowerQ = q.toLowerCase();

                if (caseMap.containsKey(lowerQ)) {
                    result[i] = caseMap.get(lowerQ); // Rule 2: Case-insensitive match
                } else {
                    String devowelQ = devowel(lowerQ);

                    if (vowelMap.containsKey(devowelQ)) {
                        result[i] = vowelMap.get(devowelQ); // Rule 3: Vowel-error match
                    } else {
                        result[i] = ""; // No match
                    }
                }
            }
        }

        return result;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
