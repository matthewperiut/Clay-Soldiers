package com.matthewperiut.clay.forge.item;

import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ClayItemsColorProvider implements ItemColorProvider {

    private class Pair
    {
        public Item item;
        public int color;

        Pair(Item item, int color)
        {
            this.item = item;
            this.color = color;
        }
    }

    public List<Pair> pairs = new ArrayList<>();

    public void addColoredItem(Item item, int color)
    {
        pairs.add(new Pair(item, color));
    }

    @Override
    public int getColor(ItemStack stack, int tintIndex)
    {
        // this doesn't need high performance
        for (Pair pair : pairs)
        {
            if (stack.getItem() == pair.item)
            {
                return pair.color;
            }
        }

        return 0;
    }

}
