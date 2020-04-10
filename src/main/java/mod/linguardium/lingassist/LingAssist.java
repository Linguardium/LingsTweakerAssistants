package mod.linguardium.lingassist;

import io.github.cottonmc.libcd.api.tweaker.TweakerManager;
import mod.linguardium.lingassist.Assistants.ItemStackAssistant;
import mod.linguardium.lingassist.Assistants.RandomAssistant;
import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LingAssist implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "lingassist";
    public static final String MOD_NAME = "Ling's Tweaker Assistants";

    @Override
    public void onInitialize() {
        TweakerManager.INSTANCE.addAssistant("lings.ItemStack", ItemStackAssistant.INSTANCE);
        TweakerManager.INSTANCE.addAssistant("lings.Random", RandomAssistant.INSTANCE);
        log(Level.INFO, "Linguardium has given you aides");
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}