package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v2.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

//    @Override
//    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Member> members = memberRepository.findAll();
//
//        request.setAttribute("members", members);
//
//        // v2 에서는 MyView 에서 처리
////        String viewPath = "/WEB-INF/views/members.jsp";
////        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
////        dispatcher.forward(request, response);
//        return new MyView("/WEB-INF/views/members.jsp");
//    }

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();
        // v3
//        ModelView mv = new ModelView("members");
//
//        mv.getModel().put("members", members);
//        return mv;

        // v4
        model.put("members", members);
        return "members";
    }
}
