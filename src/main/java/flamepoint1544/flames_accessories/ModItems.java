package flamepoint1544.flames_accessories;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.entity.attribute.EntityAttribute;

public class ModItems {
    private static final EntityAttribute[] zephyrAttributes = new EntityAttribute[]{EntityAttributes.GENERIC_MOVEMENT_SPEED, EntityAttributes.GENERIC_MOVEMENT_SPEED};
    private static final String[] zephyrAttributeNames = new String[]{"flames_accessories:movement_speed_ult", "flames_accessories:attack_speed_alt"};
    private static final double[] zephyrValues = new double[]{0.2, 3};
    private static final EntityAttributeModifier.Operation[] zephyrOperations = new EntityAttributeModifier.Operation[]{EntityAttributeModifier.Operation.MULTIPLY_TOTAL, EntityAttributeModifier.Operation.ADDITION};

    // Items
    public static final Item SPEED_CHARM = register(new Accessory(new Item.Settings(), EntityAttributes.GENERIC_MOVEMENT_SPEED, "flames_accessories:movement_speed", 0.05, EntityAttributeModifier.Operation.MULTIPLY_TOTAL), "speed_charm");
    public static final Item SPEED_CHARM_T2 = register(new Accessory(new Item.Settings(), EntityAttributes.GENERIC_MOVEMENT_SPEED, "flames_accessories:movement_speed", 0.2, EntityAttributeModifier.Operation.MULTIPLY_TOTAL), "speed_charm_t2");
    public static final Item SPEED_CHARM_ULT = register(new AccessoryMult(new Item.Settings(), zephyrAttributes, zephyrAttributeNames, zephyrValues, zephyrOperations, 2), "speed_charm_ult");

    // item group registry keys
    public static final RegistryKey<ItemGroup> PRIMARY_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(FlamesAccessories.MOD_ID, "primary_item_group"));

    // Item Groups
    public static final ItemGroup PRIMARY_ITEM_GROUP = FabricItemGroup.builder()
    .icon(() -> new ItemStack(Items.BEDROCK.asItem()))
    .displayName(Text.translatable("itemGroup.flames_accessories.primary_item_group")).build();
    
    /***************************************************************************************************
     * +# register(Item item, String id): Item
     * Registers items using the string id and the modid defined in the main class to make an identifier
     ***************************************************************************************************/
    public static Item register(Item item, String id){
        // Create Identifier
        Identifier itemID = Identifier.of(FlamesAccessories.MOD_ID, id);

        // Register the item
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        // Return
        return registeredItem;
    }

    /**********************************************************
     * +# initialize(): void
     * Initializes the file while also registering item groups
     *********************************************************/
    public static void initialize(){
        // Register group
        Registry.register(Registries.ITEM_GROUP, PRIMARY_GROUP_KEY, PRIMARY_ITEM_GROUP);

        // add items to registered group
        ItemGroupEvents.modifyEntriesEvent(PRIMARY_GROUP_KEY).register(itemGroup ->{
            itemGroup.add(SPEED_CHARM);
            itemGroup.add(SPEED_CHARM_T2);
            itemGroup.add(SPEED_CHARM_ULT);
         });
    }
}