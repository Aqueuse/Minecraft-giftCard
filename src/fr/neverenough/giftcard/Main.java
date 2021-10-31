package fr.neverenough.giftcard;

import fr.neverenough.giftcard.listeners.OnDrawMap;
import fr.neverenough.giftcard.map.MapRender;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {
	public static MapRender myMapRender;

	@Override
	public void onEnable() {
		myMapRender = new MapRender("");

		getServer().getPluginManager().registerEvents(new OnDrawMap(), this);

		Objects.requireNonNull(getCommand("giftcard")).setExecutor((commandSender, command, label, args) -> {
			StringBuilder message = new StringBuilder();

			if (commandSender instanceof Player player) {
				for (String arg : args) {
					message.append(arg);
					message.append(" ");
				}

				int charactersByLine = 24;

				int messageLinesQuantity = (int) Math.ceil(((double) message.length())/charactersByLine);
				String multilineMessage = "";

				// filling the last line with spaces for simplicity of coding ¯\(°_o)/¯
				int fillingSpacesQuantity = (messageLinesQuantity*charactersByLine) - message.length();
				message.append(" ".repeat(Math.max(0, fillingSpacesQuantity)));

				for (int i = 0; i < messageLinesQuantity; i++) {
					multilineMessage = multilineMessage + message.substring(i*charactersByLine, (i*charactersByLine)+charactersByLine) + "\n";
				}

				myMapRender = new MapRender(multilineMessage);

				ItemStack itemStack = new ItemStack(Material.MAP, 1);
				player.getInventory().addItem(itemStack);
			}
			return false;
		});
		System.out.println("giftcard enabled");
	}
}