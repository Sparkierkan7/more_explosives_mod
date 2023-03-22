package morefirework.mod.entity.projectile

import morefirework.mod.MorefireworkMod.Companion.MusketShotEntityType
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.util.hit.EntityHitResult
import net.minecraft.util.hit.HitResult
import net.minecraft.world.World
import kotlin.math.absoluteValue


class MusketShotProjectile : ThrownItemEntity {

    var lifeSpan = 200
    var damage = 0f
    constructor(entityType: EntityType<out ThrownItemEntity?>?, world: World?) : super(entityType, world) {



    }

    constructor(world: World?, owner: LivingEntity, d: Float) : super(MusketShotEntityType, owner, world) {

        this.damage = d

    }

    constructor(world: World?, x: Double, y: Double, z: Double, d: Float) : super(MusketShotEntityType, x, y, z, world) {

        this.damage = d

    }

    override fun getDefaultItem(): Item? {

        return null

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

        entityHitResult!!.entity.damage(DamageSource.thrownProjectile(this, owner), this.damage)

        super.onEntityHit(entityHitResult)
    }

    override fun onCollision(hitResult: HitResult?) {

        this.kill()

        world.sendEntityStatus(this, 3.toByte())
        super.onCollision(hitResult)

    }

}