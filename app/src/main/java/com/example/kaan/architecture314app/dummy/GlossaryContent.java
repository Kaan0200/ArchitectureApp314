package com.example.kaan.architecture314app.dummy;

import java.util.*;

/**
 * Created by Kaan on 4/16/2015.  This class contains all the content for the glossary
 */
public class GlossaryContent {

    /**
     * An array of items.
     */
    public static List<GlossaryItem> ITEMS = new ArrayList<GlossaryItem>();

    /**
     * A map of items, by unique ID word.
     */
    public static Map<String, GlossaryItem> ITEM_MAP = new HashMap<String, GlossaryItem>();

    static {
        // Add 3 sample items.
        addItem(new GlossaryItem("CPU", "Central Processing Unit, this is the main processor"));
        addItem(new GlossaryItem("CPI",
                "Clocks Per Instruction, the number of clocks needed to execute an instruction"));
        addItem(new GlossaryItem("Clock Speed",
                "This is how many times the clock switches per second"));
    }

    private static void addItem(GlossaryItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.word, item);
    }

    public static class GlossaryItem {
        public String word; //unique ID
        public String definition;
        public String relatedWords;

        public GlossaryItem(String word, String definition) {
            this.word = word;
            this.definition = definition;
        }

        public String toString() { return word + " : "+ definition; }
    }
}
