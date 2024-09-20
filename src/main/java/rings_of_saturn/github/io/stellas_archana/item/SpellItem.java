package rings_of_saturn.github.io.stellas_archana.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import rings_of_saturn.github.io.stellas_archana.StellasArchana;

import java.util.List;

public class SpellItem extends Item {
    public SpellItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        String disc = "stellas_archana.spell.description." + stack.getItem().getName().getString().toLowerCase();
        tooltip.add(Text.translatable(disc));
    }
}
