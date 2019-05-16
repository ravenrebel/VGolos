package com.vgolos.VGolos.security.configuration;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vgolos.VGolos.entity.Account;
import com.vgolos.VGolos.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.*;

import static com.vgolos.VGolos.entity.Role.USER;


public class UserDetailsImpl implements UserDetails {
    private Long id;

    @JsonIgnore
    private String login;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String login, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl create(Account user, Role role) {
        List<GrantedAuthority> authorities =new ArrayList<>();
        switch(role) {
            case ADMIN:
                authorities.add(new SimpleGrantedAuthority(
                        RoleConstant.ROLE_ADMIN)
                );
            case USER:
                authorities.add(new SimpleGrantedAuthority(
                        RoleConstant.ROLE_USER)
                );
        }
        if (user.isCitizen()) authorities.add(new SimpleGrantedAuthority(
                RoleConstant.ROLE_CITIZEN
        ));

        return new UserDetailsImpl(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                authorities
        );
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailsImpl that = (UserDetailsImpl) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}