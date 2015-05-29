package wuyechun.springmvcdemo.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/*******************************************************************************
 * 功能说明: 用户实体类
 * 
 * 2013-3-26 下午3:23:56 ycwu 创建文件
 * 
 * 修改说明: 创建文件
 * 
 * 2013-3-26 下午3:23:56 ycwu 修改文件
 * 
 ******************************************************************************/

public class User {

	private Long userid;
	private String username;
	private String nickname;
	private String password;
	private String email;

	
	public User() {
		super();
	}

	public User(String username, String password, String nickname, String email) {
		super();
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	@NotEmpty(message="用户名不能为空")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Size(min=1,max=10,message="密码的长度应该在1和10之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Email(message="邮箱的格式不正确")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
