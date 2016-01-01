package cn.my.facelook.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 可理解为HttpServletRequest的子类、实现类
 * @author LCH
 *
 */
public class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {
	private String encoding = "UTF-8";

	public void setEncoding(String encoding) {
		this.encoding = encoding;	}

	public MyHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if (value != null) {
			try {
				value = new String(value.getBytes("ISO-8859-1"), encoding);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] value = super.getParameterValues(name);
		if (value != null) {
			for (int i = 0; i < value.length; i++) {
				try {
					value[i] = new String(value[i].getBytes("ISO-8859-1"),
							encoding);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

}
