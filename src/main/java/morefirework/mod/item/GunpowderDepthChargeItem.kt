package morefirework.mod.item

import morefirework.mod.MorefireworkMod.Companion.LOGGER
import morefirework.mod.entity.projectile.GunpowderDepthChargeProjectile
import morefirework.mod.util.Math.setShootVelocity
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.text.Text
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class GunpowderDepthChargeItem : Item {

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

        if (hand == Hand.MAIN_HAND) {

            var stack = user?.getStackInHand(hand)

            var shot = setShootVelocity(user!!.pitch, user.yaw, 0f, 1.0)
            var entity = GunpowderDepthChargeProjectile(world, user as LivingEntity, stack)
            entity.setVelocity(shot)

            world?.spawnEntity(entity)

            if (!user.isCreative) {

                user.itemCooldownManager[this] = 20


            }

        } else if (hand == Hand.OFF_HAND) {

            var stack = user?.getStackInHand(hand)

            LOGGER.info("${stack?.nbt}")

        }

        return super.use(world, user, hand)

    }

    override fun onCraft(stack: ItemStack?, world: World?, player: PlayerEntity?) {

        if (stack?.nbt?.getBoolean("tooltip_nbt") == null || stack.nbt?.getBoolean("tooltip_nbt") == true) {

            var nbt = NbtCompound()
            nbt.putFloat("power", 4.5f)
            nbt.putInt("fuse", 75)
            nbt.putBoolean("light_on_impact", false)
            nbt.putBoolean("tooltip_nbt", true)

            stack?.setNbt(nbt)

        }

        super.onCraft(stack, world, player)

    }

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {

        if (stack?.nbt?.getBoolean("tooltip_nbt") == null || stack.nbt?.getBoolean("tooltip_nbt") == true) {

            var nbt = NbtCompound()
            nbt.putFloat("power", 4.5f)
            nbt.putInt("fuse", 75)
            nbt.putBoolean("light_on_impact", false)
            nbt.putBoolean("tooltip_nbt", true)

            stack?.setNbt(nbt)

        }

        super.appendTooltip(stack, world, tooltip, context)
    }

}