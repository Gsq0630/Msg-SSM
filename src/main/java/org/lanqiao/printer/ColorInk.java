package org.lanqiao.printer;

import org.springframework.stereotype.Component;

@Component("colorInk")
public class ColorInk implements Ink{

	@Override
	public String getColor() {
		return "彩色";
	}
	

}
