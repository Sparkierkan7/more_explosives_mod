package morefirework.mod.item

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

class ShortMusketItem : Item {

    var maxGunpowder = 4
    var ironGunpowderDamageMultiplier = 4.25f
    var copperGunpowderDamageMultiplier = 3.75f

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

                //LOGGER.info("Damage: ${stack!!.nbt!!.getInt("damage")}")

                if (stack!!.nbt!!.getString("ammunition") != "null" && stack!!.nbt!!.getInt("gunpowder") > 0 && stack!!.nbt!!.getBoolean("ready") == true) {

                    if (stack!!.nbt!!.getString("ammunition") == "iron") {

                        var entity = MusketShotProjectile(world, user as LivingEntity, (stack!!.nbt!!.getInt("gunpowder") * this.ironGunpowderDamageMultiplier))
                        entity.setVelocity(user, user.pitch, user.yaw, 0.0f, 16.0f, 0.0f)
                        entity.setNoGravity(true)

                        world?.spawnEntity(entity)

                    } else if (stack!!.nbt!!.getString("ammunition") == "copper") {

                        var entity = MusketShotProjectile(world, user as LivingEntity, (stack!!.nbt!!.getInt("gunpowder") * this.copperGunpowderDamageMultiplier))
                        entity.setVelocity(user, user.pitch, user.yaw, 0.0f, 16.0f, 0.0f)
                        entity.setNoGravity(true)

                        world?.spawnEntity(entity)

                    }

                    user!!.pitch -= 2

                    user!!.playSound(SoundEvents.ENTITY_FIREWORK_ROCKET_BLAST, 3f, 1f)
                    var pshot = setShootVelocity(user!!.pitch, user.yaw, 0f, 0.125)
                    MinecraftClient.getInstance().particleManager.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, user.x, user.y + 1.5, user.z, pshot.x, pshot.y, pshot.z)

                    stack!!.nbt!!.putString("ammunition", "null")
                    stack!!.nbt!!.putInt("gunpowder", 0)
                    stack!!.nbt!!.putBoolean("ready", false)

                    val damage = stack!!.nbt!!.getInt("damage")

                    stack!!.nbt!!.putInt("damage", (damage - 1))

                } else if (stack!!.nbt!!.getBoolean("ready") == false) {

                    var offStack = user!!.offHandStack

                    if (offStack.item == ItemStack(Items.GUNPOWDER).item) {

                        if (stack!!.nbt!!.getString("ammunition") != "null") {

                            if (stack!!.nbt!!.getInt("gunpowder") < this.maxGunpowder) {

                                val newgun = stack!!.nbt!!.getInt("gunpowder") + 1

                                stack!!.nbt!!.putInt("gunpowder", newgun)

                                offStack.count -= 1

                                if (stack!!.nbt!!.getString("ammunition") == "iron") {

                                    user.sendMessage(Text.literal("§6Gunpowder: ${stack!!.nbt!!.getInt("gunpowder")} §cDamage: ${(stack!!.nbt!!.getInt("gunpowder") * this.ironGunpowderDamageMultiplier)}"), true)

                                } else if (stack!!.nbt!!.getString("ammunition") == "copper") {

                                    user.sendMessage(Text.literal("§6Gunpowder: ${stack!!.nbt!!.getInt("gunpowder")} §cDamage: ${(stack!!.nbt!!.getInt("gunpowder") * this.copperGunpowderDamageMultiplier)}"), true)

                                }

                            } else {

                                if (stack!!.nbt!!.getString("ammunition") == "iron") {

                                    user.sendMessage(Text.literal("§eMaximum Gunpowder Reached §cDamage: ${(stack!!.nbt!!.getInt("gunpowder") * this.ironGunpowderDamageMultiplier)}"), true)

                                } else if (stack!!.nbt!!.getString("ammunition") == "copper") {

                                    user.sendMessage(Text.literal("§eMaximum Gunpowder Reached §cDamage: ${(stack!!.nbt!!.getInt("gunpowder") * this.copperGunpowderDamageMultiplier)}"), true)

                                }

                            }

                        } else {

                            user.sendMessage(Text.literal("§6Load Ammunition First"), true)

                        }

                    }

                    if (stack!!.nbt!!.getString("ammunition") == "null") {

                        if (offStack.item == ItemStack(MorefireworkItems.IRON_SHOT_ITEM).item) {

                            stack!!.nbt!!.putString("ammunition", "iron")

                            offStack.count -= 1

                            user.sendMessage(Text.literal("§eIron Shot Loaded"), true)

                        }

                        if (offStack.item == ItemStack(MorefireworkItems.COPPER_SHOT_ITEM).item) {

                            stack!!.nbt!!.putString("ammunition", "copper")

                            offStack.count -= 1

                            user.sendMessage(Text.literal("§eCopper Shot Loaded"), true)

                        }

                    }

                    if (offStack.item == ItemStack(MorefireworkItems.MUSKET_RAM_ROD).item) {

                        if (stack!!.nbt!!.getInt("gunpowder") > 0) {

                            stack!!.nbt!!.putBoolean("ready", true)

                            user.sendMessage(Text.literal("§aReady to Shoot"), true)

                        }

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
            nbt!!.putBoolean("ready", false)
            nbt!!.putString("ammunition", "null")
            nbt!!.putInt("gunpowder", 0)
            nbt!!.putInt("damage", 256)

            stack!!.setNbt(nbt)

        }

        super.appendTooltip(stack, world, tooltip, context)
    }

}