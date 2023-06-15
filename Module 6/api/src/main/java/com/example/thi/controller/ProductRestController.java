package com.example.thi.controller;

import com.example.thi.dto.ProductDTO;
import com.example.thi.model.Customer;
import com.example.thi.model.Employee;
import com.example.thi.model.Product;
import com.example.thi.model.Shop;
import com.example.thi.service.ICustomerService;
import com.example.thi.service.IEmployeeService;
import com.example.thi.service.IProductService;
import com.example.thi.service.IShopService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductRestController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IShopService iShopService;
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public ResponseEntity<List<Product>> findAll(String search) {
        if (search == null) {
            search = "";
        }
        List<Product> products = iProductService.list(search);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO, BindingResult bindingResult) {
        new ProductDTO().validate(productDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
//        product.setCode(productDTO.getCode());
//        product.setName(productDTO.getName());
//        product.setQuantity(productDTO.getQuantity());
        Customer customer = iCustomerService.findByID(productDTO.getCustomerDTO().getIdCustomer());
        product.setCustomer(customer);
        Shop shop = iShopService.findByID(productDTO.getShopDTO().getIdShop());
        product.setShop(shop);
        Employee employee = iEmployeeService.findByID(productDTO.getEmployeeDTO().getIdEmployee());
        product.setEmployee(employee);
        iProductService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
