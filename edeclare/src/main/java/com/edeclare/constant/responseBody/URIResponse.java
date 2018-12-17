package com.edeclare.constant.responseBody;
/**
* Type: URIResponse
* Description: 返回异步请求，需要前台跳转到对应uri
* @author LYM
* @date Dec 17, 2018
 */
public class URIResponse extends BaseResponse {

	String uri;
	
	public URIResponse(String message) {
		super(message);
	}
	public URIResponse(String message, String uri) {
		this(message);
		this.uri = uri;
	}
	public String getUri() {
		return uri;
	}
	public URIResponse setUri(String uri) {
		this.uri = uri;
		return this;
	}
	
}
