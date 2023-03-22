package morefirework.mod.render.entity

import morefirework.mod.entity.projectile.*
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.util.Identifier

@Environment(EnvType.CLIENT)
class MusketShotProjectileRenderer(context: EntityRendererFactory.Context?) : FlyingItemEntityRenderer<MusketShotProjectile>(context, 0.75f, false) {

    val TEXTURE = Identifier("textures/entity/projectile/firecracker.png") //does not really matter

    fun getTexture(MusketShotProjectile: MusketShotProjectile): Identifier? {
        return TEXTURE
    }

}
