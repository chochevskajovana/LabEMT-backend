package com.example.labemt.model.database;

import com.example.labemt.model.Author;
import com.example.labemt.model.Book;
import com.example.labemt.model.Country;
import com.example.labemt.model.enumerations.Category;
import com.example.labemt.repository.AuthorRepository;
import com.example.labemt.repository.BookRepository;
import com.example.labemt.repository.CountryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataHolder {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final BookRepository bookRepository;

    public DataHolder(AuthorRepository authorRepository, CountryRepository countryRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init(){
        Country usa = new Country("USA", "North America");
        Country mk = new Country("MK", "Europe");

        countryRepository.save(usa);
        countryRepository.save(mk);

        Author author1 = new Author("Marta", "Martevska", usa);
        Author author2 = new Author("Marko", "Markov", mk);

        authorRepository.save(author1);
        authorRepository.save(author2);

        Book book1 = new Book("Book 1", Category.BIOGRAPHY, author1, 10);
        Book book2 = new Book("Book 2", Category.DRAMA, author2, 5);
        Book book3 = new Book("Book 3", Category.CLASSICS, author2, 23);
        Book book4 = new Book("Book 4", Category.NOVEL, author2, 0);
        Book book5 = new Book("Book 5", Category.HISTORY, author2, 17);
        Book book6 = new Book("Book 6", Category.THRILLER, author2, 3);
        Book book7 = new Book("Book 7", Category.FANTASY, author2, 43);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
        bookRepository.save(book5);
        bookRepository.save(book6);
        bookRepository.save(book7);
    }
}

