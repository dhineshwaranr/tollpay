package com.toll.domain;

import java.util.HashMap;
import java.util.Map;

public enum Frequency {

	MONTHLY("Monthly"),
	ANNUALLY("Annually");
	
    private String displayName;

    private Frequency(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        for (Frequency item : values()) {
            map.put(item.name(), item.getDisplayName());
        }
        return map;
    }
	
}
