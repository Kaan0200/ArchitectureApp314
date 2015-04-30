package com.example.kaan.architecture314app.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ProcessorDictionary {

    // An array of sample processor items.
    public static List<ProcessorItem> ITEMS = new ArrayList<ProcessorItem>();
    // A map of sample processor items, by ID.
    public static Map<String, ProcessorItem> ITEM_MAP = new HashMap<String, ProcessorItem>();

    static {
        // empty block that is executed.
    }

    private static void addItem(ProcessorItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class ProcessorItem {
        public String name;
        public String company;
        public String year;
        public String instructionset;
        public String bitsize;
        public String microarch;
        public String speed;
        public String other;

        public ProcessorItem(String name, String company, String year,
                             String instructionset, String bitsize,
                             String microarch, String speed,String other) {
            this.name = name;
            this.company = company;
            this.year = year;
            this.instructionset = instructionset;
            this.bitsize = bitsize;
            this.microarch = microarch;
            this.speed = speed;
            this.other = other;
        }

        @Override
        public String toString() {
            return company + " - "+ name;
        }
    }
}
