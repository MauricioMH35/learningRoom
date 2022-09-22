package org.learning.notes.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FilterCustom implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        System.out.println("passou no custom filter");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (httpRequest.getMethod().equals("GET")) {
            System.out.println("o método HTTP utilizado foi o GET");
            chain.doFilter(request, response); // passa para o recurso
        } else {
            System.out.println("não é possível utilizar um método HTTP que não seja o GET");
            HttpServletResponse httpResponse = (HttpServletResponse) response; // transforma em HttpServletResponse
            httpResponse.setStatus(401); // passa código HTTP na resposta
        }
    }

}
