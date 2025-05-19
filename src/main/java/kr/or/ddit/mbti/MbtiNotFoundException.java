package kr.or.ddit.mbti;

/**
 * 특정한 예외 상황을 구체적으로 표현할 수 있는 커스텀 예외
 * 커스텀 예외 정의 방법
 * 1. 예외의 특성과 처리 정채겡 따라 상위 타입 결정
 * 	1) Throwable
 *  2) 
 */
public class MbtiNotFoundException extends RuntimeException {

	public MbtiNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MbtiNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MbtiNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MbtiNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public MbtiNotFoundException(String format) {
		// TODO Auto-generated constructor stub
	}
	
}
