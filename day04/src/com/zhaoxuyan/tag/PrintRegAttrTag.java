package com.zhaoxuyan.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class PrintRegAttrTag extends TagSupport {
    private String attr;

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    @Override
    public int doStartTag() throws JspException {
        // 拿到请求对象
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        // 从请求拿到attr属性值
        String val = (String) request.getAttribute(attr);
        // val不为空，则显示在页面
        if (val != null && !val.equals("")) {
            JspWriter out = pageContext.getOut();
            try {
                out.println("<font color = red>" + val + "</font>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.doStartTag();
    }

}
