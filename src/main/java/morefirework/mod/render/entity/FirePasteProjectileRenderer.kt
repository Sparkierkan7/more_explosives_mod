package morefirework.mod.render.entity

import morefirework.mod.entity.projectile.FirePasteProjectile
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.util.Identifier

@Environment(EnvType.CLIENT)
class FirePasteProjectileRenderer(context: EntityRendererFactory.Context?) : FlyingItemEntityRenderer<FirePasteProjectile>(context, 1.75f, true) {

    val TEXTURE = Identifier("textures/entity/projectile/firecracker.png") //does not really matter

    fun getTexture(FirePasteProjectile: FirePasteProjectile): Identifier? {
        return TEXTURE
    }

}
