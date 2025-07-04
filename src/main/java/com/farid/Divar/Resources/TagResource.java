package com.farid.Divar.Resources;

import com.farid.Divar.Library.Resources.BaseResource;
import com.farid.Divar.Models.Tag;
import lombok.Getter;

@Getter()
public class TagResource extends BaseResource<Tag> {
    private Integer id;
    private String title;

    @Override
    public void toResource(Tag tag) {
        id = tag.getId();
        title = tag.getTitle();
    }
}
