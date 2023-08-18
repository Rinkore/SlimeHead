package com.github.rinkore28.slimehead.client;

import com.github.rinkore28.slimehead.client.render.entity.EntityRegister;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;


@Environment(EnvType.CLIENT)
public class EntryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRegister.init();
    }
}
