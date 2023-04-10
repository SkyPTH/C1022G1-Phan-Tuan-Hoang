//package com.example.book_borrow.AOP;
//
//import com.example.book_borrow.controller.BookController;
//import com.example.book_borrow.model.Book;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//public class LoginAspect {
//    @Pointcut("execution(* com.example.book_borrow.controller.BookController.borrow(..))")
//    public void loggingBorrowPointCut(){}
//    @Pointcut("execution(* com.example.book_borrow.controller.BookController.returnBook(..))")
//    public void loggingReturnPointCut() {}
//    @Pointcut("execution(* com.example.book_borrow.controller.BookController.list(..))")
//    public void loggingList () {}
//
//    @AfterReturning(pointcut = "loggingBorrowPointCut()")
//    public void handleAfterReturningBorrow(JoinPoint joinPoint) {
//        Book book = ((BookController)joinPoint.getTarget())
//                .bookService.findById(((Integer) joinPoint.getArgs()[0]).intValue()).get();
//        System.out.println("Sach "+ book.getBookName() + " da bi muon di 1, con lai: "
//                + book.getAmount() +" quyen sach");
//        System.out.println("*******************");
//    }
//
//    @AfterReturning(pointcut = "loggingReturnPointCut()")
//    public void handleAfterReturningReturn(JoinPoint joinPoint1) {
//        Book book = ((BookController)joinPoint1.getTarget())
//                .bookService.findById(((Integer) joinPoint1.getArgs()[1]).intValue()).get();
//        System.out.println("Sach "+ book.getBookName() + " da bi tra lai 1, con lai: "
//                + book.getAmount() +" quyen sach");
//        System.out.println("*******************");
//    }
//    int count = 0;
//    @AfterReturning(pointcut = "loggingList()")
//    public void handleAfterReturningLoggingList() {
//        System.out.println("Tong so nguoi ghe tham thu vien:" + ++count);
//        System.out.println("*******************");
//    }
//}
