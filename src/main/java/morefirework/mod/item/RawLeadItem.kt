package morefirework.mod.item

import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class RawLeadItem : Item {

    constructor(settings: Settings?) : super(settings) {



    }

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {



        return super.use(world, user, hand)

    }

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {

        //tooltip?.add(Text.translatable("Dont eat.").formatted(Formatting.GOLD));

        super.appendTooltip(stack, world, tooltip, context)

    }

}