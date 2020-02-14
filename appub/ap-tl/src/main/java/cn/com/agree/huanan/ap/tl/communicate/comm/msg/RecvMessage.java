package cn.com.agree.huanan.ap.tl.communicate.comm.msg;

import cn.com.agree.huanan.ap.tl.communicate.comm.base.Const;

public class RecvMessage extends Message{
	
	
	public RecvMessage(String msg){
		super(Const.MESSAGE_RECV_TYPE, msg);
	}
	
	public RecvMessage(byte [] msg){
		super(Const.MESSAGE_RECV_TYPE, msg);
	}
	
	public RecvMessage(String msg, String encoding){
		super(Const.MESSAGE_RECV_TYPE, encoding, msg);
	}
	
	public RecvMessage(byte [] msg, String encoding){
		super(Const.MESSAGE_RECV_TYPE, encoding, msg);
	}
}
