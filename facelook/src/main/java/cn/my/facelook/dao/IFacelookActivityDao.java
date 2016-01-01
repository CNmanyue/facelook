package cn.my.facelook.dao;

import java.util.List;

import cn.my.facelook.entity.FacelookActivity;
import cn.my.facelook.entity.FacelookUser;

public interface IFacelookActivityDao {

	/**
	 * �����û���ѯ���û��ĺ��Ѷ�̬
	 * @param user
	 * @return
	 */
	public List<FacelookActivity> getList(FacelookUser user);

	/**
	 * ���һ����¼
	 * @param activity
	 * @return
	 */
	public Long save(FacelookActivity activity);
}
