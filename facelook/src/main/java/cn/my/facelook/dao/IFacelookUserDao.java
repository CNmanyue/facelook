package cn.my.facelook.dao;

import java.util.List;

import cn.my.facelook.entity.FacelookUser;

public interface IFacelookUserDao {

	/**
	 * ͨ��Id���һ���û�
	 * @param userId
	 * @return
	 */
	public FacelookUser getById(String userId);

	/**
	 * ��ѯ���к���
	 * @param user
	 * @return
	 */
	public List<FacelookUser> getFriends(FacelookUser user);
	
}
