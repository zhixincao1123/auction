package com.gec.service;

import java.util.List;

import com.gec.pojo.User;

public interface UserService {

	//����һ����¼�ķ���
	//select * from user where username=? and password=?->���ɹ����û����һ������
	//����������ͨ�ֶΣ���������������ѯ����ѯ����Ӧ����һ�����ݻ��Ƕ������� ֻȡ���������еĵ�һ������
	//һ��������һ��user��ʾ����������ʹ�ö�����б�
	public List<User> selectUser(User user);//��Ҫ�õ���ʵ������ ֻҪ�õ�list�����еĵ�һ��Ԫ�� 
	//�����������usercontroller���е���
	//�βε�����д����д 1 ָ��ʵ����
	//�ӿڸ㶨
	//ֱ��ָ��ʵ���� ��������
}