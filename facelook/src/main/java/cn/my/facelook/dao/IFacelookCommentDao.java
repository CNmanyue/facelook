package cn.my.facelook.dao;

import cn.my.facelook.entity.FacelookComment;

public interface IFacelookCommentDao {

	/**
	 * 添加评论
	 * @param comment
	 * @return
	 */
	public Long save(FacelookComment comment);

	/**
	 * 根据id获得一条评论
	 * @param id
	 * @return
	 */
	public FacelookComment getById(Long id);
}
