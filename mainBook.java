package Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainBook {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> bookTitles = new ArrayList<>();
		List<String> authors = new ArrayList<>();
		List<String> publishers = new ArrayList<>();
		List<Integer> pageCounts = new ArrayList<>();
		List<Integer> publicationYears = new ArrayList<>();
		List<Double> prices = new ArrayList<>();
		byte menu;

		while (true) {
			bookFunction.displayMenu();
			menu = scanner.nextByte();

			switch (menu) {
			case 1:
				bookFunction.addBook(bookTitles, authors, publishers, pageCounts, publicationYears, prices, scanner);
				break;
			case 2:
				bookFunction.listBooks(bookTitles, authors, publishers, pageCounts, publicationYears, prices);
				break;
			case 3:
				System.out.println("Enter the name of the book to search: ");
				String searchedBookTitle = scanner.next();
				bookFunction.searchBook(bookTitles, authors, publishers, pageCounts, publicationYears, prices,
						searchedBookTitle);
				break;
			case 4:
				System.out.println("Enter the name of the book to correct: ");
				String bookToCorrect = scanner.next();
				bookFunction.correctBook(bookTitles, authors, publishers, pageCounts, publicationYears, prices,
						bookToCorrect, scanner);
				break;
			case 5:
				System.out.println("Enter the name of the book to delete: ");
				String bookToDelete = scanner.next();
				bookFunction.deleteBook(bookTitles, authors, publishers, pageCounts, publicationYears, prices,
						bookToDelete, scanner);
				break;
			case 6:
				double averagePages = bookFunction.calculateAverage(pageCounts);
				System.out.println("Average number of pages in books: " + averagePages);
				break;
			case 7:
				bookFunction.findBookWithMostPages(bookTitles, authors, pageCounts, publishers);
				break;
			case 8:
				bookFunction.findBookWithLeastPages(bookTitles, authors, pageCounts, publishers);
				break;
			case 9:
				System.out.println("Exiting the program...");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid menu value");
				break;
			}
		}
	}
}
		
	


