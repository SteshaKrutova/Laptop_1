package com.geekbrains.sem1;

import java.util.Objects;

public class Notebook {
    String Name;
    String RAM;
    String HardDiskSpace;
    String OS;
    String Color;

    public Notebook(String Name, String RAM, String HardDiskSpace, String OS, String Color) {
        this.Name = Name;
        this.RAM = RAM;
        this.HardDiskSpace = HardDiskSpace;
        this.OS = OS;
        this.Color = Color;
    }

    public String return_Name (){ return Name;}
    public String return_Ram (){ return RAM;}
    public String return_HardDiskSpace (){ return HardDiskSpace;}
    public String return_OS (){ return OS;}
    public String return_Color (){ return Color;}

    @Override
    public String toString() {
        return "Notebook{" +
                "Name='" + Name + '\'' +
                ", RAM='" + RAM + '\'' +
                ", HardDiskSpace='" + HardDiskSpace + '\'' +
                ", OS='" + OS + '\'' +
                ", Color='" + Color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return RAM == notebook.RAM && HardDiskSpace == notebook.HardDiskSpace && Objects.equals(OS, notebook.OS) && Objects.equals(Color, notebook.Color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(RAM, HardDiskSpace, OS, Color);
    }
}
