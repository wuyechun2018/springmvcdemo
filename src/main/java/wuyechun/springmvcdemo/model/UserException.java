
package wuyechun.springmvcdemo.model;

/*******************************************************************************
 *  功能说明: 用户异常
  
 *  2013-3-26 下午3:38:15 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2013-3-26 下午3:38:15 ycwu 修改文件
 * 
 ******************************************************************************/

public class UserException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}

