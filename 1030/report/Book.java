package practice;

public class Book {
	private String author;
	private String title;
	private String name;

	public Book() {
	}

	public Book(String author, String title, String name) {
		this.author = author;
		this.title = title;
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name + "이 구입한 도서 : " + this.author + "의 " + this.title;
	}

	@Override
	public boolean equals(Object obj) {
		Book book = (Book) obj;

		if (this.author == book.getAuthor() && this.title == book.getTitle())
			return true;
		else
			return false;

	}

}
