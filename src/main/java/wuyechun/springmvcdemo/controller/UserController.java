
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
 *  ����˵��: �û�������
  
 *  2013-3-26 ����3:26:50 ycwu �����ļ�
 * 
 *  �޸�˵��: �����ļ�

 *  2013-3-26 ����3:26:50 ycwu �޸��ļ�
 * 
 ******************************************************************************/
@Controller
@RequestMapping("/user")
public class UserController {
	
	//��������,����HashMap��
	private Map<String, User> users = new HashMap<String, User>();
	public UserController() {
		users.put("admin", new User("admin", "123", "����Ա", "admin@163.com"));
		users.put("zxm", new User("zxm", "123", "��С��", "zxm@qq.com"));
		users.put("lsg", new User("lsg", "123", "���Ĺ�", "lsg@gmail.com"));
		users.put("ssq", new User("ssq", "123", "����ǿ", "ssq@sina.cn"));
		users.put("zy", new User("zy", "123", "��һ", "zy@sohu.com"));
		users.put("dw", new User("dw", "123", "����", "wangwu@126.com"));
	}
	//��¼
	//���ݲ����ĵ�һ�ַ�ʽ
	@RequestMapping(value="/login",method=RequestMethod.POST)
	private String login(String username,String password,HttpSession session){
		
		if(!users.containsKey(username)){
			throw new UserException("�û��������ڣ�");
		}
		
		User user=users.get(username);
		if(!user.getPassword().equals(password)){
			throw new UserException("�û����벻��ȷ��");
		}
		//���û���Ϣ����session��
		session.setAttribute("user", user);
		
		return "welcome";
	}
	
	//�û��б�
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model){
		
		model.addAttribute("users", users);
		return "user/list";
	}
	
	//��ת��"�����û�ҳ��"
	@RequestMapping(value="add",method=RequestMethod.GET)
	private String add(@ModelAttribute("user") User user){
		return "user/add";
	}
	
	//�����û�
	@RequestMapping(value="add",method=RequestMethod.POST)
	private String add(@Valid User user, BindingResult br){
		if(br.hasErrors()){
			return "user/add";
		}
		users.put(user.getUsername(),user);
		return "redirect:/user/list";
	}
	
	//ɾ���û�
	@RequestMapping(value="{username}/delete",method=RequestMethod.GET)
	private String delete(@PathVariable String username){
		users.remove(username);
		return "redirect:/user/list";
	}
	
	
	//��ȡ�û���Ϣ,��ת���޸�ҳ��.
	@RequestMapping(value="{username}/update",method=RequestMethod.GET)
	private String update(@PathVariable String username,Model model){
		
		model.addAttribute(users.get(username));
		return "user/update";
	}
	
	//�����û���Ϣ
	@RequestMapping(value="{username}/update",method=RequestMethod.POST)
	private String update(@PathVariable String username,@Valid User user,BindingResult br){
		if(br.hasErrors()){
			// ����д���ֱ����ת��update��ͼ
			return "user/update";
		}
		users.put(username, user);
		return "redirect:/user/list";
	}
	
	
	//��ת���ϴ�ҳ��
	@RequestMapping(value="/upload")
	private String upload(){
		return "/user/upload";
	}
	
	//�����ļ��ϴ�
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	private String upload(@RequestParam("attachs") MultipartFile attachs,HttpServletRequest req) throws IOException{
		
		String realpath = req.getSession().getServletContext().getRealPath("/resources/upload");
		File f = new File(realpath + "/" + attachs.getOriginalFilename());
		FileUtils.copyInputStreamToFile(attachs.getInputStream(), f);
		return "/user/upload";
 
	//����Ƕ���ļ��ϴ�,�������Բ�������ķ�ʽ��@RequestParam("attachs") MultipartFile attachs
    //����ѭ��,����ָ���ļ��С�
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
	 * ע��ĵط���
	 * 1.Ҫָ�� @controller��ǩ,ʹ֮��Ϊһ��controller.
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


