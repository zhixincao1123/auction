package com.gec.serviceImpl;

import java.util.List;//.


import org.springframework.beans.factory.annotation.Autowired;//.
import org.springframework.stereotype.Service;//.

import com.gec.mapper.UserMapper;
import com.gec.pojo.User;//.
import com.gec.pojo.UserExample;
import com.gec.service.UserService;//.
@Service//1 ��ע��
public class UserServiceImpl implements UserService {
//2 ע��usermapper�ӿ�(����Autowiredע��userMapper)
	@Autowired
	UserMapper userMapper; 
	@Override
	public List<User> selectUser(User user) {//3.����userMapper�ĸ���������ѯ�ķ���
		// TODO Auto-generated method stub
		//(1)����example����//4.����example���󣬻�ȡcriteria����װ��ѯ����
		UserExample example=new UserExample();
		UserExample.Criteria criteria=example.createCriteria();//����example�����һ������
		//������Ҫ��ȡexample�е�Criteria�����ǶԲ�ѯ�������з�װ��example�Լ������ˣ�ֻ�ܽ����������criteria��ͨ��example�����е�createCriteria�������л�ȡ��
		//����criteria֮�� ����������ȥ��װ��ѯ����
		//select * from ..user where username=? and password=?
		criteria.andLoginNameEqualTo(user.getLoginName());//5.���ݹ��ܶ�Ӧ��sql�����������ķ�װ
		//and�������user���е��ֶ�����,����������Ҫ�Ľ��е���
		//�ڶ����ֿ�ʼ
		criteria.andPasswordEqualTo(user.getPassword());
		List<User> userList = userMapper.selectByExample(example);//6.��������ѯ�ķ���selectByExample�ķ���ֵ��Ϊservice��ʵ�ַ�������
		return userList;//userList��Ϊselect�ķ���ֵ����return
	}
//��Ϊspring�е�bean
}
