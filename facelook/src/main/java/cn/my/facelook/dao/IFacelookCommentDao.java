package cn.my.facelook.dao;

import cn.my.facelook.entity.FacelookComment;

public interface IFacelookCommentDao {

	/**
	 * �������
	 * @param comment
	 * @return
	 */
	public Long save(FacelookComment comment);

	/**
	 * ����id���һ������
	 * @param id
	 * @return
	 */
	public FacelookComment getById(Long id);
}
