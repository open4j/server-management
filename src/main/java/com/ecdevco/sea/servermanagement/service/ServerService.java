package com.ecdevco.sea.servermanagement.service;

import com.ecdevco.sea.servermanagement.domain.dto.CPUInfo;
import com.ecdevco.sea.servermanagement.domain.dto.MemInfo;
import com.ecdevco.sea.servermanagement.domain.dto.OSInfo;
import com.ecdevco.sea.servermanagement.domain.dto.StorageInfo;
import com.ecdevco.sea.servermanagement.util.CommandExecutor;
import com.ecdevco.sea.servermanagement.util.SNMPManager;
import org.snmp4j.smi.OID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Service
public class ServerService {

    @Autowired
    private SNMPManager snmpManager;
    @Autowired
    private CommandExecutor commandExecutor;

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    static {
        DECIMAL_FORMAT.setRoundingMode(RoundingMode.CEILING);
    }

    public MemInfo getMemInfo() {
        MemInfo memInfo = new MemInfo();
        try {
            snmpManager.start();

            memInfo.setTotal(Long.parseLong(snmpManager.getAsString(new OID(".1.3.6.1.4.1.2021.4.5.0"))));
            memInfo.setFree(Long.parseLong(snmpManager.getAsString(new OID(".1.3.6.1.4.1.2021.4.6.0"))));
            memInfo.setBuffered(Long.parseLong(snmpManager.getAsString(new OID(".1.3.6.1.4.1.2021.4.14.0"))));
            memInfo.setCached(Long.parseLong(snmpManager.getAsString(new OID(".1.3.6.1.4.1.2021.4.15.0"))));

        } catch (Exception ex) {

        }

        return memInfo;
    }

    public CPUInfo getCPUInfo() {
        CPUInfo cpuInfo = new CPUInfo();
        try {
            snmpManager.start();

            cpuInfo.setIdle(Long.parseLong(snmpManager.getAsString(new OID("1.3.6.1.4.1.2021.11.11.0"))));
            cpuInfo.setRawIdle(Long.parseLong(snmpManager.getAsString(new OID("1.3.6.1.4.1.2021.11.53.0"))));
            cpuInfo.setRawKernel(Long.parseLong(snmpManager.getAsString(new OID("1.3.6.1.4.1.2021.11.55.0"))));
            cpuInfo.setRawNice(Long.parseLong(snmpManager.getAsString(new OID("1.3.6.1.4.1.2021.11.51.0"))));
            cpuInfo.setRawSystem(Long.parseLong(snmpManager.getAsString(new OID("1.3.6.1.4.1.2021.11.52.0"))));
            cpuInfo.setRawUser(Long.parseLong(snmpManager.getAsString(new OID("1.3.6.1.4.1.2021.11.50.0"))));
            cpuInfo.setRawWait(Long.parseLong(snmpManager.getAsString(new OID("1.3.6.1.4.1.2021.11.54.0"))));
            cpuInfo.setRawInterrupts(Long.parseLong(snmpManager.getAsString(new OID("1.3.6.1.4.1.2021.11.59.0"))));
            cpuInfo.setRawSoftIRQ(Long.parseLong(snmpManager.getAsString(new OID("1.3.6.1.4.1.2021.11.61.0"))));
            cpuInfo.setRawSteal(Long.parseLong(snmpManager.getAsString(new OID("1.3.6.1.4.1.2021.11.64.0"))));

        } catch (Exception ex) {

        }

        return cpuInfo;
    }

    public StorageInfo getStorageInfo() {
        StorageInfo storageInfo = new StorageInfo();
        try {
            snmpManager.start();

            storageInfo.setTotal(Long.parseLong(snmpManager.getAsString(new OID("1.3.6.1.2.1.25.2.3.1.5.31"))));
            storageInfo.setUsed(Long.parseLong(snmpManager.getAsString(new OID("1.3.6.1.2.1.25.2.3.1.6.31"))));

        } catch (Exception ex) {

        }

        return storageInfo;
    }

    public OSInfo getOSInfo() {
        OSInfo osInfo = new OSInfo();
        commandExecutor.execute("uptime");
        osInfo.setUptime(commandExecutor.getStdInput());

        return osInfo;
    }
}
