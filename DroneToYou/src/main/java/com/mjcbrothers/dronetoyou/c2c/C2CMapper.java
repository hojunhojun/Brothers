package com.mjcbrothers.dronetoyou.c2c;

import java.util.List;

public interface C2CMapper {

	public abstract int regC2C(C2C c);

	public abstract int getC2CCount(C2CSelector ccs);

	public abstract List<C2C> get(C2CSelector ccs);

	public abstract int delete(C2C c);

	public abstract int update(C2C c); 
	
	public abstract int submitRequest(C2CRequest ccr);
	
	public abstract List<C2CRequest> getSubmitRequest(C2CRequest ccr);
}
