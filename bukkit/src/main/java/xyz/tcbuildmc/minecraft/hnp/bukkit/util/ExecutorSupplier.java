package xyz.tcbuildmc.minecraft.hnp.bukkit.util;

import dev.jorel.commandapi.executors.CommandArguments;
import xyz.tcbuildmc.common.annotations.Testing;

@Testing
@FunctionalInterface
public interface ExecutorSupplier<T> {
    void execute(T sender, CommandArguments args);
}
