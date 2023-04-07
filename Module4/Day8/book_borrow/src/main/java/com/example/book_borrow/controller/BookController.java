package com.example.book_borrow.controller;

import com.example.book_borrow.model.Borrow;
import com.example.book_borrow.model.Student;
import com.example.book_borrow.service.IBookService;
import com.example.book_borrow.service.IBorrowService;
import com.example.book_borrow.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.Instant;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    IBookService iBookService;
    @Autowired
    IStudentService iStudentService;
    @Autowired
    IBorrowService iBorrowService;

    @GetMapping("")
    public String list(Model model, @PageableDefault(sort = "bookID", direction = Sort.Direction.DESC, size = 3) Pageable pageable, @RequestParam(required = false, defaultValue = "") String search) {
        model.addAttribute("list", iBookService.list(pageable, search));
        return "list";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("book", iBookService.findByID(id));
        return "detail";
    }

    @GetMapping("borrow")
    public String borrow(@RequestParam(name = "bookID") int bookID, @RequestParam(name = "studentID") int studentID, RedirectAttributes redirectAttributes) {
        Student student = iStudentService.findByID(studentID);
        if (student == null) {
            redirectAttributes.addAttribute("msg", "Không tìm thấy học sinh");
            return "redirect:/list";
        } else {
            Borrow borrow = new Borrow();
            borrow.setStudent(student);
            borrow.setBorrowDay(Date.from(Instant.now()).toString());
            borrow.setBook(iBookService.findByID(bookID));
            iBorrowService.save(borrow);
        }
        return "redirect:/list";
    }

    @GetMapping("return")
    public String returnBook() {
        return "redirect:/list";
    }
}
