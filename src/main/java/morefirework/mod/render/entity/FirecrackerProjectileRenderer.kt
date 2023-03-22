package morefirework.mod.render.entity

import morefirework.mod.entity.projectile.FirecrackerProjectile
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.util.Identifier

@Environment(EnvType.CLIENT)
class FirecrackerProjectileRenderer(context: EntityRendererFactory.Context?) : FlyingItemEntityRenderer<FirecrackerProjectile>(context, 1f, true) {

    val TEXTURE = Identifier("textures/entity/projectile/firecracker.png")

    fun getTexture(FirecrackerProjectile: FirecrackerProjectile): Identifier? {
        return TEXTURE
    }

}
