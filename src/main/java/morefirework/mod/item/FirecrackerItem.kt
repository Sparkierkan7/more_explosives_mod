package morefirework.mod.item

import morefirework.mod.entity.projectile.FirecrackerProjectile
import morefirework.mod.util.Math.setShootVelocity
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class FirecrackerItem : Item {

    /*fun FirecrackerItem(settings: Settings?) {
        super(settings)
    }*/

    constructor(settings: Settings?) : super(settings) {



    }

    override fun postProcessNbt(nbt: NbtCompound?) {

        //nbt?.putInt("power", 1)

        super.postProcessNbt(nbt)
    }

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {

        var stack = user?.getStackInHand(hand)

        //if (stack!!.count > 1) { stack.count -= 1 }

        var shot = setShootVelocity(user!!.pitch, user.yaw, 0f, 3.0)
        var entity = FirecrackerProjectile(world, user as LivingEntity, stack)
        entity.setVelocity(shot)

        world?.spawnEntity(entity)

        //user?.getStackInHand(hand)!!.count -= 1

        return super.use(world, user, hand)

    }

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {

        var nbt = NbtCompound()
        nbt.putFloat("power", 8f)

        stack?.setNbt(nbt)

        tooltip?.add(Text.translatable("§6Explosion Power: ${stack?.nbt?.getFloat("power")}").formatted(Formatting.GOLD));

        super.appendTooltip(stack, world, tooltip, context)
    }

}