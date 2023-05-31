package morefirework.mod

import morefirework.mod.block.MoreFireworkBlocks.FIREWORK_STATION_BLOCK
import morefirework.mod.block.MoreFireworkBlocks.GUNPOWDER_BARREL_BLOCK
import morefirework.mod.block.MoreFireworkBlocks.LEAD_ORE_BLOCK
import morefirework.mod.block.MoreFireworkBlocks.POTASSIUM_BLOCK
import morefirework.mod.block.MoreFireworkBlocks.SULFUR_BLOCK
import morefirework.mod.block.MoreFireworkBlocks.SULFUR_ORE_BLOCK
import morefirework.mod.block.entity.GunpowderBarrelBlockEntity
import morefirework.mod.entity.GunpowderBarrelEntity
import morefirework.mod.entity.projectile.*
import morefirework.mod.item.MorefireworkItems.ASH_ITEM
import morefirework.mod.item.MorefireworkItems.BEESWAX_FIRE_STARTER_ITEM
import morefirework.mod.item.MorefireworkItems.CAST_IRON_GUNPOWDER_BOMB_ITEM
import morefirework.mod.item.MorefireworkItems.COPPER_MUSKET_CARTRIDGE_ITEM
import morefirework.mod.item.MorefireworkItems.COPPER_SHOT_ITEM
import morefirework.mod.item.MorefireworkItems.DENSE_PAPER_ITEM
import morefirework.mod.item.MorefireworkItems.DYNAMITE_BOMB_ITEM
import morefirework.mod.item.MorefireworkItems.DYNAMITE_ITEM
import morefirework.mod.item.MorefireworkItems.DYNAMITE_PACK_ITEM
import morefirework.mod.item.MorefireworkItems.EXPLOSIVE_MIXTURE_ITEM
import morefirework.mod.item.MorefireworkItems.FIRECRACKER_ITEM
import morefirework.mod.item.MorefireworkItems.FIRE_ITEM
import morefirework.mod.item.MorefireworkItems.FIRE_PASTE_ITEM
import morefirework.mod.item.MorefireworkItems.FUSE_ITEM
import morefirework.mod.item.MorefireworkItems.GUNPOWDER_BOMB_ITEM
import morefirework.mod.item.MorefireworkItems.GUNPOWDER_DEPTH_CHARGE_ITEM
import morefirework.mod.item.MorefireworkItems.GUNPOWDER_PACK_ITEM
import morefirework.mod.item.MorefireworkItems.GUNPOWDER_SHRAPNEL_STICK_ITEM
import morefirework.mod.item.MorefireworkItems.INCENDIARY_BOMB_ITEM
import morefirework.mod.item.MorefireworkItems.INCENDIARY_PACK_ITEM
import morefirework.mod.item.MorefireworkItems.IRON_MUSKET_CARTRIDGE_ITEM
import morefirework.mod.item.MorefireworkItems.IRON_SHOT_ITEM
import morefirework.mod.item.MorefireworkItems.MUSKET_RAM_ROD
import morefirework.mod.item.MorefireworkItems.POTASSIUM_INGOT_ITEM
import morefirework.mod.item.MorefireworkItems.POTASSIUM_POWDER_ITEM
import morefirework.mod.item.MorefireworkItems.POWDERED_SULFUR_ITEM
import morefirework.mod.item.MorefireworkItems.PURE_POTASH_ITEM
import morefirework.mod.item.MorefireworkItems.SHORT_MUSKET_ITEM
import morefirework.mod.item.MorefireworkItems.SULFUR_CHUNK_ITEM
import morefirework.mod.item.MorefireworkItems.WATER_ASH_SOLUTION_BUCKET_ITEM
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry
import net.minecraft.block.Block
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.SpawnGroup
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemGroup
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

        val IronGunpowderBombEntityType: EntityType<IronGunpowderBombProjectile> = Registry.register<EntityType<*>, EntityType<IronGunpowderBombProjectile>>(
            Registry.ENTITY_TYPE,
            Identifier(modid, "iron_gunpowder_bomb_projectile"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ::IronGunpowderBombProjectile)
                .dimensions(EntityDimensions.changing(0.5f, 0.5f))
                .trackRangeBlocks(128).trackedUpdateRate(10)
                .build()
        )

        val GunpowderDepthChargeEntityType: EntityType<GunpowderDepthChargeProjectile> = Registry.register<EntityType<*>, EntityType<GunpowderDepthChargeProjectile>>(
            Registry.ENTITY_TYPE,
            Identifier(modid, "gunpowder_depth_charge_projectile"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ::GunpowderDepthChargeProjectile)
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

        val IncendiaryPackEntityType: EntityType<IncendiaryPackProjectile> = Registry.register<EntityType<*>, EntityType<IncendiaryPackProjectile>>(
            Registry.ENTITY_TYPE,
            Identifier(modid, "incendiary_pack_projectile"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ::IncendiaryPackProjectile)
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

        val IncendiaryBombEntityType: EntityType<IncendiaryBombProjectile> = Registry.register<EntityType<*>, EntityType<IncendiaryBombProjectile>>(
            Registry.ENTITY_TYPE,
            Identifier(modid, "incendiary_bomb_projectile"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ::IncendiaryBombProjectile)
                .dimensions(EntityDimensions.changing(0.5f, 0.5f))
                .trackRangeBlocks(128).trackedUpdateRate(10)
                .build()
        )

        val DynamiteBombEntityType: EntityType<DynamiteBombProjectile> = Registry.register<EntityType<*>, EntityType<DynamiteBombProjectile>>(
            Registry.ENTITY_TYPE,
            Identifier(modid, "dynamite_bomb_projectile"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ::DynamiteBombProjectile)
                .dimensions(EntityDimensions.changing(0.5f, 0.5f))
                .trackRangeBlocks(128).trackedUpdateRate(10)
                .build()
        )

        val DynamitePackEntityType: EntityType<DynamitePackProjectile> = Registry.register<EntityType<*>, EntityType<DynamitePackProjectile>>(
            Registry.ENTITY_TYPE,
            Identifier(modid, "dynamite_pack_projectile"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ::DynamitePackProjectile)
                .dimensions(EntityDimensions.changing(0.5f, 0.5f))
                .trackRangeBlocks(128).trackedUpdateRate(10)
                .build()
        )

        val FirePasteEntityType: EntityType<FirePasteProjectile> = Registry.register<EntityType<*>, EntityType<FirePasteProjectile>>(
            Registry.ENTITY_TYPE,
            Identifier(modid, "fire_paste_projectile"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ::FirePasteProjectile)
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

        //block entities
        val GUNPOWDER_BARREL_BLOCK_ENTITY: BlockEntityType<GunpowderBarrelBlockEntity> = //useless
            Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                Identifier(modid, "gunpowder_barrel_block_entity"),
                FabricBlockEntityTypeBuilder.create(::GunpowderBarrelBlockEntity, GUNPOWDER_BARREL_BLOCK).build()
        )

        //entity
        val GUNPOWDER_BARREL: EntityType<GunpowderBarrelEntity> = Registry.register(
            Registry.ENTITY_TYPE,
            Identifier("morefirework", "gunpowder_barrel"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ::GunpowderBarrelEntity)
                .dimensions(EntityDimensions.fixed(1f, 1f)).build()
        )

    }

    override fun onInitialize() {

        //entity
        FabricDefaultAttributeRegistry.register(GUNPOWDER_BARREL, LivingEntity.createLivingAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 0.0))

        //items
        Registry.register(Registry.ITEM, Identifier("morefirework", "firecracker"), FIRECRACKER_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "gunpowder_bomb"), GUNPOWDER_BOMB_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "incendiary_bomb"), INCENDIARY_BOMB_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "gunpowder_shrapnel_stick"), GUNPOWDER_SHRAPNEL_STICK_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "gunpowder_pack"), GUNPOWDER_PACK_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "incendiary_pack"), INCENDIARY_PACK_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "dynamite_bomb"), DYNAMITE_BOMB_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "dynamite_pack"), DYNAMITE_PACK_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "cast_iron_gunpowder_bomb"), CAST_IRON_GUNPOWDER_BOMB_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "gunpowder_depth_charge"), GUNPOWDER_DEPTH_CHARGE_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "iron_shot"), IRON_SHOT_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "copper_shot"), COPPER_SHOT_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "iron_musket_cartridge"), IRON_MUSKET_CARTRIDGE_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "copper_musket_cartridge"), COPPER_MUSKET_CARTRIDGE_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "fuse"), FUSE_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "short_musket"), SHORT_MUSKET_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "musket_ram_rod"), MUSKET_RAM_ROD)
        Registry.register(Registry.ITEM, Identifier("morefirework", "fire_paste"), FIRE_PASTE_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "beeswax_fire_starter"), BEESWAX_FIRE_STARTER_ITEM)

        Registry.register(Registry.ITEM, Identifier("morefirework", "potassium_ingot"), POTASSIUM_INGOT_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "potassium_powder"), POTASSIUM_POWDER_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "pure_potash"), PURE_POTASH_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "ash"), ASH_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "water_ash_solution_bucket"), WATER_ASH_SOLUTION_BUCKET_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "sulfur_chunk"), SULFUR_CHUNK_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "powdered_sulfur"), POWDERED_SULFUR_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "dense_paper"), DENSE_PAPER_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "dynamite"), DYNAMITE_ITEM)
        Registry.register(Registry.ITEM, Identifier("morefirework", "explosive_mixture"), EXPLOSIVE_MIXTURE_ITEM)


        //icon items
        Registry.register(Registry.ITEM, Identifier("morefirework", "fire"), FIRE_ITEM)

        //blocks
        Registry.register<Block, Block>(Registry.BLOCK, Identifier(modid, "lead_ore"), LEAD_ORE_BLOCK)
        Registry.register<Block, Block>(Registry.BLOCK, Identifier(modid, "sulfur_ore"), SULFUR_ORE_BLOCK)

        Registry.register<Block, Block>(Registry.BLOCK, Identifier(modid, "potassium_block"), POTASSIUM_BLOCK)
        Registry.register<Block, Block>(Registry.BLOCK, Identifier(modid, "sulfur_block"), SULFUR_BLOCK)

        Registry.register<Block, Block>(Registry.BLOCK, Identifier(modid, "firework_station"), FIREWORK_STATION_BLOCK)
        Registry.register<Block, Block>(Registry.BLOCK, Identifier(modid, "gunpowder_barrel"), GUNPOWDER_BARREL_BLOCK)

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
            Identifier(modid, "sulfur_ore"),
            BlockItem(SULFUR_ORE_BLOCK, FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS))
        )

        Registry.register(
            Registry.ITEM,
            Identifier(modid, "firework_station_block"),
            BlockItem(FIREWORK_STATION_BLOCK, FabricItemSettings().group(ItemGroup.DECORATIONS))
        )

        Registry.register(
            Registry.ITEM,
            Identifier(modid, "gunpowder_barrel"),
            BlockItem(GUNPOWDER_BARREL_BLOCK, FabricItemSettings())
        )

    }

}