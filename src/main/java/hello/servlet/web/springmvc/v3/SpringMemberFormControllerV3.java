package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberFormControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping(value = "/new-form" )
    public String newForm() {
//        return new ModelAndView("new-form");
        return "new-form";  // 알아서 뷰 이름으로 알고 진행
    }

    @PostMapping(value = "/save")
    public String save(@RequestParam ("username") String username,
                       @RequestParam ("age") int age,
                       Model model
                       // request, response 를 받는 대신에 @ReqeustParam 어노테이션을 통해 받을 수 있음
//                             HttpServletRequest request, HttpServletResponse response
    ) {
//        String username = request.getParameter("username");
//        int age = Integer.parseInt(request.getParameter("age"));
        // @RequestParam으로 훨씬 간편해짐!
        Member member = new Member(username, age);
        memberRepository.save(member);

        // ModelAndView를 생성하는 대신 파라미터로 받은 model에 넣어서 뷰 이름만 반환해주면 됨
//        ModelAndView mv = new ModelAndView("save-result");
//        mv.addObject("member",  member);
//        return mv;
        model.addAttribute("member", member);
        return "save-result"
                ;
    }

    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
//        ModelAndView mv = new ModelAndView ("members");
//        mv.addObject("members", members);
//        return mv;

        model.addAttribute("members", members);
        return "members";
    }
}
