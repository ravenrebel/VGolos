package com.vgolos.VGolos.dto.converter;

import com.vgolos.VGolos.dto.authentication.SignInFormDTO;
import com.vgolos.VGolos.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class SignInFormConverter implements Converter<Account, SignInFormDTO> {


    @Override
    public SignInFormDTO convertToDTO(Account account) {
        SignInFormDTO signInFormDTO = new SignInFormDTO();
        signInFormDTO.setLogin(account.getLogin());
        signInFormDTO.setPassword(account.getPassword());
        return signInFormDTO;
    }

    @Override
    public Account convertToEntity(SignInFormDTO signInFormDTO) {
        Account account = new Account();
        account.setLogin(signInFormDTO.getLogin());
        account.setPassword(signInFormDTO.getPassword());
        return account;
    }

}
