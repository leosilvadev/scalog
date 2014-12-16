package br.com.leonardojgs.scalog.taglib.components;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PaginableTable extends TagSupport {

	private static final long serialVersionUID = 9177797199966629593L;

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		
		return super.doStartTag();
	}
	
}
