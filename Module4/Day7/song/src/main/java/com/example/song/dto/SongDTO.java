package com.example.song.dto;

import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.Validation;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SongDTO implements Validator {

    @NotBlank(message = "Tên bài hát không được để trống")
    @Pattern(message = "Không vượt quá 800 ký tự và không chứa các kí tự đặc biệt như @ ; , . = - + , ….",
            regexp = "[a-zA-Z0-9 ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưă" +
                    "ạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]{1,800}")
    private String name;
    @NotBlank(message = "Tên ca sĩ không được để trống")
    @Pattern(message = "Không vượt quá 300 ký tự và không chứa các kí tự đặc biệt như @ ; , . = - + , ….",
            regexp = "[a-zA-Z0-9 ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềể" +
                    "ỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]{1,300}")
    private String singer;

    @NotBlank(message = "Thể loại nhạc không được để trống")
    @Pattern(message = "Không vượt quá 1000 ký tự và không chứa các kí tự đặc biệt ngoại trừ dấu .",
            regexp = "[a-zA-Z0-9. ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềể" +
                    "ỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]{1,1000}")
    private String type;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    public SongDTO(String name, String singer, String type) {
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public SongDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
    
}
