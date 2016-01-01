package cn.my.facelook.action;

import cn.my.facelook.biz.IFacelookPhotoBiz;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ���ϴ���Ŀ��ӵ�action
 * Ϊ�˷���ɾ�����ݿ���е�����
 * @author ����
 *
 */
public class DeveloperAction extends ActionSupport {

	private Long id;
	private Integer[] ids;
	private IFacelookPhotoBiz fpBiz;
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deletePhotos()throws Exception{
		fpBiz.deleteById(ids);
		return "index";
	}
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public IFacelookPhotoBiz getFpBiz() {
		return fpBiz;
	}
	public void setFpBiz(IFacelookPhotoBiz fpBiz) {
		this.fpBiz = fpBiz;
	}
}
