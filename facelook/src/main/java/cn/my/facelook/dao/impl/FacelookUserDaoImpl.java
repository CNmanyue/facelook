package cn.my.facelook.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.my.facelook.dao.IFacelookUserDao;
import cn.my.facelook.entity.FacelookUser;

public class FacelookUserDaoImpl extends HibernateDaoSupport implements
		IFacelookUserDao {

	@Override
	public FacelookUser getById(String userId) {
		return (FacelookUser) getHibernateTemplate().get(FacelookUser.class, userId);
	}

	@Override
	public List<FacelookUser> getFriends(FacelookUser user) {
		// TODO Auto-generated method stub
		return null;
	}

}
