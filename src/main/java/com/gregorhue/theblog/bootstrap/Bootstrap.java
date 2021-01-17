package com.gregorhue.theblog.bootstrap;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import com.gregorhue.theblog.model.Post;
import com.gregorhue.theblog.repository.PostRepository;

/**
 * Created by gregorhue on 30.12.2020.
 */
@Singleton
@Startup
public class Bootstrap {
	
	@Inject
	private PostRepository postRepository;

	@PostConstruct
	public void initImages() {
		
		byte[] data = null;
		try {
			data = Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("static/images/hobby1.jpg").toURI()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Post post = postRepository.findOne(1L);
		post.setImage(data);
		postRepository.updateEntry(post);
		
		
	    data = null;
		try {
			data = Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("static/images/pastries1.jpg").toURI()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		post = postRepository.findOne(2L);
		post.setImage(data);
		postRepository.updateEntry(post);
		
		data = null;
		try {
			data = Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("static/images/holiday1.jpg").toURI()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		post = postRepository.findOne(3L);
		post.setImage(data);
		postRepository.updateEntry(post);
		
		
		data = null;
		try {
			data = Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("static/images/flowers1.jpg").toURI()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		post = postRepository.findOne(4L);
		post.setImage(data);
		postRepository.updateEntry(post);
		
		
		data = null;
		try {
			data = Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("static/images/hobby2.jpg").toURI()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		post = postRepository.findOne(5L);
		post.setImage(data);
		postRepository.updateEntry(post);
		
		
		data = null;
		try {
			data = Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("static/images/flowers2.jpg").toURI()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		post = postRepository.findOne(6L);
		post.setImage(data);
		postRepository.updateEntry(post);
		
	}

}
