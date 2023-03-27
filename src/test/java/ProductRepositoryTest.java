import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductRepositoryTest {


    @Test
    public void removeById() {


        ProductRepository repo = new ProductRepository();

        Book book1 = new Book(1, "Harry Potter 1", "Rowilgs");
        Book book2 = new Book(2, "Harry Poter 2", "Rowilgs2");
        Book book3 = new Book(3, "Harry Pottter 3", "Rowilgs");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(1);
        Product[] actual = repo.findAll();
        Product[] expected = {book2, book3};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void removeByIdWhenIdIsCorrect() {


        ProductRepository repo = new ProductRepository();

        Book book1 = new Book(1, "Harry Potter 1", "Rowilgs");
        Book book2 = new Book(2, "Harry Poter 2", "Rowilgs2");
        Book book3 = new Book(3, "Harry Pottter 3", "Rowilgs");
        Smartphone phone1 = new Smartphone(4, "Iphone", "Apple");
        Smartphone phone2 = new Smartphone(5, "Iphoneten", "Apple");
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(phone1);
        repo.add(phone2);

        repo.removeById(5);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3, phone1};

        Assertions.assertArrayEquals(expected, actual);


    }


    
//    @Test
//    public void removeByIdWhenIdIsIncorrect2() {
//
//
//        ProductRepository repo = new ProductRepository();
//
//        Book book1 = new Book(1, "Harry Potter 1", "Rowilgs");
//        Book book2 = new Book(2, "Harry Poter 2", "Rowilgs2");
//        Book book3 = new Book(3, "Harry Pottter 3", "Rowilgs");
//        Smartphone phone1 = new Smartphone(4, "Iphone", "Apple");
//        Smartphone phone2 = new Smartphone(6, "Iphoneten", "Apple");
//        repo.add(book1);
//        repo.add(book2);
//        repo.add(book3);
//        repo.add(phone1);
//        repo.add(phone2);
//
//     Assertions.assertThrows(NotFoundException.class,
//             () -> repo.removeById(7)
//             );
//
//    }


}