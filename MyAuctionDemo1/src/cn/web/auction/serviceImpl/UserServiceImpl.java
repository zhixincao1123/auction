package cn.web.auction.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import cn.web.auction.mapper.UserMapper;
import cn.web.auction.pojo.User;
import cn.web.auction.pojo.UserExample;
import cn.web.auction.service.UserService;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
UserMapper userMapper;
	
	@Override
	public User login(String username, String userpassword) {
		// TODO Auto-generated method stub
		UserExample example=new UserExample();
		UserExample.Criteria criteria=example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andUserpasswordEqualTo(userpassword);
		
	List<User> userList=userMapper.selectByExample(example);
	if(!userList.isEmpty()) 
	{return userList.get(0);
		}return null;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		user.setUserisadmin(0);
		userMapper.insert(user);//����user ��auctionuser ��id name password ������Ϊ�� ������Щ������Ҳû���⣬
	
	//id�Ĵ����ǲ���Ҫ�� ������Ϊ�յ��в���Ҫ�ܡ�����ԱȨ�����Բ���Ҫָ�� ����Ȼ��0.��user�����useradmin����ָ������Ȼ��0
		}
		
	

}
