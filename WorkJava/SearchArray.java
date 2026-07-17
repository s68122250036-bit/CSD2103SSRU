import java.util.Scanner;

public class SearchArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] names = {"Somchai", "Somsri", "Anan", "Malee", "Suda"};

        System.out.print("Enter name to search: ");
        String searchName = input.nextLine();

        boolean found = false;

        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(searchName)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }

        input.close();
    }
}