import java.util.Scanner;

public class TypeSpeedProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String textToType = "The quick brown fox jumps over the lazy dog.";

        // Display the text to type
        System.out.println("Welcome to the Type Speed Program!");
        System.out.println("Type the following text as fast and accurately as you can:");
        System.out.println("\"" + textToType + "\"");
        System.out.println("\nPress Enter when you are ready to start...");

        scanner.nextLine(); // Wait for user to press Enter
        System.out.println("\nStart typing now! Press Enter when you are done.");

        // Start the timer
        long startTime = System.nanoTime();

        // Take user input
        String userInput = scanner.nextLine();

        // Stop the timer
        long endTime = System.nanoTime();

        // Calculate the time taken in seconds
        long durationInNano = endTime - startTime;
        double timeInSeconds = durationInNano / 1.0 / 1_000_000_000;

        // Calculate typing speed
        double wordsTyped = userInput.split("\\s+").length; // Count words
        double speed = (wordsTyped / timeInSeconds) * 60; // Words per minute

        // Calculate accuracy
        double accuracy = calculateAccuracy(userInput, textToType);

        // Display results
        System.out.println("\nTyping Test Results:");
        System.out.printf("Time Taken: %.2f seconds%n", timeInSeconds);
        System.out.printf("Typing Speed: %.2f words per minute%n", speed);
        System.out.printf("Accuracy: %.2f%%%n", accuracy);

        scanner.close();
    }

    /**
     * Calculate typing accuracy by comparing the user input to the reference text.
     */
    private static double calculateAccuracy(String userInput, String originalText) {
        String[] userWords = userInput.split("\\s+");
        String[] originalWords = originalText.split("\\s+");

        int correctWords = 0;

        for (int i = 0; i < Math.min(userWords.length, originalWords.length); i++) {
            if (userWords[i].equalsIgnoreCase(originalWords[i])) {
                correctWords++;
            }
        }

        return (correctWords / (double) userWords.length) * 100;
    }
}
