package net.baconknight.petshop.item;

import net.baconknight.petshop.PetShop;
import net.baconknight.petshop.item.custom.AdoptionPapersItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ADOPTION_PAPERS = registerItem("adoption_papers",
            new AdoptionPapersItem(new FabricItemSettings()));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM,new Identifier(PetShop.MOD_ID,name),item);
    }

    public static void registerModItems(){
        PetShop.LOGGER.info("Registering Mod Items For "+PetShop.MOD_ID);
    }
}
