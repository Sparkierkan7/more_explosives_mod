package morefirework.mod.item

import morefirework.mod.block.MoreFireworkBlocks
import morefirework.mod.entity.projectile.IncendiaryBombProjectile
import morefirework.mod.util.Math.setShootVelocity
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.item.Items
import net.minecraft.nbt.NbtCompound
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.Formatting
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class IncendiaryBombItem : Item {

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

            var shot = setShootVelocity(user!!.pitch, user.yaw, 0f, 1.25)
            var entity = IncendiaryBombProjectile(world, user as LivingEntity, stack)
            entity.setVelocity(shot)

            world?.spawnEntity(entity)

            user.itemCooldownManager[this] = 20

        }

        return super.use(world, user, hand)

    }

    override fun onCraft(stack: ItemStack?, world: World?, player: PlayerEntity?) {

        if (stack?.nbt?.getBoolean("tooltip_nbt") == null || stack.nbt?.getBoolean("tooltip_nbt") == true) {

            var nbt = NbtCompound()
            nbt.putInt("shrapnel", 64)
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
            nbt.putInt("shrapnel", 64)
            nbt.putInt("fuse", 75)
            nbt.putBoolean("light_on_impact", false)
            nbt.putBoolean("tooltip_nbt", true)

            stack?.setNbt(nbt)

        }

        super.appendTooltip(stack, world, tooltip, context)
    }

    override fun useOnBlock(context: ItemUsageContext?): ActionResult {

        var world = context!!.world
        var player = context!!.player

        if (world.getBlockState(context.blockPos) == MoreFireworkBlocks.FIREWORK_STATION_BLOCK.defaultState) {

            var mainStack = player!!.inventory.mainHandStack
            var offStack = player.offHandStack

            if (context.hand == Hand.MAIN_HAND) {

                if (mainStack.item == ItemStack(MorefireworkItems.INCENDIARY_BOMB_ITEM).item) {

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

                        if (fuse > 15) {

                            mainStack.nbt!!.putInt("fuse", (fuse - 5))

                            if (fuse <= 20) {

                                mainStack.nbt!!.putBoolean("light_on_impact", false)

                            }

                            val newStack = ItemStack(mainStack.item, mainStack.count)
                            newStack.setNbt(mainStack.nbt)

                            player.dropStack(newStack)
                            mainStack.count = 0

                            player.sendMessage(Text.translatable("§eRemoved §65 ticks from fuse (now ${newStack.nbt!!.getInt("fuse")})").formatted(Formatting.BOLD), true)

                        } else if (fuse <= 15) {

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

                    if (offStack.item == ItemStack(Items.AIR).item) {

                        if (world.isClient == true) {

                            player.sendMessage(Text.translatable("§l§e-Item Information-").formatted(Formatting.BOLD), false)
                            player.sendMessage(Text.translatable("§cFuse: ${mainStack.nbt!!.getInt("fuse")}"), false)
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
    }

}