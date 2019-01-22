package com.example.illes.beeappiaristtry2;

import android.widget.ImageButton;

public class Hive
{

    private String name;
    boolean hasQueen, hasWorm, hasFood, hasHoney, hasIllness;
    String[] strength = {"gyenge", "átlagos", "erős"};  // vagy számokban, pl. 1-tol 10-ig v. 5-ig vagy szimplán az elso verzio szamokkal: 33, 67, 100.
    String warning = "";
    int hiveFrameCapacity, numberOfFrames, framesWithBees, framePerHivePercent, beePerFramePercent;

    // TODO: etetések jelölése dátum alapján, pl. úgy megoldva, hogy csak az utolsó 5 etetés látszódjon és/vagy csak az utolsó 1 hónapban (pipa lehetőség: "látszodjanak a korábbi etetések is")
    boolean WinterPrepared;

    int honeyAprox; // kg


    // Constructor
    public Hive()
    {
    }

    /** Value need: hiveFrameCapacity */
    public Hive(int hiveFrameCapacity)
    {
        framePerHivePercent = numberOfFrames * 100 / hiveFrameCapacity;
        beePerFramePercent = framesWithBees * 100 / numberOfFrames;

    }

    /** Values need: numberOfFrames, hiveFrameCapacity */
    public Hive(int numberOfFrames, int hiveFrameCapacity)
    {
        framePerHivePercent = numberOfFrames * 100 / hiveFrameCapacity;   // 3-as szabály
    }


    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
