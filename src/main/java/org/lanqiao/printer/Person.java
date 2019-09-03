package org.lanqiao.printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Person {
    public static void main(String[] args) {
//		Printer pri=new Printer("惠普");
//
//		A4Paper a4=new A4Paper();
//		B5Paper b5=new B5Paper();
//		BlackInk bink=new BlackInk();
//		ColorInk cink=new ColorInk();
//
//		pri.setInk(cink);
//		pri.setPaper(b5);

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
        Printer printer = (Printer) context.getBean("printer");

        String str = "您可真是太优秀了！";

        printer.print(str);


    }


}
