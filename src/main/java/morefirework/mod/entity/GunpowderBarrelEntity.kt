package morefirework.mod.entity

import net.minecraft.entity.EntityType
import net.minecraft.entity.mob.PathAwareEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.particle.ParticleTypes
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion


class GunpowderBarrelEntity : PathAwareEntity {

    /*companion object {

        var fuse: TrackedData<Int> = DataTracker.registerData(GunpowderBarrelEntity::class.java, TrackedDataHandlerRegistry.INTEGER)

    }*/

    var fuse = 100
    var primed = false

    constructor(entityType: EntityType<out PathAwareEntity?>?, world: World?) : super(entityType, world) {



    }

    //var primed = false

    /*override fun initDataTracker() {

        dataTracker.startTracking(fuse, 104)

        super.initDataTracker()
    }*/

    /*override fun writeNbt(nbt: NbtCompound): NbtCompound? {

        // Save the current value of the number to the nbt
        nbt.putInt("fuse", dataTracker.get(fuse))
        nbt.putBoolean("primed", primed)
        super.writeNbt(nbt)

        return nbt //????

    }

    override fun readNbt(nbt: NbtCompound?) {

        super.readNbt(nbt)

        fuse = nbt!!.getInt("fuse")
        primed = nbt.getBoolean("primed")

    }*/

    override fun tick() {

        if (primed == true) {

            if (world.isClient) {
                world.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 1, this.getZ(), 0.0, 0.0, 0.0)
            }
            fuse -= 1

            if (fuse == 0) {

                if (!world.isClient) {

                    world.createExplosion(this, pos!!.x, pos.y, pos.z, 6.0f, Explosion.DestructionType.BREAK)
                    this.kill()

                }

            }

        }

        super.tick()
    }

    /*override fun tick() {

        val of = dataTracker.get(fuse)

        dataTracker.set(fuse, of - 1)

        if (dataTracker.get(fuse) == 0) {

            world.createExplosion(this, pos!!.x, pos.y, pos.z, 6.0f, Explosion.DestructionType.BREAK)
            this.kill()

        }

        super.tick()
    }*/

    override fun interactAt(player: PlayerEntity?, hitPos: Vec3d?, hand: Hand?): ActionResult {

        var handStack = player!!.getStackInHand(hand)

        if (handStack.item == ItemStack(Items.FLINT_AND_STEEL).item) {

            this.primed = true
            player.swingHand(hand)

        }

        return super.interactAt(player, hitPos, hand)
    }

}