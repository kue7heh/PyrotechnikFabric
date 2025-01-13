package pyrotechnik.kue7heh.config;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;

@Config(name = "pyrotechnik-config", wrapperName = "PyrotechnikConfig")
@Modmenu(modId = "pyrotechnik")

public class config {
    public static boolean explosive_arrows_enchantment_destroys_blocks = false;
}