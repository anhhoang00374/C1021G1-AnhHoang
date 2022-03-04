package com.codegym.service.impl;

import com.codegym.model.Setting;
import com.codegym.service.ISettingService;
import org.springframework.stereotype.Service;

@Service
public class SettingService implements ISettingService {
    @Override
    public Setting displayCurrentSetting(){
        return new Setting("English",10,true,"this is my name");
    }
}
