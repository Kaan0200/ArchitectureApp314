package com.example.kaan.architecture314app.dummy;

import java.util.*;

/**
 * Created by Kaan on 4/16/2015.  This class contains all the content for the glossary
 */
public class GlossaryContent {

    // The items list contains all items, the map is unique by word
    public static List<GlossaryItem> ITEMS = new ArrayList<GlossaryItem>();
    public static Map<String, GlossaryItem> ITEM_MAP = new HashMap<String, GlossaryItem>();

    private static void addItem(GlossaryItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.word, item);
    }

    // This is individual item with it's definition
    public static class GlossaryItem {
        public String word; //unique ID
        public String definition;
        public String relatedWords;

        public GlossaryItem(String word, String definition) {
            this.word = word;
            this.definition = definition;
        }
        // this is what will be shown on the list of items
        public String toString() { return word; }
    }

    static {
        // Add Items to glossary here
        addItem(new GlossaryItem("AIM Alliance",
                "Standing for Apple-IBM-Motorola, the AIM Alliance was created with the goal of creating a new computing standard based on the PowerPC architecture. They were trying to beat the current "+
                "dominant Wintel computing platform and show that RISC microprocessor design was better then CISC."));
        addItem(new GlossaryItem("AMD",
                "Advanced Micro Devices is an American Semiconductor company founded in 1969."));
        addItem(new GlossaryItem("BCD",
                "Binary-coded Decimal, is a type of binary encoding where each digit is represented by a fixed number of bits."));
        addItem(new GlossaryItem("CPU",
                "Central Processing Unit, this is the main processor in a computer that carries out the instructions."));
        addItem(new GlossaryItem("CPI",
                "Clocks Per Instruction, the number of clocks needed to execute an instruction."));
        addItem(new GlossaryItem("Clock Speed",
                "This is how many times the clock switches per second."));
        addItem(new GlossaryItem("ISA",
                "Instruction Set Architecture, this is the part of a computer architecture dealing with instructions and other machine level code."));
        addItem(new GlossaryItem("Intel Corperation",
                "This is an American multinational corporation who produce a large array of computer related devices. They design leading edge computer chips and through their widely popular Pentium processors "+
                "they have become a household name."));
        addItem(new GlossaryItem("MMX",
                "This is a SIMD instruction set developed by Intel.  Produced in 1997, it is a processor supplementary capability that better for graphic powering due to it's faster matrix math abilities."));
        addItem(new GlossaryItem("Qualcomm",
                "Qualcomm Inc. is an American semiconductor company founded in 1985"));
        addItem(new GlossaryItem("SIMD",
                "Single Instruction, Multiple Data, this describes the ability of processors that perform the same operation on multiple data points simultaneously."));
        addItem(new GlossaryItem("VIA Technologies",
                "This is a Taiwanese processor manufacturer.  They are the world's largest independent manufacturer of motherboard chipsets.  They produce intergrated chipsets for motherboards, audio controllers"+
                " network controllers, low power CPUs, and even CD/DVD writers."));
    }
}
