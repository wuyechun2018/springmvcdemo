
package wuyechun.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*******************************************************************************
 *  功能说明: 跳转到首页
  
 *  2013-3-26 下午3:46:04 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2013-3-26 下午3:46:04 ycwu 修改文件
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
 * 可以使用 {}使该方来处理多个请求
 * 
 */

