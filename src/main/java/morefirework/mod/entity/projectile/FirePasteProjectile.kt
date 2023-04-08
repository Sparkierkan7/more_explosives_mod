package morefirework.mod.entity.projectile

import morefirework.mod.MorefireworkMod.Companion.FirePasteEntityType
import morefirework.mod.item.MorefireworkItems.FIRE_ITEM
import net.minecraft.block.Blocks
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.util.hit.EntityHitResult
import net.minecraft.util.hit.HitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import kotlin.math.absoluteValue


class FirePasteProjectile : ThrownItemEntity {

    var lifeSpan = 80
    var source = ""

    constructor(entityType: EntityType<out ThrownItemEntity?>?, world: World?) : super(entityType, world) {



    }

    constructor(world: World?, owner: LivingEntity) : super(FirePasteEntityType, owner, world) {



    }

    constructor(world: World?, x: Double, y: Double, z: Double) : super(FirePasteEntityType, x, y, z, world) {



    }

    override fun getDefaultItem(): Item? {

        return FIRE_ITEM

    }

    override fun tick() {

        this.lifeSpan -= 1

        if (this.lifeSpan <= 0) {

            this.kill()

        }

        super.tick()
    }

    override fun onEntityHit(entityHitResult: EntityHitResult?) {

        var totalVelocity = (this.velocity.x.absoluteValue + this.velocity.y.absoluteValue + this.velocity.z.absoluteValue)

        entityHitResult!!.entity.damage(DamageSource.thrownProjectile(this, owner), totalVelocity.toFloat())

        super.onEntityHit(entityHitResult)

    }

    override fun onCollision(hitResult: HitResult?) {

        if (world.getBlockState(BlockPos(this.blockPos.x, this.blockPos.y - 1, this.blockPos.z)) != Blocks.AIR.defaultState) {

            var block = world.getBlockState(BlockPos(this.blockPos.x, this.blockPos.y, this.blockPos.z))

            if (block == Blocks.AIR.defaultState || block == Blocks.GRASS.defaultState || block == Blocks.TALL_GRASS.defaultState || block == Blocks.SNOW.defaultState || block == Blocks.WHEAT.defaultState || block == Blocks.DEAD_BUSH.defaultState) {

                world.setBlockState(this.blockPos, Blocks.FIRE.defaultState)

            }

            if (block == Blocks.FARMLAND.defaultState || block == Blocks.DIRT_PATH.defaultState) {

                world.setBlockState(this.blockPos, Blocks.DIRT.defaultState)
                world.setBlockState(BlockPos(this.blockPos.x, this.blockPos.y + 1, this.blockPos.z), Blocks.FIRE.defaultState)

            }

        }

        this.kill()

        world.sendEntityStatus(this, 3.toByte())
        super.onCollision(hitResult)

    }

}