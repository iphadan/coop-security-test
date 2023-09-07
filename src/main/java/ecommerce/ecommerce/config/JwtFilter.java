package ecommerce.ecommerce.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {
    private final JWTUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    public JwtFilter(JWTUtil jwtUtil,CustomerUserDetailService customerUserDetailService){
        this.jwtUtil=jwtUtil;
        this.userDetailsService=customerUserDetailService;
    }
    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull  HttpServletResponse response,@NotNull FilterChain filterChain) throws ServletException, IOException {

        String autHeader=request.getHeader("Authorization");
        if(autHeader == null ||  !autHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
        String jwtToken=autHeader.substring(7);
        String userEmail=jwtUtil.extractUserEmail(jwtToken);




    }
}
