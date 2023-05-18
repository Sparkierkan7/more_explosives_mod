package morefirework.mod

import morefirework.mod.MorefireworkMod.Companion.FirePasteEntityType
import morefirework.mod.MorefireworkMod.Companion.FirecrackerEntityType
import morefirework.mod.MorefireworkMod.Companion.GunpowderBombEntityType
import morefirework.mod.MorefireworkMod.Companion.GunpowderDepthChargeEntityType
import morefirework.mod.MorefireworkMod.Companion.GunpowderPackEntityType
import morefirework.mod.MorefireworkMod.Companion.GunpowderShrapnelStickEntityType
import morefirework.mod.MorefireworkMod.Companion.IncendiaryBombEntityType
import morefirework.mod.MorefireworkMod.Companion.IncendiaryPackEntityType
import morefirework.mod.MorefireworkMod.Companion.IronGunpowderBombEntityType
import morefirework.mod.MorefireworkMod.Companion.IronShotEntityType
import morefirework.mod.MorefireworkMod.Companion.MusketShotEntityType
import morefirework.mod.render.entity.*
import morefirework.mod.render.entity.model.GunpowderBarrelEntityModel
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.util.Identifier


class MorefireworkClient : ClientModInitializer {

    companion object {

        val MODEL_GUNPOWDER_BARREL_LAYER = EntityModelLayer(Identifier("morefirework", "gunpowder_barrel"), "main")

    }

    override fun onInitializeClient() {

        //entity
        EntityRendererRegistry.register(MorefireworkMod.GUNPOWDER_BARREL,
            EntityRendererFactory { context: EntityRendererFactory.Context ->
                GunpowderBarrelEntityRenderer(
                    context
                )
            })

        //projectile
        EntityRendererRegistry.register(FirecrackerEntityType, ::FirecrackerProjectileRenderer)
        EntityRendererRegistry.register(GunpowderBombEntityType, ::GunpowderBombProjectileRenderer)
        EntityRendererRegistry.register(IronGunpowderBombEntityType, ::IronGunpowderBombProjectileRenderer)
        EntityRendererRegistry.register(GunpowderDepthChargeEntityType, ::GunpowderDepthChargeProjectileRenderer)
        EntityRendererRegistry.register(IncendiaryBombEntityType, ::IncendiaryBombProjectileRenderer)
        EntityRendererRegistry.register(IncendiaryPackEntityType, ::IncendiaryPackProjectileRenderer)
        EntityRendererRegistry.register(FirePasteEntityType, ::FirePasteProjectileRenderer)
        EntityRendererRegistry.register(GunpowderPackEntityType, ::GunpowderPackProjectileRenderer)
        EntityRendererRegistry.register(GunpowderShrapnelStickEntityType, ::GunpowderShrapnelStickProjectileRenderer)
        EntityRendererRegistry.register(IronShotEntityType, ::IronShotProjectileRenderer)
        EntityRendererRegistry.register(MusketShotEntityType, ::MusketShotProjectileRenderer)

        //???
        EntityModelLayerRegistry.registerModelLayer(MODEL_GUNPOWDER_BARREL_LAYER, GunpowderBarrelEntityModel::getTexturedModelData);

    }

}
