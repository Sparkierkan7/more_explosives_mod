package morefirework.mod

import morefirework.mod.MorefireworkMod.Companion.FirecrackerEntityType
import morefirework.mod.MorefireworkMod.Companion.GunpowderBombEntityType
import morefirework.mod.MorefireworkMod.Companion.GunpowderPackEntityType
import morefirework.mod.MorefireworkMod.Companion.GunpowderShrapnelStickEntityType
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

        var airJumpKey: KeyBinding? = null
        var dashKey: KeyBinding? = null

    }

    override fun onInitializeClient() {

        EntityRendererRegistry.register(FirecrackerEntityType, ::FirecrackerProjectileRenderer)
        EntityRendererRegistry.register(GunpowderBombEntityType, ::GunpowderBombProjectileRenderer)
        EntityRendererRegistry.register(GunpowderPackEntityType, ::GunpowderPackProjectileRenderer)
        EntityRendererRegistry.register(GunpowderShrapnelStickEntityType, ::GunpowderShrapnelStickProjectileRenderer)
        EntityRendererRegistry.register(IronShotEntityType, ::IronShotProjectileRenderer)
        EntityRendererRegistry.register(MusketShotEntityType, ::MusketShotProjectileRenderer)

        //LOGGER.info("client init")

        /*airJumpKey = KeyBindingHelper.registerKeyBinding(KeyBinding(

            "Air Jump",  // The translation key of the keybinding's name
            InputUtil.Type.KEYSYM,  // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
            GLFW.GLFW_KEY_R,  // The keycode of the key
            "Secret hacks" // The translation key of the keybinding's category.

        ))

        dashKey = KeyBindingHelper.registerKeyBinding(KeyBinding(

            "Dash",  // The translation key of the keybinding's name
            InputUtil.Type.KEYSYM,  // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
            GLFW.GLFW_KEY_R,  // The keycode of the key
            "Secret hacks" // The translation key of the keybinding's category.

        ))*/

        ClientTickEvents.END_CLIENT_TICK.register(ClientTickEvents.EndTick { client: MinecraftClient ->

            /*while (airJumpKey!!.wasPressed()) {

                var player = MinecraftClient.getInstance().player!!

                var velocity = player.velocity
                player.setVelocity(velocity.x, 1.5, velocity.z)

                //client.player!!.sendMessage(Text.literal("YEET ${player.velocity.y}"), false)

            }

            while (dashKey!!.wasPressed()) {

                var nethandler: ClientPlayNetworkHandler = MinecraftClient.getInstance().networkHandler!!
                var player = MinecraftClient.getInstance().player!!

                //nethandler.sendPacket(PlayerInteractEntityC2SPacket.attack(player, player.isSneaking()))

                var dashv = player.velocity

                dashv = setShootVelocity(player.pitch, player.yaw, 0f, 1.5)

                player.setVelocity(dashv)

            }*/

        })

    }

}