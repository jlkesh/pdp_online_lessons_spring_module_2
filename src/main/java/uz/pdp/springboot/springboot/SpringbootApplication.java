package uz.pdp.springboot.springboot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import uz.pdp.springboot.springboot.book.Book;
import uz.pdp.springboot.springboot.book.BookRepository;
import uz.pdp.springboot.springboot.config.ApplicationConfigurer;

public class SpringbootApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfigurer.class);
        BookRepository bookRepository = context.getBean(BookRepository.class);
        /*Book book = Book.builder()
                .name("Spring boot In Action 7th edition")
                .author("Laura Spilk")
                .build();
        bookRepository.save(book);*/
        /*bookRepository.findAll().forEach(System.out::println);*/
        /*bookRepository.findById(3).ifPresentOrElse(System.out::println,
                () -> System.out.println("Book not found"));*/
        bookRepository.deleteById(2);

    }

}
