package com.noticehub.mapper;

import com.noticehub.dto.AuthorityDto;
import com.noticehub.entity.Authority;

public class AuthorityMapper {

    public static Authority mapToAuthority(AuthorityDto authorityDto) {
        return new Authority(
                authorityDto.id(),
                authorityDto.name()
        );
    }

    public static AuthorityDto mapToAuthorityDto(Authority authority) {
        return new AuthorityDto(
                authority.getId(),
                authority.getName()
        );
    }
}
