package com.example.barraisertest.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartHomeRepository {
    List<String> smartHomeAppliances = new ArrayList<>();
    Map<String, String> switchModeMap = new HashMap<>();

    public void addSmartHomeAppliances(String homeAppliance) {
        smartHomeAppliances.add(homeAppliance);
    }

    public boolean checkSmartHomeApplianceExists(String electricalAppliance) {
        return smartHomeAppliances.contains(electricalAppliance);
    }

    public String fetchSwitchMode(String electricalAppliance) {
        return switchModeMap.get(electricalAppliance);
    }
}
