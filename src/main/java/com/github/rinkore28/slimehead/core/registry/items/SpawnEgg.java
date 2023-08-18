package com.github.rinkore28.slimehead.core.registry.items;

import com.github.rinkore28.slimehead.core.Entry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import com.github.rinkore28.slimehead.core.registry.entities.EntityRegister;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.github.rinkore28.slimehead.core.Entry.MOD_ID;

public class SpawnEgg {

    public static final Item SLIME_HEAD_SPAWN_EGG = new SpawnEggItem(EntityRegister.CUBE,  0x44343E,0x9CA5D1, new Item.Settings());


}

