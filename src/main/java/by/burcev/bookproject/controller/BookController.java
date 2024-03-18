package by.burcev.bookproject.controller;

import by.burcev.bookproject.model.Book;
import by.burcev.bookproject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping("/{title}")
    public ResponseEntity<?> getBookByTitle(@PathVariable String title)
    {
        Book findBook = bookService.getBookByTitle(title);
        if(findBook!=null)
        return ResponseEntity.ok(findBook);
        else return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
    }
    @GetMapping("/allBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @PostMapping("/create")
    public ResponseEntity<String> createBook(@RequestBody Book book){
        boolean create = bookService.createBook(book);
        return ResponseEntity.ok("Created!");
    }
    @PutMapping("/update/{title}")
    public ResponseEntity<String> updateBook(@PathVariable String title,@RequestBody Book book){
        if(bookService.updateBooksByTitle(title, book))
        return ResponseEntity.ok("Updated");
        else return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{title}")
    public ResponseEntity<String> deleteBook(@PathVariable String title){
        boolean deleteBook = bookService.deleteByTitle(title);
        if(deleteBook) return ResponseEntity.ok("Deleted");
        else return new ResponseEntity<>("Book Not Found", HttpStatus.NOT_FOUND);
    }
}
