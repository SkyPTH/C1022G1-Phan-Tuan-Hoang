package com.example.thi.controller;

import com.example.thi.model.Book;
import com.example.thi.service.IBookService;
import com.example.thi.service.IBookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBookTypeService iBookTypeService;

        @GetMapping("")
    public String list(@PageableDefault(size = 3, direction = Sort.Direction.DESC, sort = {"id"}) Pageable pageable, @RequestParam(defaultValue = "") String search, Model model) {
        model.addAttribute("list", iBookService.list(pageable, search));
        return "list";
    }


    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("typeList", iBookTypeService.list());
        return "create";
    }

    @PostMapping("create")
    public String create(@Valid @ModelAttribute Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("book", book);
            model.addAttribute("typeList", iBookTypeService.list());
            return "create";
        } else {
            iBookService.save(book);
            redirectAttributes.addFlashAttribute("msg", "Tạo mới thành công");
        }
        return "redirect:/book";
    }

    @GetMapping("update/{id}")
    public String updateForm(@PathVariable int id, Model model) {
        model.addAttribute("book", iBookService.findByID(id));
        model.addAttribute("typeList", iBookTypeService.list());
        return "update";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "update";
        } else {
            iBookService.save(book);
            redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công");
        }
        return "redirect:/book";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        iBookService.detete(id);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/book";
    }
}
