package me.tigerhix.lib.scoreboard.type;

import org.bukkit.entity.Player;

import java.util.List;

/**
 * Represents the handler to determine the title and entries of a scoreboard.
 *
 * @author TigerHix
 */
public interface ScoreboardHandler {

    /**
     * Determines the title to display for this player. If null returned, title automatically becomes a blank line.
     *
     * @param player player
     * @return title
     */
    String getTitle(Player player);

    /**
     * Determines the entries to display for this player. If null returned, the entries are not updated.
     *
     * @param player player
     * @return entries
     */
    List<Entry> getEntries(Player player);

}
