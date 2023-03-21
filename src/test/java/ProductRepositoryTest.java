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


}