package com.gec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gec.pojo.User;
import com.gec.service.UserService;

@Controller
public class UserController {
@Autowired
UserService userService;//���ýӿڽ��д��� ʵ�ֶ�̬
	@RequestMapping("/userLogin")
	public String userLogin(User user) {//����userService��������Ϊuser���� ������������user����
		List<User> userList = userService.selectUser(user);
		//listֻ���õ���0��Ԫ�أ��û���������ֻ��һ������ 1702�� ֻ������list�����еĵ�0��Ԫ�أ���Ҫ�õ���ȷ���û���Ϣ
		//���ɷ�������ֵ�ͷ��صĿ�ݼ�ctrl+2���� �ٰ�L
		//�ж��û��Ƿ��¼�ɹ�������ʲô��
		//���˵�û����䣬 ��¼�����б� �϶�Ϊ�� user1�϶�Ϊ��
		//�����¼�ɹ� �������ݵ� �����ص�list���ϲ�Ϊ��
		//ͨ���ж�userlist�Ƿ�Ϊ�� �� user1�Ƿ�Ϊ��
		if(userList.isEmpty()){
			//��¼�ɹ�
			User user1=userList.get(0);
			return "success";
		}
		return "failed";
	}
}
