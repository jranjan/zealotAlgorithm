package org.zealot.algorithm.academy;

public class WordDistance {
    public static int solution(String[] words, String word1, String word2) {
        int d1 = -1, d2 = -1, p1 = -1, p2 = -1, mind = -1;

        // assumes words is part of array
        if (word1 == word2) {
            return 0;
        }
        for (int start=0, end=words.length-1; start<words.length; start++, end--) {
            // forward search
            if (words[start].equals(word1) || words[start].equals(word2)) {
                String searchWord = (words[start] == word1) ? word2 : word1;
                for (int j=start+1; j<words.length; j++) {
                    if (words[j] == searchWord) {
                        p2 = j;
                        mind = d1 = (p2 - start);
                        break;
                    }
                }
            }

            // Backward search
            if (words[end].equals(word1) || words[end].equals(word2)) {
                p1 = end;
                String searchWord = (words[start] == word1) ? word2 : word1;
                for (int j=end-1; j>0; j--) {
                    if (words[j] == searchWord) {
                        p2 = j;
                        d2 = (p1 - p2);
                        mind = (mind != -1) ? ((d1 < d2) ? d1 : d2) : d2;
                        break;
                    }
                }
            }

           if (mind != -1) {
               return mind;
           }
        }

        return mind;
    }


    public static int solutionBirdirectionalPointer(String[] words, String word1, String word2) {
        int sd = words.length;
        int p1 = -1, p2 = -1;
        // assumes words is part of array
        if (word1 == word2) {
            return 0;
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) { // If the current word is word1, update the position1
                p1 = i;
            } else if (word.equals(word2)) { // If the current word is word2, update the position2
                p2 = i;
            }

            if (p1 != -1 && p2 != -1) {
                sd = Math.min(sd, Math.abs(p1 - p2));
            }
        }

        System.out.println("Bidirectional pointer = " + sd);
        return sd;
    }
}

