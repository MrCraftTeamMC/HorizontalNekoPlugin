package xyz.tcbuildmc.minecraft.hnp.bukkit.command;

import org.bukkit.ChatColor;
import xyz.tcbuildmc.common.util.secret.AprilFoolUtils;
import xyz.tcbuildmc.minecraft.hnp.bukkit.util.BukkitHolderString;
import xyz.tcbuildmc.minecraft.hnp.bukkit.util.CommandUtils;

import java.time.LocalTime;
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

        if (AprilFoolUtils.isTodayAprilFool()) {
            CommandUtils.builder("gg")
                    .executes(((sender, args) -> {
                        if (LocalTime.now().getSecond() % 4 == 0) {
                            sender.sendMessage("https://www.bilibili.com/video/BV1qh4y1b7w6/");
                        } else if (LocalTime.now().getSecond() % 4 == 1) {
                            sender.sendMessage("https://www.bilibili.com/video/BV1GJ411x7h7/");
                        } else if (LocalTime.now().getSecond() % 4 == 2) {
                            sender.sendMessage("https://www.bilibili.com/video/BV1Lu4y1W74m/");
                        } else {
                            sender.sendMessage("https://www.bilibili.com/video/BV1ct4y1n7t9/");
                        }
                    }))
                    .register();
        }
    }
}
