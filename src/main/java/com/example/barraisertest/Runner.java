package com.example.barraisertest;

import com.example.barraisertest.service.Device;
import com.example.barraisertest.service.SmartHomeAppliances;
import com.example.barraisertest.service.impl.Fan;
import com.example.barraisertest.service.impl.GoogleHomeDevice;
import com.example.barraisertest.service.impl.Light;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {

    static Map<String, Integer> fanSpeedMap = new HashMap<>();
    static Map<String, String> switchModeMap = new HashMap<>();

    public static void addInterfaceDevice(String deviceName, String location, String activationKeyword) {
        Device device = new GoogleHomeDevice();
        device.addDevice(deviceName, location, activationKeyword);
    }

    public static void addSmartHomeDevice(String deviceName, String homeApplicance, String location) {
        if(homeApplicance.equals("FAN")) {
            SmartHomeAppliances smartHomeAppliances = new Fan();
            smartHomeAppliances.addSmartHomeAppliances(deviceName, homeApplicance , location);
        }
    }

    public static void giveCommand(String activationKeyword, String deviceName, String location, String deviceCommandValue) {
        if (deviceName.equals("FAN") && deviceCommandValue.equals("ON")) {
            Fan fan = new Fan();
            fan.switchOnOrOff(deviceName, deviceCommandValue, switchModeMap);
        }
    }


    public static void main(String[] args) {
        addInterfaceDevice("Google Home", "Living Room", "OK Google");
        addInterfaceDevice("Alexa","Drawing Room", "Alexa");
        addSmartHomeDevice("ALEXA","FAN","Drawing Room");

        giveCommand("OK Google","FAN","Living Room","ON");
    }

}
