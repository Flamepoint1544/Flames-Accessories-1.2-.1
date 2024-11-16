package flamepoint1544.flames_accessories;

import java.util.UUID;

import com.google.common.collect.Multimap;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;

public class Accessory extends TrinketItem{
    private final EntityAttribute attribute;
    private final String modifierName;
    private final double value;
    private final EntityAttributeModifier.Operation operation;

    public Accessory(Settings settings, EntityAttribute attribute, String modifierName, double value, EntityAttributeModifier.Operation operation) {
        super(settings);
        this.attribute = attribute;
        this.modifierName = modifierName;
        this.value = value;
        this.operation = operation;
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid){
        var modifiers = super.getModifiers(stack, slot, entity, uuid);

        modifiers.put(attribute, new EntityAttributeModifier(uuid, modifierName, value, operation));

        return modifiers;
    }
}
