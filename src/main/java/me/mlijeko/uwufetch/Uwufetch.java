/*
           _             __     _       _
          (_)           / _|   | |     | |
 _ __ ___  _ _ __   ___| |_ ___| |_ ___| |__
| '_ ` _ \| | '_ \ / _ \  _/ _ \ __/ __| '_ \
| | | | | | | | | |  __/ ||  __/ || (__| | | |
|_| |_| |_|_|_| |_|\___|_| \___|\__\___|_| |_|

* Minefetch -- it's like Neofetch, but for Minecraft servers!
 * Displays the actual `Neofetch` output inside Minecraft Server chat
 * Initial idea, concept and some code:
 * github.com/mlijekome
 *
 * Recent Changes:
 * - Utilized Streams API for reading command output.
 * - Enhanced resource management with try-with-resources.
 * - Big thanks to https://Yikesec.github.io for polishing me up!
 * SERIOUSLY, TYSM I *FUCKING* HATE JAVA ITS PAIN IN THE FUCKING ASS
 *
 * Why does this exist? In case you manage to run your minecraft
 * server on `weird` CPUs, or just wanna show off our newest AMD(r) EPYC(tm)
 * or perhaps you got it running on an usual distro/os, sky\'s the limit!
 */

package me.mlijeko.uwufetch;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public final class Uwufetch extends JavaPlugin {

    // logger, in case something gets fucked
    private static final Logger logger = LoggerFactory.getLogger(Uwufetch.class);

    @Override
    public void onEnable() {
        //A command?! You sure hope so!
        Bukkit.getPluginCommand("minefetch").setExecutor((sender, command, label, args) -> {
            // Human check lmao -- just for good practice
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be executed by players, silly! :3");
                return true;
            }

            // Let's get the command
            Bukkit.getScheduler().runTaskAsynchronously(this, () -> {
                String output = executeShellCommand("neofetch --source distro uptime terminal cpu memory");
                if (output != null) {
                    // Let's show the message to the player!
                    sender.sendMessage(output);
                } else {
                    // Awww, something went wrong...
                    sender.sendMessage("I have no clue what the fuck happened. But you ain't\n getting server info! Sowwie.");
                }
            });

            return true;
        });
    }

    private String executeShellCommand(String command) {
        // Shell stuff
        try {
            Process process = Runtime.getRuntime().exec(command);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                return reader.lines().collect(Collectors.joining("\n"));
            }
        } catch (IOException e) {
            // Oh something is fucking broken, lets log it. I probably wont check it.
            logger.error("Failed to execute shell command: {}", e.getMessage());
            return null;
        }
    }
}