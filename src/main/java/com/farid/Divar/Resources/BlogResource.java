package com.farid.Divar.Resources;

import com.farid.Divar.Library.Resources.BaseResource;
import com.farid.Divar.Models.Blog;
import lombok.Getter;

import java.util.List;

@Getter()
public class BlogResource extends BaseResource<Blog> {
    private Integer id;
    private String title;
    private Integer price;
    private List<TagResource> tags;

    @Override
    public void toResource(Blog blog) {
        id = blog.getId();
        title = blog.getTitle();
        price = blog.getPrice();
        tags = blog.getTags().stream().map(tag -> TagResource.from(tag, TagResource.class)).toList();
    }
}
