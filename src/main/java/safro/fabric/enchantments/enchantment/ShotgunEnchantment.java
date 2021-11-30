package safro.fabric.enchantments.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import safro.fabric.enchantments.config.EnchantmentConfigs;

public class ShotgunEnchantment extends Enchantment {

    public ShotgunEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.CROSSBOW, new EquipmentSlot[] {EquipmentSlot.MAINHAND});

        if (EnchantmentConfigs.getValue("shotgun")) {
            Registry.register(Registry.ENCHANTMENT, new Identifier("fabricenchantments", "shotgun"), this);
        }
    }

    @Override
    public int getMinPower(int level) { return 15; }

    @Override
    public int getMaxLevel() { return 2; }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.PIERCING;
    }
}