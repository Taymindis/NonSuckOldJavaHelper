package com.github.taymindis.jh;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

//
// JspResponseWrapper responseWrapper = new JspResponseWrapper(response);
//   request.getRequestDispatcher("/apps/a/b/c.jsp?custid=" + custId + "&custemail=" + custemail)
//   		.include(new HttpServletRequestWrapper(request) {
//   			@Override
//   			public String getMethod() {
//   				return "POST";
//   			}
//   		}, responseWrapper);
//
//
public class DispatcherResponse extends HttpServletResponseWrapper {

    private int httpStatus;
    private final StringWriter sw = new StringWriter();

    public DispatcherResponse(HttpServletResponse response) {
        super(response);
        httpStatus = -1;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(sw);
    }

    @Override
    public String toString() {
        return sw.toString();
    }


    @Override
    public void sendError(int sc) throws IOException {
        httpStatus = sc;
    }

    @Override
    public void sendError(int sc, String msg) throws IOException {
        httpStatus = sc;
    }


    @Override
    public void setStatus(int sc) {
        httpStatus = sc;
    }

    public int getStatus() {
        return httpStatus;
    }

}