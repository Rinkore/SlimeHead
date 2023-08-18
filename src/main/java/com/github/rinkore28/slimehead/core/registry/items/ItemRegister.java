package com.github.rinkore28.slimehead.core.registry.items;

import com.github.rinkore28.slimehead.core.Entry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.github.rinkore28.slimehead.core.Entry.MOD_ID;
import static com.github.rinkore28.slimehead.core.registry.items.SpawnEgg.SLIME_HEAD_SPAWN_EGG;

public class ItemRegister {

    private static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "item_group"));

    private static void register(DefaultedRegistry<Item> registryType, Identifier registryKey, Item registryEntry) {

        Registry.register(registryType, registryKey, registryEntry);
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
            content.add(registryEntry);
        });
    }

    public static void init() {
        //Item Group Setting
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
                .displayName(Text.translatable("Slime Head"))
                .icon(() -> new ItemStack(Items.PLAYER_HEAD))
                .build()
        );

        //Items Register
        ItemRegister.register(Registries.ITEM, Entry.id("slime_head_spawn_egg"), SLIME_HEAD_SPAWN_EGG);
    }
}
