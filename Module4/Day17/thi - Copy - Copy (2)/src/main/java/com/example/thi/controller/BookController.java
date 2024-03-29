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
    IBookTypeService iBookTypeService;
    @Autowired
    IBookService iBookService;
    @GetMapping("")
    public String list(Model model, @PageableDefault(size = 2,direction = Sort.Direction.DESC,sort = "id")Pageable pageable, @RequestParam(defaultValue = "") String search){
        model.addAttribute("list",iBookService.list(pageable, search));
        return "list";
    }
    @GetMapping("create")
    public String createForm(Model model){
        model.addAttribute("book",new Book());
        model.addAttribute("typeList",iBookTypeService.list());
        return "create";
    }
    @PostMapping("create")
    public String create(@Valid @ModelAttribute Book book,BindingResult bindingResult,RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("typeList",iBookTypeService.list());
            return "create";
        }
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("msg","Thêm mới thành công");
        return "redirect:/book";
    }
    @GetMapping("update/{id}")
    public String updateForm(Model model,@PathVariable int id){
        model.addAttribute("book",iBookService.findById(id));
        model.addAttribute("typeList",iBookTypeService.list());
        return "update";
    }
    @PostMapping("update")
    public String update(@Valid @ModelAttribute Book book,BindingResult bindingResult,RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("typeList",iBookTypeService.list());
            return "update";
        }
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("msg","Chỉnh sửa thành công");
        return "redirect:/book";
    }
    @PostMapping("delete")
    public String delete(@RequestParam int id,RedirectAttributes redirectAttributes){
        iBookService.delete(id);
        redirectAttributes.addFlashAttribute("msg","xóa thành công");
        return "redirect:/book";
    }
}
