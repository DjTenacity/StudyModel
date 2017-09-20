package com.kaixuan.djstudy.handler;

public class Handler2 extends Handler {

	@Override
	public void handle(AbstractRequest abstractRequest) {
		System.out.println("----handle2  处理请求: "+abstractRequest.getRequestLevel());
	}

	@Override
	public int getHandleLevel() {
		return 2;
	}

}
