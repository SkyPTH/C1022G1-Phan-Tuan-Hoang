package com.example.thi.controller;

import com.example.thi.model.Book;
import com.example.thi.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    IBookService iBookService;

    @GetMapping("")
    public String list(@PageableDefault(size = 3, sort = "bookID", direction = Sort.Direction.DESC) Pageable pageable,
                       Model model, @RequestParam(required = false, defaultValue = "") String search) {
        model.addAttribute("list", iBookService.list(search, pageable));
        return "list";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("book",new Book());
        return "create";
    }
    @PostMapping
    @GetMapping
    @PostMapping
    @GetMapping
}
