package cn.my.facelook.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.my.facelook.biz.IFacelookActivityBiz;
import cn.my.facelook.biz.IFacelookAlbumBiz;
import cn.my.facelook.biz.IFacelookCommentBiz;
import cn.my.facelook.biz.IFacelookPhotoBiz;
import cn.my.facelook.entity.FacelookActivity;
import cn.my.facelook.entity.FacelookAlbum;
import cn.my.facelook.entity.FacelookComment;
import cn.my.facelook.entity.FacelookPhoto;
import cn.my.facelook.entity.FacelookUser;
import cn.my.facelook.util.FileUtil;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class PhotoAction extends ActionSupport {

	private Integer id; // ����
	private FacelookPhoto fp; // ��Ƭʵ�����
	private List<FacelookPhoto> fpList; // ʵ�弯��
	private File photo; // �ϴ����ļ�
	private String photoContentType; // �ϴ����ļ�������
	private String photoFileName; // �ϴ����ļ����
	private InputStream inputStream; // �����
	private IFacelookPhotoBiz fpBiz; // ������Ƭ���ҵ�����
	private IFacelookAlbumBiz faBiz;
	private Long albumId; // ���id
	private Integer orderNo; // ��Ƭ��������-orderNo
	private String type; // ��Ƭ���ͣ�����ͼ|ԭͼ
	private Map<Object, List<FacelookComment>> map;	//����map
	private IFacelookActivityBiz facBiz;

	/**
	 * �ϴ�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String upload() throws Exception {
		System.out.println("----------photoAction upload()");
		FacelookAlbum album = faBiz.findById(albumId);
		System.out.println("--" + albumId + "**" + album.getFaAlbumName());
		fp.setFacelookAlbum(album); // �������
		FacelookActivity activity = new FacelookActivity();
		fp.setFacelookActivities(null); // ��̬
		fp.setFacelookComments(null); // ����
		fp.setFacelookMarks(null); // Ȧ��
		fp.setFpContent(FileUtil.toByteArray(photo));// ��Ƭ
		fp.setFpContentType(photoContentType); // �ļ�����
		fp.setFpCreateTime(new Date()); // �ϴ�ʱ��
		if (null == fp.getFpName() || fp.getFpName().equalsIgnoreCase("")) {
			int index = photoFileName.indexOf(".");
			System.out.println("index:" + index);
			fp.setFpName(photoFileName.substring(0, index));
		} // ��Ƭ���
		List<FacelookPhoto> list = new ArrayList<FacelookPhoto>(
				album.getFacelookPhotos());
		System.out.println("list.size:" + list.size());
		if (list.size() > 0) {// ����
			Integer no = list.get(list.size() - 1).getFpOrder() + 1;
			fp.setFpOrder(no);
		} else {
			fp.setFpOrder(1);
		}
		fp.setFpThumbnail(FileUtil.buildThumbnail(photo)); // ����ͼ
		id = fpBiz.savePhoto(fp);
		/*
		 * �ϴ�����Ƭ�� �ڶ�̬�����һ�м�¼
		 */
		activity.setFacelookPhoto(fp);
		FacelookUser user = (FacelookUser) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		activity.setFacelookUser(user);
		activity.setFaTime(new Timestamp(System.currentTimeMillis()));
		activity.setFaType(1);
		facBiz.save(activity);
		return "upload_ok";
	}

	/**
	 * �����Ƭ����ʾ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showPhotoList() throws Exception {
		fp = fpBiz.getByfpId(id);
		photoContentType = fp.getFpContentType();
		if (type != null && type.equalsIgnoreCase("big")) {
			inputStream = new ByteArrayInputStream(fp.getFpContent());
			type = null;
		} else {
			inputStream = new ByteArrayInputStream(fp.getFpThumbnail());
		}
		inputStream.close();
		return "photo";
	}

	/**
	 * �鿴����ͼƬ
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String view() throws Exception {
		fp = fpBiz.getByfpId(id);
		map = new HashMap<Object, List<FacelookComment>>();
		List<FacelookComment> _comments = new ArrayList<FacelookComment>(fp.getFacelookComments());
		for (FacelookComment comment : _comments) {
			List<FacelookComment> list = map.get(comment.getFacelookComment());
			if (list == null) {
				list = new ArrayList<FacelookComment>();
				list.add(comment);
				map.put(comment.getFacelookComment(), list);
			} else {
				list.add(comment);
			}
		}
		return "toView";
	}

	/**
	 * �����һ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewNext() throws Exception {
		fp = fpBiz.getNextPhoto(albumId, orderNo);
		if (fp == null) {
			/*
			 * ���û����һ�ţ���ô����view()����
			 * ���¼��ص�ǰͼƬ��
			 */
			view();
			ServletActionContext.getRequest().setAttribute("existMsg",
					"�Ѿ������һ�ţ�");
		}else{
			id = fp.getFpPhotoId();
			view();
		}
		return "toView";
	}

	/**
	 * �����һ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewPrevious() throws Exception {
		fp = fpBiz.getPreviousPhoto(albumId, orderNo);
		if (fp == null) {
			/*
			 * ���û����һ�ţ���ô����view()����
			 * ���¼��ص�ǰͼƬ��
			 */
			view();
			fp = fpBiz.getByfpId(id);
			ServletActionContext.getRequest().setAttribute("existMsg",
					"�Ѿ��ǵ�һ�ţ�");
		}else{
			id = fp.getFpPhotoId();
			view();
		}
		return "toView";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FacelookPhoto getFp() {
		return fp;
	}

	public void setFp(FacelookPhoto fp) {
		this.fp = fp;
	}

	public List<FacelookPhoto> getFpList() {
		return fpList;
	}

	public void setFpList(List<FacelookPhoto> fpList) {
		this.fpList = fpList;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public void setFpBiz(IFacelookPhotoBiz fpBiz) {
		this.fpBiz = fpBiz;
	}

	public void setFaBiz(IFacelookAlbumBiz faBiz) {
		this.faBiz = faBiz;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Map<Object, List<FacelookComment>> getMap() {
		return map;
	}

	public void setMap(Map<Object, List<FacelookComment>> map) {
		this.map = map;
	}

	public void setFacBiz(IFacelookActivityBiz facBiz) {
		this.facBiz = facBiz;
	}

}
