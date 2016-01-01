package cn.my.facelook.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * Servlet Filter implementation class CharacterFilter
 */
public class CharacterFilter implements Filter {
	private String encoding = "UTF-8";
    /**
     * Default constructor. 
     */
    public CharacterFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String method = httpRequest.getMethod();// ������󷽷�
		if ("post".equalsIgnoreCase(method)) {// post�����������ַ�����
			httpRequest.setCharacterEncoding(encoding);
		} else {// get����
			MyHttpServletRequestWrapper myHttpRequest = new MyHttpServletRequestWrapper(
					httpRequest);// ��װ��ģʽ(��̬)
			myHttpRequest.setEncoding(encoding);
			//httpRequest�����ࡢ�ӿ�����
			//myHttpRequest�����ࡢʵ�������
			httpRequest = myHttpRequest;
		}
		response.setContentType("text/html;charset=" + encoding);
		chain.doFilter(httpRequest, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String str = fConfig.getInitParameter("encoding");
		if(str!=null){
			encoding = str;
		}
	}

}
