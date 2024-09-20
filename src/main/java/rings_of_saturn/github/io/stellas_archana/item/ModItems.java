package rings_of_saturn.github.io.stellas_archana.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import rings_of_saturn.github.io.stellas_archana.StellasArchana;

import static rings_of_saturn.github.io.stellas_archana.StellasArchana.MOD_ID;

public class ModItems {
	public static final Item SPELL_BOOK = registerItem("spell_book", new SpellBookItem(
			new Item.Settings().maxCount(1).fireproof()));

	public static final Item WIND_SPELL = registerSpellItem("wind_spell");
	public static final Item SELF_SPELL = registerSpellItem("self_spell");


	private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
	}

	private static Item registerItem(String name, Item item){
		return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
	}

	private static Item registerSpellItem(String name){
		return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), new SpellItem(
				new Item.Settings().maxCount(1)));
	}

	public static void registerModItems(){
		StellasArchana.LOGGER.info("Registering Items For" + MOD_ID);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
	}

}