package com.farid.Divar.Resources;

import com.farid.Divar.Library.Resources.BaseResource;
import com.farid.Divar.Models.Blog;
import lombok.Getter;

@Getter()
public class BlogResource extends BaseResource<Blog> {
    private Integer id;
    private String title;
    private Integer price;

    @Override
    public void toResource(Blog entity) {
        id = entity.getId();
        title = entity.getTitle();
        price = entity.getPrice();
    }
}
