package hello.login.web.session;

import hello.login.domain.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SessionManagerTest {

    SessionManager sessionManager = new SessionManager();

    @Test
    void sessionTest() {

        //서버에서 클라이언트
        MockHttpServletResponse response = new MockHttpServletResponse();
        //세션 생성
        Member member = new Member();
        //서버에서는 쿠기와 세션이 다 만들어서 response에 담아 놓은 것
        sessionManager.createSession(member, response);

        //클라이언트에서 서버로
        //요청에 응답 쿠기 저장
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies()); //mySessionId=1231231-12312-1dfdfd

        //세션 조회
        Object result = sessionManager.getSession(request);
        assertThat(result).isEqualTo(member);

        //세션 만료
        sessionManager.expire(request);
        Object expired = sessionManager.getSession(request);
        assertThat(expired).isNull();

    }
}