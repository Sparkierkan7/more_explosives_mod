package morefirework.mod.entity.projectile

import morefirework.mod.MorefireworkMod.Companion.IronShotEntityType
import morefirework.mod.item.MorefireworkItems.IRON_SHOT_ITEM
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.util.hit.EntityHitResult
import net.minecraft.util.hit.HitResult
import net.minecraft.world.World
import kotlin.math.absoluteValue


class IronShotProjectile : ThrownItemEntity {

    var lifeSpan = 20
    var source = ""

    constructor(entityType: EntityType<out ThrownItemEntity?>?, world: World?) : super(entityType, world) {



    }

    constructor(world: World?, owner: LivingEntity) : super(IronShotEntityType, owner, world) {



    }

    constructor(world: World?, x: Double, y: Double, z: Double) : super(IronShotEntityType, x, y, z, world) {



    }

    override fun getDefaultItem(): Item? {

        return IRON_SHOT_ITEM

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

        this.kill()

        world.sendEntityStatus(this, 3.toByte())
        super.onCollision(hitResult)

    }

}