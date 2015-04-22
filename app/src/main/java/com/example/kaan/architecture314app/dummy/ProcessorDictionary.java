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
        // Add 3 sample items.
        addItem(new ProcessorItem("Broadwell i3", "Item 1"));
        addItem(new ProcessorItem("Broadwell i5", "Item 2"));
        addItem(new ProcessorItem("Broadwell i7", "Item 3"));
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
        public String desc;

        public ProcessorItem(String name, String desc) {
            this.name = name;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return desc;
        }
    }
}
