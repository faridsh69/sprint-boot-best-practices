package com.farid.Divar.Requests;

import com.farid.Divar.Library.Requests.BaseRequest;
import com.farid.Divar.Models.Blog;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogRequest extends BaseRequest<Blog> {

    @NotBlank(message = "title is required")
    @Size(min = 2, message = "title must be at least 2 characters")
    private String title;

    @NotNull(message = "userId is required")
    private Integer userId;
}
