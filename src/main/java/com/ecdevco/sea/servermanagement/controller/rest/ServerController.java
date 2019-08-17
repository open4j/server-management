package com.ecdevco.sea.servermanagement.controller.rest;

import com.ecdevco.sea.servermanagement.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/server")
public class ServerController {

    @Autowired
    private ServerService serverService;

    @GetMapping("/v1/meminfo")
    public ResponseEntity<?> getMemInfo() {
        return ResponseEntity.ok(serverService.getMemInfo());
    }

    @GetMapping("/v1/cpuinfo")
    public ResponseEntity<?> getCPUInfo() {
        return ResponseEntity.ok(serverService.getCPUInfo());
    }

    @GetMapping("/v1/storageinfo")
    public ResponseEntity<?> getStorageInfo() {
        return ResponseEntity.ok(serverService.getStorageInfo());
    }

    @GetMapping("/v1/osinfo")
    public ResponseEntity<?> getOSInfo(){
        return ResponseEntity.ok(serverService.getOSInfo());
    }
}
