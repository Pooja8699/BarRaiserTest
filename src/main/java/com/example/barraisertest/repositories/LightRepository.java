package com.example.barraisertest.repositories;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class LightRepository {

    Map<String, String> switchModeMap = new HashMap<>();
    Map<String, Integer> brightnessLevelMap = new HashMap<>();
    Map<String, String> colorMap = new HashMap<>();

    SmartHomeRepository smartHomeRepository;
    public void addLight(String homeAppliance) {
        smartHomeRepository.addSmartHomeAppliances(homeAppliance);
    }
    public boolean checkSmartHomeApplianceExists(String electricalAppliance) {
        return smartHomeRepository.checkSmartHomeApplianceExists(electricalAppliance);
    }

    public void mapSwitchModes(String electricalAppliance, String mode) {
        switchModeMap.put(electricalAppliance, mode);
    }

    public void mapBrightnessLevel(String electricalAppliance, Integer brightness) {
        brightnessLevelMap.put(electricalAppliance, brightness);
    }

    public String fetchSwitchMode(String electricalAppliance) {
        return switchModeMap.get(electricalAppliance);
    }

    public void addColoMap(String electricalAppliance, String color) {
        colorMap.put(electricalAppliance, color);
    }
}
