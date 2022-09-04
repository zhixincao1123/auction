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
		userMapper.insert(user);//对于user 即auctionuser 除id name password 都允许为空 后面那些不输入也没问题，
	
	//id的处理是不需要的 不允许为空的列不需要管。管理员权限属性不需要指定 但必然是0.对user对象的useradmin进行指定，必然是0
		}
		
	

}
