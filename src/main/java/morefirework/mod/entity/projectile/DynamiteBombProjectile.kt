package morefirework.mod.entity.projectile

import morefirework.mod.MorefireworkMod.Companion.DynamiteBombEntityType
import morefirework.mod.MorefireworkMod.Companion.LOGGER
import morefirework.mod.item.MorefireworkItems.DYNAMITE_BOMB_ITEM
import net.minecraft.client.MinecraftClient
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.particle.ParticleTypes
import net.minecraft.util.hit.HitResult
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion.DestructionType
import kotlin.random.Random


class DynamiteBombProjectile : ThrownItemEntity {

    var power = 0f
    var fuse = 99999 //large for fix bug
    var ticking = false
    var lightOnImpact = false

    constructor(entityType: EntityType<out ThrownItemEntity?>?, world: World?) : super(entityType, world) {



    }

    constructor(world: World?, owner: LivingEntity, stack: ItemStack?) : super(DynamiteBombEntityType, owner, world) {

        var nbt = owner.mainHandStack.getNbt()

        try {

            //LOGGER.info("${stack}")
            //LOGGER.info("${owner.mainHandStack.getNbt()}")

            this.power = nbt!!.getFloat("power")
            this.fuse = nbt.getInt("fuse")
            this.lightOnImpact = nbt.getBoolean("light_on_impact")

        } catch (e: Throwable) { LOGGER.info("Dynamite bomb get nbt error: ${e}") }

        if (this.lightOnImpact == false) {

            this.ticking = true

        }

        owner.mainHandStack.count -= 1

    }

    constructor(world: World?, x: Double, y: Double, z: Double) : super(DynamiteBombEntityType, x, y, z, world) {



    }

    override fun getDefaultItem(): Item? {

        return DYNAMITE_BOMB_ITEM

    }

    override fun tick() {

        if (this.ticking == true) {

            this.fuse -= 1

        }

        if (this.fuse <= 0) {

            for (s in 0..24) {

                var maxVelocity = 0.0625
                var v = Vec3d(Random.nextDouble(-maxVelocity, maxVelocity), Random.nextDouble(-maxVelocity, maxVelocity) + 0.05, Random.nextDouble(-maxVelocity, maxVelocity))

                if (world.isClient()) {

                    MinecraftClient.getInstance().particleManager.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, this.x, this.y, this.z, v.x, v.y, v.z)

                }

            }

            world.createExplosion(this, this.x, this.y, this.z, this.power, DestructionType.BREAK)
            this.kill()

        }

        super.tick()
    }

    override fun onCollision(hitResult: HitResult?) {

        this.ticking = true

        this.setVelocity(0.0, 0.0, 0.0)
        var pos = this.pos
        this.setPos(pos.x, pos.y + 0.0625, pos.z)

        super.onCollision(hitResult)

    }

}