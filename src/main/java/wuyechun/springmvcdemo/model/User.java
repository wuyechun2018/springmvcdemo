package wuyechun.springmvcdemo.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/*******************************************************************************
 * ����˵��: �û�ʵ����
 * 
 * 2013-3-26 ����3:23:56 ycwu �����ļ�
 * 
 * �޸�˵��: �����ļ�
 * 
 * 2013-3-26 ����3:23:56 ycwu �޸��ļ�
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
	
	@NotEmpty(message="�û�������Ϊ��")
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
	@Size(min=1,max=10,message="����ĳ���Ӧ����1��10֮��")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Email(message="����ĸ�ʽ����ȷ")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
