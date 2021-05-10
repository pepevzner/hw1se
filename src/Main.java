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
        switch (grade/10){
            case 7:
                System.out.println("Good");
                break;
            case 8:
                System.out.println("Very Good");
                break;
            case 9:
                System.out.println("Great");
                break;
            case 10:
                System.out.println("Excellent");
                break;
            default:
                System.out.println("OK");
                break;
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
        StringBuilder compressedString = new StringBuilder();
        char current=stringToCompress.charAt(0);
        int counter=1;
        for (int i=1;i<stringToCompress.length();i++){
            if(current!=stringToCompress.charAt(i)){
                compressedString.append(""+current+counter);
                current=stringToCompress.charAt(i);
                counter=0;
            }
            counter++;
        }
        compressedString.append(""+current+counter);

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
        StringBuilder decompressedString = new StringBuilder();
        String sequence;
        int count,i=0;
        while(i<compressedString.length()) {
            sequence="";
            while(Character.isLetter(compressedString.charAt(i))){
                sequence+=compressedString.charAt(i);
                i++;
            }
            count=0;
            while(i<compressedString.length()&&Character.isDigit(compressedString.charAt(i))){
                count*=10;
                count+=Integer.parseInt(""+compressedString.charAt(i)) ;
                i++;
            }
            for (int j=0;j<count;j++)
                decompressedString.append(sequence);
        }

        return decompressedString.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        //String filePath = args[0];
        //File file = new File(filePath);
        Scanner scanner = new Scanner(System.in);

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
