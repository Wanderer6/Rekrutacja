package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure{
    public List<Block> blocks;
    public Wall() {
        blocks = new ArrayList<>();
    }

    public Optional<Block> findBlockByColor(String color) {
        System.out.println("Block found by " + color + " color:");
        for (Block block : blocks) {
            if (block.getColor().equals(color)) {
                System.out.println(block.getColor() + " " + block.getMaterial() + "\n");
                return Optional.of(block);
            }
        }
        System.out.println("No blocks with that color" + "\n");
        return Optional.empty();
    }

    public List<Block> findBlocksByMaterial(String material) {
        System.out.println("Blocks found by " + material + " material:");
        boolean found = false;
        List<Block> foundBlocks = new ArrayList<>();
        for (Block block : blocks) {
            if (block.getMaterial().equals(material)) {
                found = true;
                foundBlocks.add(block);
                System.out.println(block.getColor() + " " + block.getMaterial());
            }
        }
        if (!found) System.out.println("Didn't find any block by " + material + " material");
        System.out.println();
        return foundBlocks;
    }

    public int count() {
        int count = 0;
        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                continue;
            }
            count++;
        }
        return count;
    }

    public List<Block> viewBlocks() {
        System.out.println("All blocks: ");
        for (Block block : blocks) {
            System.out.println(block.getColor() + " " + block.getMaterial());
        }
        System.out.println();
        return blocks;
    }

    public Block createBlock(String color, String material) {
        Block block = new Block() {
            public String getColor() {
                return color;
            }
            public String getMaterial() {
                return material;
            }
        };
        blocks.add(block);
        return block;
    }

    public CompositeBlock createCompositeBlock(String color, String material, List<Block> subBlocks) {
        CompositeBlock compositeBlock = new CompositeBlock() {
            public String getColor() {
                return color;
            }
            public String getMaterial() {
                return material;
            }
            public List<Block> getBlocks() {
                return subBlocks;
            }
        };
        blocks.add(compositeBlock);
        return compositeBlock;
    }

    public List<Block> viewSubBlocks(CompositeBlock compositeBlock) {
        System.out.println("Sub Blocks of " + compositeBlock.getColor() + " " + compositeBlock.getMaterial() + ":");
        List<Block> subBlocks = compositeBlock.getBlocks();
        for (Block block : subBlocks) {
            System.out.println(block.getColor() + " " + block.getMaterial());
        }
        System.out.println();
        return subBlocks;
    }
}

