package com.noticehub.controller;

import com.noticehub.dto.AuthorityDto;
import com.noticehub.service.AuthorityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/authority")
public class AuthorityController {

    public final AuthorityService authorityService;

    public AuthorityController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    //REST API to add authority
    @PostMapping
    public ResponseEntity<AuthorityDto> addAuthority(@RequestBody AuthorityDto authorityDto) {

        return new ResponseEntity<>(authorityService.addAuthority(authorityDto), HttpStatus.CREATED);
    }

    //REST API to update authority
    @PutMapping("/{id}")
    public ResponseEntity<AuthorityDto> updateAuthority(@PathVariable Long id ,
                                                        @RequestBody AuthorityDto updateAuthority) {
        AuthorityDto authorityDto = authorityService.updateAuthority(id, updateAuthority);
        return ResponseEntity.ok(authorityDto);
    }

    // REST API to get authority
    @GetMapping("/{id}")
    public ResponseEntity<AuthorityDto> getAuthorityById(@PathVariable Long id) {
        AuthorityDto authorityDto = authorityService
                .getAuthorityById(id);
        return ResponseEntity.ok(authorityDto);
    }

    //REST API to delete authority
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthority(@PathVariable Long id) {
        authorityService.deleteAuthority(id);
        return ResponseEntity.ok("Authority deleted successfully.");
    }
}
