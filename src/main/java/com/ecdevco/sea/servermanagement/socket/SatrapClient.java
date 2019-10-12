package com.ecdevco.sea.servermanagement.socket;

import com.ecdevco.sea.servermanagement.socket.dto.Trigger;
import com.ecdevco.sea.servermanagement.socket.dto.TriggerResponse;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;

@Component
public class SatrapClient {

    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public boolean connectToSatrap(String ip, int port) {
        try {
            socket = new Socket(ip, port);

            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            System.out.println("Connection Created");
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean sendRequest(Trigger trigger) {
        try {
            objectOutputStream.writeObject(trigger);
            objectOutputStream.flush();
            System.out.println("Object writed");

            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public TriggerResponse getResponse() {
        try {
            return (TriggerResponse) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
