package mod.linguardium.lingassist.Assistants;

import com.google.common.collect.Lists;
import io.github.cottonmc.libcd.api.CDSyntaxError;
import net.minecraft.block.SpawnerBlock;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.InfoEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.TradeOffers;
import net.minecraft.world.MobSpawnerEntry;

public class ItemStackAssistant {
    public static final ItemStackAssistant INSTANCE = new ItemStackAssistant();

    private ItemStackAssistant() {}
    public ItemStack Dye(ItemStack stack) {
        return DyeByTable(stack,RandomAssistant.random.nextInt(16));
    }
    public ItemStack DyeByTable(ItemStack stack, Integer color) {
        if (stack.getItem() instanceof DyeableItem) {
            ItemStack newstack = stack.copy();
            newstack = DyeableItem.blendAndSetColor(newstack,Lists.newArrayList(DyeItem.byColor(DyeColor.byId(color))));
            ((DyeableItem) stack.getItem()).setColor(stack,((DyeableItem)newstack.getItem()).getColor(newstack));
        }
        return stack;
    }
    public ItemStack DyeByInt(ItemStack stack, Integer color) {
        if (stack.getItem() instanceof DyeableItem) {
            ((DyeableItem) stack.getItem()).setColor(stack, color);
        }
        return stack;
    }
    public ItemStack enchant(ItemStack stack) {
        int enchantLevel = 5+RandomAssistant.random.nextInt(15);
        return enchant(stack,enchantLevel,true);
    }
    public ItemStack enchant(ItemStack stack, Integer enchantLevel) {
        return enchant(stack,enchantLevel,true);
    }
    public ItemStack enchant(ItemStack stack, Boolean treasureEnchant) {
        int enchantLevel = 5+RandomAssistant.random.nextInt(15);
        return enchant(stack,enchantLevel,treasureEnchant);
    }
    public ItemStack enchant(ItemStack stack, Integer enchantLevel, Boolean treasureEnchant) {
        Enchantment enchantment = null;
        EnchantmentHelper.enchant(RandomAssistant.random,stack,enchantLevel,treasureEnchant);
        return stack;
    }
    public ItemStack generateSpawner(String mobId) throws CDSyntaxError {
        ItemStack stack = new ItemStack(Items.SPAWNER);
        EntityType mob = Registry.ENTITY_TYPE.get(Identifier.tryParse(mobId));
        if (mob != null) {
            stack.setCustomName(mob.getName().append(" Spawner"));
            CompoundTag tag = stack.getOrCreateTag();
            CompoundTag spawnData = new CompoundTag();
            spawnData.putString("id",mobId);
            tag.put("SpawnData",spawnData);
            stack.setTag(tag);
        }else{
            throw(new CDSyntaxError("Unknown Entity: "+mobId));
        }
        return stack;
    }

    public ItemStack generateEnchantedBook() {
        Enchantment enchantment = (Enchantment)Registry.ENCHANTMENT.getRandom(RandomAssistant.random);
        int i = MathHelper.nextInt(RandomAssistant.random, enchantment.getMinimumLevel(), enchantment.getMaximumLevel());
        return EnchantedBookItem.forEnchantment(new InfoEnchantment(enchantment, i));
    }
}
