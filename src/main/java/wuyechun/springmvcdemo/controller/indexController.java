
package wuyechun.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*******************************************************************************
 *  ����˵��: ��ת����ҳ
  
 *  2013-3-26 ����3:46:04 ycwu �����ļ�
 * 
 *  �޸�˵��: �����ļ�

 *  2013-3-26 ����3:46:04 ycwu �޸��ļ�
 * 
 ******************************************************************************/
@Controller
public class indexController {
	
	//@RequestMapping("/")
	@RequestMapping({"/index","/"})
	public String gotoIndex(){
		return "index";
	}

}

/***
 * ����ʹ�� {}ʹ�÷�������������
 * 
 */

