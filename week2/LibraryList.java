import java.util.ArrayList;

class Book{
    private String title;
    private String author;

    public Book(String t, String a){
        this.title = t;
        this.author = a;
    }

    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
}

class Library{
    private String name;
    ArrayList<Book> bookList;

    public Library(String name){
        this.name = name;
        this.bookList = new ArrayList<Book>();
    }

    public Library(Library a){
        this.name = a.getName()+"-1";
        this.bookList = a.getBookList();
    }

    public ArrayList<Book> getBookList(){
        return this.bookList;
    }
    public void addBook(Book a){
        this.bookList.add(a);
    }

    public String getName(){
        return this.name;
    }

    public void changeBook(String titleA, String authorA, String titleB, String authorB){

        Book target = null;

        for( Book b : this.bookList){
            if ((b.getAuthor().equals(authorA)) &&(b.getTitle().equals(titleA)) ){
                target = b;
            }
        }

        int targetIndex = this.bookList.indexOf(target);
        if (targetIndex == -1){
            return;
        }

        this.bookList.set(targetIndex, new Book(titleB, authorB));
    }

    public void printBookList(){
        System.out.println("----------------------------------------------------");
        System.out.println("|Printing "+ this.getName()+" library's List of Books|");
        System.out.println("----------------------------------------------------");
        for(Book book: this.bookList){
            System.out.println(book.getTitle() + " by "+ book.getAuthor());
        }
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
    }

}

public class LibraryList {
    public static void main(String[] args) {

        String[] bookTitles = {"태백산맥","이기적 유전자","자전거 도둑","토지","대변동"};
        String[] bookAuthors = {"조정래", "리처드 도킨즈", "박완서", "박경리", "제레드 다이아몬드"};

        Library A = new Library("온마을");
        Library B = new Library("두마을");

        for(int i = 0 ; i < bookTitles.length; i++){
            A.addBook(new Book(bookTitles[i],bookAuthors[i]));
            B.addBook(new Book(bookTitles[i],bookAuthors[i]));
        }

        Library A_1 = new Library(A);

        A.changeBook("자전거 도둑","박완서","그 많던 싱아는 누가 다 먹었을까","박완서");
        B.addBook(new Book("사피엔스","유발 하라리"));

        A.printBookList();
        A_1.printBookList();
        B.printBookList();


    }
}
