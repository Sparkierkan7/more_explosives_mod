package morefirework.mod.entity.projectile

import morefirework.mod.MorefireworkMod.Companion.IncendiaryBombEntityType
import morefirework.mod.MorefireworkMod.Companion.LOGGER
import morefirework.mod.item.MorefireworkItems.INCENDIARY_BOMB_ITEM
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.hit.HitResult
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion.DestructionType
import kotlin.random.Random


class IncendiaryBombProjectile : ThrownItemEntity {

    var shrapnel = 0
    var fuse = 99999 //large for fix bug, move along
    var ticking = false
    var lightOnImpact = false

    constructor(entityType: EntityType<out ThrownItemEntity?>?, world: World?) : super(entityType, world) {



    }

    constructor(world: World?, owner: LivingEntity, stack: ItemStack?) : super(IncendiaryBombEntityType, owner, world) {

        var nbt = owner.mainHandStack.getNbt()

        try {

            this.shrapnel = nbt!!.getInt("shrapnel")
            this.fuse = nbt.getInt("fuse")
            this.lightOnImpact = nbt.getBoolean("light_on_impact")

        } catch (e: Throwable) { LOGGER.info("Incendiary bomb projectile get nbt error: ${e}") }

        owner.mainHandStack.count -= 1

        if (this.lightOnImpact == false) {

            this.ticking = true

        }

    }

    constructor(world: World?, x: Double, y: Double, z: Double) : super(IncendiaryBombEntityType, x, y, z, world) {



    }

    override fun getDefaultItem(): Item? {

        return INCENDIARY_BOMB_ITEM

    }

    override fun tick() {

        if (this.ticking == true) {

            this.fuse -= 1

        }

        if (this.fuse <= 0) {

            for (s in 0..shrapnel) {

                var maxVelocity = 0.25
                var maxDist = 3.0
                var Velocity = Vec3d(Random.nextDouble(-maxVelocity, maxVelocity), -0.0, Random.nextDouble(-maxVelocity, maxVelocity))
                var pos = Vec3d(Random.nextDouble(-maxDist, maxDist), Random.nextDouble(-maxDist, maxDist), Random.nextDouble(-maxDist, maxDist))
                var shrapnelEntity = FirePasteProjectile(this.world, this.pos.x + pos.x, this.pos.y + pos.y, this.pos.z + pos.z)

                shrapnelEntity.setVelocity(Velocity)

                world.spawnEntity(shrapnelEntity)

            }

            world.createExplosion(this, this.x, this.y, this.z, 1f, DestructionType.NONE)
            this.kill()

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