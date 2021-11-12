package fr.neverenough.giftcard;

import java.util.Objects;

import fr.neverenough.giftcard.map.MapRender;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static MapRender myMapRender;

	@Override
	public void onEnable() {
		myMapRender = new MapRender("");

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

				ItemStack giftcardsStack = new ItemStack( Material.FILLED_MAP, 1);
				myMapRender = new MapRender(multilineMessage);

				MapMeta meta = (MapMeta) giftcardsStack.getItemMeta();

				MapView mapView = Bukkit.getServer().createMap(Bukkit.getWorld("world"));
				mapView.getRenderers().clear();
				mapView.addRenderer(myMapRender);
				meta.setMapView(mapView);

				giftcardsStack.setItemMeta(meta);

				player.getInventory().addItem(giftcardsStack);
			}
			return false;
		});
		System.out.println("giftcard enabled");
	}
}