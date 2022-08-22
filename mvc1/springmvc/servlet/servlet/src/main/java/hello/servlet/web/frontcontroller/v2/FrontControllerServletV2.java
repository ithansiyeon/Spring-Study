package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.Controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.Controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.Controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV2",urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    //alt + insert
    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form",new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save",new MemberSaveControllerV2());
        //부모가 controllerV1이라서 받을 수 있음
        controllerMap.put("/front-controller/v2/members",new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // /front-controller/v1/members
        String requestURI = request.getRequestURI();
        //부모는 자식을 받을 수 있음
        ControllerV2 controller = controllerMap.get(requestURI);
        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //인스턴스의 주소값이 넘어와
        MyView view = controller.process(request,response);
        view.render(request,response);
    }
}
