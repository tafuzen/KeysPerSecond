package me.roan.kps.panels;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

import me.roan.kps.ColorManager;
import me.roan.kps.Main;
import me.roan.kps.RenderingMode;
import me.roan.kps.SizeManager;
import me.roan.kps.layout.LayoutPosition;
import me.roan.kps.RenderingMode.RenderCache;

/**
 * Abstract base class for the 
 * panels that display the
 * average, maximum and current
 * keys per second
 * @author Roan
 */
public abstract class BasePanel extends JPanel implements LayoutPosition{
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 8816524158873355997L;
	/**
	 * Smallest size of graph images
	 */
	public static final int imageSize = 4;
	/**
	 * RenderCache for this panel
	 */
	private RenderCache cache = new RenderCache();

	/**
	 * Signals this panel that its size
	 * or properties changed and that thus
	 * the render cache should be invalidated
	 */
	public void sizeChanged(){
		cache.init(getRenderingMode());
		this.repaint();
	}

	/**
	 * Constructs a new BasePanel
	 */
	protected BasePanel(){
		this.setOpaque(!ColorManager.transparency);
	}

	@Override
	public void paintComponent(Graphics g1){
		Graphics2D g = (Graphics2D)g1;

		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC, Main.config.getBackgroundOpacity()));
		g.setColor(Main.config.getBackgroundColor());
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, Main.config.getForegroundOpacity()));
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

//		g.drawImage(ColorManager.graph_upper_left,   2, 2, 2 + SizeManager.graphImageSize, 2 + SizeManager.graphImageSize, 0, 0, 4, 4, this);
//		g.drawImage(ColorManager.graph_lower_left,   2, this.getHeight() - 2 - SizeManager.graphImageSize, 2 + SizeManager.graphImageSize, this.getHeight() - 2, 0, 0, 4, 4, this);
//		g.drawImage(ColorManager.graph_upper_right,  this.getWidth() - 2 - SizeManager.graphImageSize, 2, this.getWidth() - 2, 2 + SizeManager.graphImageSize, 0, 0, 4, 4, this);
//		g.drawImage(ColorManager.graph_lower_right,  this.getWidth() - 2 - SizeManager.graphImageSize, this.getHeight() - 2 - SizeManager.graphImageSize, this.getWidth() - 2, this.getHeight() - 2, 0, 0, 4, 4, this);
//		g.drawImage(ColorManager.graph_side_left,    2, 2 + SizeManager.graphImageSize, 2 + SizeManager.graphImageSize, this.getHeight() - 2 - SizeManager.graphImageSize, 0, 0, 4, 56, this);
//		g.drawImage(ColorManager.graph_upper_middle, 2 + SizeManager.graphImageSize, 2, this.getWidth() - 2 - SizeManager.graphImageSize, 2 + SizeManager.graphImageSize, 0, 0, 46, 4, this);
//		g.drawImage(ColorManager.graph_lower_middle, 2 + SizeManager.graphImageSize, this.getHeight() - 2 - SizeManager.graphImageSize, this.getWidth() - 2 - SizeManager.graphImageSize, this.getHeight() - 2, 0, 0, 46, 4, this);
//		g.drawImage(ColorManager.graph_side_right,   this.getWidth() - 2 - SizeManager.graphImageSize, 2 + SizeManager.graphImageSize, this.getWidth() - 2, this.getHeight() - 2 - SizeManager.graphImageSize, 0, 0, 4, 56, this);
		//TODO close or far version
//		g.drawImage(ColorManager.graph_upper_left,   0, 0, 0 + SizeManager.graphImageSize, 0 + SizeManager.graphImageSize, 0, 0, 4, 4, this);
//		g.drawImage(ColorManager.graph_lower_left,   0, this.getHeight() - 0 - SizeManager.graphImageSize, 0 + SizeManager.graphImageSize, this.getHeight() - 0, 0, 0, 4, 4, this);
//		g.drawImage(ColorManager.graph_upper_right,  this.getWidth() - 0 - SizeManager.graphImageSize, 0, this.getWidth() - 0, 0 + SizeManager.graphImageSize, 0, 0, 4, 4, this);
//		g.drawImage(ColorManager.graph_lower_right,  this.getWidth() - 0 - SizeManager.graphImageSize, this.getHeight() - 0 - SizeManager.graphImageSize, this.getWidth() - 0, this.getHeight() - 0, 0, 0, 4, 4, this);
//		g.drawImage(ColorManager.graph_side_left,    0, 0 + SizeManager.graphImageSize, 0 + SizeManager.graphImageSize, this.getHeight() - 0 - SizeManager.graphImageSize, 0, 0, 4, 56, this);
//		g.drawImage(ColorManager.graph_upper_middle, 0 + SizeManager.graphImageSize, 0, this.getWidth() - 0 - SizeManager.graphImageSize, 0 + SizeManager.graphImageSize, 0, 0, 46, 4, this);
//		g.drawImage(ColorManager.graph_lower_middle, 0 + SizeManager.graphImageSize, this.getHeight() - 0 - SizeManager.graphImageSize, this.getWidth() - 0 - SizeManager.graphImageSize, this.getHeight() - 0, 0, 0, 46, 4, this);
//		g.drawImage(ColorManager.graph_side_right,   this.getWidth() - 0 - SizeManager.graphImageSize, 0 + SizeManager.graphImageSize, this.getWidth() - 0, this.getHeight() - 0 - SizeManager.graphImageSize, 0, 0, 4, 56, this);

		g.drawImage(ColorManager.graph_upper_left,   SizeManager.tmp, SizeManager.tmp, SizeManager.tmp + imageSize, SizeManager.tmp + imageSize, 0, 0, 4, 4, this);
		g.drawImage(ColorManager.graph_lower_left,   SizeManager.tmp, this.getHeight() - SizeManager.tmp - imageSize, SizeManager.tmp + imageSize, this.getHeight() - SizeManager.tmp, 0, 0, 4, 4, this);
		g.drawImage(ColorManager.graph_upper_right,  this.getWidth() - SizeManager.tmp - imageSize, SizeManager.tmp, this.getWidth() - SizeManager.tmp, SizeManager.tmp + imageSize, 0, 0, 4, 4, this);
		g.drawImage(ColorManager.graph_lower_right,  this.getWidth() - SizeManager.tmp - imageSize, this.getHeight() - SizeManager.tmp - imageSize, this.getWidth() - SizeManager.tmp, this.getHeight() - SizeManager.tmp, 0, 0, 4, 4, this);
		g.drawImage(ColorManager.graph_side_left,    SizeManager.tmp, SizeManager.tmp + imageSize, SizeManager.tmp + imageSize, this.getHeight() - SizeManager.tmp - imageSize, 0, 0, 4, 56, this);
		g.drawImage(ColorManager.graph_upper_middle, SizeManager.tmp + imageSize, SizeManager.tmp, this.getWidth() - SizeManager.tmp - imageSize, SizeManager.tmp + imageSize, 0, 0, 46, 4, this);
		g.drawImage(ColorManager.graph_lower_middle, SizeManager.tmp + imageSize, this.getHeight() - SizeManager.tmp - imageSize, this.getWidth() - SizeManager.tmp - imageSize, this.getHeight() - SizeManager.tmp, 0, 0, 46, 4, this);
		g.drawImage(ColorManager.graph_side_right,   this.getWidth() - SizeManager.tmp - imageSize, SizeManager.tmp + imageSize, this.getWidth() - SizeManager.tmp, this.getHeight() - SizeManager.tmp - imageSize, 0, 0, 4, 56, this);
		
		
		if(isActive()){
			g.setColor(ColorManager.activeColor);
			g.fillRect(2 + (imageSize / 4) * 3, 
			           2 + (imageSize / 4) * 2, 
			           this.getWidth() - 5 - (imageSize / 4) * 5, 
			           this.getHeight() - 4 - (imageSize / 4) * 4);
			g.setColor(Main.config.getBackgroundColor());
		}else{
			g.setColor(Main.config.getForegroundColor());
		}

		cache.renderTitle(getTitle(), g, this);

		cache.renderValue(getValue(), g, this);
	}

	/**
	 * Gets whether or not this panel
	 * should be highlighted
	 * @return Whether the panel is "active" or not
	 */
	protected boolean isActive(){
		return false;
	}

	/**
	 * Gets the title for this panel
	 * @return The title for this panel
	 */
	protected abstract String getTitle();

	/**
	 * Gets the value for this panel
	 * @return The value for this panel
	 */
	protected abstract String getValue();

	/**
	 * Gets the rendering mode for this panel
	 * @return The rendering mode for this panel
	 */
	protected abstract RenderingMode getRenderingMode();
}
