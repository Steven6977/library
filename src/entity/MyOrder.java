package entity;

public class MyOrder {
	private String name;
	private String author;
	private String publisher;
	private String borrowdate;
	private String returndate;
	
	
	public MyOrder(){}
	
	public MyOrder(Book b,Order o){
		this.name = b.getName();
		this.author = b.getAuthor();
		this.publisher = b.getPublisher();
		this.borrowdate = o.getBorrowdate();
		this.returndate = o.getReturndate();
	}

	public String getBorrowdate() {
		return borrowdate;
	}

	public void setBorrowdate(String borrowdate) {
		this.borrowdate = borrowdate;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}
