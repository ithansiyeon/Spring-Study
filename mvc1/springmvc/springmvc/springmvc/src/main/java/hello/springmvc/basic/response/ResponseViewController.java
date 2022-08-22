package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello").addObject("data","hello");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
       model.addAttribute("data","hello");
        ModelAndView mav = new ModelAndView("response/hello").addObject("data","hello");
        // @Controller 이면 밑에가 뷰의 논리적인 이름이 돼
        // @ResponseBody 쓰면 view로 안가고 문자로 보임
        return "response/hello";
    }

    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data","hello");
        //Controller의 이름과 뷰의 논리적인 이름이 같으면 그냥 반환 안해도 돼
    }
}
