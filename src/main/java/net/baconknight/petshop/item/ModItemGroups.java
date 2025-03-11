package net.baconknight.petshop.item;

import net.baconknight.petshop.PetShop;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup PET_SHOP_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PetShop.MOD_ID,"pet_shop_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pet_shop_group"))
                    .icon(()->new ItemStack(ModItems.ADOPTION_PAPERS)).entries((displayContext, entries) -> {

                        entries.add(ModItems.ADOPTION_PAPERS);
                    }).build());
    public static final void registerItemGroups(){
        PetShop.LOGGER.info("Registering Item Groups For "+PetShop.MOD_ID);
    }
}
