package leetcode75;

/**
 * You are given an array of strings products and a string searchWord.
 *
 * Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
 *
 * Return a list of lists of the suggested products after each character of searchWord is typed.
 *
 * Example 1:
 *
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
 * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
 * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"].
 * Example 2:
 *
 * Input: products = ["havana"], searchWord = "havana"
 * Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * Explanation: The only word "havana" will be always suggested while typing the search word.
 */


public class SearchSuggessionSystem_1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products); // Sort the products lexicographically

        int left = 0;
        int right = products.length - 1;

        // For each character in the searchWord, narrow down the range of matching products
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            List<String> word = new ArrayList<>();

            // Move 'left' forward to exclude products that don't match the current prefix
            while (left <= right &&
                    (products[left].length() <= i || products[left].charAt(i) != c)) {
                left++;
            }

            // Move 'right' backward to exclude products that don't match the current prefix
            while (left <= right &&
                    (products[right].length() <= i || products[right].charAt(i) != c)) {
                right--;
            }

            // Add the first 3 products from the remaining range [left, right]
            for (int j = 0; j < 3 && left + j <= right; j++) {
                word.add(products[left + j]);
            }

            result.add(word); // Add the current word suggestion list to the result
        }

        return result;
    }
}
