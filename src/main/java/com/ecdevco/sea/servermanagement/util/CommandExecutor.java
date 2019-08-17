package com.ecdevco.sea.servermanagement.util;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class CommandExecutor {

    private String stdInput;
    private String stdError;
    private int exitCode;

    public void execute(String command) {
        String str = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(command);

            BufferedReader bufferedReaderInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader bufferedReaderError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            while ((str = bufferedReaderInput.readLine()) != null) {
                stringBuilder.append(str).append("\n");
            }
            stdInput = stringBuilder.toString();

            stringBuilder = new StringBuilder();
            while ((str = bufferedReaderError.readLine()) != null) {
                stringBuilder.append(str).append("\n");
            }
            stdError = stringBuilder.toString();

            exitCode = process.exitValue();

            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getStdInput() {
        return stdInput;
    }

    public String getStdError() {
        return stdError;
    }

    public int getExitCode() {
        return exitCode;
    }
}
