package cn.my.facelook.dao;

import java.util.List;

import cn.my.facelook.entity.FacelookActivity;
import cn.my.facelook.entity.FacelookUser;

public interface IFacelookActivityDao {

	/**
	 * 根据用户查询该用户的好友动态
	 * @param user
	 * @return
	 */
	public List<FacelookActivity> getList(FacelookUser user);

	/**
	 * 添加一条记录
	 * @param activity
	 * @return
	 */
	public Long save(FacelookActivity activity);
}
