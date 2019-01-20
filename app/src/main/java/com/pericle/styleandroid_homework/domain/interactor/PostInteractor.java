package com.pericle.styleandroid_homework.domain.interactor;

import com.pericle.styleandroid_homework.data.repository.PostRepository;
import com.pericle.styleandroid_homework.domain.entity.PostModel;
import com.pericle.styleandroid_homework.presentation.callback.INewPostCallback;
import com.pericle.styleandroid_homework.presentation.callback.IShowPostCallback;

public class PostInteractor {

    private PostRepository postRepository;

    public PostInteractor() {
        postRepository = new PostRepository();
    }

    public void showPosts(IShowPostCallback iShowPostCallback) {
        postRepository.showPosts(iShowPostCallback);
    }

    public void addPost(String title, String body, INewPostCallback iNewPostCallback) {
        PostModel post = stringToPost(title, body);
        postRepository.addPost(post, iNewPostCallback);
    }

    private PostModel stringToPost(String title, String body) {
        PostModel post = new PostModel();
        post.setTitle(title);
        post.setBody(body);
        return post;
    }
}
