package fr.neverenough.giftcard.map;

import org.bukkit.entity.Player;
import org.bukkit.map.*;

// TODO: Auto-generated Javadoc
/**
 * The Class MapRender.
 */
public class MapRender extends MapRenderer {
	private final String message;

	public MapRender(String message) {
		this.message = message;
	}

	/**
	 * Render.
	 *
	 * @param mapView   the view
	 * @param mapCanvas the canvas
	 * @param player the player
	 */
	@Override
	public void render(MapView mapView, MapCanvas mapCanvas, Player player) {
		for (int i = 0; i < 127; i++) {
			for (int i1 = 0; i1 < 127; i1++) {
				mapCanvas.setPixel(i, i1, MapPalette.matchColor(255, 252, 245));
			}
		}
		mapView.setCenterX((int) (player.getLocation().getX() + 1000000000));
		mapView.setCenterZ((int) (player.getLocation().getZ() + 1000000000));

		mapCanvas.drawText(1, 0, MinecraftFont.Font, message);
	}
}