package com.example.service.impl;

import com.example.model.MailSetting;
import com.example.repository.IMailSettingRepository;
import com.example.service.IMailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MailSettingService implements IMailSettingService {
    @Autowired
    IMailSettingRepository iMailSettingRepository;

    @Override
    public void create(MailSetting mailSetting) {
        iMailSettingRepository.create(mailSetting);
    }

    @Override
    public List<MailSetting> mailList() {
        return iMailSettingRepository.mailList();
    }

    @Override
    public void update(MailSetting mailSetting) {
        iMailSettingRepository.update(mailSetting);
    }

    @Override
    public String[] language() {
        return iMailSettingRepository.language();
    }

    @Override
    public Integer[] pageSize() {
        return iMailSettingRepository.pageSize();
    }

}
