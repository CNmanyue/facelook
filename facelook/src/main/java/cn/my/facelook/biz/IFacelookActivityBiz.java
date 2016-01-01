package cn.my.facelook.biz;

import java.util.List;

import cn.my.facelook.entity.FacelookActivity;
import cn.my.facelook.entity.FacelookUser;

public interface IFacelookActivityBiz {

	/**
	 * �����û���ѯ������Ѷ�̬
	 * @param user
	 * @return
	 */
	public List<FacelookActivity> getList(FacelookUser user);

	/**
	 * ���һ����̬
	 * @param activity
	 */
	public Long save(FacelookActivity activity);
}
