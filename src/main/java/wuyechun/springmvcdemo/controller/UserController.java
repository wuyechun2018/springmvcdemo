
package wuyechun.springmvcdemo.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import wuyechun.springmvcdemo.model.User;
import wuyechun.springmvcdemo.model.UserException;

/*******************************************************************************
 *  功能说明: 用户控制类
  
 *  2013-3-26 下午3:26:50 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2013-3-26 下午3:26:50 ycwu 修改文件
 * 
 ******************************************************************************/
@Controller
@RequestMapping("/user")
public class UserController {
	
	//构造数据,存入HashMap中
	private Map<String, User> users = new HashMap<String, User>();
	public UserController() {
		users.put("admin", new User("admin", "123", "管理员", "admin@163.com"));
		users.put("zxm", new User("zxm", "123", "张小明", "zxm@qq.com"));
		users.put("lsg", new User("lsg", "123", "李四光", "lsg@gmail.com"));
		users.put("ssq", new User("ssq", "123", "孙三强", "ssq@sina.cn"));
		users.put("zy", new User("zy", "123", "赵一", "zy@sohu.com"));
		users.put("dw", new User("dw", "123", "王五", "wangwu@126.com"));
	}
	//登录
	//传递参数的第一种方式
	@RequestMapping(value="/login",method=RequestMethod.POST)
	private String login(String username,String password,HttpSession session){
		
		if(!users.containsKey(username)){
			throw new UserException("用户名不存在！");
		}
		
		User user=users.get(username);
		if(!user.getPassword().equals(password)){
			throw new UserException("用户密码不正确！");
		}
		//将用户信息存入session中
		session.setAttribute("user", user);
		
		return "welcome";
	}
	
	//用户列表
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model){
		
		model.addAttribute("users", users);
		return "user/list";
	}
	
	//跳转到"新增用户页面"
	@RequestMapping(value="add",method=RequestMethod.GET)
	private String add(@ModelAttribute("user") User user){
		return "user/add";
	}
	
	//新增用户
	@RequestMapping(value="add",method=RequestMethod.POST)
	private String add(@Valid User user, BindingResult br){
		if(br.hasErrors()){
			return "user/add";
		}
		users.put(user.getUsername(),user);
		return "redirect:/user/list";
	}
	
	//删除用户
	@RequestMapping(value="{username}/delete",method=RequestMethod.GET)
	private String delete(@PathVariable String username){
		users.remove(username);
		return "redirect:/user/list";
	}
	
	
	//获取用户信息,跳转到修改页面.
	@RequestMapping(value="{username}/update",method=RequestMethod.GET)
	private String update(@PathVariable String username,Model model){
		
		model.addAttribute(users.get(username));
		return "user/update";
	}
	
	//更新用户信息
	@RequestMapping(value="{username}/update",method=RequestMethod.POST)
	private String update(@PathVariable String username,@Valid User user,BindingResult br){
		if(br.hasErrors()){
			// 如果有错误直接跳转到update视图
			return "user/update";
		}
		users.put(username, user);
		return "redirect:/user/list";
	}
	
	
	//跳转到上传页面
	@RequestMapping(value="/upload")
	private String upload(){
		return "/user/upload";
	}
	
	//处理文件上传
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	private String upload(@RequestParam("attachs") MultipartFile attachs,HttpServletRequest req) throws IOException{
		
		String realpath = req.getSession().getServletContext().getRealPath("/resources/upload");
		File f = new File(realpath + "/" + attachs.getOriginalFilename());
		FileUtils.copyInputStreamToFile(attachs.getInputStream(), f);
		return "/user/upload";
 
	//如果是多个文件上传,参数可以采用数组的方式：@RequestParam("attachs") MultipartFile attachs
    //遍历循环,存入指定文件夹。
	//		for (MultipartFile attach : attachs) {
	//			if (attach.isEmpty())
	//				continue;
	//			File f = new File(realpath + "/" + attach.getOriginalFilename());
	//			FileUtils.copyInputStreamToFile(attach.getInputStream(), f);
	//		}
	}
	
	@RequestMapping(value="/ajax",method=RequestMethod.GET)
	public String ajax(){
		return "/user/ajax";
	}
	
	@RequestMapping(value="/ajax",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String ajax(String username){
		return "hello,"+username;
	}
	
	
	/**
	 * 注意的地方：
	 * 1.要指定 @controller标签,使之成为一个controller.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	

}


