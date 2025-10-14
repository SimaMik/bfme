package net.sima.bfme.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.sima.bfme.faction.Faction;
import net.sima.bfme.player.PlayerData;
import net.sima.bfme.player.PlayerDataProvider;

import java.util.Arrays;

public class SetReputationCommand {
    public SetReputationCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("reputation").then(Commands.literal("set")
                .then(Commands.argument("factionName", StringArgumentType.string())
                        .then(Commands.argument("value", IntegerArgumentType.integer())
                                .executes(this::execute)))));
    }

    private int execute(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        String factionName = StringArgumentType.getString(context, "factionName");
        int value = IntegerArgumentType.getInteger(context, "value");

        // Находим фракцию по имени
        Faction faction = Arrays.stream(Faction.values())
                .filter(f -> f.getFactionName().equalsIgnoreCase(factionName))
                .findFirst().orElse(null);

        if (faction == null) {
            context.getSource().sendFailure(Component.literal("Faction " + factionName + " does not exist"));
            return 0;
        }

        // Получаем данные игрока через капабилити
        PlayerData playerData = player.getCapability(PlayerDataProvider.PLAYER_DATA_CAPABILITY, null);
        if (playerData != null) {
            playerData.setReputation(faction, value);
            context.getSource().sendSuccess(() -> Component.literal("Set reputation for " + factionName + " to " + value), false);
        } else {
            context.getSource().sendFailure(Component.literal("Failed to get player data."));
        }

        return 1;
    }
}
