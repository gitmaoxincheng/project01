package cn.com.agree.huanan.ap.tl.communicate.comm.msg;

import cn.com.agree.huanan.ap.tl.communicate.comm.base.Const;

public class SendMessage extends Message{
	
	
	public SendMessage(String msg){
		super(Const.MESSAGE_SEND_TYPE, msg);
	}
	
	public SendMessage(byte [] msg){
		super(Const.MESSAGE_SEND_TYPE, msg);
	}
	
	public SendMessage(String msg, String encoding){
		super(Const.MESSAGE_SEND_TYPE, encoding, msg);
	}
	
	public SendMessage(byte [] msg, String encoding){
		super(Const.MESSAGE_SEND_TYPE, encoding, msg);
	}
}
