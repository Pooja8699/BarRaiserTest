package com.example.barraisertest.service.impl;

import com.example.barraisertest.repositories.FanRepository;
import com.example.barraisertest.repositories.SmartHomeRepository;
import com.example.barraisertest.service.SmartHomeAppliances;
import lombok.AllArgsConstructor;

import java.util.Map;

public class Fan implements SmartHomeAppliances {

    private SmartHomeRepository smartHomeRepository = new SmartHomeRepository();

    private FanRepository fanRepository = new FanRepository();
    @Override
    public void addSmartHomeAppliances(String deviceName, String homeApplicance, String location) {
        smartHomeRepository.addSmartHomeAppliances(homeApplicance+location);
        System.out.println("Added "+ homeApplicance + " " + location + " " + deviceName);
    }

    public String switchOnOrOff(String electricalAppliance, String switchMode, Map<String, String> switchModeMap) {
        if(smartHomeRepository.checkSmartHomeApplianceExists(electricalAppliance)) {
            if (switchMode.equals("ON")) {
                System.out.println(electricalAppliance + " turned ON");
            } else if (switchMode.equals("OFF")) {
                System.out.println(electricalAppliance + " turned OFF");
            }
            fanRepository.mapSwitchModes(electricalAppliance, switchMode, switchModeMap);
        }
        return null;
    }

    public String addSpeed(String electricalAppliance, int speed, Map<String, Integer> fanSpeedMap) {
        if (smartHomeRepository.checkSmartHomeApplianceExists(electricalAppliance)) {
            if(fanRepository.fetchSwitchMode(electricalAppliance).equals("ON") && speed >= 1 && speed <= 5) {
                fanRepository.addFanSpeed(electricalAppliance, speed, fanSpeedMap);
                System.out.println(electricalAppliance + " speed set to " + speed);
            }
        }
        return null;
    }
}
