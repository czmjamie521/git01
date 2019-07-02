package com.shsxt.userservice;

import javax.servlet.http.HttpServletRequest;

import com.mysql.fabric.Response;
import com.shsxt.userdao.UserDao;
import com.sxt.util.ResultInfo;
import com.sxt.util.StringUtil;
import com.sxt.util.User;

import jdk.nashorn.internal.ir.RuntimeNode.Request;


public class UserService {
	private UserDao userdao=new UserDao();

	public ResultInfo<User> checkByUname(String uname) {
		//锟矫碉拷web锟姐传锟斤拷锟侥诧拷锟斤拷uname
		ResultInfo<User> resultinfo=new ResultInfo();
		User user=new User();
		user.setUname(uname);
		resultinfo.setResult(user);
		//锟叫讹拷web锟斤拷锟斤拷锟斤拷锟斤拷锟角凤拷强锟�
		if(StringUtil.isEmpty(uname)){
			resultinfo.setCode(0);
			resultinfo.setMsg("锟矫伙拷锟斤拷锟斤拷锟斤拷为锟斤拷");
			return resultinfo;
		}
		//锟矫碉拷锟斤拷台锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		User u=userdao.checkUname(uname);
		if(u==null){
			resultinfo.setCode(0);
			resultinfo.setMsg("锟矫伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷");
			return resultinfo;
		}
			resultinfo.setCode(1);
			return resultinfo;
		
		
	}

	public ResultInfo loginByName(String uname, String upwd) {
		//锟矫碉拷web锟斤拷牟锟斤拷锟絬name锟斤拷upwd
		ResultInfo<User> resultinfo=new ResultInfo();
		User user = new User();
		user.setUname(uname);
		user.setUpwd(upwd);
		resultinfo.setResult(user);
		//锟叫讹拷uname锟斤拷upwd锟角凤拷强锟�
		if(StringUtil.isEmpty(uname)||StringUtil.isEmpty(upwd)){
			resultinfo.setCode(0);
			resultinfo.setMsg("锟矫伙拷锟斤拷锟斤拷锟斤拷锟斤拷为锟斤拷");
			return resultinfo;
		}
		//锟斤拷锟斤拷dao锟斤拷锟絬ser
		User u=userdao.loginunameandupwd(uname,upwd);
		
		//锟叫讹拷锟角凤拷为锟斤拷
		if(u==null){
			resultinfo.setCode(0);
			resultinfo.setMsg("* 锟矫伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�,锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷!");
			return resultinfo;
		}
		resultinfo.setCode(1);
		resultinfo.setMsg("锟斤拷录锟缴癸拷");
		resultinfo.setResult(u);
		
		return resultinfo;
	}

	public ResultInfo<User> registerUser(HttpServletRequest request) {
		//锟斤拷锟角疤拷锟斤拷锟�
		String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String upwd=request.getParameter("upwd");
		String head=request.getParameter("head");
		ResultInfo<User> resultinfo=new ResultInfo();
		User user=new User();
		user.setUname(uname);
		user.setEmail(email);
		user.setPhone(phone);
		user.setUpwd(upwd);
		user.setHead(head);
		resultinfo.setResult(user);
		if(StringUtil.isEmpty(uname)){
			resultinfo.setCode(0);
			resultinfo.setMsg("锟矫伙拷锟斤拷锟斤拷锟斤拷为锟斤拷");
			return resultinfo;
		}
		if(StringUtil.isEmpty(upwd)){
			resultinfo.setCode(0);
			resultinfo.setMsg("锟斤拷锟诫不锟斤拷为锟斤拷");
			return resultinfo;
		}
		if(StringUtil.isEmpty(phone)){
			resultinfo.setCode(0);
			resultinfo.setMsg("锟斤拷锟诫不锟斤拷为锟斤拷");
			return resultinfo;
		}
		//锟矫碉拷锟斤拷台锟斤拷锟斤拷影锟斤拷锟斤拷锟斤拷锟侥诧拷锟斤拷
 		int row=userdao.registerUser(uname,email,phone,upwd,head);
		System.out.println(row);
		if(row>0){
			resultinfo.setCode(1);
			User u=userdao.loginunameandupwd(uname,upwd);
			resultinfo.setResult(u);
			return resultinfo;
		}
		resultinfo.setCode(0);
		resultinfo.setMsg("锟斤拷锟斤拷没锟绞э拷锟�");
		return resultinfo;
	}

	public ResultInfo<User> uniqueUser(String uname) {
		//锟斤拷锟斤拷uname锟斤拷email
		ResultInfo<User> resultinfo=new ResultInfo();
		User user=new User();
		user.setUname(uname);
		
		resultinfo.setResult(user);
		//锟叫讹拷锟角凤拷强锟�
		if(StringUtil.isEmpty(uname)){
			resultinfo.setCode(0);
			resultinfo.setMsg("锟矫伙拷锟斤拷锟斤拷锟斤拷为锟斤拷");
			return resultinfo;
		}
		//锟叫讹拷锟矫伙拷锟斤拷锟角凤拷锟截革拷
		//锟矫碉拷锟斤拷台锟斤拷锟斤拷锟斤拷锟矫伙拷
		User u=userdao.uniqueByName(uname);
		System.out.println(u);
		
		//锟叫讹拷前台锟斤拷锟斤拷锟斤拷
		if(u==null){
			resultinfo.setCode(1);
			return resultinfo;
		}
		resultinfo.setCode(0);
		resultinfo.setMsg("* 锟矫伙拷锟斤拷锟窖憋拷占锟斤拷");
		return resultinfo;
		}
	
	public ResultInfo<User> payByUserId(double balance, Integer uid) {
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟秸的讹拷锟斤拷
		ResultInfo<User> resultinfo=new ResultInfo();
		User user = new User();
		user.setBalance(balance);
		resultinfo.setResult(user);
		//锟叫断斤拷锟斤拷欠锟角匡拷
		if(balance<=0){
			resultinfo.setCode(0);
			resultinfo.setMsg("锟斤拷畈伙拷锟斤拷锟叫★拷锟斤拷锟�");
			return resultinfo;
		}
		//锟矫碉拷dao锟姐传锟斤拷锟斤拷user锟斤拷balance
		int row=userdao.payBalance(balance,uid);
		if(row>0){
			resultinfo.setCode(1);
			resultinfo.setMsg("锟斤拷值锟缴癸拷");
			User u=userdao.checkBalance(uid);
			resultinfo.setResult(u);
			return resultinfo;
		}
		resultinfo.setCode(0);
		resultinfo.setMsg("锟斤拷值失锟斤拷");
		return resultinfo;
	}

	public ResultInfo<User> updateUser(String userphone, String useremail, String sex, String age, int uid) {
		ResultInfo<User> resultinfo=new ResultInfo();
		if(StringUtil.isEmpty(userphone)||StringUtil.isEmpty(useremail)||StringUtil.isEmpty(sex)||StringUtil.isEmpty(age)){
			resultinfo.setCode(0);
			return resultinfo;
		}
		int row=userdao.updateUser( userphone,  useremail,  sex,  age,  uid);
		if(row<1){
			resultinfo.setCode(0);
			return resultinfo;
		}
		resultinfo.setCode(1);
		return resultinfo;
	}
		
	}

	
	

