package com.example.service.impl;

import com.example.model.MailSetting;
import com.example.repository.IMailSettingRepository;
import com.example.repository.impl.MailSettingRepository;
import com.example.service.IMailSettingService;

import java.util.List;

public class MailSettingService implements IMailSettingService {
    private final IMailSettingRepository iMailSettingRepository = new MailSettingRepository();

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
