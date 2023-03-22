package morefirework.mod.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.biome.Biome
import net.minecraft.world.explosion.Explosion
import kotlin.random.Random

class PotassiumBlock(settings: FabricBlockSettings) : Block(settings) {

    override fun precipitationTick(
        state: BlockState?,
        world: World?,
        pos: BlockPos?,
        precipitation: Biome.Precipitation?
    ) {

        if (precipitation == Biome.Precipitation.RAIN) {

            val power = Random.nextDouble(2.0, 6.0)

            world?.createExplosion(null, pos!!.x.toDouble(), pos!!.y.toDouble(),pos!!.z.toDouble(), power.toFloat(), true, Explosion.DestructionType.BREAK)

        } else if (precipitation == Biome.Precipitation.SNOW) {

            world?.createExplosion(null, pos!!.x.toDouble(), pos!!.y.toDouble(),pos!!.z.toDouble(), 2f, true, Explosion.DestructionType.BREAK)

        }

        super.precipitationTick(state, world, pos, precipitation)
    }

    override fun randomTick(
        state: BlockState?,
        world: ServerWorld?,
        pos: BlockPos?,
        random: net.minecraft.util.math.random.Random?
    ) {



        super.randomTick(state, world, pos, random)
    }

}