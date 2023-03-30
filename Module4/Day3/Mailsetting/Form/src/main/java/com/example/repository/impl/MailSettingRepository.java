package com.example.repository.impl;

import com.example.model.MailSetting;
import com.example.repository.IMailSettingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MailSettingRepository implements IMailSettingRepository {
    private static final List<MailSetting> mailSettingList = new ArrayList<>();

    static {
        mailSettingList.add(new MailSetting("Vietnamese", 5, true, "Hoàng"));
    }

    @Override
    public void create(MailSetting mailSetting) {
        mailSettingList.add(mailSetting);
    }

    @Override
    public List<MailSetting> mailList() {
        return mailSettingList;
    }

    @Override
    public void update(MailSetting mailSetting) {
        mailSettingList.set(0,mailSetting);
    }

    @Override
    public String[] language() {
        return new String[]{"Chinese","Vietnamese","English"};
    }

    @Override
    public Integer[] pageSize() {
        return new Integer[]{5,10,25,50,100};
    }
}
