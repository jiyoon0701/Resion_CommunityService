package org.tukorea.project.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tukorea.project.persistence.MemberDAO;
import org.tukorea.project.domain.UserVO;

@Component
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private MemberDAO memberDAO;
	
	private static final String namespace = "org.tukorea.project.mapper.UserMapper";
	
	@Override
	public void register(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".register", user);
	}	

	@Override
	public UserVO login(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.login(user);
	}

	

	
}
