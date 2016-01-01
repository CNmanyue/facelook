package cn.my.facelook.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.my.facelook.dao.IFacelookPhotoDao;
import cn.my.facelook.entity.FacelookPhoto;

public class FacelookPhotoDaoImpl extends HibernateDaoSupport implements
		IFacelookPhotoDao {

	@Override
	public Integer savePhoto(FacelookPhoto fp) {
		return (Integer) getHibernateTemplate().save(fp);
	}

	@Override
	public FacelookPhoto getByfpId(Integer fpId) {
		return (FacelookPhoto) getHibernateTemplate().get(FacelookPhoto.class, fpId);
	}

	/*
	 * 通过id查询得到这张照片的所在的相册id,和这张照片的orderNum
	 * 查询相册内的照片的orderNum>这张照片的id 的第一张照片的id
	 * 通过Id查询得到下一张照片
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FacelookPhoto> getNextPhoto(Long albumId,Integer orderNo) {
		String hql = "from FacelookPhoto fp1 where fp1.facelookAlbum.faAlbumId=? " +
				"and fp1.fpOrder>? " +
				"order by fp1.fpOrder asc";
		return getHibernateTemplate().find(hql,new Object[]{albumId,orderNo});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FacelookPhoto> getPreviousPhoto(final Long albumId,final Integer orderNo) {
		String hql = "from FacelookPhoto fp1 where fp1.facelookAlbum.faAlbumId=? " +
				"and fp1.fpOrder<? " +
				"order by fp1.fpOrder desc";
		return getHibernateTemplate().find(hql,new Object[]{albumId,orderNo});
	}

	@Override
	public void deleteById(Integer id) {
		getHibernateTemplate().delete(getByfpId(id));
	}

}
