package org.lanqiao.printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("printer")
public class Printer {
	@Autowired/*默认用type注入*/
	@Qualifier("colorInk")/*修改为用名字注入*/
	private Ink ink;
	@Autowired/*默认用type注入*/
	private Paper paper;
	private String str = "惠普";

	public Printer(){

	}

	public Printer(String s){
		this.str = s;
	}
	
	public void print(String string){
		System.out.println(this.str + "正在使用"+ink.getColor()+"颜色的墨盒"+paper.getSize()+"纸张打印。");
		System.out.println("====================================");
		System.out.println(string);
	}
	
	public Ink getInk() {
		return ink;
	}
	public void setInk(Ink ink) {
		this.ink = ink;
	}
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	

}
