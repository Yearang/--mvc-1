package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v2.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {

        // v1 : MyView 에서 처리하도록 수정됨
//        String viewPath = "/WEB-INF/views/new-form.jsp";
//        // 컨트롤러에서 뷰로 이동할 때 사용
//        RequestDispatcher dispather = request.getRequestDispatcher(viewPath);
//        dispather.forward(request, response);

        // v2
//        return new MyView("/WEB-INF/views/new-form.jsp");

        // v3
        return new ModelView("new-form");
    }
}
