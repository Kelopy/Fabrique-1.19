package net.kelopy.fabrique.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kelopy.fabrique.FabriqueMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item TANZANITE = registerItem("tanzanite",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(FabriqueMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        FabriqueMod.LOGGER.debug("Registering Mod Items for " + FabriqueMod.MOD_ID);
    }

}
