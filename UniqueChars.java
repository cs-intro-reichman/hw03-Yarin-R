/** String processing exercise 2. */
public class UniqueChars {
    // main(string[]) - the entry point of a Java program.
    // args - args contains the supplied command-line
    // arguments as an array of String objects.
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    
    // isIn - checks if a character(c) is in a string(s).
    private static boolean isIn(char c, String s) {
		for (int i = 0; i < s.length(); i++) {
            // check if character(c) is equal to each character in string(s) one by one.
            if (c == s.charAt(i)) {
                return true;
            }
        }
        return false;
    }

     // uniqueChars - returns a string without any indentical characters except for " "
     // in the order and content provided by string(s).
    public static String uniqueChars(String s) {
        // declaring the new string withe unique characters as an empty string.
        String uniqString = "";
        for (int i = 0; i < s.length(); i++) {
            if (!(isIn(s.charAt(i), uniqString)) || (s.charAt(i) == ' ')) {
                // adding a unique character or a " " to the string withe the unique characters.
                uniqString += s.charAt(i);
            }
        }
        return uniqString;
    }
}
