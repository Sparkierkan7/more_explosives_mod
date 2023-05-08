package morefirework.mod.render.entity.model

import com.google.common.collect.ImmutableList
import morefirework.mod.entity.GunpowderBarrelEntity
import net.minecraft.client.model.*
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.render.entity.model.EntityModelPartNames
import net.minecraft.client.util.math.MatrixStack


class GunpowderBarrelEntityModel(modelPart: ModelPart) : EntityModel<GunpowderBarrelEntity?>() {
    private val base: ModelPart

    init {
        base = modelPart.getChild(EntityModelPartNames.CUBE)
    }

    companion object {

        fun getTexturedModelData(): TexturedModelData? {
            val modelData = ModelData()
            val modelPartData = modelData.root
            modelPartData.addChild(
                EntityModelPartNames.CUBE,
                ModelPartBuilder.create().uv(0, 0).cuboid(-8f, 8f, -8f, 16f, 16f, 16f),
                ModelTransform.pivot(0f, 0f, 0f)
            )
            return TexturedModelData.of(modelData, 64, 64);
        }

    }


    override fun setAngles(
        entity: GunpowderBarrelEntity?,
        limbAngle: Float,
        limbDistance: Float,
        animationProgress: Float,
        headYaw: Float,
        headPitch: Float
    ) {
    }

    override fun render(
        matrices: MatrixStack?,
        vertices: VertexConsumer?,
        light: Int,
        overlay: Int,
        red: Float,
        green: Float,
        blue: Float,
        alpha: Float
    ) {
        ImmutableList.of(base).forEach { modelRenderer ->
            modelRenderer.render(
                matrices,
                vertices,
                light,
                overlay,
                red,
                green,
                blue,
                alpha
            )
        }
    }
}