package com.gregorhue.theblog.helper;

import java.util.Comparator;
import java.util.List;

import com.gregorhue.theblog.dto.PostDto;

/**
 * Created by gregorhue on 14.11.2020.
 */

public class SortAndFilterHelper {

	public static List<PostDto> sort(List<PostDto> posts, String sortOrder) {

		if (posts != null) {
			switch (sortOrder) {
			case "newest":
				posts.sort(Comparator.comparing(PostDto::getCreatedAt).reversed());
				break;
			case "best":
				posts.sort(Comparator.comparing(PostDto::getLikes).reversed());
				break;
			default:
			}			
		}
		return posts;
	}
}
