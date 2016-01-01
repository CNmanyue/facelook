package cn.my.facelook.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.my.facelook.biz.IFacelookActivityBiz;
import cn.my.facelook.entity.FacelookActivity;
import cn.my.facelook.entity.FacelookUser;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ActivityAction extends ActionSupport {

	private Long id;
	private FacelookActivity activity;
	private List<FacelookActivity> activitys;
	private IFacelookActivityBiz facBiz;
	
	/**
	 * 查询用户的最近好友动态
	 * @return
	 * @throws Exception
	 */
	public String getList()throws Exception{
		FacelookUser user = (FacelookUser) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		activitys = facBiz.getList(user);
		return "home";
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public FacelookActivity getActivity() {
		return activity;
	}
	public void setActivity(FacelookActivity activity) {
		this.activity = activity;
	}
	public List<FacelookActivity> getActivitys() {
		return activitys;
	}
	public void setActivitys(List<FacelookActivity> activitys) {
		this.activitys = activitys;
	}
	public void setFacBiz(IFacelookActivityBiz facBiz) {
		this.facBiz = facBiz;
	}
}
