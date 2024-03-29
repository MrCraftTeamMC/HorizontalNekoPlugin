package xyz.tcbuildmc.minecraft.hnp.command;

import org.bukkit.ChatColor;
import xyz.tcbuildmc.minecraft.hnp.util.CommandUtils;
import xyz.tcbuildmc.minecraft.hnp.util.TextUtils;

import java.util.Random;

public final class HorizontalNekoCommands {
    public static void register() {
        CommandUtils.builder("here")
                .executes((sender, args) -> {
                    Random random = new Random();

                    sender.sendMessage(TextUtils.formatted("Your lucky number is: %number%")
                            .appendColor(ChatColor.AQUA)
                            .replaceHolder("%number%", random.nextInt(100))
                            .toString());
                })
                .register();
    }
}
