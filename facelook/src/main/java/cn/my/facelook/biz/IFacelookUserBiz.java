package cn.my.facelook.biz;

import cn.my.facelook.entity.FacelookUser;

public interface IFacelookUserBiz {

	/**
	 * �û���¼
	 * @param user
	 * @return
	 */
	public FacelookUser doLogin(String id);
}
