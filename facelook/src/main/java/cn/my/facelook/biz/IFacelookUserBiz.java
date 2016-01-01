package cn.my.facelook.biz;

import cn.my.facelook.entity.FacelookUser;

public interface IFacelookUserBiz {

	/**
	 * ÓÃ»§µÇÂ¼
	 * @param user
	 * @return
	 */
	public FacelookUser doLogin(String id);
}
