package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    // 프레임워크에 종속적임
    ModelView process(Map<String,String> paramMap);
}
