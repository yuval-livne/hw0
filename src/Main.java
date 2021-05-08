import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    /**
     * Prints a message according to a given grade.
     *
     * It is guaranteed that the grade is within the range [0, 100].
     *
     * @param grade The grade
     */
    public static void gradeMessage(int grade) {
        /*
        TODO: Your code for part A is here...
         */
        switch (grade/10){
            case 10:
                System.out.println("Excellent");
                break;
            case 9:
                System.out.println("Great");
                break;
            case 8:
                System.out.println("Very good");
                break;
            case 7:
                System.out.println("Good");
                break;
            default:
                System.out.println("OK");

        }

    }

    /**
     * Compresses a given string.
     *
     * The compression process is done by replacing a sequence of identical consecutive characters
     * with that same character followed by the length of sequence.
     *
     * It is guaranteed that the string contains only letters (lowercase and uppercase).
     *
     * @param stringToCompress The string to compress
     * @return The compressed version of the string
     */
    public static String compressString(String stringToCompress) {
        /*
        TODO: Your code for part B1 is here...
        Note: you may change the given code, but you must not change the signature of the method.
         */
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a string");
//        String str = scanner.nextLine();
        StringBuilder compressedString = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < stringToCompress.length(); i++) {
            countConsecutive++;
// If next character is different than current append this char to result
            if (i + 1 >= stringToCompress.length() ||
                    stringToCompress.charAt(i) !=
                            stringToCompress.charAt(i + 1)) {
                compressedString.append(stringToCompress.charAt(i));
                compressedString.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressedString.toString();
    }

    /**
     * Decompresses a given string.
     *
     * The decompression process is done by duplicating each sequence of characters
     * according to the number which appears after the sequence.
     *
     * It is guaranteed that the string is a legal compressed string.
     *
     * @param compressedString The string to decompress
     * @return The decompressed string
     */
    public static String decompressString(String compressedString) {
        String decompressedString = "";

        /*
        TODO: Your code for part B2 is here...
        Note: you may change the given code, but you must not change the signature of the method.
         */

        return decompressedString;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = args[0];
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        // Tests for part A
        int numberOfGrades = scanner.nextInt();
        for (int i = 0; i < numberOfGrades; i++) {
            int grade = scanner.nextInt();
            gradeMessage(grade);
        }

        // Tests for part B1
        int numberOfStringsToCompress = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfStringsToCompress; i++) {
            String stringToCompress = scanner.nextLine();
            String compressedString = compressString(stringToCompress);
            System.out.println("The compressed version of " + stringToCompress + " is " + compressedString);
        }

        // Tests for part B2
        int numberOfDecompressedStrings = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfDecompressedStrings; i++) {
            String compressedString = scanner.nextLine();
            String decompressedString = decompressString(compressedString);
            System.out.println("The decompressed version of " + compressedString + " is " + decompressedString);
        }

        // Tests for both part B1 and B2
        int numberOfCombinedTests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfCombinedTests; i++) {
            String stringToCompress = scanner.nextLine();
            String compressedString = compressString(stringToCompress);
            String decompressedString = decompressString(compressedString);
            System.out.println("decompress(compress(" + stringToCompress + ")) == " + stringToCompress + "? " + stringToCompress.equals(decompressedString));
        }
    }
}
