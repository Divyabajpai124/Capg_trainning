import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Book {
	private int isbnno;
	private String bookName;
	private String author;
	public int getIsbnno() {
		return isbnno;
	}
	public void setIsbnno(int isbnno) {
		this.isbnno = isbnno;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [isbnno=" + isbnno + ", bookName=" + bookName + ", author=" + author + "]";
	}
	
			
	}
class Library{
	ArrayList<Book>Booklist=new ArrayList();
	Iterator<Book> iter = Booklist.iterator();
	int count=-1;
	void addbook(Book b) {
		Booklist.add(b);
		count++;
		System.out.println(Booklist);
	}
	boolean isEmpty() {
		if(count==-1) {
			return true;
		}
		else
			return false;
	}
   ArrayList<Book>viewAllBook(){
	   return Booklist;
   }
   ArrayList<Book> viewBooksByAuthor(String author){
		ArrayList<Book> bl = new ArrayList<Book>();
		
		while (iter.hasNext()) {
			Book bk = iter.next();
			String s =bk.getAuthor();
			if(s.equals(author))
	           bl.add(bk);
	     }
		return bl;
	}
	int countnoofbook(String bname) {
		int bookCount  = 0;
		while (iter.hasNext()) {
			Book bk = iter.next();
			String s =bk.getBookName();
			if(s.equals(bname))
	           bookCount++;
	     }
		return bookCount;
	}

	
}
	

public class BookManipulation {
	public static void main(String[] args) {
		
		Library l=new Library();
		ArrayList<Book> bl = new ArrayList<Book>();
		int n =0 ;
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int choice;
		int isbn;
		String bookName;
		String authorName;
		do {
			System.out.println("1.Add Book\n2.Display all book details\n3.Search Book by author"
					+ "\n4.Count number of books - by book name\n5.Check whether list is empty or not"
					+ "\n6.Exit");
			choice =  sc1.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the isbn no:\r\n"
						+ "Enter the book name:\r\n"
						+ "Enter the author name:");
				isbn = sc1.nextInt();
				bookName = sc2.nextLine();
				authorName = sc2.nextLine();
				Book b = new Book();
				b.setAuthor(authorName);b.setBookName(bookName);b.setIsbnno(isbn);
				l.addbook(b);
				break;
				
			case 2:
				bl = l.viewAllBook();
				n = bl.size();
				if(n==0)
					System.out.println(" The list is empty ");
				for(int i=0;i<n;i++) {
					   System.out.println(bl.get(i).getIsbnno() + " ");
			           System.out.println(bl.get(i).getBookName() + " ");
			           System.out.println(bl.get(i).getAuthor() + " ");
			     }
				break;
			case 3:
				System.out.println("Enter the author name you want to search");
				authorName = sc2.nextLine();
				bl = l.viewBooksByAuthor(authorName);
				n = bl.size();
				if(n==0)
					System.out.println(" The list is empty ");
				System.out.println(bl);
				break;
			case 4:
				System.out.println("Enter the book name you want to  count");
				bookName = sc2.nextLine();
				int count =  l.countnoofbook(bookName);
				System.out.println(count);
				break;
			case 5:
				boolean flag = l.isEmpty();
				if(flag==true)
					System.out.println("List is empty");
				else
					System.out.println("List is not empty");
				break;
			case 6:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Select the correct option");
				break;	
	}
}while(choice!=6);
	}}
