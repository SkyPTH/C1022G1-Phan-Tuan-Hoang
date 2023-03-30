package com.example.repository;

import com.example.model.MailSetting;

import java.util.List;

public interface IMailSettingRepository {
    void create(MailSetting mailSetting);

    List<MailSetting> mailList();

    void update(MailSetting mailSetting);
    String[] language();
    Integer[] pageSize();
}
