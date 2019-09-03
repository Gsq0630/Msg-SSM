package org.lanqiao.printer;

import org.springframework.stereotype.Component;

//@Component("b5")
public class B5Paper implements Paper{

	@Override
	public String getSize() {
		// TODO Auto-generated method stub
		return "B5";
	}

}
