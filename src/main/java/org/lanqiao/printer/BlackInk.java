package org.lanqiao.printer;

import org.springframework.stereotype.Component;

@Component
public class BlackInk implements Ink{

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return "黑色";
	}

}
