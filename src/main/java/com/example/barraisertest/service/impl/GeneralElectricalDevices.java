package com.example.barraisertest.service.impl;

import com.example.barraisertest.repositories.SmartHomeRepository;
import com.example.barraisertest.service.SmartHomeAppliances;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GeneralElectricalDevices implements SmartHomeAppliances {

   private SmartHomeRepository smartHomeRepository;
    @Override
    public void addSmartHomeAppliances(String homeAppliance, String location, String activationKeyword) {
        smartHomeRepository.addSmartHomeAppliances(homeAppliance);
    }
}
