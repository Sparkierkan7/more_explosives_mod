package morefirework.mod.entity.projectile

import morefirework.mod.MorefireworkMod.Companion.GunpowderDepthChargeEntityType
import morefirework.mod.MorefireworkMod.Companion.LOGGER
import morefirework.mod.item.MorefireworkItems.GUNPOWDER_DEPTH_CHARGE_ITEM
import net.minecraft.block.Blocks
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.hit.HitResult
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion.DestructionType


class GunpowderDepthChargeProjectile : ThrownItemEntity {

    var power = 0f
    var fuse = 99999 //large for fix bug
    var ticking = false
    var lightOnImpact = false

    constructor(entityType: EntityType<out ThrownItemEntity?>?, world: World?) : super(entityType, world) {



    }

    constructor(world: World?, owner: LivingEntity, stack: ItemStack?) : super(GunpowderDepthChargeEntityType, owner, world) {

        var nbt = owner.mainHandStack.getNbt()

        try {

            this.power = nbt!!.getFloat("power")
            this.fuse = nbt.getInt("fuse")
            this.lightOnImpact = nbt.getBoolean("light_on_impact")

        } catch (e: Throwable) { LOGGER.info("iron gunpowder bomb get nbt error: ${e}") }

        if (this.lightOnImpact == false) {

            this.ticking = true

        }

        owner.mainHandStack.count -= 1

    }

    constructor(world: World?, x: Double, y: Double, z: Double) : super(GunpowderDepthChargeEntityType, x, y, z, world) {



    }

    override fun getDefaultItem(): Item? {

        return GUNPOWDER_DEPTH_CHARGE_ITEM

    }

    override fun tick() {

        if (this.ticking == true) {

            this.fuse -= 1

        }

        if (this.fuse <= 0) {

            if (world.getBlockState(this.blockPos) == Blocks.AIR.defaultState) {

                world.createExplosion(this, this.x, this.y, this.z, this.power - 2, DestructionType.BREAK)
                this.kill()

            } else {

                world.setBlockState(this.blockPos, Blocks.AIR.defaultState)

                world.createExplosion(this, this.x, this.y, this.z, this.power, DestructionType.BREAK)
                this.kill()

            }

        }

        super.tick()
    }

    override fun onCollision(hitResult: HitResult?) {

        //world.createExplosion(this, this.x, this.y, this.z, this.power, DestructionType.BREAK)

        this.ticking = true

        //this.setNoGravity(true)
        this.setVelocity(0.0, 0.0, 0.0)
        var pos = this.pos
        this.setPos(pos.x, pos.y + 0.0625, pos.z)

        //world.sendEntityStatus(this, 3.toByte())

        super.onCollision(hitResult)

    }

}