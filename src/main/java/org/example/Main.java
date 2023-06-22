package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Wall wall1 = new Wall();

        wall1.createBlock("Red", "Clay");
        wall1.createBlock("Gray", "Concrete");

        List<Block> subBlocks = new ArrayList<>();

        subBlocks.add(wall1.createBlock("Brown", "Wood"));
        subBlocks.add(wall1.createBlock("Yellow", "Wood"));

        CompositeBlock compositeBlock = wall1.createCompositeBlock("Brown-Yellow", "Wood", subBlocks);

        wall1.findBlockByColor("Yellow");
        wall1.findBlocksByMaterial("Wood");
        System.out.println(wall1.count() + "\n");
        wall1.viewBlocks();
        wall1.viewSubBlocks(compositeBlock);

    }
}