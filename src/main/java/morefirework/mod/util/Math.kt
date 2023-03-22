package morefirework.mod.util

import net.minecraft.util.math.MathHelper
import net.minecraft.util.math.Vec3d

object Math {

    fun setShootVelocity(pitch: Float, yaw: Float, roll: Float, multiplyer: Double): Vec3d {

        var shot: Vec3d = Vec3d(0.0,0.0,0.0)

        val f = -MathHelper.sin(yaw * 0.017453292f) * MathHelper.cos(pitch * 0.017453292f)
        val g = -MathHelper.sin((pitch + roll) * 0.017453292f)
        val h = MathHelper.cos(yaw * 0.017453292f) * MathHelper.cos(pitch * 0.017453292f)
        shot = Vec3d(f.toDouble()*multiplyer, g.toDouble()*multiplyer, h.toDouble()*multiplyer)
        return shot

    }

}