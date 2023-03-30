package com.example.service;

import com.example.model.MailSetting;

import java.util.List;

public interface IMailSettingService {
    void create(MailSetting mailSetting);

    List<MailSetting> mailList();
    void update(MailSetting mailSetting);
    String[] language();
    Integer[] pageSize();
 }
