package morefirework.mod.render.entity

import morefirework.mod.entity.projectile.DynamitePackProjectile
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.util.Identifier

@Environment(EnvType.CLIENT)
class DynamitePackProjectileRenderer(context: EntityRendererFactory.Context?) : FlyingItemEntityRenderer<DynamitePackProjectile>(context, 2f, false) {

    val TEXTURE = Identifier("textures/entity/projectile/firecracker.png") //does not really matter

    fun getTexture(DynamitePackProjectile: DynamitePackProjectile): Identifier? {
        return TEXTURE
    }

}
