import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        library.addBook(new Book("Java Programming", "Author A", "12345"));
        library.addBook(new Book("Python Programming", "Author B", "67890"));
        library.registerMember(new Member("Alice", "M001", "alice@example.com"));
        library.registerMember(new Member("Bob", "M002", "bob@example.com"));
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String ISBN = scanner.nextLine();
                    library.addBook(new Book(title, author, ISBN));
                    break;

                case 2:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter member email: ");
                    String email = scanner.nextLine();
                    library.registerMember(new Member(name, memberId, email));
                    break;

                case 3:
                    System.out.print("Enter book title to borrow: ");
                    title = scanner.nextLine();
                    Book bookToBorrow = library.searchBook(title);
                    if (bookToBorrow != null) {
                        System.out.print("Enter member ID: ");
                        memberId = scanner.nextLine();
                        for (Member member : library.members) {
                            if (member.getMemberId().equals(memberId)) {
                                member.borrowBook(bookToBorrow);
                                break;
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter book title to return: ");
                    title = scanner.nextLine();
                    Book bookToReturn = library.searchBook(title);
                    if (bookToReturn != null) {
                        System.out.print("Enter member ID: ");
                        memberId = scanner.nextLine();
                        for (Member member : library.members) {
                            if (member.getMemberId().equals(memberId)) {
                                member.returnBook(bookToReturn);
                                break;
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter book title to search: ");
                    title = scanner.nextLine();
                    library.searchBook(title);
                    break;

                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
