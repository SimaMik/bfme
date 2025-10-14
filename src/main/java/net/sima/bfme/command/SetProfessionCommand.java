package net.sima.bfme.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.sima.bfme.player.PlayerData;
import net.sima.bfme.player.PlayerDataProvider;
import net.sima.bfme.profession.Professions;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SetProfessionCommand {
    private static final SuggestionProvider<CommandSourceStack> PROFESSION_SUGGESTIONS = (context, builder) -> {
        // Предоставляем список доступных профессий для автозаполнения
        return net.minecraft.commands.SharedSuggestionProvider.suggest(
                Arrays.stream(Professions.values())
                        .map(Professions::getName)
                        .collect(Collectors.toList()),
                builder);
    };

    public SetProfessionCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("profession")
                .then(Commands.literal("set")
                        .then(Commands.argument("professionName", StringArgumentType.string())
                                .suggests(PROFESSION_SUGGESTIONS)  // Подключаем автозаполнение
                                .executes(this::execute))));
    }

    private int execute(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();
        String professionName = StringArgumentType.getString(context, "professionName");

        // Ищем профессию по имени
        Professions profession = null;
        for (Professions p : Professions.values()) {
            if (p.getName().equalsIgnoreCase(professionName)) {
                profession = p;
                break;
            }
        }

        if (profession == null) {
            context.getSource().sendFailure(Component.literal("Profession " + professionName + " does not exist"));
            return 0;
        }

        // Сохраняем profession.getName() в переменной
        String foundProfessionName = profession.getName();

        // Получаем данные игрока
        PlayerData playerData = player.getCapability(PlayerDataProvider.PLAYER_DATA_CAPABILITY, null);
        if (playerData != null) {
            playerData.setProfession(profession);  // Устанавливаем профессию
            context.getSource().sendSuccess(() -> Component.literal("Profession set to " + foundProfessionName), false);
        } else {
            context.getSource().sendFailure(Component.literal("Could not retrieve player data"));
        }

        return 1;
    }
}
