package morefirework.mod.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.ItemGroup
import net.minecraft.item.Items

object MorefireworkItems {

    val FIRECRACKER_ITEM = FirecrackerItem(FabricItemSettings().maxCount(64).group(ItemGroup.MISC))
    val GUNPOWDER_BOMB_ITEM = GunpowderBombItem(FabricItemSettings().maxCount(16).group(ItemGroup.MISC))
    val CAST_IRON_GUNPOWDER_BOMB_ITEM = CastIronGunpowderBombItem(FabricItemSettings().maxCount(8).group(ItemGroup.MISC))
    val GUNPOWDER_DEPTH_CHARGE_ITEM = GunpowderDepthChargeItem(FabricItemSettings().maxCount(8).group(ItemGroup.MISC))
    val GUNPOWDER_SHRAPNEL_STICK_ITEM = GunpowderShrapnelStickItem(FabricItemSettings().maxCount(16).group(ItemGroup.MISC))
    val GUNPOWDER_PACK_ITEM = GunpowderPackItem(FabricItemSettings().maxCount(2).group(ItemGroup.MISC))
    val INCENDIARY_PACK_ITEM = IncendiaryPackItem(FabricItemSettings().maxCount(2).group(ItemGroup.MISC))
    val INCENDIARY_BOMB_ITEM = IncendiaryBombItem(FabricItemSettings().maxCount(16).group(ItemGroup.MISC))
    val DYNAMITE_BOMB_ITEM = DynamiteBombItem(FabricItemSettings().maxCount(16).group(ItemGroup.MISC))
    val DYNAMITE_PACK_ITEM = DynamitePackItem(FabricItemSettings().maxCount(2).group(ItemGroup.MISC))
    val SHORT_MUSKET_ITEM = ShortMusketItem(FabricItemSettings().maxCount(1).group(ItemGroup.COMBAT))
    val MUSKET_RAM_ROD = MusketRamRod(FabricItemSettings().maxCount(1).group(ItemGroup.COMBAT))
    val FIRE_PASTE_ITEM = FirePasteItem(FabricItemSettings().maxCount(64).group(ItemGroup.MISC))
    val BEESWAX_FIRE_STARTER_ITEM = BeeswaxFireStarterItem(FabricItemSettings().maxCount(1).group(ItemGroup.TOOLS))

    val IRON_SHOT_ITEM = IronShotItem(FabricItemSettings().maxCount(64).group(ItemGroup.MISC))
    val COPPER_SHOT_ITEM = CopperShotItem(FabricItemSettings().maxCount(64).group(ItemGroup.MISC))
    val IRON_MUSKET_CARTRIDGE_ITEM = IronMusketCartridge(FabricItemSettings().maxCount(16).group(ItemGroup.COMBAT))
    val COPPER_MUSKET_CARTRIDGE_ITEM = CopperMusketCartridge(FabricItemSettings().maxCount(16).group(ItemGroup.COMBAT))
    val FUSE_ITEM = FuseItem(FabricItemSettings().maxCount(64).group(ItemGroup.MISC))
    val EXPLOSIVE_MIXTURE_ITEM = ExplosiveMixtureItem(FabricItemSettings().maxCount(16).group(ItemGroup.MISC))
    val DYNAMITE_ITEM = DynamiteItem(FabricItemSettings().maxCount(64).group(ItemGroup.MISC))

    val POTASSIUM_INGOT_ITEM = PotassiumIngotItem(FabricItemSettings().maxCount(64).group(ItemGroup.MISC))
    val POTASSIUM_POWDER_ITEM = PotassiumPowderItem(FabricItemSettings().maxCount(64).group(ItemGroup.MISC))
    val PURE_POTASH_ITEM = PurePotashItem(FabricItemSettings().maxCount(64).group(ItemGroup.MISC))
    val ASH_ITEM = AshItem(FabricItemSettings().maxCount(64).group(ItemGroup.MISC))
    val WATER_ASH_SOLUTION_BUCKET_ITEM = WaterAshSolutionBucketItem(FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(16).group(ItemGroup.MISC))
    val SULFUR_CHUNK_ITEM = SulfurChunkItem(FabricItemSettings().maxCount(64).group(ItemGroup.MISC))
    val POWDERED_SULFUR_ITEM = PowderedSulfurItem(FabricItemSettings().maxCount(64).group(ItemGroup.MISC))
    val DENSE_PAPER_ITEM = DensePaperItem(FabricItemSettings().maxCount(64).group(ItemGroup.MISC))


    val FIRE_ITEM = FireItem(FabricItemSettings().maxCount(64))

}