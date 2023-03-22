package morefirework.mod.item

import morefirework.mod.MorefireworkMod.Companion.LOGGER
import morefirework.mod.entity.projectile.MusketShotProjectile
import morefirework.mod.util.Math.setShootVelocity
import net.minecraft.client.MinecraftClient
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.nbt.NbtCompound
import net.minecraft.particle.ParticleTypes
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import java.util.function.Consumer

class ShortMusketItem : Item {

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

        stack!!.nbt!!.putBoolean("tooltip_nbt", false)

        if (hand == Hand.MAIN_HAND) {

            if (stack!!.nbt!!.getInt("damage") > 0) {

                LOGGER.info("Damage: ${stack!!.nbt!!.getInt("damage")}")

                if (stack!!.nbt!!.getString("ammunition") == "iron" && stack!!.nbt!!.getBoolean("gunpowder")) {

                    var entity = MusketShotProjectile(world, user as LivingEntity, 16f)
                    entity.setVelocity(user, user.pitch, user.yaw, 0.0f, 16.0f, 0.0f)
                    entity.setNoGravity(true)

                    user.pitch -= 2

                    world?.spawnEntity(entity)

                    user.playSound(SoundEvents.ENTITY_FIREWORK_ROCKET_BLAST, 3f, 1f)
                    var pshot = setShootVelocity(user!!.pitch, user.yaw, 0f, 0.125)
                    MinecraftClient.getInstance().particleManager.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, user.x, user.y + 1.5, user.z, pshot.x, pshot.y, pshot.z)

                    stack!!.nbt!!.putString("ammunition", "null")
                    stack!!.nbt!!.putBoolean("gunpowder", false)

                    val damage = stack!!.nbt!!.getInt("damage")

                    stack!!.nbt!!.putInt("damage", (damage - 1))

                } else if (stack!!.nbt!!.getString("ammunition") == "null" || !stack!!.nbt!!.getBoolean("gunpowder")) {

                    var offStack = user!!.offHandStack

                    if (offStack.item == ItemStack(Items.GUNPOWDER).item) {

                        stack!!.nbt!!.putBoolean("gunpowder", true)

                        offStack.count -= 1

                    }

                    if (offStack.item == ItemStack(MorefireworkItems.IRON_SHOT_ITEM).item) {

                        stack!!.nbt!!.putString("ammunition", "iron")

                        offStack.count -= 1

                    }

                }

            } else if (stack!!.nbt!!.getInt("damage") <= 0) {

                stack.count -= 1

            }

            //var shot = setShootVelocity(user!!.pitch, user.yaw, 0f, 10.0)

        }

        return super.use(world, user, hand)

    }

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {

        if (stack?.nbt?.getBoolean("tooltip_nbt") == null || stack?.nbt?.getBoolean("tooltip_nbt") == true) {

            var nbt = NbtCompound()
            nbt!!.putBoolean("tooltip_nbt", true)
            nbt!!.putString("ammunition", "null")
            nbt!!.putBoolean("gunpowder", false)
            nbt!!.putInt("damage", 256)

            stack!!.setNbt(nbt)

        }

        super.appendTooltip(stack, world, tooltip, context)
    }

}