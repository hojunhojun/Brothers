package com.mjcbrothers.dronetoyou.member;

public interface MemberMapper {
	public abstract Member getMemberByID(Member m);
	public abstract int join(Member m);
	public abstract int update(Member m);
	public abstract int bye(Member m);
}
