package cn.my.facelook.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.my.facelook.biz.IFacelookAlbumBiz;
import cn.my.facelook.entity.FacelookAlbum;
import cn.my.facelook.entity.FacelookUser;

import com.opensymphony.xwork2.ActionSupport;

public class AlbumAction extends ActionSupport{

	private Long id;
	private String userId;	//用户编号
	private FacelookAlbum album;	//创建相册实体
	private Integer limit;
	private List<FacelookAlbum> albums;	//获得相册集合
	
	private IFacelookAlbumBiz faBiz;
	/**
	 * 按照用户查找
	 * @return
	 * @throws Exception
	 */
	public String doListByUser()throws Exception{
		FacelookUser loginUser = (FacelookUser) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		System.out.println("loginId:"+loginUser.getFuUserId());
		System.out.println("userId :"+userId);
		if(loginUser.getFuUserId().equals(userId)){
			limit = 3;
		}else{
			limit = 2;
		}
		System.out.println("--limit:"+limit);
		albums = faBiz.findByUser(userId,limit);
		return "success";
	}
	/**
	 * 新建相册
	 * @return
	 * @throws Exception
	 */
	public String doCreateAlbum()throws Exception{
		FacelookUser loginUser = (FacelookUser) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		album.setFacelookUser(loginUser);
		album.setFacelookPhotos(null);
		id = faBiz.saveAlbum(album);
		return "create_ok";
	}
	/**
	 * 获得用户下的所有相册列表，跳转到上传照片页面
	 * @return
	 * @throws Exception
	 */
	public String toUploadPhoto()throws Exception{
		albums = faBiz.findByUser(userId,3);
		return "toUpload";
	}
	/**
	 * 根据id获得一个相册所有信息
	 * @return
	 * @throws Exception
	 */
	public String getById()throws Exception{
		album = faBiz.findById(id);
		return "toList";
	}
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public FacelookAlbum getAlbum() {
		return album;
	}
	public void setAlbum(FacelookAlbum album) {
		this.album = album;
	}
	public List<FacelookAlbum> getAlbums() {
		return albums;
	}
	public void setAlbums(List<FacelookAlbum> albums) {
		this.albums = albums;
	}
	public void setFaBiz(IFacelookAlbumBiz faBiz) {
		this.faBiz = faBiz;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}
