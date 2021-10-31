package fr.neverenough.giftcard.listeners;

import fr.neverenough.giftcard.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.map.MapView;

public class OnDrawMap implements Listener {
    @EventHandler
    public void onMapInitialize(MapInitializeEvent mapInitializeEvent) {
        MapView mapView = mapInitializeEvent.getMap();
        mapView.getRenderers().clear();
        mapView.addRenderer(Main.myMapRender);
    }
}
