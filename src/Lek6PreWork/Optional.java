package Lek6PreWork;

interface Book {
    String title();
    String isbn();
    Author author();      // ger null om namngiven författare saknas
}

interface Author {
    String name();
    Address address();     // ger null om författaren saknar
                           // adress
}

interface Address {
    String streetAddress();
    String zipCode();
}

interface Library {
    Book bookByIsbn(String isbn);  // ger null om ingen sådan bok
                                   // finns
}

class ZipFinder {  
    private static Library lib;

    public static String zipByIsbn(String isbn) {
        Book book = lib.bookByIsbn(isbn);
        if (book==null) {
            return null;
        }
        Author author = book.author();
        if (author == null) {
            return null;
        }
        Address address = author.address();
        if (address == null) {
            return null;
        } 
        String zipCode = address.zipCode();
        return zipCode;

    }

}
