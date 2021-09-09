package new_entity;

import entity.Book;
import entity.BookType;
import entity.SalesBook;

public class WSalesBook {

	private SalesBook sbook;
	private Book book;
	private BookType type;
	
	public BookType getType() {
		return type;
	}
	public void setType(BookType type) {
		this.type = type;
	}
	public SalesBook getSbook() {
		return sbook;
	}
	public void setSbook(SalesBook sbook) {
		this.sbook = sbook;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
