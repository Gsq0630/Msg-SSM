package org.lanqiao.printer;

import org.springframework.stereotype.Component;

@Component
public class A4Paper implements Paper{

	@Override
	public String getSize() {
		// TODO Auto-generated method stub
		return "A4";
	}

}
