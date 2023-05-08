package morefirework.mod.render.entity

import morefirework.mod.MorefireworkClient
import morefirework.mod.entity.GunpowderBarrelEntity
import morefirework.mod.render.entity.model.GunpowderBarrelEntityModel
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.util.Identifier


class GunpowderBarrelEntityRenderer(context: EntityRendererFactory.Context) :
    MobEntityRenderer<GunpowderBarrelEntity?, GunpowderBarrelEntityModel?>(
        context,
        GunpowderBarrelEntityModel(context.getPart(MorefireworkClient.MODEL_GUNPOWDER_BARREL_LAYER)),
        0.1f
    ) {

    override fun getTexture(entity: GunpowderBarrelEntity?): Identifier {
        return Identifier("morefirework", "textures/entity/gunpowder_barrel.png")
    }

}


/*    */