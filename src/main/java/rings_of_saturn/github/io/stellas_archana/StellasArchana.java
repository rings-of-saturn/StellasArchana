package rings_of_saturn.github.io.stellas_archana;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static rings_of_saturn.github.io.stellas_archana.item.ModItems.registerModItems;

public class StellasArchana implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Stella's Archana");
    public static final String MOD_ID = "stellas_archana";

    @Override
    public void onInitialize() {
        registerModItems();
    }
}
