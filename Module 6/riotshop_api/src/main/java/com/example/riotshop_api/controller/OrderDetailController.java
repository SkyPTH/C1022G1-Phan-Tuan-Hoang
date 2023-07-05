package com.example.riotshop_api.controller;

import com.example.riotshop_api.dto.RequestPayment;
import com.example.riotshop_api.model.*;
import com.example.riotshop_api.sercurity.jwt.JwtProvider;
import com.example.riotshop_api.sercurity.jwt.JwtTokenFilter;
import com.example.riotshop_api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/user/order-detail")
@CrossOrigin("*")
public class OrderDetailController {
    @Autowired
    private ICartService iCartService;
    @Autowired
    private JwtTokenFilter jwtTokenFilter;
    @Autowired private JwtProvider jwtProvider;
    @Autowired private IAccountUserService iAccountUserService;
    @Autowired private IOrderCustomer iOrderCustomer;
    @Autowired private IProductService iProductService;
    @Autowired private IOrderDetail iOrderDetail;
    @GetMapping("")
    public List<OrderDetail> orderDetailListByIdOrder(@RequestParam int id){
        return iOrderDetail.orderList(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/payment")
    public void payment(HttpServletRequest request, @RequestBody RequestPayment requestPayment){
        String token = jwtTokenFilter.getJwt(request);
        String name = jwtProvider.getUserNameFromToken(token);
        AccountUser accountUser=iAccountUserService.findAccountUserByNameAccount(name);
        List<Cart> cartList= iCartService.findCartByNameAccount(name);
        OrderCustomer orderCustomer=new OrderCustomer();
        orderCustomer.setTotalPrice(requestPayment.getTotalPrice());
        orderCustomer.setDateOrder(String.valueOf(LocalDate.now()));
        orderCustomer.setAccountUser(accountUser);
        iOrderCustomer.createOderCustomer(orderCustomer);
        for (int i = 0; i < cartList.size(); i++) {
            Product product=cartList.get(i).getProduct();
            product.setDeleted(true);
            iProductService.save(product);
            OrderDetail orderDetail=new OrderDetail();
            orderDetail.setProduct(cartList.get(i).getProduct());
            orderDetail.setOrderCustomer(orderCustomer);
            orderDetail.setPriceProduct(cartList.get(i).getPriceProduct());
            iOrderDetail.createOderDetail(orderDetail);
            iCartService.deleteById(cartList.get(i).getIdCart());
        }

    }
}
