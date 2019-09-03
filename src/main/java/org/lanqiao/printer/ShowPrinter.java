package org.lanqiao.printer;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ShowPrinter {


    @Before("execution(* org.lanqiao.printer.*.print(..))")
    public void buy(){
        System.out.println("购买纸张");
    }

    @After("execution(* org.lanqiao.printer.*.print(..))")
    public void maidiao(){
        System.out.println("卖掉打印机");
    }



}
