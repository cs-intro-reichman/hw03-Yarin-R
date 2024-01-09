/** String processing exercise 1. */
public class lowerCase {
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
        String loweString = "";
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'A') && (s.charAt(i) <= 'Z')) {
                loweString += (char)(s.charAt(i) + 32);
            }
            else {
                loweString += s.charAt(i);
            }
        }
        return loweString;
    }
}
