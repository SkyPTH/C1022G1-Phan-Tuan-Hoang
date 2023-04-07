package com.example.song.controller;

import com.example.song.dto.SongDTO;
import com.example.song.model.Song;
import com.example.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("song")
public class SongController {
    @Autowired
    private ISongService iSongService;
    @GetMapping("")
    public String list(Model model){
        model.addAttribute("list",iSongService.list());
        return "list";
    }

    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("songDTO", new SongDTO());
        return "create";
    }

    @GetMapping("update/{id}")
    public String updateForm(Model model, @PathVariable int id) {
        model.addAttribute("song",iSongService.findByID(id));
        return "update";
    }

    @PostMapping("create")
    public String create(@ModelAttribute @Valid SongDTO songDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            iSongService.save(songDTO);
            redirectAttributes.addFlashAttribute("msg", "Tạo mới thành công");
            return "redirect:/song";
        }

    }

    @PostMapping("update")
    public String update(@ModelAttribute @Valid SongDTO songDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            iSongService.save(songDTO);
            redirectAttributes.addFlashAttribute("msg", "Tạo mới thành công");
            return "redirect:/update";
        }
    }
}
