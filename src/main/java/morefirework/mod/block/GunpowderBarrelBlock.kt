package morefirework.mod.block

import morefirework.mod.MorefireworkMod.Companion.GUNPOWDER_BARREL
import morefirework.mod.entity.GunpowderBarrelEntity
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockRenderType
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World


class GunpowderBarrelBlock(settings: FabricBlockSettings) : Block(settings) {

    override fun getRenderType(state: BlockState?): BlockRenderType? {
        // With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need to change that!
        return BlockRenderType.MODEL
    }

    override fun onPlaced(
        world: World?,
        pos: BlockPos?,
        state: BlockState?,
        placer: LivingEntity?,
        itemStack: ItemStack?
    ) {

        world!!.setBlockState(pos, Blocks.AIR.defaultState)

        var entity = GunpowderBarrelEntity(GUNPOWDER_BARREL, world)

        entity.setPos(pos!!.x.toDouble() + 0.5,pos.y.toDouble(),pos.z.toDouble() + 0.5)

        world?.spawnEntity(entity)

        super.onPlaced(world, pos, state, placer, itemStack)
    }

}