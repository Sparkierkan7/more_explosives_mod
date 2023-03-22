package morefirework.mod.render.entity

import morefirework.mod.entity.projectile.FirecrackerProjectile
import morefirework.mod.entity.projectile.GunpowderBombProjectile
import morefirework.mod.entity.projectile.GunpowderShrapnelStickProjectile
import morefirework.mod.entity.projectile.IronShotProjectile
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.util.Identifier

@Environment(EnvType.CLIENT)
class IronShotProjectileRenderer(context: EntityRendererFactory.Context?) : FlyingItemEntityRenderer<IronShotProjectile>(context, 0.75f, false) {

    val TEXTURE = Identifier("textures/entity/projectile/firecracker.png") //does not really matter

    fun getTexture(IronShotProjectile: IronShotProjectile): Identifier? {
        return TEXTURE
    }

}
