package cn.web.auction.service;

import cn.web.auction.pojo.User;

public interface UserService {

	//�������ɸѡ�Ĳ���
	public User login(String username,String userpassword);
	//��ȡList�����еĵ�һ������//ֱ�ӽ��зǿ��ж� ��ȡList�����е�Ԫ��

	public void addUser(User user);
}