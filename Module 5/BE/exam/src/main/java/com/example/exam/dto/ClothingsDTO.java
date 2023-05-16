package com.example.exam.dto;

import com.example.exam.model.BookType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ClothingsDTO {

    private Integer id;
    @Pattern(regexp = "BO-[0-9]{4}$", message = "Mã có định dạng BO-XXXX (X là số)")
    @NotBlank(message = "Không được bỏ trống")
    private String code;
    @NotBlank(message = "Không được bỏ trống")
    @Size(max = 100, message = "Tên không dài quá 100 ký tự")
    private String name;

    private ClothingTypeDTO clothingTypeDTO;
    @NotBlank(message = "Không được bỏ trống")
    private String date;
    @Positive(message = "Số lượng phải là số nguyên dương")
    @NotBlank(message = "Không được bỏ trống")
    private String quantity;

    public ClothingsDTO() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClothingTypeDTO getClothingTypeDTO() {
        return bookTypeDTO;
    }

    public void setClothingTypeDTO(ClothingTypeDTO ClothingTypeDTO) {
        this.bookTypeDTO = bookTypeDTO;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
