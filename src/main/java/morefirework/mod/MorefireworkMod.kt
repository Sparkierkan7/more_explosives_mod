package morefirework.mod

import morefirework.mod.block.MoreFireworkBlocks.FIREWORK_STATION_BLOCK
import morefirework.mod.block.MoreFireworkBlocks.LEAD_ORE_BLOCK
import morefirework.mod.block.MoreFireworkBlocks.POTASSIUM_BLOCK
import morefirework.mod.block.MoreFireworkBlocks.SULFUR_BLOCK
import morefirework.mod.entity.projectile.*
import morefirework.mod.item.MorefireworkItems
import morefirework.mod.item.MorefireworkItems.ASH_ITEM
import morefirework.mod.item.MorefireworkItems.DENSE_PAPER_ITEM
import morefirework.mod.item.MorefireworkItems.FIRECRACKER_ITEM
import morefirework.mod.item.MorefireworkItems.FUSE_ITEM
import morefirework.mod.item.MorefireworkItems.GUNPOWDER_BOMB_ITEM
import morefirework.mod.item.MorefireworkItems.GUNPOWDER_PACK_ITEM
import morefirework.mod.item.MorefireworkItems.GUNPOWDER_SHRAPNEL_STICK_ITEM
import morefirework.mod.item.MorefireworkItems.IRON_SHOT_ITEM
import morefirework.mod.item.MorefireworkItems.LEAD_INGOT_ITEM
import morefirework.mod.item.MorefireworkItems.POTASSIUM_INGOT_ITEM
import morefirework.mod.item.MorefireworkItems.POTASSIUM_POWDER_ITEM
import morefirework.mod.item.MorefireworkItems.PURE_POTASH_ITEM
import morefirework.mod.item.MorefireworkItems.RAW_LEAD_ITEM
import morefirework.mod.item.MorefireworkItems.SHORT_MUSKET_ITEM
import morefirework.mod.item.MorefireworkItems.SULFUR_CHUNK_ITEM
import morefirework.mod.item.MorefireworkItems.WATER_ASH_SOLUTION_BUCKET_ITEM
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry
import net.minecraft.block.Block
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.slf4j.LoggerFactory


class MorefireworkMod : ModInitializer {

    companion object {

        val modid = "morefirework"

        // This logger is used to write text to the console and the log file.
        // It is considered best practice to use your mod id as the logger's name.
        // That way, it's clear which mod wrote info, warnings, and errors.
        var LOGGER = LoggerFactory.getLogger("morefirework")

        val FirecrackerEntityType: EntityType<FirecrackerProjectile> = Registry.register<EntityType<*>, EntityType<FirecrackerProjectile>>(
            Registry.ENTITY_TYPE,
            Identifier(modid, "firecracker_projectile"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ::FirecrackerProjectile)
                .dimensions(EntityDimensions.changing(1f, 1f))
                .trackRangeBlocks(128).trackedUpdateRate(10)
                .build()
        )

        val GunpowderBombEntityType: EntityType<GunpowderBombProjectile> = Registry.register<EntityType<*>, EntityType<GunpowderBombProjectile>>(
            Registry.ENTITY_TYPE,
            Identifier(modid, "gunpowder_bomb_projectile"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ::GunpowderBombProjectile)
                .dimensions(EntityDimensions.changing(0.5f, 0.5f))
                .trackRangeBlocks(128).trackedUpdateRate(10)
                .build()
        )

        val GunpowderPackEntityType: EntityType<GunpowderPackProjectile> = Registry.register<EntityType<*>, EntityType<GunpowderPackProjectile>>(
            Registry.ENTITY_TYPE,
            Identifier(modid, "gunpowder_pack_projectile"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ::GunpowderPackProjectile)
                .dimensions(EntityDimensions.changing(0.5f, 0.5f))
                .trackRangeBlocks(128).trackedUpdateRate(10)
                .build()
        )

        val GunpowderShrapnelStickEntityType: EntityType<GunpowderShrapnelStickProjectile> = Registry.register<EntityType<*>, EntityType<GunpowderShrapnelStickProjectile>>(
            Registry.ENTITY_TYPE,
            Identifier(modid, "gunpowder_shrapnel_stick_projectile"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ::GunpowderShrapnelStickProjectile)
                .dimensions(EntityDimensions.changing(0.5f, 0.5f))
                .trackRangeBlocks(128).trackedUpdateRate(10)
                .build()
        )

        val IronShotEntityType: EntityType<IronShotProjectile> = Registry.register<EntityType<*>, EntityType<IronShotProjectile>>(
            Registry.ENTITY_TYPE,
            Identifier(modid, "iron_shot_projectile"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ::IronShotProjectile)
                .dimensions(EntityDimensions.changing(1f, 1f))
                .trackRangeBlocks(128).trackedUpdateRate(10)
                .build()
        )

        val MusketShotEntityType: EntityType<MusketShotProjectile> = Registry.register<EntityType<*>, EntityType<MusketShotProjectile>>(
            Registry.ENTITY_TYPE,
            Identifier(modid, "musket_shot_projectile"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ::MusketShotProjectile)
                .dimensions(EntityDimensions.changing(1f, 1f))
                .trackRangeBlocks(128).trackedUpdateRate(10)
                .build()
        )

        /*public fun itemTooltipCallback() {

            ItemTooltipCallback.EVENT.register(ItemTooltipCallback { stack: ItemStack, context: TooltipContext?, lines: MutableList<Text?> ->
                if (stack.item === GUNPOWDER_SHRAPNEL_STICK_ITEM) {
                    val nbtData = stack.nbt
                    if (nbtData != null) {

                        lines.clear()

                        lines.add(Text.translatable("§cFuse: ${stack?.nbt?.getInt("fuse")}"));
                        lines.add(Text.translatable("§6Shrapnel Count: ${stack?.nbt?.getInt("shrapnel")}"));
                        lines.add(Text.translatable("§dLight on Impact: ${stack?.nbt?.getBoolean("light_on_impact")}"))

                    }
                }
            })

        }*/

    }

    override fun onInitialize() {

        //items
        Registry.register(Registry.ITEM, Identifier("morefirework", "firecracker"), FIRECRACKER_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "gunpowder_bomb"), GUNPOWDER_BOMB_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "gunpowder_shrapnel_stick"), GUNPOWDER_SHRAPNEL_STICK_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "gunpowder_pack"), GUNPOWDER_PACK_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "iron_shot"), IRON_SHOT_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "fuse"), FUSE_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "short_musket"), SHORT_MUSKET_ITEM)

        Registry.register(Registry.ITEM, Identifier("morefirework", "raw_lead"), RAW_LEAD_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "lead_ingot"), LEAD_INGOT_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "potassium_ingot"), POTASSIUM_INGOT_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "potassium_powder"), POTASSIUM_POWDER_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "pure_potash"), PURE_POTASH_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "ash"), ASH_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "water_ash_solution_bucket"), WATER_ASH_SOLUTION_BUCKET_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "sulfur_chunk"), SULFUR_CHUNK_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "dense_paper"), DENSE_PAPER_ITEM)


        //blocks
        Registry.register<Block, Block>(Registry.BLOCK, Identifier(modid, "lead_ore"), LEAD_ORE_BLOCK)

        Registry.register<Block, Block>(Registry.BLOCK, Identifier(modid, "potassium_block"), POTASSIUM_BLOCK)
        Registry.register<Block, Block>(Registry.BLOCK, Identifier(modid, "sulfur_block"), SULFUR_BLOCK)

        Registry.register<Block, Block>(Registry.BLOCK, Identifier(modid, "firework_station"), FIREWORK_STATION_BLOCK)

        //flammable blocks
        FlammableBlockRegistry.getDefaultInstance().add(POTASSIUM_BLOCK, 400, 450)
        FlammableBlockRegistry.getDefaultInstance().add(SULFUR_BLOCK, 1, 50)

        //block items
        Registry.register(
            Registry.ITEM,
            Identifier(modid, "potassium_block"),
            BlockItem(POTASSIUM_BLOCK, FabricItemSettings())
        )
        Registry.register(
            Registry.ITEM,
            Identifier(modid, "sulfur_block"),
            BlockItem(SULFUR_BLOCK, FabricItemSettings())
        )
        Registry.register(
            Registry.ITEM,
            Identifier(modid, "firework_station_block"),
            BlockItem(FIREWORK_STATION_BLOCK, FabricItemSettings().group(ItemGroup.DECORATIONS))
        )

    }

}