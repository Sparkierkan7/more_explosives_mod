package morefirework.mod.render.entity

import morefirework.mod.entity.projectile.GunpowderPackProjectile
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.util.Identifier

@Environment(EnvType.CLIENT)
class GunpowderPackProjectileRenderer(context: EntityRendererFactory.Context?) : FlyingItemEntityRenderer<GunpowderPackProjectile>(context, 2f, false) {

    val TEXTURE = Identifier("textures/entity/projectile/firecracker.png") //does not really matter

    fun getTexture(GunpowderPackProjectile: GunpowderPackProjectile): Identifier? {
        return TEXTURE
    }

}
