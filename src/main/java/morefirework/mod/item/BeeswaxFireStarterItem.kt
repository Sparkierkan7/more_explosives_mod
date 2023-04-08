package morefirework.mod.item

import morefirework.mod.entity.projectile.FirePasteProjectile
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

class BeeswaxFireStarterItem : Item {

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

            for (i in 0..2) {

                var entity = FirePasteProjectile(world, user as LivingEntity)
                entity.setVelocity(user!!, user.pitch, user.yaw, 0.0f, 0.25f, 15f)

                world?.spawnEntity(entity)

            }

            var damage = stack!!.nbt!!.getInt("durability")

            stack!!.nbt!!.putInt("durability", damage - 1)
            stack!!.nbt!!.putBoolean("tooltip_nbt", false)

            if (stack!!.nbt!!.getInt("durability") <= 0) {

                stack.count -= 1

            }

            user!!.swingHand(hand)
            user.itemCooldownManager[this] = 20

        } else if (hand == Hand.OFF_HAND) {

            var stack = user?.getStackInHand(hand)
            user!!.sendMessage(Text.literal("§6Durability: §e${stack!!.nbt!!.getInt("durability")}/64"), true)

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
            nbt.putInt("durability", 64)
            nbt.putBoolean("tooltip_nbt", true)

            stack?.setNbt(nbt)

        }

        super.appendTooltip(stack, world, tooltip, context)
    }

    /*override fun useOnBlock(context: ItemUsageContext?): ActionResult {

        var world = context!!.world
        var player = context!!.player

        if (world.getBlockState(context.blockPos) == MoreFireworkBlocks.FIREWORK_STATION_BLOCK.defaultState) {

            var mainStack = player!!.inventory.mainHandStack
            var offStack = player.offHandStack

            if (context.hand == Hand.MAIN_HAND) {

                if (mainStack.item == ItemStack(MorefireworkItems.GUNPOWDER_BOMB_ITEM).item) {

                    mainStack.nbt!!.putBoolean("tooltip_nbt", false)

                    if (offStack.item == ItemStack(Items.REDSTONE).item) {

                        if (mainStack.nbt!!.getInt("fuse") >= 20) {

                            if (offStack.count >= mainStack.count) {

                                mainStack.nbt!!.putBoolean("light_on_impact", true)

                                offStack.count -= mainStack.count

                                val newStack = ItemStack(mainStack.item, mainStack.count)
                                newStack.setNbt(mainStack.nbt)

                                player.dropStack(newStack)
                                mainStack.count = 0

                                player.sendMessage(Text.translatable("§aAdded §dLight on Impact").formatted(Formatting.BOLD), true)

                            }

                        } else {

                            val newStack = ItemStack(mainStack.item, mainStack.count)
                            newStack.setNbt(mainStack.nbt)
                            player.dropStack(newStack)
                            mainStack.count = 0

                            player.sendMessage(Text.translatable("§6Fuse must be greater than 20 ticks.").formatted(Formatting.BOLD), true)

                        }

                    }

                    if (offStack.item == ItemStack(Items.SHEARS).item) {

                        var fuse = mainStack.nbt!!.getInt("fuse")

                        if (fuse > 0) {

                            mainStack.nbt!!.putInt("fuse", (fuse - 5))

                            val newStack = ItemStack(mainStack.item, mainStack.count)
                            newStack.setNbt(mainStack.nbt)

                            player.dropStack(newStack)
                            mainStack.count = 0

                            player.sendMessage(Text.translatable("§eRemoved §65 ticks from fuse (now ${newStack.nbt!!.getInt("fuse")})").formatted(Formatting.BOLD), true)

                        } else if (fuse <= 0) {

                            val newStack = ItemStack(mainStack.item, mainStack.count)
                            newStack.setNbt(mainStack.nbt)

                            player.dropStack(newStack)
                            mainStack.count = 0

                            player.sendMessage(Text.translatable("§eCannot shorten fuse anymore §c(fuse ${newStack.nbt!!.getInt("fuse")})").formatted(Formatting.BOLD), true)

                        }


                    }

                    if (offStack.item == ItemStack(MorefireworkItems.FUSE_ITEM).item) {

                        if (offStack.count >= mainStack.count) {

                            var fuse = mainStack.nbt!!.getInt("fuse")
                            mainStack.nbt!!.putInt("fuse", (fuse + 5))

                            val newStack = ItemStack(mainStack.item, mainStack.count)
                            newStack.setNbt(mainStack.nbt)

                            offStack.count -= mainStack.count

                            player.dropStack(newStack)
                            mainStack.count = 0

                            player.sendMessage(Text.translatable("§aAdded §65 ticks to fuse (now ${newStack.nbt!!.getInt("fuse")})").formatted(Formatting.BOLD), true)

                        } else {

                            val newStack = ItemStack(mainStack.item, mainStack.count)
                            newStack.setNbt(mainStack.nbt)
                            player.dropStack(newStack)
                            mainStack.count = 0

                            player.sendMessage(Text.translatable("§6Not enough §cFuse").formatted(Formatting.BOLD), true)

                        }

                    }

                    if (offStack.item == ItemStack(Items.GUNPOWDER).item) {

                        if (mainStack.nbt!!.getFloat("power") < 4.0f) {

                            if (offStack.count >= mainStack.count) {

                                val power = mainStack.nbt!!.getFloat("power")
                                mainStack.nbt!!.putFloat("power", (power + 0.0625f))

                                val newStack = ItemStack(mainStack.item, mainStack.count)
                                newStack.setNbt(mainStack.nbt)

                                offStack.count -= mainStack.count

                                player.dropStack(newStack)
                                mainStack.count = 0

                                player.sendMessage(Text.translatable("§aAdded §60.0625 to power (now ${newStack.nbt!!.getFloat("power")})").formatted(Formatting.BOLD), true)

                            } else {

                                val newStack = ItemStack(mainStack.item, mainStack.count)
                                newStack.setNbt(mainStack.nbt)
                                player.dropStack(newStack)
                                mainStack.count = 0

                                player.sendMessage(Text.translatable("§6Not enough §cGunpowder").formatted(Formatting.BOLD), true)

                            }

                        } else {

                            val newStack = ItemStack(mainStack.item, mainStack.count)
                            newStack.setNbt(mainStack.nbt)

                            player.dropStack(newStack)
                            mainStack.count = 0

                            player.sendMessage(Text.translatable("§eMaximum power reached §6(${newStack.nbt!!.getFloat("power")})").formatted(Formatting.BOLD), true)

                        }

                    }

                    if (offStack.item == ItemStack(Items.AIR).item) {

                        if (world.isClient == true) {

                            player.sendMessage(Text.translatable("§l§e-Item Information-").formatted(Formatting.BOLD), false)
                            player.sendMessage(Text.translatable("§cFuse: ${mainStack.nbt!!.getInt("fuse")}"), false)
                            player.sendMessage(Text.translatable("§6Power: ${mainStack.nbt!!.getFloat("power")}"), false)
                            player.sendMessage(Text.translatable("§dIgnite on Impact: ${mainStack.nbt!!.getBoolean("light_on_impact")}"), false)

                        }

                        val newStack = ItemStack(mainStack.item, mainStack.count)
                        newStack.setNbt(mainStack.nbt)

                        player.dropStack(newStack)
                        mainStack.count = 0

                    }

                }

            }

        }

        return super.useOnBlock(context)
    }*/

}