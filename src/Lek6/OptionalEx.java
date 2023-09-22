package Lek6;

import java.util.Optional;

//tidigare lösning

class old {

    String zipCodeOfAuthor(Library lib, String isbn) {
        var book = library.bookByIsbn(isbn);
        if (book != null) {
            var author = book.author();
            if (author != null) {
                var address = author.address();
                if (address != null) {
                    return address.zipCode();
                }
            }
        }
    }
}
//göra om med optional

interface Library {
    Optional<Book> bookByIsbn(String isbn);
}

interface Book {
    String title();
    String isbn(); //inte på Isbn för det finns alltid en isbn
    Optional<Author> author();
}

interface Author {
    String name();
    Optional<Address> address();
}

interface Address {
    String streetAddress();
    String zipCode();
}

//ny metod

class New {

    String zipCodeOfAuthor1(Library library, String isbn) {
        return
            library //optional på en book
            .bookByIsbn(isbn);
            .map(book -> book.author()) //här returneras en optional av en author
    }

    String zipCodeOfAuthor2(Library library, String isbn) {
        return
            library 
            .bookByIsbn(isbn)
            .flatMap(book -> book.author()) //flatMap ger en ny optional som vi vill lyfta ut
            .flatMap(author -> author.address())
            .map(address -> address.zipCode())
            //.get() fungerar inte om optionalen är tom
            .orElse("Unknown zipcode");
    }    
}
