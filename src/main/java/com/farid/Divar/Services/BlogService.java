package com.farid.Divar.Services;

import com.farid.Divar.Library.Services.BaseService;
import com.farid.Divar.Models.Blog;
import com.farid.Divar.Repositories.BlogRepository;
import com.farid.Divar.Requests.BlogRequest;
import org.springframework.stereotype.Service;

@Service
public class BlogService extends BaseService<Blog, BlogRequest> {

    public BlogService(BlogRepository blogRepository) {
        super(blogRepository, Blog.class);
    }
}
