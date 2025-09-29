public class Screen {
    public void displayMessage(String message) { System.out.println("SCREEN: " + message); }
    public void displayOptions(String[] options) {
        System.out.println("SCREEN: Please select an option:");
        for (int i = 0; i < options.length; i++) {
            System.out.println("  " + (i + 1) + ". " + options[i]);
        }
    }
}

