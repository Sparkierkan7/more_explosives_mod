package morefirework.mod.block.entity

import morefirework.mod.MorefireworkMod
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.network.Packet
import net.minecraft.network.listener.ClientPlayPacketListener
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket
import net.minecraft.util.math.BlockPos


//this is useless just ignore.
class GunpowderBarrelBlockEntity(pos: BlockPos?, state: BlockState?) :
    BlockEntity(MorefireworkMod.GUNPOWDER_BARREL_BLOCK_ENTITY, pos, state) {

    var fuse = 125
    var primed = false

    // Serialize the BlockEntity
    public override fun writeNbt(nbt: NbtCompound) {

        // Save the current value of the number to the nbt
        nbt.putInt("fuse", fuse)
        nbt.putBoolean("primed", primed)
        super.writeNbt(nbt)

    }

    override fun readNbt(nbt: NbtCompound?) {

        super.readNbt(nbt)

        fuse = nbt!!.getInt("fuse")
        primed = nbt.getBoolean("primed")

    }

    override fun toUpdatePacket(): Packet<ClientPlayPacketListener?>? {
        return BlockEntityUpdateS2CPacket.create(this)
    }

    override fun toInitialChunkDataNbt(): NbtCompound? {
        return createNbt()
    }

}