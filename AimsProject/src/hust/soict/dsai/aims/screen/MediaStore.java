package hust.soict.dsai.aims.screen;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart.*;

public class MediaStore extends JPanel{
	private Media media;
	private Cart cart;
	
	public MediaStore(Media media, Cart cart) {
		this.media = media;
		this.cart = cart;
		// Setup layout
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Setup labels
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);

		// Setup container
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));

		// Setup buttons
		JButton addToCart = new JButton("Add to cart");
		JButton play = new JButton("Play");
		container.add(addToCart);
		if (media instanceof Playable) {
			container.add(play);
		}

		// Handle buttons' events
		addToCart.addActionListener(e -> {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(addToCart, "Added to the cart");
			try {
				cart.addMedia(media);
			} catch (LimitExceededException ex) {
				throw new RuntimeException(ex);
			}
			cart.print();
		});
		play.addActionListener(e -> {
			// TODO Auto-generated method stub
			if (media instanceof Playable) {
				Disc mediacv = (Disc) media;
					try {
						mediacv.tryToPlay();
						JOptionPane.showMessageDialog(play, "Playing this track");
					} catch (PlayerException ex) {
						JOptionPane.showMessageDialog(play, ex);
					}
			}
		});

		// Adding to the main Panel
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}