package com.example.barraisertest.service.impl;

import com.example.barraisertest.repositories.LightRepository;
import com.example.barraisertest.repositories.SmartHomeRepository;
import com.example.barraisertest.service.SmartHomeAppliances;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Light implements SmartHomeAppliances {

    private SmartHomeRepository smartHomeRepository;

    private LightRepository lightRepository;
    @Override
    public void addSmartHomeAppliances(String homeApplicance, String location, String activationKeyword) {
        smartHomeRepository.addSmartHomeAppliances(homeApplicance+location);
        System.out.println("Added "+ homeApplicance + " " + location + " " + activationKeyword);
    }

    public String switchOnOrOff(String electricalAppliance, String switchMode) {
        if(lightRepository.checkSmartHomeApplianceExists(electricalAppliance)) {
            if (switchMode.equals("ON")) {
                System.out.println(electricalAppliance + " turned ON");
            } else if (switchMode.equals("OFF")) {
                System.out.println(electricalAppliance + " turned OFF");
            }
            lightRepository.mapSwitchModes(electricalAppliance, switchMode);
        }
        return null;
    }

    public String brightness(String electricalAppliance, int brightnessLevel) {
        if (lightRepository.checkSmartHomeApplianceExists(electricalAppliance)) {
            if(lightRepository.fetchSwitchMode(electricalAppliance).equals("ON") && brightnessLevel >= 1 && brightnessLevel <= 10) {
                lightRepository.mapBrightnessLevel(electricalAppliance, brightnessLevel);
                System.out.println(electricalAppliance + " brightness set to " + brightnessLevel);
            }
        }
        return null;
    }

    public String color(String electricalAppliance, String color) {
        if (lightRepository.checkSmartHomeApplianceExists(electricalAppliance)) {
            if(lightRepository.fetchSwitchMode(electricalAppliance).equals("ON") && (color.equals("Red") || color.equals("Blue") ||
                    color.equals("Green") || color.equals("White"))) {
                lightRepository.addColoMap(electricalAppliance, color);
                System.out.println(electricalAppliance + " color set to " + color);
            }
        }
        return null;
    }
}
