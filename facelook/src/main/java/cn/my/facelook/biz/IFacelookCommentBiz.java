package cn.my.facelook.biz;

import cn.my.facelook.entity.FacelookComment;

public interface IFacelookCommentBiz {

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
