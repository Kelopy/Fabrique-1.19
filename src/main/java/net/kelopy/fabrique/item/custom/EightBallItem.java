package net.kelopy.fabrique.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

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

    private void outputRandomNumber(PlayerEntity player){
        int num = getRandomNumber();
        player.sendMessage(Text.literal("§7You Rolled §b" + num));

        if(num == 5){
            player.sendMessage(Text.literal("§b§lCONGRATS YOU ROLLED A 5"));
        }

    }

    private int getRandomNumber(){
        return Random.createLocal().nextInt(10);
    }

}
