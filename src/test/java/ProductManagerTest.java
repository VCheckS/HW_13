import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    @Test
    public void searchByNameWhenFewProductFound() {


        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(1, "Harry Potter 1", "Rowilgs");
        Book book2 = new Book(2, "Harry Poter 2", "Rowilgs2");
        Book book3 = new Book(3, "Harry Pottter 3", "Rowilgs");
        Smartphone phone1 = new Smartphone(1, "S10", "Samsung");
        Smartphone phone2 = new Smartphone(2, "14 Pro", "Iphone");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(phone1);
        repo.add(phone2);
        Product[] actual = manager.searchBy("1");
        Product[] expected = {book1, phone1, phone2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchByNameWhenNoProductFound() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(1, "Harry Potter 1", "Rowilgs");
        Book book2 = new Book(2, "Harry Poter 2", "Rowilgs2");
        Book book3 = new Book(3, "Harry Pottter 3", "Rowilgs");
        Smartphone phone4 = new Smartphone(4, "Iphone", "Apple");
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(phone4);
        Product[] actual = manager.searchBy("x");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchByNameWhenOnePhoneFound() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Smartphone phone1 = new Smartphone(1, "Sone", "Samsung");
        Smartphone phone2 = new Smartphone(2, "Stwo", "Samsung");
        Smartphone phone3 = new Smartphone(3, "Sthre", "Samsung");
        Smartphone phone4 = new Smartphone(4, "Iphone", "Apple");
        Book book1 = new Book(1, "War and Peace", "Tolstoy");
        repo.add(phone1);
        repo.add(phone2);
        repo.add(phone3);
        repo.add(phone4);
        Product[] actual = manager.searchBy("Ip");
        Product[] expected = {phone4};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testAdd() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Product product = new Product(1, "Smartphone");

        manager.add(product);

        assertEquals(1, repository.findAll().length);
    }

}


