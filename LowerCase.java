/** String processing exercise 1. */
public class LowerCase {
    // main(string[]) - the entry point of a Java program.
    // args - args contains the supplied command-line
    // arguments as an array of String objects.
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }

   /**
    * Returns a string which is identical to the original string, 
    * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    */
    public static String lowerCase(String s) {
        // declaring a new empty string which will comtain the original string with lower case characters.
        String loweString = "";
        for (int i = 0; i < s.length(); i++) {
            // check if a certain character is an upper case character.
            if ((s.charAt(i) >= 'A') && (s.charAt(i) <= 'Z')) {
                // input the lower case version of the upper cased character.
                loweString += (char)(s.charAt(i) + 32);
            }
            else {
                loweString += s.charAt(i);
            }
        }
        return loweString;
    }
}
