package com.example.riotshop_api.service.impl;

import com.example.riotshop_api.config.Config;
import com.example.riotshop_api.dto.RequestPayment;
import com.example.riotshop_api.dto.ResponsePayment;
import com.example.riotshop_api.model.Cart;
import com.example.riotshop_api.repository.ICartRepository;
import com.example.riotshop_api.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository iCartRepository;

    @Override
    public List<Cart> findCartByIdProduct(int idProduct) {
        return iCartRepository.findCartByIdProduct(idProduct);
    }

    @Override
    public List<Cart> findCartByNameAccount(String nameAccount) {
        return iCartRepository.findCartsByAccountUser_NameAccount(nameAccount);
    }

    @Override
    public Cart findByIdCart(int idCart) {
        return iCartRepository.findById(idCart).get();
    }


    @Override
    public void save(Cart cart) {
        iCartRepository.save(cart);
    }

    @Override
    public void deleteById(int id) {
        iCartRepository.deleteById(id);
    }

    @Override
    public boolean existsCartByAccountUser_IdAccountAndProduct_IdProduct(int idAccount, int idProduct) {
        return iCartRepository.existsCartByAccountUser_IdAccountAndProduct_IdProduct(idAccount,idProduct);
    }

    @Override
    public ResponsePayment payment(RequestPayment requestPayment) throws UnsupportedEncodingException {
        Inet4Address ip;
        try {
            ip = (Inet4Address) Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String vnp_TxnRef = Config.getRandomNumber(8);
        String vnp_TmnCode = Config.vnp_TmnCode;
        long amount = (long) (requestPayment.getTotalPrice()*100);
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
//        vnp_Params.put("vnp_Amount", "1000000");
        vnp_Params.put("vnp_CurrCode", "VND");
        vnp_Params.put("vnp_BankCode", "NCB");
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang thoi gian:" + vnp_TxnRef);
        vnp_Params.put("vnp_OrderType", "topup");
        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_ReturnUrl", Config.vnp_Returnurl);
        vnp_Params.put("vnp_IpAddr", String.valueOf(ip));
        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Config.hmacSHA512(Config.vnp_HashSecret, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
        ResponsePayment responsePayment = new ResponsePayment();
        responsePayment.setMessage("Successfully");
        responsePayment.setStatus("Ok");
        responsePayment.setURL(paymentUrl);
        return responsePayment;
    }
}
