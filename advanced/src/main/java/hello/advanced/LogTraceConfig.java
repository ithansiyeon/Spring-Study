package hello.advanced;

import hello.advanced.trace.logtrace.FieldLogTrace;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//스프링 빈으로 자동으로 등록됨
//@Component가 있음

@Configuration
public class LogTraceConfig {
    @Bean
    public LogTrace logTrace() {
        //인스턴스가 하나 싱글톤으로 생성됨
        return new FieldLogTrace();
    }
}
