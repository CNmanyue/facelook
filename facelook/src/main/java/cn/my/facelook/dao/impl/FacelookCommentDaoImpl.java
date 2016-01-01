package cn.my.facelook.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.my.facelook.dao.IFacelookCommentDao;
import cn.my.facelook.entity.FacelookComment;

public class FacelookCommentDaoImpl extends HibernateDaoSupport implements
		IFacelookCommentDao {

	@Override
	public Long save(FacelookComment comment) {
		System.out.println("----savecomment:");
		System.out.println("comment:"+comment.getFcComment());
		System.out.println("comment:"+comment.getFcOrder());
		System.out.println("comment:"+comment.getFacelookUser());
		System.out.println("id:"+comment.getFcId());
		try {
			return (Long) getHibernateTemplate().save(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public FacelookComment getById(Long id) {
		return (FacelookComment) getHibernateTemplate().get(FacelookComment.class, id);
	}

}
