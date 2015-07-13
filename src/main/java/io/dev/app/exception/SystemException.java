package io.dev.app.exception;

/**
 * desc:
 * 
 * @author lsr
 * @version 2014年5月28日
 */
public class SystemException extends RuntimeException {
	private static final long serialVersionUID = -4619095797339107592L;
	private int resultCode;
	private String resultMessage;
	
	public SystemException(int resultCode, String resultMessage) {
		super();
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

}
