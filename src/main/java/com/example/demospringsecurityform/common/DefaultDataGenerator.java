package com.example.demospringsecurityform.common;

import com.example.demospringsecurityform.account.Account;
import com.example.demospringsecurityform.account.AccountService;
import com.example.demospringsecurityform.book.Book;
import com.example.demospringsecurityform.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DefaultDataGenerator implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // jinwoo - spring
        // park - hibernate
        Account jinwoo = createUser("jinwoo");
        Account park = createUser("park");

        createBook("spring", jinwoo);
        createBook("hibernate", park);
    }

    private void createBook(String title, Account account) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(account);
        bookRepository.save(book);
    }

    private Account createUser(String username) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword("123");
        account.setRole("USER");
        return accountService.createNew(account);
    }
}
