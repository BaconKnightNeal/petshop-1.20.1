package net.baconknight.petshop.item.custom;

import net.minecraft.client.font.Font;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

public class AdoptionPapersItem extends Item {

    public AdoptionPapersItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        if (entity instanceof TameableEntity) {
            TameableEntity tameableEntity = (TameableEntity) entity;
            if (tameableEntity.isTamed()) {
                if (!tameableEntity.getOwnerUuid().equals(player.getUuid())) {
                    tameableEntity.setOwner(player);
                    player.sendMessage(Text.of("You are now the owner of " + tameableEntity.getName().getString() + "!"), true);
                    stack.decrement(1);
                    return ActionResult.SUCCESS;
                } else {
                    player.sendMessage(Text.of("You already own this entity."), true);
                    return ActionResult.FAIL;
                }
            }
        }

        player.sendMessage(Text.of("Entity is not tamed or not tameable"), true);
        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.petshop.adoption_papers").formatted(Formatting.LIGHT_PURPLE));
        tooltip.add(Text.translatable("tooltip.petshop.adoption_papers_sub").formatted(Formatting.ITALIC,Formatting.RED));
        super.appendTooltip(stack, world, tooltip, context);
    }
}