package org.tukorea.project.persistence;

import java.util.List;
import java.util.Map;


import org.tukorea.project.domain.UserVO;

public interface MemberDAO {
	// 회원가입 
	public void register(UserVO user) throws Exception;
	
	// 로그인 
	public UserVO login(UserVO user) throws Exception;


}
