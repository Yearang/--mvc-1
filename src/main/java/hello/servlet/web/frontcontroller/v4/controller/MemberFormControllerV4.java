package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.web.frontcontroller.v2.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {

        // v1 : MyView 에서 처리하도록 수정됨
//        String viewPath = "/WEB-INF/views/new-form.jsp";
//        // 컨트롤러에서 뷰로 이동할 때 사용
//        RequestDispatcher dispather = request.getRequestDispatcher(viewPath);
//        dispather.forward(request, response);

        // v2
//        return new MyView("/WEB-INF/views/new-form.jsp");

        // v3
//        return new ModelView("new-form");

        // v4 -> 그냥 뷰 이름만 리턴해주면 됨
        return "new-form";
    }
}
