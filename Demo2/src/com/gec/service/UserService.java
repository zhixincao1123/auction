package com.gec.service;

import java.util.List;

import com.gec.pojo.User;

public interface UserService {

	//定义一个登录的方法
	//select * from user where username=? and password=?->生成关于用户表的一条数据
	//根据两个普通字段（区别于主键）查询表，查询出来应该是一条数据还是多条数据 只取多条数据中的第一条数据
	//一条数据用一个user表示，多条数据使用对象的列表
	public List<User> selectUser(User user);//想要拿到真实的数据 只要拿到list数据中的第一个元素 
	//这个方法必在usercontroller进行调用
	//形参的两种写法都写 1 指定实体类
	//接口搞定
	//直接指定实体类 （修正）
}