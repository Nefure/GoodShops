package org.nefure.goodshops.dto;

import lombok.Data;

/**
 * @author nefure
 * @since 2022/11/24 12:59
 */
@Data
public class LoginFormDTO {
    private String email;
    private String code;
    private String password;
}
