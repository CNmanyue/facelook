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
		String method = httpRequest.getMethod();// 获得请求方法
		if ("post".equalsIgnoreCase(method)) {// post方法，设置字符编码
			httpRequest.setCharacterEncoding(encoding);
		} else {// get方法
			MyHttpServletRequestWrapper myHttpRequest = new MyHttpServletRequestWrapper(
					httpRequest);// 包装器模式(多态)
			myHttpRequest.setEncoding(encoding);
			//httpRequest：父类、接口引用
			//myHttpRequest：子类、实现类对象
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
