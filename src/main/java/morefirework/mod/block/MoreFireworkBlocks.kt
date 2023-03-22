package morefirework.mod.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Material
import net.minecraft.sound.BlockSoundGroup

object MoreFireworkBlocks {

    val LEAD_ORE_BLOCK: LeadOreBlock = LeadOreBlock(FabricBlockSettings.of(Material.STONE).strength(2f).sounds(BlockSoundGroup.STONE))

    val POTASSIUM_BLOCK: PotassiumBlock = PotassiumBlock(FabricBlockSettings.of(Material.METAL).strength(2f).sounds(BlockSoundGroup.CANDLE))
    val SULFUR_BLOCK: SulfurBlock = SulfurBlock(FabricBlockSettings.of(Material.STONE).strength(2f).sounds(BlockSoundGroup.TUFF))

    val FIREWORK_STATION_BLOCK: FireworkStationBlock = FireworkStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.75f).sounds(BlockSoundGroup.WOOD))

}