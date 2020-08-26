import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;

/**
 * This example uses a local MBTiles file. Thus, it does not need an Internet connection to load tiles.
 */
public class OfflineMapApp extends PApplet {

	public static String mbTilesString = "blankLight-1-3.mbtiles";

	UnfoldingMap map1;
	UnfoldingMap map2;
	UnfoldingMap map3;
	UnfoldingMap map4;
	UnfoldingMap currentMap;
	int color = color(255,255,0);

	public void setup() {
		size(800, 600);

		map3 = new UnfoldingMap(this, new Microsoft.RoadProvider());
		map2 = new UnfoldingMap(this);
		map4 = new UnfoldingMap(this, new MBTilesMapProvider("blankDark-1-3.mbtiles"));
		
		map1 = new UnfoldingMap(this, new Microsoft.AerialProvider());
		MapUtils.createDefaultEventDispatcher(this, map1, map2, map3);
		currentMap = map1;
		//currentMap.setZoomRange(1, 3);
	}

	public void draw() {
		background(0);
		currentMap.draw();
		//map2.draw();
		Location location = currentMap.getLocation(mouseX, mouseY);
		fill(color);
		text(location.getLat() + ", " + location.getLon(), mouseX, mouseY);
	}
	public void keyPressed() {
	    if (key == '1') {
	        currentMap = map1;
	        color = color(255, 255, 0);
	    } else if (key == '2') {
	        currentMap = map2;
	        color = color(255, 0, 0);
	    } else if (key =='3') {
	    	currentMap = map3;
	    	color = color(255, 0, 0);
	    }
	    else if (key =='4') {
	    	currentMap = map4;
	    	color = color(255, 0, 0);
	    }
	}

}