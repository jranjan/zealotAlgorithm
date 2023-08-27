package org.zealot.algorithm.scratchpad.one;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | EXCELLENT | REVISIT
 *****************************************************************************************************/
public class ComputeShortestWordDistance {
    public static int compute(String[] words, String word1, String word2) {
       int shortDistance = -1;
       int firstKeyPosition = -1;
       String searhKey = "";
       for(int i = 0; i < words.length; i++){
           if ((words[i].equals(word1)) || (words[i].equals(word2))) {
               if (firstKeyPosition == -1) {
                   // Found the first tome
                   firstKeyPosition = i;
                   // set the search key to be found
                   searhKey = (words[i].equals(word2)) ? word1 : word2;
                   if (word1.equals(word2)) {
                       return 0;
                   }
               } else {
                   if (words[i].equals(searhKey)) {
                       // we found the search key, let us compute the short distance
                       if (shortDistance == -1) {
                           shortDistance = i - firstKeyPosition;
                       } else {
                           int currDistance = i - firstKeyPosition;
                           shortDistance = (shortDistance > currDistance) ? currDistance : shortDistance;
                       }
                       // Let us again start searching fresh for new key
                       searhKey = word1.equals(searhKey) ? word2 : word1;
                   }
                   firstKeyPosition = i;
               }
           }
       }

       return shortDistance;
    }
}
