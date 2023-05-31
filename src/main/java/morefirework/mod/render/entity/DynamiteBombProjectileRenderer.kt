package morefirework.mod.render.entity

import morefirework.mod.entity.projectile.DynamiteBombProjectile
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.util.Identifier

@Environment(EnvType.CLIENT)
class DynamiteBombProjectileRenderer(context: EntityRendererFactory.Context?) : FlyingItemEntityRenderer<DynamiteBombProjectile>(context, 2f, false) {

    val TEXTURE = Identifier("textures/entity/projectile/firecracker.png") //does not really matter

    fun getTexture(DynamiteBombProjectile: DynamiteBombProjectile): Identifier? {
        return TEXTURE
    }

}
