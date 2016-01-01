package cn.my.facelook.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.my.facelook.dao.IFacelookActivityDao;
import cn.my.facelook.entity.FacelookActivity;
import cn.my.facelook.entity.FacelookUser;

public class FacelookActivityDaoImpl extends HibernateDaoSupport implements
		IFacelookActivityDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<FacelookActivity> getList(final FacelookUser user) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				String sql = "select * from facelook_activity fa where fa.fu_user_id in " +
						"(select fu1_id from facelook_relation where fu2_id=:userId and fr_relation=1 " +
						"union " +
						"select fu2_id from facelook_relation where fu1_id=:userId and fr_relation=1) " +
						"order by fa_time desc";
				Query query = session.createSQLQuery(sql)
						.addEntity("fa", FacelookActivity.class);
				query.setString("userId", user.getFuUserId());
				return query.list();
			}
		});
	}

	@Override
	public Long save(FacelookActivity activity) {
		return (Long) getHibernateTemplate().save(activity);
	}

}
