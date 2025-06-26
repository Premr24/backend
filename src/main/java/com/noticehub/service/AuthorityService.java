package com.noticehub.service;

import com.noticehub.dto.AuthorityDto;
import com.noticehub.entity.Authority;

public interface AuthorityService {

    AuthorityDto addAuthority(AuthorityDto authorityDto);

    AuthorityDto updateAuthority(Long id, AuthorityDto updateAuthority);

    AuthorityDto getAuthorityById(Long id);

    void deleteAuthority(Long id);
}
