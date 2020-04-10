package minegame159.meteorclient.settings;

import minegame159.meteorclient.gui.screens.PotionSettingScreen;
import minegame159.meteorclient.gui.widgets.WButton;
import minegame159.meteorclient.gui.widgets.WItemWithLabel;
import minegame159.meteorclient.utils.MyPotion;
import net.minecraft.client.MinecraftClient;

import java.util.function.Consumer;

public class PotionSetting extends EnumSetting<MyPotion> {
    public PotionSetting(String name, String description, String group, MyPotion defaultValue, Consumer<MyPotion> onChanged, Consumer<Setting<MyPotion>> onModuleActivated, boolean visible) {
        super(name, description, group, defaultValue, onChanged, onModuleActivated, visible);

        widget = new WItemWithLabel(get().potion);
        widget.add(new WButton("Select")).action = () -> MinecraftClient.getInstance().openScreen(new PotionSettingScreen(this));
    }

    @Override
    protected void resetWidget() {
        ((WItemWithLabel) widget).set(get().potion);
        widget.layout();
    }

    public static class Builder extends EnumSetting.Builder<MyPotion> {
        @Override
        public EnumSetting<MyPotion> build() {
            return new PotionSetting(name, description, group, defaultValue, onChanged, onModuleActivated, visible);
        }
    }
}
