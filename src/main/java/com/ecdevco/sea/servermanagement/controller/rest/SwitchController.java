package com.ecdevco.sea.servermanagement.controller.rest;

import com.ecdevco.sea.servermanagement.service.SwitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/switch")
public class SwitchController {

    @Autowired
    private SwitchService switchService;

    @GetMapping("/v1/socketinfo")
    public ResponseEntity<?> getSocketInfo(@RequestParam(value = "address") String address) {
        return ResponseEntity.ok(switchService.getSocketInfo(address));
    }

    @PostMapping("/v1/service/{command}")
    public ResponseEntity<?> serviceCommand(@PathVariable("command") String command) {
        boolean result;
        switch (command) {
            case "start":
                result = switchService.startSwitch();
                break;
            case "stop":
                result = switchService.stopSwitch();
                break;
            case "restart":
                result = switchService.restartSwitch();
                break;
            default:
                return ResponseEntity.ok(switchService.switchStatus());
        }

        if (result) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/v1/service/status")
    public ResponseEntity<?> serviceStatus() {
        return ResponseEntity.ok(switchService.switchStatus());
    }

    @GetMapping("/v1/resources")
    public ResponseEntity<?> getResources(){
        return ResponseEntity.ok(switchService.getSwitchResourceInfo());
    }
}
