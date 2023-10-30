package com.example.barraisertest.repositories;

import java.util.ArrayList;
import java.util.List;

public class GoogleHomeRepository {

    List<String> devices = new ArrayList<>();
    public void addDevice(String deviceName) {
        devices.add(deviceName);
    }
}
