import java.io.*;
import java.util.Scanner;

public class UnorderedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String fileName = "words.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    list.append(word);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        System.out.println("Current List: " + list);
        System.out.print("Enter a word to search: ");
        String word = scanner.nextLine();

        if (list.search(word)) {
            list.delete(word);
            System.out.println("Word found and removed from the list.");
        } else {
            list.append(word);
            System.out.println("Word not found and added to the list.");
        }

        System.out.println("Updated List: " + list);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Node<String> current = list.head;
            while (current != null) {
                writer.write(current.data + " ");
                current = current.next;
            }
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
}

