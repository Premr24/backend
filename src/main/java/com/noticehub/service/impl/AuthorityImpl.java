package com.noticehub.service.impl;

import com.noticehub.dto.AuthorityDto;
import com.noticehub.entity.Authority;
import com.noticehub.exception.ResourceNotFoundException;
import com.noticehub.mapper.AuthorityMapper;
import com.noticehub.repository.AuthorityRepository;
import com.noticehub.service.AuthorityService;
import org.springframework.stereotype.Service;

@Service
public class AuthorityImpl implements AuthorityService {

    public final AuthorityRepository authorityRepository;

    public AuthorityImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    //add Authority method
    @Override
    public AuthorityDto addAuthority(AuthorityDto authorityDto) {

        Authority authority = AuthorityMapper.mapToAuthority(authorityDto);
        Authority savedAuthority = authorityRepository.save(authority);
        return AuthorityMapper.mapToAuthorityDto(savedAuthority);
    }

    //update Authority method
    @Override
    public AuthorityDto updateAuthority(Long id, AuthorityDto updateAuthority) {

        Authority authority = authorityRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Authority does not exists!"));

        authority.setName(updateAuthority.name());
        Authority update = authorityRepository.save(authority);
        return new AuthorityDto(update.getId(), update.getName());
    }

    //Retrieve Authority method
    @Override
    public AuthorityDto getAuthorityById(Long id) {

        Authority authority = authorityRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Authority does not exists!"));
        return AuthorityMapper.mapToAuthorityDto(authority);
    }

    //Delete Authority method
    @Override
    public void deleteAuthority(Long id) {

        Authority authority = authorityRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Authority does not exists!"));
        authorityRepository.deleteById(id);
    }
}
