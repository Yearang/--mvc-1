package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v2.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        // v1 & v2
//        System.out.println("MemberSaveServlet.service");
//        String username = request.getParameter("username");
//        int age = Integer.parseInt(request.getParameter("age"));
//
//        Member member = new Member(username, age);
//        memberRepository.save(member);
//
//        //Model에 데이터 보관
//        request.setAttribute("member", member);

        // v1 myview에서 처리
//        String viewPath = "/WEB-INF/views/save-result.jsp";
//        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//        dispatcher.forward(request, response);

        // v2
//        return new MyView("/WEB-INF/views/save-result.jsp");

        // v3
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);
        return mv;
    }
}
