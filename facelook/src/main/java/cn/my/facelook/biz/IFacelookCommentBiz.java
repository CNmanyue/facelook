package cn.my.facelook.biz;

import cn.my.facelook.entity.FacelookComment;

public interface IFacelookCommentBiz {

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
