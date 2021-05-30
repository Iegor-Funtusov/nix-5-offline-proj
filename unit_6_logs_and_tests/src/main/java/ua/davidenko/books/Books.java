package ua.davidenko.books;

 public class Books {
     String title;
     String bookId;

     public String getTitle() {
         return title;
     }

     public void setTitle(String title) {
         this.title = title;
     }

     public String getBookId() {
         return bookId;
     }

     public void setBookId(String bookId) {
         this.bookId = bookId;
     }

     @Override
     public String toString() {
         return "Books{" +
                 "title='" + title + '\'' +
                 ", bookId='" + bookId + '\'' +
                 '}';
     }
 }