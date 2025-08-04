package entity1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	int bookId;
	String BookName;
	
	@ManyToOne
	@JoinColumn(name="libraryId")
	Library library;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public Book(int bookId, String bookName, Library library) {
		super();
		this.bookId = bookId;
		BookName = bookName;
		this.library = library;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", BookName=" + BookName + ", library=" + library + "]";
	}
	
	
	

}
