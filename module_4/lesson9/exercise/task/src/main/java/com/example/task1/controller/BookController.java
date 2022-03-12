package com.example.task1.controller;

import com.example.task1.model.Book;
import com.example.task1.model.BorrowedBook;
import com.example.task1.model.Customer;
import com.example.task1.service.IBookService;
import com.example.task1.service.IBorrowedBookService;
import com.example.task1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    IBookService bookService;

    @Autowired
    ICustomerService customerService;

    @Autowired
    IBorrowedBookService borrowedBookService;
    @RequestMapping
    public String displayHome(Model model, @PageableDefault(size = 5)Pageable pageable){
        Page<Book> bookList = bookService.findAll(pageable);
       // bookList.add(new Book(3,3,"love"));
        model.addAttribute("bookList",bookList);
        return "book/list";
    }
    @GetMapping("/add-book")
    public String showFormAdd( Model model){
        model.addAttribute("book",new Book());
        return "book/addBook";
    }
    @PostMapping("/add-book")
    public String addBook(@ModelAttribute Book book){
        book.setCurrentQuantity(book.getQuantity());
        bookService.save(book);

        return "redirect:/";
    }

    @GetMapping("borrow-book")
    public String showFormBorrow(@RequestParam Long id,RedirectAttributes redirectAttributes,Model model) throws NumberFormatException{
        Book book = bookService.findById(id);
        if(book!=null){
            if(book.getCurrentQuantity()>0){
                model.addAttribute("book",book);
                return "book/borrowBook";
            }else {
                throw new NumberFormatException("");
//                redirectAttributes.addFlashAttribute("message","sách đã hết");
//                return "redirect:/";
            }
        }
        return "redirect:/";
    }

    @PostMapping("borrow-book")
    public String borrowBook( @ModelAttribute Book book,@RequestParam String customerName, RedirectAttributes model){
        book.setCurrentQuantity(book.getCurrentQuantity()-1);
        Customer customerId = customerService.findCustomerByName(customerName);
        BorrowedBook borrowedBook = new BorrowedBook(randomBorrowedNumber(),book,customerId);
        borrowedBookService.save(borrowedBook);
        model.addFlashAttribute("message","bạn đã mượn thành công sách");
        bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("pay-book")
    public String showFormPayBook(){
        return "book/payBook";
    }

    @PostMapping("pay-book")
    public String payBook(@RequestParam String number,RedirectAttributes redirectAttributes) throws Exception {
        BorrowedBook borrowedBook = borrowedBookService.findByborrowedNumber(number);
        if(borrowedBook==null){
            throw  new NullPointerException("");
        }else {
            Long bookId = borrowedBook.getBook().getId();
            Book book = bookService.findById(bookId);
            book.setCurrentQuantity(book.getCurrentQuantity()+1);
            bookService.save(book);
            redirectAttributes.addFlashAttribute("message","đã trả sách thành công");
            borrowedBookService.delete(borrowedBook);
            return "redirect:/";
        }

    }

    private int randomNumber(){
        int number = (int) Math.round(Math.random()*9);
        return number;
    }

    private String randomBorrowedNumber(){
        String result = "";
        for (int i = 0;i<5;i++){
            result +=randomNumber();
        }
        return result;
    }
}
