package entity;

public class Order extends Entity{
    private int    id;
    private int    userid;
    private int    bookid;
    private String borrowdate;
    private String returndate;
    private int    ifreturn;

    
    public Order(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
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

    public int getIfreturn() {
        return ifreturn;
    }

    public void setIfreturn(int ifreturn) {
        this.ifreturn = ifreturn;
    }
}
