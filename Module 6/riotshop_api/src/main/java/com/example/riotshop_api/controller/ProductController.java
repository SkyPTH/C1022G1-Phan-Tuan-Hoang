package com.example.riotshop_api.controller;

import com.example.riotshop_api.dto.ProductDTO;
import com.example.riotshop_api.model.Product;
import com.example.riotshop_api.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/public/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public ResponseEntity<?> searchProduct(@RequestParam(required = false, defaultValue = "") String nameProduct,
                                           @RequestParam(required = false, defaultValue = "") String idRank,
                                           @RequestParam(required = false, defaultValue = "") String nameSkin,
                                           @RequestParam(required = false, defaultValue = "") String minPrice,
                                           @RequestParam(required = false, defaultValue = "") String maxPrice,
                                           @PageableDefault(size = 4) Pageable pageable,
                                           @RequestParam(required = false, defaultValue = "") String sortType
    ) {
        Sort sort = null;
        switch (sortType) {
            case "Tên: A-Z":
                sort = Sort.by("name_product").ascending();
                break;
            case "Tên: Z-A":
                sort = Sort.by("name_product").descending();
                break;
            case "Giá: Tăng dần":
                sort = Sort.by("od.price_product").ascending();
                break;
            case "Giá: Giảm dần":
                sort = Sort.by("od.price_product").descending();
                break;
            default:
                sort = Sort.by("id_product").descending();
        }
        Pageable sortedPageaBle = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        return new ResponseEntity<>(iProductService.searchProduct(nameProduct,idRank, nameSkin, minPrice, maxPrice, sortedPageaBle), HttpStatus.OK);
    }

    @GetMapping("detail")
    public ResponseEntity<?> detailProduct(@RequestParam(required = false) Integer idProduct) {
        return new ResponseEntity<>(iProductService.findProductByIdProduct(idProduct), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        iProductService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/update")
    public ResponseEntity<?> update(@Valid @RequestBody ProductDTO productDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Product product = iProductService.findProductByIdProduct(productDTO.getIdProduct());
        BeanUtils.copyProperties(productDTO,product);
        product.setDeleted(false);
            iProductService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}