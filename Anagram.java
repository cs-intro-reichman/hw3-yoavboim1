import java.nio.file.FileAlreadyExistsException;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		for (int i = 0; i < str1.length(); i++){

			char c = str1.charAt(i);
			boolean charIsInStr2 = false;

			for (int j = 0; j < str2.length(); j++){
				char c2 = str2.charAt(j);
				if (c == c2){
					charIsInStr2 = true;
					str2 = str2.substring(0, j) + str2.substring(j + 1);
					break; // if c is in c2, go to next c of str1...
				}	
			}
			if (charIsInStr2 == false){
				return false;
			}
		}

		if (str2.isEmpty()){
			return true;
		}
		return false;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String result = "";

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (Character.isLetter(c)) {
				result += Character.toLowerCase(c);
			}
		}

		return result;
	}
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
        String shuffled = "";
        String remaining = str;

        for (int i = str.length(); i > 0; i--) {
            int index = (int)(Math.random() * remaining.length());
            char c = remaining.charAt(index);
            shuffled += c;
            remaining = remaining.substring(0, index) + remaining.substring(index + 1);
        }
		return shuffled;
	}
}
