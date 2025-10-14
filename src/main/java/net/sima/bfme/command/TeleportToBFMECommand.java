package net.sima.bfme.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.sima.bfme.worldgen.dimension.ModDimensions;

public class TeleportToBFMECommand {
    public TeleportToBFMECommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("bfme")
                .then(Commands.literal("teleport")
                        .executes(this::execute)));
    }

    private int execute(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();
        if (player == null) {
            context.getSource().sendFailure(Component.literal("Command must be executed by a player."));
            return 0;
        }

        // Телепортируем игрока в измерение BFME
        ModDimensions.teleportPlayerToBFME(player);

        context.getSource().sendSuccess(() -> Component.literal("You have been teleported to the BFME dimension!"), true);
        return 1;
    }
}
