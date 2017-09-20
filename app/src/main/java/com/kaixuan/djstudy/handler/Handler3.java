package com.kaixuan.djstudy.handler;

public class Handler3   extends Handler {

	@Override
	public void handle(AbstractRequest abstractRequest) {
		System.out.println("----handle3  处理请求: "+abstractRequest.getRequestLevel());
	}

	@Override
	public int getHandleLevel() {
		return 3;
	}
}