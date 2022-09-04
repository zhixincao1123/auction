package com.gec.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gec.mapper.UserMapper;
import com.gec.pojo.User;
import com.gec.pojo.UserExample;
import com.gec.service.UserService;
@Service
public class UserServiceImpl implements UserService {
@Autowired
UserMapper userMapper;
	@Override
	public List<User> selectUser(User user) {
		// TODO Auto-generated method stub
		UserExample example=new UserExample();
		UserExample.Criteria criteria=example.createCriteria();
		
		criteria.andLoginNameEqualTo(user.getLoginName());
		criteria.andPasswordEqualTo(user.getPassword());
		List<User>userlist=userMapper.selectByExample(example);
		
		return userlist;
	}

}
