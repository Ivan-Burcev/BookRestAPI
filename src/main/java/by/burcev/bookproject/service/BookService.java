package by.burcev.bookproject.service;

import by.burcev.bookproject.model.Book;
import by.burcev.bookproject.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book getBookByTitle(String title){
        return bookRepository.findByTitle(title).orElse(null);
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public boolean createBook(Book book){
        bookRepository.save(book);
        return true;
    }
    public boolean updateBooksByTitle(String title, Book book)
    {
        Book findBook = getBookByTitle(title);
        if(findBook != null){
            if(book.getTitle()!=null) findBook.setTitle(book.getTitle());
            if(book.getAuthor()!=null) findBook.setAuthor(book.getAuthor());
            if(book.getDateOfCreate()!=null) findBook.setDateOfCreate(book.getDateOfCreate());
            bookRepository.save(findBook);
            return true;
        }
        return false;
    }
    public boolean deleteByTitle(String title){
        Book findBook = getBookByTitle(title);
        if(findBook!=null) {
            bookRepository.deleteByTitle(title);
            return true;
        }
        else return false;

    }
}
