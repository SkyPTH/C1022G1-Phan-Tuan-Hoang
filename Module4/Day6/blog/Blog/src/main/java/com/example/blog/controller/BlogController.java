package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ITypeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("blog")
public class BlogController {
    @Autowired
    @Qualifier("blogService")
    private IBlogService iBlogService;
    @Autowired
    private ITypeBlogService iTypeBlogService;

    @GetMapping(value = "")
    public String list(Model model) {
        model.addAttribute("list", iBlogService.findAll());
        return "list";
    }

    @GetMapping(value = "detail/{id}")
    public String detail(@PathVariable int id,Model model){
        model.addAttribute("blog", iBlogService.findByID(id));
        return "detail";
    }

    @GetMapping(value = "create")
    public String createForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("typeList", iTypeBlogService.findAll());
        return "create";
    }

    @GetMapping(value = "update/{id}")
    public String updateForm(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findByID(id));
        model.addAttribute("typeList", iTypeBlogService.findAll());
        return "update";
    }

    @GetMapping(value = "delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        iBlogService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:blog";
    }

    @PostMapping(value = "create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:blog";
    }

    @PostMapping(value = "update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công");
        return "redirect:blog";
    }
}
