package com.farid.Divar.Controllers;

import com.farid.Divar.Library.Controllers.BaseController;
import com.farid.Divar.Models.Blog;
import com.farid.Divar.Requests.BlogRequest;
import com.farid.Divar.Resources.BlogResource;
import com.farid.Divar.Services.BlogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/blogs")
public class BlogController extends BaseController<Blog, BlogRequest, BlogResource, BlogService> {

    public BlogController(BlogService service) {
        super(service);
    }

    @Override
    protected BlogService getService() {
        return this.service;
    }

    @Override
    protected BlogResource convertToResource(Blog entity) {
        return BlogResource.from(entity, BlogResource.class);
    }
}
