class Solution {
    public String sortVowels(String s) {
        String vowels = "aeiouAEIOU";
        List<Character> vowelList = new ArrayList();

        //Step 1: Extract vowels
        for(char ch : s.toCharArray()){
            if(vowels.indexOf(ch) != -1){
                vowelList.add(ch);
            }
        }

        //Step 2:Sort vowels by ASCII
        Collections.sort(vowelList);

        //Step 3: Build result
        StringBuilder result = new StringBuilder();
        int idx = 0; //pointer for sorted vowels

        for(char ch : s.toCharArray()){
            if(vowels.indexOf(ch) != -1){
                result.append(vowelList.get(idx++)); //put next sorted vowel

            }else{
                result.append(ch); //consonant stays
            }
        }
        return result.toString();


    }
}