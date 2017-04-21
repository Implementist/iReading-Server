/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Implementist.iReading;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

/**
 *
 * @author Implementist
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 设置响应内容类型  
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        try (PrintWriter out = response.getWriter()) {

            //获得请求中传来的手机号码
            String phoneNumber = request.getParameter("PhoneNumber").trim();

            Map<String, String> params = new HashMap<>();
            JSONObject jsonObject = new JSONObject();

            //按注册方式调用不同的验证函数
            switch (request.getParameter("RegisterType")) {
                case "RegisterByPhoneNumber":
                    //根据手机号注册的每一个注册步骤分别执行相应的函数
                    switch (request.getParameter("RegisterStep")) {
                        case "1":
                            Boolean isNew = isNewPhoneNumber(phoneNumber);
                            if (isNew) {
                                //TODO:Generate Security Number and Store It to Session
                            }
                            params.put("IsNew", isNew.toString());
                            break;

                        case "2":
                            //TODO: to Verify security code.
                            break;

                        case "3":
                            String password = request.getParameter("Password");
                            Boolean registerResult = register(phoneNumber, password);
                            params.put("RegisterResult", registerResult.toString());
                            break;
                    }
                    break;
            }

            jsonObject.put("params", params);
            out.write(jsonObject.toString());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 到数据库中查询手机号是已绑定
     *
     * @param phoneNumber
     */
    private Boolean isNewPhoneNumber(String phoneNumber) {
        User user = UserDAO.queryUserByPhoneNumber(phoneNumber);
        return null == user;
    }

    /**
     * 生成用户安全戳和密码混淆值并将用户实例插入数据库
     *
     * @param phoneNumber 手机号码
     * @param password 密码
     * @return 插入是否成功
     */
    private Boolean register(String phoneNumber, String password) {
        String securityStamp = Encrypt.getNewSecurityStamp();
        String passwordHash = Encrypt.getCiphertext(password, securityStamp);

        User user = new User();

        //填充用户实例
        user.setPhoneNumber(phoneNumber);
        user.setPasswordHash(passwordHash);
        user.setSecurityStamp(securityStamp);

        return UserDAO.insertUserByPhoneNumber(user);
    }
}
