package xyz.tcbuildmc.minecraft.hnp.util;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.Argument;
import dev.jorel.commandapi.wrappers.NativeProxyCommandSender;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.ProxiedCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import xyz.tcbuildmc.minecraft.hnp.annotations.Testing;

import java.util.List;
import java.util.function.Predicate;

public final class CommandUtils {
    @Deprecated
    public static CommandAPICommand createCommand(String literal) {
        return new CommandAPICommand(literal);
    }

    public static CommandUtils.Builder builder(String literal) {
        return new CommandUtils.Builder(literal);
    }

    @Testing
    public static class Builder {
        private final CommandAPICommand command;

        public Builder(String literal) {
            this.command = new CommandAPICommand(literal);
        }

        public CommandUtils.Builder args(List<Argument<?>> args) {
            this.command.withArguments(args);
            return this;
        }

        public CommandUtils.Builder args(Argument<?>... args) {
            return this.args(List.of(args));
        }

        public CommandUtils.Builder permission(String permission) {
            this.command.withPermission(permission);
            return this;
        }

        public CommandUtils.Builder permission(CommandPermission permission) {
            this.command.withPermission(permission);
            return this;
        }

        public CommandUtils.Builder aliases(String... aliases) {
            this.command.withAliases(aliases);
            return this;
        }

        public CommandUtils.Builder usage(String... usages) {
            this.command.withUsage(usages);
            return this;
        }

        public CommandUtils.Builder help(String shortDesc, String longDesc) {
            this.command.withHelp(shortDesc, longDesc);
            return this;
        }

        public CommandUtils.Builder requires(Predicate<CommandSender> predicate) {
            this.command.withRequirement(predicate);
            return this;
        }

        public CommandUtils.Builder subCommand(CommandAPICommand... commands) {
            this.command.withSubcommands(commands);
            return this;
        }

        public CommandUtils.Builder executes(ExecutorSupplier<CommandSender> supplier) {
            this.command.executes(supplier::execute);
            return this;
        }

        public CommandUtils.Builder executesPlayer(ExecutorSupplier<Player> supplier) {
            this.command.executesPlayer(supplier::execute);
            return this;
        }

        public CommandUtils.Builder executesEntity(ExecutorSupplier<Entity> supplier) {
            this.command.executesEntity(supplier::execute);
            return this;
        }

        public CommandUtils.Builder executesCommandBlock(ExecutorSupplier<BlockCommandSender> supplier) {
            this.command.executesCommandBlock(supplier::execute);
            return this;
        }

        public CommandUtils.Builder executesConsole(ExecutorSupplier<ConsoleCommandSender> supplier) {
            this.command.executesConsole(supplier::execute);
            return this;
        }

        public CommandUtils.Builder executesProxy(ExecutorSupplier<ProxiedCommandSender> supplier) {
            this.command.executesProxy(supplier::execute);
            return this;
        }

        public CommandUtils.Builder executesNativeProxy(ExecutorSupplier<NativeProxyCommandSender> supplier) {
            this.command.executesNative(supplier::execute);
            return this;
        }

        public CommandAPICommand register() {
            this.command.register();
            return this.command;
        }
    }
}
