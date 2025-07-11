import java.util.*;

public class PasswordPuzzleGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wordCount;

        // Step 1: Get number of words (3 to 5)
        do {
            System.out.print("How many words would you like to enter? (3-5): ");
            wordCount = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        } while (wordCount < 3 || wordCount > 5);

        // Step 2: Input and clean words
        String[] words = new String[wordCount];

        for (int i = 0; i < wordCount; i++) {
            System.out.print("Enter word " + (i + 1) + ": ");
            String input = scanner.nextLine().trim();
            words[i] = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
        }

        // Step 9: Sort the array alphabetically
        Arrays.sort(words);

        boolean happy = false;

        while (!happy) {
            // Step 2 continued: Show cleaned & sorted words
            System.out.println("\nYour cleaned and sorted words:");
            for (int i = 0; i < words.length; i++) {
                System.out.println((i + 1) + ". " + words[i]);
            }

            // Step 3: User selects two words
            int firstChoice, secondChoice;
            do {
                System.out.print("Choose the first word number: ");
                firstChoice = scanner.nextInt() - 1;
                System.out.print("Choose the second word number: ");
                secondChoice = scanner.nextInt() - 1;
                scanner.nextLine(); // Consume newline
            } while (firstChoice < 0 || firstChoice >= wordCount || secondChoice < 0 || secondChoice >= wordCount);

            String word1 = words[firstChoice];
            String word2 = words[secondChoice];

            // Step 8: Let user choose a special symbol
            System.out.print("Choose a special character (@, #, $, !, etc.): ");
            char specialChar = scanner.nextLine().charAt(0);

            // Step 4: Build password
            String reversed = new StringBuilder(word1).reverse().toString();
            String part2 = word2.length() >= 3 ? word2.substring(0, 3) : word2;
            int totalLength = word1.length() + word2.length();
            String password = reversed + specialChar + part2 + totalLength;

            // Step 5: Check for vowel
            boolean startsWithVowel = "AEIOUaeiou".indexOf(password.charAt(0)) != -1;

            // Step 6: Display formatted result
            System.out.println(String.format("\nYour generated password is: %s", password));
            System.out.println("Starts with a vowel? " + (startsWithVowel ? "Yes" : "No"));

            // Step 7: Ask if user is happy
            System.out.print("\nAre you happy with your password? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("yes")) {
                happy = true;
                System.out.println("Password generation complete!");
            }
        }

        scanner.close();
    }
}
