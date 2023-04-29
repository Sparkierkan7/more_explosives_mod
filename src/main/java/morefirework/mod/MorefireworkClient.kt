package morefirework.mod

import morefirework.mod.MorefireworkMod.Companion.FirePasteEntityType
import morefirework.mod.MorefireworkMod.Companion.FirecrackerEntityType
import morefirework.mod.MorefireworkMod.Companion.GunpowderBombEntityType
import morefirework.mod.MorefireworkMod.Companion.GunpowderPackEntityType
import morefirework.mod.MorefireworkMod.Companion.GunpowderShrapnelStickEntityType
import morefirework.mod.MorefireworkMod.Companion.IncendiaryBombEntityType
import morefirework.mod.MorefireworkMod.Companion.IncendiaryPackEntityType
import morefirework.mod.MorefireworkMod.Companion.IronShotEntityType
import morefirework.mod.MorefireworkMod.Companion.MusketShotEntityType
import morefirework.mod.render.entity.*
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.minecraft.client.MinecraftClient
import net.minecraft.client.option.KeyBinding
import org.slf4j.LoggerFactory


class MorefireworkClient : ClientModInitializer {

    companion object {

        var LOGGER = LoggerFactory.getLogger("morefirework")

    }

    override fun onInitializeClient() {

        EntityRendererRegistry.register(FirecrackerEntityType, ::FirecrackerProjectileRenderer)
        EntityRendererRegistry.register(GunpowderBombEntityType, ::GunpowderBombProjectileRenderer)
        EntityRendererRegistry.register(IncendiaryBombEntityType, ::IncendiaryBombProjectileRenderer)
        EntityRendererRegistry.register(IncendiaryPackEntityType, ::IncendiaryPackProjectileRenderer)
        EntityRendererRegistry.register(FirePasteEntityType, ::FirePasteProjectileRenderer)
        EntityRendererRegistry.register(GunpowderPackEntityType, ::GunpowderPackProjectileRenderer)
        EntityRendererRegistry.register(GunpowderShrapnelStickEntityType, ::GunpowderShrapnelStickProjectileRenderer)
        EntityRendererRegistry.register(IronShotEntityType, ::IronShotProjectileRenderer)
        EntityRendererRegistry.register(MusketShotEntityType, ::MusketShotProjectileRenderer)

    }

}
