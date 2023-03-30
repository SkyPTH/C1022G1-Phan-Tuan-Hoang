package com.example.controller;

import com.example.model.MailSetting;
import com.example.service.IMailSettingService;
import com.example.service.impl.MailSettingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/mail-setting")
public class MailSettingController {
    private final IMailSettingService iMailSettingService = new MailSettingService();

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("list", iMailSettingService.mailList());
        return "list";
    }

    @GetMapping("create")
    public String showFormCreate(Model model) {
        model.addAttribute("mailSetting", new MailSetting());
        model.addAttribute("language", iMailSettingService.language());
        model.addAttribute("pageSize", iMailSettingService.pageSize());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute MailSetting mailSetting, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        iMailSettingService.create(mailSetting);
        redirectAttributes.addAttribute("message", "Thêm mới thành công");
        return "redirect:/mail-setting";
    }

    @GetMapping("update")
    public String showUpdateForm(Model model) {
        model.addAttribute("mailSetting", iMailSettingService.mailList().get(0));
        model.addAttribute("language", iMailSettingService.language());
        model.addAttribute("pageSize", iMailSettingService.pageSize());
        return "update";
    }

    @PostMapping("update")
    public String update(@ModelAttribute MailSetting mailSetting, RedirectAttributes redirectAttributes) {
        iMailSettingService.update(mailSetting);
        redirectAttributes.addAttribute("message", "Thay đổi thành công");
        return "redirect:/mail-setting";
    }
}
