package morefirework.mod.render.entity

import morefirework.mod.entity.projectile.IronGunpowderBombProjectile
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.util.Identifier

@Environment(EnvType.CLIENT)
class IronGunpowderBombProjectileRenderer(context: EntityRendererFactory.Context?) : FlyingItemEntityRenderer<IronGunpowderBombProjectile>(context, 2f, false) {

    val TEXTURE = Identifier("textures/entity/projectile/firecracker.png") //does not really matter

    fun getTexture(IronGunpowderBombProjectile: IronGunpowderBombProjectile): Identifier? {
        return TEXTURE
    }

}
