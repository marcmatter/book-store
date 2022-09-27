package ch.bfo.m_223.contract;

/***
 * DTO welche die nötigen Informationen für einen Kunden enthält
 */
public class BookDto {
    private String titel;
    private String publisher;
    private String genre;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String author;
    private int bookId;


    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }


    @Override
    public String toString() {
        return this.titel + " [" + this.bookId + "]" + " (" + this.author + " - " + this.publisher + ")";
    }
}