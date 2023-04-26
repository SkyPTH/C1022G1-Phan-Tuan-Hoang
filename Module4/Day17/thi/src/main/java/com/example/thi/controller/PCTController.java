package com.example.thi.controller;

import com.example.thi.model.PCT;
import com.example.thi.service.IPCTService;
import com.example.thi.service.ITypeService;
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
@RequestMapping("pct")
public class PCTController {
    @Autowired
    private ITypeService iTypeService;
    @Autowired
    private IPCTService ipctService;

    @GetMapping("")
    public String list(@PageableDefault(size = 2, direction = Sort.Direction.DESC, sort = {"id"}) Pageable pageable, @RequestParam(defaultValue = "") String search, Model model) {
        model.addAttribute("list", ipctService.list(pageable, search));
        return "list";
    }

    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("pct", new PCT());
        model.addAttribute("typeList", iTypeService.list());
        return "create";
    }

    @PostMapping("create")
    public String create(@Valid @ModelAttribute PCT pct, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pct", pct);
            model.addAttribute("typeList", iTypeService.list());
            model.addAttribute("msg","Tạo mới thất bại");
            return "create";
        } else {
            ipctService.save(pct);
            redirectAttributes.addFlashAttribute("msg", "Tạo mới thành công");
        }
        return "redirect:/pct";
    }
    @PostMapping("delete")
    public String delete(@RequestParam int id){
        ipctService.delete(id);
        return "redirect:/pct";
    }
}
