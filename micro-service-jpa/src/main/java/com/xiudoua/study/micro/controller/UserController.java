package com.xiudoua.study.micro.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xiudoua.study.micro.bean.UserBean;
import com.xiudoua.study.micro.exception.FormException;
import com.xiudoua.study.micro.service.IUserService;
import com.xiudoua.study.micro.utils.Json;
import com.xiudoua.study.micro.utils.MD5Util;

@Controller
@RequestMapping("/user")
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);
    
    @Autowired
    private IUserService userService;
	
    /**
     * 跳转到列表页面
     * listGet:TODO Description <br/>
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String listGet(UserBean param,HttpServletRequest request,Model model){
        try {
            List<UserBean> adsList = this.userService.getList(param);
            model.addAttribute("userList", adsList);
        } catch (FormException e) {
            model.addAttribute("errorMsg", e.getMessage());
            logger.error(e.getMessage());
        }
        return "user/list";
    }
    
    /**
     * 跳转到添加页面
     * listGet:TODO Description <br/>
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addGet(Model model){
        return "user/add";
    }
    
    /**
     * 添加用户
     * listGet:TODO Description <br/>
     */
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Json addPost(UserBean param,Model model,HttpServletRequest request){
        
        Json json = new Json();
        try {
            int count = this.userService.add(param);
            if(count > 0){
                json.setMsg("添加成功");
                json.setSuccess(true);
            }else{
                json.setMsg("添加失败");
                json.setSuccess(false);
            }
        } catch (FormException e) {
            logger.error(e.getMessage());
            json.setErrorCode(e.getErrorCode());
            json.setMsg(e.getMessage());
        }
        return json;
        
    }
    
    /**
     * 删除用户
     * listGet:TODO Description <br/>
     */
    @ResponseBody
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public Json removePost(UserBean param,Model model,HttpServletRequest request){
        
        Json json = new Json();
        try {
            int count = this.userService.remove(param);
            if(count > 0){
                json.setMsg("删除成功");
                json.setSuccess(true);
            }else{
                json.setMsg("删除失败");
                json.setSuccess(false);
            }
        } catch (FormException e) {
            logger.error(e.getMessage());
            json.setErrorCode(e.getErrorCode());
            json.setMsg(e.getMessage());
        }
        return json;
        
    }
    
    /**
     * 跳转到修改页面
     * listGet:TODO Description <br/>
     */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String updateGet(UserBean param,Model model){
        try {
            UserBean res = this.userService.getOne(param);
            if(res != null && !"".equals(res.getPassword())){
                res.setPassword(MD5Util.convertMD5(MD5Util.convertMD5(res.getPassword())));
            }
            model.addAttribute("userInfo", res);
        } catch (FormException e) {
            logger.error(e.getMessage());
        }
        return "user/update";
    }
    
    /**
     * 添加用户
     * listGet:TODO Description <br/>
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Json updatePost(UserBean param,Model model,HttpServletRequest request){
        
        Json json = new Json();
        try {
            UserBean res = this.userService.update(param);
            if(res != null){
                json.setMsg("修改成功");
                json.setSuccess(true);
            }else{
                json.setMsg("修改失败");
                json.setSuccess(false);
            }
        } catch (FormException e) {
            logger.error(e.getMessage());
            json.setErrorCode(e.getErrorCode());
            json.setMsg(e.getMessage());
        }
        return json;
        
    }
    
    /**
     * 显示详细
     */
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public String detailGet(UserBean param,Model model){
        try {
            UserBean res = this.userService.getOne(param);
            model.addAttribute("userInfo", res);
        } catch (FormException e) {
            logger.error(e.getMessage());
        }
        return "user/detail";
    }
    
}