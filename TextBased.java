import java.io.*;    
import java.util.Scanner; 

public class TextBased {
    
    static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            
            System.out.println("\n===== NOTES MANAGER =====");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                addNote(sc);
            } else if (choice == 2) {
                viewNotes();
            } else if (choice == 3) {
                System.out.println("Chlye Bye");
            } else {
                System.out.println("Invalid choice");
            }

        } while (choice != 3);

       
    }

    
    static void addNote(Scanner sc) {
        System.out.print("Enter your note: ");
        String note = sc.nextLine();

        try {
            FileWriter writer = new FileWriter(FILE_NAME, true); 
            writer.write(note + "\n");
            writer.close();
            System.out.println("Note saved!");
        } catch (IOException e) {
            System.out.println("Error saving note.");
        }
    }

    
    static void viewNotes() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            boolean empty = true;

            System.out.println("\n===== YOUR NOTES =====");
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
                empty = false;
            }
            reader.close();

            if (empty) {
                System.out.println("(No notes found)");
            }

        } catch (FileNotFoundException e) {
            System.out.println("(No notes found — file not created yet)");
        } catch (IOException e) {
            System.out.println("Error reading notes.");
        }
    }
}

