package com.noticehub.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtResponse {

    //DTO for returning token info

    private String token;
    private String email;
    private String role;
}
