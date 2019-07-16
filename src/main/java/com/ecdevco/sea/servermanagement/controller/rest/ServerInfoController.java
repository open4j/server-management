package com.ecdevco.sea.servermanagement.controller.rest;

import com.ecdevco.sea.servermanagement.domain.dto.MemInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/server")
public class ServerInfoController {

    @GetMapping("/v1/meminfo")
    public ResponseEntity<?> getMemInfo(){
        return ResponseEntity.ok(new MemInfo(1));
    }
}
