package com.gregorhue.theblog.helper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.gregorhue.theblog.dto.PostDto;

/**
 * Created by gregorhue on 14.11.2020.
 */

public class SortAndFilterHelper {

	public static List<PostDto> sortAndFilter(List<PostDto> posts, String sortOrder, String filter) {

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
			if (!filter.equals("All")) {
				posts = posts.stream().filter(post -> filter.equals(post.getCategory().getName())).collect(Collectors.toList());
			}
		}
		return posts;
	}
	
}
