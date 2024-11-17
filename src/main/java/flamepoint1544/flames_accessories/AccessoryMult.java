package flamepoint1544.flames_accessories;

import java.util.UUID;

import com.google.common.collect.Multimap;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;

public class AccessoryMult extends TrinketItem{
    private final EntityAttribute[] attribute;
    private final String[] modifierName;
    private final double[] value;
    private final EntityAttributeModifier.Operation[] operation;
    private final int count;
    private final boolean hasGlint;

    public AccessoryMult(Settings settings, EntityAttribute[] attribute, String[] modifierName, double[] value, EntityAttributeModifier.Operation[] operation, int count, boolean hasGlint) {
        super(settings);
        this.attribute = attribute;
        this.modifierName = modifierName;
        this.value = value;
        this.operation = operation;
        this.count = count;
        this.hasGlint = hasGlint;
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid){
        var modifiers = super.getModifiers(stack, slot, entity, uuid);

        for(int i = 0; i < count; i++){
            modifiers.put(attribute[i], new EntityAttributeModifier(uuid, modifierName[i], value[i], operation[i]));
        }

        return modifiers;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return hasGlint;
    }
}
