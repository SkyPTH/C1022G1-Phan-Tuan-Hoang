package com.example.service;

import com.example.model.MailSetting;
import com.example.repository.IMailSettingRepository;
import com.example.repository.MailSettingRepository;

import java.util.List;

public class MailSettingService implements IMailSettingService {
    IMailSettingRepository iMailSettingRepository=new MailSettingRepository();
    @Override
    public void create(MailSetting mailSetting) {
        iMailSettingRepository.create(mailSetting);
    }

    @Override
    public List<MailSetting> mailList() {
        return iMailSettingRepository.mailList();
    }
}
