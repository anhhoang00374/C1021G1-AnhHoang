package com.codegym.service;

import com.codegym.model.Language;
import org.springframework.stereotype.Service;


public interface ILanguageService {
    Language checkLanguage(String language);
}
