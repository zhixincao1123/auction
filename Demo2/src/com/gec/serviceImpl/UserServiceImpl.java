package com.gec.serviceImpl;

import java.util.List;//.


import org.springframework.beans.factory.annotation.Autowired;//.
import org.springframework.stereotype.Service;//.

import com.gec.mapper.UserMapper;
import com.gec.pojo.User;//.
import com.gec.pojo.UserExample;
import com.gec.service.UserService;//.
@Service//1 加注解
public class UserServiceImpl implements UserService {
//2 注入usermapper接口(利用Autowired注入userMapper)
	@Autowired
	UserMapper userMapper; 
	@Override
	public List<User> selectUser(User user) {//3.调用userMapper的根据条件查询的方法
		// TODO Auto-generated method stub
		//(1)创建example对象//4.创建example对象，获取criteria来封装查询条件
		UserExample example=new UserExample();
		UserExample.Criteria criteria=example.createCriteria();//等于example对象的一个方法
		//我们想要获取example中的Criteria帮我们对查询条件进行封装，example自己做不了，只能借助它里面的criteria。通过example对象中的createCriteria方法进行获取。
		//有了criteria之后 可以利用它去封装查询条件
		//select * from ..user where username=? and password=?
		criteria.andLoginNameEqualTo(user.getLoginName());//5.根据功能对应的sql语句完成条件的封装
		//and后跟的是user表中的字段名称,按照我们想要的进行调用
		//第二部分开始
		criteria.andPasswordEqualTo(user.getPassword());
		List<User> userList = userMapper.selectByExample(example);//6.把条件查询的方法selectByExample的返回值作为service的实现方法返回
		return userList;//userList作为select的返回值进行return
	}
//成为spring中的bean
}
