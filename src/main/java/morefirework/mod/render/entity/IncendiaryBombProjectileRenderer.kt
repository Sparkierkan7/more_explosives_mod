package morefirework.mod.render.entity

import morefirework.mod.entity.projectile.IncendiaryBombProjectile
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.util.Identifier

@Environment(EnvType.CLIENT)
class IncendiaryBombProjectileRenderer(context: EntityRendererFactory.Context?) : FlyingItemEntityRenderer<IncendiaryBombProjectile>(context, 2f, false) {

    val TEXTURE = Identifier("textures/entity/projectile/firecracker.png") //does not really matter

    fun getTexture(IncendiaryBombProjectile: IncendiaryBombProjectile): Identifier? {
        return TEXTURE
    }

}
