package xyz.tcbuildmc.minecraft.hnp.bukkit.util;

import org.bukkit.ChatColor;
import xyz.tcbuildmc.common.util.HolderString;

public class BukkitHolderString extends HolderString {
    public BukkitHolderString(String string) {
        super(string);
    }

    public BukkitHolderString() {
    }

    public BukkitHolderString appendColor(ChatColor color) {
        this.setString(color + this.getString());
        return this;
    }
}
