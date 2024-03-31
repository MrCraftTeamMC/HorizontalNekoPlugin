package xyz.tcbuildmc.minecraft.hnp.bukkit.command;

import org.bukkit.ChatColor;
import xyz.tcbuildmc.minecraft.hnp.bukkit.util.BukkitHolderString;
import xyz.tcbuildmc.minecraft.hnp.bukkit.util.CommandUtils;

import java.util.Random;

public final class HorizontalNekoCommands {
    public static void register() {
        CommandUtils.builder("here")
                .executes((sender, args) -> {
                    Random random = new Random();

                    sender.sendMessage(new BukkitHolderString("Your lucky number is: %number%")
                            .appendColor(ChatColor.AQUA)
                            .replaceHolder("%number%", random.nextInt(100))
                            .toString());
                })
                .register();
    }
}
