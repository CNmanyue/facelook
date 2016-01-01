package cn.my.facelook.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.my.facelook.dao.IFacelookAlbumDao;
import cn.my.facelook.entity.FacelookAlbum;
import cn.my.facelook.entity.FacelookUser;

public class FacelookAlbumDaoImpl extends HibernateDaoSupport implements IFacelookAlbumDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<FacelookAlbum> findByUserId(String userId,Integer limit) {
		String hql = "from FacelookAlbum a where a.facelookUser.fuUserId='"+userId+"' " +
				"and a.faLimit<="+limit;
		return getHibernateTemplate().find(hql);
	}

	@Override
	public Long saveAlbum(FacelookAlbum album) {
		return (Long) getHibernateTemplate().save(album);
	}

	@Override
	public FacelookAlbum findById(Long albumId) {
		return (FacelookAlbum) getHibernateTemplate().get(FacelookAlbum.class,albumId);
	}

}
