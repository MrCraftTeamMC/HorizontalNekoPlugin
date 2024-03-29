package xyz.tcbuildmc.minecraft.hnp.util;

import dev.jorel.commandapi.executors.CommandArguments;
import xyz.tcbuildmc.minecraft.hnp.annotations.Testing;

@Testing
@FunctionalInterface
public interface ExecutorSupplier<T> {
    void execute(T sender, CommandArguments args);
}
