package com.company.RTTI;

import java.util.Objects;

/**
 * page 457
 */
interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    public Toy() {
    }

    public Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    public FancyToy() {
        super(1);
    }
}

public class ClassTest {
    public static void printClassInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" +
                cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.company.RTTI.FancyToy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        printClassInfo(c);
        for (Class face: c.getInterfaces()) {
            System.out.println(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        printClassInfo(Objects.requireNonNull(obj).getClass());
    }
}
