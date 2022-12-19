package org.tukorea.project.service;


import org.tukorea.project.domain.UserVO;

public interface MemberService {
	public void register(UserVO user) throws Exception;
	public UserVO login(UserVO user) throws Exception;


}
