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
                System.out.println("Very Good");
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
     * The compression process is done by replacing
     * a sequence of identical consecutive characters
     * with that same character followed by the length of sequence.
     *
     * It is guaranteed that the string contains
     * only letters (lowercase and uppercase).
     *
     * @param stringToCompress The string to compress
     * @return The compressed version of the string
     */
    public static String compressString(String stringToCompress) {
        StringBuilder compressedString = new StringBuilder();
        int countConsecutive = 0;
        int len = stringToCompress.length();
        for (int i = 0; i < len; i++) {
            countConsecutive++;
        // If next character is different
            // than current append this char to result
            if (i + 1 >= len ||
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
     * The decompression process is done
     * by duplicating each sequence of characters
     * according to the number which appears after the sequence.
     *
     * It is guaranteed that the string is a legal compressed string.
     *
     * @param compressedString The string to decompress
     * @return The decompressed string
     */
    public static String decompressString(String compressedString) {
        StringBuilder tempSequence = new StringBuilder();
        StringBuilder times = new StringBuilder();
        StringBuilder decompressedString = new StringBuilder();
        int len = compressedString.length();
        for (int i = 0; i < len; i++) {
            char currentChar = compressedString.charAt(i);
//            if the current character is a digit check if there are more
//            digits after it
            if (currentChar >= '0'
                    && currentChar <= '9'){
                do {
                    times.append(currentChar);
                    i++;
                    if (i < len)
                        currentChar = compressedString.charAt(i);
                    else
                        break;
                }
                while (currentChar >= '0' && currentChar <= '9');
                i--;
//                get the repetitions number for the last sequence
                int number = Integer.parseInt(times.toString());
//                add the last sequence multiplied by repetitions number
                for (int j = 0; j < number; j++){
                    decompressedString.append(tempSequence);
                }
//                reset the strings to empty strings
                times.delete(0, times.length());
                tempSequence.delete(0, tempSequence.length());
            }
            else {
                tempSequence.append(currentChar);
            }
        }

        return decompressedString.toString();
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
            System.out.println("The compressed version of " + stringToCompress
                    + " is " + compressedString);
        }

        // Tests for part B2
        int numberOfDecompressedStrings = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfDecompressedStrings; i++) {
            String compressedString = scanner.nextLine();
            String decompressedString = decompressString(compressedString);
            System.out.println("The decompressed version of "
                    + compressedString + " is " + decompressedString);
        }

        // Tests for both part B1 and B2
        int numberOfCombinedTests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfCombinedTests; i++) {
            String stringToCompress = scanner.nextLine();
            String compressedString = compressString(stringToCompress);
            String decompressedString = decompressString(compressedString);
            System.out.println("decompress(compress(" +
                    stringToCompress + ")) == " + stringToCompress +
                    "? " + stringToCompress.equals(decompressedString));
        }
    }
}
