package cn.my.facelook.dao;

import java.util.List;

import cn.my.facelook.entity.FacelookUser;

public interface IFacelookUserDao {

	/**
	 * 通过Id获得一个用户
	 * @param userId
	 * @return
	 */
	public FacelookUser getById(String userId);

	/**
	 * 查询所有好友
	 * @param user
	 * @return
	 */
	public List<FacelookUser> getFriends(FacelookUser user);
	
}
