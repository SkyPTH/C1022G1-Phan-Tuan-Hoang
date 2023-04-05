package com.example.song.controller;

import com.example.song.model.Song;
import com.example.song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("song")
public class SongController {
    @Autowired
    ISongService iSongService;

    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @GetMapping("update")
    public String updateForm() {
        return "update";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            iSongService.save(song);
            redirectAttributes.addFlashAttribute("msg","Tạo mới thành công");
            return "redirect:/create";
        }

    }

    @PostMapping("update")
    public String update(@ModelAttribute Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            iSongService.save(song);
            redirectAttributes.addFlashAttribute("msg","Tạo mới thành công");
            return "redirect:/update";
        }
    }
}
