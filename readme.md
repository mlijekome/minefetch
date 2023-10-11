# Minefetch - A Spigot/Paper Minecraft Server Information Display Plugin

Minefetch is a Spigot/Paper plugin that essentially acts as a wrapper for Neofetch, redirecting most of the information it gathers and displaying it inside your Minecraft server chat, once exectued by user. 
Just like Neofetch, Minefetch provides information about your box's system, including the distribution, uptime, CPU, and memory usage. This plugin is designed for Spigot/Paper Minecraft servers running on various configurations, making it a great way to display system information for servers running unconventional hardware, such as weak processors, low RAM amounts, or unusual OS/distro choices. It can also be used to show off rather powerful hardware configurations and impress your players with your unique server setup! This plugin can be a fun and informative addition to your server. 😺

## Installation

To use Minefetch, you need to follow these installation steps:

1. Ensure you have a Spigot or Paper server running. (Tested on PurPur, which is Paper fork)
2. Download the `Minefetch.jar` file from the [GitHub repository](https://github.com/mlijekome/minefetch/releases/tag/Release).

3. Place the `Minefetch.jar` file in your server's `plugins` directory.

4. Restart or reload your server to enable the plugin.

Minefetch was coded using [IntelliJ IDEA Community](https://www.jetbrains.com/idea/), a powerful and free Java development environment.

To build and compile the plugin from the source code, follow these steps:
1. Clone the Minefetch repository from GitHub.
2. Open the project in IntelliJ IDEA or your preferred Java development environment.
3. Use Maven to build the project, ensuring that it retrieves all necessary dependencies.
4. Once the build is successful, you will find the compiled JAR file in the `target` directory.

## Usage

Once Minefetch is installed and active on your server, you can use it by typing the following command in the Minecraft chat:
``/minefetch``

![Minefetch example output](https://i.imgur.com/rr1J3X8.png)


This command is only available to players, meaning it **CANNOT** be executed from the server console	. When executed, the plugin will run in the background and gather system information using the `neofetch` command. Afterward, it will display the information in the server chat for the person executing it.
## Credits and Contributions

Minefetch is based on the initial idea, concept, and some code by [mlijekome](https://github.com/mlijekome). Some changes and improvements have been made to the code, including the utilization of the Streams API for reading command output and enhanced resource management with try-with-resources. Special thanks to [Yikesec](https://Yikesec.github.io) for polishing and contributing to the project.

This project is open to contributions from the Minecraft and Spiggot/Paper community. If you have ideas, improvements, or bug fixes, feel free to contribute by opening a pull request on this [GitHub repository](https://github.com/mlijekome/minefetch).

## Disclaimer

Minefetch is provided as-is and may or may not receive continuous updates. While the goal is to ensure the stability and functionality of the plugin, it may not work perfectly on all server configurations. Repo owner and/or its contributors ARE NOT responsible for any issues or damages that may occur as a result of using this plugin. It's important to backup your server before adding and using any new plugin. Use it at your own discretion and risk.


