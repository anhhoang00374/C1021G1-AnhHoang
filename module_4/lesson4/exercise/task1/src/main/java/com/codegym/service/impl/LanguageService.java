package com.codegym.service.impl;

import com.codegym.model.Language;
import com.codegym.service.ILanguageService;
import org.springframework.stereotype.Service;

@Service
public class LanguageService implements ILanguageService {
    //String title, String language, String pageSize, String show, String emailsPerPage,
    //                    String spamsFilter,
    //                    String enableSpamsFilter, String signature, String upload, String cancel)
    Language english = new Language("Setting","Language","Page size","Show",
            "Emails Per Page","Spams filter",
            "Enable spams filter","Signature","Upload","Cancel");
    Language vietnamese = new Language("Cài đặt","Ngôn ngữ","Kích thước trang","hiển thị","email trên trang",
            "Bộ lọc spam","Vô hiệu hoá bộ lọc","Chữ ký","Cập nhât","Huỷ");
    Language chinese = new Language("安裝","語言","尺寸","看","Emails/頁","垃圾郵件過濾器",
            "打開垃圾郵件過濾器","簽名","上傳","取消");
    Language  japanese = new Language("設定","言語","ページサイズ","見","emails/ページ","スパムフィルタ",
            "スパムフィルターを有効にする","サイン","アップロード","キャンセル");
    @Override
    public Language checkLanguage(String language) {
        switch (language){
            case ("Vietnamese"):
                return vietnamese;
            case ("Chinese"):
                return chinese;
            case ("Japanese"):
                return japanese;
            default:
                return english;
        }
    }
}
