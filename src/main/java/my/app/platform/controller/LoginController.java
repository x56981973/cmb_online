package my.app.platform.controller;

import my.app.platform.domain.view.User;
import my.app.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 夏之阳
 *         创建时间：2018-07-05 16:42
 *         创建说明：登陆接口
 */

@Controller
public class LoginController {
    @Autowired
    private HttpSession session;

    @Autowired
    private UserService loginService;

    @Value("${session.interval}")
    int sessionInterval;

    /**
     * 默认接口
     * @return 跳转到主页面
     */
    @RequestMapping(value = "/")
    public String home(){
        if("seller".equals(session.getAttribute("role").toString())){
            return "redirect:/seller/home";
        } else if("customer".equals(session.getAttribute("role").toString())){
            return "redirect:/customer/home";
        } else {
            return "redirect:/admin/home";
        }
    }

    /**
     * 登陆接口
     * @return 跳转到登陆页面
     */
    @RequestMapping(value = "/login")
    public String login(){
        if(session.getAttribute("name") != null){
            session.removeAttribute("name");
        } else if(session.getAttribute("username") != null){
            session.removeAttribute("username");
        } else if(session.getAttribute("role") != null){
            session.removeAttribute("role");
        }

        return "/login";
    }

    /**
     * 登出接口
     * @return 跳转到登录页面
     */
    @RequestMapping(value = "/logout")
    public String logout(){
        session.removeAttribute("role");
        session.removeAttribute("name");
        session.removeAttribute("username");
        return "redirect:/login";
    }

    /**
     * 登陆验证接口
     * @param request http请求
     * @param username 用户名
     * @param password 密码
     * @return 登陆结果
     */
    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    @ResponseBody
    public String loginHandler(HttpServletRequest request,String username,String password) {
        if(!username.matches("^([A-Za-z]|[0-9]|[!@#$*,.]){0,}$")){
            return "{\"error\":\"1\",\"msg\":\"用户名包含非法字符\",\"to\":\"/login\"}";
        }
        if(!password.matches("^([A-Za-z]|[0-9]|[!@#$*,.]){0,}$")){
            return "{\"error\":\"1\",\"msg\":\"密码包含非法字符\",\"to\":\"/login\"}";
        }
        User user = loginService.loginCheck(username, password);
        if(user != null) {
            if("2".equals(user.getStatus())){
                return "{\"error\":\"1\",\"msg\":\"账号异常，请联系管理员\",\"to\":\"/login\"}";
            }

            String role = user.getRole();
            String name = user.getName();
            setSession(username, name, role); //Set Session

            if("seller".equals(role)){
                return "{\"error\":\"0\",\"msg\":\"登陆成功\",\"to\":\"/seller/home\"}";
            } else if("customer".equals(role)){
                return "{\"error\":\"0\",\"msg\":\"登陆成功\",\"to\":\"/customer/home\"}";
            } else if ("admin".equals(role)){
//                loginService.insertLoginRecord(request, username); //管理员登陆记录
                return "{\"error\":\"0\",\"msg\":\"登陆成功\",\"to\":\"/admin/home\"}";
            } else {
                return "{\"error\":\"1\",\"msg\":\"未知权限，请联系管理员\",\"to\":\"/login\"}";
            }
        } else {
            return "{\"error\":\"1\",\"msg\":\"用户名或密码错误\",\"to\":\"/login\"}";
        }
    }

    /**
     * 设置session
     * @param username 用户名
     * @param name 名称
     * @param role 角色
     */
    protected void setSession(String username, String name, String role){
        session.setAttribute("role", role);
        session.setAttribute("name",name);
        session.setAttribute("username", username);

        session.setMaxInactiveInterval(sessionInterval);
    }
}
