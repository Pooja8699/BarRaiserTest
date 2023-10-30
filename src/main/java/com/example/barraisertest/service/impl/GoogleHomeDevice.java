package com.example.barraisertest.service.impl;

import com.example.barraisertest.repositories.GoogleHomeRepository;
import com.example.barraisertest.service.Device;


public class GoogleHomeDevice implements Device {

    GoogleHomeRepository googleHomeRepository = new GoogleHomeRepository();
    @Override
    public void addDevice(String deviceName, String location, String activationKeyword) {
        googleHomeRepository.addDevice(deviceName);
        System.out.println("Added "+ deviceName + " " + location + " " + activationKeyword);
    }
}
