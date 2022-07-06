package net.kelopy.fabrique.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EightBallItem extends Item {

    public EightBallItem(Settings settings){
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if(!world.isClient && hand == Hand.MAIN_HAND){
            outputRandomNumber(user);
            user.getItemCooldownManager().set(this, 20);
        }

        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if(Screen.hasShiftDown()){
            tooltip.add(Text.literal("Right Click to roll a random number.").formatted(Formatting.AQUA));
            tooltip.add(Text.literal("Rolls a random number between 0-10,").formatted(Formatting.AQUA));
            tooltip.add(Text.literal("if you roll a 5 you are congratulated!").formatted(Formatting.AQUA));
        }else{
            tooltip.add(Text.literal("Press Shift for more info.").formatted(Formatting.GRAY));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    private void outputRandomNumber(PlayerEntity player){
        int num = getRandomNumber();
        player.sendMessage(Text.literal("§7You Rolled a §b" + num));

        if(num == 5){
            player.sendMessage(Text.literal("§b§lCONGRATS YOU ROLLED A 5"));
        }

    }

    private int getRandomNumber(){
        return Random.createLocal().nextInt(10);
    }

}
