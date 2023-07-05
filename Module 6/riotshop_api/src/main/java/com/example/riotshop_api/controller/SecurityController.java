package com.example.riotshop_api.controller;


import com.example.riotshop_api.model.AccountUser;
import com.example.riotshop_api.model.Role;
import com.example.riotshop_api.sercurity.jwt.JwtProvider;
import com.example.riotshop_api.sercurity.request.EmailConfirm;
import com.example.riotshop_api.sercurity.request.SignInForm;
import com.example.riotshop_api.sercurity.request.SignUpForm;
import com.example.riotshop_api.sercurity.response.ConfirmEmailSuccess;
import com.example.riotshop_api.sercurity.response.ErrorMessage;
import com.example.riotshop_api.sercurity.response.JwtResponse;
import com.example.riotshop_api.sercurity.response.ResponseMessage;
import com.example.riotshop_api.sercurity.userPrincipal.UserPrinciple;
import com.example.riotshop_api.service.IAccountUserService;
import com.example.riotshop_api.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * @author ChinhLV
 */
@RestController
@RequestMapping("/public")
@CrossOrigin("*")
public class SecurityController {
    @Autowired
    IAccountUserService accountUserService;
    @Autowired
    IRoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;

    /**
     * @author HoangPT
     * @body signInForm
     * @return ResponseEntity<?> signup(@Valid @RequestBody SignUpForm signUpForm)
     * Phương thức sử dụng để đăng ký account dựa trên đầu vào là username và password
     * Kết quả trả về là 1 object bao gồm: message thành công khi lưu thành công hoặc bại khi lưu thất bại
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignUpForm signUpForm) {
        if (accountUserService.isAccountUserExistByName(signUpForm.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("Tài khoản đã tồn tại. Hãy thử lại"), HttpStatus.OK);
        }
        AccountUser users = new AccountUser(signUpForm.getUsername(), passwordEncoder.encode(signUpForm.getPassword()),signUpForm.getEmail(),signUpForm.getPhoneNumber());
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleService.findbyNameRole("ADMIN");
                    roles.add(adminRole);
                    break;
                case "employee":
                    Role employeeRole = roleService.findbyNameRole("EMPLOYEE");
                    roles.add(employeeRole);
                    break;
                default:
                    Role userRole = roleService.findbyNameRole("USER");
                    roles.add(userRole);
            }
        });
        users.setRole(roles);
        System.out.println(users);
        AccountUser accountUser = accountUserService.save(users);
        if (accountUser != null) {
            return new ResponseEntity<>(new ResponseMessage("Tạo tài khoản thành công!!!"), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new ResponseMessage("Tạo tài khoản thất bại!!!"), HttpStatus.BAD_REQUEST);
    }

    /**
     * @author HoangPT
     * @body signInForm
     * @return ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm)
     * Phương thức sử dụng để đăng nhập dựa trên đầu vào là username và password
     * Kết quả trả về là 1 object bao gồm: token được tạo có hiệu lực 1h, tên người dùng và quyền truy cập
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ErrorMessage> errorMessages = new ArrayList<>();
            bindingResult
                    .getFieldErrors()
                    .stream()
                    .forEach(f -> errorMessages.add(new ErrorMessage(f.getField(), f.getDefaultMessage())));
            return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return new ResponseEntity<>(new JwtResponse(token, userPrinciple.getUsername(), userPrinciple.getAuthorities()), HttpStatus.OK);
    }
    /**
     * @author HoangPT
     * @param emailConfirm
     * @return ResponseMessage thông báo
     * hàm trả message nếu email đã tồn tại trong db hay chưa
     */
//    @PostMapping("/confirm-email")
//    public ResponseEntity<?> confirmEmailSignup(@RequestBody EmailConfirm emailConfirm) {
//        Boolean flag = iCustomerService.existByEmail(emailConfirm.getEmail());
//        if (flag) {
//            int code = accountUserService.sendEmail(emailConfirm.getEmail());
//            return new ResponseEntity<>(new ConfirmEmailSuccess("Xác nhận email thành công.",String.valueOf(code), emailConfirm.getEmail()), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(new ResponseMessage("Email không tồn tại."),HttpStatus.NOT_FOUND);
//        }
//    }
//
//    /**
//     * @author ChinhLV
//     * @param resetPassword
//     * @return http.statusCode
//     * hàm trả status code 2xx nếu đổi mật khẩu thành công, 4xx nếu thất bại.
//     */
//    @PostMapping("/reset-password")
//    public ResponseEntity<?> resetPassword(@RequestBody ResetPassword resetPassword ) {
//        Customer customer = iCustomerService.findCustomerByEmail(resetPassword.getEmail());
//        AccountUser accountUser = customer.getAccountUser();
//        accountUser.setPasswordAccount(passwordEncoder.encode(resetPassword.getPassword()));
//        AccountUser newAccountUser = accountUserService.saveAccountUser(accountUser);
//        if (newAccountUser == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//    /**
//     * @author ChinhLV
//     * @param facebookRequest
//     * @return http.statusCode
//     * hàm trả status code 2xx nếu đổi mật khẩu thành công, 4xx nếu thất bại.
//     */
//    @PostMapping("/login-facebook")
//    public ResponseEntity<?> loginByAccountFacebook(@RequestBody FacebookRequest facebookRequest) {
//        if (accountUserService.existByNameAccount(facebookRequest.getEmail())) {
//            return new ResponseEntity<>(new ResponseMessage("Email đã tồn tại, vui lòng thử lại"), HttpStatus.BAD_REQUEST);
//        }
//        AccountUser accountUser = new AccountUser();
//        Random rnd = new Random();
//        int numberRandom = rnd.nextInt(900000) + 100000;
//        accountUser.setNameAccount(facebookRequest.getEmail());
//        accountUser.setPasswordAccount(passwordEncoder.encode(String.valueOf(numberRandom)));
//        Set<Roles> roles = new HashSet<>();
//        roles.add(roleService.findRolesByName("USER"));
//        accountUser.setRoles(roles);
//        accountUserService.saveAccountUser(accountUser);
//        accountUserService.sendPassword(facebookRequest.getEmail(), numberRandom);
//        accountUserService.saveAccountUser(accountUser);
//        return new ResponseEntity<>(new ResponseMessage("Thêm mới tài khoản thành công."),HttpStatus.CREATED);
//    }
}
