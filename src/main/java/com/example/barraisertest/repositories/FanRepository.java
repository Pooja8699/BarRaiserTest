package com.example.barraisertest.repositories;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public class FanRepository {

//    Map<String, Integer> fanSpeedMap = new HashMap<>();
//    Map<String, String> switchModeMap = new HashMap<>();

    SmartHomeRepository smartHomeRepository;

    public void addFanSpeed(String electricalAppliance, Integer speed, Map<String, Integer> fanSpeedMap) {
        fanSpeedMap.put(electricalAppliance, speed);
    }

    public void mapSwitchModes(String electricalAppliance, String mode, Map<String, String> switchModeMap) {
        switchModeMap.put(electricalAppliance, mode);
    }

    public String fetchSwitchMode(String electricalAppliance) {
        return smartHomeRepository.fetchSwitchMode(electricalAppliance);
    }
}
