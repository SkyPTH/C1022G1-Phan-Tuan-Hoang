package com.example.blog.controller;

import com.example.blog.model.TypeBlog;
import com.example.blog.service.ITypeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("typeBlog")
public class TypeBlogController {
    @Autowired
    ITypeBlogService iTypeBlogService;

    @GetMapping("")
    public String typeList(Model model) {
        model.addAttribute("typeList", iTypeBlogService.findAll());
        return "type_blog/type_list";
    }

    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("typeBlog", new TypeBlog());
        return "type_blog/type_create";
    }

    @GetMapping("update/{id}")
    public String updateForm(@PathVariable int id, Model model) {
        model.addAttribute("typeBlog", iTypeBlogService.findByID(id));
        return "type_blog/type_update";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int typeID) {
        iTypeBlogService.delete(typeID);
        return "redirect:/typeBlog";
    }

    @PostMapping(value = "create")
    public String create(@ModelAttribute TypeBlog typeBlog, RedirectAttributes redirectAttributes) {
        iTypeBlogService.save(typeBlog);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/typeBlog";
    }

    @PostMapping(value = "update")
    public String update(@ModelAttribute TypeBlog typeBlog, RedirectAttributes redirectAttributes) {
        iTypeBlogService.save(typeBlog);
        redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công");
        return "redirect:/typeBlog";
    }

}
