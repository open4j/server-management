package com.ecdevco.sea.servermanagement.service;

import com.ecdevco.sea.servermanagement.domain.dto.ServiceInfo;
import com.ecdevco.sea.servermanagement.domain.dto.SocketInfo;
import com.ecdevco.sea.servermanagement.socket.SatrapClient;
import com.ecdevco.sea.servermanagement.socket.dto.Trigger;
import com.ecdevco.sea.servermanagement.socket.dto.TriggerResponse;
import com.ecdevco.sea.servermanagement.util.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwitchService {

    @Autowired
    private CommandExecutor commandExecutor;
    @Autowired
    private SatrapClient satrapClient;

    public SocketInfo getSocketInfo(String address) {
        SocketInfo socketInfo = new SocketInfo();
        socketInfo.setAddress(address);

        int established = 0;
        int listen = 0;
        int timeWait = 0;
        int closeWait = 0;

        commandExecutor.execute("netstat -ant");

        String[] socketState = commandExecutor.getStdInput().split("\\r?\\n");
        for (String str : socketState) {
            if (str.contains(address)) {
                if (str.contains("ESTABLISHED")) {
                    established++;
                } else if (str.contains("LISTEN")) {
                    listen++;
                } else if (str.contains("TIME_WAIT")) {
                    timeWait++;
                } else if (str.contains("CLOSE_WAIT")) {
                    closeWait++;
                }
            }
        }
        socketInfo.setEstablished(established);
        socketInfo.setListen(listen);
        socketInfo.setCloseWait(closeWait);
        socketInfo.setTimeWait(timeWait);

        return socketInfo;
    }

    public boolean startSwitch() {
        commandExecutor.execute("sudo systemctl start satrap");
        return commandExecutor.getExitCode() == 0;
    }

    public boolean stopSwitch() {
        commandExecutor.execute("sudo systemctl stop satrap");
        return commandExecutor.getExitCode() == 0;
    }

    public boolean restartSwitch() {
        commandExecutor.execute("sudo systemctl restart satrap");
        return commandExecutor.getExitCode() == 0;
    }

    public ServiceInfo switchStatus() {
        ServiceInfo serviceInfo = new ServiceInfo();
        serviceInfo.setName("satrap");

        commandExecutor.execute("systemctl status satrap");

        if (commandExecutor.getStdInput().contains("inactive")) {
            serviceInfo.setStatus("inactive");
        } else if (commandExecutor.getStdInput().contains("active")) {
            serviceInfo.setStatus("active");
        } else {
            serviceInfo.setStatus("none");
        }

        return serviceInfo;
    }

    public TriggerResponse getSwitchResourceInfo(){
        TriggerResponse triggerResponse = null;
        Trigger trigger = new Trigger();
        trigger.setType("system");
        trigger.setCommand("resource_log");

        if(satrapClient.connectToSatrap("127.0.0.1", 9000) && satrapClient.sendRequest(trigger)){
            triggerResponse = satrapClient.getResponse();
        }

        return triggerResponse;
    }
}
