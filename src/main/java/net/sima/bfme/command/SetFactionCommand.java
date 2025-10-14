package net.sima.bfme.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.sima.bfme.faction.Faction;
import net.sima.bfme.player.PlayerData;
import net.sima.bfme.player.PlayerDataProvider;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SetFactionCommand {
    private static final SuggestionProvider<CommandSourceStack> FACTION_SUGGESTIONS = (context, builder) -> {
        // Предоставляем список доступных фракций для автозаполнения
        return net.minecraft.commands.SharedSuggestionProvider.suggest(Arrays.stream(Faction.values())
                .map(Faction::getFactionName)
                .collect(Collectors.toList()), builder);
    };

    public SetFactionCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("faction")
                .then(Commands.literal("set")
                        .then(Commands.argument("factionName", StringArgumentType.string())
                                .suggests(FACTION_SUGGESTIONS)  // Подключаем автозаполнение
                                .executes(this::execute))));
    }
    private int execute(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();
        String factionName = StringArgumentType.getString(context, "factionName");

        // Ищем фракцию по имени
        Faction faction = null;
        for (Faction f : Faction.values()) {
            if (f.getFactionName().equalsIgnoreCase(factionName)) {
                faction = f;
                break;
            }
        }

        if (faction == null) {
            context.getSource().sendFailure(Component.literal("Faction " + factionName + " does not exist"));
            return 0;
        }

        // Сохраняем faction.getFactionName() в переменной
        String foundFactionName = faction.getFactionName();

        // Получаем данные игрока
        PlayerData playerData = player.getCapability(PlayerDataProvider.PLAYER_DATA_CAPABILITY, null);
        if (playerData != null) {
            playerData.setFaction(faction);  // Устанавливаем фракцию
            context.getSource().sendSuccess(() -> Component.literal("Faction set to " + foundFactionName), false);
        } else {
            context.getSource().sendFailure(Component.literal("Could not retrieve player data"));
        }

        return 1;
    }
}
