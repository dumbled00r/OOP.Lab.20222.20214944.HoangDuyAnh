package hust.soict.dsai.aims.media;

import java.util.*;

public class MediaComparatorByTitleCost implements Comparator<Media> {

	@Override
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
		// Compare titles
		int titleComparing = o1.getTitle().compareTo(o2.getTitle());
		if (titleComparing != 0)
			return titleComparing;
		// then compare cost
		return Float.compare(o1.getCost(), o2.getCost());
	}
}
