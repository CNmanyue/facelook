package cn.my.facelook.biz;

import java.util.List;

import cn.my.facelook.entity.FacelookActivity;
import cn.my.facelook.entity.FacelookUser;

public interface IFacelookActivityBiz {

	/**
	 * 根据用户查询最近好友动态
	 * @param user
	 * @return
	 */
	public List<FacelookActivity> getList(FacelookUser user);

	/**
	 * 添加一条动态
	 * @param activity
	 */
	public Long save(FacelookActivity activity);
}
