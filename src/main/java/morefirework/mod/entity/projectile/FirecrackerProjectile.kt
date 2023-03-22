package morefirework.mod.entity.projectile

import morefirework.mod.MorefireworkMod.Companion.FirecrackerEntityType
import morefirework.mod.MorefireworkMod.Companion.LOGGER
import morefirework.mod.item.MorefireworkItems.FIRECRACKER_ITEM
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.hit.HitResult
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion.DestructionType


class FirecrackerProjectile : ThrownItemEntity {

    var power = 0f

    constructor(entityType: EntityType<out ThrownItemEntity?>?, world: World?) : super(entityType, world) {



    }

    constructor(world: World?, owner: LivingEntity, stack: ItemStack?) : super(FirecrackerEntityType, owner, world) {

        var nbt = owner.mainHandStack.getNbt()

        try {

            LOGGER.info("${stack}")
            LOGGER.info("${owner.mainHandStack.getNbt()}")

            this.power = nbt!!.getFloat("power")

        } catch (e: Throwable) { LOGGER.info("${e}") }

        owner.mainHandStack.count -= 1

    }

    constructor(world: World?, x: Double, y: Double, z: Double) : super(FirecrackerEntityType, x, y, z, world) {



    }

    override fun getDefaultItem(): Item? {

        return FIRECRACKER_ITEM

    }

    override fun onCollision(hitResult: HitResult?) {

        world.createExplosion(this, this.x, this.y, this.z, this.power, DestructionType.BREAK)

        world.sendEntityStatus(this, 3.toByte())
        kill()

        super.onCollision(hitResult)

    }

}