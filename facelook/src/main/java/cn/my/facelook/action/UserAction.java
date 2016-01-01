package cn.my.facelook.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.my.facelook.biz.IFacelookUserBiz;
import cn.my.facelook.entity.FacelookUser;

public class UserAction extends ActionSupport {

	private String id;
	private FacelookUser user;
	private IFacelookUserBiz fuBiz;
	/**
	 * 登录
	 * @return
	 * @throws Exception
	 */
	public String doLogin()throws Exception{
		FacelookUser loginUser = fuBiz.doLogin(user.getFuUserId());
		if(loginUser==null){
			addFieldError("loginMsg", "输入的用户id错误！");
			return "input";
		}else if(!loginUser.getFuPassword().equalsIgnoreCase(user.getFuPassword())){
			addFieldError("loginMsg", "输入的用户密码错误！");
			return "input";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("loginUser", loginUser);
			return "success";
		}
	}
	
	
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public FacelookUser getUser() {
		return user;
	}
	public void setUser(FacelookUser user) {
		this.user = user;
	}
	public IFacelookUserBiz getFuBiz() {
		return fuBiz;
	}
	public void setFuBiz(IFacelookUserBiz fuBiz) {
		this.fuBiz = fuBiz;
	}
}
