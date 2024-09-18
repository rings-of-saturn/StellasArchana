package rings_of_saturn.github.io.stellas_archana.mixin;


import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import rings_of_saturn.github.io.stellas_archana.item.ModItems;

import static rings_of_saturn.github.io.stellas_archana.StellasArchana.MOD_ID;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
	@ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At(value = "HEAD"), argsOnly = true)
	public BakedModel useClosedBookModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
		if (stack.isOf(ModItems.SPELL_BOOK) && (renderMode == ModelTransformationMode.GUI || renderMode == ModelTransformationMode.FIXED))
            return ((ItemRendererAccessor)this).stellasAlchemy$getModels().getModelManager().getModel(new ModelIdentifier(Identifier.of(MOD_ID, "spell_book_closed"), "gui"));
		if (stack.isOf(ModItems.SPELL_BOOK) && renderMode == ModelTransformationMode.GROUND) {
			return ((ItemRendererAccessor) this).stellasAlchemy$getModels().getModelManager().getModel(new ModelIdentifier(Identifier.of(MOD_ID, "spell_book_closed"), "ground"));
		}
		return value;
	}
}