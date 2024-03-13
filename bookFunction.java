package Library;

import java.util.List;
import java.util.Scanner;

public class bookFunction {

	public static void displayMenu() {
		System.out.println("1-Add Record");
		System.out.println("2-List");
		System.out.println("3-Search by Name");
		System.out.println("4-Correction");
		System.out.println("5-Deletion");
		System.out.println("6-Average");
		System.out.println("7-Whose Book Has the Most Pages");
		System.out.println("8-Whose Book Has the Fewest Pages");
		System.out.println("9-Exit");
		System.out.print("Make your choice: ");
	}

	public static void addBook(List<String> bookTitles, List<String> authors, List<String> publishers,
			List<Integer> pageCounts, List<Integer> publicationYears, List<Double> prices, Scanner scanner) {
		System.out.print("Book Title: ");
		String bookTitle = scanner.next();
		System.out.print("Author: ");
		String author = scanner.next();
		System.out.print("Publisher: ");
		String publisher = scanner.next();
		System.out.print("Page Count: ");
		int pageCount = scanner.nextInt();
		System.out.print("Publication Year: ");
		int publicationYear = scanner.nextInt();
		System.out.print("Price: ");
		double price = scanner.nextDouble();

		bookTitles.add(bookTitle);
		authors.add(author);
		publishers.add(publisher);
		pageCounts.add(pageCount);
		publicationYears.add(publicationYear);
		prices.add(price);

		System.out.println("Book added successfully.");
	}

	public static void listBooks(List<String> bookTitles, List<String> authors, List<String> publishers,
			List<Integer> pageCounts, List<Integer> publicationYears, List<Double> prices) {
		if (bookTitles.isEmpty()) {
			System.out.println("No books in the list.");
		} else {
			for (int i = 0; i < bookTitles.size(); i++) {
				System.out.println("Book Title: " + bookTitles.get(i));
				System.out.println("Author: " + authors.get(i));
				System.out.println("Publisher: " + publishers.get(i));
				System.out.println("Page Count: " + pageCounts.get(i));
				System.out.println("Publication Year: " + publicationYears.get(i));
				System.out.println("Price: " + prices.get(i));
				System.out.println("-----------------------");
			}
		}
	}

	public static void searchBook(List<String> bookTitles, List<String> authors, List<String> publishers,
			List<Integer> pageCounts, List<Integer> publicationYears, List<Double> prices, String searchedBookTitle) {
		boolean found = false;
		for (int i = 0; i < bookTitles.size(); i++) {
			if (bookTitles.get(i).equalsIgnoreCase(searchedBookTitle)) {
				System.out.println("Book found:");
				System.out.println("Author: " + authors.get(i));
				System.out.println("Publisher: " + publishers.get(i));
				System.out.println("Page Count: " + pageCounts.get(i));
				System.out.println("Publication Year: " + publicationYears.get(i));
				System.out.println("Price: " + prices.get(i));
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Book not found.");
		}
	}

	public static void correctBook(List<String> bookTitles, List<String> authors, List<String> publishers,
			List<Integer> pageCounts, List<Integer> publicationYears, List<Double> prices, String bookToCorrect,
			Scanner scanner) {
		boolean found = false;
		for (int i = 0; i < bookTitles.size(); i++) {
			if (bookTitles.get(i).equalsIgnoreCase(bookToCorrect)) {
				System.out.println("Enter new details:");

				System.out.print("Book Title: ");
				bookTitles.set(i, scanner.next());
				System.out.print("Author: ");
				authors.set(i, scanner.next());
				System.out.print("Publisher: ");
				publishers.set(i, scanner.next());
				System.out.print("Page Count: ");
				pageCounts.set(i, scanner.nextInt());
				System.out.print("Publication Year: ");
				publicationYears.set(i, scanner.nextInt());
				System.out.print("Price: ");
				prices.set(i, scanner.nextDouble());

				System.out.println("Book corrected successfully.");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Book not found.");
		}
	}

	public static void deleteBook(List<String> bookTitles, List<String> authors, List<String> publishers,
			List<Integer> pageCounts, List<Integer> publicationYears, List<Double> prices, String bookToDelete,
			Scanner scanner) {
		boolean found = false;
		for (int i = 0; i < bookTitles.size(); i++) {
			if (bookTitles.get(i).equalsIgnoreCase(bookToDelete)) {
				bookTitles.remove(i);
				authors.remove(i);
				publishers.remove(i);
				pageCounts.remove(i);
				publicationYears.remove(i);
				prices.remove(i);

				System.out.println("Book deleted successfully.");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Book not found.");
		}
	}

	public static double calculateAverage(List<Integer> pageCounts) {
		if (pageCounts.isEmpty()) {
			return 0;
		} else {
			double totalPages = 0;
			for (int pageCount : pageCounts) {
				totalPages += pageCount;
			}
			return totalPages / pageCounts.size();
		}
	}

	public static void findBookWithMostPages(List<String> bookTitles, List<String> authors, List<Integer> pageCounts,
			List<String> publishers) {
		if (pageCounts.isEmpty()) {
			System.out.println("No books in the list.");
		} else {
			int maxPages = Integer.MIN_VALUE;
			int maxIndex = -1;

			for (int i = 0; i < pageCounts.size(); i++) {
				if (pageCounts.get(i) > maxPages) {
					maxPages = pageCounts.get(i);
					maxIndex = i;
				}
			}

			if (maxIndex != -1) {
				System.out.println("Book with the most pages:");
				System.out.println("Book Title: " + bookTitles.get(maxIndex));
				System.out.println("Author: " + authors.get(maxIndex));
				System.out.println("Publisher: " + publishers.get(maxIndex));
				System.out.println("Page Count: " + pageCounts.get(maxIndex));
			}
		}
	}

	public static void findBookWithLeastPages(List<String> bookTitles, List<String> authors, List<Integer> pageCounts,
			List<String> publishers) {
		if (pageCounts.isEmpty()) {
			System.out.println("No books in the list.");
		} else {
			int minPages = Integer.MAX_VALUE;
			int minIndex = -1;

			for (int i = 0; i < pageCounts.size(); i++) {
				if (pageCounts.get(i) < minPages) {
					minPages = pageCounts.get(i);
					minIndex = i;
				}
			}

			if (minIndex != -1) {
				System.out.println("Book with the fewest pages:");
				System.out.println("Book Title: " + bookTitles.get(minIndex));
				System.out.println("Author: " + authors.get(minIndex));
				System.out.println("Publisher: " + publishers.get(minIndex));
				System.out.println("Page Count: " + pageCounts.get(minIndex));
			}
		}
	}
}
