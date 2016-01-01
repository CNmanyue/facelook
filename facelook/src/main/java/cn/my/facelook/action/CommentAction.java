package cn.my.facelook.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.my.facelook.biz.IFacelookActivityBiz;
import cn.my.facelook.biz.IFacelookCommentBiz;
import cn.my.facelook.biz.IFacelookPhotoBiz;
import cn.my.facelook.entity.FacelookActivity;
import cn.my.facelook.entity.FacelookComment;
import cn.my.facelook.entity.FacelookPhoto;
import cn.my.facelook.entity.FacelookUser;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CommentAction extends ActionSupport {

	private Long id;
	private FacelookComment comment;
	private List<FacelookComment> comments;
	private IFacelookCommentBiz fcBiz;
	private String option;
	private Long parentId; // Ҫ�����۵Ķ����id
	private Integer photoId;// ��Ƭid
	private IFacelookPhotoBiz fpBiz;
	private IFacelookActivityBiz facBiz;

	/**
	 * �������
	 * @return
	 * @throws Exception
	 */
	public String saveComment() throws Exception {
		// id ����ʱ�� ���۵��û� ���۵����� ���۵�����Ƭ�������� ����
		comment.setFcCreateTime(new Date());
		FacelookUser loginUser = (FacelookUser) ServletActionContext
				.getRequest().getSession().getAttribute("loginUser");
		// comment.setFcComment(ajax��ֵ����);
		comment.setFacelookUser(loginUser);
		List<FacelookComment> list = null;	//��������ֵ��
		/*
		 * ����Ƭ������ӽ���
		 */
		FacelookPhoto _photo = fpBiz.getByfpId(photoId);
		comment.setFacelookPhoto(_photo);
		/*
		 * ���������������û�����Ƭ���������û������۵��ж� ����û�������optionֵ��
		 */
		if (option.equalsIgnoreCase("parentId")) {
			// �����������һ�����ۣ�����id�ҵ������������õ�Ҫ�����������
			FacelookComment _comment = fcBiz.getById(parentId);
			comment.setFacelookComment(_comment);
			list = new ArrayList<FacelookComment>(_comment.getFacelookComments());
		}else{
			list = new ArrayList<FacelookComment>(_photo.getFacelookComments());
		}
		/*
		 * ����order
		 */
		if (list.size() > 0) {
			Integer _no = list.get(list.size() - 1).getFcOrder();
			comment.setFcOrder(_no + 1);
		} else {
			comment.setFcOrder(1);
		}
		id = fcBiz.save(comment);
		/*
		 * ��ݷ��ص�id����ѯ�õ�����ӽ�ȥ��Comment
		 */
		comment = fcBiz.getById(id);
		System.out.println("___saveComment End:" + id);
		FacelookActivity activity = new FacelookActivity();
		/*
		 * �ϴ�����Ƭ�� �ڶ�̬�����һ�м�¼
		 */
		activity.setFacelookPhoto(_photo);
		activity.setFacelookUser(loginUser);
		activity.setFaTime(new Timestamp(System.currentTimeMillis()));
		activity.setFaType(2);
		facBiz.save(activity);
		return "comment";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FacelookComment getComment() {
		return comment;
	}

	public void setComment(FacelookComment comment) {
		this.comment = comment;
	}

	public List<FacelookComment> getComments() {
		return comments;
	}

	public void setComments(List<FacelookComment> comments) {
		this.comments = comments;
	}

	public IFacelookCommentBiz getFcBiz() {
		return fcBiz;
	}

	public void setFcBiz(IFacelookCommentBiz fcBiz) {
		this.fcBiz = fcBiz;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public void setFpBiz(IFacelookPhotoBiz fpBiz) {
		this.fpBiz = fpBiz;
	}

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public void setFacBiz(IFacelookActivityBiz facBiz) {
		this.facBiz = facBiz;
	}


}
