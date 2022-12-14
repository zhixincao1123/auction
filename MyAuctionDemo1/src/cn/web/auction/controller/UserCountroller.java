package cn.web.auction.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.web.auction.pojo.User;
import cn.web.auction.service.UserService;

@Controller
@RequestMapping("/user")
public class UserCountroller {
	@Autowired
	UserService userService;
	
	@RequestMapping("/doLogin")
public  String doLogin(String username,
		String userpassword,
		String inputCode,
		HttpSession session,
		Model model) {//先判断验证码
		//获取自动生成的验证码 和 用户输入的验证码 pk
		if(!inputCode.equalsIgnoreCase((String)session.getAttribute("numrand"))) {
			//验证码不通过
			model.addAttribute("errorMsg", "验证码错误");
			return "login";
		}//验证码通过
		//用户名 密码判断
		
		User user=userService.login(username, userpassword);
		
		if(user!=null) {//登录成功
			//利用session作用域帮我们存放用户user的信息
			session.setAttribute("user", user);
			
			//进行跳转
		return "redirect:/auction/queryAuctions";}
			
				//用户名和密码错误
				//liyong利用mode传输错误消息,model作为载体，把数据内容从后端传到前端，前端接受的依据就是键errorMsg
			else {
				model.addAttribute("errorMsg", "用户名和密码错误");
				return "login";
			}	
			}
	
	//首先 注册方法的方法返回值是什么
	//我注册的页面想要什么结果 1.用户的所有输入都被成功地插入到表的auctionuser表里面，成为一条新的数据。注册成功，点击立即注册，我们想要chenxian呈现一种什么样地效果。注册成功 跳转到登录页面。登录页面还有验证码，所以说需要雅正一下
//2.注册失败	 无论如何 只是都是单纯地页面跳转，不需要把数据在这个登录页面进行渲染。再次对registor.jsp进行访问，清空里面地所有信息，不需要视图地渲染
//所以简单使用string作为返回值就可以了
	@RequestMapping("/register")
	public String register(@Validated User user,BindingResult bindingResult,Model model)
	{//第一件事情，是否登录成功取决于bindingResult容器里 有没有错误信息。如果有，证明输错了内容。相反 没有错误信息 证明用户在注册页面内全输正确了。并且把信息插入到user表里面去
		if (bindingResult.hasErrors()) {
			//如果有错误信息 就必须让用户知道
		//对所有错误信息进行统一处理 方式一
			/** 方法一 
			 * List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError objectError : errors) {
				System.out.println(objectError);
			}
			model.addAttribute("errors", errors);**/
			//把每一个错误区分开来
			//方法二 利用表单项的name属性作为错误的键
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				model.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return "register";
		}
		
		//用户输入的所有数据都合法，进行注册成功的处理
		//将用户输入的数据插入user表中
		userService.addUser(user);//创建一个方法 根据什么来插呢 根据接收的user对象来插
		return "login";//我们定义了这个方法参数，返回值需不需要 不需要。添加数据的操作侧重于表数据本身的一个操作，跟我们查询有所区别，查询就在于返回的数据内容。但是增、删、改这一类专注于数据本身
	//注册成功跳转到登录页面
		}
	//用户注销
	@RequestMapping("/doLogout")
	public String doLogout(HttpSession session)
	{session.invalidate();//方式一 销毁
	//session.removeAttribute("user");//方式二 移除session中的user
	return "login";
	}
}
